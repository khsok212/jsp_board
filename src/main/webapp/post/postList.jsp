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

<title>게시판목록/등록</title>
<style>

	.postTr{
		cursor: pointer;
	}
	
	.postTr:hover{
		background: pink;
	}
	
</style>
<%@ include file = "/commonJsp/basicLib.jsp" %>
<script>
   // 문서 로딩이 완료된 후
   $(document).ready(function(){
      // 사용자 정보 클릭시 이벤트 핸들러
      $(".postTr").on("click", function(){
    	  
		 var dataValue = $(this).data("postno");         
         console.log("dataValue: " + dataValue);
         
         // 하위 코드는 실행되지 않는다.
//          return false;
         
         // input 태그에 값 설정
         $("#postNo").val(dataValue);
         
         // form 태그이용 전송
         console.log("serialize: "+ $("#frm").serialize());
         
         $("#frm").submit();
      });
   });
</script>
</head>

<body>
	<form id="frm" action="${cp}/post" method="get">
       <input type="hidden" id="postNo" name="postNo"/>
       <input type="hidden" id="parentPostNo" name="parentPostNo" value = "${post.parentPostNo }"/>
       <input type="hidden" id="boardNo" name="boardNo" value = "${board.boardNo }"/>
       <input type="hidden" id="deleteYN" name="deleteYN" value = "${post.deleteYN }"/>
       
    </form>
    
	<!-- header -->
	<%@ include file="/commonJsp/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@ include file="/commonJsp/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">${board.boardName }</h2>
						<div class="table-responsive">
							<table class="table table-striped table-condensed">
								<tr>
									<th>게시글 번호</th>
									<th>제목</th>
									<th>작성자 아이디</th>
									<th>작성일시</th>
								</tr>

								<%-- for(User user : userList) --%>
								
								<c:forEach items="${postList}" var="post">
									<c:choose>
										<c:when test="${post.deleteYN == 1 }">
											<tr class="postTr" data-postNo="${post.postNo }">
												<td>${post.postNo }</td>
												<td><c:forEach begin="1" end="${post.level }">
										&nbsp;&nbsp;&nbsp;&nbsp;	
										</c:forEach> <c:if test="${post.level > 1 }">
										└ 
										</c:if> 
										${post.postTitle }</td>
										<td>${post.userId }</td>
										<td>${post.postWDate_fmt }</td>
										</c:when>
										
										<c:otherwise>
											<tr class="deleteTr" data-postNo="${post.postNo }">
												<td>${post.postNo }</td>
												<td><c:forEach begin="1" end="${post.level }">
										&nbsp;&nbsp;&nbsp;&nbsp;	
										</c:forEach> <c:if test="${post.level > 1 }">
										└ 
										</c:if> 
										[삭제된 게시글 입니다]</td>
										<td>${post.userId }</td>
										<td>${post.postWDate_fmt }</td>
										</c:otherwise>
									</c:choose>
								</c:forEach>

							</table>
						</div>

						<a href = "${cp }/postForm?boardNo=${ param.boardNo }" class="btn btn-info pull-right">게시물 등록</a>
						
						<div class="text-center">
							<ul class="pagination">
							
								<%--  이전 페이지 가기 : 지금 있는 페이지에서 한 페이지 전으로  
									 단, 1페이지인 경우 li태그에 class = "disabled"를 추가하고 이동 경로는 차단
								--%>
								
								<c:choose>
									<c:when test="${param.page == 1 }">
										<li class = "daisabled">
											<span aria-hidden="true">&lt;&lt;</span>
										</li>
									</c:when>
									<c:otherwise>
										<li><a href="${cp }/postList?page=1&pagesize=10&boardNo=${boardNo}" aria-label="Previous">
										<span aria-hidden="true">&lt;&lt;</span>
										</a></li> 
									</c:otherwise>
								</c:choose>
								
								<c:choose>
									<c:when test="${param.page == 1 }">
										<li class = "daisabled">
											<span aria-hidden="true">&lt;</span>
										</li>
									</c:when>
									<c:otherwise>
										<li><a href="${cp }/postList?page=${param.page-1 }&pagesize=10&boardNo=${boardNo}" aria-label="Previous">
										<span aria-hidden="true">&lt;</span>
										</a></li> 
									</c:otherwise>
								</c:choose>
								
								<c:forEach begin="1" end="${paginationSize }" var="page">
								
									<c:choose>
									<c:when test="${page == param.page }">
										<li class = "active"><span>${page }</span></li>
									</c:when>
									<c:otherwise>
										<li><a href="${cp }/postList?page=${page}&pagesize=10&boardNo=${boardNo}">${page }</a></li>
									</c:otherwise>
									</c:choose>
									
								</c:forEach>
								
								<c:choose>
									<c:when test="${param.page >= paginationSize }">
										<li class = "daisabled">
											<span aria-hidden="true">&gt;</span>
										</li>
									</c:when>
									<c:otherwise>
										<li><a href="${cp }/postList?page=${param.page+1 }&pagesize=10&boardNo=${boardNo}" aria-label="Next">
										<span aria-hidden="true">&gt;</span>
										</a></li> 
									</c:otherwise>
								</c:choose>
								
								<c:choose>
									<c:when test="${param.page >= paginationSize }">
										<li class = "daisabled">
											<span aria-hidden="true">&gt;&gt;</span>
										</li>
									</c:when>
									<c:otherwise>
										<li><a href="${cp }/postList?page=${paginationSize }&pagesize=10&boardNo=${boardNo}" aria-label="Next">
										<span aria-hidden="true">&gt;&gt;</span>
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
