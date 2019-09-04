package kr.or.ddit.file.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.repository.BoardDaoTest;
import kr.or.ddit.postfile.model.PostFileVO;
import kr.or.ddit.postfile.repository.IPostFileDao;
import kr.or.ddit.postfile.repository.PostFileDaoImpl;
import kr.or.ddit.util.MybatisUtil;

public class FileDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);
	private IPostFileDao dao;
	private SqlSession sqlSession;
	
	
	@Before
	   public void setup() {
	      logger.debug("before");
	      dao = new PostFileDaoImpl();
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
	* Method : getPostFileTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시물 첨부파일 리스트 조회 테스트
	 */
	@Test
	public void getPostFileTest() {
		/***Given***/
		int postNo = 1;

		/***When***/
		List<PostFileVO> list = dao.getPostFile(sqlSession, postNo);
		/***Then***/
		assertEquals(3, list.size());
	}
	
	/** 성공
	 * 
	* Method : getFileTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 단일 파일 조회 테스트
	 */
	@Test
	public void getFileTest() {
		/***Given***/
		int fileNo = 1;

		/***When***/
		PostFileVO vo = dao.getFile(sqlSession, fileNo);
		/***Then***/
		assertEquals(1, vo.getPostNo());
		assertEquals("moon.png", vo.getFileName());
	}
	
	/** 성공
	 * 
	* Method : deleteFile
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 첨부파일 삭제 테스트
	 */
	@Test
	public void deleteFile() {
		/***Given***/
		int fileNo = 77;

		/***When***/
		int cnt = dao.deleteFile(sqlSession, fileNo);
//		sqlSession.commit();
		/***Then***/
		assertEquals(1, cnt);
	}

}
