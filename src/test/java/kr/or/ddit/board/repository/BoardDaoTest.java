package kr.or.ddit.board.repository;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.Board1VO;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.util.MybatisUtil;

public class BoardDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);
	private IBoardDao boardDao;
	private SqlSession sqlSession;
	
	
	@Before
	   public void setup() {
	      logger.debug("before");
	      boardDao = new BoardDaoImpl();
	      sqlSession = MybatisUtil.getSession();
	   }
	   
	   // 테스트에 공통적으로 사용한 자원을 해제
	   @After
	   public void tearDown() {
	      logger.debug("after");
	      sqlSession.close();
	   }
	
	/**
	 * 
	* Method : insertBoard1Test
	* 작성자 : 202-01
	* 변경이력 :
	* @throws ParseException
	* Method 설명 : 게시판 추가 test
	 */
	@Test
	public void insertBoard1Test() throws ParseException{
		/***Given***/
		Board1VO board1 = new Board1VO();
		
		board1.setBoardName("테스트게시판");
		board1.setUseYN(1); 
		
		/***When***/
		int cnt = boardDao.insertBoard1(sqlSession, board1);
//		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	/** 성공
	 * 
	* Method : getBoardListTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 전체 게시판 조회 테스트
	 */
	@Test
	public void getBoardListTest() {
		/***Given***/
		IBoardDao dao = new BoardDaoImpl();

		/***When***/
		List<Board1VO> boardList = dao.getBoardList(sqlSession);
		
		/***Then***/
		assertEquals(7, boardList.size());
	}
	
	/** 성공
	 * 
	* Method : updateBoardTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시판 수정 테스트
	 */
	@Test
	public void updateBoardTest() {
		/***Given***/
		Board1VO board1 = new Board1VO();
		
		board1.setBoardNo(2);
		board1.setBoardName("테스트게시판1");
		board1.setUseYN(2);

		/***When***/
		int cnt = boardDao.updateBoard1(sqlSession, board1);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	/** 성공
	 * 
	* Method : getBoard
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시판 가져오기
	 */
	@Test
	public void getBoard() {
		/***Given***/
		int boardNo = 1; 
		IBoardDao dao = new BoardDaoImpl();
		
		/***When***/
		Board1VO vo = boardDao.getBoard(sqlSession, boardNo);
		
		/***Then***/
		assertEquals(1, vo.getBoardNo());
		assertEquals("자유게시판", vo.getBoardName());
	}
	
	
	
	
}
