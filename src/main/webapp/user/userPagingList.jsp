<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-basicLib</title>
<style>
	td{
		cursor: pointer;
	}
	.userTr:hover{
		background: pink;
	}
</style>
<%@ include file = "/commonJsp/basicLib.jsp" %>
<script>
   // 문서 로딩이 완료된 후
   $(document).ready(function(){
      // 사용자 정보 클릭시 이벤트 핸들러
      $(".userTr").on("click", function(){
    	  
         // 클릭한 tr 태그의 자식태그(td) 중 첫번째 자식의 텍스트 문자열
         var tdText = $($(this).children()[1]).text();
         console.log("tdText: " + tdText);
         
         //input태그에 저장된 값 확인
         var inputValue = $(this).find("input").val();
         console.log("inputValue: " + inputValue);
         
         // data 속성으로 값 가져오기
         // data 속성명은 소문자로 치환된다.
         // data-userId -> $(this).data("userid");
         
		 var dataValue = $(this).data("userid");         
         console.log("dataValue: " + dataValue);
         
         // 하위 코드는 실행되지 않는다.
//          return false;
         
         // input 태그에 값 설정
         $("#userId").val(dataValue);
         
         // form 태그이용 전송
         console.log("serialize: "+$("#frm").serialize());
         
         $("#frm").submit();
      });
   });
</script>
</head>

<body>
	<form id="frm" action="${cp}/user" method="get">
       <input type="hidden" id="userId" name="userId"/>
    </form>
    
	<!-- header -->
	<%@ include file="/commonJsp/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				
				<!-- left -->
				<%@ include file="/commonJsp/mainLeft.jsp"%>

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자 페이징 리스트</h2>
						<div class="table-responsive">
							<table class="table table-striped table-condensed">
								<tr>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>

								<%--
									// UserListController에서 지정한 request.setAttribute("userList", userList); 아이디 이름으로 가져온다.
									List<User> userList = (List<User>)request.getAttribute("userList");
									for(User userVo : userList){
								--%>
								
<!-- 								<tr> -->
<%-- 									<td><%=userVo.getUserId() %></td> --%>
									<!-- 사용자 아이디  -->
<%-- 									<td><%=userVo.getUserNm() %></td> --%>
									<!-- 사용자 이름  -->
<!-- 									<td></td> -->
									<!-- 사용자 별명  -->
<!-- 									<td></td> -->
									<!-- 등록일시  -->
<!-- 								</tr> -->
								
								<%-- } --%>
								
								<%-- for(User user : userList) --%>
								<c:forEach items="${userList}" var="user">
									<tr class = "userTr" data-userId = "${user.userId }">
									<input type = "hidden" value = "${user.userId }"/>
										<td>${user.userId }</td>
										<td>${user.userNm }</td>
										<td>${user.alias }</td>
										<td>${user.reg_dt_fmt }</td>
									</tr>
								</c:forEach>

							</table>
						</div>

						<a href = "${cp }/userForm" class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
							
								<%--  이전 페이지 가기 : 지금 있는 페이지에서 한 페이지 전으로  
									 단, 1페이지인 경우 li태그에 class = "disabled"를 추가하고 이동 경로는 차단
								--%>
								
								
								<c:choose>
									<c:when test="${param.page == 1 }">
										<li class = "daisabled">
											<span aria-hidden="true">&laquo;</span>
										</li>
									</c:when>
									<c:otherwise>
										<li><a href="${cp }/userPagingList?page=${param.page-1 }&pagesize=10" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
										</a></li> 
									</c:otherwise>
								</c:choose>
								
								<c:forEach begin="1" end="${paginationSize }" var="page">
								
<%-- 									<li <c:if test="${page == param.page }"> class="active" </c:if> --%>
<%-- 									><a href="${cp }/userPagingList?page=${page}&pagesize=15">${page }</a></li> --%>
									<c:choose>
									<c:when test="${page == param.page }">
										<li class = "active"><span>${page }</span></li>
									</c:when>
									<c:otherwise>
										<li><a href="${cp }/userPagingList?page=${page}&pagesize=10">${page }</a></li>
									</c:otherwise>
									</c:choose>
									
								</c:forEach>
								
								<c:choose>
									<c:when test="${param.page >= paginationSize }">
										<li class = "daisabled">
											<span aria-hidden="true">&raquo;</span>
										</li>
									</c:when>
									<c:otherwise>
										<li><a href="${cp }/userPagingList?page=${param.page+1 }&pagesize=10" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
										</a></li> 
									</c:otherwise>
								</c:choose>

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
