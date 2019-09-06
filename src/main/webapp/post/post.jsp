<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%  %>

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
	#deleteIcon{
		cursor: pointer;
	}
	*{
		font-family: NanumSquare ExtraBold;
		font-size: 1.02em;
	}
</style>
<%@include file="/commonJsp/basicLib.jsp" %>
</head>
<script>
// 문서 로딩이 완료된 후
$(document).ready(function(){
	
	// 수정하기 버튼 클릭시 이벤트 핸들러
	$('#modifyBtn').click(function(){
		$("#frm").submit();
	})
	
	// 댓글등록 클릭시 이벤트 핸들러 
	$('#replyBtn').click(function(){
		$("#frm2").submit();
	})
	
	// 댓글 삭제 아이콘 클릭시 이벤트 핸들러
	$('#deleteIcon').click(function(){
		$('#frm3').submit();
	})
	
	// 답글달기 클릭시 이벤트 핸들러
	$('#reRegBtn').click(function(){
		$('#frm4').submit();
	})
	
	// 게시물 삭제 클릭시 이벤트 핸들러
	$('#deleteBtn').click(function(){
		$('#frm5').submit();
	})
	
	// 댓글 등록 (500글자)
	$("textarea").keyup(function() {
         var len = $(this).val().length;
         if(len >= 500) {
            $(this).val($(this).val().slice(0, 500));
            alert("댓글은 500자를 넘길 수 없습니다.")
         }
      })
})
</script>
<body>
	<form id="frm4" action="${cp}/postReForm" method="get">
       <input type="hidden" id="userId" name="userId" value = "${user.userId }"/>
       <input type="hidden" id="postNo" name="postNo" value = "${post.postNo }"/>
       <input type="hidden" id="parentPostNo" name="parentPostNo" value = "${param.parentPostNo}"/>
       <input type="hidden" id="boardNo" name="boardNo" value = "${post.boardNo}"/>
<%--        <input type="hidden" id="postContent" name="postContent" value = "${post.postContent}"/> --%>
<%--        <input type="hidden" id="postTitle" name="postTitle" value = "${post.postTitle}"/> --%>
    </form>
    
	<!-- 값을 가져오는 방법??? -->
	<form id="frm3" action="${cp}/replyDelete" method="get">
       <input type="hidden" id="postNo" name="postNo" value = "${post.postNo }"/>
       <input type="hidden" id="replyNo" name="replyNo" value = "${reply.replyNo }"/>
    </form>
	
	<!-- 가져간다  -->
	<form id="frm" action="${cp}/postModify" method="get">
       <input type="hidden" id="userId" name="userId" value = "${user.userId }"/>
       <input type="hidden" id="postNo" name="postNo" value = "${post.postNo }"/>
       <input type="hidden" id="fileNo" name="fileNo" value = "${file.fileNo }"/>
       <input type="hidden" id="boardNo" name="boardNo" value = "${post.boardNo}"/>
    </form>
    
	<form id="frm5" action="${cp}/postDelete" method="get">
       <input type="hidden" id="postNo" name="postNo" value = "${post.postNo }"/>
       <input type="hidden" id="boardNo" name="boardNo" value = "${post.boardNo}"/>
    </form>

   <!-- header -->
   <%@include file="/commonJsp/header.jsp" %>
   
   <div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@include file="/commonJsp/left.jsp"%>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form id = "frm2" class="form-horizontal" role="form"
				action="${cp }/post" method="post">
				
				<input type="hidden" name="replyNo" value="${param.replyNo }">
				<input type="hidden" name="postNo" value="${param.postNo }"> ${post.parentPostNo }

					<div class="form-group">
						<label for="postTitle" class="col-sm-2 control-label">제 목</label>
						<div class="col-sm-10">
							<label class="control-label">${post.postTitle }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="postContent" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<label class="control-label">${post.postContent }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
							<c:forEach items="${ fileList }" var="file">
							<div>
								<label class="control-label">${file.fileName}</label>
								<!-- download = 지우면 다운로드 // 저렇게 적으면  -->
								<a href="${cp }/fileDownload?fileNo=${file.fileNo}" download="${file.fileName }">다운로드</a>
							</div>
							</c:forEach>
							<br>
							<c:if test="${post.userId == S_USERVO.userId }">
								<button type="button" id="modifyBtn" class="btn">수정하기</button>
								<button type="button" id="deleteBtn" class="btn">삭제하기</button>
							</c:if>
							<button type="button" id="reRegBtn" class="btn">답글쓰기</button>
							<br>
						</div>
					</div>

					<div class="form-group">
						<label for="replyContent" class="col-sm-2 control-label">댓글</label>
						<div class="col-sm-10">
							<c:forEach items="${ replyList }" var="reply">
								<c:choose>
									<c:when test="${reply.deleteYN == 1 }">
									<div class = "replyOn">
										<label class="control-label">${reply.replyContent }[
											${reply.userId } / ${reply.replyWDate_fmt } ]</label>
											
										<c:if test="${reply.userId == S_USERVO.userId }">
											<a href="${cp}/replyDelete?postNo=${post.postNo }&replyNo=${reply.replyNo }"> 
												<span id = deleteIcon class="glyphicon glyphicon-remove"></span>
											</a>
										</c:if>
									</div>
									</c:when>	
									
									<c:otherwise>
									<div class = "replyOff">
										<label class="control-label">[삭제된 댓글입니다]</label>
									</div>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<br>
							<br>
						</div>
					</div>
					
					<div class="form-group">
						<label for="replyContent" class="col-sm-2 control-label">댓글입력</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="4" name="replyContent1" id="replyContent1" placeholder="댓글을 입력하세요." style="resize: none;"></textarea>
							<br><button type="button" id="replyBtn" class="btn btn-info">댓글 등록</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>
    