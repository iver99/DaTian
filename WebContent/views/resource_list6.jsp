<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>资源-货物</title>
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
	<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;货物<input type="hidden" id="page_info" value="货物"/>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                   <a href="linetransport?flag=0" class="a_leftnav" hidefocus="true">运输线路</a>
						<a href="cityline?flag=0" class="a_leftnav" hidefocus="true">配送网络</a>
						 <a	href="car?flag=0" class="a_leftnav" hidefocus="true">车辆</a>
						<a href="warehouse?flag=0" class="a_leftnav" hidefocus="true">仓库</a>
						 <a href="company" class="a_leftnav" hidefocus="true">公司</a>
                    <span class="text_leftnav1" style="border-bottom:none;">货物</span>
                </div> 
			</td>
			<td>
            	<div id="div_resource_select">
                    <div id="cityselector" class="div_cityselector1">
                        起止城市：
                        <input id="city1" type="text" text="startPlace" value="" class="input_city1" />
                        &nbsp;&nbsp;至&nbsp;&nbsp;
                        <input id="city2" type="text" text="endPlace" value="" class="input_city1" />
                    </div>
                    <ul class="resource">
                        <li class="resource_list">
                            <dl id="select1" value="transportType">
                                <dt>运输类型：</dt>
                                <dd class="resource_all selected"><a href="javascript:;" hidefocus="true" id="select1_0">全部</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select1_1">整车</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select1_2">零担</a></dd>
                            </dl>
                        </li>
                        <li class="resource_list">
                       
                            <dl id="select2" value="weight">
                                <dt>重量：</dt>
                                <dd class="resource_all selected"><a href="javascript:;" hidefocus="true" id="select2_0">全部</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select2_1">10吨</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select2_2">15吨</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select2_3">20吨</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select2_4">35吨</a></dd>
                            </dl>
                        </li>
                        <li class="resource_list">
                            <dl id="select3" value="transportReq">
                                <dt>车型要求：</dt>
                                <dd class="resource_all selected"><a href="javascript:;" hidefocus="true" id="select3_0">全部</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select3_1">高栏货车</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select3_2">厢式货车</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select3_3">平板货车</a></dd>
                            </dl>
                        </li>
                        <li class="resource_result">
                            <dl>
                                <dt>已选条件：</dt>
                                <dd class="resource_no">暂无内容</dd>
                            </dl>
                        </li>
                        <li>
                            <input type="button" id="btn2" value="重置" class="btn_resource_search2" hidefocus="true" onclick="Reset()"/>
                        	<input type="button" id="btn1" value="筛选" class="btn_resource_search1" hidefocus="true" />
                        </li>
                    </ul>
				</div>
                <div id="div_resource_list_head">
                    <div id="div_resource_list_head1"><!-- 共  条记录 --></div>
						<input id="count" value="" type="text"/>
						<input id="display" value="10" type="text"/>
						<input id="currentPage" value="1" type="text"/>
						<input id="flag" value=0 type="text"/><!-- 点击页码和点击筛选标识位 -->
						
                    <div id="middlesort">
                        <ul class="quickmenu">
                          <li class="menuitem">
                              <div class="menu">
                                  <a href="javascript:;" class="menuhd" hidefocus="true">类型</a> 
                                  <div class="menubd">
                                      <div class="menubdpanel">
                                          <a href="javascript:;" class="a_top2a" hidefocus="true" id="trigger1a">升序</a>
                                          <a href="javascript:;" class="a_top2b" hidefocus="true" id="trigger1b">降序</a>
                                      </div>
                                  </div>
                              </div>
                          </li>
                          <li class="menuitem">
                              <div class="menu">
                                  <a href="javascript:;" class="menuhd" hidefocus="true">重量</a> 
                                  <div class="menubd">
                                      <div class="menubdpanel">
                                          <a href="javascript:;" class="a_top2a" hidefocus="true" id="trigger2a">升序</a>
                                          <a href="javascript:;" class="a_top2b" hidefocus="true" id="trigger2b">降序</a>
                                      </div>
                                  </div>
                              </div>
                          </li>
                          <li class="menuitem">
                              <div class="menu">
                                  <a href="javascript:;" class="menuhd" hidefocus="true">关注</a> 
                                  <div class="menubd">
                                      <div class="menubdpanel">
                                          <a href="javascript:;" class="a_top2a" hidefocus="true" id="trigger3a">升序</a>
                                          <a href="javascript:;" class="a_top2b" hidefocus="true" id="trigger3b">降序</a>
                                      </div>
                                  </div>
                              </div>
                          </li>
                        </ul>
                    </div>

                </div> 
                <table border="0" cellspacing="0" cellpadding="0" class="table_main_list" id="list">
                    <thead>
                        <tr>
                            <td width="15" class="td_main_list_head"></td>
                            <td class="td_main_list_head">货物名称</td>
                            <td class="td_main_list_head" width="70">运输类型</td>
                            <td class="td_main_list_head" width="100">有效期至</td>
                            <td class="td_main_list_head" width="80">重量(吨)</td>
                            <td class="td_main_list_head" width="110">发布日期</td>
                            <td class="td_main_list_head" width="45">关注</td>
                        </tr>
                    </thead>
                    <tbody id="testbody">
                     <%--  <c:forEach var="goodsformInfo" items="${goodsformInfo }">
								  
                       <tr>
                            <td class="td_main_list_content"></td>
                            <td class="td_main_list_content">
                                <a href="goodsdetail?id=${goodsformInfo.id }" hidefocus="true">${goodsformInfo.name }</a>
                            </td>
                            <td class="td_main_list_content">${goodsformInfo.transportType }</td>
                           <td class="td_main_list_content">${goodsformInfo.realName }</td>
                            <td class="td_main_list_content">${goodsformInfo.weight }</td>
                            <td class="td_main_list_content">${goodsformInfo.relDate }</td>
                           <input type="button" value="0" style="display:none" id="i"></input>
							<td class="td_main_list_content">
								<script>
									document.getElementById("i").value=0;
								</script>
								<c:forEach var="focus" items="${focusList }">
								<c:if test="${goodsformInfo.id==focus.focusId}">
									<script>
										document.getElementById("i").value=1;
									</script>
								</c:if>
								</c:forEach>
								<script type="text/javascript">
									if(document.getElementById("i").value==1)
										document.write( "<a href=\"javascript:;\" class=\"a_main_list_handle_icon1b\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('${goodsformInfo.id }')\"></a>" );
									else
										document.write( "<a href=\"javascript:;\" class=\"a_main_list_handle_icon1a\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('${goodsformInfo.id }')\"></a>" );
								</script>
							</td>
                       </tr> 
                       </c:forEach> --%>
                    </tbody>
                </table>
				<table border="0" cellpadding="0" cellspacing="0" class="table_recordnumber">
                    <tr>
	                    <td>
                            每页
                            <select id="Display">
                                <option value="5" selected="selected">5</option>
                                <option value="20">20</option>
                                <option value="50">50</option>
                            </select>
                            条记录
                        </td>
                    </tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" class="table_pagenumber" id="page_layout" value="1">
                  <!--   页码显示区 -->
				</table>
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
            	<textarea class="textarea_popup1" placeholder="请输入内容..."></textarea>
            </td>
        </tr>
        <tr>
            <td class="td_popup1">
                <input type="button" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" /><input type="button" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" />
            </td>
        </tr>
    </table>
