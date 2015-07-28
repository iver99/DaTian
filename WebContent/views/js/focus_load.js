function insertMessage()
{
	var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
	var message = document.getElementById("message").value;
	$.ajax({
		   type: "GET",
		   url: curWwwPath.substring(0,pos) + "/DaTian/insertmessage",//请求的后台地址
		   data: "content=" + message,//前台传给后台的参数
		   success: function(msg){//msg:返回值
			   document.getElementById("message").value = "";
			   document.getElementById("close").click();
		   }
		});
}

function loadMessages()
{
	var url="getAllUserMessage";
	$.post(url,{},
	  function(data,status){
			  $("#getmessage").empty();
		for(var i=0; i<data.length; i++) {
			$("#getmessage").append("<tr>");
			$("#getmessage").append("<td style=\"width:250px;\" class=\"td_main_list_content\">"+renderTime_message(data[i].relDate)+"</td>");
			$("#getmessage").append("<td style=\"width:250px;\" class=\"td_main_list_content\">"+data[i].content+"</td>");
			$("#getmessage").append("<tr>");
		}
	  },"json");
}

function renderTime_message(date){ 
	var da = new Date(parseInt(date)); 
	return da.getFullYear()+"-"+ (da.getMonth()+1)+"-" +da.getDate(); 
}

function loadFocus()
{
	var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
	$.ajax({
        type: "POST",
        url: curWwwPath.substring(0,pos) + "/DaTian/focusNum",
        cache:false,
        success:function(responseText){
        	//alert(responseText);
        	if((document.getElementById("loginStatus").innerText.indexOf("登录") != -1)&&(document.getElementById("loginStatus").innerText.indexOf("注册") != -1))
        		document.getElementById("focusNum").innerHTML = "<img src=\"images/btn_m1.png\" />&nbsp;我的关注";
        	else
        		document.getElementById("focusNum").innerHTML = "<img src=\"images/btn_m1.png\" />&nbsp;我的关注("+ responseText +")"; 
        }
    })
	/*var City = getCookie("city");
	if(City == null)
		document.getElementById("city").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;北京&nbsp;<a href=\"city\" hidefocus=\"true\">[更换]</a>";
	else
		document.getElementById("city").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;"+City+"&nbsp;<a href=\"city\" hidefocus=\"true\">[更换]</a>";*/
}

function getCookie(name) 
{ 
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
 
    if(arr=document.cookie.match(reg))
 
        return unescape(arr[2]); 
    else 
        return null; 
} 