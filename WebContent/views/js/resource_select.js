$(document).ready(function(){
	var urladdtion = new Array([5]);//申请数组存储筛选控件状态
	
	urladdtion[0] = "";
	urladdtion[1] = "";
	urladdtion[2] = "";
	urladdtion[3] = "";
	urladdtion[4] = "";
							
	$("#select1 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("resource_all")) {
			$("#selectA").remove();
			urladdtion[0] = "All";//取消点选是状态恢复为all
		} else {
			var copyThisA = $(this).clone();
			/*urladdtion[0] = $(this).text().trim();//点选控件时控件value设置为当前text*/
			urladdtion[0] = jQuery.trim($(this).text());
			if ($("#selectA").length > 0) {
				$("#selectA a").html($(this).text());
			} else {
				$(".resource_result dl").append(copyThisA.attr("id", "selectA"));
			}
		}
	});
	
	$("#select2 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("resource_all")) {
			$("#selectB").remove();
			urladdtion[1] = "All";
		} else {
			var copyThisB = $(this).clone();
			/*urladdtion[1] = $(this).text().trim();*/
			urladdtion[1] = jQuery.trim($(this).text());
			if ($("#selectB").length > 0) {
				$("#selectB a").html($(this).text());
			} else {
				$(".resource_result dl").append(copyThisB.attr("id", "selectB"));
			}
		}
	});
	
	$("#select3 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("resource_all")) {
			$("#selectC").remove();
			urladdtion[2] = "All";
		} else {
			var copyThisC = $(this).clone();
			/*urladdtion[2] = $(this).text().trim();*/
			urladdtion[2] = jQuery.trim($(this).text());
			if ($("#selectC").length > 0) {
				$("#selectC a").html($(this).text());
			} else {
				$(".resource_result dl").append(copyThisC.attr("id", "selectC"));
			}
		}
	});
	
	$("#select4 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("resource_all")) {
			$("#selectD").remove();
			urladdtion[3] = "All";
		} else {
			var copyThisD = $(this).clone();
			/*urladdtion[3] = $(this).text().trim();*/
			urladdtion[3] = jQuery.trim($(this).text());
			if ($("#selectD").length > 0) {
				$("#selectD a").html($(this).text());
			} else {
				$(".resource_result dl").append(copyThisD.attr("id", "selectD"));
			}
		}
	});

	
	$("#select5 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("resource_all")) {
			$("#selectE").remove();
			urladdtion[4] = "All";
		} else {
			var copyThisE = $(this).clone();
			/*urladdtion[4] = $(this).text().trim();*/
			urladdtion[4] = jQuery.trim($(this).text());
			if ($("#selectE").length > 0) {
				$("#selectE a").html($(this).text());
			} else {
				$(".resource_result dl").append(copyThisE.attr("id", "selectE"));
			}
		}
	});
	
	$("#btn1").click(function () {//筛选按钮
		//清空页码
		var page_layout=$('#page_layout');
		page_layout.empty();
		/*var page_info=$('#page_info').val().trim();*/
		var page_info=jQuery.trim($('#page_info').val());
		if(page_info=='运输线路'){
			//筛选资源
			if($('#flag').val() == '0'){//直接点击筛选
				//currentPage置为1
				$('#currentPage').val(1);
				
				getSelectedLineAjax(
						$('#city1').val(),
						$('#city2').val(),
						urladdtion[0],
						urladdtion[2],
						urladdtion[1],
						$('#display').val(),
						$('#currentPage').val());
				//总条数
			    getSelectedLineTotalRowsAjax(
			    		$('#city1').val(),
			    		$('#city2').val(),
			    		urladdtion[0],
						urladdtion[2],
						urladdtion[1],
						$('#display').val(),
						$('#currentPage').val());
			}else{//点击页码调用筛选按钮
				getSelectedLineAjax(
						$('#city1').val(),
						$('#city2').val(),
						urladdtion[0],
						urladdtion[2],
						urladdtion[1],
						$('#display').val(),
						$('#currentPage').val());
				//总条数
			    getSelectedLineTotalRowsAjax(
			    		$('#city1').val(),
			    		$('#city2').val(),
			    		urladdtion[0],
						urladdtion[2],
						urladdtion[1],
						$('#display').val(),
						$('#currentPage').val());
			    
			    //flag重置为0
			    $('#flag').val(0);
			}
			
		}
		//配送网络筛选
		if(page_info=='配送网络'){
			if($('#flag').val() == '0'){//直接点击筛选
				$('#currentPage').val(1);
				getSelectedLineAjax(
						$('#city1').val(),
						urladdtion[0],
						urladdtion[1],
						$('#display').val(),
						$('#currentPage').val());
				//总条数
				getSelectedCityLineTotalRowsAjax(
			    		$('#city1').val(),
						urladdtion[0],
						urladdtion[1],
						$('#display').val(),
						$('#currentPage').val());
			}else{//点击页码
				getSelectedLineAjax(
						$('#city1').val(),
						urladdtion[0],
						urladdtion[1],
						$('#display').val(),
						$('#currentPage').val());
				//总条数
				getSelectedCityLineTotalRowsAjax(
			    		$('#city1').val(),
						urladdtion[0],
						urladdtion[1],
						$('#display').val(),
						$('#currentPage').val());
			    //flag重置为0
			    $('#flag').val(0);
			}
			
		}
		if(page_info=='车辆'){
			//车辆筛选
			//alert("carlength+"+urladdtion[1]);
			if($('#flag').val() == '0'){//直接点击筛选
				
				$('#currentPage').val(1);
				getSelectedCarAjax(
						$('#city1').val(),
						$('#city2').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						$('#display').val(),
						$('#currentPage').val());
				
				getSelectedCarTotalRows(
						$('#city1').val(),
						$('#city2').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						$('#display').val(),
						$('#currentPage').val()
				);
			}else{
				getSelectedCarAjax(
						$('#city1').val(),
						$('#city2').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						$('#display').val(),
						$('#currentPage').val());
				
				getSelectedCarTotalRows(
						$('#city1').val(),
						$('#city2').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						$('#display').val(),
						$('#currentPage').val()
				);
				
				//flag重置为0
			    $('#flag').val(0);
			}
			
		}
		if(page_info=='仓库'){
			if($('#flag').val() == '0'){//直接点击筛选
				
				$('#currentPage').val(1);
				getSelectedWarehouseAjax(
						$('#city1').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						$('#display').val(),
						$('#currentPage').val());
				getSelectedWarehouseTotalRows(
						$('#city1').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						$('#display').val(),
						$('#currentPage').val());
			}else{//点击页码
				getSelectedWarehouseAjax(
						$('#city1').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						$('#display').val(),
						$('#currentPage').val());
				getSelectedWarehouseTotalRows(
						$('#city1').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						$('#display').val(),
						$('#currentPage').val());
				
				//flag重置为0
			    $('#flag').val(0);
			}
			
		}
		if(page_info=='公司'){
			if($('#flag').val() == '0'){//直接点击筛选
				
				$('#currentPage').val(1);
				
				getSelectedCompanyAjax(
						$('#city1').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						urladdtion[3],
						$('#display').val(),
						$('#currentPage').val());
				getSelectedCompanyTotalRowsAjax(
						$('#city1').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						urladdtion[3],
						$('#display').val(),
						$('#currentPage').val());
			}else{//点击页码
				getSelectedCompanyAjax(
						$('#city1').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						urladdtion[3],
						$('#display').val(),
						$('#currentPage').val());
				getSelectedCompanyTotalRowsAjax(
						$('#city1').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						urladdtion[3],
						$('#display').val(),
						$('#currentPage').val());
				
				//flag重置为0
			    $('#flag').val(0);
			}
		}
		if(page_info=='货物'){
			if($('#flag').val() == '0'){//直接点击筛选
				
				$('#currentPage').val(1);
				
				getSelectedCargoAjax(
						$('#city1').val(),
						$('#city2').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						$('#display').val(),
						$('#currentPage').val());
				getSelectedCargoTotalRows(
						$('#city1').val(),
						$('#city2').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						$('#display').val(),
						$('#currentPage').val());
			}else{//点击页码
				getSelectedCargoAjax(
						$('#city1').val(),
						$('#city2').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						$('#display').val(),
						$('#currentPage').val());
				getSelectedCargoTotalRows(
						$('#city1').val(),
						$('#city2').val(),
						urladdtion[0],
						urladdtion[1],
						urladdtion[2],
						$('#display').val(),
						$('#currentPage').val());
				
				//flag重置为0
			    $('#flag').val(0);
			}
		}
	    
	});
	

	$("#selectA").live("click", function () {
		$(this).remove();
		urladdtion[0] = "";
		$("#select1 .resource_all").addClass("").siblings().removeClass("selected");
	});
	
	$("#selectB").live("click", function () {
		$(this).remove();
		urladdtion[1] = "";
		$("#select2 .resource_all").addClass("selected").siblings().removeClass("selected");
	});
	
	$("#selectC").live("click", function () {
		$(this).remove();
		urladdtion[2] = "";
		$("#select3 .resource_all").addClass("selected").siblings().removeClass("selected");
	});
	
	$("#selectD").live("click", function () {
		$(this).remove();
		$("#select4 .resource_all").addClass("selected").siblings().removeClass("selected");
	});
	
	$("#selectE").live("click", function () {
		$(this).remove();
		$("#select5 .resource_all").addClass("selected").siblings().removeClass("selected");
	});

	$(".resource dd").live("click", function () {
		if ($(".resource_result dd").length > 1) {
			$(".resource_no").hide();
		} else {
			$(".resource_no").show();
		}
	});
});

