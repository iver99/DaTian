<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>资源-车辆</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
#allmap {
	width: 100%;
	height: 100%;
	overflow: hidden;
	margin: 1;
	font-family: "微软雅黑";
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=osuO3WDtmGYEK9nMYGZimjkb"></script>

<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/resource_select.js"></script>
<script type="text/javascript" src="js/jquery.tablesorter.pack.js"></script>
<script type="text/javascript" src="js/table_sort.js"></script>
<script type="text/javascript" src="js/citylist.js"></script>
<script type="text/javascript" src="js/cityquery.js"></script>
<script type="text/javascript" src="js/backtop.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="js/splitPage.js"></script><!-- 新增 -->	
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
		<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;车辆
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="230" class="td_leftnav_top">
					<div id="main_frame_left">
						<a href="linetransport?flag=0" class="a_leftnav" hidefocus="true">运输线路</a>
						<a href="cityline?flag=0" class="a_leftnav" hidefocus="true">配送网络</a>
						<span class="text_leftnav1">车辆</span> 
						<a href="warehouse?flag=0" class="a_leftnav" hidefocus="true">仓库</a>
						<a href="company" class="a_leftnav" hidefocus="true">公司</a> <a
							href="goodsform?flag=0" class="a_leftnav" hidefocus="true"
							style="border-bottom: none;">货物</a>
					</div>
				</td>
				<td>
					<div id="div_resource_select">
						<div id="cityselector" class="div_cityselector1">
							当前位置： <input id="city1" type="text" value="" text="carLocation"
								class="input_city1" /> &nbsp;&nbsp;&nbsp;&nbsp;目的城市： <input
								id="city2" type="text" value="" text="endPlace"
								class="input_city1" />
						</div>
						<ul class="resource">
							<li class="resource_list">
								<dl id="select1" value="carBase">
									<dt>厢型：</dt>
									<dd class="resource_all selected">
										<a href="javascript:;" hidefocus="true" id="select1_0">全部</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select1_1">普通</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select1_2">平板</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select1_3">厢式</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select1_4">高栏</a>
									</dd>
								</dl>
							</li>
							<li class="resource_list">
								<dl id="select2" value="carLength">
									<dt>车长：</dt>
									<dd class="resource_all selected">
										<a href="javascript:;" hidefocus="true" id="select2_0">全部</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select2_1">10米</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select2_2">12米</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select2_3">14米</a>
									</dd>
								</dl>
							</li>
							<li class="resource_list">
								<dl id="select3" value="carWeight">
									<dt>载重：</dt>
									<dd class="resource_all selected">
										<a href="javascript:;" hidefocus="true" id="select3_0">全部</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select3_1">8吨</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select3_2">12吨</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select3_3">16吨</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select3_4">20吨</a>
									</dd>
								</dl>
							</li>
					<!-- 	<li class="resource_list">
								<dl>
									<dt>车辆位置：</dt>
									<dd>
										<input id="location1" type="text" text="location"
											class="input_resource_search1"
											style="width: 300px; cursor: pointer;" value="点击此处定位..."
											readonly="readonly" onclick="showid('popup2');" />
									</dd>
								</dl>
							</li> -->
							<li class="resource_result">
								<dl>
									<dt>已选条件：</dt>
									<dd class="resource_no">暂无内容</dd>
								</dl>
							</li>
							<li><input type="button" id="btn2" value="重置"
								class="btn_resource_search2" hidefocus="true" /> <input
								type="button" id="btn1" value="筛选" class="btn_resource_search1"
								hidefocus="true" /></li>
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
										<a href="javascript:;" class="menuhd" hidefocus="true">用途</a>
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
										<a href="javascript:;" class="menuhd" hidefocus="true">状态</a>
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
										<a href="javascript:;" class="menuhd" hidefocus="true">车长</a>
										<div class="menubd">
											<div class="menubdpanel">
												<a href="javascript:;" class="a_top2a" hidefocus="true"
													id="trigger3a">升序</a> <a href="javascript:;"
													class="a_top2b" hidefocus="true" id="trigger3b">降序</a>
											</div>
										</div>
									</div>
								</li>
								<li class="menuitem">
									<div class="menu">
										<a href="javascript:;" class="menuhd" hidefocus="true">载重</a>
										<div class="menubd">
											<div class="menubdpanel">
												<a href="javascript:;" class="a_top2a" hidefocus="true"
													id="trigger4a">升序</a> <a href="javascript:;"
													class="a_top2b" hidefocus="true" id="trigger4b">降序</a>
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
													id="trigger5a">升序</a> <a href="javascript:;"
													class="a_top2b" hidefocus="true" id="trigger5b">降序</a>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<table border="0" cellspacing="0" cellpadding="0"
						class="table_main_list" id="list1">
						<thead>
							<tr>
								<td width="15" class="td_main_list_head"></td>
								<td class="td_main_list_head">牌照号码</td>
								<td class="td_main_list_head" width="80">用途</td>
								<td class="td_main_list_head" width="70">状态</td>
								<td class="td_main_list_head" width="70">车长(米)</td>
								<td class="td_main_list_head" width="70">载重(吨)</td>
								<td class="td_main_list_head" width="100">当前位置</td>
								<td class="td_main_list_head" width="80">定位日期</td>
								<td class="td_main_list_head" width="45">关注</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="car" items="${carList }">
								<tr>
									<td class="td_main_list_content"></td>
									<td class="td_main_list_content"><a
										href="cardetail?carId=${car.id }&carrierId=${car.carrierId}&linetransportId=${car.linetransportId }&flag=0"
										hidefocus="true">${car.carNum }<!-- <img src="images/btn_level1a.png" /> --></a>
										<br /> <a href="companyDetail?id=${car.carrierId }"
										style="color:#717071;" hidefocus="true">${car.companyName }<img
											src="images/btn_level1a.png" /></a></td>

									<td class="td_main_list_content">${car.carUse }</td>
									<td class="td_main_list_content">${car.carState }</td>
									<td class="td_main_list_content">${car.carLength }</td>
									<td class="td_main_list_content">${car.carWeight }</td>
									<td class="td_main_list_content">${car.carLocation }</td>
									<td class="td_main_list_content">${car.relDate }</td>
									<input type="button" value="0" style="display:none" id="i"></input>
									<td class="td_main_list_content">
										<script>
											document.getElementById("i").value=0;
										</script>
										<c:forEach var="focus" items="${focusList }">
										<c:if test="${car.id==focus.focusId}">
											<script>
												document.getElementById("i").value=1;
											</script>
										</c:if>
										</c:forEach>
										<script type="text/javascript">
											if(document.getElementById("i").value==1)
												document.write( "<a href=\"javascript:;\" class=\"a_main_list_handle_icon1b\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('${car.id }')\"></a>" );
											else
												document.write( "<a href=\"javascript:;\" class=\"a_main_list_handle_icon1a\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('${car.id }')\"></a>" );
										</script>
									</td>
								</tr>
							</c:forEach>
						</tbody>

						<select id="carloc">
							<c:forEach var="location" items="${locList }">
								<option value="${location.carNum }">${location.carNum }</option>
								<option value="${location.locLongitude }">${location.locLongitude }</option>
								<option value="${location.locLatitude }">${location.locLatitude }</option>
								<option value="${location.carLocation }">${location.carLocation }</option>
							</c:forEach>
						</select>

					</table>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table_recordnumber">
						<tr>
							<td>每页 <select id="Display">
									<option value="10" selected="selected">10</option>
									<option value="20">20</option>
									<option value="50">50</option>
							</select> 条记录
							</td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table_pagenumber" id="PageNow" value="1">
						<tr>
							<td width="45" class="td_pagenumber" onclick="ChangeTo('first')"><a href="javascript:;" class="a_pagenumber" hidefocus="true">首页</td>
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
				<td class="td_popup1"><input type="button" id="btn1" value="提交"
					class="btn_mgmt1" hidefocus="true" /><input type="button"
					id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" /></td>
			</tr>
		</table>
	</div>

	<div id="popup2" style="display: none;">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="610"><div class="div_popup_title1">地图</div></td>
				<td>
					<div id="close2" style="cursor: pointer;">
						<img src="images/btn_cancel1.png" title="关闭本窗口" />
					</div>
				</td>
			</tr>
		</table>
		<!-- <div class="div_popup_content1">
    	<img src="images/illust_4.jpg" width="100%" height="100%" />
    </div> -->
		<div class="div_popup_content1">
			<div id="allmap"></div>
		</div>
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="570" height="40"><input type="text"
					class="input_resource_search1"
					style="width: 200px; margin-left: 10px;" placeholder="请输入要查找的地点..."
					id="searchloc" value="" /> <select class="select_popup1"
					id="searcharea">
						<option value="1" selected="selected">请选择范围</option>
						<option value="5">周围5公里以内</option>
						<option value="10">周围10公里以内</option>
						<option value="20">周围20公里以内</option>
						<option value="50">周围50公里以内</option>
				</select> <input type="button" value="搜索" class="btn_mgmt1" hidefocus="true"
					onclick="search()" /></td>
				<td>
					<div>
						<input type="button" id="close2a" value="提交" class="btn_mgmt1"
							hidefocus="true" />
					</div>
				</td>
			</tr>
		</table>
	</div>

	<div id="footer_frame">
		<iframe allowtransparency="true" width="100%" frameborder="0"
			hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0"
			src="views/footer.jsp"></iframe>
	</div>
