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
<script type="text/javascript" src="js/focus_load.js"></script>
<script type="text/javascript" src="js/search_resource.js"></script><!-- 搜索资源 -->
<script type="text/javascript" src="js/rating3.js"></script>
<script type="text/javascript" src="js/jquery.raty.min.js"></script>
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
	<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;配送网络
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tbody>
   
		<tr>
			<td width="320" class="td_leftnav_top"><img src="images/illust_2b.jpg" /></td>
			<td class="td_detail_top">
            	网络名称：<span class="text_detail_title1">${citylineInfo.cityName }</span>
                <br />
                参考报价：<span class="text_detail_title2">${citylineInfo.refPrice }元/公斤</span>
                <br />
                详细报价：<a href="downloaddetailprice?id=${citylineInfo.id }" hidefocus="true"><img src="images/btn_filetype2.png" /></a>
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
                <input type="button" value="0" style="display:none" id="i"></input>
                <c:forEach var="focus" items="${focusList }">
					<c:if test="${citylineInfo.id==focus.focusId}">
						<script>
							document.getElementById("i").value=1;
						</script>
					</c:if>
				</c:forEach>
				<script type="text/javascript">
					if(document.getElementById("i").value==1)
						document.write( "<input type=\"button\" id=\"btnfav\" value=\"已关注\" class=\"input_detail3\" hidefocus=\"true\" onclick=\"loadXMLDoc('${citylineInfo.id }');hidefav(this);\" />" );
					else
						document.write( "<input type=\"button\" id=\"btnfav\" value=\"关注\" class=\"input_detail1\" hidefocus=\"true\" onclick=\"loadXMLDoc('${citylineInfo.id }');hidefav(this);\" />" );
				</script>
                <input type="button" id="btn2" value="提交订单" class="input_detail2" hidefocus="true" onclick="window.location.href='getneworderform?carrierid=${citylineInfo.carrierId}&flag=2&resourceId=${citylineInfo.id}'" />
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
                          ${citylineInfo.remarks }
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
                            <!-- <li>业务种类：专线卡车(数据库没有)</li> -->
                            <li>信用等级：${carrierInfo.creditRate }级</li>
                        </ul>
                        <ul id="item4" class="tab_hide">
                        	<div id="div_rating3">
                                <div class="div_rating_left1">综合：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;服务态度</div>
                                <c:choose>
                                	<c:when test="${comment.serviceAttitude == '很好' }">
	                                	<div id="rating1" class="div_rating_right1" data-score="5"></div>
                                	</c:when>
                                	<c:when test="${comment.serviceAttitude == '好' }">
	                                	<div id="rating1" class="div_rating_right1" data-score="4"></div>
                                	</c:when>
                                	<c:when test="${comment.serviceAttitude == '一般' }">
	                                	<div id="rating1" class="div_rating_right1" data-score="3"></div>
                                	</c:when>
                                	<c:when test="${comment.serviceAttitude == '差' }">
	                                	<div id="rating1" class="div_rating_right1" data-score="2"></div>
                                	</c:when>
                                	<c:otherwise>
                                		<div id="rating1" class="div_rating_right1" data-score="1"></div>
                                	</c:otherwise>
                                </c:choose>
                                <div class="div_rating_left1">运输时效</div>
                                <c:choose>
                                	<c:when test="${comment.transportEfficiency == '很好' }">
		                                <div id="rating2" class="div_rating_right1" data-score="5"></div>
                                	</c:when>
                                	<c:when test="${comment.transportEfficiency == '好' }">
		                                <div id="rating2" class="div_rating_right1" data-score="4"></div>
                                	</c:when>
                                	<c:when test="${comment.transportEfficiency == '一般' }">
		                                <div id="rating2" class="div_rating_right1" data-score="3"></div>
                                	</c:when>
                                	<c:when test="${comment.transportEfficiency == '差' }">
		                                <div id="rating2" class="div_rating_right1" data-score="2"></div>
                                	</c:when>
                                	<c:otherwise>
 		                                <div id="rating2" class="div_rating_right1" data-score="1"></div>
                                	</c:otherwise>
                                </c:choose>
                                <div class="div_rating_left1">货物安全</div>
                                <c:choose>
                                	<c:when test="${comment.cargoSafety == '很好' }">
		                                <div id="rating3" class="div_rating_right1" data-score="5"></div>
                                	</c:when>
                                	<c:when test="${comment.cargoSafety == '好' }">
		                                <div id="rating3" class="div_rating_right1" data-score="4"></div>
                                	</c:when>
                                	<c:when test="${comment.cargoSafety == '一般' }">
		                                <div id="rating3" class="div_rating_right1" data-score="3"></div>
                                	</c:when>
                                	<c:when test="${comment.cargoSafety == '差' }">
		                                <div id="rating3" class="div_rating_right1" data-score="2"></div>
                                	</c:when>
                                	<c:otherwise>
                                		<div id="rating3" class="div_rating_right1" data-score="1"></div>
                                	</c:otherwise>
                                </c:choose>
                                <div class="div_rating_left1">总体费用</div>
                                <c:choose>
                                	<c:when test="${comment.totalMoney == '很好' }">
		                                <div id="rating4" class="div_rating_right1" data-score="5"></div>
                                	</c:when>
                                	<c:when test="${comment.totalMoney == '好' }">
		                                <div id="rating4" class="div_rating_right1" data-score="4"></div>
                                	</c:when>
                                	<c:when test="${comment.totalMoney == '一般' }">
		                                <div id="rating4" class="div_rating_right1" data-score="3"></div>
                                	</c:when>
                                	<c:when test="${comment.totalMoney == '差' }">
		                                <div id="rating4" class="div_rating_right1" data-score="2"></div>
                                	</c:when>
                                	<c:otherwise>
                                		<div id="rating4" class="div_rating_right1" data-score="1"></div>
                                	</c:otherwise>
                                </c:choose>
                            </div>
                            <br />
                            <c:forEach var="comment" items="${commentList }">
                            <li class="item2a">${comment.comment }------------ ${comment.relDate }</li>
                            </c:forEach>
                        </ul>
                    </div>
				</div>
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
		   data: "type=cityline&id=" + id,//前台传给后台的参数
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