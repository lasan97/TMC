<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.tmc.member.model.vo.Member"%>
<%
	Member mb = (Member) session.getAttribute("member");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TMC TEST Web</title>
<link rel="stylesheet" href="/tmc/resourse/css/rsinsertcss.css"
	type="text/css">
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<%-- 	<%
		if (m != null) {
	%> --%>
	<div class="entry-content">
		<div class="rsBoard">

			<form action="<%=request.getContextPath()%>/trInsert.do"
				method="post" enctype="multipart/form-data" id="insertForm">
				<div id="trHiddenDiv">
					<input type="text" name="userId" value="TEST"> <input
						type="file" name="trMainImg" id="trMainImg"
						onchange='trMainImgChange(this);'> <input type="text"
						name="imgNames" id="imgNames"> <input type="text"
						name="deletImg" id="deletImg">
				</div>
				<div id="rsInsertBoard">
					<div style="width: 200px;">
						<input type="text" name="boardT" id="boardT" required="required"
							placeholder="제목" maxlength="20">
						<hr>
					</div>
					<div id="mainImg">
						<img id="mainImgView" src="../../resourse/img/tmcLogo.png"
							style="cursor: pointer;"> <a>대표이미지</a>
					</div>
					<hr style="width: 220px;">
				</div>
				<div id="rsServicesBar">
					<button type="button" id="rsInsertImg">이미지 넣기</button>

				</div>
				<div id="content" class="fr-element fr-view" dir="ltr"
					contenteditable="true" style="min-height: 300px;"
					aria-disabled="false" spellcheck="true">

				
				</div>
				<hr>
				<input type="hidden" name="content" id="trContentInput" value=''>

				<div class="complete">
					<button onclick="insertButton();" id="rscomplete">등록하기</button>

				</div>

			</form>
			<form id="ajaxform" action="<%=request.getContextPath()%>/tInsert.tn"
				method="post" enctype="multipart/form-data">
				<ul id="TrImgInputs" style="display: none;">
					<li><input type='file' name='trImgFile' id='trImgFile'
						onchange='trInputChange(this);' /></li>
				</ul>
			</form>

		</div>
	</div>
	<hr>
	<script>
		var imgNamesArr = new Array();

		var imgNum = 0;
		var imgCount = 1;

		$(function() {
			$('#rsInsertImg').click(function() {
				$("#trImgFile").click();
			});
		});

		function trInputChange(value) {
			console.log(value);
			var imgname = "";
			var form = $('#ajaxform')[0];
			var formData = new FormData(form);

			/* formData.append("file",$('#trImgFile'+num)[0].files[0]); */
			$.ajax({
						url : "/tmc/rstest1.do",
						type : "POST",
						processData : false,
						contentType : false,
						data : formData,
						success : function(data) {
							console.log(data.imgName);

							$('#content')
									.append(
											"<img src='/tmc/resourse/trainingImg/"+data.imgName+"' name="+data.imgName+" id='trContentImg'>")
							imgNamesArr[imgNum] = data.imgName;
							imgNum++;

							/* console.log($('#trContentImg')[0].attr(src)); */
						},
						error : function(data) {

						}

					});
			imgCount++;
			/* 			if (value.files && value.files[0]) {

			 var reader = new FileReader();

			 reader.onload = function(e) {

			 $('#content').append(
			 "<img src='' id='trContentImg"+num+"'>")

			 $('#trContentImg' + num).attr('src', e.target.result);

			 }
			 reader.readAsDataURL(value.files[0]); 
			
			 document.querySelector('#download').href = dataURI; 
			 console.log($('#trContentImg'+imgCount).dataURL);
			
			 imgCount++;
			 } */

		};

		$('#content').mouseleave(function() {
			/* console.log(document.getElementById('content').innerHTML); */

		});
		$('#mainImgView').click(function() {
			$('#trMainImg').click();
		});
		function trMainImgChange(value) {
			if (value.files && value.files[0]) {

				var reader = new FileReader();

				reader.onload = function(e) {

					$('#mainImgView').attr('src', e.target.result);

				}
				reader.readAsDataURL(value.files[0]);

			}
		};
		function insertButton() {
			var deletImgArr = new Array();
			var imgArray = $('#content img');

			$('#imgNames').val(imgNamesArr);

			$('#trContentInput').val(
					document.getElementById('content').innerHTML);

			for (var i = 0; i < imgArray.length; i++) {
				deletImgArr[i] = imgArray.eq(i).attr('name');
			}
			$('#deletImg').val(deletImgArr);

			/* $('#insertForm').submit();  */
		};
	</script>

	<%-- <%
		}else{
			// 비회원일 경우
			request.setAttribute("msg", "회원만 가능한 서비스입니다.");
			request.getRequestDispatcher("../common/errorPage.jsp").forward(request, response);

		}
	%> --%>
	<%@ include file="../common/footer.jsp"%>

	<!-- <script type="text/javascript" src="../../resourse/js/trInsert.js" charset="UTF-8"></script>  -->
</body>
</html>