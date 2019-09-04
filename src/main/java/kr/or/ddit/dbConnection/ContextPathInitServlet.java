package kr.or.ddit.dbConnection;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ContextPathInitServlet", loadOnStartup = 1)
public class ContextPathInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		ServletContext application = config.getServletContext();
		
		String cp = application.getContextPath();
		
		application.setAttribute("cp", cp);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
