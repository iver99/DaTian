$(function(){           
	var navBox = $('.tabTagBox'), navList = $('.tabTagList'), navs = navList.children('li'), contentBoxs = $('.tabcon');
	
	var opts = {
		curNavIndex: 0
	}

	var navToContentBox = function () {
		navs.removeClass('current');
		contentBoxs.hide().eq(opts.curNavIndex).show();
	}
	
	navs.click(function () {
		opts.curNavIndex = $(this).index();
		navToContentBox();
		$(this).addClass('current');
		lazyloadForPart(contentBoxs);
	});
	
});
