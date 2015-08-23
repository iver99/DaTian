<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
  		String currentUserId=(String)session.getAttribute("userId");
  	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>货物信息</title>
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
<script type="text/javascript" src="js/focus_load.js"></script>
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
	<a href="myinfo" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的资源
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <%@ include  file="mysource_leftnav_mytrade.jsp" %>
                    <hr class="hr_2" />
                    <span class="text_mgmt_leftnav1"><span
							id="mgmt_nav_switch2a" class="span_mgmt_nav1" title="收起"
							onclick="mgmt_nav_switch2a();"></span><span
							id="mgmt_nav_switch2b" class="span_mgmt_nav2" title="展开"
							onclick="mgmt_nav_switch2b();"></span>我的资源</span>
						<div id="mgmt_nav2">
                       <% if((Integer)session.getAttribute("userKind") ==3) {%><!-- 企业用户 -->
                        <a href="linetransport?flag=1&Display=10&PageNow=1" class="a_mgmt_leftnav" hidefocus="true">干线运输线路信息</a>
                        <a href="cityline?flag=1" class="a_mgmt_leftnav" hidefocus="true">城市配送网络信息</a>
                        <a href="car?flag=1" class="a_mgmt_leftnav" hidefocus="true">车辆信息</a>
                        <a href="warehouse?flag=1" class="a_mgmt_leftnav" hidefocus="true">仓库信息</a>
						<a href="driver?flag=1" class="a_mgmt_leftnav" hidefocus="true">司机信息</a>
                        <a href="client" class="a_mgmt_leftnav" hidefocus="true">客户信息</a>
                        <%} %>
                        <% if((Integer)session.getAttribute("userKind") ==2) {%><!-- 个人用户 -->
                        <a href="goodsform?flag=1" class="a_mgmt_leftnav1" hidefocus="true">货物信息</a>
                        <a href="contract" class="a_mgmt_leftnav" hidefocus="true">合同信息</a>
                        <%} %>
                    </div>
                    <%@ include  file="mysource_leftnav_myplan.jsp"%>
                    <%@ include  file="mysource_leftnav_myanalysis.jsp"%>
                    <%@ include  file="mysource_leftnav_myaccount.jsp"%>
