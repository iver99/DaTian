<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>供应链资源管理平台-我的信息</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/mgmt.js"></script>
<script type="text/javascript" src="js/raphael.2.1.0.min.js"></script>
<script type="text/javascript" src="js/justgage.1.0.1.min.js"></script>
<script type="text/javascript" src="js/dashboard.js"></script>
<script type="text/javascript" src="js/backtop.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<script type="text/javascript"> 
	$(function() {
		$('input, textarea').placeholder(); 
	});
</script>
</head>

<body>
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
	<span class="text_main_title1">我的信息</span>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch1a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch1a();"></span><span id="mgmt_nav_switch1b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch1b();"></span>我的交易</span>
                    <div id="mgmt_nav1" class="div_mgmt_show1">
                        <a href="mgmt_d_focus.htm" class="a_mgmt_leftnav" hidefocus="true">我的关注</a>
                        <a href="getallresponse" class="a_mgmt_leftnav" hidefocus="true">我的反馈</a>
                        <a href="sendorderinfo" class="a_mgmt_leftnav" hidefocus="true">我提交的订单</a>
                        <a href="recieveorderinfo" class="a_mgmt_leftnav" hidefocus="true">我收到的订单</a>
                        <a href="mgmt_d_settle_s.htm" class="a_mgmt_leftnav" hidefocus="true">我的结算</a>
                        <a href="mycomplaint" class="a_mgmt_leftnav" hidefocus="true">我的投诉</a>
                    </div>
                    <hr class="hr_2" />
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch2a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch2a();"></span><span id="mgmt_nav_switch2b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch2b();"></span>我的资源</span>
                    <div id="mgmt_nav2" class="div_mgmt_show1">
                        <a href="linetransport?flag=1&Display=10&PageNow=1" class="a_mgmt_leftnav" hidefocus="true">干线运输线路信息</a>
                        <a href="cityline?flag=1" class="a_mgmt_leftnav" hidefocus="true">城市配送网络信息</a>
                        <a href="car?flag=1" class="a_mgmt_leftnav" hidefocus="true">车辆信息</a>
                        <a href="warehouse?flag=1" class="a_mgmt_leftnav" hidefocus="true">仓库信息</a>
						<a href="driver?flag=1" class="a_mgmt_leftnav" hidefocus="true">司机信息</a>
                        <a href="client" class="a_mgmt_leftnav" hidefocus="true">客户信息</a>
                        <a href="mgmt_r_cargo.htm" class="a_mgmt_leftnav" hidefocus="true">货物信息</a>
                        <a href="contract" class="a_mgmt_leftnav" hidefocus="true">合同信息</a>
                    </div>
                    <hr class="hr_2" />
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch3a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch3a();"></span><span id="mgmt_nav_switch3b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch3b();"></span>我的方案</span>
                    <div id="mgmt_nav3" class="div_mgmt_show1">
                        <a href="mgmt_p_template.htm" class="a_mgmt_leftnav" hidefocus="true">方案模板信息</a>
                        <a href="mgmt_p_appraise.htm" class="a_mgmt_leftnav" hidefocus="true">方案报价评估</a>
                    </div>
                    <hr class="hr_2" />
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch4a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch4a();"></span><span id="mgmt_nav_switch4b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch4b();"></span>统计分析</span>
                    <div id="mgmt_nav4" class="div_mgmt_show1">
                        <a href="mgmt_s_opr.htm" class="a_mgmt_leftnav" hidefocus="true">运营指标</a>
                        <a href="mgmt_s_veh.htm" class="a_mgmt_leftnav" hidefocus="true">车辆指标</a>
                        <a href="mgmt_s_fin.htm" class="a_mgmt_leftnav" hidefocus="true">财务指标</a>
                    </div>
                    <hr class="hr_2" />
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch5a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch5a();"></span><span id="mgmt_nav_switch5b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch5b();"></span>我的帐户</span>
                    <div id="mgmt_nav5" class="div_mgmt_show1">
                        <a href="accountinfo" class="a_mgmt_leftnav" hidefocus="true">帐户信息</a>
                        <a href="getsubaccount" class="a_mgmt_leftnav" hidefocus="true">附属帐户</a>
                        <a href="mgmt_a_address.htm" class="a_mgmt_leftnav" hidefocus="true">常用地址</a>
                        <a href="mgmt_a_security.htm" class="a_mgmt_leftnav" hidefocus="true">安全设置</a>
                    </div>
</div>
			</td>
			<td class="td_leftnav_top">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right1">
                	<tr>
                    	<td class="td_mgmt_index1">
                        	<div class="div_mgmt_index1">
                                <span class="span_mgmt_right1_text1">李强，欢迎您！<br /><img src="images/btn_level1a.png" /></span>
                            </div>
                        	<div class="div_mgmt_index2">
                                <div class="div_mgmt_index2a">
                                	 本月已结算金额 (元)
                                     <a href="mgmt_d_settle_s.htm" class="a_mgmt_right1_text2a" hidefocus="true">130,992.00</a>
                                </div>
                                <div class="div_mgmt_index2b">
                                	 本月待结算金额 (元)
                                     <a href="mgmt_d_settle_s.htm" class="a_mgmt_right1_text2b" hidefocus="true">52,657.00</a>
                                </div>
                            </div>
                        </td>
                	</tr>
            	</table>
            	<br />
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right1a">
                	<tr>
                    	<td class="td_mgmt_index1">
                        	<div class="div_mgmt_index3">
                                <span class="span_mgmt_right1_text1a">完成情况</span>
                            </div>
                        	<div class="div_mgmt_index4">
                                <ul class="ul_mgmt_index">
                                	<li class="li_mgmt_index3">
                                    	<div id="div_mgmt_dashboard1"></div>
                                    </li>
                                	<li class="li_mgmt_index3">
                                    	<div id="div_mgmt_dashboard2"></div>
                                    </li>
                                </ul>
                            </div>
                        </td>
                	</tr>
            	</table>
                <br />
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right1">
                	<tr>
                    	<td class="td_mgmt_index1">
                        	<div class="div_mgmt_index3">
                                <span class="span_mgmt_right1_text1a">交易情况</span>
                            </div>
                        	<div class="div_mgmt_index4">
                                <ul class="ul_mgmt_index">
                                	<li class="li_mgmt_index1">
                                    	待发货<br />
                                        <a href="javascript:;" hidefocus="true"><img src="images/btn_mgmt1.png" /><br />12</a>
                                    </li>
                                	<li class="li_mgmt_index1">
                                    	待收货<br />
                                        <a href="javascript:;" hidefocus="true"><img src="images/btn_mgmt2.png" /><br />12</a>
                                    </li>
                                	<li class="li_mgmt_index1">
                                    	待结算<br />
                                        <a href="javascript:;" hidefocus="true"><img src="images/btn_mgmt3.png" /><br />12</a>
                                    </li>
                                	<li class="li_mgmt_index2">
                                    	已完成<br />
                                        <a href="javascript:;" hidefocus="true"><img src="images/btn_mgmt4.png" /><br />12</a>
                                    </li>
                                </ul>
                            </div>
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
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.htm"></iframe>
</div>

</body>
</html>