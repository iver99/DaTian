<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的结算</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/mgmt.js"></script>
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/backtop.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
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
	<a href="myinfo" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的交易
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch1a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch1a();"></span><span id="mgmt_nav_switch1b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch1b();"></span>我的交易</span>
                    <div id="mgmt_nav1">
                        <a href="mgmt_d_focus.htm" class="a_mgmt_leftnav" hidefocus="true">我的关注</a>
                        <a href="getallresponse" class="a_mgmt_leftnav" hidefocus="true">我的反馈</a>
                        <a href="sendorderinfo" class="a_mgmt_leftnav" hidefocus="true">我提交的订单</a>
                        <a href="recieveorderinfo" class="a_mgmt_leftnav" hidefocus="true">我收到的订单</a>
                        <a href="mysettlement" class="a_mgmt_leftnav1" hidefocus="true">我的结算</a>
                        <a href="mycomplaint" class="a_mgmt_leftnav" hidefocus="true">我的投诉</a>
                    </div>
                   <%@ include  file="mysource_leftnav_myresource.jsp"%>
                    <%@ include  file="mysource_leftnav_myplan.jsp"%>
                    <%@ include  file="mysource_leftnav_myanalysis.jsp"%>
                    <%@ include  file="mysource_leftnav_myaccount.jsp"%>
</div>
			</td>
			<td class="td_leftnav_top">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2">
                    <tr>
                    	<td>
                        	<span class="span_mgmt_right2_text1">我的结算(需求方)</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:;" hidefocus="true" class="a_btn_mgmt4">批量生成对账单</a></span>
                            <div class="div_mgmt_s1">
                                <input type="text" class="input_date1" onclick="SelectDate(this,'yyyy-MM-dd')" value="开始时间" readonly="readonly" title="点击选择" />
                                &nbsp;&nbsp;至&nbsp;&nbsp;
                                <input type="text" class="input_date1" onclick="SelectDate(this,'yyyy-MM-dd')" value="结束时间" readonly="readonly" title="点击选择" />
                                &nbsp;&nbsp;<input type="text" class="input_mgmt1" style="width:180px;" placeholder="承运方名称或承运方合同编号..." />
                                <input type="button" id="btn1" value="查询" class="btn_mgmt3" hidefocus="true" />
                            </div>
                        </td>
                	</tr>
            	</table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td width="30" height="40" class="td_mgmt_right3_head1"><input type="checkbox" id="f1_all" onClick="selectall();" /></td>
                        <td width="100" class="td_mgmt_right3_head">订单编号</td>
                        <td class="td_mgmt_right3_head">客户名称</td>
                        <td class="td_mgmt_right3_head">承运方</td>
                        <td width="100" class="td_mgmt_right3_head">承运方合同编号</td>
                        <td width="80" class="td_mgmt_right3_head">订单完成时间</td>
                        <td width="88" class="td_mgmt_right3_head">订单运费(元)</td>
                        <td width="88" class="td_mgmt_right3_head">最终运费(元)</td>
                        <td width="60" class="td_mgmt_right3_head">状态</td>
                        <td width="90" class="td_mgmt_right3_head">操作</td>
                    </tr>
                    <c:forEach var="order" items="${orderList }">
                    <tr>
                        <td height="60" class="td_mgmt_right3_td1d"><input type="checkbox" name="f1" id="f1a" /></td>
                        <td class="td_mgmt_right3_td1"><a href="mgmt_d_order_s6a.htm" hidefocus="true">${order.orderNum }</a></td>
                        <td class="td_mgmt_right3_td1"><a href="javascript:;" class="link1" hidefocus="true">${order.clientName }</a></td>
                        <td class="td_mgmt_right3_td1"><a href="javascript:;" class="link1" hidefocus="true">${order.companyName }</a></td>
                        <td class="td_mgmt_right3_td1"><a href="mgmt_r_contact_s4.htm" class="link1">${order.contractId }</a></td>
                        <td class="td_mgmt_right3_td1">${order.submitTime }</td>
                        <td class="td_mgmt_right3_td1">${order.expectedPrice }</td>
                        <td class="td_mgmt_right3_td1">${order.actualPrice }</td>
                        <%-- <td class="td_mgmt_right3_td2">${order.settlementState }</td> --%>
                        <c:choose>
                        	<c:when test="${order.settlementState =='已生成'}">
                        	<td class="td_mgmt_right3_td1">${order.settlementState }</td>
                        		<td class="td_mgmt_right3_td3"><a href="mgmt_d_settle_s2.htm" hidefocus="true">查看记录</a></td>
                        	</c:when>
                        	<c:otherwise>
                        	 	<td class="td_mgmt_right3_td2">${order.settlementState }</td>
                        		<td class="td_mgmt_right3_td3"><a href="javascript:;" hidefocus="true">生成对账单</a></td>
                        	</c:otherwise>
                        	
                        </c:choose>
                        
                    </tr>
                    </c:forEach>
                   
                </table>
				<table border="0" cellpadding="0" cellspacing="0" class="table_recordnumber">
                    <tr>
	                    <td>
                            每页
                            <select>
                                <option value="" selected="selected">10</option>
                                <option value="a">20</option>
                                <option value="b">50</option>
                            </select>
                            条记录
                        </td>
                    </tr>
				</table>
                <table border="0" cellpadding="0" cellspacing="0" class="table_pagenumber">
                    <tr>
                        <td width="45" class="td_pagenumber">首页</td>
                        <td width="45" class="td_pagenumber"><a href="mgmt_d_settle_r.htm" class="a_pagenumber" hidefocus="true">上页</a></td>
                        <td width="30" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">1</a></td>
                        <td width="30" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">2</a></td>
                        <td width="30" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">3</a></td>
                        <td width="45" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">下页</a></td>
                        <td width="45" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">末页</a></td>
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
</html>