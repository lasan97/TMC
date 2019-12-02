<%@page import="java.util.Arrays"%>
<%@page import="com.kh.tmc.training.model.vo.TrainingBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.tmc.member.model.vo.Member"%>
<%
	Member mb = (Member) session.getAttribute("member");
	TrainingBoard t = (TrainingBoard) request.getAttribute("TrainingBoard");
	String likeName = t.getTrLikers().replace("[", "").replace("]", "");
	String userName = "";
	if (mb != null) {
		userName = mb.getUserId();
	}
	
	boolean check = true;
	String[] likeList = likeName.split(",");
	for (int i = 0; i < likeList.length; i++) {
		if (likeList[i].equals(userName)) {
			check = false;
		}
	    if (likeList[i] == "") {
	        for (int j =0; j < likeList.length-1; j++) {
	        	likeList[j] = likeList[j+1];
	        }
	        break;
	    }

	}

	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TMC TEST Web</title>
<link rel="stylesheet" href="/tmc/resourse/css/rsdetailcss.css"
	type="text/css">
</head>
<body>
	<%@ include file="../common/header.jsp"%>



	<div class="entry-content">
		<div class="rsBoard">

			<div id="rsInsertBoard">
				<div style="width: 100px; height: auto;" class="rs-boardData">
					<p id="rsUserId">admin</p>
					<div>
						<p><%=t.getTrDate()%></p>
					</div>
					<div>
						<p><%=t.getTrCount()%></p>
					</div>
					<div>
						<img onclick="rslike();" src="/tmc/resourse/img/rs.png"
							style="width: 30px; height: 30px; cursor: pointer;">
						<p id="trLike" style="font-size: 8px;"><%=t.getTrLike()%></p>
					</div>


				</div>
				<div id="rsTitleBar">
					<p class="rsListTitle"><%=t.getTrTitle()%></p>
				</div>

			</div>
			<hr>
			<div class="board_txt_area fr-view">
				<%=t.getTrContent()%>
				<div class="file_area"></div>
			</div>
			<hr>
			 <% if(userName.equals(t.getTrWriter())){ %>
			<div style="float: right; margin-right: 15px;">
				<button
					onclick="location.href='<%=request.getContextPath()%>/trUpdate.tr?bno=<%=t.getTrBno()%>'">수정하기</button>
				<button
					onclick="location.href='<%=request.getContextPath()%>/trDelete.tr?bno=<%=t.getTrBno()%>'">삭제하기</button>
			</div>
			<%} %> 
		</div>

	</div>
	<script>
	var test =<%=check%>;
	var likeCount =<%= t.getTrLike()%>;
	var UpOnDown=1;
	function rslike() {
		var userName = "<%=userName%>";
		var likers ="";

		<%String result ="";%>
		if(userName!=""){
			
			if(test){
		
				<%result =Arrays.toString(likeList);
					result = result.replace("[","").replace("]","");
					result +=","+userName;
					check=false;%>
				UpOnDown =1;
				likers ="<%=result.replace(" ", "")%>";
				test=false;
				<% t.setTrLike(t.getTrLike()+1);%>
				likeCount++;
				
			}else{

				
				<% result =Arrays.toString(likeList);
				   result= result.replace(userName,"");
				   result= result.replace("[","").replace("]","");
					check=true;%>
				likers="<%=result.replace(" ", "")%>";
				UpOnDown =0;
				test=true;
				<% t.setTrLike(t.getTrLike()-1);%>
				likeCount--;
			}
		
		$.ajax({
			url : "/tmc/trLiker.tr",
			type : "get",
			data : {bno : <%= t.getTrBno() %>,    		
				likers :likers,
				UpOnDown :UpOnDown
			
			},
			success : function(data) {
				<%if(check)t.setTrLikers(result);
				else t.setTrLikers(result);%>
				$('#trLike').text(likeCount);
			},
			error : function(data) {
			}
		});  
		}else{
			alert("로그인 후 이용 가능한 기능");
		} 
	}
	</script>

	<%@ include file="../common/footer.jsp"%>

	<!-- <script type="text/javascript" src="resourse/js/rsjss.js" charset="UTF-8"></script> -->
</body>
</html>