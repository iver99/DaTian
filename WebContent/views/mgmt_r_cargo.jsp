<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>供应链资源管理平台-货物信息</title>
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
	<a href="mgmt.htm" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的资源
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch1a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch1a();"></span><span id="mgmt_nav_switch1b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch1b();"></span>我的交易</span>
                    <div id="mgmt_nav1">
                        <a href="mgmt_d_focus.htm" class="a_mgmt_leftnav" hidefocus="true">我的关注</a>
                        <a href="mgmt_d_response.htm" class="a_mgmt_leftnav" hidefocus="true">我的反馈</a>
                        <a href="mgmt_d_order_s.htm" class="a_mgmt_leftnav" hidefocus="true">我提交的订单</a>
                        <a href="mgmt_d_order_r.htm" class="a_mgmt_leftnav" hidefocus="true">我收到的订单</a>
                        <a href="mgmt_d_settle_s.htm" class="a_mgmt_leftnav" hidefocus="true">我的结算</a>
                        <a href="mgmt_d_complain.htm" class="a_mgmt_leftnav" hidefocus="true">我的投诉</a>
                    </div>
                    <hr class="hr_2" />
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch2a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch2a();"></span><span id="mgmt_nav_switch2b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch2b();"></span>我的资源</span>
                    <div id="mgmt_nav2">
                    <div id="mgmt_nav2">
                        <a href="mgmt_r_line.htm" class="a_mgmt_leftnav" hidefocus="true">干线运输线路信息</a>
                        <a href="mgmt_r_city.htm" class="a_mgmt_leftnav" hidefocus="true">城市配送网络信息</a>
                        <a href="mgmt_r_car.htm" class="a_mgmt_leftnav" hidefocus="true">车辆信息</a>
                        <a href="mgmt_r_warehouse.htm" class="a_mgmt_leftnav" hidefocus="true">仓库信息</a>
                        <a href="mgmt_r_driver.htm" class="a_mgmt_leftnav" hidefocus="true">司机信息</a>
                        <a href="mgmt_r_customer.htm" class="a_mgmt_leftnav" hidefocus="true">客户信息</a>
                        <a href="mgmt_r_cargo.htm" class="a_mgmt_leftnav1" hidefocus="true">货物信息</a>
                        <a href="mgmt_r_contact_s.htm" class="a_mgmt_leftnav" hidefocus="true">合同信息</a>
                    </div>
                    <hr class="hr_2" />
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch3a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch3a();"></span><span id="mgmt_nav_switch3b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch3b();"></span>我的方案</span>
                    <div id="mgmt_nav3">
                        <a href="mgmt_p_template.htm" class="a_mgmt_leftnav" hidefocus="true">方案模板信息</a>
                        <a href="mgmt_p_appraise.htm" class="a_mgmt_leftnav" hidefocus="true">方案报价评估</a>
                    </div>
                    <hr class="hr_2" />
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch4a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch4a();"></span><span id="mgmt_nav_switch4b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch4b();"></span>统计分析</span>
                    <div id="mgmt_nav4">
                        <a href="mgmt_s_opr.htm" class="a_mgmt_leftnav" hidefocus="true">运营指标</a>
                        <a href="mgmt_s_veh.htm" class="a_mgmt_leftnav" hidefocus="true">车辆指标</a>
                        <a href="mgmt_s_fin.htm" class="a_mgmt_leftnav" hidefocus="true">财务指标</a>
                    </div>
                    <hr class="hr_2" />
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch5a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch5a();"></span><span id="mgmt_nav_switch5b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch5b();"></span>我的帐户</span>
                    <div id="mgmt_nav5">
                        <a href="mgmt_a_info.htm" class="a_mgmt_leftnav" hidefocus="true">帐户信息</a>
                        <a href="mgmt_a_subaccount.htm" class="a_mgmt_leftnav" hidefocus="true">附属帐户</a>
                        <a href="mgmt_a_address.htm" class="a_mgmt_leftnav" hidefocus="true">常用地址</a>
                        <a href="mgmt_a_pwd.htm" class="a_mgmt_leftnav" hidefocus="true">密码修改</a>
                    </div>
</div>
			</td>
			<td class="td_leftnav_top">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2">
                    <tr>
                    	<td>
                        	<span class="span_mgmt_right2_text1">货物信息</span>
                            <span class="span_mgmt_right2_text2"><a href="mgmt_r_cargo2.htm" hidefocus="true"><img src="images/btn_add1.png" class="span_mgmt_right2_pic1" title="添加" /></a></span>
                        </td>
                	</tr>
            	</table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td width="20" height="40" class="td_mgmt_right3_head1">&nbsp;</td>
                        <td width="90" class="td_mgmt_right3_head">编号</td>
                        <td class="td_mgmt_right3_head">货物名称</td>
                        <td width="80" class="td_mgmt_right3_head">发布日期</td>
                        <td width="80" class="td_mgmt_right3_head">有效期至</td>
                        <td width="50" class="td_mgmt_right3_head">反馈方</td>
                        <td width="60" class="td_mgmt_right3_head">反馈数量</td>
                        <td width="60" class="td_mgmt_right3_head">状态</td>
                        <td width="80" class="td_mgmt_right3_head">操作</td>
                    </tr>
                    <tbody>
                        <c:forEach var="goodsinfo" items="${goodsinfoList }">
                        <tr>
                            <td class="td_main_list_content"></td>
                            <td class="td_main_list_content">${goodsinfo.id }</td>
                            <td class="td_main_list_content">
                                <a href="companyDetail?id=${goodsinfo.name }" hidefocus="true">${goodsinfo.name }</a>
                            </td>
                            <td class="td_main_list_content">${goodsinfo.relDate }</td>
                            <td class="td_main_list_content">${goodsinfo.limitDate }</td>
                            <td class="td_main_list_content">${goodsinfo.oriented }</td>
                            <td class="td_main_list_content">${goodsinfo.feedbackQuantity }</td>
                            <td class="td_main_list_content">${goodsinfo.state }</td>
                            <td class="td_main_list_content">
                                <c:if test="${goodsinfo.state=='待确认'}">
									<div id="handlebox" style="z-index:203;">
	                                <ul class="quickmenu">
	                                    <li class="menuitem">
	                                        <div class="menu">
	                                            <a href="mgmt_r_cargo5a.htm" class="menuhd" hidefocus="true">查看反馈</a>
	                                            <div class="menubd">
	                                                <div class="menubdpanel">
	                                                    <a href="mgmt_r_cargo3.htm" class="a_top3" hidefocus="true">更新</a>
	                                                    <a href="javascript:;" class="a_top3" hidefocus="true">删除</a>
	                                                </div>
	                                            </div>
	                                        </div>
	                                    </li>
	                                </ul>
                                    </div>
								</c:if>
								<c:if test="${goodsinfo.state=='已确认'}">
									<a href="mgmt_r_cargo5b.htm" hidefocus="true">查看反馈</a>
								</c:if>
								<c:if test="${goodsinfo.state=='已取消'}">
									<a href="mgmt_r_cargo5b.htm" hidefocus="true">查看</a>
								</c:if>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
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

<div id="footer_frame">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.htm"></iframe>
</div>

</body>

</html>