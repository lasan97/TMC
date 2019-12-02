
$(document).ready(function () {
    $('.tmc_nav_ul li').hover(function () {
        $(this).addClass('on');
        $(this).siblings().removeClass('on');
    }, function () {
        $(this).removeClass('on');
    });
    $(window).resize(function(){
        var Wwid = $(document).width();
            $('.tmc_nav_ul').removeClass('mb');
    });
});
$(document).scroll(function () {
    var scla = window.scrollY || document.documentElement.scrollTop;

    if (scla > 20) {
        $('.tmc_main-header').addClass('guide');
    } else {
        $('.tmc_main-header').removeClass('guide');
    }
});

$('#nav_bar_pull').on("click",function(){
    // toggleClass("nav_ul")
    // $('.main_header_container').addClass('mb');
    $('.tmc_nav_ul').toggleClass('mb');
});



// 로그인
var section_login = document.getElementById("login_form");

var login_btn = document.getElementById("login_onclick");

var span = document.getElementsByClassName("close")[0];

login_btn.onclick = function () {
    section_login.style.display = "block";
}

span.onclick = function () {
    section_login.style.display = "none";
}
// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == section_login) {
        section_login.style.display = "none";
    }
}