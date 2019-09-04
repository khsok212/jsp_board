package kr.or.ddit.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileuploadUtil {

	/**
	 * 
	* Method : getFilenameTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : Content-disposition 헤더 문자열로부터 파일이름 추출
	 */
	public static String getFilename(String contentDisposition) {
		// 메소드 인자 : form-data; name = \"file\"; filename = \"brown.png\";
		String[] attrs = contentDisposition.split("; ");
		// attrs[0] form-data | attrs[1] name = \"file\" | attrs[2] filename = \"brown.png\"
		
		String filename = "";
			// keyValue[0] filename
			// keyValue[1] "brown.png"
		
		for(String attr : attrs) {
			if(attr.startsWith("filename")) {
				String[] keyValue = attr.split("=");
				
				filename = keyValue[1].substring(keyValue[1].indexOf("\"")+1, keyValue[1].lastIndexOf("\""));
				break;
			}
		}
		return filename;
	}

	public static String getFileExtension(String contentDisposition) {
		// 메소드 인자 : form-data; name = \"file\"; filename = \"brown.png\";
		String[] attrs = contentDisposition.split("; ");
		String filename = "";
		
		for(String attr : attrs) {
			if(attr.startsWith("filename")) {
				String[] keyValue = attr.split("=");
				// keyValue[0] filename
				// keyValue[1] "brown.png"
				
				if(!keyValue[1].contains(".")) {
					filename = "";
					break;
				}else {
					filename = keyValue[1].substring(keyValue[1].lastIndexOf("."), keyValue[1].lastIndexOf("\""));
					System.out.println(filename);
					break;
				}
			}
		}
		return filename;
	}

	/**
	 * 
	* Method : getPath
	* 작성자 : 202-01
	* 변경이력 :
	* @return
	* Method 설명 : 파일을 업로드 할 경로를 조회한다.
	 */
	public static String getPath() {
		String basicPath = "d:\\upload";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		
		String yyyyMM = sdf.format(new Date()); // 201908
		String yyyy = yyyyMM.substring(0,4);	// 2019
		String mm = yyyyMM.substring(4,6);		// 08
		
		File yyyyDirectory = new File(basicPath + "\\" + yyyy + "\\" + mm);
		
		if(!yyyyDirectory.exists()) {
			yyyyDirectory.mkdirs();
		}
		// d:\\upload\\2019\\08\\
		return basicPath + "\\" + yyyy + "\\" + mm + "\\";
	}
}
