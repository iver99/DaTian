<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公司详细信息</title>
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
<script type="text/javascript" src="js/search_resource.js"></script><!-- 搜索资源 -->
<!-- 引入工具js -->
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
	<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;公司
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
                <input type="button" value="0" style="display:none" id="i"></input>
                <c:forEach var="focus" items="${focusList }">
					<c:if test="${carrierinfo.id==focus.focusId}">
						<script>
							document.getElementById("i").value=1;
						</script>
					</c:if>
				</c:forEach>
				<script type="text/javascript">
					if(document.getElementById("i").value==1)
						document.write( "<input type=\"button\" id=\"btnfav\" value=\"已关注\" class=\"input_detail3\" hidefocus=\"true\" onclick=\"loadXMLDoc('${carrierinfo.id }');hidefav(this);\" />" );
					else
						document.write( "<input type=\"button\" id=\"btnfav\" value=\"关注\" class=\"input_detail1\" hidefocus=\"true\" onclick=\"loadXMLDoc('${carrierinfo.id }');hidefav(this);\" />" );
				</script>
				<input type="button" id="btn2" value="提交订单" class="input_detail2" hidefocus="true" onclick="window.location.href='getneworderform?carrierid=${carrierinfo.id}&flag=4'" />
				
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
                                <c:forEach var="linetransportList" items="${linetransportList }">
                        
                                <tr>
                                    <td height="25"><a href="linetransportdetail?linetransportid=${linetransportList.id }&carrierId=${linetransportList.carrierId}&flag=0" hidefocus="true">${linetransportList.startPlace }→${linetransportList.endPlace }</a></td>
                                    <td>${linetransportList.onWayTime }</td>
                                    <td>${linetransportList.refPrice }</td>
                                    <td>${linetransportList.type }</td>
                                </tr>
                                
                            </c:forEach>
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
                        <c:forEach var="citylineList" items="${citylineList }">
                                <tr>
                                    <td height="25">${citylineList.name }</td>
                                    <td>${citylineList.refPrice }</td>
                                    <td>${citylineList.VIPService }</td>
                                </tr>
                          
                            </c:forEach>      
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
                        <c:forEach var="warehouseList" items="${warehouseList }">
                                <tr>
                                    <td height="25">${warehouseList.name }</td>
                                    <td>${warehouseList.city }</td>
                                    <td>${warehouseList.type }</td>
                                    <td>${warehouseList.houseArea }</td>
                                </tr>
                             
                            </c:forEach>   
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

<%@ include  file="popup1.jsp"%>

<div id="footer_frame">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.jsp"></iframe>
</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
	}
</script>
<script type="text/javascript">
function loadXMLDoc(id)
{
	var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
	$.ajax({
		   type: "GET",
		   url: curWwwPath.substring(0,pos) + "/DaTian/focus",//请求的后台地址
		   data: "type=company&id=" + id,//前台传给后台的参数
		   cache:false,
		   success: function(msg){//msg:返回值
			   if(msg == "login"){
				   location.assign(curWwwPath.substring(0,pos) + "/DaTian/loginForm");
			   }
			   loadFocus();
		   }
		});
}
</script>
</html>