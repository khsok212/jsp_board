<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    
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

</style>
<%@include file="/commonJsp/basicLib.jsp" %>
<script src="/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});

	// 사용자 등록 버튼 클릭시 이벤트 핸들러
	$("#regBtn").on("click", function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이 부분에 에디터 validation 검증
			if(validation()) {
				$("#frm").submit();
			}
		}
	})
	$('#picture').change(function(){
		var length = $('#picture')[0].files.length;
		
		length += ${fileList.size()};
		if(length > 5){
			alert("파일은 최대 5개만 첨부가 가능합니다.");
			$('#picture').val("");
		}
	})
	
	$('#deleteIcon').click(function(){
		$("#frm5").submit();
	})
	
});

// 필수값 Check
function validation(){
	var contents = $.trim(oEditors[0].getContents());
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}

	return true;
}

</script>

</head>

<body>

	<form id="frm5" action="${cp}/fileDelete" method="get">
       <input type="hidden" id="postNo" name="postNo" value = "${post.postNo }"/>
       <input type="hidden" id="fileNo" name="fileNo" value = "${file.fileNo}"/>
    </form>
   <!-- header -->
   <%@include file="/commonJsp/header.jsp" %>
   
   <div class="container-fluid">
      <div class="row">
            
         <div class="col-sm-3 col-md-2 sidebar">
            <!-- left -->
            <%@include file="/commonJsp/left.jsp" %>
         </div>
      
         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      
            <form id = "frm" class="form-horizontal" role="form"
            		action="${cp }/postModify?boardNo=${param.boardNo }" method="post"
            		enctype="multipart/form-data">
            		
	      		<input type="hidden" id="boardNo" name="boardNo" value = "${param.boardNo }"/>
	      		<input type="hidden" id="postNo" name="postNo" value = "${postNo }"/>
			
               <div class="form-group">
                  <label for="postTitle" class="col-sm-2 control-label">제목</label>
                  <div class="col-sm-10">
                     <input type="text" class="form-control" id="postTitle" name="postTitle"
								placeholder="제목" value="${post.postTitle }">
                  </div>
               </div>
      
               <div class="form-group">
                  <label for="postContent" class="col-sm-2 control-label">글내용</label>
                  <div class="col-sm-10">
                  <!-- id값 변경 x -->
                     <textarea name="postContent" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;">${post.postContent }</textarea> 
                  </div>
               </div>
               
      		   <div class="form-group">
                  <label for="picture" class="col-sm-2 control-label">첨부파일</label>
                  <div class="col-sm-10">
                  
                  <c:forEach items="${ fileList }" var="file">
                  		<div id = "deletefile">
							<label class="control-label">${file.fileName} </label>&nbsp;&nbsp;&nbsp; 
							<a href="${cp}/fileDelete?postNo=${post.postNo }&fileNo=${file.fileNo }"> 
								<span id = deleteIcon class="glyphicon glyphicon-remove"></span>
							</a>
						</div>
				  </c:forEach>
				  <br>
                     <input type="file" multiple="multiple" class="form-control" id="picture" name="picture"
								placeholder="첨부파일" value="${file.fileName }">
					 <input type="hidden" id="fileNo" name="fileNo" value = "${param.fileNo }"/>
					 <input type="hidden" id="realFileName" name="realFileName" value = "${param.realFileName }"/>
                  </div>
               </div>
               
               <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                     <button type="button" id = "regBtn" class="btn btn-info">수정하기</button>
                  </div>
               </div>
            </form>
         </div>
      </div>
   </div>
</body>
</html>
    