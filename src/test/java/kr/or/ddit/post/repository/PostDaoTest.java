package kr.or.ddit.post.repository;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.postfile.model.PostFileVO;
import kr.or.ddit.util.MybatisUtil;

public class PostDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(PostDaoTest.class);
	private IPostDao postdao;
	private SqlSession sqlSession;
	
	@Before
	   public void setup() {
	      logger.debug("before");
	      postdao = new PostDaoImpl();
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
   	* Method : getPostTotalCntTest
  	* 작성자 : 202-01
  	* 변경이력 :
  	* Method 설명 : boardNo에 따른 게시물 전체 수 가져오기 테스트
   	*/
	@Test
	public void getPostTotalCntTest() {
		/***Given***/
		int boardNo = 1;

		/***When***/
		int cnt = postdao.getPostTotalCnt(sqlSession, boardNo);
		/***Then***/
		assertEquals(11, cnt);
	}
	
	/** 성공
	 * 
	* Method : getPostTotalCntTest1
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시물 전체 수 가져오기 테스트
	 */
	@Test
	public void getPostTotalCntTest1() {
		/***Given***/
		

		/***When***/
		int cnt = postdao.getPostTotalCnt1(sqlSession);
		/***Then***/
		assertEquals(12, cnt);
	}
	
	/** 성공
	 * 
	* Method : getPostPagingListTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시물 페이징 리스트 조회 테스트
	 */
	@Test
	public void getPostPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setBoardNo(1);
		page.setPage(1);
		page.setPagesize(10);

		/***When***/
		List<PostVO> list = postdao.getPostPagingList(sqlSession, page);
		
		/***Then***/
		assertEquals(10, list.size());
		assertEquals(1, list.get(0).getBoardNo());
	}
	
	
	/** 성공
	 * 
	* Method : getPostTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시글 보기 테스트
	 */
	@Test
	public void getPostTest() {
		/***Given***/
		int postNo = 1;
		IPostDao dao = new PostDaoImpl();

		/***When***/
		PostVO vo = postdao.getPost(sqlSession, postNo);
		
		/***Then***/
		assertEquals(1, vo.getBoardNo());
		assertEquals("sally", vo.getUserId());
	}
	
	/** 성공
	 * 
	* Method : insertPostTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시물 추가 테스트
	 * @throws ParseException 
	 */
	@Test
	public void insertPostTest() throws ParseException {
		/***Given***/
		PostVO vo = new PostVO();
		vo.setBoardNo(2);
		vo.setPostTitle("testcode");
		vo.setPostContent("testcont");
		vo.setUserId("brown");
		vo.setParentPostNo(1);

		/***When***/
		int cnt = postdao.insertPost(sqlSession, vo);
//		sqlSession.commit();
		/***Then***/
		assertEquals(1, cnt);
	}
	
	/** 삭제 성공
	 * 
	* Method : deleteFileTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 파일 삭제 테스트
	 */
	@Test
	public void deleteFileTest() {
		/***Given***/
		int fileNo = 71;

		/***When***/
		int cnt = postdao.deleteFile(sqlSession, fileNo);
//		sqlSession.commit();
		/***Then***/
		assertEquals(1, cnt);
	}
	/** 성공
	 * 
	* Method : insertFileTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 파일 추가 테스트
	 */
	@Test 
	public void insertFileTest() {
		/***Given***/
		PostFileVO vo = new PostFileVO();

		vo.setFileName("brown.png");
		vo.setRealFileName("D:\\upload\\2019\\08\\brown.png");
		vo.setPostNo(1);
		/***When***/
		int cnt = postdao.insertFile(sqlSession, vo);
//		sqlSession.commit();
		/***Then***/
		assertEquals(1, cnt);
	}
	
	/** 성공
	 * 
	* Method : updatePostTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시물 수정 테스트
	 */
	@Test
	public void updatePostTest() {
		/***Given***/
		int postNo = 12;
		PostVO vo = postdao.getPost(sqlSession, postNo);
		
		vo.setPostTitle("testCode");
		vo.setPostContent("testCode");
		
		/***When***/
		int cnt = postdao.updatePost(sqlSession, vo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	/** 성공
	 * 
	* Method : deletePostTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시물 삭제 테스트
	 */
	@Test
	public void deletePostTest() {
		/***Given***/
		int postNo = 12;
		
		/***When***/
		int cnt = postdao.deletePost(sqlSession, postNo);
//		sqlSession.commit();
		/***Then***/
		assertEquals(1, cnt);
	}
}
