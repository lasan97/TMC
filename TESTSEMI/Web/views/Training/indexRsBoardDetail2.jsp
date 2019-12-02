<%@page import="com.kh.tmc.training.model.vo.TrainingBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.tmc.member.model.vo.Member"%>
    <%
    	
    	Member mb = (Member)session.getAttribute("member"); 
    	TrainingBoard t = (TrainingBoard)request.getAttribute("TrainingBoard");
    	
    	String likeStr = t.getTrLikers();
    	String user = t.getTrWriter();
    	String[] likeArr = likeStr.split(",");
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TMC TEST Web</title>
    <link rel="stylesheet" href="/tmc/resourse/css/rsdetailcss.css" type="text/css">
</head>
<body>
	<%@ include file="views/common/header.jsp" %>

	

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
                        <img  onclick="rslike();" src="resourse/img/rs.png"
                            style="width: 30px; height: 30px; cursor: pointer;">
                        <p id="trLike" style="font-size: 8px;"><%=t.getTrLike() %></p>
                       
                    </div>
                </div>
                <div id="rsTitleBar">
                    <p class="rsListTitle"><%=t.getTrTitle() %></p>
                </div>
             
            </div>
            <hr>
            <div class="board_txt_area fr-view">
	            <%=t.getTrContent() %>
                <div class="file_area"></div>
            </div>
            <hr>
        </div>
  
    </div>
    <script>
	<% String oldStr=t.getTrLikers();
		String newStr="";
		String A = "";
		String B = "";
	%>
	
	var result = 1;
    	function rslike(){
    		var resultStr= "";
					
				
    	   	<% for(int i=0;i<likeArr.length;i++){ 
   				if(likeArr[i].equals(user)){
   					if(!likeArr[i].equals(t.getTrWriter())){
						newStr+=likeArr[i];
					}
					if(i>0&&i<likeArr.length-1){
						newStr+=",";
					}
   				%>
   				
    	   		result=0;
    	   		<%}else{%>
    	   		result=1;
    	   		<%} }%>
    	   		
    	   		if(result==1){
        	   		console.log("중복없음");
        	   		<%oldStr+=","+user;%>
        	   		resultStr ="<%=oldStr%>";
    	   		}else{
    	   			console.log("중복있음");
    	   			
    	   			<%for(int i=0;i<likeArr.length;i++){
						if(!likeArr[i].equals(t.getTrWriter())){
							newStr+=likeArr[i];
						}
						if(i>0&&i<likeArr.length-1){
							newStr+=",";
						}
					} t.setTrLikers(newStr);%>
					resultStr="<%=newStr%>";
    	   		
    	   		}
    	   		
    	   		
    	   		
    	   		console.log("유저");
    	   		console.log("<%=user%>");
    	   		
    	   		
    				
    
    	
    	
    		$.ajax({
				url : "/tmc/trLiker.tr",
				type : "get",
				data : {bno : <%= t.getTrBno() %>,    		
    				likers :resultStr,
    				st : result,
    				test : "<%=user%>"
				},
				success : function(data) {
					
				},
				error : function(data) {
				}
			});  
    		if(result==1) result=0;
    		else result=1;
    	
    	}
    </script>
    
	<%@ include file="views/common/footer.jsp" %>
	
	    <!-- <script type="text/javascript" src="resourse/js/rsjss.js" charset="UTF-8"></script> -->
</body>
</html>