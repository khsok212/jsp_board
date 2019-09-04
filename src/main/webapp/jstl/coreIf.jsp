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
	<%-- 
		일반적인 if : if else if else 
		jstl if : if
		일반적인 if에 해당하는 jstl tag는 choose
	--%>
	<h2>core if</h2>
	<c:set var="code2" value="02"/>
	<c:set var="code1" value="01"/>
	
	<%-- test 속성에 조건을 기술, test 부분이 true이면 c:if 태그안의 내용이 실행  
		★ 비교 구문은 el 안에 작성한다.
	--%>
	<c:if test="${code1 == '01'}">
		code1 is 01 <br>
	</c:if>
	
	<c:if test="${code2 == '02'}">
		code2 is 02
	</c:if>
</body>
</html>