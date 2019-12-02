<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TMC TEST Web</title>
<link rel="stylesheet" href="resourse/css/index.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<style type="text/css">
.alert-success {
	width: 25%;
	font-size: 1em;
}

.alert-danger {
	width: 40%;
	font-size: 1em;
}
</style>
</head>
<body>
	<%@ include file="views/common/header.jsp"%>
	<div class="entry-content">
		<!-- MemberName에 각자 이름 기재바람 -->
		<section class="section1_background_singup_hongsuk">

			<div class="section1_singup">
				<h1>회원가입</h1>
				<p>
					*필수입력<br>
				</p>
				<form action="/tmc/signup.mo" method="POST">

					<p class="p_tag_margin">*이메일 입력</p>
					<div style="display: flex">
						<input type="text" name="userId" class="SignInText form-control"
							style="width: 20%;"> &nbsp; <span
							style="font-size: 1.5em;"><sub>@</sub></span> &nbsp; <input
							type="text" name="userEmail" style="width: 20%"
							onblur="checkid()" class="form-control"> &nbsp;&nbsp; <select
							name="domain" onchange="domainCheck();">
							<option value="0" selected="selected">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="hanmail.net">hanmail.net</option>
							<option value="nate.com">nate.com</option>
							<option value="yahoo.com">yahoo.com</option>
						</select>
					</div>

					<p class="p_tag_margin">*비밀번호</p>
					<input id="pwd1" type="password" class="SignInText form-control"
						style="width: 25%;" name="userPwd1">
					<p class="p_tag_margin">*비밀번호 확인</p>
					<input id="pwd2" type="password" class="SignInText form-control"
						style="width: 25%;" name="userPwd2">

					<div class="alert alert-success" id="alert-success">비밀번호가
						일치합니다.</div>
					<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지
						않습니다.</div>

					<p class="p_tag_margin">*이름</p>
					<input type="text" class="SignInText form-control"
						style="width: 18%;" name="userName">
					<p class="p_tag_margin">*연락처</p>
					<input type="text" class="SignInText form-control"
						style="width: 38%;" placeholder="- 을 넣지마세요!" name="userPhone">
					<p class="p_tag_margin">*주소</p>
					<input type="text" class="SignInText form-control"
						style="width: 80%;" name="userAddress"> <br> <br>
					<button id="submit" type="submit" onclick=""
						class="btn btn-outline-success">회원가입</button>
					&nbsp;&nbsp;
					<button type="button" onclick="" class="btn btn-outline-success">초기화</button>
				</form>
		</section>
	</div>
	<%@ include file="views/common/footer.jsp"%>
	<script type="text/javascript" src="resourse/js/rsjss.js"></script>
	<script>
		$(function() {

			$("#submit").attr("disabled", "disabled");
			$("#alert-success").hide();
			$("#alert-danger").hide();
			$("input").keyup(function() {
				var pwd1 = $('#pwd1').val();
				var pwd2 = $('#pwd2').val();
				if (pwd1 != "" || pwd2 != "") {
					if (pwd1 == pwd2) {
						$("#alert-success").show();
						$("#alert-danger").hide();
						$("#submit").removeAttr("disabled");
					} else {
						$("#alert-success").hide();
						$("#alert-danger").show();
						$("#submit").attr("disabled", "disabled");

					}
				}
			});

		});
	</script>
		</body>
		</html>
	