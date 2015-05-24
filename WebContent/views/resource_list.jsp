<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>资源-运输线路</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
	<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
	<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
	<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
	<link type="text/css" rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
		<script type="text/javascript" src="js/top_search.js"></script>
		<script type="text/javascript" src="js/main_nav.js"></script>
		<script type="text/javascript" src="js/resource_select.js"></script>
		<script type="text/javascript" src="js/citylist.js"></script>
		<script type="text/javascript" src="js/cityquery.js"></script>
		<script type="text/javascript" src="js/jquery.tablesorter.pack.js"></script>
		<script type="text/javascript" src="js/table_sort.js"></script>
		<script type="text/javascript" src="js/popup.js"></script>
		<script type="text/javascript" src="js/backtop.js"></script>
		<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
		<script type="text/javascript" src="js/splitPage.js"></script><!-- 新增 -->
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
			<div class="qqserver-body" style="display: block;">
				<div class="qqserver-header">
					<div>在线客服</div>
					<span class="qqserver_arrow"></span>
				</div>
				<a href="javascript:;"
					onclick="window.open('http://b.qq.com/webc.htm?new=0&sid=11223344&o=abc.com&q=1', '_blank')"
					hidefocus="true">咨询提问</a> <a href="javascript:;" hidefocus="true">意见建议</a>
				<div class="qqserver_comment" onclick="showid('popup1');"
					hidefocus="true">给我留言</div>
				<a href="javascript:;" class="a1" hidefocus="true">查看历史记录</a>
			</div>
		</div>
		<a id="backtop" onclick="return false;" title="回到顶部"></a>
	</div>

