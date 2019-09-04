package kr.or.ddit.postfile.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.postfile.service.IPostFileService;
import kr.or.ddit.postfile.service.PostFileServiceImpl;

@WebServlet("/fileDelete")
public class FileDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(FileDeleteController.class);
	private IPostFileService fileservice;

	@Override
	public void init() throws ServletException {
		fileservice = new PostFileServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int fileNo = Integer.parseInt(request.getParameter("fileNo"));
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		int deleteCnt = fileservice.deleteFile(fileNo);
		
		logger.debug("fileNo, postNo :, {},{} ", fileNo, postNo );
		
		if(deleteCnt == 1) {
			System.out.println("삭제성공");
			response.sendRedirect(request.getContextPath() + "/postModify?postNo=" + postNo);
		}else {
			System.out.println("삭제실패");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	}

}
