package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileuploadUtilTest {

	
	/**
	 * 
	* Method : getFilenameTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : Content-disposition 헤더 문자열로부터 파일이름 추출 테스트
	 */
	@Test
	public void getFilenameTest() {
		/***Given***/
		String contentDisposition = "form-data; name = \"file\"; filename = \"brown.png\"";

		/***When***/
		String filename = FileuploadUtil.getFilename(contentDisposition);
		/***Then***/
		assertEquals("brown.png", filename);
	}
	
	/**
	 * 
	* Method : getFileExtentionTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : Content-disposition 헤더 문자열로부터 파일확장자 추출 테스트
	 */
	@Test
	public void getFileExtensionTest() {
		/***Given***/
		String contentDisposition = "form-data; name = \"file\"; filename = \"brown.png\"";
		String contentDisposition2 = "form-data; name = \"file\"; filename = \"brown\"";
		String contentDisposition3 = "form-data; name = \"file\"; filename = \"moon.png\"";
		String contentDisposition4 = "form-data; name = \"file\"; filename = \"moon.xx.jpg\"";

		/***When***/
		String fileExtensionName = FileuploadUtil.getFileExtension(contentDisposition);
		String fileExtensionName2 = FileuploadUtil.getFileExtension(contentDisposition2);
		String fileExtensionName3 = FileuploadUtil.getFileExtension(contentDisposition3);
		String fileExtensionName4 = FileuploadUtil.getFileExtension(contentDisposition4);
		
		/***Then***/
		assertEquals(".png", fileExtensionName);
		assertEquals("", fileExtensionName2);
		assertEquals(".png", fileExtensionName3);
		assertEquals(".jpg", fileExtensionName4);
	}
	
	@Test
	public void getPathTest() {
		/***Given***/
		

		/***When***/
		String path = FileuploadUtil.getPath();
		
		/***Then***/
		assertEquals("d:\\upload\\2019\\08\\", path);
	}
	
	
	
}
