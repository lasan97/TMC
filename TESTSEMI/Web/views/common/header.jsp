<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.tmc.member.model.vo.*"%>
<%
	Member m = (Member) session.getAttribute("member");
%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/tmc/resourse/js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="/tmc/resourse/css/tmc.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<!-- HEADER -->
    <header class="tmc_main-header">
            <div class="tmc_main_header_container">
                <div class="tmc_header-logo">
                    <img src="/tmc/resourse/img/tmcLogo.png" alt="logo">
    
                </div>
    
                <div class="tmc_nav_bar" id="navbarResponsive">
                    
                    <ul class="tmc_nav_ul">
                        <li>
                            <a class="tmc_nav-link" href="/tmc/listAdoptW.ado">입양하기</a>
                        </li>
                        <li>
                            <a class="tmc_nav-link" href="/tmc/views/hospital/indexRS.jsp">동물병원</a>
                        </li>
                        <li>
                            <a class="tmc_nav-link" href="#">후원하기</a>
                        </li>
                        <li>
                            <a class="tmc_nav-link" href="#">보호소</a>
                        </li>
                        <li>
                            <a class="tmc_nav-link" href="/tmc/trSelectList.tr">훈련정보</a>
                        </li>
                        <li>
                            <a class="tmc_nav-link" href="#">게시판</a>
                        </li>
                        <li>
                            <a class="tmc_nav-link" href="#">마이페이지</a>
                        </li>
                        <li>
                        <form action="signout.do" name="user_logout" style="display: inline">
						<a id="login_onclick" class="tmc_nav-link">로그인</a> <a
							id="logout_onclick" class="tmc_nav-link">로그아웃</a>
					</form></li>
                        <div id="tmc_nav_guide"></div>
                    </ul>
                    <a id="nav_bar_pull">
                            <span></span>
                        </a>
                </div>
            </div>
        </header>
        <!-- 로그인 -->
	<div id="login_form" class="section_login">
		<div class="login_content">
			<div class="login-header">
				<span class="close">&times;</span>
				<h2>로그인</h2>
			</div>
			<div class="login-body">

				<form action="/tmc/signIn.mo">

					<p>아이디와 비밀번호를 입력하세요.</p>
					<input type="text" name="userId" id="userid" class="form-control"
						placeholder="아이디를 입력하세요"> <br> <input type="password"
						name="userPwd" id="userpassword" class="form-control"
						placeholder="비밀번호를 입력하세요"> <br>
					<button type="submit" class="btn btn-outline-success"
						style="background: white;">로그인</button>
					<br> <br>
					<button class="btn btn-outline-primary">페이스북</button>
					<button class="btn btn-outline-warning">카카오톡</button>


					<br> <a href="">아이디나 비밀번호를 잊으셨나?</a><br> <a href="">아직
						회원이 아니세요?</a>

				</form>
			</div>
		</div>
	</div>

	<script>
		
	<%if (m == null) {%>
		document.getElementById("logout_onclick").style.display = "none";
	<%} else {%>
		document.getElementById("login_onclick").style.display = "none";
	<%}%>
		// 로그아웃

		$("#logout_onclick").click(function() {
			var input = confirm('정말 로그아웃?');
			if (input){
					document.user_logout.submit();
			}
		});
	</script>
</body>
</html>