<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户信息</title>
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
                        <a href="car?flag=1" class="a_mgmt_leftnav" hidefocus="true">车辆信息</a>
                        <a href="warehouse?flag=1" class="a_mgmt_leftnav" hidefocus="true">仓库信息</a>
						<a href="driver?flag=1" class="a_mgmt_leftnav" hidefocus="true">司机信息</a>
						<%} %>
						<% if((Integer)session.getAttribute("userKind") ==2) {%><!-- 个人用户 -->
                        <a href="client" class="a_mgmt_leftnav1" hidefocus="true">客户信息</a>
                        <a href="goodsform?flag=1" class="a_mgmt_leftnav" hidefocus="true">货物信息</a>
                        <%} %>
						<% if((Integer)session.getAttribute("userKind") ==3) {%><!-- 企业用户 -->
                        <a href="contract2" class="a_mgmt_leftnav" hidefocus="true">合同信息</a>
                        <%} %>
                        <% if((Integer)session.getAttribute("userKind") ==2) {%><!-- 个人用户 -->
                        <a href="contract" class="a_mgmt_leftnav" hidefocus="true">合同信息</a>
                        <%} %>
                    </div>
                    <%@ include  file="mysource_leftnav_myplan.jsp"%>
                    <%@ include  file="mysource_leftnav_myanalysis.jsp"%>
                    <%@ include  file="mysource_leftnav_myaccount.jsp"%>
</div>
			</td>
			<td class="td_leftnav_top">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2">
                    <tr>
                    	<td>
                        	<span class="span_mgmt_right2_text1">客户信息</span>
                            <span class="span_mgmt_right2_text2"><a href="insert?flag=6" hidefocus="true"><img src="images/btn_add1.png" class="span_mgmt_right2_pic1" title="添加" /></a></span>
                        </td>
                	</tr>
				</table>
				
				<!-- 页码相关 -->
				<input id="count" value="" type="hidden" /><!--  总记录条数 -->
				<input id="display" value="10" type="hidden" /> <!-- 每页展示的数量 -->
				<input id="currentPage" value="1" type="hidden" /><!-- 当前页 -->
				<inpyt id="is_resource_page" value="0" type="hidden"/><!-- 是否为资源页，资源页需要模拟click按钮 -->
				
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3" id="result_body">
					<%-- <tr>
                        <td width="20" height="40" class="td_mgmt_right3_head1">&nbsp;</td>
                        <td width="100" class="td_mgmt_right3_head">客户帐号</td>
                        <td class="td_mgmt_right3_head">客户名称</td>
                        <td width="70" class="td_mgmt_right3_head">所属行业</td>
                        <td width="80" class="td_mgmt_right3_head">创建日期</td>
                        <td width="80" class="td_mgmt_right3_head">操作</td>
					</tr>
					<c:forEach var="client" items="${clientList }">
					<tr>
                        <td height="60" class="td_mgmt_right3_td1d">&nbsp;</td>
                        <td class="td_mgmt_right3_td1"><a href="clientdetail?clientId=${client.id }&flag=1" hidefocus="true">${client.account }</a></td>
                        <td class="td_mgmt_right3_td1">${client.clientName }</td>
                        <td class="td_mgmt_right3_td1">${client.clientBusiness }</td>
                        <td class="td_mgmt_right3_td1">${client.relDate }</td>
                        <td class="td_mgmt_right3_td3">
                            <div id="handlebox" style="z-index:203;">
                                <ul class="quickmenu">
                                    <li class="menuitem">
                                        <div class="menu">
                                            <a href="clientdetail?clientId=${client.id }&flag=2" class="menuhd" hidefocus="true">更新</a>
                                            <div class="menubd">
                                                <div class="menubdpanel">
                                                    <a href="clientdelete?id=${client.id }" class="a_top3" hidefocus="true">删除</a>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </td>
					</tr>
					</c:forEach> --%>
					
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
            	<table border="0" cellpadding="0" cellspacing="0" class="table_pagenumber" id="page_layout">
                    <!-- <tr>
	                    <td width="45" class="td_pagenumber">首页</td>
                        <td width="45" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">上页</a></td>
                        <td width="30" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">1</a></td>
                        <td width="30" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">2</a></td>
                        <td width="30" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">3</a></td>
                        <td width="45" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">下页</a></td>
                        <td width="45" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">末页</a></td>
                  </tr> -->
				</table>
			</td>
		</tr>
    </table>
