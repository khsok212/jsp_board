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

@WebServlet("/userListOnlyHalf")
public class UserListOnlyHalfController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserListOnlyHalfController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
		
		List<User> userList = userService.getUserListOnlyHalf();
		
		// ★ 중요  "userList" 아이디로 넘긴다.
		request.setAttribute("userList", userList);
		
		// 위임한다.
		request.getRequestDispatcher("/user/userListOnlyHalf.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