//////////////////////////////////搜索功能////////////////////////////////////////
/**
 * 上方资源搜索功能相关
 */
//搜索种类
function searchKind(){
	
	var resource_kind=$("#resource_choose").val();
//	alert(resource_kind);
	var search_content=$("#search_content").val();
//	alert(search_content);
	var container=$("#thead");
	container.empty();//清空
	container.append("<tr>");
	//alert(window.location.pathname);
	if(resource_kind == '线路'){
		//debugger;
		window.location.href="linetransport?flag=0&resource_kind="+resource_kind+"&search_content="+search_content;
		container.append("<td width=\"15\" class=\"td_main_list_head\"></td><td class=\"td_main_list_head\">线路名称</td><td width=\"100\" class=\"td_main_list_head\">参考价(元/kg)</td><td width=\"60\" class=\"td_main_list_head\">类型</td><td width=\"80\" class=\"td_main_list_head\">时限(小时)</td><td width=\"80\" class=\"td_main_list_head\">发布日期</td><td width=\"45\" class=\"td_main_list_head\">关注</td>");
		searchFunc_linetransport(search_content,resource_kind,10,1);
	}else if(resource_kind == '配送'){
		container.append("<td width=\"15\" class=\"td_main_list_head\"></td><td class=\"td_main_list_head\">网络名称</td><td class=\"td_main_list_head\" width=\"100\">参考价(元/kg)</td><td class=\"td_main_list_head\" width=\"80\">增值服务</td><td class=\"td_main_list_head\" width=\"80\">信用等级</td><td class=\"td_main_list_head\" width=\"80\">发布日期</td><td class=\"td_main_list_head\" width=\"45\">关注</td>");
		searchFunc_city(search_content,resource_kind,10,1);
	}else if(resource_kind == '车辆'){
		container.append("<td width=\"15\" class=\"td_main_list_head\"></td><td class=\"td_main_list_head\">牌照号码</td><td class=\"td_main_list_head\" width=\"80\">用途</td><td class=\"td_main_list_head\" width=\"70\">状态</td><td class=\"td_main_list_head\" width=\"70\">车长(米)</td><td class=\"td_main_list_head\" width=\"70\">载重(吨)</td><td class=\"td_main_list_head\" width=\"100\">当前位置</td><td class=\"td_main_list_head\" width=\"80\">定位日期</td><td class=\"td_main_list_head\" width=\"45\">关注</td>");
		searchFunc_car(search_content,resource_kind,10,1);
	}else if(resource_kind == '仓库'){
		container.append("<td width=\"15\" class=\"td_main_list_head\"></td><td class=\"td_main_list_head\">仓库名称</td><td class=\"td_main_list_head\" width=\"70\">消防等级</td>	<td class=\"td_main_list_head\" width=\"80\">类型</td><td class=\"td_main_list_head\" width=\"100\">面积(平方米)</td><td class=\"td_main_list_head\" width=\"80\">发布日期</td>	<td class=\"td_main_list_head\" width=\"45\">关注</td>");
		searchFunc_warehouse(search_content,resource_kind,10,1);
	}else if(resource_kind == '公司'){
		container.append("<td width=\"15\" class=\"td_main_list_head\"></td><td class=\"td_main_list_head\">公司名称</td><td class=\"td_main_list_head\" width=\"70\">资源级别</td><td class=\"td_main_list_head\" width=\"70\">公司性质</td><td class=\"td_main_list_head\" width=\"70\">信用等级</td><td class=\"td_main_list_head\" width=\"80\">发布日期</td><td class=\"td_main_list_head\" width=\"45\">关注</td>");
		searchFunc_company(search_content,resource_kind,10,1);
	}else if(resource_kind == '货物'){
		container.append("<td width=\"15\" class=\"td_main_list_head\"></td><td class=\"td_main_list_head\">货物名称</td><td class=\"td_main_list_head\" width=\"70\">运输类型</td><td class=\"td_main_list_head\" width=\"100\">有效期至</td><td class=\"td_main_list_head\" width=\"80\">重量(吨)</td><td class=\"td_main_list_head\" width=\"110\">发布日期</td><td class=\"td_main_list_head\" width=\"45\">关注</td>");
		searchFunc_cargo(search_content,resource_kind,10,1);
	}
	container.append("</tr>");
	
		
}
//搜索资源功能-干线
function searchFunc_linetransport(search_content,resource_kind,display,currentPage){
		//alert("clisk");
	var url="searchResourceAjax";
	$.ajax({url:url,
			type:"get",
			cache:false,
			data:{"resource_kind":resource_kind,
		"search_content":search_content,
		"display":display,
		"currentPage":currentPage},
		dataType:"json",
		success:function(data,status){
				$("#testbody").empty();//清空结果集
				for(var i=0;i<data.length;i++){
				$("#testbody").append("<tr>");
				$("#testbody").append("<td class=\"td_main_list_content\"></td>");
				$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"linetransportdetail?linetransportid="+data[i].id+"&carrierId="+data[i].carrierId+"&linetransportId="+data[i].carrierid+"&flag=0\" hidefocus=\"true\">"+data[i].startPlace+"→"+data[i].endPlace+"</a><br /><a style=\"color:#717071;\" href=\"companyDetail?id="+data[i].carrierId+"\" hidefocus=\"true\">"+data[i].companyName+"<img src=\"images/btn_level1a.png\" /></a></td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].refPrice+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].transportType+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].onWayTime+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+renderTime(data[i].relDate)+"</td>");
				if(data[i].status == "有效")
					$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1b\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>");
				else
					$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1a\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>");
				/* $("#testbody").append("</td>"); */
				$("#testbody").append("</tr>");
			}
		}
		});
}

