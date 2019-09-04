package kr.or.ddit.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import kr.or.ddit.board.model.Board1VO;

public class BoardDaoImpl implements IBoardDao {
	
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
	@Override
	public int insertBoard1(SqlSession sqlSession, Board1VO board1) {
		return sqlSession.insert("board.insertBoard1", board1);
	}
	
	/**
	 * 
	* Method : getBoardList
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 전체 게시판 조회
	 */
	@Override
	public List<Board1VO> getBoardList(SqlSession sqlSession) {
		return sqlSession.selectList("board.getBoardList");
	}
	
	/**
	 * 
	* Method : updateBoard1
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param board1
	* @return
	* Method 설명 : 게시판 수정하기 (제목, 사용/미사용)
	 */
	@Override
	public int updateBoard1(SqlSession sqlSession, Board1VO board1) {
		return sqlSession.update("board.updateBoard1", board1);
	}
	
	/**
	 * 
	* Method : deleteBoard
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param boardNo
	* @return
	* Method 설명 : 게시판 삭제
	 */
	@Override
	public int deleteBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.delete("board.deleteBoard", boardNo);
	}
	
	/**
	 * 
	* Method : getBoard
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param boardNo
	* @return
	* Method 설명 : 게시판 이름 가져오기
	 */
	@Override
	public Board1VO getBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("board.getBoard", boardNo);
	}
	
}
