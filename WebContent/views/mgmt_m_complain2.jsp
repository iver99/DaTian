<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>投诉管理</title>
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
<script type="text/javascript"> 
	$(function() {
		$('input, textarea').placeholder(); 
	});
</script>
</head>

<body>

<div id="backtop_item">
    <div class="qqserver">
        <div class="qqserver_fold">
            <div></div>
        </div>
        <div class="qqserver-body" style="display:block;">
            <div class="qqserver-header">
                <div>在线客服</div>
                <span class="qqserver_arrow"></span>
            </div>
            <a href="javascript:;" onclick="window.open('http://b.qq.com/webc.htm?new=0&sid=11223344&o=abc.com&q=1', '_blank')" hidefocus="true">咨询提问</a>
            <a href="javascript:;" hidefocus="true">意见建议</a>
            <div class="qqserver_comment" onclick="showid('popup1');" hidefocus="true">
                给我留言
            </div>
            <a href="javascript:;" class="a1" hidefocus="true">查看历史记录</a>
        </div>
    </div>
    <a id="backtop" onclick="return false;" title="回到顶部"></a> 
</div>

<%@ include  file="topFrame.jsp"%>
<div id="main_frame">
	<a href="allcomplaint" hidefocus="true" class="a_text_main_title1">后台管理</a>&nbsp;&gt;&nbsp;客户服务
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch1a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch1a();"></span><span id="mgmt_nav_switch1b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch1b();"></span>客户服务</span>
                    <div id="mgmt_nav1">
                        <a href="mgmt_m_complain.htm" class="a_mgmt_leftnav1" hidefocus="true">投诉管理</a>
                        <a href="mgmt_m_register.htm" class="a_mgmt_leftnav" hidefocus="true">用户验证</a>
                    </div>
                    <hr class="hr_2" />
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch2a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch2a();"></span><span id="mgmt_nav_switch2b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch2b();"></span>平台运营</span>
                    <div id="mgmt_nav2">
                        <a href="mgmt_m_pricetemplate.htm" class="a_mgmt_leftnav" hidefocus="true">报价模板信息</a>
                        <a href="mgmt_m_carmonitor.htm" class="a_mgmt_leftnav" hidefocus="true">车辆监控</a>
                    </div>
                </div>
			</td>
            <td class="td_leftnav_top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2a">
					<tr>
                    	<td>
                        	<span class="span_mgmt_right2_text1">投诉管理</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                	</tr>
            	</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
					<tr>
						<td class="td_mgmt_right3_td1a"> 
						<br />   
						<form action="doacceptcomplaint?id=${complaintInfo.id }" method="post">	          
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="120" height="40" class="td_mgmt_right3_td1b">类型：</td>
									<td>${complaintInfo.type }</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">主题：</td>
									<td>${complaintInfo.theme }</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">内容：</td>
									<td>${complaintInfo.content }</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">订单编号：</td>
									<td><a href="javascript:;" hidefocus="true">${orderinfo.orderNum }</a></td>
								</tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">相关材料：</td>
                                    <td><a href="javascript:;" hidefocus="true"><img src="images/btn_filetype2.png" /></a></td>
                                </tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">反馈：</td>
									<td>
                                    	<textarea name="feedback" class="textarea_rating" placeholder="请输入内容...">${complaintInfo.feedback }</textarea>
                                    </td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
									<td><input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" /><input type="reset" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" /></td>
								</tr>
							</table>
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
</html>