</div>

<div id="footer_frame">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="views/footer.jsp"></iframe>
</div>

</body>

<script type="text/javascript">
	function OnLoad(){
		//Rescreen();
		loadFocus();
		//页面一加载进行默认的筛选
		//debugger;
		//alert("test");
		getSelectedCargoAjax("中文或拼音","中文或拼音","All","All","All");
		getSelectedCargoTotalRows("中文或拼音","中文或拼音","All","All","All");
    }
	function Reset()
	{
		document.getElementById("select1_0").click();
		document.getElementById("city1").value = "中文或拼音";
		document.getElementById("city2").value = "中文或拼音";
	}
</script>

<script type="text/javascript">
function loadXMLDoc(id)
{
	var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
	$.ajax({
		   type: "GET",
		   url: curWwwPath.substring(0,pos) + "/DaTian/focus",//请求的后台地址
		   data: "type=goods&id=" + id,//前台传给后台的参数
		   success: function(msg){//msg:返回值
			   if(msg == "login"){
				   location.assign(curWwwPath.substring(0,pos) + "/DaTian/loginForm");
			   }
			   loadFocus();
		   }
		});
}

//货物筛选
function getSelectedCargoAjax(startPlace,endPlace,transportType,weight,transportReq,display,currentPage){
	//alert("ajax_post");
      var url="getSelectedCargoAjax";
	  $.post(url,{
		  startPlace:startPlace,
		  endPlace:endPlace,
		  weight:weight,
		  transportType:transportType,
		  transportReq:transportReq,
		  display:display,
		  currentPage:currentPage},
	  function(data,status){
			  //alert(data);
			  $("#testbody").empty();
		for(var i=0; i<data.length; i++) {
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
	  },"json");
}

function renderTime(date){ 
	var da = new Date(parseInt(date)); 
	return da.getFullYear()+"-"+ (da.getMonth()+1)+"-" +da.getDate(); 
} 

//获取筛选货物记录总条数
function getSelectedCargoTotalRows(startPlace,endPlace,transportType,weight,transportReq,display,currentPage){
	var url="getSelectedCargoTotalRowsAjax";
	  $.post(url,{
		  startPlace:startPlace,
		  endPlace:endPlace,
		  weight:weight,
		  transportType:transportType,
		  transportReq:transportReq,
		  display:display,
		  currentPage:currentPage},
	  function(data,status){
			  //返回总记录数
			  $('#div_resource_list_head1').text("共"+data+"条记录");
			  $('#count').val(data);
			  pageLayout(data);//页面布局
	  },"text");
	
}

//控制页码显示
function pageLayout(totalRows){
	var display=parseInt($('#display').val());
	var currentPage=parseInt($('#currentPage').val());
	var pageNum=Math.ceil(totalRows/display);
	//alert(pageNum);
	var page_layout=$('#page_layout');//onclick='ChangeTo("+pageNum+")'
	page_layout.append("<tr>");
	page_layout.append("<td width='45' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+1+");' class='a_pagenumber' hidefocus='true'>首页</a></td>");
	var pre=currentPage==1?1:currentPage-1;
	page_layout.append("<td width='45' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+pre+");' class='a_pagenumber' hidefocus='true'>上页</a></td>");
	if(pageNum< 8){
		for(var i=1;i<=pageNum;i++){
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true'>"+i+"</a></td>");
		}
	}
	if(pageNum>=8){
		if(currentPage<=3){
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true'>"+i+"</a></td>");
			page_layout.append("...");
		}
		if(currentPage==4){
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true'>"+i+"</a></td>");
			page_layout.append("...")
		}
		if(currentPage==5){
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true'>"+i+"</a></td>");
			page_layout.append("...");
		}
		if(currentPage>5 && currentPage<=pageNum-3){
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('1');' class='a_pagenumber' hidefocus='true'>1</a></td>");
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('2');' class='a_pagenumber' hidefocus='true'>2</a></td>");
			page_layout.append("...");
			for(var j=currentPage-2;j<currentPage+2;j++){
				page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+j+");' class='a_pagenumber' hidefocus='true'>"+j+"</a></td>");
			}
			page_layout.append("...");
		}
		if(currentPage==pageNum-3){
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('1');' class='a_pagenumber' hidefocus='true'>1</a></td>");
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('2');' class='a_pagenumber' hidefocus='true'>2</a></td>");
			page_layout.append("...");
			for(var i=currentPage-5;i<=currentPage;i++){
				page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true'>"+i+"</a></td>");
			}
		}
		if(currentPage==pageNum-2){
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('1');' class='a_pagenumber' hidefocus='true'>1</a></td>");
			page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('2');' class='a_pagenumber' hidefocus='true'>2</a></td>");
			page_layout.append("...");
			for(var i=currentPage-4;i<=currentPage;i++){
				page_layout.append("<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true'>"+i+"</a></td>");
			}
		}
	}
	var lat=currentPage==pageNum?pageNum:currentPage+1;
	//alert(lat);
	page_layout.append("<td width='45' class='td_pagenumber' ><a href='javascript:ChangeTo("+lat+");' class='a_pagenumber' hidefocus='true'>下页</a></td>");
	page_layout.append("<td width='45' class='td_pagenumber' ><a href='javascript:ChangeTo("+pageNum+");' class='a_pagenumber' hidefocus='true'>末页</a></td>");
	page_layout.append("</tr>");
   
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
</script>
</html>