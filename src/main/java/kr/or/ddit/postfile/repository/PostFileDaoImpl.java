package kr.or.ddit.postfile.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.postfile.model.PostFileVO;

public class PostFileDaoImpl implements IPostFileDao {
	/**
	 * 
	* Method : getPostFile
	* 작성자 : 202-01
	* 변경이력 :
	* @param fileNo
	* @return
	* Method 설명 : 게시물번호에 조회되는 첨부파일 리스트
	 */
	@Override
	public List<PostFileVO> getPostFile(SqlSession sqlSession, int postNo) {
		return sqlSession.selectList("file.getPostFile", postNo);
	}
	
	/**
	 * 
	* Method : getFile
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param fileNo
	* @return
	* Method 설명 : 단일 파일 조회
	 */
	@Override
	public PostFileVO getFile(SqlSession sqlSession, int fileNo) {
		return sqlSession.selectOne("file.getFile", fileNo);
	}
	
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
	@Override
	public int deleteFile(SqlSession sqlSession, int fileNo) {
		return sqlSession.delete("file.deleteFile", fileNo);
	}
	
	
}
