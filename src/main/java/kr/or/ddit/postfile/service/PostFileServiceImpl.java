package kr.or.ddit.postfile.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.postfile.model.PostFileVO;
import kr.or.ddit.postfile.repository.IPostFileDao;
import kr.or.ddit.postfile.repository.PostFileDaoImpl;
import kr.or.ddit.util.MybatisUtil;

public class PostFileServiceImpl implements IPostFileService {

	private IPostFileDao fileDao;
	
	public PostFileServiceImpl() {
		fileDao = new PostFileDaoImpl();
	}
		
	@Override
	public List<PostFileVO> getPostFile(int postNo) {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		List<PostFileVO> fileList = fileDao.getPostFile(sqlSession, postNo);
		sqlSession.close();
		
		return fileList;
	}

	@Override
	public PostFileVO getFile(int fileNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		PostFileVO fileVo = fileDao.getFile(sqlSession, fileNo);
		sqlSession.close();
		return fileVo;
	}

	@Override
	public int deleteFile(int fileNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = fileDao.deleteFile(sqlSession, fileNo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

}
