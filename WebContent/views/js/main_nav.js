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



/*资源列表的关注切换*/
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


/*资源详细页的关注切换*/
function hidefav(obj) {
	if(obj.className) {
		if(obj.className=="input_detail1") {
			obj.className="input_detail3";
			document.getElementById('btnfav').value="已关注";
		}
		else {
			obj.className="input_detail1";
			document.getElementById('btnfav').value="关注";
		}
    }
}


/*关注维护页中的复选框全选*/
function selectall() {
	var box1 = document.getElementsByName("f1");
	if (document.getElementById('f1_all').checked)
		{ for (var i=0; i<box1.length; i++)
			{
				box1[i].checked = true;
			}
		} 
	else
		{
			for (var i=0; i<box1.length; i++)
			{
				box1[i].checked = false;
				box1[i].disabled = false;
			} 
		}
 }




