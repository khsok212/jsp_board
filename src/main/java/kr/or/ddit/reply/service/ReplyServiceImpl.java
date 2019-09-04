package kr.or.ddit.reply.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.postfile.model.PostFileVO;
import kr.or.ddit.postfile.repository.IPostFileDao;
import kr.or.ddit.postfile.repository.PostFileDaoImpl;
import kr.or.ddit.reply.model.P_ReplyVO;
import kr.or.ddit.reply.repository.IReplyDao;
import kr.or.ddit.reply.repository.ReplyDaoImpl;
import kr.or.ddit.util.MybatisUtil;

public class ReplyServiceImpl implements IReplyService {

	private IReplyDao replyDao;
	
	public ReplyServiceImpl() {
		replyDao = new ReplyDaoImpl();
	}

	/**
	 * 
	* Method : getReply
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param replyNo
	* @return
	* Method 설명 : 단일 댓글 조회
	 */
	@Override
	public P_ReplyVO getReply(int replyNo) {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		P_ReplyVO replyVo = replyDao.getReply(sqlSession, replyNo);
		sqlSession.close();
		
		return replyVo;
	}
	/**
	 * 
	* Method : getReplyList
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param replyNo
	* @return
	* Method 설명 : 댓글 리스트 조회
	 */
	@Override
	public List<P_ReplyVO> getReplyList(int postNo) {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		List<P_ReplyVO> replyList = replyDao.getReplyList(sqlSession, postNo);
		sqlSession.close();
		return replyList;
	}
	/**
	 * 
	* Method : insertReply
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param replyVo
	* @return
	* Method 설명 : 댓글 추가하기
	 */
	@Override
	public int insertReply(P_ReplyVO replyVo) {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = replyDao.insertReply(sqlSession, replyVo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
		
	}
	/**
	 * 
	* Method : deleteReply
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param replyNo
	* @return
	* Method 설명 : 댓글 삭제하기
	 */
	@Override
	public int deleteReply(int replyNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = replyDao.deleteReply(sqlSession, replyNo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

}
