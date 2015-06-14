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
			
		}
		if(page_info=='货物'){
			
		}
		
		
	    
	});
	/*//干线筛选
	function getSelectedLineAjax(){
		//alert("ajax_post");
	      var url="linetransporttest";
		  $.post(url,{
			  startPlace:$('#city1').val(),
			  endPlace:$('#city2').val(),
			  transportType:urladdtion[0],
			  refPrice:urladdtion[2],
			  fromPlace:urladdtion[1],
			  display:$('#display').val(),
			  currentPage:$('#currentPage').val()},
		  function(data,status){
				  //alert(data);
				  $("#testbody").empty();
			for(var i=0; i<data.length; i++) {
				$("#testbody").append("<tr>");
				$("#testbody").append("<td class=\"td_main_list_content\"></td>");
				$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"linetransportdetail?linetransportid="+data[i].id+"&carrierId="+data[i].carrierId+"&linetransportId="+data[i].carrierid+"&flag=0\" hidefocus=\"true\">"+data[i].startPlace+"→"+data[i].endPlace+"</a><br /><a style=\"color:#717071;\" href=\"companyDetail?id="+data[i].carrierId+"\" hidefocus=\"true\">"+data[i].companyName+"<img src=\"images/btn_level1a.png\" /></a></td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].refPrice+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].transportType+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].onWayTime+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].relDate+"</td>");
				$("#testbody").append("<td class=\"td_main_list_content\">");
				$("#testbody").append("</td>");
				$("#testbody").append("</tr>");
			}
		  },"json");
	}
	//获取所有干线筛选的总条数
	function getSelectedLineTotalRowsAjax(){
		var url="getSelectedLineTotalRowsAjax";
		  $.post(url,{
			  startPlace:$('#city1').val(),
			  endPlace:$('#city2').val(),
			  transportType:urladdtion[0],
			  refPrice:urladdtion[2],
			  fromPlace:urladdtion[1],
			  display:$('#display').val(),
			  currentPage:$('#currentPage').val()},
		  function(data,status){
				  //alert(data);
				  $('#div_resource_list_head1').text("共"+data+"条记录");
				  $('#count').val(data);
				  //pageLayout(data);//页面布局
		  },"text");
		
	}
	
	//控制页码显示
	function pageLayout(totalRows){
		var display=$('#display').val();
		var currentPage=$('#currentPage').val();
//		alert(display);
//		alert(totalRows);
		var pageNum=Math.ceil(totalRows/display);
		//alert(pageNum);
		var page_layout=$('#page_layout');
		page_layout.append("<tr>");
		page_layout.append("<td width='45' class='td_pagenumber' onclick='changeTo("+1+")'><a href='javascript:;' class='a_pagenumber' hidefocus='true'>首页</a></td>");
		page_layout.append("<td width='45' class='td_pagenumber' onclick='changeTo("	+currentPage==1?1:currentPage-1+	")'><a href='javascript:;' class='a_pagenumber' hidefocus='true'>上页</a></td>");
		<td width="45" class="td_pagenumber" onclick="ChangeTo('first')"><a href="javascript:;" class="a_pagenumber" hidefocus="true">首页</a></td>
        <td width="45" class="td_pagenumber" onclick="ChangeTo('previous')"><a href="javascript:;" class="a_pagenumber" hidefocus="true">上页</a></td>
		
}*/
	

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