<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${cp}/elScope" method="post">
		request : <input type = "text" name = "req" value = "brown"/><br>
		session : <input type = "text" name = "session" value = "cony"/><br>
		application : <input type = "text" name = "application" value = "sally"/><br>
		<input type = 'submit' value = "전송">
	</form>
	
	<hr>

	<h2>el scope test</h2>
	
	<h3> pageContext / request / session / application </h3>
	<%
		// pageContext / request / session / application
		pageContext.setAttribute("attr", "page_attr");
		request.setAttribute("attr", "request_attr");
		session.setAttribute("attr", "session_attr");
		application.setAttribute("attr", "application_attr");
	%>
	pageScope : ${pageScope.attr}<br>
	requestScope : ${requestScope.attr}<br>
	sessionScope : ${sessionScope.attr}<br>
	applicationScope : ${applicationScope.attr}<br><br>
	
	el : ${attr }<br>
	
	<hr>
	<h3> pageContext삭제 후</h3>
	<%
		pageContext.removeAttribute("attr",1);
	%>
	
	el : ${attr }<br>
	
	<hr>
	<h3> request 삭제 후</h3>
	<%
		pageContext.removeAttribute("attr",2);
	%>
	
	el : ${attr }<br>
	
	<hr>
	<h3> session 삭제 후</h3>
	<%
		pageContext.removeAttribute("attr",3);
	%>
	
	el : ${attr }<br>
	
</body>
</html>