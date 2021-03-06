<%@page import="kr.or.ddit.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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

<title>게시판-Main</title>
<style>
	*{
		font-family: NanumSquare ExtraBold;
		font-size: 1.02em;
	}
	img{
		height: 200px;
		width: 200px;
	}
</style>
<%@ include file="/commonJsp/basicLib.jsp"%>
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


				<div class="blog-header">
					<h1 class="blog-title">Main</h1>
					<img src="board/게시판.gif">
					<p class="lead blog-description">Jsp / Spring.</p>
				</div>

				<div class="row">

					<div class="col-sm-8 blog-main">

						<div class="blog-post">
							<h2 class="blog-post-title">Board</h2>
							<p class="blog-post-meta"></p>
							
							<p>게시판 실습</p>
							<hr>

							<h3>요구사항</h3>
							<p>작성되어야 할 기능, 화면</p>
							<ul>
								<li>로그인 화면</li>
								<li>게시판 관리화면(게시판 신규 추가, 비활성화)</li>
								<li>게시물 리스트 화면(페이징 기능 추가, 답글(게층형))</li>
								<li>게시물 상세화면</li>
								<li>게시물 추가 입력화면 - 파일추가</li>
								<li>게시물 수정화면</li>
								<li>게시물 삭제기능</li>
								<li>게시물 답글기능</li>
								<li>댓글 달기기능</li>
							</ul>
						</div>
					</div>
					
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
