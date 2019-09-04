package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class UserDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	private IUserDao userDao;
	private SqlSession sqlSession;
	private String userId = "kTest";
	
	// 실행 > junit테스트
	
	/**
	* Method : getUserListTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : getUserList 테스트
	*/
	
	@Before
	   public void setup() {
	      logger.debug("before");
	      userDao = new UserDao();
	      sqlSession = MybatisUtil.getSession();
	      
	      userDao.deleteUser(sqlSession, userId);
	   }
	   
	   // 테스트에 공통적으로 사용한 자원을 해제
	   @After
	   public void tearDown() {
	      logger.debug("after");
	      sqlSession.close();
	   }
	
	@Test
	public void getUserListTest() {
		/***Given - 상황 ***/
		IUserDao userDao = new UserDao();

		/***When - 메서드 쿼리 ***/
		List<User> userList = userDao.getUserList(sqlSession);
		
		/***Then - 기술 ***/
		assertEquals(105, userList.size());
	}
	
	/**
	* Method : getUserTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 사용자 정보 조회 테스트
	*/
	
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";
		IUserDao userDao = new UserDao();

		/***When***/
		User userVo = userDao.getUser(sqlSession, userId);
		/***Then***/
		assertEquals("브라운", userVo.getUserNm());
		assertEquals("brown1234", userVo.getPass());
		
	}
	
	@Test
	public void getUserOnlyHalfTest() {
		/***Given - 상황 ***/
		IUserDao userDao = new UserDao();

		/***When - 메서드 쿼리 ***/
		List<User> userList = userDao.getUserListOnlyHalf(sqlSession);
		
		/***Then - 기술 ***/
		assertEquals(50, userList.size());
	}
	
	/**
	* 
	* Method : getUserPagingList
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void getUserPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(3);
		page.setPagesize(10);
		
		/***When***/
		List<User> userList = userDao.getUserPagingList(sqlSession, page);
		/***Then***/
		assertEquals(10, userList.size());
		assertEquals("xuerid22", userList.get(0).getUserId());
	}
	
	@Test
	public void getUserTotalCnt() {
		/***Given***/
		

		/***When***/
		int totalCnt = userDao.getUserTotalCnt(sqlSession);
		/***Then***/
		assertEquals(105, totalCnt);
	}
	
	
	@Test
	public void insertUserTest() throws ParseException {
		/***Given***/
		User user = new User();
		
		user.setUserId(userId);
		user.setUserNm("케이테스트");
		user.setPass("kTest1234");
		user.setReg_dt(new SimpleDateFormat("yyyy/MM/dd").parse("2019/08/08"));
		user.setAlias("곰테스트");
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");
		user.setFilename("11");
		user.setRealfilename("11");
		
		/***When***/
		int insertCnt = userDao.insertUser(sqlSession, user);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, insertCnt);
	
	}
	
	@Test
	public void updateUserTest() throws ParseException {
		/***Given***/
		User user = new User();
		
		user.setUserId(userId);
		user.setUserNm("케이테스트");
		user.setPass("kTest1234");
		user.setReg_dt(new SimpleDateFormat("yyyy/MM/dd").parse("2019/08/08"));
		user.setAlias("곰테스트");
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");
		user.setFilename("11");
		user.setRealfilename("11");
		
		/***When***/
		int UpdateCnt = userDao.updateUser(sqlSession, user);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, UpdateCnt);
	}
	
	
	
}
