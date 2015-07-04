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
<%@ include file="jsTool.jsp" %>
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
                                     <a href="mysettlement" class="a_mgmt_right1_text2a" hidefocus="true"><!-- 130,992.00 --></a>
                                </div>
                                <div class="div_mgmt_index2b">
                                	 本月待结算金额 (元)
                                     <a href="mysettlement" class="a_mgmt_right1_text2b" hidefocus="true"><!-- 52,657.00 --></a>
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
                                    	待受理<br />
                                        <a href="javascript:;" hidefocus="true" id="transaction_info1"><img src="images/btn_mgmt1.png"></img><br />1</a>
                                    </li>
                                	<li class="li_mgmt_index1">
                                    	待收货<br />
                                        <a href="javascript:;" hidefocus="true" id="transaction_info2"><img src="images/btn_mgmt2.png"></img><br />2</a>
                                    </li>
                                	<li class="li_mgmt_index1">
                                    	待结算<br />
                                        <a href="javascript:;" hidefocus="true" id="transaction_info3"><img src="images/btn_mgmt3.png"></img><br />3</a>
                                    </li>
                                	<li class="li_mgmt_index2">
                                    	已完成<br />
                                        <a href="javascript:;" hidefocus="true" id="transaction_info4"><img src="images/btn_mgmt4.png"></img><br />4</a>
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

<%@ include  file="popup1.jsp"%>

<div id="footer_frame">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="views/footer.jsp"></iframe>
</div>
</html>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
		//获取我的信息-主页面下的交易信息
		getTransactionInfo();
		//获取用户页面上的结算信息
		getSettlementInfo();
		//获取用户页面上的投诉率
		getComplaintRate();
		//获取用户页面是的好评率
		getGoodCommentRate();
	}
	//获取好评率
	function getGoodCommentRate(){
		var url="getUserGoodCommentRateAjax";
		$.ajax({
			url:url,
			type:"GET",
			cache:false,
			success:function(data){//返回一个小于1的小数
				//画图-好评率
				getGoodCommentInfo(parseInt(data)*100);
				
			}
		});
	}
	//获取投诉率
	function getComplaintRate(){
		var url="getUserComplaintRateAjax";
		$.ajax({
			url:url,
			type:"GET",
			cache:false,
			success:function(data){//返回一个小于1的小数
				//画图-好评率和投诉率 
				getComplaintRateInfo(parseInt(data)*100);
			}
		});
	}
	
	//获取用户页面上的结算信息
	function getSettlementInfo(){
		var url="getUserSettlementInfoAjax";
		$.ajax({
			url:url,
			type:"GET",
			cache:false,
			success:function(data){
				var settlement_info=data.split("-");
				
				$("a.a_mgmt_right1_text2a").text(settlement_info[0]);
				
				$("a.a_mgmt_right1_text2b").text(settlement_info[1]);
				
			}
		});
	}
	
	//获取我的信息-主页面下的交易信息
	function getTransactionInfo(){
		var url="getUserTransactionInfoAjax";
		$.ajax({
			url:url,
			type:"GET",
			cache:false,
			success:function(data){
				//alert(data);
				var transaction_info=data.split("-");
				$('#transaction_info1').html("<img src=\"images/btn_mgmt1.png\" ></img><br />"+transaction_info[0]);
				$('#transaction_info2').html("<img src=\"images/btn_mgmt2.png\" ></img><br />"+transaction_info[1]);
				$('#transaction_info3').html("<img src=\"images/btn_mgmt3.png\" ></img><br />"+transaction_info[2]);
				$('#transaction_info4').html("<img src=\"images/btn_mgmt4.png\" ></img><br />"+transaction_info[3]);
				
			}
		});
		
		
		
		
	}
</script>