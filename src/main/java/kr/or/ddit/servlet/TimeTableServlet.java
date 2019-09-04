package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeTableServlet extends HttpServlet{
	
//	private Logger logger =  LoggerFactory.getLogger(TimeTableServlet.class);
	private static final Logger logger = LoggerFactory.getLogger(TimeTableServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getMethod();
		
//		System.out.println("TimeTableServlet doGet");
		logger.debug("TimeTableServlet doGet() {} {}", method, method+"test");
		logger.trace("TimeTableServlet doGet() {}", method+"test");
		logger.info("TimeTableServlet doGet()");
		logger.warn("TimeTableServlet doGet()");
		logger.error("TimeTableServlet doGet()");
		
		resp.setContentType("text/html; charset=UTF-8"); //위치
		PrintWriter pw = resp.getWriter();
		
		pw.write("<html>");
		pw.write("	<head>");
		pw.write("		<title>TimeTable</title>");
		pw.write("	</head>");
		pw.write("	<body>");
		pw.write("		<table border = 1 width = 670 height = 400 align = center padding = 5" );
		pw.write("		<tr>");
		
		for(int i = 2; i < 10; i++) {
			pw.write(" <th>" + i + "단" + "</th>");
		}
		pw.write("		</tr>");
		
		for(int j = 1; j < 10; j++) {
			pw.write("   <tr>");
				for(int i = 2; i < 10; i++) {
				pw.write("<td>" + i + " * " + j + "= " + (i * j) + "</td>");
			}
			pw.write("   </tr>");
		}
		
		pw.write("		</table>");
		pw.write("	</body>");
		pw.write("</html>");
	}
	
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
