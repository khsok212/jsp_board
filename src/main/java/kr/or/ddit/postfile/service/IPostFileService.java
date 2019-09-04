package kr.or.ddit.postfile.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.postfile.model.PostFileVO;

public interface IPostFileService {
	
	/**
	 * 
	* Method : getPostFile
	* 작성자 : 202-01
	* 변경이력 :
	* @param fileNo
	* @return
	* Method 설명 : 게시물 첨부파일 리스트 조회
	 */
	public List<PostFileVO> getPostFile(int postNo);
	
	/**
	 * 
	* Method : getFile
	* 작성자 : 202-01
	* 변경이력 :
	* @param fileNo
	* @return
	* Method 설명 : 단일 파일 조회
	 */
	public PostFileVO getFile(int fileNo);
	
	/**
	 * 
	* Method : deleteFile
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param fileNo
	* @return
	* Method 설명 : 첨부파일 삭제
	 */
	public int deleteFile(int fileNo);
}
