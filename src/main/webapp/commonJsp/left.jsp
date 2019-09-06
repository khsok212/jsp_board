<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="kr.or.ddit.post.service.PostServiceImpl"%>
<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.board.service.BoardServiceImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List list = new BoardServiceImpl().getBoardList();
	request.setAttribute("boardList", list);
	
%>

    <ul class="nav nav-sidebar">
    	<li class="active"><a href="${cp}/main.jsp">메인 <span class="sr-only">(current)</span></a></li>
    	
		<c:if test="${'brown' == S_USERVO.userId }">
			<li class="active"><a href="${cp}/boardList">게시판 생성<span class="sr-only">(current)</span></a></li>
		</c:if>
		  			
		<c:forEach items = "${boardList }" var = "board">
			<c:if test="${board.useYN == 1 }">
				<input type="hidden" id="boardNo" name="boardNo" value = "${board.boardNo }"/>
				<li class="active"><a href="${cp}/postList?boardNo=${board.boardNo }&page=1&pagesize=10">${board.boardName }<span class="sr-only">(current)</span></a></li>
			</c:if>
		</c:forEach>
	</ul>