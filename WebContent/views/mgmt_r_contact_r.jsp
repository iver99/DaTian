<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>合同信息</title>
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
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="js/focus_load.js"></script>
<%@ include file="jsTool.jsp" %>
<script type="text/javascript"> 
	$(function() {
		$('input, textarea').placeholder(); 
		
		OnLoad();
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
                        <a href="client" class="a_mgmt_leftnav" hidefocus="true">客户信息</a>
                        <a href="goodsform?flag=1" class="a_mgmt_leftnav" hidefocus="true">货物信息</a>
                        <%} %>
                        <% if((Integer)session.getAttribute("userKind") ==3) {%><!-- 企业用户 -->
                        <a href="contract2" class="a_mgmt_leftnav1" hidefocus="true">合同信息</a>
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
            	<form action="findcontract?flag=2" method="post">	          
                        
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2">
                    <tr>
                    	<td>
                        	<span class="span_mgmt_right2_text1">合同信息(承运方)</span>
                             <div class="div_mgmt_s1">
                                <input type="text" class="input_date1" onclick="SelectDate(this,'yyyy-MM-dd')" value="开始时间" readonly="readonly" title="点击选择" name="startDate" id="startDate"/>
                                &nbsp;&nbsp;至&nbsp;&nbsp;
                                <input type="text" class="input_date1" onclick="SelectDate(this,'yyyy-MM-dd')" value="结束时间" readonly="readonly" title="点击选择" name="endDate" id="endDate"/> 
                                &nbsp;&nbsp;<input type="text" class="input_mgmt1" style="width:110px;" placeholder="合同名称" name="name"/>
                                <input type="button" id="btn1" value="查询" class="btn_mgmt3" hidefocus="true" onclick="OnLoad()"/>
                            </div>
                        </td>
                	</tr>
				</table>
				</form>
				
				<!-- 页码相关 -->
				<input id="count" value="" type="hidden" /><!--  总记录条数 -->
				<input id="display" value="10" type="hidden" /> <!-- 每页展示的数量 -->
				<input id="currentPage" value="1" type="hidden" /><!-- 当前页 -->
				<input id="is_resource_page" value="0" type="hidden"/><!-- 是否为资源页，资源页需要模拟click按钮 -->
				<input id="kind" value="contract_r" type="hidden"/><!-- 用于判断是哪一栏的分页,用于splitPage.js -->
				
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3" >
					<thead>
					 <tr>
                        <td width="20" height="40" class="td_mgmt_right3_head1">&nbsp;</td>
                        <td width="100" class="td_mgmt_right3_head">合同编号</td>
                        <td class="td_mgmt_right3_head">合同名称</td>
                        <td width="120" class="td_mgmt_right3_head">承运方</td>
                        <td width="50" class="td_mgmt_right3_head">帐期</td>
                        <td width="80" class="td_mgmt_right3_head">创建日期</td>
                        <td width="50" class="td_mgmt_right3_head">状态</td>
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
                            <select id="Display" onchange="changeDisplay()">
                                <option value="10" selected="selected">10</option>
                                <option value="20">20</option>
                                <option value="50">50</option>
                            </select>
                            条记录
                        </td>
                    </tr>
				</table>
            	<table border="0" cellpadding="0" cellspacing="0" class="table_pagenumber" id="page_layout">
				</table>
			</td>
		</tr>
    </table>
</div>

<%@ include  file="popup1.jsp"%>

<div id="footer_frame">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.jsp"></iframe>
</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
		debugger;
		var display=$("#display").val();
		var currentPage=$("#currentPage").val();
		//搜索信息
		var startDate=$("#startDate").val();
		var endDate=$("#endDate").val();
		var name=$("#name").val();
		//如果没有选择时间，则吧默认的汉字转为时间格式，否则后台接收参数刽报错
		if(startDate == '开始时间'){
			startDate='1970-01-01';
		}
		if(endDate == '结束时间'){
			endDate='1970-01-01';
		}
		getUserContractAjax(display,currentPage,startDate,endDate,name);
		getUserContractTotalRowsAjax(display,currentPage,startDate,endDate,name);
	}
	
	//加载合同（承运方）资源
	function getUserContractAjax(display,currentPage){
		var url="getUserContractAjax";
		$.ajax({
			url:url,
			data:{
				display:display,
				currentPage:currentPage,
				startDate:startDate,
				endDate:endDate,
				name:name
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
					body.append("<td class=\"td_mgmt_right3_td1\"><a href=\"contractdetail?contractId="+data[i].id+"&flag=44\" hidefocus=\"true\">"+data[i].id+"</a></td>");
					body.append("<td class=\"td_mgmt_right3_td1\" id=\"name\">"+data[i].name+"</td>");
					body.append("<td class=\"td_mgmt_right3_td1\">"+data[i].carrierAccount+"</td>");
					body.append("<td class=\"td_mgmt_right3_td1\">"+data[i].monthlyStatementDays+"</td>");
					body.append("<td class=\"td_mgmt_right3_td1\">"+renderTime(data[i].startDate)+"</td>");
					body.append("<td class=\"td_mgmt_right3_td1\">"+data[i].state+"</td>");
					if(data[i].state=='待确认'){
						body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"contractdetail?contractId="+data[i].id+"&flag=11\" hidefocus=\"true\">确认</a></td>");
					}
					else if(data[i].state=='有效'){
						body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"contractdetail?contractId="+data[i].id+"&flag=22\" hidefocus=\"true\">终止</a></td>");				
					}
					else if(data[i].state=='已终止'){
						body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"contractdetail?contractId="+data[i].id+"&flag=33\" hidefocus=\"true\">查看</a></td>");
					}
					else{
						body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"contractdetail?contractId="+data[i].id+"&flag=44\" hidefocus=\"true\">查看</a></td>");
					}
					body.append("</tr>");
					
				} 
				
			}
		})
	}
	//合同（承运方）资源总条数
	function getUserContractTotalRowsAjax(display,currentPage){
		var url="getUserContractTotalRowsAjax";
		$.ajax({
			url:url,
			data:{
				display:display,
				currentPage:currentPage,
				startDate:startDate,
				endDate:endDate,
				name:name
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
		//搜索信息
		var startDate=$("#startDate").val();
		var endDate=$("#endDate").val();
		var name=$("#name").val();
		//如果没有选择时间，则吧默认的汉字转为时间格式，否则后台接收参数刽报错
		if(startDate == '开始时间'){
			startDate='1970-01-01';
		}
		if(endDate == '结束时间'){
			endDate='1970-01-01';
		}
		getUserContractAjax(display,currentPage,startDate,endDate,name);
		getUserContractTotalRowsAjax(display,currentPage,startDate,endDate,name);
	}
</script>
</html>