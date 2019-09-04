package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.repository.IUserDao;

public class UserServiceTest {
	
   private IUserService userService;
   private String userId = "kTest";
   
   @Before
   public void setup() {
      userService = new UserService();
      
      userService.deleteUser(userId);
   }
   
   /**
    * 
   * Method : getUserListTest
   * 작성자 : PC-08
   * 변경이력 :
   * Method 설명 : getUserList 테스트
    */
   @Test
   public void getUserListTest() {
      /***Given***/
      
      /***When***/
      List<User> userList = userService.getUserList();
      
      /***Then***/
      assertEquals(105, userList.size());
   }
   
   /**
    * 
   * Method : getUserTest
   * 작성자 : PC-08
   * 변경이력 :
   * Method 설명 : 사용자 정보 조회 테스트
    */
   @Test
   public void getUserTest() {
      /***Given***/
      String userId = "brown";

      /***When***/
      User userVo = userService.getUser(userId);
      
      /***Then***/
      assertEquals("브라운", userVo.getUserNm());
      assertEquals("brown1234", userVo.getPass());
   }
   
   /**
    * 
   * Method : getUserListHalf
   * 작성자 : PC-08
   * 변경이력 :
   * Method 설명 : getUserListHalf 테스트
    */
   @Test
   public void getUserListOnlyHalfTest() {
      /***Given***/
      
      /***When***/
      List<User> userListHalf = userService.getUserListOnlyHalf();
      
      /***Then***/
      assertEquals(50, userListHalf.size());
   }
   
   /**
    * 
   * Method : getUserPagingListTest
   * 작성자 : PC-08
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
      Map<String, Object> resultMap = userService.getUserPagingList(page);
      List<User> userList = (List<User>) resultMap.get("userList");
      int paginationSize = (Integer)resultMap.get("paginationSize");
      
      /***Then***/
      assertEquals(10, userList.size());
      assertEquals("xuerid22", userList.get(0).getUserId());
      assertEquals(11, paginationSize);
   }
   
   @Test
   public void ceilingTest() {
	   /***Given***/
	   int totalCnt = 105;
	   int pagesize = 10;

	   /***When***/
	   double paginationSize = Math.ceil((double)totalCnt / pagesize);
	   
	   /***Then***/
	   assertEquals(11, (int)paginationSize);
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
		int insertCnt = userService.insertUser(user);
		
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
		
		int insertCnt = userService.insertUser(user);
		
		user.setUserNm("케이test");
		user.setZipcode("3411");
		/***When***/
		int cnt = userService.updateUser(user);
		
		/***Then***/
		assertEquals(1, insertCnt);
		assertEquals(1, cnt);
	
	}
   
}