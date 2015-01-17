(function($){
	$.fn.hoverForIE6=function(option){
		var s=$.extend({current:"hover",delay:5},option||{});
		$.each(this,function(){
			var timer1=null,timer2=null,flag=false;
			$(this).bind("mouseover",function(){
				if (flag){
					clearTimeout(timer2);
				}else{
					var _this=$(this);
					timer1=setTimeout(function(){
						_this.addClass(s.current);
						flag=true;
					},s.delay);
				}
			}).bind("mouseout",function(){
				if (flag){
					var _this=$(this);timer2=setTimeout(function(){
						_this.removeClass(s.current);
						flag=false;
					},s.delay);
				}else{
					clearTimeout(timer1);
				}
			})
		})
	}
})(jQuery);


function hide(obj) {
	if(obj.className) {
		if(obj.className=="a_main_list_handle_icon1a") {
			obj.className="a_main_list_handle_icon1b";
		}
		else {
			obj.className="a_main_list_handle_icon1a";
		}
    }
}