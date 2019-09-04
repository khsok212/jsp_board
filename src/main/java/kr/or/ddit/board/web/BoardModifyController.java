package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import kr.or.ddit.board.model.Board1VO;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

@WebServlet("/boardModify")
public class BoardModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(BoardModifyController.class); 
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		String boardName = request.getParameter("boardNm");
		int useYN = Integer.parseInt(request.getParameter("useYN"));
		
		logger.debug("board parameter : {},{},{}", boardNo, boardName, useYN);
		
		Board1VO board = new Board1VO();
		board.setBoardName(boardName);
		board.setUseYN(useYN);
		board.setBoardNo(boardNo);
		
		int updateCnt = 0;
		
		try {
			updateCnt = service.updateBoard1(board);
			
			if(updateCnt == 1) {
				response.sendRedirect(request.getContextPath() + "/boardList");
			}
		} catch (Exception e) {
			doGet(request, response);
		}
	}
}
