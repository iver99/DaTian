<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/citylist.js"></script>
<script type="text/javascript" src="js/cityquery.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/backtop.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="js/focus_load.js"></script>
<script type="text/javascript"> 
	$(function() {
		$('input, textarea').placeholder(); 
	});
</script>

</head>

<body onload="OnLoad()">

<div id="backtop_item">
    <div class="qqserver">
        <div class="qqserver_fold">
            <div></div>
        </div>
        <div class="qqserver-body" style="display:block;">
            <div class="qqserver-header">
                <div>在线客服</div>
                <span class="qqserver_arrow"></span>
            </div>
           <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=2509129180&site=qq&menu=yes" hidefocus="true">咨询提问</a>
            <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=2509129180&site=qq&menu=yes" hidefocus="true">意见建议</a>
            <div class="qqserver_comment" onclick="showid('popup1');" hidefocus="true">
                给我留言
            </div>
            <!-- <a href="javascript:;" class="a1" onclick="showid('popup2');" hidefocus="true">查看历史记录</a> -->
        </div>
    </div>
    <a id="backtop" onclick="return false;" title="回到顶部"></a> 
</div>

<%@ include  file="topFrame.jsp"%>

<div id="div_index_1">
	<div class="div_index_1a"></div>
	<div class="div_index_1b">
    	<ul>
        	<li class="li_index_1a">安全 &#8226; 优质 &#8226; 放心</li>
        	<li class="li_index_1b">注册就送保险</li>
        	<li class="li_index_1c">海量资源</li>
        	<li class="li_index_1d">单票500公斤起更享85折优惠</li>
        	<li class="li_index_1e"></li>
        </ul>
    </div>
</div>

<div id="div_index_2">
    <ul class="ul_index_2">
        <li class="li_index_2a">线路查询</li>
        <li class="li_index_2b" id="cityselector">
            <input id="city1" type="text" value="" class="input_city2" />
            &nbsp;&nbsp;&nbsp;&nbsp;—&nbsp;&nbsp;&nbsp;&nbsp;
            <input id="city2" type="text" value="" class="input_city2" />
            <input type="button" id="btn1" value="查询" class="btn_index_2" onclick="search()" hidefocus="true" />
        </li>
        <li class="li_index_2c">
            <a href="linetransportselected?startPlace=北京&endPlace=All&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2c" hidefocus="true">北京</a>
            <a href="linetransportselected?startPlace=天津&endPlace=All&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2c" hidefocus="true">天津</a>
            <a href="linetransportselected?startPlace=上海&endPlace=All&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2c" hidefocus="true">上海</a>
            <a href="linetransportselected?startPlace=广州&endPlace=All&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2c" hidefocus="true">广州</a>
            <a href="linetransportselected?startPlace=深圳&endPlace=All&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2c" hidefocus="true">深圳</a>
            <a href="linetransportselected?startPlace=武汉&endPlace=All&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2c" hidefocus="true">武汉</a>
            <a href="linetransportselected?startPlace=南京&endPlace=All&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2c" hidefocus="true">南京</a>
            <a href="linetransportselected?startPlace=沈阳&endPlace=All&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2c" hidefocus="true">沈阳</a>
            <a href="linetransportselected?startPlace=西安&endPlace=All&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2c" hidefocus="true">西安</a>
            <a href="linetransportselected?startPlace=长沙&endPlace=All&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2c" hidefocus="true">长沙</a>
            <a href="linetransportselected?startPlace=大连&endPlace=All&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2c" hidefocus="true">大连</a>
            <a href="linetransportselected?startPlace=成都&endPlace=All&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2c" hidefocus="true">成都</a>
        </li>
        <li class="li_index_2d">
            <a href="linetransportselected?startPlace=北京&endPlace=上海&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2d" hidefocus="true">北京-上海</a>
            <a href="linetransportselected?startPlace=北京&endPlace=天津&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2d" hidefocus="true">北京-天津</a>
            <a href="linetransportselected?startPlace=西安&endPlace=上海&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2d" hidefocus="true">西安-上海</a>
            <a href="linetransportselected?startPlace=沈阳&endPlace=广州&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2d" hidefocus="true">沈阳-广州</a>
            <a href="linetransportselected?startPlace=上海&endPlace=武汉&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2d" hidefocus="true">上海-武汉</a>
            <a href="linetransportselected?startPlace=北京&endPlace=广州&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" class="a_index_2d" hidefocus="true">北京-广州</a>
        </li>
    </ul>
</div>

