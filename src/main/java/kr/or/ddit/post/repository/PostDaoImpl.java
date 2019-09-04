package kr.or.ddit.post.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.postfile.model.PostFileVO;

public class PostDaoImpl implements IPostDao {

	@Override
	public List<PostVO> getPostPagingList(SqlSession sqlSession, Page page) {
		return sqlSession.selectList("post.getPostPagingList", page);
	}
	
	@Override
	public int getPostTotalCnt(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("post.getPostTotalCnt", boardNo);
	}
	
	@Override
	public int getPostTotalCnt1(SqlSession sqlSession) {
		return sqlSession.selectOne("post.getPostTotalCnt1");
	}

	@Override
	public String getPostingUser(SqlSession sqlSession, int postNo) {
		return sqlSession.selectOne("post.getPostingUser", postNo);
	}

	@Override
	public List<PostVO> getPostList(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectList("post.getPostList", boardNo);
	}

	@Override
	public PostVO getPost(SqlSession sqlSession, int postNo) {
		return sqlSession.selectOne("post.getPost", postNo);
	}

	@Override
	public int insertPost(SqlSession sqlSession, PostVO postVo) {
		return sqlSession.insert("post.insertPost", postVo);
	}

	@Override
	public int insertFile(SqlSession sqlSession, PostFileVO fileVo) {
		return sqlSession.insert("post.insertFile", fileVo);
	}

	@Override
	public int deleteFile(SqlSession sqlSession, int fileNo) {
		return sqlSession.delete("post.deleteFile", fileNo);
	}

	@Override
	public int deletePost(SqlSession sqlSession, int postNo) {
		return sqlSession.update("post.deletePost", postNo);
	}

	@Override
	public int updatePost(SqlSession sqlSession, PostVO postVo) {
		return sqlSession.update("post.updatePost", postVo);
	}
	
	
	
	
	
}
