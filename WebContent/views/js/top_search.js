
$(function(){
	$('.search_input').focus(function(){
		var keyval=$('.search_input').val();
		if(keyval=='请输入关键字'){
			$('.search_input').val('');
		}
	})
	$('.search_input').focusout(function(){
		var keyval=$('.search_input').val();
		if(keyval==''){
			$('.search_input').val('请输入关键字');
		}
	})
	$('.mkey').click(function(){
		$('.key_ul').show();
		$('.key_ul li').click(function(){
			var keyval=$(this).text();
			$('.mkey').text(keyval);
			$('.key_ul').hide();
		})		
	})
	$(document).mouseup(function() {
		$('.key_ul').hide();
	});
	$('.search_btn').click(function(){
		var mval=$('.mkey').text();
		var keyval=$('.search_input').val();
//		alert(mval+'：'+keyval)	
		alert(keyval+'！')	
	})
	$('.key_ul li').hover(function(){$(this).addClass('on');},function(){$(this).removeClass('on');})
})