</div>

<%@ include  file="popup1.jsp"%>

<div id="footer_frame">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="views/footer.jsp"></iframe>
</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
		var display=$("#display").val();
		var currentPage=$("#currentPage").val();
		getUserBusinessClientResourceAjax(display,currentPage);
		getUserBusinessClientTotalRowsAjax(display,currentPage);
	}
	
	//加载客户资源
	function getUserBusinessClientResourceAjax(display,currentPage){
		var url="getUserBusinessClientResourceAjax";
		$.ajax({
			url:url,
			data:{
				display:display,
				currentPage:currentPage
				},
			cache:false,
			dataType:"json",
			success:function(data,status){
				var body=$("#result_body");
				body.empty();
				body.append("<tr>");
                body.append("<td width=\"20\" height=\"40\" class=\"td_mgmt_right3_head1\">&nbsp;</td>");
				body.append("<td width=\"100\" class=\"td_mgmt_right3_head\">客户帐号</td>");
				body.append("<td class=\"td_mgmt_right3_head\">客户名称</td>");
				body.append("<td width=\"70\" class=\"td_mgmt_right3_head\">所属行业</td>");
				body.append("<td width=\"80\" class=\"td_mgmt_right3_head\">创建日期</td>");
				body.append("<td width=\"80\" class=\"td_mgmt_right3_head\">操作</td>");
				body.append("</tr>");
				//循环输出结果集
				/* for(var i =0;i<data.length;i++){
					body.append("<tr>");
					body.append("<td height=\"60\" class=\"td_mgmt_right3_td1d\">&nbsp;</td>");
							body.append("<td class=\"td_mgmt_right3_td1\"><a href=\"clientdetail?clientId="+data[i].id+"&flag=1\" hidefocus=\"true\">"+data[i].account+"</a></td>");
							body.append("<td class=\"td_mgmt_right3_td1\">"+data[i].clientName+"</td>");
							body.append("<td class=\"td_mgmt_right3_td1\">"+data[i].clientBusiness+"</td>");
							body.append("<td class=\"td_mgmt_right3_td1\">"+data[i].relDate+"</td>");
							body.append("<td class=\"td_mgmt_right3_td3\"><div id=\"handlebox\" style=\"z-index: 203;\">");
							body.append("<ul class=\"quickmenu\"><li class=\"menuitem\">");
							body.append("<div class=\"menu\">");
							body.append("<a href=\"clientdetail?clientId="+data[i].id+"&flag=2\" class=\"menuhd\" hidefocus=\"true\">更新</a>");
							body.append("<div class=\"menubd\">");
							body.append("<div class=\"menubdpanel\">");
							body.append("<a href=\"clientdelete?id="+data[i].id+"\" class=\"a_top3\" hidefocus=\"true\">删除</a>");
							body.append("</div></div></div></li></ul></div></td>");
							body.append("</tr>");
					
				} */
				
			}
		})
	}
	//客户资源总条数
	function getUserBusinessClientTotalRowsAjax(display,currentPage){
		var url="getUserBusinessClientTotalRowsAjax";
		$.ajax({
			url:url,
			data:{
				display:display,
				currentPage:currentPage
			},
			cache:false,
			dataType:"json",
			success:function(data,status){
				 $('#count').val(data);
				  pageLayout(data);//页面布局
			}
		});
		
		
		
	}
	
</script>
</html>