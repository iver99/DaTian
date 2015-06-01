<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>车辆详细信息</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no" />
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css" />
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

<%@ include file="qq.jsp"%>

<%@ include  file="topFrame.jsp"%>
<div id="main_frame">
	<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;<a href="resource_list.htm" hidefocus="true">车辆</a>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tbody>
	
		<tr>
			<td width="320" class="td_leftnav_top"><img src="images/illust_2c.jpg" /></td>
			<td class="td_detail_top">
            	车牌照号：<span class="text_detail_title1">${carInfo.carNum }</span>
                <br />
                车辆规格：<span class="text_detail_title2">${carInfo.carLength }</span>
                <br />
                车辆载重：<span class="text_detail_title2">${carInfo.carWeight }</span>
                <br />
                目前状态：<span class="text_detail_title1">${carInfo.carState }</span>
                <br />
                定位方式：GPS定位
                <br />
                当前位置：上海-上海市-闸北区吴淞路22号 (定位时间 2014-03-22 17:39:20)&nbsp;&nbsp;<a href="javascript:;" hidefocus="true"><img src="images/btn_refresh1.png" alt="刷新" /></a>
                <br />
                发布日期：${carInfo.relDate }
                <br />
              浏览次数：309
                <br />
            	所属公司：${carrierInfo.companyName }
            
                <br />
                联系电话：${carrierInfo.phone }
                <hr class="hr_1" />
               <input type="button" value="0" style="display:none" id="i"></input>
                <c:forEach var="focus" items="${focusList }">
					<c:if test="${carInfo.id==focus.focusId}">
						<script>
							document.getElementById("i").value=1;
						</script>
					</c:if>
				</c:forEach>
				<script type="text/javascript">
					if(document.getElementById("i").value==1)
						document.write( "<input type=\"button\" id=\"btnfav\" value=\"已关注\" class=\"input_detail3\" hidefocus=\"true\" onclick=\"loadXMLDoc('${carInfo.id }');hidefav(this);\" />" );
					else
						document.write( "<input type=\"button\" id=\"btnfav\" value=\"关注\" class=\"input_detail1\" hidefocus=\"true\" onclick=\"loadXMLDoc('${carInfo.id }');hidefav(this);\" />" );
				</script>
                <input type="button" id="btn2" value="提交订单" class="input_detail2" hidefocus="true" onclick="window.location.href='getneworderform?carrierid=${carInfo.carrierId}&flag=3&resourceId=${carInfo.id}'" />
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
                        <li><a href="#item2" hidefocus="true">运营线路</a></li>
                        <li><a href="#item3" hidefocus="true">公司信息</a></li>
                        <li><a href="#item4" hidefocus="true">评价记录</a></li>
                    </ul>
                    <div class="list_wrap">
                        <ul id="item1">
                            <li>用途：${carInfo.carUse }</li>
                            <li>车型：${carInfo.carType }</li>
                            <li>厢型：(数据库没有)</li>
                            <li>品牌：${carInfo.carBrand }</li>
                            <li>冷藏：${carInfo.storage }</li>
                            <li>购置日期：${carInfo.purchaseTime }</li>
                       
                        </ul>
                        <ul id="item2" class="tab_hide">
                            <li class="item2a">${linetransportInfo.startPlace }←→${linetransportInfo.endPlace }</li>
                            <li class="item2a">经停城市：数据库没有，与城市关联？（石家庄、郑州）</li>
                        </ul>
                        <ul id="item3" class="tab_hide">
                           	<li>公司名称：${carrierInfo.companyName }</li>
                            <li>公司性质：${carrierInfo.companyType }</li>
                            <li>注册日期：${carrierInfo.relDate }</li>
                            <li>服务行业：${carrierInfo.serviceIndustry }</li>
                            <li>业务种类：专线卡车</li>
                            <li>信用等级：${carrierInfo.creditRate	 }级</li>
                        </ul>
                        <ul id="item4" class="tab_hide">
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
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
	}
</script>
<script type="text/javascript">
function loadXMLDoc(id)
{
	$.ajax({
		   type: "GET",
		   url: "http://localhost:8585/DaTian/focus",//请求的后台地址
		   data: "type=car&id=" + id,//前台传给后台的参数
		   success: function(msg){//msg:返回值
			   loadFocus();
		   }
		});
}
</script>
</html>