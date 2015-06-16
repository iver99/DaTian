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
			urladdtion[0] = $(this).text().trim();//点选控件时控件value设置为当前text
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
			urladdtion[1] = $(this).text().trim();
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
			urladdtion[2] = $(this).text().trim();
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
			urladdtion[3] = $(this).text().trim();
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
			urladdtion[4] = $(this).text().trim();
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
		var page_info=$('#page_info').val().trim();
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
				//alert(urladdtion[0]);
				//alert(urladdtion[1]);
				//alert(urladdtion[2]);
				
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