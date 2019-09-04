package kr.or.ddit.post.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.postfile.service.IPostFileService;
import kr.or.ddit.postfile.service.PostFileServiceImpl;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyServiceImpl;
import kr.or.ddit.user.web.UserController;

@WebServlet("/postDelete")
public class PostDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private IPostService postservice;
	private IBoardService boardservice;
	
	@Override
	public void init() throws ServletException {
		postservice = new PostServiceImpl();
		boardservice = new BoardServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		int deleteCnt = postservice.deletePost(postNo);
		
		if(deleteCnt == 1) {
			response.sendRedirect(request.getContextPath() + "/postList?boardNo=" + boardNo + "&");
		}
		
	}
}
