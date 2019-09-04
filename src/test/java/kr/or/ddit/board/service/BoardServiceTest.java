package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.model.Board1VO;
import kr.or.ddit.board.repository.BoardDaoImpl;
import kr.or.ddit.board.repository.IBoardDao;


public class BoardServiceTest {
	
	private IBoardService boardService;
	private int boardNo = 3;
	
	@Before
	   public void setup() {
			boardService = new BoardServiceImpl();
			
			boardService.deleteBoard(boardNo);
	   }
	
	@Test
	public void insertBoard1Test() {
		/***Given***/
		Board1VO board1 = new Board1VO();
		
		board1.setBoardName("테스트게시판");
		board1.setUseYN(1); 
		
		/***When***/
		int cnt = boardService.insertBoard1(board1);
//		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, cnt);
		
		boardService.deleteBoard(boardNo);
	}
	
	// 성공
	@Test
	public void getBoardListTest() {
		/***Given***/
		

		/***When***/
		List<Board1VO> boardList = boardService.getBoardList();
		
		/***Then***/
		assertEquals(7, boardList.size());
	}

	// 성공
	@Test
	public void updateBoardTest() {
		/***Given***/
		Board1VO board1 = new Board1VO();
		
		board1.setBoardNo(28);
		board1.setBoardName("테스트게시판1");
		board1.setUseYN(2);

		/***When***/
		int cnt = boardService.updateBoard1(board1);
		
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
		Board1VO vo = boardService.getBoard(boardNo);
		
		/***Then***/
		assertEquals(1, vo.getBoardNo());
		assertEquals("자유게시판", vo.getBoardName());
	}
	
}
