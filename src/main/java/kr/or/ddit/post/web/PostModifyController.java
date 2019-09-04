package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.postfile.model.PostFileVO;
import kr.or.ddit.postfile.service.IPostFileService;
import kr.or.ddit.postfile.service.PostFileServiceImpl;
import kr.or.ddit.util.FileuploadUtil;

@WebServlet("/postModify")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class PostModifyController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostModifyController.class);
	
	private IPostService postservice;
	private IPostFileService fileservice;
	
	@Override
	public void init() throws ServletException {
		postservice = new PostServiceImpl();
		fileservice = new PostFileServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		PostVO postVo = postservice.getPost(postNo);
		List<PostFileVO> fileList = fileservice.getPostFile(postNo);
		
		request.setAttribute("post", postVo);
		request.setAttribute("fileList", fileList);
		request.setAttribute("postNo", postNo);
		
		request.getRequestDispatcher("/post/postModify.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		String postTitle = request.getParameter("postTitle");
		String postContent = request.getParameter("postContent");
		
		Collection<Part> parts = request.getParts();
		String fileName = "";
		String path = "";
		String realFileName = "";
		
		PostVO postVo = new PostVO();
		
		postVo.setPostNo(postNo);
		postVo.setPostContent(postContent);
		postVo.setPostTitle(postTitle);
		
		int cnt = postservice.updatePost(postVo);
		
		int insertCnt1 = 0;
		
		List<PostFileVO> fileList = fileservice.getPostFile(postNo);
		System.out.println(fileList.size());
		// 사용자가 파일을 업로드 한 경우만 -> 한번더 확인
		for (Part part : parts) {
			if(part.getName().equals("picture")) {
				if(part.getSize() > 0) {
					if(fileList.size() < 5) {
						fileName = FileuploadUtil.getFilename(part.getHeader("Content-Disposition"));	// 사용자가 업로드한 파일명
						realFileName = UUID.randomUUID().toString(); 	// 파일명
						String ext = FileuploadUtil.getFileExtension(part.getHeader("Content-Disposition"));  // 확장자
						path = FileuploadUtil.getPath() + realFileName + ext;
						part.write(path);
						
						PostFileVO fileVo = new PostFileVO();
						fileVo.setPostNo(postNo);
						fileVo.setFileName(fileName);
						fileVo.setRealFileName(path);
						
						if(fileName != null) {
							insertCnt1 = postservice.insertFile(fileVo);
						}
					}
				}
			}
		}
		
		if(cnt == 1 || insertCnt1 == 1 ) {
			response.sendRedirect(request.getContextPath() + "/post?postNo=" + postNo);
		}
	}
}
