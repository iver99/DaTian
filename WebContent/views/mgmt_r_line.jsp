<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>干线运输线路信息</title>
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
<script type="text/javascript" src="js/splitPage2.js"></script>
<script type="text/javascript" src="js/focus_load.js"></script>
<!-- 新增 -->

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
                        <a href="linetransport?flag=1&Display=10&PageNow=1" class="a_mgmt_leftnav1" hidefocus="true">干线运输线路信息</a>
                        <a href="cityline?flag=1" class="a_mgmt_leftnav" hidefocus="true">城市配送网络信息</a>
                        <a href="car?flag=1" class="a_mgmt_leftnav" hidefocus="true">车辆信息</a>
                        <a href="warehouse?flag=1" class="a_mgmt_leftnav" hidefocus="true">仓库信息</a>
						<a href="driver?flag=1" class="a_mgmt_leftnav" hidefocus="true">司机信息</a>
						<%} %>
						
						 <% if((Integer)session.getAttribute("userKind") ==2) {%><!-- 个人用户 -->
                        <a href="client" class="a_mgmt_leftnav" hidefocus="true">客户信息</a>
                        <a href="goodsform?flag=1" class="a_mgmt_leftnav" hidefocus="true">货物信息</a>
                         <%} %>
                         
                         <% if((Integer)session.getAttribute("userKind") ==3) {%><!-- 企业用户 -->
                        <a href="contract2" class="a_mgmt_leftnav" hidefocus="true">合同信息</a>
                        <%} %>
                        
                        <% if((Integer)session.getAttribute("userKind") ==2) {%><!-- 个人用户 -->
                        <a href="contract" class="a_mgmt_leftnav1" hidefocus="true">合同信息</a>
                        <%} %>
                    </div>
                    <%@ include  file="mysource_leftnav_myplan.jsp"%>
                    <%@ include  file="mysource_leftnav_myanalysis.jsp"%>
                    <%@ include  file="mysource_leftnav_myaccount.jsp"%>
