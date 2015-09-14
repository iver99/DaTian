<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>运输线路详细信息</title>
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
<!-- <script type="text/javascript" src="js/search_resource.js"></script>搜索资源
<script type="text/javascript" src="js/resource_select.js" charset="UTF-8"></script> -->
<script type="text/javascript" src="js/rating3.js"></script> 
<script type="text/javascript" src="js/jquery.raty.min.js"></script>
<!-- 引入工具js -->
<%@ include file="jsTool.jsp" %>
<!-- <script type="text/javascript"> 

	$(function() {
		$('input, textarea').placeholder(); 
	});
</script> -->
</head>

<body onload="OnLoad()">

<%@ include file="qq.jsp"%>

<%@ include  file="topFrame.jsp"%>
<div id="main_frame">
	<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;运输线路
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tbody>
		<tr>
			<td width="320" class="td_leftnav_top"><img src="images/illust_2a.jpg" /></td>
			<td class="td_detail_top">线路名称：<span class="text_detail_title1">${linetransportInfo.startPlace }→${linetransportInfo.endPlace }</span>
                <br />
                运输类型：<span class="text_detail_title2">${linetransportInfo.type }</span>
                <br />
                在途时限：<span class="text_detail_title2">${linetransportInfo.onWayTime }</span>
                <br />
                参考报价：<span class="text_detail_title2">${linetransportInfo.refPrice }元/公斤</span>
                <br />
                详细报价：<a href="downloadlinedetailprice?id=${linetransportInfo.id }" hidefocus="true"><img src="images/btn_filetype2.png" /></a>
                <br />
                发布日期：${linetransportInfo.relDate }
                <br />
                浏览次数：309
                <br />
            	所属公司：${carrierInfo.companyName }
            
                <br />
                联系电话：${carrierInfo.phone }
            	
                <hr class="hr_1" />
                <input type="button" value="0" style="display:none" id="i"></input>
                <c:forEach var="focus" items="${focusList }">
					<c:if test="${linetransportInfo.id==focus.focusId}">
						<script>
							document.getElementById("i").value=1;
						</script>
					</c:if>
				</c:forEach>
				<script type="text/javascript">
					if(document.getElementById("i").value==1)
						document.write( "<input type=\"button\" id=\"btnfav\" value=\"已关注\" class=\"input_detail3\" hidefocus=\"true\" onclick=\"loadXMLDoc('${linetransportInfo.id }');hidefav(this);\" />" );
					else
						document.write( "<input type=\"button\" id=\"btnfav\" value=\"关注\" class=\"input_detail1\" hidefocus=\"true\" onclick=\"loadXMLDoc('${linetransportInfo.id }');hidefav(this);\" />" );
				</script>
                
                <input type="button" id="btn2" value="提交订单" class="input_detail2" hidefocus="true" onclick="window.location.href='getneworderform?carrierid=${linetransportInfo.carrierId}&flag=1&resourceId=${linetransportInfo.id}'" />
            
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
                        <li><a href="#item2" hidefocus="true">公司信息</a></li>
                        <li><a href="#item3" hidefocus="true">评价记录</a></li>
                    </ul>
                    <div class="list_wrap">
                        <ul id="item1">
                            ${linetransportInfo.remarks }
                        </ul>
                        <ul id="item2" class="tab_hide">
                            <li>公司名称：${carrierInfo.companyName }</li>
                            <li>公司性质：${carrierInfo.companyType }</li>
                            <li>注册日期：${carrierInfo.relDate }</li>
                            <li>服务行业：${carrierInfo.serviceIndustry }</li>
                            <li>业务种类：专线卡车</li>
                            <li>信用等级：${carrierInfo.creditRate	 }级</li>
                        </ul>
                        <ul id="item3" class="tab_hide">
                        	<div id="div_rating3">
                                <div class="div_rating_left1">综合：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;服务态度</div>
                                	<div id="rating1" class="div_rating_right1" data-score="0"></div>
                                	<input type="hidden" value="" id="rate1"/>
                                <div class="div_rating_left1">运输时效</div>
                                	<div id="rating2" class="div_rating_right1"	data-score="0"></div>
                                	<input type="hidden" value="" id="rate2"/>
                                <div class="div_rating_left1">货物安全</div>
                                	<div id="rating3" class="div_rating_right1" data-score="0"></div>
                                	<input type="hidden" value="" id="rate3"/>
                                <div class="div_rating_left1">总体费用</div>
                                	<div id="rating4" class="div_rating_right1" data-score="0"></div>
                                	<input type="hidden" value="" id="rate4"/>
                            </div>
                            <br />
                        	<c:forEach var="comment" items="${commentList }">
                            <li class="item2a">${comment.comment }------------------ ${comment.relDate }</li>
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
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.jsp"></iframe>
</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
		//加载评论星形效果
		setStar();
	}
</script>
<script type="text/javascript">
function loadXMLDoc(id){
	var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
	$.ajax({
		   type: "GET",
		   url: curWwwPath.substring(0,pos) + "/DaTian/focus",//请求的后台地址
		   data: "type=linetransport&id=" + id,//前台传给后台的参数
		   cache:false,
		   success: function(msg){//msg:返回值
			   if(msg == "login"){
				   location.assign(curWwwPath.substring(0,pos) + "/DaTian/loginForm");
			   }
			   loadFocus();
		   }
		});
}

//加载评论星形效果
function setStar(){
	//var serviceAttitude="${comment.serviceAttitude}";
	var serviceAttitude="${avgComment.serviceAttitude}";
	var transportEfficiency="${avgComment.transportEfficiency}";
	var cargoSafety="${avgComment.cargoSafety}";
	var totalMoney="${avgComment.totalMoney}";
	  if(serviceAttitude == '很好'){
		  $("#rating1").attr("data-score","5");
	}else if(serviceAttitude =='好'){
		 $("#rating1").attr("data-score","4");
	}else if(serviceAttitude == '一般'){
		 $("#rating1").attr("data-score","3");
	}else if(serviceAttitude =='差'){
		 $("#rating1").attr("data-score","2");
	}else{
		 $("#rating1").attr("data-score","1");
	}  
	//rating1();
	//$('#rating1').attr('data-score',3);
	if(transportEfficiency == '很好'){
		 $("#rating2").attr("data-score","5");
	}else if(transportEfficiency =='好'){
		 $("#rating2").attr("data-score","4");
	}else if(transportEfficiency == '一般'){
		 $("#rating2").attr("data-score","3");
	}else if(transportEfficiency =='差'){
		 $("#rating2").attr("data-score","2");
	}else{
		 $("#rating2").attr("data-score","1");
	}
	//rating2();
	//评价三
	 if(cargoSafety == '很好'){
		 $("#rating3").attr("data-score","5");
	}else if(cargoSafety =='好'){
		$("#rating3").attr("data-score","4");
	}else if(cargoSafety == '一般'){
		$("#rating3").attr("data-score","3");
	}else if(cargoSafety =='差'){
		$("#rating3").attr("data-score","2");
	}else{
		$("#rating3").attr("data-score","1");
	}
	//rating3();
	//评价四
	if(totalMoney == '很好'){
		$("#rating4").attr("data-score","5");
	}else if(totalMoney =='好'){
		$("#rating4").attr("data-score","4");
	}else if(totalMoney == '一般'){
		$("#rating4").attr("data-score","3");
	}else if(totalMoney =='差'){
		$("#rating4").attr("data-score","2");
	}else{
		$("#rating4").attr("data-score","1");
	} 
	//rating4();
	
}

</script>
</html>