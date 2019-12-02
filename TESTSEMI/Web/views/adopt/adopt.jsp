<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
    <title>TMC 닷컴</title>
    <link rel="stylesheet" href="/tmc/resourse/css/tmc.css">
    <script src="/tmc/resourse/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="/rstest1/resourse/css/business-ipyang2.css" >
    <!-- 부트스트랩 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/views/common/header.jsp"%>

<div class="entry-content">
<!-- MemberName에 각자 이름 기재바람 -->
	<section class="section1_background_singup_hongsuk">
		<div>                  
 			<h2>입양하기</h2>
		</div>
		<br>
            
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
		
		<div class="gallery_ga">
		    <ul>
		        <li class="gallery_list">                
		            <dl>
		                <dt>
		                    <!-- <a href="#"> -->
		                    <img class="img-ga" src="/rstest1/resourse/img/main-img3.jpg">
		                    <!-- </a> -->
		                </dt>
		                <dd>
		                    <dl>                            
		                        <dd>제목 : 귀여운 냥이 업어가세요</dd>                            
		                        <dd>등록일 : 2019.06.30</dd>
		                    </dl>
		                </dd>
		            </dl>
		            <dl>
		                <dt>
		                    <img class="img-ga" src="/rstest1/resourse/img/main-img3.jpg">
		                </dt>
		                <dd>
		                    <dl>
		                        <dd>제목 : 귀여운 강지 업어가세요</dd>                            
		                        <dd>등록일 : 2019.06.30</dd>
		                    </dl>
		                </dd>
		            </dl>
		        </li>
		        <li class="gallery_list">                
		            <dl>
		                <dt>
		                    <!-- <a href="#"> -->
		                    <img class="img-ga" src="/rstest1/resourse/img/main-img3.jpg">
		                    <!-- </a> -->
		                </dt>
		                <dd>
		                    <dl>                            
		                        <dd>제목 : 귀여운 냥이 업어가세요</dd>                            
		                        <dd>등록일 : 2019.06.30</dd>
		                    </dl>
		                </dd>
		            </dl>
		            <dl>
		                <dt>
		                    <img class="img-ga" src="/rstest1/resourse/img/main-img3.jpg">
		                </dt>
		                <dd>
		                    <dl>
		                        <dd>제목 : 귀여운 강지 업어가세요</dd>                            
		                        <dd>등록일 : 2019.06.30</dd>
		                    </dl>
		                </dd>
		            </dl>
		        </li>
		        
		    </ul>
		
		</div>                      
		<div class="mb-5">
		    <div class="bbt">
		        <input class="btn" type="button" value="목록" onclick="">
		        <input class="btn" type="button" value="글쓰기" onclick="">
		    </div>
		    <br><br>
		    <div>
		        <ul class="ip_pagination">
		            <li><a href="#">1</a></li>
		            <li><a href="#">2</a></li>
		            <li><a href="#">3</a></li>
		            <li><a href="#">4</a></li>
		            <li><a href="#">5</a></li>
		        </ul>
		    </div>          
		</div>
	</section>
</div>
<%@ include file="/views/common/footer.jsp"%>

</body>
</html>