</div>
			</td>
					<td class="td_leftnav_top">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2a">
                    <tr>
                        <td>
                            <span class="span_mgmt_right2_text1">添加订单</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                    </tr>
                </table>
                <form action="createOrderFromCargo" method="post" id="new_order">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                    <!-- 隐藏字段，用于存储当前用户id -->
                    	<td><input type="hidden" id="currentUserId" name="currentUserId" value="<%=currentUserId %>"/></td>
                        <td class="td_mgmt_right3_td1a">
                            <div class="span_mgmt_right3_text4">基本信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">所属客户：</td>
									<td>
										<select style="width:120px;" name="clientName" id="clientName" required>
											<option value="" selected="selected">请选择</option>
                                        </select>
									</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">关联客户运单：</td>
                                    <td>
                                        <select id="isLinkToClientWayBill" style="width:120px;" onchange="changeIsLinkToClientWayBill()" name="isLinkToClientWayBill" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="有">有</option>
                                            <option value="无">无</option>
                                        </select>
                                        <div id="p_detail" style="display:none;">
                                            <input type="text" name="clientWayBillNum" class="input_mgmt1" style="width:176px;" placeholder="请输入客户运单号..."/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">承运方：</td>
                                    <td><input name="companyName" type="text" readonly="readonly" value="${carrierInfo.companyName }" required/></td>
                                	<!-- 隐藏字段 -->
                                	 <td><input id="carrierId" name="carrierId" value="${carrierId }" type="hidden"/> </td>
                                	  <td><input name="goodsId" value="${goodsId  }" type="hidden"/> </td>
                                	   <td><input name="responseId" value="${responseId}" type="hidden"/> </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">承运方合同：</td>
                                    <td>
                                        <select id="hasCarrierContract" style="width:120px;" onchange="changeHasCarrierContract();" name="hasCarrierContract" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="有">有</option>
                                            <option value="无">无</option>
                                        </select>
                                        <div id="c_detail" style="display:none;">
                                            <select style="width:93px;" name="contractId" id="contractId">
                                                <option value="" selected="selected">请选择</option>
                                            </select>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">资源分类：</td>
									<td>
										<select name="resourceType" id="resourceType" style="width:120px;" onchange="getResource()" required>
											<option value="" selected="selected">请选择</option>
                                            <option value="线路" >线路</option>
                                            <option value="配送" >配送</option>
                                            <option value="车辆" >车辆</option>
                                        </select>
									</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">资源名称：</td>
									<td>
										<select name="resourceName" id="resourceName" style="width:120px;" required>
											<option value="" selected="selected">请选择</option>
                                            <!--  <option value="北京→上海">北京→上海</option>
                                            <option value="北京→天津">北京→天津</option>
                                            <option value="北京→广州">北京→广州</option> --> 
                                        </select>
									</td>
                                </tr>

                            </table>
                            <div class="span_mgmt_right3_text4">货物信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">货物名称：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" id="goodsName" name="goodsName" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">货物重量：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" id="goodsWeight" name="goodsWeight" required/>
                                    (公斤)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">货物体积：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" id="goodsVolume" name="goodsVolume" required/>
                                    (立方米)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">货物声明价值：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" id="declaredPrice" name="declaredPrice" required/>
                                    (元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">保险费：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" id="insurance" name="insurance" required/>
                                    (元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">运费：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" id="expectedPrice" name="expectedPrice" required/>
                                    (元)</td>
                                </tr>
                            </table>
                            <div class="span_mgmt_right3_text4">地址信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">
                                    	发货人信息
                                        <a href="javascript:;" onclick="showid('popup2');" hidefocus="true"><img src="images/btn_address.png" title="查询" /></a>
                                    </td>
                                    <td width="270">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td width="100" class="td_mgmt_right3_td1b">
                                    	收货人信息
                                        <a href="javascript:;" onclick="showid('popup3');" hidefocus="true"><img src="images/btn_address.png" title="查询" /></a>
                                    </td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">姓名：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:200px;" name="deliveryName" id="deliveryName" required/></td>
                                    <td class="td_mgmt_right3_td1b">姓名：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:200px;" name="recieverName" id="recieverName" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">地址：</td>
                                    <td><textarea class="textarea_rating1" name="deliveryAddr" id="deliveryAddress" required></textarea></td>
                                    <td class="td_mgmt_right3_td1b">地址：</td>
                                    <td><textarea class="textarea_rating1" name="recieverAddr" id="recieverAddress" required></textarea></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">电话：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:200px;" name="deliveryPhone" id="deliveryPhone" required/></td>
                                    <td class="td_mgmt_right3_td1b">电话：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:200px;" name="recieverPhone" id="recieverPhone" required/></td>
                                </tr>
                                <tr>
                                    <td height="20" class="td_mgmt_right3_td1b">&nbsp;</td>
                                    <td><input type="checkbox" id="sender_info" name="sender_info"/>&nbsp;加入常用发货地址</td>
                                    <td class="td_mgmt_right3_td1b">&nbsp;</td>
                                    <td><input type="checkbox" id="reciever_info" name="reciever_info"/>&nbsp;加入常用收货地址</td>
                                </tr>
                            </table>
                            <div class="span_mgmt_right3_text4">备注信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="120" height="40" class="td_mgmt_right3_td1b">备注：</td>
									<td>
                                    	<textarea class="textarea_rating" placeholder="请输入内容..." id="remarks" name="remarks" required></textarea>
                                    </td>
								</tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
                                    <td><input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" />
                                    <input type="reset" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" /></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
                </form>
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
            	<textarea class="textarea_popup1" placeholder="请输入内容..." id="message"></textarea>
            </td>
        </tr>
        <tr>
            <td class="td_popup1">
                <input type="button" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" onclick="insertMessage()"/><input type="button" id="btn2" value="重填" class="btn_mgmt2" hidefocus="true" />
            </td>
        </tr>
    </table>
</div>
	
	<div id="popup2" style="display:none;">
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="610"><div class="div_popup_title1">常用发货地址</div></td>
            <td>
                <div id="close2" style="cursor:pointer; margin-right:10px;"><img src="images/btn_cancel1.png" title="关闭本窗口" /></div>
            </td>
        </tr>
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_popup_address1">
        <tr>
            <td width="100" class="td_popup_address1">姓名</td>
            <td width="120" class="td_popup_address1">电话</td>
            <td class="td_popup_address1">地址</td>
        </tr>
    </table>
	<div class="div_popup_address">
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_popup_address2" >
            <tbody id="send_info">
            
            </tbody>
        </table>
    </div>
</div>

<div id="popup3" style="display:none;">
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="610"><div class="div_popup_title1">常用收货地址</div></td>
            <td>
                <div id="close3" style="cursor:pointer; margin-right:10px;"><img src="images/btn_cancel1.png" title="关闭本窗口" /></div>
            </td>
        </tr>
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_popup_address1">
        <tr>
            <td width="100" class="td_popup_address1">姓名</td>
            <td width="120" class="td_popup_address1">电话</td>
            <td class="td_popup_address1">地址</td>
        </tr>
    </table>
	<div class="div_popup_address">
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_popup_address2" >
            <tbody id="recieve_info">
            
            </tbody>
        </table>
    </div>
</div>

	<div id="footer_frame">
		<iframe allowtransparency="true" width="100%" frameborder="0"
			hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0"
			src="footer.jsp"></iframe>
	</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
		
		getUserContract();
		getUserClientName();
		
		//获取常用发货地址
		getFrequentAddress(1);
		//获取常用收货地址
		getFrequentAddress(2);
		
		//validate
		formValidate();
		
	}
	
	function formValidate(){
		
		$("#new_order").validate({
				rules : {
					clientName : "required",
					isLinkToClientWayBill : "required",
					hasCarrierContract : "required",
					goodsName : "required",
					driverName : "required",
					goodsVolume : {
						required : true,
						number : true
					},
					goodsWeight : {
						required : true,
						number : true
					},
					declaredPrice : {
						required : true,
						number : true
					},
					insurance : {
						required : true,
						number : true
					},
					expectedPrice : {
						required : true,
						number : true
					},
					deliveryName : "required",
					recieverName : "required",
					recieverphone : {
						required : true,
						number : true
					},
					deliveryphone : {
						required : true,
						number : true
					},
					deliveryAddr : "required",
					recieverAddr : "required",
					remarks : "required",

				}
			});
		}
	
	
	//获取常用地址]
	function getFrequentAddress(kind){
		var url="getUserAddressAjax";
		$.ajax({
			url:url,
			cache:false,
			dataType:"json",
			data:{kind:kind},
			success:function(data,status){
				var f;
				//debugger;
				if(kind ==1){
				 	f=$("#send_info");
				}else{
					f=$("#recieve_info");
				}
				f.empty();
				for(var i=0;i<data.length;i++){
					f.append("<tr>");
					f.append("<td width=\"100\" class=\"td_popup_address2a\">"+data[i].name+"</td>");
					f.append("<td width=\"120\" class=\"td_popup_address2\">"+data[i].phone+"</td>");
					f.append("<td class=\"td_popup_address2\">"+data[i].address+"</td>");
					f.append("</tr>");
					
				}
			}
		})
	}
	//返回用户的合同编号
	function getUserContract(){
		var url="getUserContractIdAjax";
		$.post(url,{currentUserId:$('#currentUserId').val()},function(data,status){
			var CONTRACTID=$('#contractId');
			CONTRACTID.empty();
			 for(var i=0;i<data.length;i++) {
		         option = $("<option>").text(data[i].id).val(data[i].id);
		         CONTRACTID.append(option);
		      }     
		},"json");
	}
	//返回用户的客户信息
	function getUserClientName(){
		var url="getUserBusinessClientAjax";
		$.post(url,{currentUserId:$('#currentUserId').val()},function(data,status){
			var client_name=$('#clientName');
			client_name.empty();
			 for(var i=0;i<data.length;i++) {
		         var option = $("<option>").text(data[i].clientName).val(data[i].clientName);
		         client_name.append(option);
		      }    
		},"json");
	}
	
	//如果选中了添加常用地址的选项则在提交表单时添加常用地址
   /*  function addAddress(){
		var url="addAddressAjax";
		var name;
		var phone;
		var address;
		//debugger;
		var sender_info=$("#sender_info");
		var receiver_info=$("#receiver_info");
		if($("#sender_info").attr("checked") == "checked"){//发货人添加常用地址选中
			name=$("#deliveryName").val();
			address=$("#deliveryAddr").val();
			phone=$("#deliveryPhone").val();
			$.ajax({
				type: "GET",
				url:url,
				data:{"name":name,
					"address":address,
					"phone":phone
					},
				cache:false,
				success:function(data){
					//不做任何操作
				}
			});
		}
		
		if(receiver_info.attr("checked") == "checked"){//收货人常用地址选中
			name=$("#recieverName").val();
			address=$("#recieverAddr").val();
			phone=$("#recieverPhone").val();
			
			$.ajax({
				type: "GET",
				url:url,
				data:{"name":name,
					"address":address,
					"phone":phone
					},
				cache:false,
				success:function(data){
					//不做任何操作
				}
			});
		}
		//提交订单
		$('#new_order').submit();
	} */
	
	//根据选择不同的资源，获得不同的资源列表
	function getResource(){
		var kind=$("#resourceType").val();
		var carrierId=$("#carrierId").val();
		var url ="";
		if(kind == '线路'){//加载公司的线路资源
			url="getCompanyLinetransportAjax";
		}else if(kind == '配送'){//加载公司的城市配送资源
			url="getCompanyCitylineAjax";
		}else if(kind == '车辆'){//加载公司的车辆资源
			url="getCompanyCarAjax";
		}
		//异步获取资源
		$.ajax({
			url:url,
			cache:false,
			data:{carrierId:carrierId},
			dataType:"json",
			success:function(data,status){
				var resource_name=$("#resourceName");
				resource_name.empty();
				for(var i=0;i<data.length;i++){
					if(kind == '线路'){
						var option =$("<option>").text(data[i].lineName);
					}else if(kind == '配送'){
						var option =$("<option>").text(data[i].name);
					}else if(kind == '车辆'){
						var option =$("<option>").text(data[i].carNum);
					}
					resource_name.append(option);
				}
			}
		});
	}
	
</script>
</html>