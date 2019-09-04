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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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

@WebServlet("/postForm")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class PostFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(PostFormController.class);
    private IPostService postservice;
    private IPostFileService fileservice;
    
    @Override
    public void init() throws ServletException {
    	postservice = new PostServiceImpl();
    	fileservice = new PostFileServiceImpl();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("boardNo", request.getParameter("boardNo"));
		request.setAttribute("parentPostNo", request.getParameter("parentPostNo"));
		request.getRequestDispatcher("post/postForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String postTitle = request.getParameter("postTitle");
		String postContent = request.getParameter("postContent");
		
		String parentPostNo = request.getParameter("parentPostNo");
		
		HttpSession session = request.getSession();
		
		Collection<Part> parts = request.getParts();
		
		String fileName = "";
		String path = "";
		String realFileName = "";
		
		PostVO postVo = new PostVO();
		
		// 로그인한 유저Id 가져오기
		User user = (User) session.getAttribute("S_USERVO");
		String userId = user.getUserId();
		
		// null이 아닐때 답글
//		if(parentPostNo != null) {
//			Integer postNo = Integer.parseInt(request.getParameter("postNo"));
//			postVo.setParentPostNo(postNo);
//		}
		
		if(parentPostNo == null || parentPostNo.equals("")) {
			
		}else {
			// 답글
			Integer postNo = Integer.parseInt(request.getParameter("parentPostNo"));
			postVo.setParentPostNo(postNo);
		}
		// 수정하기
		
		// null일때 글쓰기(새로)
		
		postVo.setBoardNo(boardNo);
		postVo.setPostContent(postContent);
		postVo.setPostTitle(postTitle);
		postVo.setUserId(userId);
		
		int insertCnt = postservice.insertPost(postVo);
		
//		Integer postNo = Integer.parseInt(parentPostNo);
		
		int insertCnt1 = 0;
		int postsize = postservice.getPostTotalCnt1();
		
		// 사용자가 파일을 업로드 한 경우만 -> 한번더 확인
		for (Part part : parts) {
			if(part.getName().equals("picture")) {
				if(part.getSize() > 0) {
					
					fileName = FileuploadUtil.getFilename(part.getHeader("Content-Disposition"));	// 사용자가 업로드한 파일명
					realFileName = UUID.randomUUID().toString(); 	// 파일명
					String ext = FileuploadUtil.getFileExtension(part.getHeader("Content-Disposition"));  // 확장자
					path = FileuploadUtil.getPath() + realFileName + ext;
					part.write(path);
					
					
					PostFileVO fileVo = new PostFileVO();
					fileVo.setPostNo(postsize);
					fileVo.setFileName(fileName);
					fileVo.setRealFileName(path);
					
					if(fileName != null) {
						insertCnt1 = postservice.insertFile(fileVo);
					}
				}
			}
		}
		
		logger.debug("boardNo, postContent, postTitle, userId :  {},{},{},{}", boardNo, postContent, postTitle, userId);
		logger.debug("fileName, path : {},{}", fileName, path);
		
		if(insertCnt == 1 || insertCnt1 == 1 ) {
			response.sendRedirect(request.getContextPath() + "/post?postNo=" + postsize);
		}
	}
}

