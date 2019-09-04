package kr.or.ddit.reply.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.postfile.model.PostFileVO;
import kr.or.ddit.reply.model.P_ReplyVO;
import kr.or.ddit.user.model.User;

public interface IReplyDao {
	

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
	public P_ReplyVO getReply(SqlSession sqlSession, int replyNo);
	
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
	public List<P_ReplyVO> getReplyList(SqlSession sqlSession, int postNo);
	
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
	public int insertReply(SqlSession sqlSession, P_ReplyVO replyVo);
	
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
	public int deleteReply(SqlSession sqlSession, int replyNo );
}
