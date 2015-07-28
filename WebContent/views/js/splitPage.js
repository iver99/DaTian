//控制页码显示
function pageLayout(totalRows){
	var display=parseInt($('#display').val());
	var currentPage=parseInt($('#currentPage').val());
	var pageNum=Math.ceil(totalRows/display);
	var page_layout=$('#page_layout');//onclick='ChangeTo("+pageNum+")'
	page_layout.append("<tr>");
	page_layout.append("<td width='45' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+1+");' class='a_pagenumber' hidefocus='true'>首页</a></td>");
	var pre=currentPage==1?1:currentPage-1;
	page_layout.append("<td width='45' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+pre+");' class='a_pagenumber' hidefocus='true'>上页</a></td>");
	if(pageNum< 8){
		for(var i=1;i<=pageNum;i++){
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>");
		}
	}
	if(pageNum>=8){
		if(currentPage<=3){
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>");
			page_layout.append("...");
		}
		if(currentPage==4){
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>");
			page_layout.append("...");
		}
		if(currentPage==5){
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>");
			page_layout.append("...");
		}
		if(currentPage>5 && currentPage<=pageNum-3){
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('1');' class='a_pagenumber' hidefocus='true' id='1'>1</a></td>");
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('2');' class='a_pagenumber' hidefocus='true' id='2'>2</a></td>");
			page_layout.append("...");
			for(var j=currentPage-2;j<currentPage+2;j++){
				page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+j+");' class='a_pagenumber' hidefocus='true' id="+j+">"+j+"</a></td>");
			}
			page_layout.append("...");
		}
		if(currentPage==pageNum-3){
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('1');' class='a_pagenumber' hidefocus='true' id='1'>1</a></td>");
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('2');' class='a_pagenumber' hidefocus='true' id='2'>2</a></td>");
			page_layout.append("...");
			for(var i=currentPage-5;i<=currentPage;i++){
				page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>");
			}
		}
		if(currentPage==pageNum-2){
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('1');' class='a_pagenumber' hidefocus='true' id='1'>1</a></td>");
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('2');' class='a_pagenumber' hidefocus='true' id='2'>2</a></td>");
			page_layout.append("...");
			for(var i=currentPage-4;i<=currentPage;i++){
				page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>");
			}
		}
	}
	var lat=currentPage==pageNum?pageNum:currentPage+1;
	//alert(lat);
	page_layout.append("<td width='45' class='td_pagenumber' ><a href='javascript:ChangeTo("+lat+");' class='a_pagenumber' hidefocus='true'>下页</a></td>");
	page_layout.append("<td width='45' class='td_pagenumber' ><a href='javascript:ChangeTo("+pageNum+");' class='a_pagenumber' hidefocus='true'>末页</a></td>");
	page_layout.append("</tr>");
   
	$("#"+currentPage).css("background","#7EBFEF");
}
//页面 跳转(资源栏列表页使用)
function ChangeTo(page){
	var page_layout=$('#page_layout');
	page_layout.empty();
	$('#currentPage').val(page);
	
	var display=$("#display").val();
	var currentPage=$("#currentPage").val();
	//点击页码，标志位置为1
	if($("#is_resource_page").val() == 0){//等于0时此段代码为我的信息各栏使用
		if($("#kind").val() == 'linetransport'){
			getUserLinetransportResource(display,currentPage);
			getUserLinetransportResourceTotalRows(display,currentPage);
		}
		if($("#kind").val() == 'cityline'){
			getUserCitylineResource(display,currentPage);
			getUserCitylineResourceTotalRows(display,currentPage);
		}
		if($("#kind").val() == 'car'){
			getUserCarResource(display,currentPage);
			getUserCarResourceTotalRows(display,currentPage);		
		}
		if($("#kind").val() == 'carTeam'){
			getUserCarTeamResource(display,currentPage);
			getUserCarTeamResourceTotalRows(display,currentPage);
		}
		if($("#kind").val() == 'warehouse'){
			getUserWarehouseResource(display,currentPage);
			getUserWarehouseResourceTotalRows(display,currentPage);
		}
		if($("#kind").val() == 'driver'){
			getUserDriverResource(display,currentPage);
			getUserDriverResourceTotalRows(display,currentPage);
		}
		if($("#kind").val() == 'customer'){
			getUserBusinessClientResourceAjax(display,currentPage);
			getUserBusinessClientTotalRowsAjax(display,currentPage);
		}
		if($("#kind").val() == 'cargo'){
			getUserCargoResourceAjax(display,currentPage);
			getUserCargoResourceTotalRowsAjax(display,currentPage);
		}
		if($("#kind").val() == 'subAccount'){
			var username=$("#username").val();
			getSubAccountList(username,display,currentPage);
			getSubAccountListTotalRows(username,display,currentPage);
		}
		//需求方
		if($("#kind").val() == 'contract_s' || $("#kind").val() == 'contract_r'){
			//搜索信息
			var startDate=$("#startDate").val();
			var endDate=$("#endDate").val();
			var name=$("#name").val();
			//如果没有选择时间，则吧默认的汉字转为时间格式，否则后台接收参数刽报错
			if(startDate == '开始时间'){
				startDate='1970-01-01';
			}
			if(endDate == '结束时间'){
				endDate='1970-01-01';
			}
			getUserContractAjax(display,currentPage,startDate,endDate,name);
			getUserContractTotalRowsAjax(display,currentPage,startDate,endDate,name);
		}
		/*//承运方
		if($("#kind").val() == 'contract_r'){
			
		}*/
		//尚未完成
		if($("#kind").val() == 'focus'){
			
		}
		if($("#kind").val() == 'response'){
			getUserResponseResource(display,currentPage);
			getUserResponseResourceTotalRows(display,currentPage);
		}
		if($("#kind").val() == 'order_send'){
			var orderNum=$("#orderNum").val();
			getUserOrderResource(display,currentPage,orderNum);
			getUserOrderResourceTotalRows(display,currentPage,orderNum);
		}
		if($("#kind").val() == 'order_recieve'){
			var orderNum=$("#orderNum").val();
			getUserOrderResource(display,currentPage,orderNum);
			getUserOrderResourceTotalRows(display,currentPage,orderNum);
		}
		if($("#kind").val() == 'settlement_r' || $("#kind").val() == 'settlement_s'){
			var name=$("#name").val();
			
			getUserSettleSResource(display,currentPage,name);
			getUserSettleSResourceTotalRows(display,currentPage,name);
		}
		if($("#kind").val() == 'complaint'){
			var theme=$("#theme").val();
			getUserComplainResource(display,currentPage,theme);
			getUserComplainResourceTotalRows(display,currentPage,theme);
		}

		

	}else{//资源列表使用
		$('#flag').val(1);
		$('#btn1').click();
	}
}
