<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>货物信息</title>
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
                    <%@ include  file="mysource_leftnav_mytrade.jsp" %>
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
                        <a href="client" class="a_mgmt_leftnav" hidefocus="true">客户信息</a>
                        <a href="goodsform?flag=1" class="a_mgmt_leftnav1" hidefocus="true">货物信息</a>
                        <a href="contract" class="a_mgmt_leftnav" hidefocus="true">合同信息</a>
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
							<td><span class="span_mgmt_right2_text1">货物信息</span> <span
								class="span_mgmt_right2_text2"><a
									href="insert?flag=9" hidefocus="true"><img
										src="images/btn_add1.png" class="span_mgmt_right2_pic1"
										title="添加" /></a></span></td>
						</tr>
					</table>
					
					<!-- 页码相关 -->
				<input id="count" value="" type="hidden" /><!--  总记录条数 -->
				<input id="display" value="10" type="hidden" /> <!-- 每页展示的数量 -->
				<input id="currentPage" value="1" type="hidden" /><!-- 当前页 -->
				<input id="is_resource_page" value="0" type="hidden"/><!-- 是否为资源页，资源页需要模拟click按钮 -->
				<input id="kind" value="cargo" type="hidden"/><!-- 用于判断是哪一栏的分页,用于splitPage.js -->
				
					<table width="100%" border="0" cellspacing="0" cellpadding="0" 
						class="table_mgmt_right3">
						<thead>
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
						</thead>
						<tbody id="result_body" >
						</tbody> 
					</table>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table_recordnumber">
						<tr>
							<td>每页  <select id="Display" onchange="changeDisplay()">
                                <option value="10" selected="selected">10</option>
                                <option value="20">20</option>
                                <option value="50">50</option>
                            </select> 条记录
							</td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0" id="page_layout" 
						class="table_pagenumber">
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
			src="footer.jsp"></iframe>
	</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
		var display=$("#display").val();
		var currentPage=$("#currentPage").val();
		getUserCargoResourceAjax(display,currentPage);
		getUserCargoResourceTotalRowsAjax(display,currentPage);
	}
	
	//加载货物资源
	function getUserCargoResourceAjax(display,currentPage){
		var url="getUserCargoResourceAjax";
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
				//循环输出结果集
				 for(var i =0;i<data.length;i++){
					body.append("<tr>");
					body.append("<td class=\"td_main_list_content\"></td>");
					body.append("<td class=\"td_main_list_content\">"+data[i].id+"</td>");
					body.append("<td class=\"td_main_list_content\"><a href=\"mygoodsdetail?id="+data[i].id+"&flag=1\" hidefocus=\"true\">"+data[i].name+"</a></td>");
					body.append("<td class=\"td_main_list_content\">"+renderTime(data[i].relDate)+"</td>");
					body.append("<td class=\"td_main_list_content\">"+renderTime(data[i].limitDate)+"</td>");
					body.append("<td class=\"td_main_list_content\">"+data[i].oriented+"</td>");
					body.append("<td class=\"td_main_list_content\">"+data[i].feedbackQuantity+"</td>");
					if(data[i].state=='已确认'){
						body.append("<td class=\"td_mgmt_right3_td1\">已确认</td>");
						body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"viewResponseDetailAfter?goodsid="+data[i].id+"\" hidefocus=\"true\">查看反馈</a></td>");
					}
					else if(data[i].state=='已取消'){
						body.append("<td class=\"td_mgmt_right3_td1\">已取消</td>");
						body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"mygoodsdetail?id="+data[i].id+"&flag=1\" hidefocus=\"true\">查看</a></td>");
					}
					else{
						var str="<td class=\"td_mgmt_right3_td2\">待确认</td>";
						str+="<td class=\"td_mgmt_right3_td3\"><div id=\"handlebox\" style=\"z-index: 203;\">";
						str+="<ul class=\"quickmenu\"><li class=\"menuitem\">";
						str+="<div class=\"menu\">";
						str+="<a href=\"viewResponseDetail?goodsid="+data[i].id+"\" class=\"menuhd\" hidefocus=\"true\">查看反馈</a>";
						str+="<div class=\"menubd\">";
						str+="<div class=\"menubdpanel\">";
						str+="<a href=\"mygoodsdetail?id="+data[i].id+"&flag=2\" class=\"a_top3\" hidefocus=\"true\">更新</a>";
						str+="<a href=\"deletegoods?id="+data[i].id+"\" class=\"a_top3\" hidefocus=\"true\">删除</a>";
						str+="</div></div></div></li></ul></div></td>";
						str+="</tr>";
						body.append(str);
					}
					
				} 
				
			}
		})
	}
	//货物资源总条数
	function getUserCargoResourceTotalRowsAjax(display,currentPage){
		var url="getUserCargoResourceTotalRowsAjax";
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
			getUserCargoResourceAjax(display,currentPage);
			getUserCargoResourceTotalRowsAjax(display,currentPage);
	}
	
</script>
</html>