<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>货物详细信息</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/jquery.organictabs.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
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
	<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;<a href="resource_list6.htm" hidefocus="true">货物</a>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
    		<tr>
			<td width="320" class="td_leftnav_top"><img src="images/illust_2g.png" /></td>
			<td class="td_detail_top">货物名称：<span class="text_detail_title1">${goodsformInfo.name }</span>
                <br />
                运输类型：<span class="text_detail_title2">${goodsformInfo.transportType }</span>
                <br />
                重量：<span class="text_detail_title2">${goodsformInfo.weight }吨</span>
                <br />
                始发城市：${goodsformInfo.startPlace }
                <br />
                目的城市：${goodsformInfo.endPlace }
                <br />
                发布日期：${goodsformInfo.relDate }
                <br />
                有效期至：${goodsformInfo.limitDate }
                <br />
                发布人：${goodsformInfo.realName }<img src="images/btn_level2a.png" />
                <br />
                浏览次数：309
                <br />
                联系电话：${goodsformInfo.phone }
                <hr class="hr_1" />
                <% if((Integer)session.getAttribute("userKind") ==3) {%><!-- 企业用户 -->
                <input type="button" id="btn2" value="提交反馈" class="input_detail1" hidefocus="true" onclick="window.location.href='getresponseform?goodsid=${goodsformInfo.id}'" />
            	<% } %>
            </td>
		</tr>
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top"></td>
            <td class="td_leftnav_top">
                <div id="detail_tab">
                    <ul class="nav">
                        <li><a href="#item1" class="current" hidefocus="true">补充信息</a></li>
                    </ul>
                    <div class="list_wrap">
                        <ul id="item1">
                            <li class="item2a">说明：</li>
                            <li class="item2a">1）货物信息：包括大型仪器。</li>
                            <li class="item2a">2）货物的体积大，并且至少25米长。</li>
                            <li class="item2a">3）运送目的地包括华中五省的一级城市与二级城市。</li>
                            <li class="item2a">4）增值服务：需要对货物进行分拣包装。</li>
                            <li class="item2a">5）赔偿要求：若出现丢失或破损，须照原价赔偿。</li>
                        </ul>
                    </div>
				</div>
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
                <input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" />
                <input type="button" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" />
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