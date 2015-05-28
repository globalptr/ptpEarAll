$(function() {
	var $sidebar = $(".block_right"),
		$left = $(".mark"),
		winHeight = $(window).height(),
		sideTop = $sidebar.outerHeight() + $sidebar.offset().top,
		leftTop = $left.offset().top + $left.outerHeight(),
		diffHeight = $left.outerHeight() - $sidebar.outerHeight(),
		top;
		
        $(window).scroll(function() {
		var scrollTop = $(document).scrollTop(),
		top = scrollTop + winHeight - sideTop;
		top = top > diffHeight ? diffHeight: top;
		if (scrollTop + winHeight >= sideTop) {
			$sidebar.css({position: "relative"}).stop(true, false).animate({top: top},300)
		} else {
			$sidebar.stop(true, false).animate({top: 0},300)}
		})
	
	});