<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>仓库信息</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/citylist.js"></script>
<script type="text/javascript" src="js/cityquery.js"></script>
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
                        <a href="warehouse?flag=1" class="a_mgmt_leftnav1" hidefocus="true">仓库信息</a>
						<a href="driver?flag=1" class="a_mgmt_leftnav" hidefocus="true">司机信息</a>
                        <a href="client" class="a_mgmt_leftnav" hidefocus="true">客户信息</a>
                        <a href="goodsform?flag=1" class="a_mgmt_leftnav" hidefocus="true">货物信息</a>
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
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2a">
                    <tr>
                        <td>
                            <span class="span_mgmt_right2_text1">更新仓库信息</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                    </tr>
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a"> 
                            <br /> 
                             <form action="updateWarehouse?id=${warehouseInfo.id }" method="post" enctype="multipart/form-data">	          
                            <c var="warehouseInfo" items="${warehouseInfo }">
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">仓库名称：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${warehouseInfo.name }" name="name" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">所在城市：</td>
                                    <td id="cityselector"><input id="city1" type="text" value="${warehouseInfo.city }" class="input_city1" name="city" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">地址：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${warehouseInfo.address }" name="address" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">仓库类型：</td>
                                    <td>
                       					<select style="width:120px;" name="type" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="保税" >保税</option>
                                            <option value="非保税">非保税</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                <td height="40" class="td_mgmt_right3_td1b">所属性质：</td>
                                    <td>
                       					<select style="width:120px;" name="kind" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="自有" >自有</option>
                                            <option value="租用">租用</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">仓库面积：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${warehouseInfo.houseArea }" name="houseArea" required/>
                                    (平方米)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">堆场面积：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${warehouseInfo.yardArea }" name="yardArea" required/>
                                    (平方米)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">库层层高：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${warehouseInfo.height }" name="height" required/>
                                    (米)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">消防等级：</td>
                                    <td>
                       					<select style="width:120px;" name="fireRate" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="甲" >甲</option>
                                            <option value="乙">乙</option>
                                            <option value="丙">丙</option>
                                        </select>
                                    </td>
                                </tr>
                               <%--  <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">保管形态：</td>
                                    <td>
                                    <d:choose>
                                    <d:when test="${everystorageForm[0] == '普通' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="普通" name="storageForm" />
                                        普通仓库&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everystorageForm[0] == '' }">
                                    	<input type="checkbox" id="checkbox" value="普通" name="storageForm" />
                                        普通仓库&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose>
                                    </d>
                                    <d var="everystorageForm" items="${everystorageForm }">
                                    <d:choose>
                                    <d:when test="${everystorageForm[1] == '冷藏' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="冷藏" name="storageForm" />
                                        冷藏仓库&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everystorageForm[1] == '' }">
                                    	<input type="checkbox" id="checkbox" value="冷藏" name="storageForm" />
                                        冷藏仓库&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    <d var="everystorageForm" items="${everystorageForm }">
                                    <d:choose>
                                    <d:when test="${everystorageForm[2] == '恒温' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="恒温" name="storageForm" />
                                        恒温仓库&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everystorageForm[2] == '' }">
                                    	<input type="checkbox" id="checkbox" value="恒温" name="storageForm" />
                                        恒温仓库&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    <d var="everystorageForm" items="${everystorageForm }">
                                    <d:choose>
                                    <d:when test="${everystorageForm[3] == '露天' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="露天" name="storageForm" />
                                        露天仓库&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everystorageForm[3] == '' }">
                                    	<input type="checkbox" id="checkbox" value="露天" name="storageForm" />
                                        露天仓库&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    <d var="everystorageForm" items="${everystorageForm }">
                                    <d:choose>
                                    <d:when test="${everystorageForm[4] == '危险品' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="危险品" name="storageForm" />
                                        危险品仓库&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everystorageForm[4] == '' }">
                                    	<input type="checkbox" id="checkbox" value="危险品" name="storageForm" />
                                        危险品仓库&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">防火安保：</td>
                                    <td>
                                    <d var="everyfireSecurity" items="${everyfireSecurity }">
                                    <d:choose>
                                    <d:when test="${everyfireSecurity[0] == '烟感' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="烟感" name="fireSecurity"/>
                                        烟感&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everyfireSecurity[0] == '' }">
                                    	<input type="checkbox" id="checkbox" value="烟感" name="fireSecurity"/>
                                        烟感&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    <d var="everyfireSecurity" items="${everyfireSecurity }">
                                    <d:choose>
                                    <d:when test="${everyfireSecurity[1] == '自动喷淋' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="自动喷淋" name="fireSecurity"/>
                                        自动喷淋&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everyfireSecurity[1] == '' }">
                                    	<input type="checkbox" id="checkbox" value="自动喷淋" name="fireSecurity"/>
                                        自动喷淋&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    <d var="everyfireSecurity" items="${everyfireSecurity }">
                                    <d:choose>
                                    <d:when test="${everyfireSecurity[2] == '24小时摄像监控' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="24小时摄像监控" name="fireSecurity"/>
                                        24小时摄像监控&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everyfireSecurity[2] == '' }">
                                    	<input type="checkbox" id="checkbox" value="24小时摄像监控" name="fireSecurity"/>
                                       24小时摄像监控&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    <d var="everyfireSecurity" items="${everyfireSecurity }">
                                    <d:choose>
                                    <d:when test="${everyfireSecurity[3] == '无' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="无" name="fireSecurity"/>
                                        无&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everyfireSecurity[3] == '' }">
                                    	<input type="checkbox" id="checkbox" value="无" name="fireSecurity"/>
                                       无&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">IT环境：</td>
                                    <td>
                                    <d var="everyenvironment" items="${everyenvironment }">
                                    <d:choose>
                                    <d:when test="${everyenvironment[0] == 'Internet宽带接入' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="Internet宽带接入" name="environment"/>
                                        Internet宽带接入&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everyenvironment[0] == '' }">
                                    	<input type="checkbox" id="checkbox" value="Internet宽带接入" name="environment"/>
                                        Internet宽带接入&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    <d var="everyenvironment" items="${everyenvironment }">
                                    <d:choose>
                                    <d:when test="${everyenvironment[1] == '仓库信息管理系统' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="仓库信息管理系统" name="environment"/>
                                        仓库信息管理系统&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everyenvironment[1] == '' }">
                                    	<input type="checkbox" id="checkbox" value="仓库信息管理系统" name="environment"/>
                                        仓库信息管理系统&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    <d var="everyenvironment" items="${everyenvironment }">
                                    <d:choose>
                                    <d:when test="${everyenvironment[2] == '无' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="无" name="environment"/>
                                        无&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everyenvironment[2] == '' }">
                                    	<input type="checkbox" id="checkbox" value="无" name="environment"/>
                                        无&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">服务内容：</td>
                                    <td>
                                    <d var="everyserviceContent" items="${everyserviceContent }">
                                    <d:choose>
                                    <d:when test="${everyserviceContent[0] == '机械出入库搬运' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="机械出入库搬运" name="serviceContent"/>
                                        机械出入库搬运&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everyserviceContent[0] == '' }">
                                    	<input type="checkbox" id="checkbox" value="机械出入库搬运" name="serviceContent"/>
                                        机械出入库搬运&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    <d var="everyserviceContent" items="${everyserviceContent }">
                                    <d:choose>
                                    <d:when test="${everyserviceContent[1] == '分拣' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="分拣" name="serviceContent"/>
                                        分拣&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everyserviceContent[1] == '' }">
                                    	<input type="checkbox" id="checkbox" value="分拣" name="serviceContent"/>
                                        分拣&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    <d var="everyserviceContent" items="${everyserviceContent }">
                                    <d:choose>
                                    <d:when test="${everyserviceContent[2] == '包装' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="包装" name="serviceContent"/>
                                        包装&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everyserviceContent[2] == '' }">
                                    	<input type="checkbox" id="checkbox" value="包装" name="serviceContent"/>
                                        包装&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    <d var="everyserviceContent" items="${everyserviceContent }">
                                    <d:choose>
                                    <d:when test="${everyserviceContent[3] == '打托盘' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="打托盘" name="serviceContent"/>
                                        打托盘&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everyserviceContent[3] == '' }">
                                    	<input type="checkbox" id="checkbox" value="打托盘" name="serviceContent"/>
                                        打托盘&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    <d var="everyserviceContent" items="${everyserviceContent }">
                                    <d:choose>
                                    <d:when test="${everyserviceContent[4] == '地面存储' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="地面存储" name="serviceContent"/>
                                        地面存储&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everyserviceContent[4] == '' }">
                                    	<input type="checkbox" id="checkbox" value="地面存储" name="serviceContent"/>
                                        地面存储&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    <d var="everyserviceContent" items="${everyserviceContent }">
                                    <d:choose>
                                    <d:when test="${everyserviceContent[5] == '货架存储' }">
                                    	<input type="checkbox" id="checkbox" checked="checked" value="货架存储" name="serviceContent"/>
                                        货架存储&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    <d:when test="${everyserviceContent[5] == '' }">
                                    	<input type="checkbox" id="checkbox" value="货架存储" name="serviceContent"/>
                                       货架存储&nbsp;&nbsp;&nbsp;
                                    </d:when>
                                    </d:choose> 
                                    </d>
                                    </td>
                                </tr> --%>
                                  <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">保管形态：</td>
                                    <td>
                                        <input type="checkbox" id="checkbox" name="storageForm"/>
                                        普通仓库&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" id="checkbox" name="storageForm"/>
                                        冷藏仓库&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" id="checkbox" name="storageForm"/>
                                        恒温仓库&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" id="checkbox" name="storageForm"/>
                                        露天仓库&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" id="checkbox" name="storageForm"/>
                                        危险品仓库
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">防火安保：</td>
                                    <td>
                                        <input type="checkbox" id="checkbox" name="fireSecurity"/>
                                        烟感&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" id="checkbox" name="fireSecurity"/>
                                        自动喷淋&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" id="checkbox" name="fireSecurity"/>
                                        24小时摄像监控&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" id="checkbox" name="fireSecurity"/>
                                        无
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">IT环境：</td>
                                    <td>
                                        <input type="checkbox" id="checkbox" name="environment"/>
                                        Internet宽带接入&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" id="checkbox"  name="environment"/>
                                        仓库信息管理系统&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" id="checkbox" name="environment"/>
                                        无
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">服务内容：</td>
                                    <td>
                                        <input type="checkbox" id="checkbox" name="serviceContent"/>
                                        机械出入库搬运&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" id="checkbox" name="serviceContent"/>
                                        分拣&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" id="checkbox" name="serviceContent"/>
                                        包装&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" id="checkbox" name="serviceContent"/>
                                        打托盘&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" id="checkbox"  name="serviceContent"/>
                                        地面存储&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" id="checkbox" name="serviceContent"/>
                                        货架存储
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">联系人：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${warehouseInfo.contact }" name="contact" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">联系电话：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${warehouseInfo.phone }" name="phone" required/></td>
                                </tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">详细报价：</td>
									<td>
                                    	<div style="position:relative;">
                                        	<input id="apply_attachment1" type="text" class="input_attachment1" style="width:230px;" value="请参照模板格式要求填写后提交..." /><input id="upload_btn3" type="button" value="添加" class="input_attachment_btn1" style="width:60px; margin-left:10px;" />
      <input id="upload_btn4" type="file" name="file" onchange="document.getElementById('apply_attachment1').value=/[^\\]+\.\w+$/.exec(this.value)[0]" class="input_attachment_btn1_hidden" style="width:300px;" hidefocus="true" required/>
                                        </div>
                                    </td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">补充信息：</td>
									<td>
                                    	<textarea class="textarea_rating" placeholder="请输入内容..." name="remarks" required>${warehouseInfo.remarks }</textarea>
                                    </td>
								</tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
                                    <td><input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" /><!-- <input type="button" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" /> --></td>
                                </tr>
                            </table>
                            </c>
                            </form>
                    	</td>
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
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="views/footer.jsp"></iframe>
</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
	}
</script>
</html>