<%@ include  file="topFrame.jsp"%>
	<div id="main_frame">
		<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;运输线路
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="230" class="td_leftnav_top">
					<div id="main_frame_left">
						<span class="text_leftnav1">运输线路</span>
						 <a href="cityline?flag=0"	class="a_leftnav" hidefocus="true">配送网络</a> <a
							href="car?flag=0" class="a_leftnav" hidefocus="true">车辆</a>
						<a href="warehouse?flag=0" class="a_leftnav" hidefocus="true">仓库</a>
						<a href="company" class="a_leftnav" hidefocus="true">公司</a> <a
							href="goodsform?flag=0" class="a_leftnav" hidefocus="true"
							style="border-bottom: none;">货物</a>
					</div>
				</td>
				<td>
				 <!-- 这一层对应筛选部分,某些控件的text和value值有所更改，后面通过这两个值控制筛选状态  -->
            	<div id="div_resource_select">
                    <div id="cityselector" class="div_cityselector1">
                        起止城市：
                        <input id="city1" type="text" text="startPlace" value="" class="input_city1" />
                        &nbsp;&nbsp;至&nbsp;&nbsp;
                        <input id="city2" type="text" text="endPlace" value="" class="input_city1" />
                    </div>
                    <ul class="resource">
                        <li class="resource_list">
                            <dl id="select1" value="type">
                                <dt>运输类型：</dt>
                                <dd class="resource_all selected"><a href="javascript:;" hidefocus="true" id="select1_0">全部</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select1_1">整车</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select1_2">零担</a></dd>
                            </dl>
                        </li>
                        <li class="resource_list">
                       
                            <dl id="select2" value="startPlace1">
                                <dt>始发城市：</dt>
                                <dd class="resource_all selected"><a href="javascript:;" hidefocus="true" id="select2_0">全部</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select2_1">北京始发</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select2_2">天津始发</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select2_3">上海始发</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select2_4">武汉始发</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select2_5">广州始发</a></dd>
                            </dl>
                        </li>
                        <li class="resource_list">
                            <dl id="select3" value="refPrice">
                                <dt>参考报价：</dt>
                                <dd class="resource_all selected"><a href="javascript:;" hidefocus="true" id="select3_0">全部</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select3_1">大于2元/kg</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select3_2">1至2元/kg</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select3_3">小于1元/kg</a></dd>
                            </dl>
                        </li>
                        <li class="resource_result">
                            <dl>
                                <dt>已选条件：</dt>
                                <dd class="resource_no">暂无内容</dd>
                            </dl>
                        </li>
                        <li>
                            <input type="button" id="btn2" value="重置" class="btn_resource_search2" hidefocus="true" />
                        	<input type="button" id="btn1" value="筛选" class="btn_resource_search1" hidefocus="true" />
                        </li>
                    </ul>
				</div>
					<div id="div_resource_list_head">
						<div id="div_resource_list_head1">共 ${count } 条记录</div>
						<input id="count" value="${count }" type="hidden"/>
						<input id="count" value="${pageNum }" type="hidden"/>
						<input id="count" value="${pageNow }" type="hidden"/>
						<div id="middlesort">
							<ul class="quickmenu">
								<li class="menuitem">
									<div class="menu">
										<a href="javascript:;" class="menuhd" hidefocus="true">价格</a>
										<div class="menubd">
											<div class="menubdpanel">
												<a href="javascript:;" class="a_top2a" hidefocus="true"
													id="trigger1a">升序</a> <a href="javascript:;"
													class="a_top2b" hidefocus="true" id="trigger1b">降序</a>
											</div>
										</div>
									</div>
								</li>
								<li class="menuitem">
									<div class="menu">
										<a href="javascript:;" class="menuhd" hidefocus="true">时限</a>
										<div class="menubd">
											<div class="menubdpanel">
												<a href="javascript:;" class="a_top2a" hidefocus="true"
													id="trigger2a">升序</a> <a href="javascript:;"
													class="a_top2b" hidefocus="true" id="trigger2b">降序</a>
											</div>
										</div>
									</div>
								</li>
								<li class="menuitem">
									<div class="menu">
										<a href="javascript:;" class="menuhd" hidefocus="true">关注</a>
										<div class="menubd">
											<div class="menubdpanel">
												<a href="javascript:;" class="a_top2a" hidefocus="true"
													id="trigger3a">升序</a> <a href="javascript:;"
													class="a_top2b" hidefocus="true" id="trigger3b">降序</a>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<table border="0" cellspacing="0" cellpadding="0"
						class="table_main_list" id="list">
						<thead>
							<tr>
								<td width="15" class="td_main_list_head"></td>
								<td class="td_main_list_head">线路名称</td>
								<td width="100" class="td_main_list_head">参考价(元/kg)</td>
								<td width="60" class="td_main_list_head">类型</td>
								<td width="80" class="td_main_list_head">时限(小时)</td>
								<td width="80" class="td_main_list_head">发布日期</td>
								<td width="45" class="td_main_list_head">关注</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="linetransport" items="${linetransportList }">
								<tr>
									<td class="td_main_list_content"></td>
									<td class="td_main_list_content"><a
										href="linetransportdetail?linetransportid=${linetransport.id }&carrierId=${linetransport.carrierId}&linetransportId=${linetransport.id }&flag=0"
										hidefocus="true">${linetransport.startPlace }→${linetransport.endPlace }</a>
										<br />
										 <a style="color:#717071;" href="companyDetail?id=${linetransport.carrierId }" hidefocus="true">${linetransport.companyName }<img
											src="images/btn_level1a.png" /></a>
								</td>
									<td class="td_main_list_content">${linetransport.refPrice }</td>
									<td class="td_main_list_content">${linetransport.type }</td>
									<td class="td_main_list_content">${linetransport.onWayTime }</td>
									<td class="td_main_list_content">${linetransport.relDate }</td>
									<input type="button" value="0" style="display:none" id="i"></input>
									<td class="td_main_list_content">
										<script>
											document.getElementById("i").value=0;
										</script>
										<c:forEach var="focus" items="${focusList }">
										<c:if test="${linetransport.id==focus.focusId}">
											<script>
												document.getElementById("i").value=1;
											</script>
										</c:if>
										</c:forEach>
										<script type="text/javascript">
											if(document.getElementById("i").value==1)
												document.write( "<a href=\"javascript:;\" class=\"a_main_list_handle_icon1b\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('${linetransport.id }')\"></a>" );
											else
												document.write( "<a href=\"javascript:;\" class=\"a_main_list_handle_icon1a\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('${linetransport.id }')\"></a>" );
										</script>
										</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table_recordnumber">
						<tr>
							<td>每页  <select id="Display">
                                <option value="10" selected="selected">10</option>
                                <option value="20">20</option>
                                <option value="50">50</option>
                            </select> 条记录
							</td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0" class="table_pagenumber" id="PageNow" value="1">
                    <tr>
	                    <td width="45" class="td_pagenumber" onclick="ChangeTo('first')"><a href="javascript:;" class="a_pagenumber" hidefocus="true">首页</a></td>
                        <td width="45" class="td_pagenumber" onclick="ChangeTo('previous')"><a href="javascript:;" class="a_pagenumber" hidefocus="true">上页</a></td>
                        <!-- <td width="30" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">1</a></td>
                        <td width="30" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">2</a></td>
                        <td width="30" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">3</a></td> -->
                        <c:if test="${pageNum < 8}">
                        	<c:forEach begin="1" end="${pageNum }" var="i">
                        	    <td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
                        	</c:forEach>
                        </c:if>
                        <c:if test="${pageNum >= 8}">
                        	<c:choose>
                        		<c:when test="${pageNow <= 3}">
                        			<c:forEach begin="1" end="5" var="i">
                        				<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
                        			</c:forEach>
                        			...
                        		</c:when>
                        		<c:when test="${pageNow == 4}">
                        			<c:forEach begin="1" end="6" var="i">
                        				<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
                        			</c:forEach>
                        			...
                        		</c:when>
                        		<c:when test="${pageNow == 5}">
                        			<c:forEach begin="1" end="7" var="i">
                        				<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
                        			</c:forEach>
                        			...
                        		</c:when>
                        		<c:when test="${pageNow > 5 && pageNow < pageNum - 3}">
                        		    <td width="30" class="td_pagenumber" onclick="ChangePage('1')"><a href="javascript:;" class="a_pagenumber" hidefocus="true">1</a></td>
                        		    <td width="30" class="td_pagenumber" onclick="ChangePage('2')"><a href="javascript:;" class="a_pagenumber" hidefocus="true">2</a></td>
                        		    ...
                        			<c:forEach begin="${pageNow-2 }" end="${pageNow+2 }" var="i">
                        				<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
                        			</c:forEach>
                        			...
                        		</c:when>
                        		<c:when test="${pageNow == pageNum - 3}">
                        		    <td width="30" class="td_pagenumber" onclick="ChangePage('1')"><a href="javascript:;" class="a_pagenumber" hidefocus="true">1</a></td>
                        		    <td width="30" class="td_pagenumber" onclick="ChangePage('2')"><a href="javascript:;" class="a_pagenumber" hidefocus="true">2</a></td>
                        		    ...
                        			<c:forEach begin="${pageNow-5 }" end="${pageNow }" var="i">
                        				<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
                        			</c:forEach>
                        		</c:when>
                        		<c:when test="${pageNow >= pageNum - 2}">
                        		    <td width="30" class="td_pagenumber" onclick="ChangePage('1')"><a href="javascript:;" class="a_pagenumber" hidefocus="true">1</a></td>
                        		    <td width="30" class="td_pagenumber" onclick="ChangePage('2')"><a href="javascript:;" class="a_pagenumber" hidefocus="true">2</a></td>
                        		    ...
                        			<c:forEach begin="${pageNow-4 }" end="${pageNow }" var="i">
                        				<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
                        			</c:forEach>
                        		</c:when>
                        	</c:choose>
                        </c:if>
                        <td width="45" class="td_pagenumber" onclick="ChangeTo('next')"><a href="javascript:;" class="a_pagenumber" hidefocus="true">下页</a></td>
                        <td width="45" class="td_pagenumber" onclick="ChangeTo('last')"><a href="javascript:;" class="a_pagenumber" hidefocus="true">末页</a></td>
                    </tr>
				</table>
				</td>
			</tr>
		</table>
	</div>

	<div id="popup1" style="display: none;">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="510"><div class="div_popup_title1">留言</div></td>
				<td>
					<div id="close" style="cursor: pointer;">
						<img src="images/btn_cancel1.png" title="关闭本窗口" />
					</div>
				</td>
			</tr>
		</table>
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="540"><textarea class="textarea_popup1"
						placeholder="请输入内容..."></textarea></td>
			</tr>
			<tr>
				<td class="td_popup1"><input type="button" id="btn2" value="提交"
					class="btn_mgmt1" hidefocus="true" /><input type="button"
					id="btn3" value="重填" class="btn_mgmt2" hidefocus="true" /></td>
			</tr>
		</table>
	</div>

	<div id="footer_frame">
		<iframe allowtransparency="true" width="100%" frameborder="0"
			hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0"
			src="footer.htm"></iframe>
	</div>
	<!-- <div id="myDiv"></div> -->
