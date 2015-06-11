function loadFocus()
{
	var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
	$.ajax({
		   type: "GET",
		   url: curWwwPath.substring(0,pos) + "/DaTian/focusNum",//请求的后台地址
		   data: "",//前台传给后台的参数
		   success: function(msg){//msg:返回值
			   //alert(msg);
			   document.getElementById("focusNum").innerHTML = "<img src=\"images/btn_m1.png\" />&nbsp;我的关注("+ msg +")";
		   }
		});
	var City = getCookie("city");
	//alert(City);
	if(City == null)
		document.getElementById("city").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;北京&nbsp;<a href=\"city\" hidefocus=\"true\">[更换]</a>";
	else
		document.getElementById("city").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;"+City+"&nbsp;<a href=\"city\" hidefocus=\"true\">[更换]</a>";
}

function getCookie(name) 
{ 
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
 
    if(arr=document.cookie.match(reg))
 
        return unescape(arr[2]); 
    else 
        return null; 
} 