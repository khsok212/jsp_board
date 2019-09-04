package kr.or.ddit.post.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.logging.LogException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.postfile.model.PostFileVO;
import kr.or.ddit.postfile.service.IPostFileService;
import kr.or.ddit.postfile.service.PostFileServiceImpl;
import kr.or.ddit.reply.model.P_ReplyVO;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyServiceImpl;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.web.UserController;

@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private IPostService service;
	private IPostFileService fileservice;
	private IReplyService replyservice;
	
	@Override
	public void init() throws ServletException {
		service = new PostServiceImpl();
		fileservice = new PostFileServiceImpl();
		replyservice = new ReplyServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		logger.debug("postNo:{}" , postNo);
		
		PostVO postVo = service.getPost(postNo);
		List<PostFileVO> fileList = fileservice.getPostFile(postNo);
		List<P_ReplyVO> replyList = replyservice.getReplyList(postNo);
		
		request.setAttribute("post", postVo);
		request.setAttribute("fileList", fileList);
		request.setAttribute("replyList", replyList);
		
		request.getRequestDispatcher("/post/post.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		String replyContent = request.getParameter("replyContent1");

		HttpSession session = request.getSession();
		
		// 로그인한 유저Id 가져오기
		User user = (User) session.getAttribute("S_USERVO");
		String userId = user.getUserId();
		
		P_ReplyVO replyVo = new P_ReplyVO();
		
		replyVo.setPostNo(postNo);
		replyVo.setReplyContent(replyContent);
		replyVo.setUserId(userId);
		
		logger.debug("postNo, replyContent, userId , {},{},{}", postNo, replyContent, userId);
		
		try {
			int insertCnt = 0;
			
			insertCnt = replyservice.insertReply(replyVo);
			
			if(insertCnt == 1) {
				response.sendRedirect(request.getContextPath() + "/post?postNo=" + postNo);
			}
		} catch (Exception e) {
			doGet(request, response);
		}
	}

}
