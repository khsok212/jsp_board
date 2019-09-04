package kr.or.ddit.file.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.postfile.model.PostFileVO;
import kr.or.ddit.postfile.service.IPostFileService;
import kr.or.ddit.postfile.service.PostFileServiceImpl;

public class FileServiceTest {
	
	private IPostFileService service;

	@Before
	  public void setup() {
			service = new PostFileServiceImpl();
	}
	
	/** 성공
	 * 
	* Method : getPostFileTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시물 첨부파일 리스트 조회 테스트
	 */
	@Test
	public void getPostFileTest() {
		/***Given***/
		int postNo = 1;

		/***When***/
		List<PostFileVO> list = service.getPostFile(postNo);
		/***Then***/
		assertEquals(3, list.size());
	}
	
	/** 성공
	 * 
	* Method : getFileTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 단일 파일 조회 테스트
	 */
	@Test
	public void getFileTest() {
		/***Given***/
		int fileNo = 1;

		/***When***/
		PostFileVO vo = service.getFile(fileNo);
		/***Then***/
		assertEquals(1, vo.getPostNo());
		assertEquals("moon.png", vo.getFileName());
	}
	
	/** 성공
	 * 
	* Method : deleteFile
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 첨부파일 삭제 테스트
	 */
	@Test
	public void deleteFile() {
		/***Given***/
		int fileNo = 77;

		/***When***/
		int cnt = service.deleteFile(fileNo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
}
