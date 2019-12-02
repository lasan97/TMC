<%@page import="com.kh.tmc.training.model.vo.TrainingPaging"%>
<%@page import="com.kh.tmc.training.model.vo.TrainingBoard"%>
<%@page import="com.kh.tmc.training.controller.TrInsertServlet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.tmc.member.model.vo.Member"%>
<%
	ArrayList<TrainingBoard> list = (ArrayList<TrainingBoard>) request.getAttribute("list");
	TrainingPaging pi = (TrainingPaging) request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TMC TEST Web</title>
<link rel="stylesheet" href="/tmc/resourse/css/rscss2.css"
	type="text/css">
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<div class="entry-content">
		<div class="rsBoard">
			<div id="rsTitleSelect">
				<div id="rsTitleButton">
					<p>훈련 정보 게시판</p>
				</div>
			</div>
			<hr>

			<div id="rsViewList">
				<%
					int divSwitch = 0;
					int pageCount = 1;
					int boardCount = 1;
				%>

				<%
					for (TrainingBoard trb : list) {
						if (boardCount >= 10) {
							break;
						}
						if (pageCount == 1) {
							divSwitch = 1;
				%>
				<div class="rsList">
					<%
						}
					%>
					<div class="thumb-list" align="center">
						<input type="hidden" value="<%=trb.getTrBno()%>"/>
						<div>
							<img src="/tmc/resourse/trainingImg/<%=trb.getTrImgName()%>">
						</div>
						<p style="font-size: 18px; border-bottom: 1px solid white; overflow: hidden;"><%=trb.getTrTitle()%></p>
						<div class="rsDataView">
							<p style="font-size: 12px"><%=trb.getTrWriter()%></p>
							<p class="ListData"><%=trb.getTrDate()%></p>
							<p class="ListData">
								No.<%=trb.getTrBoardNo()%></p>
						</div>
						<div class="rsLike">
							<img src="resourse/img/rs.png" style="width: 30px; height: 30px;">
							<p style="font-size: 8px;"><%=trb.getTrLike()%></p>
						</div>
						<div class="rsViewCount">
							<img src="resourse/img/i.png" style="width: 30px; height: 30px;">
							<p style="font-size: 8px;"><%=trb.getTrCount()%> 조회</p>
						</div>
					</div>

					<%
						if (pageCount >= 3) {
								divSwitch = 0;
					%>
				</div>
				<hr>
				<%
					pageCount = 1;
						} else {
							pageCount++;
							boardCount++;
						}
					}
					if (divSwitch == 1) {
				%>
			</div>
			<hr>
			<%
				}
			%>







		</div>
	




	</div>
	<div id="rsBoardManager">


		<ul id="trPagingNum" style="margin-bottom: 0rem;">

			<li><a class="rsPage"
				onclick="location.href='<%=request.getContextPath()%>/trSelectList.tr?currentPage=<%=currentPage - 1%>'">&lt;</a></li>

			<%
				for (int p = startPage; p <= endPage; p++) {
					if (p == currentPage) {
			%>
			<li><a class="rsPage" style="color: gray;"><%=p %></a></li>
			<%
				} else {
			%>
			<li><a class="rsPage" onclick="location.href='<%= request.getContextPath() %>/trSelectList.tr?currentPage=<%= p %>'"><%= p %></a></li>
			<%
				}
				}
			%>

			<li><a class="rsPage" onclick="location.href='<%= request.getContextPath() %>/trSelectList.tr?currentPage=<%=currentPage + 1 %>'">&gt;</a></li>
		</ul>

	<form action="<%=request.getContextPath()%>/trSearch.tr">
		<div id="rsBoardSearch">
			<select id="trSearchType" class="rsselect" style="height: 29px;">
				<option value="제목">제목</option>
				<option value="작성자">작성자</option>
			</select> <input type="text" name="rsTitleSearch" id="rsTitleSearch">
			<button type="submit">검색하기</button>
		</div>
		<div style="display:none;">
		<input type=number name="serachType" id="serachType" value="1">
		</div>
		</form>
	
		<button onclick="location.href='<%= request.getContextPath()%>/views/Training/indexRsBoardInsert.jsp'"
			id="rsBoardInsert">글쓰기</button>

	</div>
	</div>
	<script>
	$(function(){
		
		$('.thumb-list').click(function(){
			var bno = $(this).find("input").val();
			location.href="<%=request.getContextPath()%>/trSelectOne.tr?bno=" + bno; 
		});
		
		$('#trSearchType').change(function() {
			var result = document.getElementById('trSearchType').value;
			if(result=="제목"){
				$('#serachType').val("1");
				
			}else{
				$('#serachType').val("2");
				
				
			}
			/* $('#serachType').val(1); */
			
		});
	});
	
	</script>
	
	
	<!-- <div class="section_divide"></div> -->

	<%@ include file="../common/footer.jsp"%>

<!-- 	 <script type="text/javascript" src="/tmc/resourse/js/trList.js" charset="UTF-8"></script>  -->
</body>
</html>