<div id="div_index_3">
	<div id="div_index_3_1">
        <ul class="ul_index_3">
            <li class="li_index_3_1a">我有货，找线路</li>
            <li class="li_index_3_1b">全国范围内千条线路</li>
            <li class="li_index_3_1c"><a href="linetransport?flag=0" class="a_index_3" hidefocus="true">找线路</a></li>
            <li><img src="images/illust_3_2a.png" /></li>
        </ul>
	</div>
	<div id="div_index_3_2">
        <ul class="ul_index_3">
            <li class="li_index_3_2a"><img src="images/illust_3_2b.png" /></li>
            <li class="li_index_3_2b">我有货，找车</li>
            <li class="li_index_3_2c">全国范围内千条线路</li>
            <li class="li_index_3_2d"><a href="car?flag=0" class="a_index_3" hidefocus="true">找车辆</a></li>
        </ul>
	</div>
	<div id="div_index_3_3">
        <ul class="ul_index_3">
            <li class="li_index_3_3a">我有货，找仓库</li>
            <li class="li_index_3_3b">全国范围内千条线路</li>
            <li class="li_index_3_3c"><a href="warehouse?flag=0" class="a_index_3" hidefocus="true">找仓库</a></li>
            <li class="li_index_3_3d"><img src="images/illust_3_2c.png" /></li>
        </ul>
	</div>
</div>

<div id="div_index_4">
        <ul class="ul_index_4_1">
            <li>更多帮助</li>
        </ul>
        <ul class="ul_index_4_2">
            <li class="li_index_4_2a"><a href="javascript:;" class="a_index_4_2" hidefocus="true">新手教学</a></li>
            <li class="li_index_4_2b"><a href="javascript:;" class="a_index_4_2" hidefocus="true">托运步骤详解</a></li>
            <li class="li_index_4_2c"><a href="javascript:;" class="a_index_4_2" hidefocus="true">注册事项</a></li>
            <li class="li_index_4_2d"><a href="javascript:;" class="a_index_4_2" hidefocus="true">加入资源</a></li>
        </ul>
</div>

<div id="popup1" style="display:none;">
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="510"><div class="div_popup_title1">留言</div></td>
            <td>
                <div id="close" style="cursor:pointer;"><img src="images/btn_cancel1.png" title="关闭本窗口" /></div>
            </td>
        </tr>
    </table>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="540">
            	<textarea class="textarea_popup1" placeholder="请输入内容..." id="message"></textarea>
            </td>
        </tr>
        <tr>
            <td class="td_popup1">
                <input type="button" id="btn1" value="提交" onclick="loadXMLDoc()" class="btn_mgmt1" hidefocus="true" /><input type="button" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" />
            </td>
        </tr>
    </table>
</div>

<div id="popup2" style="display:none;">
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="510"><div class="div_popup_title1">留言历史</div></td>
            <td>
                <div id="close2" style="cursor:pointer;"><img src="images/btn_cancel1.png" title="关闭本窗口" /></div>
            </td>
        </tr>
    </table>
    <table border="0" cellspacing="0" cellpadding="0" class="table_main_list" id="list">
		<thead>
		   	<tr>
				<td width="20" class="td_main_list_head">时间</td>
				<td width="50" class="td_main_list_head">内容</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="td_main_list_content">123312412421</td>
				<td class="td_main_list_content">124512512512</td>
			</tr>
		</tbody>
	</table>
</div>

<div id="footer_frame" style="margin-top:0;">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="views/footer.jsp"></iframe>
</div>

</body>
<script type="text/javascript">
function OnLoad() {
	//Rescreen();
	loadFocus();
}
function loadXMLDoc()
{
	var message = document.getElementById("message").value;
	//alert(message);
	$.ajax({
		   type: "GET",
		   url: "http://localhost:8585/DaTian/insertmessage",//请求的后台地址
		   data: "content=" + message,//前台传给后台的参数
		   success: function(msg){//msg:返回值
			   document.getElementById("close").click();
		   }
		});
}
</script>
<script type="text/javascript">
	function search() {
		var city1 = document.getElementById("city1").value;
		var city2 = document.getElementById("city2").value;
		if(city1 == "中文或拼音")
			city1 = "All";
		if(city2 == "中文或拼音")
			city2 = "All";
		var url = "linetransportselected?startPlace="+city1+"&endPlace="+city2+"&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1";
		if((city1 == "All") && (city2 == "All"))
			url = "linetransport?flag=0";
		location.assign(url);
	}
</script>
</html>