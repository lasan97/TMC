<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.tmc.adoptWant.model.vo.*, java.util.*"%>
<% 
	ArrayList<AdoptWant> list = (ArrayList<AdoptWant>)request.getAttribute("list"); 
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
    <title>TMC 닷컴</title>
    <link rel="stylesheet" href="/tmc/resourse/css/tmc.css">
    <script src="/tmc/resourse/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="/tmc/resourse/css/adoptWant.css" >
    <!-- 부트스트랩 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
<div class="entry-content">
	<section>                       
    <div>
        <h2>입양 소원하기</h2>
    </div>
    <br>
      
    
    <!-- Page Content -->
	<div>
	    <div class="ip_search_box">
	        <div class="ip_search">
	            <span>검색항목</span>
	            <select id="search_type" name="search_type" onchange="javascript:change();">
	                <option value="A">전체</option>
	                <option value="M">작성자</option>
	                <option value="T">제목</option>
	                <option value="C">내용</option>
	            </select> 
	            <span><input type="text" size="15" id="search_text" name="search_text" onkeydown="on_enter(event)"/></span>
	            <input type="button" value="검색" onclick="search('1');"/>
	        </div>
	    </div>
	    <br>
	    <div>
	    <!-- <div class="mb-5"> -->
	        <table class="ip_ga_table" >
	                <tr>
	                    <th>번호</th>                        
	                    <th>제목</th>
	                    <th>작성자</th>
	                    <th>날짜</th>
	                    <th>조회수</th>
	                </tr>
	                <% for(AdoptWant aw : list){ %>
	                <tr>
	                	<%-- <input type="hidden" value="<%= aw.getWiBno() %>"/> --%>
	                    <td><%=aw.getWiBno()%></td>
	                    <td><%=aw.getWiTitle()%></td>
	                    <td><%=aw.getWiWriter()%></td>
	                    <td><%=aw.getWiWriteDate()%></td>
	                    <td><%=aw.getWiCount()%></td>
	                </tr>
	                <% } %>
	                
	        </table>
	    </div>
    
    	<div class="mb-5">
	        <div class="ip_bbt">
	            <input class="btn" type="button" value="글쓰기" onclick="location.href='/tmc/views/adoptWant/adoptWantWrite.jsp'">
	        </div>
	        <br>
	        <br>
	        <div>
<!-- 	            <ul class="ip_pagination"> -->
<!-- 	                <li><a href="#">1</a></li> -->
<!-- 	                <li><a href="#">2</a></li> -->
<!-- 	                <li><a href="#">3</a></li> -->
<!-- 	                <li><a href="#">4</a></li> -->
<!-- 	                <li><a href="#">5</a></li> -->
<!-- 	            </ul> -->
			<button onclick="location.href='<%= request.getContextPath() %>/listAdoptW.ado?currentPage=1'"> << </button>
			<%  if(currentPage <= 1){  %>
			<button disabled></button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/listAdoptW.ado?currentPage=<%=currentPage - 1 %>'"><</button>
			<%  } %>
			
			<% for(int p = startPage; p <= endPage; p++){
					if(p == currentPage){	
			%>
				<button disabled><%= p %></button>
			<%      }else{ %>
				<button onclick="location.href='<%= request.getContextPath() %>/listAdoptW.ado?currentPage=<%= p %>'"><%= p %></button>
			<%      } %>
			<% } %>
				
			<%  if(currentPage >= maxPage){  %>
			<button disabled>></button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/listAdoptW.ado?currentPage=<%=currentPage + 1 %>'"> > </button>
			<%  } %>
			<button onclick="location.href='<%= request.getContextPath() %>/listAdoptW.ado?currentPage=<%= maxPage %>'"> >> </button>
			

	        </div>          
    	</div>
	</div>
	</section>
</div>

<script>
		$(function(){
			$(".ip_ga_table td").mouseenter(function(){
				$(this).parent().css({"background":"darkgray", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"white"});
			}).click(function(){
				var wiBno = $(this).parent().children().eq(0).text();
				location.href="<%=request.getContextPath()%>/soAdoptW.ado?wiBno=" + wiBno;
			});
		});
	</script>
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>