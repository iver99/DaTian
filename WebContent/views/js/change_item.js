/**
 * 此js文件为控制是否显示隐藏表单字段
 *
 */
/*订单相关*/
//关联客户运单
	function changeIsLinkToClientWayBill(){
		var f=$("#isLinkToClientWayBill");
		if($('#isLinkToClientWayBill option:selected').val()=='有'){
			$("#p_detail").attr("style","display:inline");
		}else{
			$("#p_detail").attr("style","display:none");
		}
	}
	
	//是否有合同
	function changeHasCarrierContract(){
		
		var f=$("#hasCarrierContract");
		if($('#hasCarrierContract option:selected').val()=='有'){
			$("#c_detail").attr("style","display:inline");
		}else{
			$("#c_detail").attr("style","display:none");
		}
		
	}
	
/*我的资源相关*/
	
/*城市配送网络信息-增值服务*/
	function changeHasVIPService(){
		var f=$("#VIPService");
		if($('#VIPService option:selected').val()=='有'){
			$("#v_detail").attr("style","display:inline");
		}else{
			$("#v_detail").attr("style","display:none");
		}
	}
	/*货物信息-增值服务*/
	function changeHasVIPService2(){
		var f=$("#VIPService");
		if($('#VIPService option:selected').val()=='需要'){
			$("#c_detail").attr("style","display:inline");
		}else{
			$("#c_detail").attr("style","display:none");
		}
	}
	
	/*车辆信息-定位方式*/
	function change_position(){
		var f=$("#locationType");
		if($('#locationType option:selected').val()=='GPS'){
			$("#pos_detail_1").attr("style","display:inline");
		}else{
			$("#pos_detail_1").attr("style","display:none");
		}
		
	}
	/*新增合同-结算方式*/
	function changeCaculateType(){
		var f=$("#caculateType");
		if($('#caculateType option:selected').val()=='月结'){
			$("#v_detail").attr("style","display:inline");
		}else{
			$("#v_detail").attr("style","display:none");
		}
	}
	
	
	
	
	


	