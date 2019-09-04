package kr.or.ddit.post.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.postfile.model.PostFileVO;

public interface IPostService {
	
	public String getPostingUser(int postNo);
	
	/**
	 * 
	* Method : getUserPagingList
	* 작성자 : 202-01
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 게시물 페이징 리스트 조회
	 */
	public Map<String, Object> getPostPagingList(Page page, int boardNo);
	
	/**
	 * 
	* Method : getPostList
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param boardNo
	* @return
	* Method 설명 : 게시판 번호와 일치하는 게시물 조회
	 */
	public List<PostVO> getPostList(int boardNo);
	
	/**
	 * 
	* Method : getPost
	* 작성자 : 202-01
	* 변경이력 :
	* @param boardNo
	* @return
	* Method 설명 : 게시글 보기
	 */
	public PostVO getPost(int postNo);
	
	/**
	 * 
	* Method : insertPost
	* 작성자 : 202-01
	* 변경이력 :
	* @param post
	* @return
	* Method 설명 : 게시글 추가하기
	 */
	public int insertPost(PostVO postVo);
	
	/**
	 * 
	* Method : getPostTotalCnt
	* 작성자 : 202-01
	* 변경이력 :
	* @return
	* Method 설명 : 전체 조회
	 */
	public int getPostTotalCnt(int boardNo);
	
	public int getPostTotalCnt1();
	
	/**
	 * 
	* Method : insertFile
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param fileVo
	* @return
	* Method 설명 : 파일 추가하기
	 */
	public int insertFile(PostFileVO fileVo);
	
	/**
	 * 
	* Method : deleteFile
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param fileVo
	* @return
	* Method 설명 : 파일 삭제
	 */
	public int deleteFile(int fileNo);  
	
	/**
	 * 
	* Method : deletePost
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param postVo
	* @return
	* Method 설명 : 게시물 삭제(제목만)
	 */
	public int deletePost(int postNo);
	
	/**
	 * 
	* Method : updatePost
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param postVo
	* @return
	* Method 설명 : 게시물 수정
	 */
	public int updatePost(PostVO postVo);
	
	
}
