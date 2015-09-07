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

//检查是否需要执行搜索功能
function checkSearch(){
	//debugger;
	var paraStr=window.location.search;
	paraStr=UrlDecode(paraStr);//汉字解析
//	alert("搜索功能...");
	//debugger;
	if(paraStr.indexOf("resource_kind")>0 || paraStr.indexOf("search_content")>0){//参数串中存在搜索信息
		var para=new Array();
		var resource_kind;//存储搜索种类
		var search_content;//存储搜索内容
		para=paraStr.split("&");
		for(var i=0;i<para.length;i++){
			//alert(para[i]);
			if(para[i].indexOf("resource_kind")>=0){//解析搜索类型
				var para_kind=new Array();
				para_kind=para[i].split("=");
				resource_kind=para_kind[1];//第二个值为参数值
			}
			if(para[i].indexOf("search_content")>=0){//解析搜索内容
				var para_content=new Array();
				para_content=para[i].split("=");
				search_content=para_content[1];//第二个值为参数值
			}
		}
		//往上方的搜索框填值用来保存搜索信息
		$("#search_content").val(search_content);
		$("#resource_choose").val(resource_kind);
		if(resource_kind == '线路'){
			$("#choose1").click();
		}else if(resource_kind == '配送'){
			$("#choose2").click();
		}else if(resource_kind == '车辆'){
			$("#choose3").click();
		}else if(resource_kind == '仓库'){
			$("#choose4").click();
		}else if(resource_kind == '公司'){
			$("#choose5").click();
		}else if(resource_kind == '货物'){
			$("#choose6").click();
		}
		//执行搜索
		searchKind();
		return false;//返回false，执行搜索功能,不执行list页面的默认的异步加载资源
	}
	return true;//返回true说明不需要执行搜索，则执行list页面上默认的资源加载
}

//将utf-8转回汉字的代码  
function UrlDecode(zipStr) {
	var uzipStr = "";
	for (var i = 0; i < zipStr.length; i++) {
		var chr = zipStr.charAt(i);
		if (chr == "+") {
			uzipStr += " ";
		} else if (chr == "%") {
			var asc = zipStr.substring(i + 1, i + 3);
			if (parseInt("0x" + asc) > 0x7f) {
				uzipStr += decodeURI("%" + asc.toString()
						+ zipStr.substring(i + 3, i + 9).toString());
				i += 8;
			} else {
				uzipStr += AsciiToString(parseInt("0x" + asc));
				i += 2;
			}
		} else {
			uzipStr += chr;
		}
	}

	return uzipStr;
}