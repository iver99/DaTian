<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
                        <% } %>
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
			
			 <form action="findcontract?flag=1" method="post">	          
                        
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2">
                    <tr>
                    	<td>
                        	<span class="span_mgmt_right2_text1">合同信息(需求方)</span>
                            <span class="span_mgmt_right2_text2"><a href="insert?flag=7" hidefocus="true"><img src="images/btn_add1.png" class="span_mgmt_right2_pic1" title="添加" /></a></span>
                            <div class="div_mgmt_s1">
                                <input type="text" class="input_date1" onclick="SelectDate(this,'yyyy-MM-dd')" value="开始时间" readonly="readonly" title="点击选择" name="startDate"/>
                                &nbsp;&nbsp;至&nbsp;&nbsp;
                                <input type="text" class="input_date1" onclick="SelectDate(this,'yyyy-MM-dd')" value="结束时间" readonly="readonly" title="点击选择" name="endDate"/>
                                &nbsp;&nbsp;<input type="text" class="input_mgmt1" style="width:110px;" placeholder="合同名称" name="name"/>
                                <input type="submit" id="btn1" value="查询" class="btn_mgmt3" hidefocus="true"/>
                            </div>
                        </td>
                	</tr>
				</table>
				</form>
				
				<!-- 页码相关 -->
				<input id="count" value="" type="hidden" /><!--  总记录条数 -->
				<input id="display" value="10" type="hidden" /> <!-- 每页展示的数量 -->
				<input id="currentPage" value="1" type="hidden" /><!-- 当前页 -->
				<inpyt id="is_resource_page" value="0" type="hidden"/><!-- 是否为资源页，资源页需要模拟click按钮 -->
				
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3" id="result_body">
					<%-- <tr>
                        <td width="20" height="40" class="td_mgmt_right3_head1">&nbsp;</td>
                        <td width="100" class="td_mgmt_right3_head">合同编号</td>
                        <td class="td_mgmt_right3_head">合同名称</td>
                        <td width="120" class="td_mgmt_right3_head">承运方</td>
                        <td width="50" class="td_mgmt_right3_head">帐期</td>
                        <td width="80" class="td_mgmt_right3_head">创建日期</td>
                        <td width="50" class="td_mgmt_right3_head">状态</td>
                        <td width="80" class="td_mgmt_right3_head">操作</td>
					</tr>
					<c:forEach var="contract" items="${contractList }">
					<tr>
                        <td height="60" class="td_mgmt_right3_td1d">&nbsp;</td>
                        <td class="td_mgmt_right3_td1"><a href="contractdetail?contractId=${contract.id }&flag=1" hidefocus="true">${contract.id }</a></td>
                        <td class="td_mgmt_right3_td1" id="name">${contract.name }</td>
                        <td class="td_mgmt_right3_td1">${contract.carrierAccount }</td>
                        <td class="td_mgmt_right3_td1">${contract.monthlyStatementDays }</td>
                        <td class="td_mgmt_right3_td1">${contract.startDate }</td>
                        <td class="td_mgmt_right3_td1">${contract.state }</td>
                        <c:choose>
                        <c:when test="${contract.state=='有效' }">
                        <td class="td_mgmt_right3_td3"><a href="contractdetail?contractId=${contract.id }&flag=2" hidefocus="true">终止</a></td>
						</c:when>
						<c:when test="${contract.state=='已终止' }">
                        <td class="td_mgmt_right3_td3"><a href="contractdetail?contractId=${contract.id }&flag=3" hidefocus="true">查看</a></td>
						</c:when>
						<c:otherwise>
						<td class="td_mgmt_right3_td3"><a href="contractdetail?contractId=${contract.id }&flag=1" hidefocus="true">查看</a></td>
						</c:otherwise>
						</c:choose>
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
                        <td width="45" class="td_pagenumber"><a href="mgmt_r_contact_r.htm" class="a_pagenumber" hidefocus="true">上页</a></td>
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
		getUserContractAjax(display,currentPage);
		getUserContractTotalRowsAjax(display,currentPage);
	}
	
	//加载合同（需求方）资源
	function getUserContractAjax(display,currentPage){
		var url="getUserContractAjax";
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
				body.append("<td width=\"100\" class=\"td_mgmt_right3_head\">合同编号</td>");
				body.append("<td class=\"td_mgmt_right3_head\">合同名称</td>");
				body.append("<td width=\"120\" class=\"td_mgmt_right3_head\">承运方</td>");
				body.append("<td width=\"50\" class=\"td_mgmt_right3_head\">帐期</td>");
				body.append("<td width=\"80\" class=\"td_mgmt_right3_head\">创建日期</td>");
				body.append("<td width=\"50\" class=\"td_mgmt_right3_head\">状态</td>");
				body.append("<td width=\"80\" class=\"td_mgmt_right3_head\">操作</td>");
				body.append("</tr>");
				//循环输出结果集
				/* for(var i =0;i<data.length;i++){
					body.append("<tr>");
					body.append("<td height=\"60\" class=\"td_mgmt_right3_td1d\">&nbsp;</td>");
					body.append("<td class=\"td_mgmt_right3_td1\"><a href=\"contractdetail?contractId="+data[i].id+"&flag=1\" hidefocus=\"true\">"+data[i].id+"</a></td>");
					body.append("<td class=\"td_mgmt_right3_td1\" id=\"name\">"+data[i].name+"</td>");
					body.append("<td class=\"td_mgmt_right3_td1\">"+data[i].companyName+"</td>");
					body.append("<td class=\"td_mgmt_right3_td1\">"+data[i].monthlyStatementDays+"</td>");
					body.append("<td class=\"td_mgmt_right3_td1\">"+data[i].startDate+"</td>");
					body.append("<td class=\"td_mgmt_right3_td1\">"+data[i].state+"</td>");
					if(data[i].state=='有效'){
						body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"contractdetail?contractId="+data[i].id+"&flag=2\" hidefocus=\"true\">终止</a></td>");				
					}
					else if(data[i].state=='已终止'){
						body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"contractdetail?contractId="+data[i].id+"&flag=3\" hidefocus=\"true\">查看</a></td>");
					}
					else{
						body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"contractdetail?contractId="+data[i].id+"&flag=1\" hidefocus=\"true\">查看</a></td>");
					}
					body.append("</tr>");
					
				} */
				
			}
		})
	}
	//合同（需求方）资源总条数
	function getUserContractTotalRowsAjax(display,currentPage){
		var url="getUserContractTotalRowsAjax";
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