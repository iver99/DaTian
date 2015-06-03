<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                        <a href="warehouse?flag=1" class="a_mgmt_leftnav" hidefocus="true">仓库信息</a>
						<a href="driver?flag=1" class="a_mgmt_leftnav" hidefocus="true">司机信息</a>
                        <a href="client" class="a_mgmt_leftnav" hidefocus="true">客户信息</a>
                        <a href="goodsform?flag=1" class="a_mgmt_leftnav" hidefocus="true">货物信息</a>
                        <%} %>
                        <a href="contract" class="a_mgmt_leftnav1" hidefocus="true">合同信息</a>
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
                            <span class="span_mgmt_right2_text1">终止合同</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                    </tr>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a"> 
                        <br />   	          
                        <table width="90%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="120" height="40" class="td_mgmt_right3_td1b">合同编号：</td>
                                <td>${contract.id }</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">合同名称：</td>
                                <td>${contract.name }</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">承运方帐户：</td>
                                <td>${contract.carrierAccount } (${carrierInfo.companyName })</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">合同开始日期：</td>
                                <td>${contract.startDate }</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">合同截止日期：</td>
                                <td>${contract.endDate }</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">结算方式：</td>
                                <td>月结 (30天)</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">联系人：</td>
                                <td>${contract.contact }</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">手机号：</td>
                                <td>${contract.phone }</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">相关材料：</td>
                                <td><a href="downloadcontactrelated?id=${contract.id }" hidefocus="true"><img src="images/btn_filetype2.png" /></a></td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">补充信息：</td>
                                <td>${contract.remarks }</td>
                            </tr>
                            <tr>
                                <td width="120" height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
                                <td><input type="submit" id="btn1" value="终止" class="btn_mgmt1" hidefocus="true" onclick="showid('popup2');" /></td>
                            </tr>
                        </table>
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
            	<textarea class="textarea_popup1" placeholder="请输入内容..." ></textarea>
            </td>
        </tr>
        <tr>
            <td class="td_popup1">
                <input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" /><input type="button" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" />
            </td>
        </tr>
    </table>
</div>

<div id="popup2" style="display:none;">
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="510"><div class="div_popup_title1">终止合同的原因</div></td>
            <td>
                <div id="close2" style="cursor:pointer;"><img src="images/btn_cancel1.png" title="关闭本窗口" /></div>
            </td>
        </tr>
    </table>
    <form action="shutdownContract?contractId=${contract.id }&rorsflag=1" method="post">
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="540">
            	<textarea class="textarea_popup1" placeholder="请输入内容..." name="reason"></textarea>
            </td>
        </tr>
        <tr>
            <td class="td_popup1">
                <input type="submit" id="btn1" value="提交" class="btn_mgmt1"  hidefocus="true" />
                <input type="button" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" />
            </td>
        </tr>
    </table>
    </form>
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