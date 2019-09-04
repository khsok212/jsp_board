package kr.or.ddit.reply.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.repository.PostDaoTest;
import kr.or.ddit.reply.model.P_ReplyVO;
import kr.or.ddit.util.MybatisUtil;

public class ReplyDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(PostDaoTest.class);
	private IReplyDao dao;
	private SqlSession sqlSession;
	
	@Before
   public void setup() {
      logger.debug("before");
      dao = new ReplyDaoImpl();
      sqlSession = MybatisUtil.getSession();
   }
   
   // 테스트에 공통적으로 사용한 자원을 해제
   @After
   public void tearDown() {
      logger.debug("after");
      sqlSession.close();
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
		P_ReplyVO vo = dao.getReply(sqlSession, replyNo);
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
		List<P_ReplyVO> list = dao.getReplyList(sqlSession, postNo);
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
		int cnt = dao.insertReply(sqlSession, vo);
		//sqlSession.commit();
		/***Then***/
		assertEquals(1, cnt);
	}
	
	/** 성공
	 * 
	* Method : deleteReplyTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 댓글 삭제 테스트
	 */
	@Test
	public void deleteReplyTest() {
		/***Given***/
		int replyNo = 33;

		/***When***/
		int cnt = dao.deleteReply(sqlSession, replyNo);
		/***Then***/
		assertEquals(1, cnt);
	}

}
