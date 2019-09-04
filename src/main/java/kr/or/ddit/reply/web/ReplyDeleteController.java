package kr.or.ddit.reply.web;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/replyDelete")
public class ReplyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(ReplyDeleteController.class);
    private IReplyService service;
    
    @Override
    public void init() throws ServletException {
    	service = new ReplyServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		
		int deleteCnt = service.deleteReply(replyNo);
		
		if(deleteCnt == 1) {
			response.sendRedirect(request.getContextPath() + "/post?postNo=" + postNo);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
	}

}