//搜索资源功能-城市配送
function searchFunc_city(search_content,resource_kind,display,currentPage){
		//alert("clisk");
	var url="searchResourceAjax";
	$.ajax({url:url,
			type:"get",
			cache:false,
			data:{"resource_kind":resource_kind,
		"search_content":search_content,
		"display":display,
		"currentPage":currentPage},
		dataType:"json",
		success:function(data,status){
			$("#testbody").empty();//清空结果集
			for(var i=0;i<data.length;i++){
				$("#testbody").append("<tr>");
				$("#testbody").append("<td class=\"td_main_list_content\"></td>");
				$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"citylinedetail?citylineId="+data[i].id+"&carrierId="+data[i].carrierId+"&flag=0\" hidefocus=\"true\">"+data[i].name+"</a> <br /> <a href=\"companyDetail?id="+data[i].carrierId+"\" style=\"color:#717071;\"  hidefocus=\"true\"> "+data[i].companyName+" <img src=\"images/btn_level1a.png\" /></a></td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].refPrice+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].vIPService+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].creditRate+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+renderTime(data[i].relDate)+"</td>");
				if(data[i].status == "有效")
					$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1b\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>");
				else
					$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1a\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>");
				$("#testbody").append("</tr>");
			}
		}
	});
}

//搜索资源功能-车辆
function searchFunc_car(search_content,resource_kind,display,currentPage){
		//alert("clisk");
//	debugger;
	var url="searchResourceAjax";
	$.ajax({url:url,
			type:"get",
			cache:false,
			data:{"resource_kind":resource_kind,
		"search_content":search_content,
		"display":display,
		"currentPage":currentPage},
		dataType:"json",
		success:	function(data,status){
			$("#testbody").empty();//清空结果集
			for(var i=0;i<data.length;i++){
				$("#testbody").append("<tr>");
				$("#testbody").append("<td class=\"td_main_list_content\"></td>");
				$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"cardetail?carId="+data[i].id+"&carrierId="+data[i].carrierId+"&linetransportId=$"+data[i].linetransportId+"&flag=0\" hidefocus=\"true\">"+data[i].carNum+"</a><br /> <a href=\"companyDetail?id="+data[i].carrierId+" style=\"color:#717071;\" hidefocus=\"true\">"+data[i].companyName+"<img src=\"images/btn_level1a.png\" /></a></td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].carBase+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].carState+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].carLength+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].carWeight+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].carLocation+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+renderTime(data[i].relDate)+"</td>");
				if(data[i].status == "有效")
					$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1b\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>");
				else
					$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1a\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>");
				$("#testbody").append("</tr>");
			}
		}
	});
}

