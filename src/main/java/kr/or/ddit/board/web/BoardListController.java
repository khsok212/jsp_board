package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.Board1VO;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;

@WebServlet("/boardList")
public class BoardListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IBoardService service;

	@Override
	public void init() throws ServletException {
		service = new BoardServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Board1VO> boardList = service.getBoardList();
		
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String boardName = req.getParameter("boardName");
		int useYN = Integer.parseInt(req.getParameter("useYN"));
		String userId = req.getParameter("userId");
		
		Board1VO board = new Board1VO();
		board.setBoardName(boardName);
		board.setUseYN(useYN);
		
		int insertCnt = service.insertBoard1(board);
		
		if(insertCnt == 1) {
			resp.sendRedirect(req.getContextPath() + "/boardList");
		}
	}
}

