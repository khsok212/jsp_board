package kr.or.ddit.reply.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.reply.model.P_ReplyVO;

public class ReplyServiceTest {

	private IReplyService service;

	@Before
	  public void setup() {
			service = new ReplyServiceImpl();
	}
	
	/** 성공
	 * 
	* Method : getReply
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 단일 댓글 조회
	 */
	@Test
	public void getReplyTest() {
		/***Given***/
		int replyNo = 34;

		/***When***/
		P_ReplyVO vo = service.getReply(replyNo);
		/***Then***/
		assertEquals(34, vo.getReplyNo());
		assertEquals("안녕하세요", vo.getReplyContent());
	}
	
	/** 성공
	 * 
	* Method : getReplyListTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 댓글 리스트 조회 테스트
	 */
	@Test
	public void getReplyListTest() {
		/***Given***/
		int postNo = 1;

		/***When***/
		List<P_ReplyVO> list = service.getReplyList(postNo);
		/***Then***/
		assertEquals(2, list.size());
	}
	
	/** 성공
	 * 
	* Method : insertReply
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 댓글 추가 테스트
	 */
	@Test
	public void insertReplyTest() {
		/***Given***/
		P_ReplyVO vo = new P_ReplyVO();
		vo.setPostNo(1);
		vo.setReplyContent("testcode답글");
		vo.setUserId("brown");
		
		/***When***/
		int cnt = service.insertReply(vo);
		//sqlSession.commit();
		/***Then***/
		assertEquals(1, cnt);
	}
	
	/** 성공
	 * 
	* Method : deleteReplyTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 댓글 삭제 테스트 (deleteYN)
	 */
	@Test
	public void deleteReplyTest() {
		/***Given***/
		int replyNo = 37;

		/***When***/
		int cnt = service.deleteReply(replyNo);
		/***Then***/
		assertEquals(1, cnt);
	}
}