</body>
<script type="text/javascript">
	function OnLoad() {
		//Rescreen();
		loadFocus();
		GetRequest();
	}
</script>

<Script language="javascript" charset="gb2312">
	function GetRequest() {
		var url = location.search; //获取url中"?"符后的字串
		if (url == "?flag=0") {
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
			carparameter[0][1] = "普通";
			carparameter[0][2] = "平板";
			carparameter[0][3] = "厢式";
			carparameter[0][4] = "高栏";
			carparameter[1][0] = "All";
			carparameter[1][1] = "10米";
			carparameter[1][2] = "12米";
			carparameter[1][3] = "14米";
			carparameter[2][0] = "All";
			carparameter[2][1] = "8吨";
			carparameter[2][2] = "12吨";
			carparameter[2][3] = "16吨";
			carparameter[2][4] = "20吨";
			var theRequest = new Object();
			if (url.indexOf("?") != -1) {
				var str = url.substr(1);
				strs = str.split("&");
				document.getElementById("city1").value = UrlDecode(strs[0]
						.split("=")[1]);
				document.getElementById("city2").value = UrlDecode(strs[1]
						.split("=")[1]);
				// alert(UrlDecode(strs[strs.length-2].split("=")[1]));
				for (var i = 2; i < strs.length; i++) {
					for (var j = 0; j < 10; j++)
						if (carparameter[i - 2][j] != "") {
							if (carparameter[i - 2][j] == UrlDecode(strs[i]
									.split("=")[1])) {
								var locate = "select" + (i - 1) + "_" + j;
								document.getElementById(locate).click();
							}
						}
				}
				document.all.Display.value = UrlDecode(strs[strs.length - 2]
						.split("=")[1]);
			}
		}
	}

	function UrlDecode(zipStr) {
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

	function StringToAscii(str) {
		return str.charCodeAt(0).toString(16);
	}
	function AsciiToString(asccode) {
		return String.fromCharCode(asccode);
	}
</Script>
</html>

<script type="text/javascript">
	// 百度地图API功能
	var longitude = 116.403851;
	var latitude = 39.915295;
	var map = new BMap.Map("allmap"); // 创建Map实例
	map.centerAndZoom(new BMap.Point(116.403851, 39.915295), 12); // 初始化地图,设置中心点坐标和地图级别
	map.addControl(new BMap.MapTypeControl()); //添加地图类型控件
	map.setCurrentCity("北京"); // 设置地图显示的城市 此项是必须设置的
	map.enableScrollWheelZoom(true); //开启鼠标滚轮缩放
	var loclist = new Array();
	var k = -4;
	<c:forEach var="location" items="${locList }">
	k += 4;
	var point = new BMap.Point(
			document.getElementById("carloc").options[k + 1].text, document
					.getElementById("carloc").options[k + 2].text);
	var marker = new BMap.Marker(point);
	marker.disableMassClear();
	map.addOverlay(marker); // 将标注添加到地图中
	//marker.addEventListener("click",getAttr);
	var label = new BMap.Label(
			document.getElementById("carloc").options[k].text, {
				offset : new BMap.Size(20, -10)
			});
	marker.setLabel(label);
	</c:forEach>
	var point = new BMap.Point(longitude, latitude);
	map.centerAndZoom(point, 13);
	//alert(k);
	map
			.addEventListener(
					"click",
					function(e) {
						if (e.overlay) {

							for (i = 0; i <= k; i += 4) {
								//alert(document.getElementById("carloc").options[i].text + " " +e.overlay.getLabel().content);
								if (document.getElementById("carloc").options[i].text == e.overlay
										.getLabel().content) {
									document.getElementById("searchloc").value = document
											.getElementById("carloc").options[i + 3].text;
									//e.overlay.setAnimation(BMAP_ANIMATION_BOUNCE);
									longitude = document
											.getElementById("carloc").options[i + 1].text;
									latitude = document
											.getElementById("carloc").options[i + 2].text;
								}
								//alert(document.getElementById("carloc").options[i+3].text);
							}
							//alert(e.overlay.getLabel().content);
							//alert('你点击的是覆盖物：'+e.overlay.toString());   
						}
					});

	function search() {
		//deletePoint();
		map.clearOverlays();
		var point = new BMap.Point(longitude, latitude);
		map.centerAndZoom(point, 13);
		var range = document.getElementById("searcharea").options[document
				.getElementById("searcharea").selectedIndex].value * 1000;
		//alert(range);
		var circle = new BMap.Circle(point, range, {
			strokeColor : "blue",
			strokeWeight : 2,
			strokeOpacity : 0.5
		});
		map.addOverlay(circle);
	}
</script>
<script type="text/javascript">
function loadXMLDoc(id)
{
	$.ajax({
		   type: "GET",
		   url: "http://localhost:8585/DaTian/focus",//请求的后台地址
		   data: "type=car&id=" + id,//前台传给后台的参数
		   success: function(msg){//msg:返回值
			   loadFocus();
		   }
		});
}
</script>