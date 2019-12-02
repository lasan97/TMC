<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.kh.tmc.adoptWant.model.vo.*, java.util.*"%>
<%
	AdoptWant aw = (AdoptWant)request.getAttribute("aw");

	// 댓글 리스트
// 	ArrayList<AdoptWantComment> clist
// 	=(ArrayList<AdoptWantComment>)request.getAttribute("clist");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<style>
	.outer{
		width:800px;
		height:500px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	td {
		border:1px solid black;
		background : black;
		color: white;
	}

	.tableArea {
		border:1px solid black;
		background : white;
		color: black;
		width:800px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
	}
	#content {
		height:230px;
	}
	.replyArea {
		width:800px;
		color:white;
		background:black;
		margin-left:auto;
		margin-right:auto;
		padding-bottom : 5px;
	}
	.replyArea textArea {
		border-radius: 10px;
		resize: none;
	}
	a:link {
    	color: yellow;
	}
	a:active {
		color: aqua;
	}
	table[class*="replyList"] * {
		color: black;
		
	}
	.replyList1 td{	background : lavenderblush; }
	.replyList2 td{	background : honeydew; }
	.replyList3 td{ background : aliceblue; }
</style>
<title>입양 소원하기 게시글 상세보기</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
	<% if(m != null ) { %>
	<div class="outer">
		<br>
		<h2 align="center">게시글 내용</h2>
		<div class="tableArea">
				<table align="center" width="800px">
					<tr>
						<td>제목 </td>
						<td colspan="5"><span><%= aw.getWiTitle() %><input name="wiTitle" type="hidden" value="<%= aw.getWiWriter() %>"/></span></td>
					</tr>
					<tr>
						<td>작성자 </td>
						<td><span><%= aw.getWiWriter() %></span></td>
						<td>작성일</td>
						<td><span><%= aw.getWiWriteDate() %></span></td>
						<td>조회수 </td>
						<td><span><%= aw.getWiCount() %></span></td>
					</tr>
					<% if(aw.getWiFileName() != null && aw.getWiFileName().length() > 0) { %>
					<tr>
						<td>첨부파일 </td>
						<td colspan="5">
							<a href="/myWeb/bfdown.bo?path=<%=aw.getWiFileName() %>">
							<%-- <a href="/myWeb/resources/boardUploadFiles/<%=b.getBoardfile() %>"
							   download="<%= b.getBoardfile() %>"> --%>
							<%=aw.getWiFileName() %>
							</a>
						</td>
					</tr>
					<% } %>
					<tr>
						<td colspan="6">내용 </td>
					</tr>
					<tr>
						<td colspan="6">
							<p id="wiContent"><%= aw.getWiContent() %>
						</td>
					</tr>
				</table>
				<br>
		</div>
		<div align="center">
			<button onclick="location.href='<%= request.getContextPath() %>/listAdoptW.ado'">메뉴로 돌아가기</button>
			<% if(m != null && m.getUserId().equals(aw.getWiWriter())){ %>
			<button onclick="location.href='<%= request.getContextPath() %>/uAdoptWViwe.ado?wiBno='+<%=aw.getWiBno()%>">수정하기</button>
			<% } %>
		</div>
		<!-- 댓글 영역 -->
		<div class="replyArea">
			<div class="replyWriteArea">
				<form action="/myWeb/insertComment.bo" method="post">
					<input type="hidden" name="writer" value="<%=m.getUserId()%>"/>
					<input type="hidden" name="bno" value="<%=aw.getWiBno() %>" />
					<input type="hidden" name="refcno" value="0" />
					<input type="hidden" name="clevel" value="1" />
					
					<table align="center">
						<tr>
							<td>댓글 작성</td>
							<td><textArea rows="3" cols="80" id="replyContent" name="replyContent"></textArea></td>
							<td><button type="submit" id="addReply">댓글 등록</button></td>
						</tr>
					</table>
				</form>
			</div>
			<div id="replySelectArea">
			<%-- 
			<!-- 게시글의 댓글들을 보여주는 부분  -->
			<% if (clist != null) { %>
				<% for(BoardComment bco : clist) { %>
				
				<table id="replySelectTable"
	      	 style="margin-left : <%= (bco.getClevel()-1) * 15 %>px;
	      	 		width : <%= 800 - ((bco.getClevel()-1) * 15)%>px;"
	      	 class="replyList<%=bco.getClevel()%>">
		  		<tr>
		  			<td rowspan="2"> </td>
					<td><b><%= bco.getCwriter() %></b></td>
					<td><%= bco.getCdate() %></td>
					<td align="center">
 					<%if(m.getUserId().equals(bco.getCwriterId())) { %>
						<input type="hidden" name="cno" value="<%=bco.getCno()%>"/>
							  
						<button type="button" class="updateBtn" 
							onclick="updateReply(this);">수정하기</button>
							
						<button type="button" class="updateConfirm"
							onclick="updateConfirm(this);"
							style="display:none;" >수정완료</button> &nbsp;&nbsp;
							
						<button type="button" class="deleteBtn"
							onclick="deleteReply(this);">삭제하기</button>
							
					<% } else if( bco.getClevel() < 3) { %>
						<input type="hidden" name="writer" value="<%=m.getUserId()%>"/>
						<input type="hidden" name="refcno" value="<%= bco.getCno() %>" />
						<input type="hidden" name="clevel" value="<%=bco.getClevel() %>" />
						<button type="button" class="insertBtn" 
							 onclick="reComment(this);">댓글 달기</button>&nbsp;&nbsp;
							 
						<button type="button" class="insertConfirm"
							onclick="reConfirm(this);"
							style="display:none;" >댓글 추가 완료</button> 
							
					<% } else {%>
						<span> 마지막 레벨입니다.</span>
					<% } %>
					</td>
				</tr>
				<tr class="comment replyList<%=bco.getClevel()%>">
					<td colspan="3" style="background : transparent;">
					<textarea class="reply-content" cols="105" rows="3"
					 readonly="readonly"><%= bco.getCcontent() %></textarea>
					</td>
				</tr>
			</table>
			
			<% } } else { %>
			<p>현재 등록된 댓글이 없습니다.<br>
			   첫 댓글의 주인공이 되어 보세요!</p>
			<% } %>
			</div>
		</div>
		<!-- 댓글 영역 --> --%>
		<script>
			function deleteReply(obj){
				// 댓글의 번호 가져오기
				var cno = $(obj).siblings('input').val();
				
				//게시글 번호 가져오기
				var wiBno = '<%=aw.getWiBno() %>';
				
				location.href="/myWeb/deleteComment.bo"
				+"?cno="+cno+"&wiBno="+wiBno;
				
			}
				
		
			function updateConfirm(obj){
				
				// 댓글의 내용 가져오기
				var content
				  =$(obj).parent().parent().next().find('textarea').val();
				
				// 댓글의 번호 가져오기
				var cno = $(obj).siblings('input').val();
				
				//게시글 번호 가져오기
				var wiBno = '<%=aw.getWiBno() %>';
				
				location.href="/myWeb/updateComment.bo?"
				 	+"cno="+cno+"&bno="+bno+"&content="+content;
				
				
			}
		
		
		
			function updateReply(obj){
				// 현재 위치와 가장 근접한 textarea 접근
				$(obj).parent().parent().next().find('textarea').removeAttr('readonly');
				
				// 수정완료 버튼을 화면 보이기
				$(obj).siblings('.updateConfirm').css('display','inline');
				
				// 수정하기 버튼 숨기기
				$(obj).css('display','none');
				
				
				
				
			}
			
		
		
		
		
		
			function reComment(obj){
				// 추가 완료 버튼을 화면 보이게 하기
				$(obj).siblings('.insertConfirm').css('display', 'inline');
				
				// 클릭한 버튼 숨기기
				$(obj).css('display', 'none');
				
				// 내용 입력 공간 만들기
				var htmlForm = 
					'<tr class="comment"><td></td>'
						+'<td colspan="3" style="background : transparent;">'
						+ '<textarea class="reply-content" style="background : ivory;" cols="105" rows="3"></textarea>'
						+ '</td>'
				    + '</tr>';
					
				$(obj).parents('table').append(htmlForm);
				
				}
			function reConfirm(obj){
				// 댓글의 내용 가져오기
				
				// 참조할 댓글의 번호를 가져오기
				var refcno = $(obj).siblings('input[name="refcno"]').val();
				
				var level = Number($(obj).siblings('input[name="clevel"]').val()) +1;
				
				// 게시글 번호 가저오기
				var wiBno = '<%=aw.getWiBno()%>';
				
				var parent = $(obj).parent();
				var grandparent = parent.parent();
				var siblingTR = grandparent.siblings().last();
				
				var content = siblingTR.find('textarea').val();
				
				location.href = '/myWeb/insertComment.bo'
						+ '?writer=<%= m.getUserId() %>'
						+ '&replyContent=' + content
						+ '&bno='+bno
						+ '&refcno='+refcno
						+ '&clevel='+level;
				
				
				
				
			}
		
		
		</script>
		
	</div>
	<% } else {
		request.setAttribute("msg", "회원만 가능한 서비스 입니다.");
		request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
	}
	%>
</body>
</html>