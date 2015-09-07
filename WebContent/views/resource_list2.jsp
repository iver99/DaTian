<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>资源-配送网络</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
	<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
	<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
	<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
	<link type="text/css" rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
		<script type="text/javascript" src="js/top_search.js"></script>
		<script type="text/javascript" src="js/main_nav.js"></script>
		<script type="text/javascript" src="js/resource_select.js"></script>
		<script type="text/javascript" src="js/citylist.js"></script>
		<script type="text/javascript" src="js/cityquery.js"></script>
		<script type="text/javascript" src="js/jquery.tablesorter.pack.js"></script>
		<script type="text/javascript" src="js/table_sort.js"></script>
		<script type="text/javascript" src="js/popup.js"></script>
		<script type="text/javascript" src="js/backtop.js"></script>
		<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
		<script type="text/javascript" src="js/splitPage.js"></script><!-- 新增 -->
		<script type="text/javascript" src="js/focus_load.js"></script>
		<!-- <script type="text/javascript" src="js/search_resource.js"></script>搜索资源 -->
		<!-- 引入工具js -->
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
		<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;配送网络<input type="hidden" id="page_info" value="配送网络"/>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="230" class="td_leftnav_top">
					<div id="main_frame_left">
						<a href="linetransport?flag=0" class="a_leftnav" hidefocus="true">运输线路</a>
						<span class="text_leftnav1">配送网络</span> <a
							href="car?flag=0" class="a_leftnav" hidefocus="true">车辆</a>
						<a href="warehouse?flag=0" class="a_leftnav" hidefocus="true">仓库</a>
						<a href="company" class="a_leftnav" hidefocus="true">公司</a> <a
							href="goodsform?flag=0" class="a_leftnav" hidefocus="true"
							style="border-bottom: none;">货物</a>
					</div>
				</td>
				<td>
					<div id="div_resource_select">
						<div id="cityselector" class="div_cityselector1">
							配送城市： <input id="city1" type="text" text="cityName" value=""
								class="input_city1" />
						</div>
						<ul class="resource">
							<li class="resource_list">
								<dl id="select1" value="VIPService">
									<dt>增值服务：</dt>
									<dd class="resource_all selected">
										<a href="javascript:;" hidefocus="true" id="select1_0">全部</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select1_1">有增值服务</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select1_2">无增值服务</a>
									</dd>
								</dl>
							</li>
							<li class="resource_list">
								<dl id="select2" value="refPrice">
									<dt>参考报价：</dt>
									<dd class="resource_all selected">
										<a href="javascript:;" hidefocus="true" id="select2_0">全部</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select2_1">大于2元/kg</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select2_2">1至2元/kg</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select2_3">小于1元/kg</a>
									</dd>
								</dl>
							</li>
							<li class="resource_result">
								<dl>
									<dt>已选条件：</dt>
									<dd class="resource_no">暂无内容</dd>
								</dl>
							</li>
							<li><input type="button" id="btn2" value="重置"
								class="btn_resource_search2" hidefocus="true" onclick="Reset()"/> <input
								type="button" id="btn1" value="筛选" class="btn_resource_search1"
								hidefocus="true" /></li>
						</ul>
					</div>
					<div id="div_resource_list_head">
						<div id="div_resource_list_head1"><!-- 共  条记录 --></div>
						<input id="count" value="" type="hidden"/>
						<input id="display" value="10" type="hidden"/>
						<input id="currentPage" value="1" type="hidden"/>
						<input id="flag" value=0 type="hidden"/><!-- 点击页码和点击筛选标识位 -->
						<!-- <div id="middlesort">
							<ul class="quickmenu">
								<li class="menuitem">
									<div class="menu">
										<a href="javascript:;" class="menuhd" hidefocus="true">价格</a>
										<div class="menubd">
											<div class="menubdpanel">
												<a href="javascript:;" class="a_top2a" hidefocus="true"
													id="trigger1a">升序</a> <a href="javascript:;"
													class="a_top2b" hidefocus="true" id="trigger1b">降序</a>
											</div>
										</div>
									</div>
								</li>
								<li class="menuitem">
									<div class="menu">
										<a href="javascript:;" class="menuhd" hidefocus="true">信用</a>
										<div class="menubd">
											<div class="menubdpanel">
												<a href="javascript:;" class="a_top2a" hidefocus="true"
													id="trigger2a">升序</a> <a href="javascript:;"
													class="a_top2b" hidefocus="true" id="trigger2b">降序</a>
											</div>
										</div>
									</div>
								</li>
								<li class="menuitem">
									<div class="menu">
										<a href="javascript:;" class="menuhd" hidefocus="true">关注</a>
										<div class="menubd">
											<div class="menubdpanel">
												<a href="javascript:;" class="a_top2a" hidefocus="true"
													id="trigger3a">升序</a> <a href="javascript:;"
													class="a_top2b" hidefocus="true" id="trigger3b">降序</a>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</div> -->
					</div>
					<table border="0" cellspacing="0" cellpadding="0"
						class="table_main_list" id="list">
						<thead id="thead">
							<tr>
								<td width="15" class="td_main_list_head"></td>
								<td class="td_main_list_head">网络名称</td>
								<td class="td_main_list_head" width="100">参考价(元/kg)</td>
								<td class="td_main_list_head" width="80">增值服务</td>
								<td class="td_main_list_head" width="80">信用等级</td>
								<td class="td_main_list_head" width="80">发布日期</td>
								<td class="td_main_list_head" width="45">关注</td>
							</tr>
						</thead>
						<tbody id="testbody">
							
						</tbody>

					</table>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table_recordnumber">
						<tr>
							<td>每页 <select id="Display" onchange="changeDisplay()">
									<option value="10" selected="selected">10</option>
									<option value="20">20</option>
									<option value="50">50</option>
							</select> 条记录
							</td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table_pagenumber" id="page_layout" value="1">
					</table>
				</td>
			</tr>
		</table>
	</div>

	<%@ include  file="popup1.jsp"%>

	<div id="footer_frame">
		<iframe allowtransparency="true" width="100%" frameborder="0"
			hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0"
			src="footer.jsp"></iframe>
	</div>

