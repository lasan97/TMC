<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.tmc.adoptWant.model.vo.*" %>
    <% AdoptWant aw = (AdoptWant)request.getAttribute("aw"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<style>
	.outer{
		width:800px;
		height:700px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	table {
		border:1px solid white;
	}

	.tableArea {
		width:450px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
	}
</style>
<title>공지 사항 수정</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<% if(m != null && m.getUserId().equals(aw.getWiWriter())){ %>
	<div class="outer">
		<br>
		<h2 align="center">게시글 수정</h2>
		<div class="tableArea">
			<form id="updateForm" method="post">
				<table>
					<tr>
						<td>제목 </td>
						<td colspan="3">
							<input type="text" size="50" name="wiTitle" 
							       value="<%= aw.getWiTitle().replace("\"", "&#34;") %>">
							<input type="hidden" name="wiBno" value="<%= aw.getWiBno() %>">
						</td>
					</tr>
					<tr>
						<td>작성자 </td>
						<td>
							<input type="text" value="<%= aw.getWiWriter() %>" name="writer" readonly>
						</td>
					</tr>
					<tr>
						<td>내용 </td>
					</tr>
					<tr>
						<td colspan="4">
							<textarea name="wiContent" cols="60" rows="15" style="resize:none;"><%= aw.getWiContent() %></textarea>
						</td>
					</tr>
				</table>
				<br>
				<div align="center">
					<button onclick="complete();">작성완료</button>
					<button onclick="deleteNotice();">삭제하기</button>
				</div>
				<script>
					function complete(){
						$("#updateForm").attr("action","<%=request.getContextPath() %>/uAdoptW.ado");
						
					}
					
					function deleteNotice(){
						// delete 는 예약어 이므로 deleteNotice 로 ...!
						$("#updateForm").attr("action","<%=request.getContextPath() %>/dAdoptW.ado");
					}
				
				</script>
			</form>
			
		</div>
	</div>
	<% } else {
		request.setAttribute("msg", "관계자 외에 접근이 불가능한 페이지입니다.");
		request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
	 } %>
	<%@ include file="../common/footer.jsp" %>