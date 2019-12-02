
// RS script
var slides = $(".slide_img").find(" div");
var count = 0;
var slideCount = slides.length;
var nextIndex = 0;
var mapCount=0;
$(document).ready(function() {
	slides.eq(nextIndex).addClass('imgon');
	// slides.fadeOut();
	// slides.eq(nextIndex).fadeIn();
//	$('#placesList .item').hover(function() {
//		$(this).addClass('on');
//		$(this).siblings().removeClass('on');
//	}, function() {
//		$(this).removeClass('on');
//	});
});

var timer = setInterval(function showNext() {
	count++;
	if (count > 5) {
		slides.eq(nextIndex).addClass('imgon');
		count = 0;
	} else if (count > 4) {
		slides.eq(nextIndex).removeClass('imgon');
		nextIndex++;
		if (nextIndex > slideCount - 1) {
			nextIndex = 0;
		}
	}
}, 500);


// var inter = setInterval(function showNext() {
// count++;
// if (count > 4) {
// slides.eq(nextIndex).addClass('on');
// slides.eq(nextIndex).fadeIn(500);
// count = 0;
// } else if (count > 3) {
// slides.eq(nextIndex).removeClass('on');
// slides.eq(nextIndex).fadeOut(1000);
// nextIndex++;
// if (nextIndex > slideCount - 1) {
// nextIndex = 0;
// }
// }
// }, 1000);
	var Seoul = ["종로구","중구","용산구","성동구","광진구","동대문구","중랑구","성북구","강북구","도봉구","노원구","은평구","서대문구","마포구","양천구","강서구","구로구","금천구","영등포구","동작구","관악구","서초구","강남구","송파구","강동구"];
	var Incheon= ["중구","동구","남구","연수구","남동구","부평구","계양구","서구","강화군","옹진군"];
	var Gyeonggi= ["수원시","고양시","성남시","용인시","부천시","안산시","남양주시","안양시","화성시","평택시","의정부시","시흥시","파주시","김포시","광명시","광주시","군포시","오산시","이천시","양주시","안성시","구리시","포천시","의왕시","하남시","여주시","양평군","동두천시","과천시","가평군","연천군"];
	var Busan = ["중구","서구","동구","영도구","부산진구","동래구","남구","북구","해운대구","사하구","금정구","강서구","연제구","수영구","사상구","기장군"];
	var Gyeongbuk= ["포항시","경주시","김천시","안동시","구미시","영주시","영천시","상주시","문경시","경산시","군위군","의성군","청송군","영양군","영덕군","청도군","고령군","성주군","칠곡군","예천군","봉화군","울진군","울릉군"];
	var Gyeongnam= ["창원시","진주시","통영시","사천시","김해시","밀양시","거제시","양산시","의령군","함안군","창녕군","고성군","남해군","하동군","산청군","함양군","거창군","합천군"];
	var Daegu= ["중구","동구","서구","남구","북구","수성구","달서구","달성군"];
	var Jeollanam= ["목포시","여수시","순천시","나주시","광양시","담양군","곡성군","구례군","고흥군","보성군","화순군","장흥군","강진군","해남군","영암군","무안군","함평군","영광군","장성군","완도군","진도군","신안군"];
	var Jeollabuk= ["전주시","군산시","익산시","정음시","남원시","김제시","완주군","진안군","무주군","장수군","임실군","순창군","고창군","부안군"];
	var Chungnam= ["천안시","공주시","보령시","아산시","서산시","논산시","계룡시","당진시","금산군","부여군","서천군","청양군","홍성군","예산군","태안군"];
	var Chungbuk= ["청주시","충주시","제천시","보온군","옥천군","영동군","증평군","진천군","괴산군","음성군","단양군"];
	var Gangwon= ["춘천시","원주시","강릉시","동해시","태백시","속초시","삼척시","홍천군","횡성군","영월군","평창군","정선군","철원군","화천군","양구군","인제군","고성군","양양군"];
	var Gwangju= ["동구","서구","남구","북구","광산구"];
	var Daejeon= ["동구","중구","서구","유성구","대덕구"];
	var Ulsan= ["중구","남구","동구","북구","울주군"];
	var Sejong= [];
	var Jeju= ["제주시","서귀포시"];
	
	function RsChange(){
		var rselect = document.getElementById('rsselectCity').value;
		var rsItem;
		switch(rselect){
		case "서울":rsItem=Seoul; break;
		case "경기도":rsItem=Gyeonggi; break;
		case "부산":rsItem=Busan; break;
		case "대구":rsItem=Daegu; break;
		case "인천":rsItem=Incheon; break;
		case "광주":rsItem=Gwangju; break;
		case "대전":rsItem=Daejeon; break;
		case "경남":rsItem=Gyeongnam; break;
		case "경북":rsItem=Gyeongbuk; break;
		case "전남":rsItem=Jeollanam; break;
		case "전북":rsItem=Jeollabuk; break;
		case "충남":rsItem=Chungnam; break;
		case "충북":rsItem=Chungbuk; break;
		case "강원도":rsItem=Gangwon; break;
		case "울산":rsItem=Ulsanbreak;break;
		case "제주도":rsItem=Jeju; break;
		default :rsItem=Sejong; break;
		}
		$('#rsselectGu').empty();
		$('#rsselectGu').append('<option value="">전체</option>');
		for(var i=0;i<rsItem.length;i++){
			var option = $("<option>"+rsItem[i]+"</option>");
			$('#rsselectGu').append(option);
		} 
	}

