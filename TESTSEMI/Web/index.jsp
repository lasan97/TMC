<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TMC TEST Web</title>
<link rel="stylesheet" href="resourse/css/index.css">
</head>
<body>
	<%@ include file="views/common/header.jsp"%>
	<div class="entry-content">
		<!-- MemberName에 각자 이름 기재바람 -->
		<section class="section1_background_main_hongsuk">

			<div class="section1_main_img">

				<img src="resourse/img/main-img.jpg" alt="">


			</div>


		</section>

		<section class="section2_background_MemberName"
			style="margin-top: 50px;">

			<div class="section2_main_row">
				<div class="section2_main_context">
					<h2>What We Do</h2>
					<hr>
					<p>동물이 인간의 일방적인 착취와 이용에서 벗어나 존엄한 생명으로서 그들 본연의 삶을 영위하고, 모든 생명이
						균형과 조화 속에 공존하는 세상을 지향한다.</p>
					<p>시민들과의 지식과 배움의 공유를 통해 동물에 대한 이해와 공감, 참여를 확대하며 폭넓은 연구와 다양한 실천을
						통해 문화와 인식의 긍정적 변화를 이끌고, 이어 법과 제도의 개선으로 동물복지를 증진한다.</p>
					<a class="btn btn-primary btn-lg" href="#">후원하기 &raquo;</a>
				</div>
			</div>



		</section>

		<section class="section3_background_MemberName">

			<div class="section3_main_row_card">

				<article class="section3_main_card">
					<div class="card">
						<h4 class="card_title">입양하기</h4>
						<a href="index_choijinho1.html"> <img class="card_img"
							src="resourse/img/main_img_01.jpg" alt="">
						</a>
						<div class="card_body">
							<p class="card_text">귀여운 강아지 입양해죠~! 귀여운 강아지 입양해죠~! 귀여운 강아지
								입양해죠~! 귀여운 강아지 입양해죠~!</p>
						</div>
						<div class="card_footer"></div>
					</div>
				</article>

				<article class="section3_main_card">
					<div class="card">
						<h4 class="card_title">입양 소원하기</h4>
						<a href="index_choijinho2.html"> <img class="card_img"
							src="resourse/img/main_img_02.jpg" alt="">
						</a>
						<div class="card_body">
							<p class="card_text">귀여운 강아지 등록해죠~! 귀여운 강아지 등록해죠~! 귀여운 강아지
								등록해죠~! 귀여운 강아지 등록해죠~!</p>
						</div>
						<div class="card_footer"></div>
					</div>
				</article>

				<article class="section3_main_card">
					<div class="card">
						<h4 class="card_title">입양후기</h4>
						<img class="card_img" src="resourse/img/main_img_03.jpg" alt="">
						<div class="card_body">
							<p class="card_text">귀여운 강아지 후기 써죠~! 귀여운 강아지 후기 써죠~! 귀여운 강아지
								후기 써죠~! 귀여운 강아지 후기 써죠~!</p>
						</div>
						<div class="card_footer"></div>
					</div>
				</article>

			</div>
	</div>
	<%@ include file="views/common/footer.jsp"%>
</body>
</html>