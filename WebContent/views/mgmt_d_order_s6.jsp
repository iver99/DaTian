<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% int userKind=(Integer)session.getAttribute("userKind"); %> 
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我提交的订单</title>
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
	<a href="myinfo" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的交易
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch1a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch1a();"></span><span id="mgmt_nav_switch1b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch1b();"></span>我的交易</span>
                    <div id="mgmt_nav1">
						<% if(userKind==2) {%><!-- 普通用户 -->
                        <a href="getallfocus" class="a_mgmt_leftnav" hidefocus="true">我的关注</a>
                        <%} %>
                       	<% if(userKind==3) {%><!-- 企业用户 -->
                        <a href="getallresponse" class="a_mgmt_leftnav" hidefocus="true">我的反馈</a>
                         <%} %>
                      <% if(userKind==2) {%> <!-- 普通用户 -->
                        <a href="sendorderinfo" class="a_mgmt_leftnav1" hidefocus="true">我提交的订单</a>
                      <%} %>
                      <% if(userKind==3) {%><!-- 企业用户 -->
                        <a href="recieveorderinfo" class="a_mgmt_leftnav" hidefocus="true">我收到的订单</a>
                       <%} %>
                        <a href="mysettlement" class="a_mgmt_leftnav" hidefocus="true">我的结算</a>
                        <% if(userKind==2) {%>  <!-- 普通用户 -->
                        <a href="mycomplaint" class="a_mgmt_leftnav" hidefocus="true">我的投诉</a>
                       <%} %>
						</div>
                   <%@ include  file="mysource_leftnav_myresource.jsp"%>
                    <%@ include  file="mysource_leftnav_myplan.jsp"%>
                    <%@ include  file="mysource_leftnav_myanalysis.jsp"%>
                    <%@ include  file="mysource_leftnav_myaccount.jsp"%>
</div>
			</td>
			<td class="td_leftnav_top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2a">
					<tr>
						<td>
							<span class="span_mgmt_right2_text1">我提交的订单</span>
                            <span class="span_mgmt_right2_text2"><a href="sendorderinfo" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
						</td>
					</tr>
				</table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a">
                        	<div class="span_mgmt_right3_text4">物流信息</div>
                            <div class="span_mgmt_right3_text2a"><a href="getOrderDetailCargoTrack?orderNum=${orderInfo.orderNum }&carNum=${orderInfo.carNum }" hidefocus="true">切换到货物轨迹</a></div>
                            <table width="90%" border="0" cellspacing="0" cellpadding="0" style="clear:both; margin-left:24px;">
                                <tr>
                                    <td width="120" height="35" class="td_mgmt_right3_td1c">2014-03-11 12:29:33</td>
                                    <td class="td_mgmt_right3_td1c">货物已装车，车牌号：京E45785<img src="images/btn_map3a.png" alt="GPS定位" /></td>
                                </tr>
                                <tr>
                                    <td height="35" class="td_mgmt_right3_td1c">2014-03-11 18:40:30</td>
                                    <td class="td_mgmt_right3_td1c">货物已经达到济南</td>
                                </tr>
                                <tr>
                                    <td height="35" class="td_mgmt_right3_td1c">2014-03-11 18:40:30</td>
                                    <td class="td_mgmt_right3_td1c">货物已经达到济南</td>
                                </tr>
                                <tr>
                                    <td height="35" class="td_mgmt_right3_td1c">2014-03-11 18:40:30</td>
                                    <td class="td_mgmt_right3_td1c">货物已经达到济南</td>
                                </tr>
                                <tr>
                                    <td height="35" class="td_mgmt_right3_td1c">2014-03-11 18:40:30</td>
                                    <td class="td_mgmt_right3_td1c">货物已经达到济南</td>
                                </tr>
                                <tr>
                                    <td height="35" class="td_mgmt_right3_td1c">2014-03-11 18:40:30</td>
                                    <td class="td_mgmt_right3_td1c">货物已经达到济南</td>
                                </tr>
                                <tr>
                                    <td height="35" class="td_mgmt_right3_td1c">2014-03-11 18:40:30</td>
                                    <td class="td_mgmt_right3_td1c">货物已经达到济南</td>
                                </tr>
                            </table>
                            <br />
                        	<div class="span_mgmt_right3_text4">基本信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">订单编号：</td>
                                    <td>${orderInfo.orderNum }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">所属客户：</td>
                                    <td>${orderInfo.clientName }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">关联客户运单：</td>
                                    <td>(未实现)无</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">承运方：</td>
                                    <td>${orderInfo.carrierName }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">承运方合同：</td>
                                    <td>${orderInfo.hasCarrierContract }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">资源分类：</td>
									<td>${orderInfo.resourceType }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">资源名称：</td>
									<td>（未实现）</td>
                                </tr>
                            </table>
                        	<div class="span_mgmt_right3_text4">货物信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">货物名称：</td>
                                    <td>${orderInfo.goodsName }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">货物重量：</td>
                                    <td>${orderInfo.goodsWeight } (公斤)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">货物体积：</td>
                                    <td>${orderInfo.goodsVolume } (立方米)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">货物声明价值：</td>
                                    <td>${orderInfo.declaredPrice } (元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">保险费：</td>
                                    <td>${orderInfo.insurance } (元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">运费：</td>
                                    <td>${orderInfo.expectedPrice } (元)</td>
                                </tr>
                            </table>
                        	<div class="span_mgmt_right3_text4">地址信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">发货人信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td width="250">&nbsp;</td>
                                    <td width="100" class="td_mgmt_right3_td1b">收货人信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">姓名：</td>
                                    <td>${orderInfo.deliveryName }</td>
                                    <td class="td_mgmt_right3_td1b">姓名：</td>
                                    <td>${orderInfo.recieverName }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">地址：</td>
                                    <td>${orderInfo.deliveryAddr }</td>
                                    <td class="td_mgmt_right3_td1b">地址：</td>
                                    <td>${orderInfo.recieverAddr }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">电话：</td>
                                    <td>${orderInfo.deliveryPhone }</td>
                                    <td class="td_mgmt_right3_td1b">电话：</td>
                                    <td>${orderInfo.recieverPhone }</td>
                                </tr>
                            </table>
                        	<div class="span_mgmt_right3_text4">备注信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">备注：</td>
                                    <td>${orderInfo.remarks }</td>
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