// map API start
var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div
mapOption = {
	center : new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
	level : 3
// 지도의 확대 레벨
};

// 지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();
var rsLevel = 0;
// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
	zIndex : 1
});

// 키워드로 장소를 검색합니다
searchPlaces();

// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {

	/*
	 * var keyword = document.getElementById('selectCity').value; keyword += " " +
	 * document.getElementById('selectGu').value;
	 */
	var keyword = document.getElementById('rsselectCity').value+" "+
					document.getElementById('rsselectGu').value+
					" 동물병원";
	if(count==0){
	keyword = document.getElementById('rssearchresult').value+" 동물병원"; count=1;}
	
	console.log(keyword);
	

	if (!keyword.replace(/^\s+|\s+$/g,'')) {
		alert('키워드를 입력해주세요!');
		return false;
	}
	
	// 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
	ps.keywordSearch(keyword, placesSearchCB);
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
	if (status === kakao.maps.services.Status.OK) {

		// 정상적으로 검색이 완료됐으면
		// 검색 목록과 마커를 표출합니다
		displayPlaces(data);

		// 페이지 번호를 표출합니다
		displayPagination(pagination);
		rsLevel= map.getLevel();

	} else if (status === kakao.maps.services.Status.ZERO_RESULT) {

		alert('검색 결과가 존재하지 않습니다.');
		return;

	} else if (status === kakao.maps.services.Status.ERROR) {

		alert('검색 결과 중 오류가 발생했습니다.');
		return;

	}
}

// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {

	var listEl = document.getElementById('placesList'), menuEl = document
			.getElementById('menu_wrap'), fragment = document
			.createDocumentFragment(), bounds = new kakao.maps.LatLngBounds(), listStr = '';

	// 검색 결과 목록에 추가된 항목들을 제거합니다
	removeAllChildNods(listEl);

	// 지도에 표시되고 있는 마커를 제거합니다
	removeMarker();

	for (var i = 0; i < places.length; i++) {

		// 마커를 생성하고 지도에 표시합니다
		var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x), marker = addMarker(
				placePosition, i), itemEl = getListItem(i, places[i]); // 검색 결과
																		// 항목
																		// Element를
																		// 생성합니다

		// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
		// LatLngBounds 객체에 좌표를 추가합니다
		bounds.extend(placePosition);

		// 마커와 검색결과 항목에 mouseover 했을때
		// 해당 장소에 인포윈도우에 장소명을 표시합니다
		// mouseout 했을 때는 인포윈도우를 닫습니다
