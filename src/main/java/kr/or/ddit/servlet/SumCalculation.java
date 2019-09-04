package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SumCalculation")
public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/sumInput.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		int startNum = Integer.parseInt(start);
		int endNum = Integer.parseInt(end);
		
		int sumResult = 0;
		
		
		
		for(int i = startNum; i <= endNum; i++) {
			sumResult += i;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("start", start);
		session.setAttribute("end", end);
		session.setAttribute("sumResult", sumResult);
		
		request.getRequestDispatcher("/jsp/sumResult1.jsp").forward(request, response);
		
	}

}
