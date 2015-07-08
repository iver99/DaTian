<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的关注</title>
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
<%@ include file="jsTool.jsp" %>
<script type="text/javascript"> 
	$(function() {
		$('input, textarea').placeholder(); 
	});
</script>
</head>

<body>

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
                        <a href="getallfocus" class="a_mgmt_leftnav1" hidefocus="true">我的关注</a>
                        <%} %>
                       	<% if((Integer)session.getAttribute("userKind") ==3) {%><!-- 企业用户 -->
                        <a href="getallresponse" class="a_mgmt_leftnav" hidefocus="true">我的反馈</a>
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
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2">
                    <tr>
                    	<td>
                        	<span class="span_mgmt_right2_text1">我的关注</span>
                            <!-- <span class="span_mgmt_right2_text2"><a href="javascript:;" hidefocus="true" class="a_btn_mgmt3">取消关注</a></span> -->
                            <div class="div_mgmt_s1">
                            <form action="findfocus" method="post">
                            	<input type="text" class="input_mgmt1" style="width:200px;" value="关注内容" name="text"/>
                                <input type="submit" id="btn1" value="查询" class="btn_mgmt3" hidefocus="true" />
                                </form>
                            </div>
                        </td>
                	</tr>
            	</table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td width="30" height="40" class="td_mgmt_right3_head1"><input type="checkbox" id="f1_all" onClick="selectall();" /></td>
						<td width="60" class="td_mgmt_right3_head">类别</td>
                        <td class="td_mgmt_right3_head">名称</td>
                        <td width="80" class="td_mgmt_right3_head">发布日期</td>
                        <td width="60" class="td_mgmt_right3_head">状态</td>
                        <td width="80" class="td_mgmt_right3_head">操作</td>
					</tr>
                   <c:forEach var="focusLineList" items="${focusLineList }">
                     <tr>
						<td height="60" class="td_mgmt_right3_td1d"><input type="checkbox" name="f1" id="f1a" /></td>
						<td class="td_mgmt_right3_td1">运输线路</td>
						<td class="td_mgmt_right3_td1">
                            <a href="linetransportdetail?linetransportid=${focusLineList.focusId }&carrierId=${focusLineList.carrierId}&linetransportId=${focusLineList.id }&flag=0" hidefocus="true">
                            ${focusLineList.startPlace }→${focusLineList.endPlace }&nbsp;<img src="images/btn_new1.png" /></a>
                            <br />
                            <a href="companyDetail?id=${focusLineList.carrierId }" class="link1" hidefocus="true">${focusLineList.companyName }&nbsp;<img src="images/btn_level1a.png" /></a>
                        </td>
                        <td class="td_mgmt_right3_td1">${focusLineList.relDate }</td>
                        <c:choose>
                        <c:when test="${focusLineList.status == '有效' }">
						<td class="td_mgmt_right3_td1">有效</td>
                        <td class="td_mgmt_right3_td3">
                            <div id="handlebox" style="z-index:205;">
                                <ul class="quickmenu">
                                    <li class="menuitem">
                                        <div class="menu">
                                            <a href="getneworderform?carrierid=${focusLineList.carrierId}&flag=1&resourceId=${focusLineList.focusId}" class="menuhd" hidefocus="true">提交订单</a> 
                                            <div class="menubd">
                                                <div class="menubdpanel">
                                                    <a href="deletefocus?id=${focusLineList.id }" class="a_top3" hidefocus="true">取消关注</a>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </td>
                        </c:when>
                        <c:when test="${focusLineList.status == '失效' }">
                        <td class="td_mgmt_right3_td1"><span class="span_mgmt_right3_text3">失效</span></td>
                        <td class="td_mgmt_right3_td3"><a href="deletefocus?id=${focusLineList.id }" hidefocus="true">取消关注</a></td>
                        </c:when>
                        </c:choose>
					</tr>
					</c:forEach>
				<c:forEach var="focusCitylineList" items="${focusCitylineList }">
                     <tr>
						<td height="60" class="td_mgmt_right3_td1d"><input type="checkbox" name="f1" id="f1a" /></td>
						<td class="td_mgmt_right3_td1">配送城市</td>
						<td class="td_mgmt_right3_td1">
                            <a href="citylinedetail?citylineId=${focusCitylineList.focusId }&carrierId=${focusCitylineList.carrierId }&flag=0" hidefocus="true">
                            ${focusCitylineList.name }&nbsp;<img src="images/btn_new1.png" /></a>
                            <br />
                            <a href="companyDetail?id=${focusCitylineList.carrierId }" class="link1" hidefocus="true">${focusCitylineList.companyName }&nbsp;<img src="images/btn_level1a.png" /></a>
                        </td>
                        <td class="td_mgmt_right3_td1">${focusCitylineList.relDate }</td>
                        <c:choose>
                        <c:when test="${focusCitylineList.status == '有效' }">
						<td class="td_mgmt_right3_td1">有效</td>
                        <td class="td_mgmt_right3_td3">
                            <div id="handlebox" style="z-index:205;">
                                <ul class="quickmenu">
                                    <li class="menuitem">
                                        <div class="menu">
                                            <a href="getneworderform?carrierid=${focusCitylineList.carrierId}&flag=2&resourceId=${focusCitylineList.focusId}" class="menuhd" hidefocus="true">提交订单</a> 
                                            <div class="menubd">
                                                <div class="menubdpanel">
                                                    <a href="deletefocus?id=${focusCitylineList.id }" class="a_top3" hidefocus="true">取消关注</a>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </td>
                        </c:when>
                        <c:when test="${focusCitylineList.status == '失效' }">
                        <td class="td_mgmt_right3_td1"><span class="span_mgmt_right3_text3">失效</span></td>
                        <td class="td_mgmt_right3_td3"><a href="deletefocus?id=${focusCitylineList.id }" hidefocus="true">取消关注</a></td>
                        </c:when>
                        </c:choose>
					</tr>
					</c:forEach>
				
				<c:forEach var="focusCarList" items="${focusCarList }">
                     <tr>
						<td height="60" class="td_mgmt_right3_td1d"><input type="checkbox" name="f1" id="f1a" /></td>
						<td class="td_mgmt_right3_td1">车辆</td>
						<td class="td_mgmt_right3_td1">
                            <a href="cardetail?carId=${focusCarList.focusId }&carrierId=${focusCarList.carrierId}&linetransportId=${focusCarList.linetransportId }&flag=0" hidefocus="true">
                            ${focusCarList.carNum }&nbsp;<img src="images/btn_new1.png" /></a>
                            <br />
                            <a href="companyDetail?id=${focusCarList.carrierId }" class="link1" hidefocus="true">${focusCarList.companyName }&nbsp;<img src="images/btn_level1a.png" /></a>
                        </td>
                        <td class="td_mgmt_right3_td1">${focusCarList.relDate }</td>
                        <c:choose>
                        <c:when test="${focusCarList.status == '有效' }">
						<td class="td_mgmt_right3_td1">有效</td>
                        <td class="td_mgmt_right3_td3">
                            <div id="handlebox" style="z-index:205;">
                                <ul class="quickmenu">
                                    <li class="menuitem">
                                        <div class="menu">
                                            <a href="getneworderform?carrierid=${focusCarList.carrierId}&flag=3&resourceId=${focusCarList.focusId}" class="menuhd" hidefocus="true">提交订单</a> 
                                            <div class="menubd">
                                                <div class="menubdpanel">
                                                    <a href="deletefocus?id=${focusCarList.id }" class="a_top3" hidefocus="true">取消关注</a>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </td>
                        </c:when>
                        <c:when test="${focusCarList.status == '失效' }">
                        <td class="td_mgmt_right3_td1"><span class="span_mgmt_right3_text3">失效</span></td>
                        <td class="td_mgmt_right3_td3"><a href="deletefocus?id=${focusCarList.id }" hidefocus="true">取消关注</a></td>
                        </c:when>
                        </c:choose>
					</tr>
					</c:forEach>
				
				<c:forEach var="focusWarehouseList" items="${focusWarehouseList }">
                     <tr>
						<td height="60" class="td_mgmt_right3_td1d"><input type="checkbox" name="f1" id="f1a" /></td>
						<td class="td_mgmt_right3_td1">仓库</td>
						<td class="td_mgmt_right3_td1">
                            <a href="warehousedetail?warehouseId=${focusWarehouseList.focusId }&carrierId=${focusWarehouseList.carrierId}&flag=0" hidefocus="true">
                            ${focusWarehouseList.name }&nbsp;<img src="images/btn_new1.png" /></a>
                            <br />
                            <a href="companyDetail?id=${focusWarehouseList.carrierId }" class="link1" hidefocus="true">${focusWarehouseList.companyName }&nbsp;<img src="images/btn_level1a.png" /></a>
                        </td>
                        <td class="td_mgmt_right3_td1">${focusWarehouseList.relDate }</td>
                        <c:choose>
                        <c:when test="${focusWarehouseList.status == '有效' }">
						<td class="td_mgmt_right3_td1">有效</td>
                        <td class="td_mgmt_right3_td3"><a href="deletefocus?id=${focusWarehouseList.id }" hidefocus="true">取消关注</a></td>
                        
                        </c:when>
                        <c:when test="${focusWarehouseList.status == '失效' }">
                        <td class="td_mgmt_right3_td1"><span class="span_mgmt_right3_text3">失效</span></td>
                        <td class="td_mgmt_right3_td3"><a href="deletefocus?id=${focusWarehouseList.id }" hidefocus="true">取消关注</a></td>
                        </c:when>
                        </c:choose>
					</tr>
					</c:forEach>
					
					<c:forEach var="focusCompanyList" items="${focusCompanyList }">
                     <tr>
						<td height="60" class="td_mgmt_right3_td1d"><input type="checkbox" name="f1" id="f1a" /></td>
						<td class="td_mgmt_right3_td1">公司</td>
						<td class="td_mgmt_right3_td1">
                            <a href="companyDetail?id=${focusCompanyList.focusId }" hidefocus="true">
                            ${focusCompanyList.companyName }&nbsp;<img src="images/btn_level1a.png" /></a>
                        </td>
                        <td class="td_mgmt_right3_td1">${focusCompanyList.relDate }</td>
                        <c:choose>
                        <c:when test="${focusCompanyList.status == '有效' }">
						<td class="td_mgmt_right3_td1">有效</td>
                       <td class="td_mgmt_right3_td3">
                            <div id="handlebox" style="z-index:205;">
                                <ul class="quickmenu">
                                    <li class="menuitem">
                                        <div class="menu">
                                            <a href="getneworderform?carrierid=${focusCompanyList.carrierId}&flag=4" class="menuhd" hidefocus="true">提交订单</a> 
                                            <div class="menubd">
                                                <div class="menubdpanel">
                                                    <a href="deletefocus?id=${focusCompanyList.id }" class="a_top3" hidefocus="true">取消关注</a>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </td>
                        </c:when>
                        <c:when test="${focusCompanyList.status == '失效' }">
                        <td class="td_mgmt_right3_td1"><span class="span_mgmt_right3_text3">失效</span></td>
                        <td class="td_mgmt_right3_td3"><a href="deletefocus?id=${focusCompanyList.id }" hidefocus="true">取消关注</a></td>
                        </c:when>
                        </c:choose>
					</tr>
					</c:forEach>
					
					<c:forEach var="focusGoodsList" items="${focusGoodsList }">
                     <tr>
						<td height="60" class="td_mgmt_right3_td1d"><input type="checkbox" name="f1" id="f1a" /></td>
						<td class="td_mgmt_right3_td1">货物</td>
						<td class="td_mgmt_right3_td1">
                            <a href="goodsdetail?id=${focusGoodsList.focusId }" hidefocus="true">
                            ${focusGoodsList.name }</a>
                        </td>
                        <td class="td_mgmt_right3_td1">${focusGoodsList.relDate }</td>
                        <c:choose>
                        <c:when test="${focusGoodsList.status == '有效' }">
						<td class="td_mgmt_right3_td1">有效</td>
                       <td class="td_mgmt_right3_td3"><a href="deletefocus?id=${focusGoodsList.id }" hidefocus="true">取消关注</a></td>
                        </c:when>
                        <c:when test="${focusGoodsList.status == '失效' }">
                        <td class="td_mgmt_right3_td1"><span class="span_mgmt_right3_text3">失效</span></td>
                        <td class="td_mgmt_right3_td3"><a href="deletefocus?id=${focusGoodsList.id }" hidefocus="true">取消关注</a></td>
                        </c:when>
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

<%@ include  file="popup1.jsp"%>

<%-- <div id="popup2" style="display:none;">
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="510"><div class="div_popup_title1">留言历史</div></td>
            <td>
                <div id="close2" style="cursor:pointer;"><img src="images/btn_cancel1.png" title="关闭本窗口" /></div>
            </td>
        </tr>
    </table>
    <table border="0" cellspacing="0" cellpadding="0" id="list" style="margin:5px 5px 0 15px;">
		<thead style="display:block;">
		   	<tr>
				<td style="width:250px" class="td_main_list_head">时间</td>
				<td style="width:250px" class="td_main_list_head">内容</td>
			</tr>
		</thead>
		<tbody id="getmessage" style="height:250px;overflow:auto;display:block;"></tbody>
	</table>
</div> --%>

<div id="footer_frame">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="views/footer.jsp"></iframe>
</div>

</body>
</html>