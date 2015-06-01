<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>车辆信息</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/mgmt.js"></script>
<script type="text/javascript" src="js/backtop.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="js/focus_load.js"></script>
<script type="text/javascript"> 
	$(function() {
		$('input, textarea').placeholder(); 
	});
</script>
</head>

<body onload="OnLoad()">

<%@ include file="qq.jsp"%>

<%@ include  file="topFrame.jsp"%>

<div id="main_frame">
	<a href="myinfo" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的资源
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <%@ include  file="mysource_leftnav_mytrade.jsp"%>
                    <hr class="hr_2" />
                    <span class="text_mgmt_leftnav1"><span
							id="mgmt_nav_switch2a" class="span_mgmt_nav1" title="收起"
							onclick="mgmt_nav_switch2a();"></span><span
							id="mgmt_nav_switch2b" class="span_mgmt_nav2" title="展开"
							onclick="mgmt_nav_switch2b();"></span>我的资源</span>
						<div id="mgmt_nav2">
                       <% if((Integer)session.getAttribute("userKind") ==3) {%><!-- 企业用户 -->
                        <a href="linetransport?flag=1&Display=10&PageNow=1" class="a_mgmt_leftnav" hidefocus="true">干线运输线路信息</a>
                        <a href="cityline?flag=1" class="a_mgmt_leftnav" hidefocus="true">城市配送网络信息</a>
                        <a href="car?flag=1" class="a_mgmt_leftnav1" hidefocus="true">车辆信息</a>
                        <a href="warehouse?flag=1" class="a_mgmt_leftnav" hidefocus="true">仓库信息</a>
						<a href="driver?flag=1" class="a_mgmt_leftnav" hidefocus="true">司机信息</a>
                        <a href="client" class="a_mgmt_leftnav" hidefocus="true">客户信息</a>
                        <a href="goodsform?flag=1" class="a_mgmt_leftnav" hidefocus="true">货物信息</a>
                        <%} %>
                        <a href="contract" class="a_mgmt_leftnav" hidefocus="true">合同信息</a>
                    </div>
                    <%@ include  file="mysource_leftnav_myplan.jsp"%>
                    <%@ include  file="mysource_leftnav_myanalysis.jsp"%>
                    <%@ include  file="mysource_leftnav_myaccount.jsp"%>
</div>
			</td>
			<td class="td_leftnav_top">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2a">
                    <tr>
                        <td>
                            <span class="span_mgmt_right2_text1">查看车辆信息</span>
                            <span class="span_mgmt_right2_text2"><a href="mgmt_r_car.htm" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                    </tr>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a"> 
                            <br />   	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">牌照号码：</td>
                                    <td>${carInfo.carNum }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">定位方式：</td>
                                    <td>${carInfo.locationType } (终端ID：${carInfo.terminalId })</td>
                                </tr>
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">当前位置：</td>
                                    <td>${carInfo.carLocation } &nbsp;&nbsp;<a href="javascript:;" hidefocus="true" title="刷新轨迹"><img src="images/btn_refresh1.png" />&nbsp;刷新</a>&nbsp;&nbsp;&nbsp;<a href="mgmt_r_car5.htm" hidefocus="true" title="查看地图"><img src="images/btn_map4.png" />查看</a></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">车型：</td>
                                    <td>${carInfo.carType } </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">厢型：</td>
                                    <td>${carInfo.carBase } </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">品牌：</td>
                                    <td>${carInfo.carBrand } </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">用途：</td>
                                    <td>${carInfo.carUse }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">规格：</td>
                                    <td>长${carInfo.carLength } × 宽 ${carInfo.carWidth } × 高 ${carInfo.carHeight } (米)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">载重：</td>
                                    <td>${carInfo.carWeight } (吨)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">购置日期：</td>
                                    <td>${carInfo.purchaseTime }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">冷藏：</td>
                                    <td>${carInfo.storage }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">司机姓名：</td>
                                    <td>${driverInfo.driverName }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">司机电话：</td>
                                    <td>${driverInfo.phone }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">运营线路：</td>
                                    <td>${linetransportInfo.startPlace }←→${linetransportInfo.endPlace }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">经停城市：</td>
                                    <td>${carInfo.stopPlace }</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
             </td>
		</tr>
    </table>
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
            	<textarea class="textarea_popup1" placeholder="请输入内容..."></textarea>
            </td>
        </tr>
        <tr>
            <td class="td_popup1">
                <input type="button" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" /><input type="button" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" />
            </td>
        </tr>
    </table>
</div>

<div id="footer_frame">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="views/footer.jsp"></iframe>
</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
	}
</script>
</html>