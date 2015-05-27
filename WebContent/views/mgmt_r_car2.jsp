<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% int userKind=(Integer)session.getAttribute("userKind"); %> 
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
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/mgmt.js"></script>
<script type="text/javascript" src="js/citylist.js"></script>
<script type="text/javascript" src="js/cityquery.js"></script>
<script type="text/javascript" src="js/dynamic_div1.js"></script>
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
            <a href="javascript:;" onclick="window.open('http://b.qq.com/webc.htm?new=0&sid=11223344&o=abc.com&q=1', '_blank')" hidefocus="true">咨询提问</a>
            <a href="javascript:;" hidefocus="true">意见建议</a>
            <div class="qqserver_comment" onclick="showid('popup1');" hidefocus="true">
                给我留言
            </div>
            <a href="javascript:;" class="a1" hidefocus="true">查看历史记录</a>
        </div>
    </div>
    <a id="backtop" onclick="return false;" title="回到顶部"></a> 
</div>

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
                       <% if(userKind==3) {%><!-- 企业用户 -->
                        <a href="linetransport?flag=1&Display=10&PageNow=1" class="a_mgmt_leftnav" hidefocus="true">干线运输线路信息</a>
                        <a href="cityline?flag=1" class="a_mgmt_leftnav" hidefocus="true">城市配送网络信息</a>
                        <a href="car?flag=1" class="a_mgmt_leftnav1" hidefocus="true">车辆信息</a>
                        <a href="warehouse?flag=1" class="a_mgmt_leftnav" hidefocus="true">仓库信息</a>
						<a href="driver?flag=1" class="a_mgmt_leftnav" hidefocus="true">司机信息</a>
                        <a href="client" class="a_mgmt_leftnav" hidefocus="true">客户信息</a>
                        <a href="goodsform?flag=1" class="a_mgmt_leftnav" hidefocus="true">货物信息</a>
                        <%} %>
                         <% if(userKind==2) {%><!-- 普通用户 -->
                        <a href="contract" class="a_mgmt_leftnav" hidefocus="true">合同信息</a>
                        <%} %>
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
                            <span class="span_mgmt_right2_text1">添加车辆信息</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                    </tr>
				</table>
				<form action="insertCar" method="post" name="insertCar">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a">
                            <br />
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">牌照：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" name="carNum"/></td>
                                </tr>
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">所属车队：</td>
                                    <td>
                                        <select style="width:120px;" name="carTeam">
                                            <option value="" selected="selected">请选择</option>
                                            <option value="北京车队">北京车队</option>
                                            <option value="天津车队">天津车队</option>
                                            <option value="上海车队">上海车队</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">定位方式：</td>
                                    <td>
                                        <select id="pos" style="width:120px;" onchange="change_pos();" name="locationType">
                                            <option value="" selected="selected">请选择</option>
                                            <option value="GPS">GPS</option>
                                            <option value="手机">手机</option>
                                            <option value="无">无</option>
                                        </select>
                                        <div id="pos_detail_1" style="display:none;">
                                            <input type="text" class="input_mgmt1" style="width:176px;" placeholder="请输入终端设备编码..." name="terminalId" />
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">车型：</td>
                                    <td>
                                        <select style="width:120px;" name="carType">
                                            <option value="" selected="selected">请选择</option>
                                            <option value="前四后四">前四后四</option>
                                            <option value="单桥">单桥</option>
                                            <option value="其他">其他</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">厢型：</td>
                                    <td>
                                        <select style="width:120px;" name="carBase">
                                            <option value="" selected="selected">请选择</option>
                                            <option value="普通">普通</option>
                                            <option value="平板">平板</option>
                                            <option value="厢式">厢式</option>
                                            <option value="开顶厢">开顶厢</option>
                                            <option value="集装箱">集装厢</option>
                                            <option value="高栏">高栏</option>
                                            <option value="其他结构">其他结构</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">品牌：</td>
                                    <td>
                                        <select name="carBrand" id="menu_name4" class="select_apply1" style="width:120px;">
                                            <option value="" selected="selected">请选择</option>
                                            <option value="解放">解放</option>
                                            <option value="福田">福田</option>
                                            <option value="东风">东风</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">用途：</td>
                                    <td>
                                        <select style="width:120px;" name="carUse">
                                            <option value="" selected="selected">请选择</option>
                                            <option value="普通运输">普通运输</option>
                                            <option value="特殊">特殊</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">规格：</td>
                                    <td>
                                    长&nbsp;<input type="text" class="input_mgmt1" style="width:46px;" name="carLength" />
                                    (米)&nbsp;&nbsp;×&nbsp;&nbsp;宽&nbsp;<input type="text" class="input_mgmt1" style="width:46px;" name="carWidth"/>
                                    (米)&nbsp;&nbsp;×&nbsp;&nbsp;高&nbsp;<input type="text" class="input_mgmt1" style="width:46px;" name="carHeight"/>
                                    (米)
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">载重：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" name="carWeight" />
                                    (吨)
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">购置日期：</td>
                                    <td><input type="text" class="input_date1" onclick="SelectDate(this,'yyyy-MM-dd')" readonly="readonly" title="点击此处选择" name="purchaseTime"/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b" >冷藏：</td>
                                    <td>
                                        <select style="width:120px;" name="storage">
                                            <option value="" selected="selected">请选择</option>
                                            <option value="是">是</option>
                                            <option value="否">否</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">司机姓名：</td>
                                    <td>
                                        <select style="width:120px;" name="driverId">
                                            <option value="" selected="selected">请选择</option>
                                            <c:forEach var="driverList" items="${driverList }">
                                            <option value="${driverList.id }">${driverList.driverName }</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">运营线路：</td>
                                    <td id="cityselector">
                                    <div>
                                        <input id="city1" type="text" value="" class="input_city1" name="startPlace"/>
                                        &nbsp;&nbsp;至&nbsp;&nbsp;
                                        <input id="city2" type="text" value="" class="input_city1" name="endPlace"/>
                                    </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">经停城市：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${carInfo.stopPlace }" name="stopPlace"/>
                                </tr>
                                <tr>
                                    <td height="1"></td>
                                    <td><div id="dym_citylist"></div></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
                                    <td><input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" />
                                    <input type="button" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" /></td>
                                </tr>
                            </table>
                            </
                        </td>
                    </tr>
                </table>
                </form>
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