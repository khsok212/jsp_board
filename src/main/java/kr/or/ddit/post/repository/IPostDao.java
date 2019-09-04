package kr.or.ddit.post.repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board1VO;
import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.postfile.model.PostFileVO;

public interface IPostDao {
	/**
	 * 
	* Method : getBoardList
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 게시판 리스트 조회(페이징 리스트)
	 */
//	public List<PostVO> getPostPagingList(SqlSession sqlSession, Map<String, Object> map);

	/**
	 * 
	* Method : getPostTotalCnt
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param boardNo
	* @return
	* Method 설명 : 게시판에 따른 게시물 건수 조회
	 */
	public int getPostTotalCnt(SqlSession sqlSession, int boardNo);
	
	/**
	 * 
	* Method : getPostTotalCnt1
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 전체 게시물 건수 조회
	 */
	public int getPostTotalCnt1(SqlSession sqlSession);
	
	/**
	 * 
	* Method : getPostingUser
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param postNo
	* @return
	* Method 설명 : 게시글번호와 일치하는 userId조회
	 */
	public String getPostingUser(SqlSession sqlSession, int postNo);
	
	
	/**
	 * 
	* Method : getPostList
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param boardNo
	* @return
	* Method 설명 : 게시판 번호와 일치하는 게시판 조회
	 */
	public List<PostVO> getPostList(SqlSession sqlSession, int boardNo);

	/**
	 * 
	* Method : getUserPagingList
	* 작성자 : 202-01
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 게시물 페이징 리스트 조회
	 */
	public List<PostVO> getPostPagingList(SqlSession sqlSession, Page page);
	
	/**
	 * 
	* Method : getPost
	* 작성자 : 202-01
	* 변경이력 :
	* @param boardNo
	* @return
	* Method 설명 : 게시글 보기
	 */
	PostVO getPost(SqlSession sqlSession, int postNo);
	/**
	 * 
	* Method : insertPost
	* 작성자 : 202-01
	* 변경이력 :
	* @param post
	* @return
	* Method 설명 : 게시글 추가하기
	 */
	public int insertPost(SqlSession sqlSession, PostVO postVo);
	
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
	public int insertFile(SqlSession sqlSession, PostFileVO fileVo);
	
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
	public int deleteFile(SqlSession sqlSession, int fileNo);  
	
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
	public int deletePost(SqlSession sqlSession, int postNo);
	
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
	public int updatePost(SqlSession sqlSession,  PostVO postVo);
	
	
}
