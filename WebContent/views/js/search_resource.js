/**
 * 上方资源搜索功能相关
 */
//搜索种类
function searchKind(){
	//debugger;
	var resource_kind=$("#resource_choose").val();
	alert(resource_kind);
	var search_content=$("#search_content").val();
	alert(search_content);
	var container=$("#thead");
	container.empty();//清空
	container.append("<tr>");
	
	if(resource_kind == '线路'){
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
		searchFunc_company(search_content,resource_kind10,1);
	}else if(resource_kind == '货物'){
		container.append("<td width=\"15\" class=\"td_main_list_head\"></td><td class=\"td_main_list_head\">货物名称</td><td class=\"td_main_list_head\" width=\"70\">运输类型</td><td class=\"td_main_list_head\" width=\"100\">有效期至</td><td class=\"td_main_list_head\" width=\"80\">重量(吨)</td><td class=\"td_main_list_head\" width=\"110\">发布日期</td><td class=\"td_main_list_head\" width=\"45\">关注</td>");
		searchFunc_cargo(search_content,resource_kind,10,1);
	}
	container.append("</tr>");
	
	//var content_body=$("#testbody");
	//content_body.empty();
	//searchFunc();
		
}
//搜索资源功能-干线
function searchFunc_linetransport(search_content,resource_kind,display,currentPage){
		//alert("clisk");
	var url="searchResourceAjax";
	//var resource_kind=$("#resource_choose").val();
	//alert(resource_kind);
	$.ajax(url,
			{resource_kind:resource_kind,
		search_content:search_content,
		display:display,
		currentPage:currentPage},
			function(data,status){
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
			},
			"json");
}

//搜索资源功能-城市配送
function searchFunc_city(search_content,resource_kind){
		//alert("clisk");
	var url="searchResourceAjax";
	//var resource_kind=$("#resource_choose").val();
	//alert(resource_kind);
	$.ajax(url,
			{resource_kind:resource_kind,
		search_content:search_content,
		display:display,
		currentPage:currentPage},
			function(data,status){
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
			},
			"json");
}

//搜索资源功能-车辆
function searchFunc_car(search_content,resource_kind){
		//alert("clisk");
	var url="searchResourceAjax";
	//var resource_kind=$("#resource_choose").val();
	//alert(resource_kind);
	$.ajax(url,
			{resource_kind:resource_kind,
		search_content:search_content,
		display:display,
		currentPage:currentPage},
			function(data,status){
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
			},
			"json");
}

//搜索资源功能-仓库
function searchFunc_warehouse(search_content,resource_kind){
		//alert("clisk");
	var url="searchResourceAjax";
	//var resource_kind=$("#resource_choose").val();
	//alert(resource_kind);
	$.ajax(url,
			{resource_kind:resource_kind,
		search_content:search_content,
		display:display,
		currentPage:currentPage},
			function(data,status){
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
			},
			"json");
}

//搜索资源功能-公司
function searchFunc_company(search_content,resource_kind){
		//alert("clisk");
	var url="searchResourceAjax";
	//var resource_kind=$("#resource_choose").val();
	//alert(resource_kind);
	$.ajax(url,
			{resource_kind:resource_kind,
		search_content:search_content,
		display:display,
		currentPage:currentPage},
			function(data,status){
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
			},
			"json");
}

//搜索资源功能-货物
function searchFunc_cargo(search_content,resource_kind){
		//alert("clisk");
	var url="searchResourceAjax";
	//var resource_kind=$("#resource_choose").val();
	//alert(resource_kind);
	$.ajax(url,
			{resource_kind:resource_kind,
		search_content:search_content,
		display:display,
		currentPage:currentPage},
			function(data,status){
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
			},
			"json");
}
