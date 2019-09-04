package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.Board1VO;

public interface IBoardService {
	
	
	/**
	 * 
	* Method : insertBoard
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param board1
	* @return
	* Method 설명 : 게시판 추가하기
	 */
	public int insertBoard1(Board1VO board1);

	/**
	 * 
	* Method : getBoardList
	* 작성자 : 202-01
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체목록 가져오기
	 */
	public List<Board1VO> getBoardList();

	/**
	 * 
	* Method : updateBoard1
	* 작성자 : 202-01
	* 변경이력 :
	* @param board1
	* @return
	* Method 설명 : 게시판 수정
	 */
	public int updateBoard1(Board1VO board1);
	
	/**
	 * 
	* Method : deleteBoard
	* 작성자 : 202-01
	* 변경이력 :
	* @param boardNo
	* @return
	* Method 설명 : 게시판 삭제
	 */
	public int deleteBoard(int boardNo);
	
	public Board1VO getBoard(int boardNo);
	
}