</div>
			</td>

	<td class="td_leftnav_top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="table_mgmt_right2">
			<tr>
				<td><span class="span_mgmt_right2_text1">干线运输线路信息</span> <span
					class="span_mgmt_right2_text2"><a href="insert?flag=1"
						hidefocus="true"><img src="images/btn_add1.png"
							class="span_mgmt_right2_pic1" title="添加" /></a></span></td>
			</tr>

		</table>

		<div id="div_resource_list_head1">共 ${count } 条记录</div> <!-- 新增 --> <input
		id="count" value="${count }" type="hidden" /> <input id="count"
		value="${pageNum }" type="hidden" /> <input id="count"
		value="${pageNow }" type="hidden" />

		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="table_mgmt_right3">
			<tr>
				<td width="20" height="40" class="td_mgmt_right3_head1">&nbsp;</td>
				<td class="td_mgmt_right3_head">名称</td>
				<td width="60" class="td_mgmt_right3_head">运输类型</td>
				<td width="60" class="td_mgmt_right3_head">始发</td>
				<td width="60" class="td_mgmt_right3_head">到达</td>
				<td width="80" class="td_mgmt_right3_head">在途(小时)</td>
				<td width="100" class="td_mgmt_right3_head">参考价(元/kg)</td>
				<td width="80" class="td_mgmt_right3_head">发布日期</td>
				<td width="80" class="td_mgmt_right3_head">操作</td>
			</tr>
			<c:forEach var="linetransport" items="${linetransportList }">
				<tr>
					<td height="60" class="td_mgmt_right3_td1d">&nbsp;</td>
					<td class="td_mgmt_right3_td1"><a
						href="linetransportdetail?linetransportid=${linetransport.id }&carrierId=0&flag=1"
						hidefocus="true">${linetransport.startPlace }→${linetransport.endPlace }</a></td>
					<td class="td_mgmt_right3_td1">${linetransport.type }
					<td class="td_mgmt_right3_td1">${linetransport.startPlace }</td>
					<td class="td_mgmt_right3_td1">${linetransport.endPlace }</td>
					<td class="td_mgmt_right3_td1">${linetransport.onWayTime }</td>
					<td class="td_mgmt_right3_td1">${linetransport.refPrice }</td>
					<td class="td_mgmt_right3_td1">${linetransport.relDate }</td>
					<td class="td_mgmt_right3_td3">
						<div id="handlebox" style="z-index: 201;">
							<ul class="quickmenu">
								<li class="menuitem">
									<div class="menu">
										<a
											href="linetransportdetail?linetransportid=${linetransport.id }&carrierId=0&flag=2"
											class="menuhd" hidefocus="true">更新</a>
										<div class="menubd">
											<!-- carrierId没有用 -->
											<div class="menubdpanel">
												<a href="linetransportdelete?id=${linetransport.id }"
												 class="a_top3" hidefocus="true">删除</a>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
		<table border="0" cellpadding="0" cellspacing="0"
			class="table_recordnumber">
			<tr>
				<td>每页 <select>
						<option value="10" selected="selected">10</option>
						<!-- 修改value -->
						<option value="20">20</option>
						<option value="50">50</option>
				</select> 条记录
				</td>
			</tr>
		</table> <%-- <%@ include file="page_table.jsp"%> --%>
		<table border="0" cellpadding="0" cellspacing="0"
			class="table_pagenumber" id="PageNow" value="1">
			<tr>
				<td width="45" class="td_pagenumber" onclick="ChangeTo('first')"><a
					href="javascript:;" class="a_pagenumber" hidefocus="true">首页</a></td>
				<td width="45" class="td_pagenumber" onclick="ChangeTo('previous')"><a
					href="javascript:;" class="a_pagenumber" hidefocus="true">上页</a></td>
				<c:if test="${pageNum < 8}">
					<c:forEach begin="1" end="${pageNum }" var="i">
						<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a
							href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
					</c:forEach>
				</c:if>
				<c:if test="${pageNum >= 8}">
					<c:choose>
						<c:when test="${pageNow <= 3}">
							<c:forEach begin="1" end="5" var="i">
								<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a
									href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
							</c:forEach>
                        			...
                        		</c:when>
						<c:when test="${pageNow == 4}">
							<c:forEach begin="1" end="6" var="i">
								<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a
									href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
							</c:forEach>
                        			...
                        		</c:when>
						<c:when test="${pageNow == 5}">
							<c:forEach begin="1" end="7" var="i">
								<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a
									href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
							</c:forEach>
                        			...
                        		</c:when>
						<c:when test="${pageNow > 5 && pageNow < pageNum - 3}">
							<td width="30" class="td_pagenumber" onclick="ChangePage('1')"><a
								href="javascript:;" class="a_pagenumber" hidefocus="true">1</a></td>
							<td width="30" class="td_pagenumber" onclick="ChangePage('2')"><a
								href="javascript:;" class="a_pagenumber" hidefocus="true">2</a></td>
                        		    ...
                        			<c:forEach begin="${pageNow-2 }"
								end="${pageNow+2 }" var="i">
								<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a
									href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
							</c:forEach>
                        			...
                        		</c:when>
						<c:when test="${pageNow == pageNum - 3}">
							<td width="30" class="td_pagenumber" onclick="ChangePage('1')"><a
								href="javascript:;" class="a_pagenumber" hidefocus="true">1</a></td>
							<td width="30" class="td_pagenumber" onclick="ChangePage('2')"><a
								href="javascript:;" class="a_pagenumber" hidefocus="true">2</a></td>
                        		    ...
                        			<c:forEach begin="${pageNow-5 }"
								end="${pageNow }" var="i">
								<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a
									href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
							</c:forEach>
						</c:when>
						<c:when test="${pageNow >= pageNum - 2}">
							<td width="30" class="td_pagenumber" onclick="ChangePage('1')"><a
								href="javascript:;" class="a_pagenumber" hidefocus="true">1</a></td>
							<td width="30" class="td_pagenumber" onclick="ChangePage('2')"><a
								href="javascript:;" class="a_pagenumber" hidefocus="true">2</a></td>
                        		    ...
                        			<c:forEach begin="${pageNow-4 }"
								end="${pageNow }" var="i">
								<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a
									href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
							</c:forEach>
						</c:when>
					</c:choose>
				</c:if>
				<td width="45" class="td_pagenumber" onclick="ChangeTo('next')"><a
					href="javascript:;" class="a_pagenumber" hidefocus="true">下页</a></td>
				<td width="45" class="td_pagenumber" onclick="ChangeTo('last')"><a
					href="javascript:;" class="a_pagenumber" hidefocus="true">末页</a></td>
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