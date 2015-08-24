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
<%@ include file="jsTool.jsp" %>
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
<%@ include file="qq.jsp"%>

<%@ include  file="topFrame.jsp"%>

<div id="main_frame">
	<a href="myinfo" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的交易
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <span class="text_mgmt_leftnav1">
                    <span id="mgmt_nav_switch1a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch1a();"></span>
                    <span id="mgmt_nav_switch1b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch1b();"></span>我的交易
                    </span>
                    <div id="mgmt_nav1">
                        <a href="getallfocus" class="a_mgmt_leftnav" hidefocus="true">我的关注</a>
                       	<% if((Integer)session.getAttribute("userKind") ==3) {%><!-- 企业用户 -->
                        <a href="getallresponse" class="a_mgmt_leftnav" hidefocus="true">我的反馈</a>
                         <%} %>
                      <% if((Integer)session.getAttribute("userKind") ==2) {%> <!-- 普通用户 -->
                        <a href="sendorderinfo" class="a_mgmt_leftnav1" hidefocus="true">我提交的订单</a>
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
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2">
                    <tr>
                        <td>
                        	<span class="span_mgmt_right2_text1">我提交的订单</span>
                            <div class="div_mgmt_s1">
                            	<input type="text" class="input_mgmt1" style="width:200px;" placeholder="订单编号" name="orderNum" id="orderNum" />
                                <input type="button" id="btn1" value="查询" class="btn_mgmt3" hidefocus="true" onclick="OnLoad()"/>
                            </div>
                        </td>
                	</tr>
            	</table>
            	
            	<input id="count" value="" type="hidden" /><!--  总记录条数 -->
				<input id="display" value="10" type="hidden" /> <!-- 每页展示的数量 -->
				<input id="currentPage" value="1" type="hidden" /><!-- 当前页 -->
				<input id="is_resource_page" value="0" type="hidden"/><!-- 是否为资源页，资源页需要模拟click按钮 -->
				<input id="kind" value="order_send" type="hidden"/><!-- 用于判断是哪一栏的分页,用于splitPage.js -->
				
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
				<thead>
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
					</thead>
					 <tbody id="result_body">
                    
                    </tbody>
                </table>
				<table border="0" cellpadding="0" cellspacing="0" class="table_recordnumber">
                    <tr>
	                    <td>
                            每页
                           <select  id="Display" onchange="changeDisplay()">
                                <option value="10" selected="selected">10</option>
                                <option value="20">20</option>
                                <option value="50">50</option>
                            </select>
                            条记录
                        </td>
                    </tr>
				</table>
				 <table border="0" cellpadding="0" cellspacing="0" class="table_pagenumber" id="page_layout" >
				</table>
			</td>
		</tr>
    </table>
</div>

<%@ include  file="popup1.jsp"%>

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
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.jsp"></iframe>
</div>
</body>
<script type="text/javascript">
function OnLoad() {
	loadFocus();
	var display=$("#display").val();
	var currentPage=$("#currentPage").val();
	var orderNum=$("#orderNum").val();
	getUserOrderResource(display,currentPage,orderNum);
	getUserOrderResourceTotalRows(display,currentPage,orderNum);
}

//加载我提交的订单资源
function getUserOrderResource(display,currentPage,orderNum){
	var url="getUserSendOrderAjax";
	$.ajax({
		url:url,
		data:{
			display:display,
			currentPage:currentPage,
			orderNum:orderNum
			},
		cache:false,
		dataType:"json",
		success:function(data,status){
			var body=$("#result_body");
			body.empty();
			//循环输出结果集
			  for(var i =0;i<data.length;i++){
				body.append("<tr>");
				body.append("<td height=\"60\" class=\"td_mgmt_right3_td1d\">&nbsp;</td>");
						body.append("<td class=\"td_mgmt_right3_td1\"><a href=\"orderDetail?orderid="+data[i].id+"\" hidefocus=\"true\">"+data[i].orderNum+"</a></td>");
						body.append("<td class=\"td_mgmt_right3_td1\">"+data[i].resourceType+"</td>");
						body.append("<td class=\"td_mgmt_right3_td1\"><a href=\"javascript:;\" class=\"link1\" hidefocus=\"true\">"+data[i].resourceName+"</a></td>");
						body.append("<td class=\"td_mgmt_right3_td1\"><a href=\"javascript:;\" class=\"link1\" hidefocus=\"true\">"+data[i].companyName+"</a></td>");
						body.append("<td class=\"td_mgmt_right3_td1\">"+data[i].expectedPrice+"</td>");
						if(data[i].actualPrice ==undefined){
							body.append("<td class=\"td_mgmt_right3_td1\">--</td>");
						}else{
							body.append("<td class=\"td_mgmt_right3_td1\">"+data[i].actualPrice+"</td>");
						}
						//alert(data[i].actualPrice ==undefined);
						body.append("<td class=\"td_mgmt_right3_td1\">"+renderTime(data[i].submitTime)+"<br /></td>");
						body.append("<td class=\"td_mgmt_right3_td2\">"+data[i].state+"</td>");
						if(data[i].state == '待受理'){
							var str="<td class=\"td_mgmt_right3_td3\"><div id=\"handlebox\" style=\"z-index: 204;\">";
							str+="<ul class=\"quickmenu\"><li class=\"menuitem\">";
							str+="<div class=\"menu\">";
							str+="<a href=\"updateOrder?orderid="+data[i].id+"\" class=\"menuhd\" hidefocus=\"true\">更新</a>";
							str+="<div class=\"menubd\">";
							str+="<div class=\"menubdpanel\">";
							str+="<a href=\"cancelOrder?orderid="+data[i].id+"\" class=\"a_top3\" hidefocus=\"true\">取消</a>";
							str+="</div></div></div></li></ul></div></td>";
							body.append(str);
							}
						else if(data[i].state == '待收货'){
							body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"orderDetailWaitToReceive?orderid="+data[i].id+"\" hidefocus=\"true\">查看</a></td>");
						}
						else if(data[i].state == '待确认'){
							var str="<td class=\"td_mgmt_right3_td3\"><div id=\"handlebox\" style=\"z-index: 202;\">";
							str+="<ul class=\"quickmenu\"><li class=\"menuitem\">";
							str+="<div class=\"menu\">";
							str+="<a href=\"getConfirmForm?orderid="+data[i].id+"\" class=\"menuhd\" hidefocus=\"true\">收货确认</a>";
							str+="<div class=\"menubd\">";
							str+="<div class=\"menubdpanel\">";
							str+="<a href=\"orderDetailWaitToReceive?orderid="+data[i].id+"\" class=\"a_top3\" hidefocus=\"true\">查看</a>";
							str+="</div></div></div></li></ul></div></td>";
							body.append(str);
						}
						else if(data[i].state == '待评价'){
							var str="<td class=\"td_mgmt_right3_td3\"><div id=\"handlebox\" style=\"z-index: 201;\">";
							str+="<ul class=\"quickmenu\"><li class=\"menuitem\">";
							str+="<div class=\"menu\">";
							str+="<a href=\"getCommentForm?orderid="+data[i].id+"&ordernum="+data[i].orderNum+"\" class=\"menuhd\" hidefocus=\"true\">评价</a>";
							str+="<div class=\"menubd\">";
							str+="<div class=\"menubdpanel\">";
							str+="<a href=\"orderDetailComment?orderid="+data[i].id+"\" class=\"a_top3\" hidefocus=\"true\">查看</a>";
							str+="</div></div></div></li></ul></div></td>";
							body.append(str);
						}
						else if(data[i].state == '已完成'){
							body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"orderDetailFinish?orderid="+data[i].id+"\" hidefocus=\"true\">查看</a></td>");
						}
						else if(data[i].state == '已取消'){
							body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"orderDetailAlreadyCancel?orderid="+data[i].id+"\" hidefocus=\"true\">查看</a></td>");
							body.append("</tr>");
						}
						
			}  
			
		}
	})
}
//我提交的订单总条数
function getUserOrderResourceTotalRows(display,currentPage,orderNum){
	var url="getUseSendOrderTotalRowsAjax";
	$.ajax({
		url:url,
		data:{
			display:display,
			currentPage:currentPage,
			orderNum:orderNum
		},
		cache:false,
		dataType:"json",
		success:function(data,status){
			 $('#count').val(data);
			 $("#page_layout").empty();
			  pageLayout(data);//页面布局
		}
	});
	
}

//变更每页展示数量
function changeDisplay(){
	//修改隐藏字段，每页数量
	$("#display").val($("#Display").val());
	//当前页归1
	$("#currentPage").val(1);
		var display=$("#display").val();
		var currentPage=$("#currentPage").val();
		var orderNum=$("#orderNum").val();
		getUserOrderResource(display,currentPage,orderNum);
		getUserOrderResourceTotalRows(display,currentPage,orderNum);
}
</script>
</html>