</body>

<script type="text/javascript">
	function OnLoad() {
		//Rescreen();
		loadFocus();
		//GetRequest();
		
		
	
	if (checkSearch()) {//返回true说明不执行上方搜索功能
			if (checkRecommend()) {//返回true说明不是推荐
				var display = $("#display").val();
				var currentPage = $("#currentPage").val();
				getSelectedLineAjax("中文或拼音", "All", "All", display, currentPage);
				getSelectedCityLineTotalRowsAjax("中文或拼音", "All", "All",
						display, currentPage);
			}
		}

	}
	
	//用于上方下拉页的链接
	function checkRecommend(){
		var paraStr=window.location.search;
		paraStr=UrlDecode(paraStr);//汉字解析
		if(paraStr.indexOf("city1")>0 || paraStr.indexOf("vip_service")){//参数串中存在搜索信息
			var para=new Array();
			var city1;//存储搜索种类
			var vip_service//增值服务
			//debugger;
			para=paraStr.split("&");
			for(var i=0;i<para.length;i++){
				//alert(para[i]);
				if(para[i].indexOf("city1")>=0){//解析搜索类型
					var para_kind=new Array();
					para_kind=para[i].split("=");
					city1=para_kind[1];//第二个值为参数值
				}
				if(para[i].indexOf("vip_service")>=0){//解析运输类型
					var para_content=new Array();
					para_content=para[i].split("=");
					vip_service=para_content[1];//第二个值为参数值
				}
			}
			//set value
			$("#city1").val(city1);
			//这里没有设置运输类型的显示效果
			if(vip_service == '有'){
				$("#select1_1").click(); 
			}
			if(vip_service == '无'){
				$("#select1_2").click(); 
			}
			$("#btn1").click();
			return false;
		}
		
		return true;
	}
</script>
<script type="text/javascript">
function Reset()
{
	document.getElementById("select1_0").click();
	document.getElementById("select2_0").click();
	document.getElementById("city1").value = "中文或拼音";
}
function loadXMLDoc(id)
{
	var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
	$.ajax({
		   type: "GET",
		   url: curWwwPath.substring(0,pos) + "/DaTian/focus",//请求的后台地址
		   data: "type=cityline&id=" + id,//前台传给后台的参数
		   cache:false,
		   success: function(msg){//msg:返回值
			   if(msg == "login"){
				   location.assign(curWwwPath.substring(0,pos) + "/DaTian/loginForm");
			   }
			   loadFocus();
		   }
		});
}

