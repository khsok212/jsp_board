package kr.or.ddit.post.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.postfile.model.PostFileVO;
import kr.or.ddit.postfile.service.IPostFileService;
import kr.or.ddit.postfile.service.PostFileServiceImpl;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.FileuploadUtil;

@WebServlet("/fileDownload")
public class FileDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);
	
    private IPostFileService fileservice;
    
    @Override
    public void init() throws ServletException {
    	fileservice = new PostFileServiceImpl();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int fileNo = Integer.parseInt(request.getParameter("fileNo"));
		PostFileVO pfv = fileservice.getFile(fileNo);
		
		ServletOutputStream sos = response.getOutputStream();
		
		File picture = new File(pfv.getRealFileName());
		FileInputStream fis = new FileInputStream(picture);
		
		byte[] buff = new byte[512];
		int len = 0;
		
		while((len = fis.read(buff, 0, 512)) != -1) {
			sos.write(buff, 0, len);
		}
		
		fis.close();
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	}

}
