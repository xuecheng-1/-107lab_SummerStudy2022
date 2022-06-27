$(function() {
	$(".nav-pills li").click(function() {
		$(this).addClass("active").siblings().removeClass("active")

	});
});
