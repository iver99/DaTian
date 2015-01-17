$(function(){
	$("#backtop_item").show();
	$("#backtop").hide();
	$(window).scroll(function() {		
		if($(window).scrollTop() >= 50){
		  $("#backtop").show();	
		 }else{    
		  $("#backtop").hide();
		 }  
	});
	$('#backtop').click(function(){$('html,body').animate({scrollTop: '0px'}, 500);});
  });


//在线客服
$(function(){
	var $qqServer = $('.qqserver');
	var $qqserverFold = $('.qqserver_fold');
	var $qqserverUnfold = $('.qqserver_arrow');
	$qqserverFold.click(function(){
		$qqserverFold.hide();
		$qqServer.addClass('unfold');
	});
	$qqserverUnfold.click(function(){
		$qqServer.removeClass('unfold');
		$qqserverFold.show();
	});
	//窗体宽度小于1024px时不显示客服QQ
	function resizeQQserver(){
		$qqServer[document.documentElement.clientWidth < 1024 ? 'hide':'show']();
	}
	$(window).bind("load resize",function(){
		resizeQQserver();
	});
});