//		console.log(map.getLevel());
		(function(marker, title) {
			kakao.maps.event.addListener(marker, 'mouseover', function() {
				displayInfowindow(marker, title);
			});

			kakao.maps.event.addListener(marker, 'mouseout', function() {
				infowindow.close();
			});

			itemEl.onmouseover = function() {
				displayInfowindow(marker, title);
				$(this).addClass('on');
				$(this).siblings().removeClass('on');
				map.setCenter(marker.getPosition());
//				map.setLevel(rsLevel);
			};

			itemEl.onmouseout = function() {
				infowindow.close();
				$(this).removeClass('on');

			};
			
//			itemEl.onmousedown = function(){
//				map.setCenter(marker.getPosition());			
//				map.setLevel(4);
//				console.log(marker.getPosition());
//			}
			
			
			
		})(marker, places[i].place_name);

		fragment.appendChild(itemEl);
	}

	// 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
	listEl.appendChild(fragment);
	menuEl.scrollTop = 0;

	// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
	map.setBounds(bounds);
}

// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {

	var el = document.createElement('li'), itemStr = '<span class="markerbg marker_'
			+ (index + 1)
			+ '"></span>'
			+ '<div class="info">'
			+ '   <h5>'
			+ places.place_name + '</h5>';

	if (places.road_address_name) {
		itemStr += '    <span>' + places.road_address_name + '</span>'
				+ '   <span class="jibun gray">' + places.address_name
				+ '</span>';
	} else {
		itemStr += '    <span>' + places.address_name + '</span>';
	}

	itemStr += '  <span class="tel">' + places.phone + '</span>' + '</div>';

	el.innerHTML = itemStr;
	el.className = 'item';

	return el;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
	var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커
																										// 이미지
																										// url,
																										// 스프라이트
																										// 이미지를
																										// 씁니다
	// var imageSrc = '../img/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를
	// 씁니다
	imageSize = new kakao.maps.Size(36, 37), // 마커 이미지의 크기
	imgOptions = {
		spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
		spriteOrigin : new kakao.maps.Point(0, (idx * 46) + 10), // 스프라이트 이미지
																	// 중 사용할 영역의
																	// 좌상단 좌표
		offset : new kakao.maps.Point(13, 37)
	// 마커 좌표에 일치시킬 이미지 내에서의 좌표
	}, markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions), marker = new kakao.maps.Marker(
			{
				position : position, // 마커의 위치
				image : markerImage
			});

	marker.setMap(map); // 지도 위에 마커를 표출합니다
	markers.push(marker); // 배열에 생성된 마커를 추가합니다

	return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
	for (var i = 0; i < markers.length; i++) {
		markers[i].setMap(null);
	}
	markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
	var paginationEl = document.getElementById('pagination'), fragment = document
			.createDocumentFragment(), i;

	// 기존에 추가된 페이지번호를 삭제합니다
	while (paginationEl.hasChildNodes()) {
		paginationEl.removeChild(paginationEl.lastChild);
	}

	for (i = 1; i <= pagination.last; i++) {
		var el = document.createElement('a');
		el.href = "#";
		el.innerHTML = i;

		if (i === pagination.current) {
			el.className = 'on';
		} else {
			el.onclick = (function(i) {
				return function() {
					pagination.gotoPage(i);
				}
			})(i);
		}

		fragment.appendChild(el);
	}
	paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title) {
	var content = '<div id="markerName" style="padding:5px;z-index:1;font-size:13px; widt:auto;">' + title + '</div>';

	infowindow.setContent(content);
	infowindow.open(map, marker);
}

// 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {
	while (el.hasChildNodes()) {
		el.removeChild(el.lastChild);
	}
}
// // map API End
