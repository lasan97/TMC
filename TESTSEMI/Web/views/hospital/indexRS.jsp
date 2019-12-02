<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.tmc.member.model.vo.Member"%>
    <%
    	
    	Member mb = (Member)session.getAttribute("member"); 
    	String str1="";
    	
    	if(mb!=null){
    		System.out.println(1);
    		String str[] = mb.getUserAddress().split(" ");
    	str1 = str[0];
    	str1 +=str[1];
    	}else{
    		System.out.println(2);
    	str1="서울";
    	}
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TMC TEST Web</title>
    <link rel="stylesheet" href="/tmc/resourse/css/rscss.css" type="text/css">
</head>
<body>
	<%@ include file="../common/header.jsp" %>
 <div class="entry-content">
        <!-- MemberName에 각자 이름 기재바람 -->
                  <select id="rssearchresult">
                          <option value=<%=str1%>>1</option>
                  </select>
          
          <!-- <div id="rsbody">11</div> -->
             <div id="rsbody">
          
              <div id="rsview">
                <div id="hd">
                  <div id="sdTag">
                    <div class="slide_img">
                      <div ><img src="../../resourse/img/rs1.jpg" class="rsimg" alt="이미지1"></div>
                      <div ><img src="../../resourse/img/rs2.jpg" class="rsimg" alt="이미지2"></div>
                      <div ><img src="../../resourse/img/rs3.jpg" class="rsimg" alt="이미지3"></div>
                      <div ><img src="../../resourse/img/rs4.PNG" class="rsimg" alt="이미지4"></div>
                      <div ><img src="../../resourse/img/rs5.PNG" class="rsimg" alt="이미지5"></div>
                      <div ><img src="../../resourse/img/rs6.PNG" class="rsimg" alt="이미지6"></div>
                      <div ><img src="../../resourse/img/rs7.PNG" class="rsimg" alt="이미지7"></div>
                    </div>
                  </div>
                  <div id="rsSearchTag">
                    <ul>
                      <li class="rsSearcTagC">
                        <select class="rsselect" id="rsselectCity" onchange="RsChange();">
                          <option value="">전체</option>
                          <option value="서울">서울시</option>
                          <option value="경기도">경기도</option>
                          <option value="부산">부산시</option>
                          <option value="대구">대구시</option>
                          <option value="인천">인천시</option>
                          <option value="광주">광주시</option>
                          <option value="대전">대전시</option>
                          <option value="경남">경상남도</option>
                          <option value="경북">경상북도</option>
                          <option value="전남">전라남도</option>
                          <option value="전북">전라북도</option>
                          <option value="충남">충청남도</option>
                          <option value="충북">충청북도</option>
                          <option value="강원도">강원도</option>
                          <option value="울산">울산시</option>
                          <option value="제주도">제주도</option>
                          <option value="세종시">세종시</option>
                          
                        </select>
                      </li>
          			
                      <li class="rsSearcTagC">
                        <select class="rsselect" id="rsselectGu">
                          <option value="">전체</option>
                        </select>
                      </li>
          
                      <li class="rsSearcTagbtn">
                        <form onsubmit="searchPlaces(); return false;">
                          <button type="submit" class="rsselect">검색</button>
                        </form>
                      </li>
                    </ul>
          
          
                  </div>
                </div>
                <div id="rsSearch">
          
                  <div id="searchList">
                    <div id="menu_wrap" class="bg_white">
          
          
                      <ul id="placesList"></ul>
                      <div id="pagination"></div>
                    </div>
                  </div>
          
                  <div id="mapView">
                    <div id="map" style="z-index0; width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
          
                  </div>
                </div>
          
              </div>
          
            
            </div> 

  
    </div>
	<%@ include file="../common/footer.jsp" %>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=caec3a1c9d432ca001177f6b90107bbf&libraries=services"></script>
	    <script type="text/javascript" src="../../resourse/js/rsjss.js" charset="UTF-8"></script>
</body>
</html>