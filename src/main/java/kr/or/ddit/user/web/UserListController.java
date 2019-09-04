package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.MybatisUtil;

@WebServlet("/userList")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 	doGet
		 	- userDao 사용자 리스트 조회
		 	- request 객체에 사용자 리스트 정보를 저장
		 	- userList.jsp를 통해서 화면응답을 생성하도록 위임
		 */
		
		// 여기서 Dao List 받고 request로 serAttribute
		UserService userService = new UserService();
		
		List<User> userList = userService.getUserList();
		
		// ★ 중요  "userList" 아이디로 넘긴다.
		request.setAttribute("userList", userList);
		
		// 위임한다.
		request.getRequestDispatcher("/user/userList.jsp").forward(request, response);
	}
}
