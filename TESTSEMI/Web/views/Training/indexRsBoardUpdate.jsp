<%@page import="java.util.*"%>
<%@page import="com.kh.tmc.training.model.vo.TrainingBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.tmc.member.model.vo.Member"%>
    <%
    	Member mb = (Member)session.getAttribute("member"); 
    	TrainingBoard t = (TrainingBoard)request.getAttribute("TrainingBoard");

    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TMC TEST Web</title>
    <link rel="stylesheet" href="/tmc/resourse/css/rsupdatecss.css" type="text/css">
</head>
<body>
	<%@ include file="../common/header.jsp" %>


 <div class="entry-content">
			<form action="<%= request.getContextPath() %>/trUpdateSave.tr?bno=<%=t.getTrBno()%>"
				method="post" enctype="multipart/form-data" id="insertForm">
				<div style="display:none;">
				<input type="file" name="trMainImg" id="trMainImg"
						onchange='trMainImgChange(this);' value="resourse/trainingImg/<%=t.getTrImgName()%>">
				<input type="text" name="UpMainImg" id="UpMainImg"
						 value="<%=t.getTrImgName()%>">
						<input type="text"
						name="imgNames" id="imgNames"> <input type="text"
						name="deletImg" id="deletImg">
		
				</div>
          <div class="rsBoard">
          <input type="hidden" name="content" id="trContentInput" value=''>

            <div id="rsInsertBoard">
               	<ul id="test2" style="	list-style: none;">
               
                 
					<li>            
                <div id="rsTitleBar">
                    <p class="rsListTitle"><input type="text" name="boardT" id="boardT" required="required"
							value="<%=t.getTrTitle() %>" maxlength="20"></p>
                </div>
                </li>
                  <li>
                   <div id="mainImg"> 
						<img id="mainImgView" name="<%=t.getTrImgName()%>" src="resourse/trainingImg/<%=t.getTrImgName()%>"
							style="cursor: pointer;"> <a>대표이미지</a>
					</div>
                   </li>
				</ul>
             
            </div>
            <hr>
            <div id="rsServicesBar">
					<button type="button" id="rsInsertImg">이미지 넣기</button>

				</div>
            <div id="content" class="fr-element fr-view" dir="ltr"
					contenteditable="true" style="min-height: 300px;"
					aria-disabled="false" spellcheck="true">
				
	            <%=t.getTrContent() %>
				</div>
            </div>
            <hr>
            <div style="float: right; margin-right: 15px;">
            <button onclick="saveButton();">저장하기</button>
            </div>
		  	</form>
        </div>
  
    </div>
    			<form id="ajaxform" action="<%=request.getContextPath()%>/tInsert.tn"
				method="post" enctype="multipart/form-data">
				<ul id="TrImgInputs" style="display: none;">
					<li><input type='file' name='trImgFile' id='trImgFile'
						onchange='trInputChange(this);' /></li>
				</ul>
			</form>
    <script>    
    var imgNamesArr = new Array();

	var imgNum = 0;
	var imgCount = 1;
    	function saveButton(){
    		$('#trContentInput').val(
					document.getElementById('content').innerHTML);
    		
    		$('#insertForm').submit();
    	}
    	
		$(function() {
			$('#mainImgView').click(function() {
				$("#trMainImg").click();
			});
		});
		function trMainImgChange(value) {
			if (value.files && value.files[0]) {

				var reader = new FileReader();

				reader.onload = function(e) {

					$('#mainImgView').attr('src', e.target.result);

				}
				reader.readAsDataURL(value.files[0]);
			}
			$('#UpMainImg').val("N");
		};
		
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
											"<img src='resourse/trainingImg/"+data.imgName+"' name="+data.imgName+" id='trContentImg'>")
							imgNamesArr[imgNum] = data.imgName;
							imgNum++;

							/* console.log($('#trContentImg')[0].attr(src)); */
						},
						error : function(data) {

						}

					});
			imgCount++;


		};
  
    </script>
    
	<%@ include file="../common/footer.jsp" %>
	
	<!-- <script type="text/javascript" src="../../resourse/js/trUpdate.js" charset="UTF-8"></script>  -->
</body>
</html>