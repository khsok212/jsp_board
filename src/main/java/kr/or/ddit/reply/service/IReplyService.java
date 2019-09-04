package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.model.P_ReplyVO;

public interface IReplyService {
	
	/**
	 * 
	* Method : getPostFile
	* 작성자 : 202-01
	* 변경이력 :
	* @param fileNo
	* @return
	* Method 설명 : 게시물 첨부파일
	 */
	public P_ReplyVO getReply(int replyNo);
	
	/**
	 * 
	* Method : getReplyList
	* 작성자 : 202-01
	* 변경이력 :
	* @param postNo
	* @return
	* Method 설명 : 게시물 번호에 조회되는 댓글 리스트
	 */
	public List<P_ReplyVO> getReplyList(int postNo);
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
	public int insertReply(P_ReplyVO replyVo);
	
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
	public int deleteReply(int replyNo);
}
