package kr.or.ddit.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import kr.or.ddit.board.model.Board1VO;
import kr.or.ddit.board.repository.BoardDaoImpl;
import kr.or.ddit.board.repository.IBoardDao;
import kr.or.ddit.util.MybatisUtil;

public class BoardServiceImpl implements IBoardService {
	
	private IBoardDao boardDao;
	
	public BoardServiceImpl() {
		boardDao = new BoardDaoImpl();
	}
	
	// 게시판 추가하기 
	@Override
	public int insertBoard1(Board1VO board1) {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = boardDao.insertBoard1(sqlSession, board1);
		sqlSession.commit();
		sqlSession.close();
		
		return cnt;
	}

	// 게시판 전체 리스트 조회
	@Override
	public List<Board1VO> getBoardList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Board1VO> boardList = boardDao.getBoardList(sqlSession);
		sqlSession.close();
		
		return boardList;
	}

	@Override
	public int updateBoard1(Board1VO board1) {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = boardDao.updateBoard1(sqlSession, board1);
		
		sqlSession.commit();
		sqlSession.close();
		
		return cnt;
	}
	
	@Override
	public int deleteBoard (int boardNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = boardDao.deleteBoard(sqlSession, boardNo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return cnt;
	}

	@Override
	public Board1VO getBoard(int boardNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		Board1VO boardVo = boardDao.getBoard(sqlSession, boardNo);
		sqlSession.close();
		
		return boardVo;
	}
}