//搜索资源功能-仓库
function searchFunc_warehouse(search_content,resource_kind,display,currentPage){
		//alert("clisk");
	var url="searchResourceAjax";
	$.ajax({url:url,
			type:"get",
			cache:false,
			data:{"resource_kind":resource_kind,
		"search_content":search_content,
		"display":display,
		"currentPage":currentPage},
		dataType:"json",
		success:	function(data,status){
			$("#testbody").empty();//清空结果集
			for(var i=0;i<data.length;i++){
				$("#testbody").append("<tr>");
				$("#testbody").append("<td class=\"td_main_list_content\"></td>");
				$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"warehousedetail?warehouseId="+data[i].id+"&carrierId="+data[i].carrierId+"&flag=0\"	hidefocus=\"true\">"+data[i].name+"</a> <br /> <a href=\"companyDetail?id="+data[i].carrierId+" style=\"color:#717071;\" hidefocus=\"true\"> "+data[i].companyName+"<img src=\"images/btn_level1a.png\" /></a></td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].fireRate+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].type+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].houseArea+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+renderTime(data[i].relDate)+"</td>");
				if(data[i].status == "有效")
					$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1b\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>");
				else
					$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1a\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>");
				$("#testbody").append("</tr>");
			}
		}
	});
}

//搜索资源功能-公司
function searchFunc_company(search_content,resource_kind,display,currentPage){
		//alert("clisk");
	var url="searchResourceAjax";
//	debugger;
	$.ajax({url:url,
			type:"get",
			cache:false,
			data:{"resource_kind":resource_kind,
		"search_content":search_content,
		"display":display,
		"currentPage":currentPage},
		dataType:"json",
		success:	function(data,status){
			$("#testbody").empty();//清空结果集
			for(var i=0;i<data.length;i++){
				$("#testbody").append("<tr>");
				$("#testbody").append("<td class=\"td_main_list_content\"></td>");
				$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"companyDetail?id="+data[i].id+" hidefocus=\"true\">"+data[i].companyName+"<img src=\"images/btn_level1a.png\" /></a></td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].resourceRate+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].companyKind+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].creditRate+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+renderTime(data[i].relDate)+"</td>");
				if(data[i].status == "有效")
					$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1b\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>");
				else
					$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1a\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>");
				$("#testbody").append("</tr>");
			}
			}
	});
}

//搜索资源功能-货物
function searchFunc_cargo(search_content,resource_kind,display,currentPage){
		//alert("clisk");
	var url="searchResourceAjax";
	$.ajax({url:url,
			type:"get",
			cache:false,
			data:{"resource_kind":resource_kind,
		"search_content":search_content,
		"display":display,
		"currentPage":currentPage},
		dataType:"json",
		success:	function(data,status){
			$("#testbody").empty();//清空结果集
				for(var i=0;i<data.length;i++){
					$("#testbody").append("<tr>");
					$("#testbody").append("<td class=\"td_main_list_content\"></td>");
					$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"goodsdetail?id="+data[i].id+"\" hidefocus=\"true\">"+data[i].name+"</a>");
					$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].transportType+"</td>");
					$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].limitDate+"</td>");
					$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].weight+"</td>");
					$("#testbody").append("<td class=\"td_main_list_content\">"+renderTime(data[i].relDate)+"</td>");
					if(data[i].status == "有效")
						$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1b\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>");
					else
						$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1a\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>");
					$("#testbody").append("</tr>");
				}
				
			}
	});
}

