<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的信息</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/mgmt.js"></script>
<script type="text/javascript" src="js/raphael.2.1.0.min.js"></script>
<script type="text/javascript" src="js/justgage.1.0.1.min.js"></script>
<script type="text/javascript" src="js/dashboard.js"></script>
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

<body  onload="OnLoad()">
<%@ include file="qq.jsp"%>

<%@ include  file="topFrame.jsp"%>
<div id="main_frame">
	<span class="text_main_title1">我的信息</span>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <%@ include  file="mysource_leftnav_mytrade.jsp"%>
                    <%@ include  file="mysource_leftnav_myresource.jsp"%>
                    <%@ include  file="mysource_leftnav_myplan.jsp"%>
                    <%@ include  file="mysource_leftnav_myanalysis.jsp"%>
                    <%@ include  file="mysource_leftnav_myaccount.jsp"%>
                    
</div>
			</td>
			<td class="td_leftnav_top">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right1">
                	<tr>
                    	<td class="td_mgmt_index1">
                        	<div class="div_mgmt_index1">
                                <span class="span_mgmt_right1_text1"><%=request.getSession().getAttribute("username") %>，欢迎您！<br /><img src="images/btn_level1a.png" /></span>
                            </div>
                        	<div class="div_mgmt_index2">

</body>
                                <div class="div_mgmt_index2a">
                                	 本月已结算金额 (元)
                                     <a href="mysettlement" class="a_mgmt_right1_text2a" hidefocus="true">130,992.00</a>
                                </div>
                                <div class="div_mgmt_index2b">
                                	 本月待结算金额 (元)
                                     <a href="mysettlement" class="a_mgmt_right1_text2b" hidefocus="true">52,657.00</a>
                                </div>
                            </div>
                        </td>
                	</tr>
            	</table>
            	<br />
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right1a">
                	<tr>
                    	<td class="td_mgmt_index1">
                        	<div class="div_mgmt_index3">
                                <span class="span_mgmt_right1_text1a">完成情况</span>
                            </div>
                        	<div class="div_mgmt_index4">
                                <ul class="ul_mgmt_index">
                                	<li class="li_mgmt_index3">
                                    	<div id="div_mgmt_dashboard1"></div>
                                    </li>
                                	<li class="li_mgmt_index3">
                                    	<div id="div_mgmt_dashboard2"></div>
                                    </li>
                                </ul>
                            </div>
                        </td>
                	</tr>
            	</table>
                <br />
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right1">
                	<tr>
                    	<td class="td_mgmt_index1">
                        	<div class="div_mgmt_index3">
                                <span class="span_mgmt_right1_text1a">交易情况</span>
                            </div>
                        	<div class="div_mgmt_index4">
                                <ul class="ul_mgmt_index">
                                	<li class="li_mgmt_index1">
                                    	待发货<br />
                                        <a href="javascript:;" hidefocus="true"><img src="images/btn_mgmt1.png" /><br />12</a>
                                    </li>
                                	<li class="li_mgmt_index1">
                                    	待收货<br />
                                        <a href="javascript:;" hidefocus="true"><img src="images/btn_mgmt2.png" /><br />12</a>
                                    </li>
                                	<li class="li_mgmt_index1">
                                    	待结算<br />
                                        <a href="javascript:;" hidefocus="true"><img src="images/btn_mgmt3.png" /><br />12</a>
                                    </li>
                                	<li class="li_mgmt_index2">
                                    	已完成<br />
                                        <a href="javascript:;" hidefocus="true"><img src="images/btn_mgmt4.png" /><br />12</a>
                                    </li>
                                </ul>
                            </div>
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
</html>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
	}
</script>