package util;

public class CookieUtil {
	
	/**
	 * 
	* Method : getCookie
	* 작성자 : 202-01
	* 변경이력 :
	* @param cookieString
	* @param cookieId
	* @return
	* Method 설명 : 쿠키 문자열로부터 특정 쿠키의 값을 변환한다.
	 */
	public static String getCookie(String cookieString, String cookieId) {
//		"userId=brown; rememberMe=Y; test=testValue"
		
		String[] cookies = cookieString.split("; ");
		for(int i = 0; i < cookies.length; i++) {
			String[] cookieVal = cookies[i].split("=");
			if(cookieId.equals(cookieVal[0])) {
				return cookieVal[1];
			}
		}
		return null;
	}
}
