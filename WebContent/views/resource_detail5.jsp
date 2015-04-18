<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>供应链资源管理平台-公司详细信息</title>
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
	<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;<a href="resource_list.htm" hidefocus="true">公司</a>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="320" class="td_leftnav_top"><img src="images/illust_2f.jpg" /></td>
			<td class="td_detail_top">
            	公司名称：<span class="text_detail_title1">${carrierinfo.companyName }</span>
                <br />                
                业务种类：<span class="text_detail_title2">干线运输、城市配送</span>
                <br />
            	公司性质：${carrierinfo.companyType }
                <br />
                发布日期：${carrierinfo.relDate }
                <br />
                浏览次数：309
                <br />
                联系电话：${carrierinfo.phone }
                <hr class="hr_1" />
                <input type="button" id="btn2" value="关注" class="input_detail1" hidefocus="true" onclick="window.location.href='mgmt_d_focus.htm'" />
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
                        <li><a href="#item2" hidefocus="true">运输线路资源</a></li>
                        <li><a href="#item3" hidefocus="true">配送网络资源</a></li>
                        <li><a href="#item4" hidefocus="true">仓库资源</a></li>
                    </ul>
                    <div class="list_wrap">
                        <ul id="item1">
                            <li>资源级别：${carrierinfo.resourceRate }</li>
                            <li>信用等级：${carrierinfo.creditRate }级</li>
                            <li>押金状况：${carrierinfo.depositCondition }</li>
                            <li>发票种类：${carrierinfo.invoiceKind }</li>
                            <li>公司地址：${carrierinfo.companyAddr }</li>
                            <li>公司规模：${carrierinfo.companyScale }</li>
                            <li>服务行业：${carrierinfo.serviceIndustry }</li>
                        </ul>
                        <ul id="item2" class="tab_hide">
                            <table border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="200" height="30">名称</td>
                                    <td width="120">在途时限(小时)</td>
                                    <td width="120">参考报价(元/kg)</td>
                                    <td width="120">运输类型</td>
                                </tr>
                                <tr>
                                    <td height="25"><a href="resource_detail1.htm" hidefocus="true">北京→上海</a></td>
                                    <td>12</td>
                                    <td>3.00</td>
                                    <td>整车</td>
                                </tr>
                                <tr>
                                    <td height="25"><a href="javascript:;" hidefocus="true">北京→上海</a></td>
                                    <td>12</td>
                                    <td>3.00</td>
                                    <td>整车</td>
                                </tr>
                                <tr>
                                    <td height="25"><a href="javascript:;" hidefocus="true">北京→上</a>海</td>
                                    <td>12</td>
                                    <td>3.00</td>
                                    <td>整车</td>
                                </tr>
                                <tr>
                                    <td height="25"><a href="javascript:;" hidefocus="true">北京→上海</a></td>
                                    <td>12</td>
                                    <td>3.00</td>
                                    <td>整车</td>
                                </tr>
                                <tr>
                                    <td height="25"><a href="javascript:;" hidefocus="true">北京→上海</a></td>
                                    <td>12</td>
                                    <td>3.00</td>
                                    <td>整车</td>
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
                        </ul>
                        <ul id="item3" class="tab_hide">
                            <table border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="200" height="30">名称</td>
                                    <td width="120">参考报价(元/kg)</td>
                                    <td width="120">增值服务</td>
                                </tr>
                                <tr>
                                    <td height="25">北京城市配送</td>
                                    <td>1.50</td>
                                    <td>有</td>
                                </tr>
                                <tr>
                                    <td height="25">上海城市配送</td>
                                    <td>1.50</td>
                                    <td>有</td>
                                </tr>
                                <tr>
                                    <td height="25">上海城市配送</td>
                                    <td>1.50</td>
                                    <td>有</td>
                                </tr>
                                <tr>
                                    <td height="25">上海城市配送</td>
                                    <td>1.50</td>
                                    <td>有</td>
                                </tr>
                                <tr>
                                    <td height="25">上海城市配送</td>
                                    <td>1.50</td>
                                    <td>有</td>
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
                        </ul>
                        <ul id="item4" class="tab_hide">
                            <table border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="200" height="30">名称</td>
                                    <td width="120">所在城市</td>
                                    <td width="120">仓库类型</td>
                                    <td width="120">仓库面积(平方米)</td>
                                </tr>
                                <tr>
                                    <td height="25">1号库</td>
                                    <td>北京</td>
                                    <td>保税</td>
                                    <td>40000</td>
                                </tr>
                                <tr>
                                    <td height="25">2号库</td>
                                    <td>北京</td>
                                    <td>非保税</td>
                                    <td>80000</td>
                                </tr>
                                <tr>
                                    <td height="25">2号库</td>
                                    <td>北京</td>
                                    <td>非保税</td>
                                    <td>80000</td>
                                </tr>
                                <tr>
                                    <td height="25">2号库</td>
                                    <td>北京</td>
                                    <td>非保税</td>
                                    <td>80000</td>
                                </tr>
                                <tr>
                                    <td height="25">2号库</td>
                                    <td>北京</td>
                                    <td>非保税</td>
                                    <td>80000</td>
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