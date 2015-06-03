<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户验证</title>
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
	<a href="mgmt_m.htm" hidefocus="true" class="a_text_main_title1">后台管理</a>&nbsp;&gt;&nbsp;客户服务
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch1a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch1a();"></span><span id="mgmt_nav_switch1b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch1b();"></span>客户服务</span>
                    <div id="mgmt_nav1">
                        <a href="allcomplaint" class="a_mgmt_leftnav" hidefocus="true">投诉管理</a>
                        <a href="mgmt_m_register.htm" class="a_mgmt_leftnav1" hidefocus="true">用户验证</a>
                    </div>
                    <!-- <hr class="hr_2" />
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch2a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch2a();"></span><span id="mgmt_nav_switch2b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch2b();"></span>平台运营</span>
                    <div id="mgmt_nav2">
                        <a href="mgmt_m_pricetemplate.htm" class="a_mgmt_leftnav" hidefocus="true">报价模板信息</a>
                        <a href="mgmt_m_carmonitor.htm" class="a_mgmt_leftnav" hidefocus="true">车辆监控</a>
                    </div> -->
                </div>
			</td>
			<td class="td_leftnav_top">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2">
                    <tr>
                    	<td>
                        	<span class="span_mgmt_right2_text1">用户验证</span>
                            <div class="div_mgmt_s1">
                            	<input type="text" class="input_mgmt1" style="width:200px;" value="用户名..." />
                                <input type="button" id="btn1" value="查询" class="btn_mgmt3" hidefocus="true" />
                            </div>
                        </td>
                	</tr>
				</table>
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
					<tr>
                        <td width="20" height="40" class="td_mgmt_right3_head1">&nbsp;</td>
                        <td width="80" class="td_mgmt_right3_head">类别</td>
                        <td class="td_mgmt_right3_head">用户名</td>
                        <td width="80" class="td_mgmt_right3_head">提交时间</td>
                        <td width="50" class="td_mgmt_right3_head">状态</td>
                        <td width="80" class="td_mgmt_right3_head">操作</td>
					</tr>
					<c:forEach var="validate" items="${validateList }">
					<tr>
                        <td height="60" class="td_mgmt_right3_td1d">&nbsp;</td>
                        <td class="td_mgmt_right3_td1">个人</td>
                        <td class="td_mgmt_right3_td1">${validate.username }</td>
                        <td class="td_mgmt_right3_td1">${validate.validateTime }</td>
                        <td class="td_mgmt_right3_td1">${validate.status }</td>
                        <c:choose>
                        <c:when test="${validate.status=='审核中' }">
                        <td class="td_mgmt_right3_td3"><a href="authenticdetail?clientId=${validate.id }&flag=2" hidefocus="true">审核</a></td>
						</c:when>
						<c:otherwise>
						<td class="td_mgmt_right3_td3"><a href="authenticview?clientId=${validate.id }" hidefocus="true">查看</a></td>
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
                        <td width="45" class="td_pagenumber"><a href="mgmt_r_contact_r.htm" class="a_pagenumber" hidefocus="true">上页</a></td>
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
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
	}
</script>
</html>