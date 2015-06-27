<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>仓库详细信息</title>
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
	<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;仓库
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
			<td width="320" class="td_leftnav_top"><img src="images/illust_2d.jpg" /></td>
			<td class="td_detail_top">
            	仓库名称：<span class="text_detail_title1">${warehouseInfo.name }</span>
                <br />
            	所在城市：<span class="text_detail_title1">${warehouseInfo.city }</span>
                <br />
                仓库面积：<span class="text_detail_title2">${warehouseInfo.houseArea }平方米</span>
                <br />
                仓库类型：<span class="text_detail_title2">${warehouseInfo.type }</span>
                <br />
                详细报价：<a href="downloadwarehousedetailprice?id=${warehouseInfo.id }" hidefocus="true"><img src="images/btn_filetype2.png" /></a>
                <br />
                发布日期：${warehouseInfo.relDate }
                <br />
                浏览次数：309
                <br />
            	所属公司：${carrierInfo.companyName }
            
                <br />
                联系电话：${carrierInfo.phone }
                <hr class="hr_1" />
                <input type="button" value="0" style="display:none" id="i"></input>
                <c:forEach var="focus" items="${focusList }">
					<c:if test="${warehouseInfo.id==focus.focusId}">
						<script>
							document.getElementById("i").value=1;
						</script>
					</c:if>
				</c:forEach>
				<script type="text/javascript">
					if(document.getElementById("i").value==1)
						document.write( "<input type=\"button\" id=\"btnfav\" value=\"已关注\" class=\"input_detail3\" hidefocus=\"true\" onclick=\"loadXMLDoc('${warehouseInfo.id }');hidefav(this);\" />" );
					else
						document.write( "<input type=\"button\" id=\"btnfav\" value=\"关注\" class=\"input_detail1\" hidefocus=\"true\" onclick=\"loadXMLDoc('${warehouseInfo.id }');hidefav(this);\" />" );
				</script>
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
                        <li><a href="#item2" hidefocus="true">公司信息</a></li>
                        <li><a href="#item3" hidefocus="true">评价记录</a></li>
                    </ul>
                    <div class="list_wrap">
                        <ul id="item1">
						    <li>地址：${warehouseInfo.address }</li>
                            <li>所属性质：${warehouseInfo.kind }</li>
                            <li>堆场面积：${warehouseInfo.yardArea }（平方米）</li>
                            <li>库层层高：${warehouseInfo.height }（米）</li>
                            <li>消防等级：${warehouseInfo.fireRate }</li>
                           <!--  <li>装卸平台：数据库没有（有）</li> -->
                            <li class="item2a">保管形态：${warehouseInfo.storageForm } </li>
                            <li class="item2a">服务内容：${warehouseInfo.serviceContent }</li>
                           <!--  <li class="item2a">搬运设备：数据库没有（托盘(库内使用)、叉车、打包机）</li> -->
                        </ul>
                        <ul id="item2" class="tab_hide">
                            <li>公司名称：${carrierInfo.companyName }</li>
                            <li>公司性质：${carrierInfo.companyType }</li>
                            <li>注册日期：${carrierInfo.relDate }</li>
                            <li>服务行业：${carrierInfo.serviceIndustry }</li>
                           <!--  <li>业务种类：专线卡车</li> -->
                            <li>信用等级：${carrierInfo.creditRate	 }级</li>
                        </ul>
                        <ul id="item3" class="tab_hide">
                           <c:forEach var="comment" items="${commentList }">
                            <li class="item2a">${comment.comment }--- ${comment.relDate }</li>
                            </c:forEach>
                        </ul>
                    </div>
				</div>
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
		   data: "type=warehouse&id=" + id,//前台传给后台的参数
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