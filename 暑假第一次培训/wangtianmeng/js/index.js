$(function() {
    var temp = $("#box").offset().top;
    var num = $(".zhongjian").offset().top;
    // console.log(num);
    // console.log(temp);
    $(document).scroll(function() {
        if ($(document).scrollTop() > temp) {
            $(".middle").find(".news").fadeIn(1500);
            $(".middle").find(".rec").fadeIn(1500);
            $(".middle").find(".location").fadeIn(1500);
        } else {
            $(".middle").find(".news").fadeOut(500);
            $(".middle").find(".rec").fadeOut(500);
            $(".middle").find(".location").fadeOut(500);
        }

        if ($(document).scrollTop() > num) {
            $(".down").find(".d1").fadeIn(1500);
            $(".down").find(".d2").fadeIn(1500);
            $(".down").find(".d3").fadeIn(1500);
            $(".down").find(".d4").fadeIn(1500);
        } else {
            $(".down").find(".d1").fadeOut(500);
            $(".down").find(".d2").fadeOut(500);
            $(".down").find(".d3").fadeOut(500);
            $(".down").find(".d4").fadeOut(500);
        }
    })
})