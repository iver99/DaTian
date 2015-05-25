<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<script type="text/javascript">
var orderid=123;
function cancel(id){
	
    showid('popup2');
}
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
                        <a href="mgmt_d_focus.htm" class="a_mgmt_leftnav" hidefocus="true">我的关注</a>
                        <a href="getallresponse" class="a_mgmt_leftnav" hidefocus="true">我的反馈</a>
                        <a href="sendorderinfo" class="a_mgmt_leftnav1" hidefocus="true">我提交的订单</a>
                        <a href="recieveorderinfo" class="a_mgmt_leftnav" hidefocus="true">我收到的订单</a>
                        <a href="mysettlement" class="a_mgmt_leftnav" hidefocus="true">我的结算</a>
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
                        	<span class="span_mgmt_right2_text1">我提交的订单</span>
                            <div class="div_mgmt_s1">
                            	<input type="text" class="input_mgmt1" style="width:200px;" value="订单内容..." />
                                <input type="button" id="btn1" value="查询" class="btn_mgmt3" hidefocus="true" />
                            </div>
                        </td>
                	</tr>
            	</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
					<tr>
                        <td width="20" height="40" class="td_mgmt_right3_head">&nbsp;</td>
                        <td width="100" class="td_mgmt_right3_head">订单编号</td>
                        <td width="60" class="td_mgmt_right3_head">类别</td>
                        <td class="td_mgmt_right3_head">名称</td>
                        <td width="120" class="td_mgmt_right3_head">承运方</td>
                        <td width="88" class="td_mgmt_right3_head">订单运费(元)</td>
                        <td width="88" class="td_mgmt_right3_head">最终运费(元)</td>
                        <td width="80" class="td_mgmt_right3_head">提交时间</td>
                        <td width="60" class="td_mgmt_right3_head">状态</td>
                        <td width="80" class="td_mgmt_right3_head">操作</td>
					</tr>
					<c:forEach var="orderinfo" items="${orderList }">
					<tr>
                        <td height="60" class="td_mgmt_right3_td1d">&nbsp;</td>
                        <td class="td_mgmt_right3_td1"><a href="orderDetail?orderid=${orderinfo.id }" hidefocus="true">${orderinfo.orderNum }</a></td>
                        <td class="td_mgmt_right3_td1">线路</td>
                        <td class="td_mgmt_right3_td1"><a href="resource_detail1.htm" class="link1" hidefocus="true">北京→上海</a></td>
                        <td class="td_mgmt_right3_td1"><a href="javascript:;" class="link1" hidefocus="true">${orderinfo.carrierName }</a></td>
                        <td class="td_mgmt_right3_td1">${orderinfo.expectedPrice }</td>
                        <td class="td_mgmt_right3_td1">${orderinfo.actualPrice }</td>
                        <td class="td_mgmt_right3_td1">${orderinfo.submitTime }<br />
                            </td>
                        <c:choose>
                        <c:when test="${orderinfo.state == '待受理' }">
                        <td class="td_mgmt_right3_td2">待受理</td>
                        <td class="td_mgmt_right3_td3">
                            <div id="handlebox" style="z-index:204;">
                                <ul class="quickmenu">
                                    <li class="menuitem">
                                        <div class="menu">
                                            <a href="updateOrder?orderid=${orderinfo.id }" class="menuhd" hidefocus="true">更新</a>
                                            <div class="menubd">
                                                <div class="menubdpanel">
                                                    <a href="cancelOrder?orderid=${orderinfo.id }" class="a_top3" hidefocus="true">取消</a>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </td>
                        </c:when>
                        
                        <c:when test="${orderinfo.state == '待收货' }">
                        <td class="td_mgmt_right3_td2">待收货</td>
                        <td class="td_mgmt_right3_td3"><a href="orderDetailWaitToReceive?orderid=${orderinfo.id }" hidefocus="true">查看</a></td>
                        </c:when>
                        
                        <c:when test="${orderinfo.state == '待确认' }">
                        <td class="td_mgmt_right3_td2">待确认</td>
                        <td class="td_mgmt_right3_td3">
                            <div id="handlebox" style="z-index:202;">
                                <ul class="quickmenu">
                                    <li class="menuitem">
                                        <div class="menu">
                                            <a href="getConfirmForm?orderid=${orderinfo.id }" class="menuhd" hidefocus="true">收货确认</a>
                                            <div class="menubd">
                                                <div class="menubdpanel">
                                                    <a href="orderDetailWaitToReceive?orderid=${orderinfo.id }" class="a_top3" hidefocus="true">查看</a>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </td>
                        </c:when>
                        
                        <c:when test="${orderinfo.state == '待评价' }">
                        <td class="td_mgmt_right3_td2">待评价</td>
                        <td class="td_mgmt_right3_td3">
                            <div id="handlebox" style="z-index:201;">
                                <ul class="quickmenu">
                                    <li class="menuitem">
                                        <div class="menu">
                                            <a href="getCommentForm?orderid=${orderinfo.id }" class="menuhd" hidefocus="true">评价</a>
                                            <div class="menubd">
                                                <div class="menubdpanel">
                                                    <a href="orderDetailComment?orderid=${orderinfo.id }" class="a_top3" hidefocus="true">查看</a>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </td>
                        </c:when>
                        
                        <c:when test="${orderinfo.state == '已完成' }">
                        <td class="td_mgmt_right3_td1">已完成</td>
                        <td class="td_mgmt_right3_td3"><a href="orderDetailFinish?orderid=${orderinfo.id }" hidefocus="true">查看</a></td>
                        </c:when>
                        
                        <c:when test="${orderinfo.state == '已取消' }">
                         <td class="td_mgmt_right3_td1">已取消</td>
                        <td class="td_mgmt_right3_td3"><a href="orderDetailAlreadyCancel?orderid=${orderinfo.id }" hidefocus="true">查看</a></td>
                        </c:when>
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
                        <td width="45" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">上页</a></td>
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

<div id="popup2" style="display:none;">
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="510"><div class="div_popup_title1">取消订单的原因</div></td>
            <td>
                <div id="close2" style="cursor:pointer;"><img src="images/btn_cancel1.png" title="关闭本窗口" /></div>
            </td>
        </tr>
    </table>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="540">
            	<textarea name="explainReason" class="textarea_popup1" placeholder="请输入内容..."></textarea>
            </td>
        </tr>
        <tr>
            <td class="td_popup1">
                <input type="button" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" /><input type="reset" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" />
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