//城市配送筛选
function getSelectedLineAjax(cityName,VIPService,refPrice,display,currentPage){
	//alert("ajax_post");
      var url="getCityLineAjax";
	  $.post(url,{
		  cityName:cityName,
		  VIPService:VIPService,
		  refPrice:refPrice,
		  display:display,
		  currentPage:currentPage},
	  function(data,status){
			  //alert(data);
			  $("#testbody").empty();
		for(var i=0; i<data.length; i++) {
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
	  },"json");
}

function renderTime(date){ 
	var da = new Date(parseInt(date)); 
	return da.getFullYear()+"-"+ (da.getMonth()+1)+"-" +da.getDate(); 
} 

//获取所有城市配送筛选的总条数
function getSelectedCityLineTotalRowsAjax(cityName,VIPService,refPrice,display,currentPage){
	var url="getSelectedCityLineTotalRowsAjax";
	  $.post(url,{
		  cityName:cityName,
		  VIPService:VIPService,
		  refPrice:refPrice,
		  display:display,
		  currentPage:currentPage},
	  function(data,status){
			  //返回总记录数
			  $('#div_resource_list_head1').text("共"+data+"条记录");
			  $('#count').val(data);
			  $("#page_layout").empty();
			  pageLayout(data);//页面布局
	  },"text");
	
}

//控制页码显示
function pageLayout(totalRows){
	var display=parseInt($('#display').val());
	var currentPage=parseInt($('#currentPage').val());
	var pageNum=Math.ceil(totalRows/display);
	var page_layout=$('#page_layout');
	var str="<tr>";
	str+="<td width='45' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+1+");' class='a_pagenumber' hidefocus='true'>首页</a></td>";
	var pre=currentPage==1?1:currentPage-1;
	str+="";
	if(pageNum< 8){
		for(var i=1;i<=pageNum;i++){
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>";
		}
	}
	if(pageNum>=8){
		if(currentPage<=3){
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>";
			str+="...";
		}
		if(currentPage==4){
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>";
			str+="...";
		}
		if(currentPage==5){
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>";
			str+="...";
		}
		if(currentPage>5 && currentPage<=pageNum-3){
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('1');' class='a_pagenumber' hidefocus='true' id='1'>1</a></td>";
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('2');' class='a_pagenumber' hidefocus='true' id='2'>2</a></td>";
			str+="...";
			for(var j=currentPage-2;j<currentPage+2;j++){
				str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+j+");' class='a_pagenumber' hidefocus='true' id="+j+">"+j+"</a></td>";
			}
			str+="...";
		}
		if(currentPage==pageNum-3){
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('1');' class='a_pagenumber' hidefocus='true' id='1'>1</a></td>";
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('2');' class='a_pagenumber' hidefocus='true' id='2'>2</a></td>";
			str+="...";
			for(var i=currentPage-5;i<=currentPage;i++){
				str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>";
			}
		}
		if(currentPage==pageNum-2){
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('1');' class='a_pagenumber' hidefocus='true' id='1'>1</a></td>";
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('2');' class='a_pagenumber' hidefocus='true' id='2'>2</a></td>";
			str+="...";
			for(var i=currentPage-4;i<=currentPage;i++){
				str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>";
			}
		}
	}
	var lat=currentPage==pageNum?pageNum:currentPage+1;
	str+="<td width='45' class='td_pagenumber' ><a href='javascript:ChangeTo("+lat+");' class='a_pagenumber' hidefocus='true'>下页</a></td>";
	str+="<td width='45' class='td_pagenumber' ><a href='javascript:ChangeTo("+pageNum+");' class='a_pagenumber' hidefocus='true'>末页</a></td>";
	str+="</tr>";
   
	page_layout.append(str);
	
	$("#"+currentPage).css("background","#7EBFEF");
}
//页面 跳转
function ChangeTo(page){
	//alert("change to "+page);
	var page_layout=$('#page_layout');
	page_layout.empty();
	$('#currentPage').val(page);
	//点击页码，标志位置为1
	$('#flag').val(1);
	$('#btn1').click();
}

//变更每页展示数量
function changeDisplay(){
	//修改隐藏字段，每页数量
	$("#display").val($("#Display").val());
	//当前页归1
	$("#currentPage").val(1);
	//加载数据
	if (checkSearch()) {
		var display = $("#display").val();
		var currentPage = $("#currentPage").val();
		getSelectedLineAjax("中文或拼音", "All", "All", display, currentPage);
		getSelectedCityLineTotalRowsAjax("中文或拼音", "All", "All", display, currentPage);

	}
}
</script>


</html>