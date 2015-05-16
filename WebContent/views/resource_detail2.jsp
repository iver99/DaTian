<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>配送网络详细信息</title>
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
	<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;<a href="resource_list.htm" hidefocus="true">配送网络</a>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tbody>
   
		<tr>
			<td width="320" class="td_leftnav_top"><img src="images/illust_2b.jpg" /></td>
			<td class="td_detail_top">
            	网络名称：<span class="text_detail_title1">${citylineInfo.cityName }</span>
                <br />
                参考报价：<span class="text_detail_title2">${citylineInfo.refPrice }元/公斤</span>
                <br />
                详细报价：<a href="javascript:;" hidefocus="true"><img src="images/btn_filetype2.png" /></a>
                <br />
                增值服务：${citylineInfo.VIPService }
                <br />
                发布日期：${citylineInfo.relDate }
                <br />
                浏览次数：309
                <br />
            	所属公司：${carrierInfo.companyName }
            
                <br />
                联系电话：${carrierInfo.phone }
                <hr class="hr_1" />
                <input type="button" id="btn2" value="关注" class="input_detail1" hidefocus="true" onclick="window.location.href='mgmt_d_focus.htm'" />
                <input type="button" id="btn2" value="提交订单" class="input_detail2" hidefocus="true" onclick="window.location.href='getneworderform?carrierid=${citylineInfo.carrierId}'" />
            </td>
		</tr>
		</tbody>
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top"></td>
            <td class="td_leftnav_top">
                <div id="detail_tab">
                    <ul class="nav">
                        <li><a href="#item1" class="current" hidefocus="true">补充信息</a></li>
                        <li><a href="#item2" hidefocus="true">配送范围</a></li>
                        <li><a href="#item3" hidefocus="true">公司信息</a></li>
                        <li><a href="#item4" hidefocus="true">评价记录</a></li>
                    </ul>
                    <div class="list_wrap">
                        <ul id="item1">
                            <li class="item2a">1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。</li>
                            <li class="item2a">2）时限从货物到达始发站的次日零时起开始计算。</li>
                            <li class="item2a">3）所有报价均不含保险，保险费率为货物声明价值的0.3%。</li>
                            <li class="item2a">4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。</li>
                            <li class="item2a">5）单票最低收费50元/票，不含提派费装卸费另计。</li>
                        </ul>
                        <ul id="item2" class="tab_hide">
                            <li class="item2a">配送城市：北京</li>
                            <li class="item2a">1）朝阳区：管庄、北苑、定福庄、三环以内、三环到四环之间、四环到五环之间</li>
                            <li class="item2a">2）海淀区：西三旗、西二旗、三环以内、三环到四环之间、四环到五环之间</li>
                            <li class="item2a">3）东城区：内环到二环、二环到三环</li>
                            <li class="item2a">4）西城区：内环到二环、二环到三环</li>
                            <li class="item2a">5）顺义区：后沙峪地区、空港街道、李桥镇、马坡地区</li>
                        </ul>
                        <ul id="item3" class="tab_hide">
                            <li>公司名称：${carrierInfo.companyName }</li>
                            <li>公司性质：${carrierInfo.companyType }</li>
                            <li>注册日期：${carrierInfo.relDate }</li>
                            <li>服务行业：${carrierInfo.serviceIndustry }</li>
                            <li>业务种类：专线卡车(数据库没有)</li>
                            <li>信用等级：${carrierInfo.creditRate }级</li>
                        </ul>
                        <ul id="item4" class="tab_hide">
                            <li class="item2a">服务好，准时！（西西 2014-03-12 18:29）</li>
                            <li class="item2a">服务好，准时！（西西 2014-03-12 18:29）</li>
                        </ul>
                    </div>
				</div>
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
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.htm"></iframe>
</div>

</body>
</html>