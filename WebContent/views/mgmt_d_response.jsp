<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的反馈</title>
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
<%@ include file="jsTool.jsp" %>
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
	<a href="myinfo" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的交易
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch1a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch1a();"></span><span id="mgmt_nav_switch1b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch1b();"></span>我的交易</span>
                    <div id="mgmt_nav1">
						<% if((Integer)session.getAttribute("userKind") ==2) {%><!-- 普通用户 -->
                        <a href="getallfocus" class="a_mgmt_leftnav" hidefocus="true">我的关注</a>
                        <%} %>
                       	<% if((Integer)session.getAttribute("userKind") ==3) {%><!-- 企业用户 -->
                        <a href="getallresponse" class="a_mgmt_leftnav1" hidefocus="true">我的反馈</a>
                         <%} %>
                      <% if((Integer)session.getAttribute("userKind") ==2) {%> <!-- 普通用户 -->
                        <a href="sendorderinfo" class="a_mgmt_leftnav" hidefocus="true">我提交的订单</a>
                      <%} %>
                      <% if((Integer)session.getAttribute("userKind") ==3) {%><!-- 企业用户 -->
                        <a href="recieveorderinfo" class="a_mgmt_leftnav" hidefocus="true">我收到的订单</a>
                       <%} %>
                        <a href="mysettlement" class="a_mgmt_leftnav" hidefocus="true">我的结算</a>
                        <% if((Integer)session.getAttribute("userKind") ==2) {%>  <!-- 普通用户 -->
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
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="table_mgmt_right2">
						<tr>
							<td><span class="span_mgmt_right2_text1">我的反馈</span></td>
						</tr>
					</table>
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="table_mgmt_right3">
						<tr>
							<td width="20" height="40" class="td_mgmt_right3_head">&nbsp;</td>
							<td width="90" class="td_mgmt_right3_head">编号</td>
							<td class="td_mgmt_right3_head">货物名称</td>
							<td width="80" class="td_mgmt_right3_head">提交日期</td>
							<td width="60" class="td_mgmt_right3_head">状态</td>
							<td width="80" class="td_mgmt_right3_head">操作</td>
						</tr>
						<c:forEach var="resp" items="${responseList }">
							<tr>
								<td height="60" class="td_mgmt_right3_td1d">&nbsp;</td>
								<td class="td_mgmt_right3_td1">${resp.id }</td>
								<td class="td_mgmt_right3_td1"><a
									href="goodsdetail?id=${resp.id }" hidefocus="true">${resp.name }</a></td>
								<td class="td_mgmt_right3_td1">${resp.relDate }</td>
								
								<c:choose>
									<c:when test="${resp.state=='待确认' }">
									<td class="td_mgmt_right3_td1">${resp.state }</td>
										<td class="td_mgmt_right3_td3"><a
											href="viewResponseInfo?responseid=${resp.responseId }" hidefocus="true">查看</a></td>
									</c:when>
									<c:otherwise>
										<td class="td_mgmt_right3_td1">${resp.state }</td>
										<td class="td_mgmt_right3_td3"><a href="viewResponseInfo?responseid=${resp.responseId }"
											hidefocus="true">查看</a></td>
									</c:otherwise>
									<%-- <c:otherwise>
									<td class="td_mgmt_right3_td1">${resp.state }</td>
									<td class="td_mgmt_right3_td3"><a
											href="getresponseform?goodsid=${resp.id }" hidefocus="true">提交</a></td>
									</c:otherwise> --%>
								</c:choose>
							</tr>
						</c:forEach>

					</table>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table_recordnumber">
						<tr>
							<td>每页 <select>
									<option value="" selected="selected">10</option>
									<option value="a">20</option>
									<option value="b">50</option>
							</select> 条记录
							</td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table_pagenumber">
						<tr>
							<td width="45" class="td_pagenumber">首页</td>
							<td width="45" class="td_pagenumber"><a href="javascript:;"
								class="a_pagenumber" hidefocus="true">上页</a></td>
							<td width="30" class="td_pagenumber"><a href="javascript:;"
								class="a_pagenumber" hidefocus="true">1</a></td>
							<td width="30" class="td_pagenumber"><a href="javascript:;"
								class="a_pagenumber" hidefocus="true">2</a></td>
							<td width="30" class="td_pagenumber"><a href="javascript:;"
								class="a_pagenumber" hidefocus="true">3</a></td>
							<td width="45" class="td_pagenumber"><a href="javascript:;"
								class="a_pagenumber" hidefocus="true">下页</a></td>
							<td width="45" class="td_pagenumber"><a href="javascript:;"
								class="a_pagenumber" hidefocus="true">末页</a></td>
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

	<div id="footer_frame">
		<iframe allowtransparency="true" width="100%" frameborder="0"
			hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0"
			src="views/footer.jsp"></iframe>
	</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
	}
</script>
</html>