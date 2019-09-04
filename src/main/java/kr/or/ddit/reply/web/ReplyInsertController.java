package kr.or.ddit.reply.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.reply.model.P_ReplyVO;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyServiceImpl;
import kr.or.ddit.user.web.UserController;

@WebServlet("/replyInsert")
public class ReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private IReplyService replyservice;
	
	@Override
	public void init() throws ServletException {
		replyservice = new ReplyServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/post/post.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int postNo = Integer.parseInt(request.getParameter("postNo"));; 
		String replyContent = request.getParameter("replyContent");
		String userId = request.getParameter("userId");
		String replyWDate = request.getParameter("replyWDate");
		
		Date replyWDate_fmt = null;
		
		try {
			replyWDate_fmt = new SimpleDateFormat("yyyy-MM-dd").parse(replyWDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		P_ReplyVO replyVo = new P_ReplyVO();
		
		replyVo.setPostNo(postNo);
		replyVo.setReplyContent(replyContent);
		replyVo.setUserId(userId);
		replyVo.setReplyWDate(replyWDate_fmt);
		
		try {
			int insertCnt = 0;
			
			insertCnt = replyservice.insertReply(replyVo);
			
			if(insertCnt == 1) {
				response.sendRedirect(request.getContextPath() + "/post?postNo="+postNo);
			}
		} catch (Exception e) {
			doGet(request, response);
		}
		
	}

}