</body>
<script type="text/javascript" charset="utf-8">
	function OnLoad() {
		GetRequest();
	}
</script>
<script type="text/javascript">
/* function loadXMLDoc(id)
{
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    //document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
	    }
	  }
	url = "http://localhost:8585/DaTian/focus?type=linetransport&id=" + id;
	xmlhttp.open("GET",url,true);
	xmlhttp.send(null);
} */
function loadXMLDoc(id)
{
	$.ajax({
		   type: "GET",
		   url: "http://localhost:8585/DaTian/focus",//请求的后台地址
		   data: "type=linetransport&id=" + id,//前台传给后台的参数
		   success: function(msg){//msg:返回值
		   }
		});
}
</script>
<Script language="javascript" charset="gb2312">
	function GetRequest() {
		var url = location.search; //获取url中"?"符后的字串
				//alert(url)
		if (url == "?flag=0") {//若当前没有任何控件被点选,模拟初始点选状态
			document.getElementById("select1_0").click();
			document.getElementById("select2_0").click();
			document.getElementById("select3_0").click();
		} else {
			var carparameter = new Array(); //先声明一维
			for (var i = 0; i < 5; i++) { //一维长度为5
				carparameter[i] = new Array(); //在声明二维
				for (var j = 0; j < 10; j++) { //二维长度为10
					carparameter[i][j] = "";
				}
			}
			//对应筛选页面，所有筛选项组成二维矩阵
			carparameter[0][0] = "All";
			carparameter[0][1] = "整车";
			carparameter[0][2] = "零担";
			carparameter[1][0] = "All";
			carparameter[1][1] = "北京始发";
			carparameter[1][2] = "天津始发";
			carparameter[1][3] = "上海始发";
			carparameter[1][4] = "武汉始发";
			carparameter[1][5] = "广州始发";
			carparameter[2][0] = "All";
			carparameter[2][1] = "大于2元/kg";
			carparameter[2][2] = "1至2元/kg";
			carparameter[2][3] = "小于1元/kg";
			var theRequest = new Object();
			if (url.indexOf("?") != -1) {
				var str = url.substr(1);//取?后的部分
				strs = str.split("&");//按&划分
				document.getElementById("city1").value = UrlDecode(strs[0]
						.split("=")[1]);//city1、city2两个控件是input型，单独处理
				document.getElementById("city2").value = UrlDecode(strs[1]
						.split("=")[1]);
				for (var i = 2; i < strs.length - 2; i++) {
					for (var j = 0; j < 10; j++)
						if (carparameter[i - 2][j] != "") {
							if (carparameter[i - 2][j] == UrlDecode(strs[i]
									.split("=")[1])) {//url中的每一项和筛选矩阵对比，确定控件点选状态
								var locate = "select" + (i - 1) + "_" + j;//定位控件id
								document.getElementById(locate).click();//模拟点选
							}
						}
				}
				//alert(UrlDecode(strs[strs.length-2].split("=")[1]));
				//document.getElemtById("Display").options[UrlDecode(strs[strs.length-2].split("=")[1])].selected = "selected";
				document.all.Display.value = UrlDecode(strs[strs.length - 2]
						.split("=")[1]);//每页显示多少条数据
			}
		}
	}

	function UrlDecode(zipStr) {//将utf-8转回汉字的代码  
		var uzipStr = "";
		for (var i = 0; i < zipStr.length; i++) {
			var chr = zipStr.charAt(i);
			if (chr == "+") {
				uzipStr += " ";
			} else if (chr == "%") {
				var asc = zipStr.substring(i + 1, i + 3);
				if (parseInt("0x" + asc) > 0x7f) {
					uzipStr += decodeURI("%" + asc.toString()
							+ zipStr.substring(i + 3, i + 9).toString());
					i += 8;
				} else {
					uzipStr += AsciiToString(parseInt("0x" + asc));
					i += 2;
				}
			} else {
				uzipStr += chr;
			}
		}

		return uzipStr;
	}

	function StringToAscii(str) { //字符串转ASCII
		return str.charCodeAt(0).toString(16);
	}
	function AsciiToString(asccode) { //ASCII转字符串 
		return String.fromCharCode(asccode);
	}
</Script>

</html>