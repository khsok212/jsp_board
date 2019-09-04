package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.repository.BoardDaoImpl;
import kr.or.ddit.board.repository.IBoardDao;
import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.post.repository.IPostDao;
import kr.or.ddit.post.repository.PostDaoImpl;
import kr.or.ddit.postfile.model.PostFileVO;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class PostServiceImpl implements IPostService {
	
	private IPostDao postDao;
	private IBoardDao boardDao;
	
	public PostServiceImpl() {
		postDao = new PostDaoImpl();
		boardDao = new BoardDaoImpl();
	}
	
	// 게시물 페이징 리스트 가져오기
	@Override
	public Map<String, Object> getPostPagingList(Page page, int boardNo) {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<PostVO> postList = postDao.getPostPagingList(sqlSession, page);
		int totalCnt = postDao.getPostTotalCnt(sqlSession, boardNo);
		
		System.out.println("============================");
		System.out.println("totalcnt : " + totalCnt);
		map.put("postList", postList);
		map.put("paginationSize", (int)Math.ceil((double)totalCnt / page.getPagesize()));
		
		sqlSession.close();
		return map;
	}
	
	@Override
	public String getPostingUser(int postNo) {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		
		String postingUserId = postDao.getPostingUser(sqlSession, postNo);
		sqlSession.close();
		
		return postingUserId;
	}

	@Override
	public List<PostVO> getPostList(int boardNo) {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<PostVO> postList = postDao.getPostList(sqlSession, boardNo);
		sqlSession.close();
		
		return postList;
	}

	@Override
	public PostVO getPost(int postNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		PostVO vo = postDao.getPost(sqlSession, postNo);
		sqlSession.close();
		
		return vo;
	}

	@Override
	public int insertPost(PostVO postVo) {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = postDao.insertPost(sqlSession, postVo);
		sqlSession.commit();
		sqlSession.close();
		
		return cnt;
	}
	
	@Override
	public int getPostTotalCnt1() {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = postDao.getPostTotalCnt1(sqlSession);
		return cnt;
	}
	
	@Override
	public int getPostTotalCnt(int boardNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = postDao.getPostTotalCnt(sqlSession, boardNo);
		return cnt;
	}

	@Override
	public int insertFile(PostFileVO fileVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = postDao.insertFile(sqlSession, fileVo);
		sqlSession.commit();
		sqlSession.close();
		
		return cnt;
	}

	@Override
	public int deleteFile(int fileNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = postDao.deleteFile(sqlSession, fileNo);
		sqlSession.commit();
		sqlSession.close();
		
		return cnt;
	}

	@Override
	public int deletePost(int postNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = postDao.deletePost(sqlSession, postNo);
		sqlSession.commit();
		sqlSession.close();
		
		return cnt;
	}

	@Override
	public int updatePost(PostVO postVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = postDao.updatePost(sqlSession, postVo);
		sqlSession.commit();
		sqlSession.close();
		
		return cnt;
	}
	
	
	
	
}
