package kr.or.ddit.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.CookieUtil;

public class CookieUtilTest {

	/**
	 * 
	* Method : getCookieTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 쿠키 가져오기 테스트
	 */
	@Test
	public void getCookieTest() {
		/***Given***/
							// 쿠키이름 = 쿠키값구분자
							// 구분자 : [;]
		String cookieString = "userId=brown; rememberMe=Y; test=testValue";
		
		/***When***/
		String cookieValue = CookieUtil.getCookie(cookieString, "userId");
		String rememberValue = CookieUtil.getCookie(cookieString, "rememberMe");
		String testValue = CookieUtil.getCookie(cookieString, "test");
		
		System.out.println(cookieValue);
		System.out.println(rememberValue);
		System.out.println(testValue);
		
		
		/***Then***/
		assertEquals("brown", cookieValue);
		assertEquals("Y", rememberValue);
		assertEquals("testValue", testValue);
	}
	

}
