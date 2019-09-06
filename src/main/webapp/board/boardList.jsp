<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title></title>
<%@ include file="/commonJsp/basicLib.jsp"%>

<style>
	#useYN {
		height: 1.9em;
	}
	
	*{
		font-family: NanumSquare ExtraBold;
		font-size: 1.02em;
	}
</style>
<script>
	
// 	function update(boardNo){
// 		$("#boardNo").val();
// 		$(this).parent('form').submit();
// 	}
	
	$(document).ready(function(){
		$('.modi').click(function(){
			$(this).parent('form').submit();
		})
	
		// 게시판 등록 버튼 클릭시
		$('#insertBtn').click(function(){
			$('#frm1').submit();
		})
	})
</script>
</head>

<body>
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

						<form id="frm1" class="form-horizontal" role="form"
							action="${cp }/boardList" method="post">

							<input type="hidden" name="userId" value="${param.userId }">

							<div class="blog-post">
								<h3>게시판 등록</h3>
								<hr>
								<p>
									<label>게시판 이름</label> 
									<input type="text" id="boardName" name="boardName" required autofocus	value="${param.boardName }"> 
										<select id="useYN" name="useYN">
										<option value="1">사용</option>
										<option value="2">미사용</option>
									</select>
									<button type="button" id="insertBtn" class="btn btn-info">생성</button>
								</p>
							</div>
						</form>

						<h3>게시판 수정</h3>
						<c:forEach items="${boardList }" var="board">
							<form id="frm2${board.boardNo }" class="form-horizontal"
								role="form" action="${cp }/boardModify" method="post">
								<hr>
								<label>게시판 이름</label>&nbsp;&nbsp; <input type="text"
									id="boardNm" name="boardNm" value="${board.boardName }">&nbsp;&nbsp;
								<input type="hidden" id="boardNo" name="boardNo" value="${board.boardNo }"> 
									<select id="useYN" name="useYN">

									<c:choose>
										<c:when test="${board.useYN == 1 }">
											<option value=1>사용</option>
											<option value=2>미사용</option>
										</c:when>
										<c:otherwise>
											<option value=1>사용</option>
											<option value=2 selected="selected">미사용</option>
										</c:otherwise>
									</c:choose>
								</select>&nbsp;&nbsp;
								<button type="button" class="btn btn-info modi"
									onclick="update(${board.boardNo })">수정</button>
								<br>
							</form>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>