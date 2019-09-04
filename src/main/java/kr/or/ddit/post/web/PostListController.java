package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;

@WebServlet("/postList")
public class PostListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory.getLogger(PostListController.class);
	private IPostService postservice;
	private IBoardService boardservice;

	@Override
	public void init() throws ServletException {
		postservice = new PostServiceImpl();
		boardservice = new BoardServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		String pageStr = request.getParameter("page");
		String pagesizeStr = request.getParameter("pagesize");
		
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pagesize = pagesizeStr == null ? 10 : Integer.parseInt(pagesizeStr);
		
		Page p = new Page(page, pagesize, boardNo);
		System.out.println("======================================================");
		System.out.println(boardNo);
		Map<String, Object> resultMap = postservice.getPostPagingList(p, boardNo);
		
		Board1VO boardVo = boardservice.getBoard(boardNo);
		
		List<PostVO> postList = (List<PostVO>) resultMap.get("postList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		request.setAttribute("postList", postList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("board", boardVo);
		
		request.getRequestDispatcher("/post/postList.jsp").forward(request, response);
	
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//	}	
}
