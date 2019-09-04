package kr.or.ddit.reply.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.postfile.model.PostFileVO;
import kr.or.ddit.reply.model.P_ReplyVO;

public class ReplyDaoImpl implements IReplyDao {
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
	public P_ReplyVO getReply(SqlSession sqlSession, int replyNo) {
		return sqlSession.selectOne("reply.getReply", replyNo);
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
	public List<P_ReplyVO> getReplyList(SqlSession sqlSession, int postNo) {
		return sqlSession.selectList("reply.getReplyList", postNo);
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
	public int insertReply(SqlSession sqlSession, P_ReplyVO replyVo) {
		return sqlSession.insert("reply.insertReply", replyVo);
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
	public int deleteReply(SqlSession sqlSession, int replyNo) {
		return sqlSession.update("reply.deleteReply", replyNo);
	}

}
