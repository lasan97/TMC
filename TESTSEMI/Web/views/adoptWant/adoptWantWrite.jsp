<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입양 소원하기</title>
<link rel="stylesheet" href="/tmc/resourse/css/tmc.css">
    <script src="/tmc/resourse/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="/tmc/resourse/css/adoptWantWrite.css" >
    <!-- 부트스트랩 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/views/common/header.jsp"%>

<section> 
<div class="adoptWantWrite">
	<form action ="<%= request.getContextPath() %>/iAdoptW.ado"
				method="post" enctype="multipart/form-data">
	<ul class="adoptWant">
	<li><label for="adoptWnat_subject">제목</label><div><input name="adoptWnat_subject" type="text"/></div></li>
	<li><label for="adoptWnat_writer">작성자</label><div><input name="adoptWnat_writer" type="hidden" value="<%=m.getUserId() %>"/><%=m.getUserId() %> </div></li>
	<li><label for="adoptWnat_content">내용</label><div><textarea name="adoptWnat_content" width="40px" height="80px"></textarea></div></li>
	</ul>
	
	<div>
	<button type="reset">취소하기</button>
	<button type="submit">등록하기</button>
	</div>
	</form>
</div>
</section>



 

<%@ include file="/views/common/footer.jsp"%>
</body>
</html>