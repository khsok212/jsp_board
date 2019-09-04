<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		HttpServletRequest hsr = (HttpServletRequest)pageContext.getRequest();
		hsr.getContextPath();
	%>
	
<%-- <script src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script> --%>
<script src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>

<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Bootstrap core CSS -->
<script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>

<!-- Custom styles for this templet -->
<link href="${pageContext.request.contextPath }/css/dashboard.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/blog.css" rel="stylesheet">