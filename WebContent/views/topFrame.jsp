<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="top_frame">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="3%" class="td_top1a">&nbsp;</td>
			<%
				if(session.getAttribute("username")!=null)
				{
			%>
			<td width="220" class="td_top1b" id="loginStatus">您好！<%=session.getAttribute("username") %>&nbsp;&nbsp;&nbsp;<a href="logout">退出</a></td>
			<%
				}
				else{
			%>
			<td width="220" class="td_top1b" id="loginStatus">您好！请&nbsp;<a href="loginForm" hidefocus="true">登录</a>&nbsp;或&nbsp;<a href="registerForm" hidefocus="true">注册</a></td>
			<%
				}
			%>
			<td class="td_top1a"><!-- <span class="span_top1a" id="city">&nbsp;&nbsp;&nbsp;&nbsp;北京&nbsp;<a href="city" hidefocus="true">[更换]</a></span> --></td>
			<td class="td_top1a" width="90">
            	<div id="topinfo">
                    <ul class="quickmenu">
                        <li class="menuitem">
                            <div class="menu">
                                <a href="myinfo" class="menuhd" hidefocus="true">我的信息</a> 
                                <div class="menubd">
                                    <div class="menubdpanel">
                                        <a href="turnToOrderPage" class="a_top1" hidefocus="true">我的订单</a>
                                        <a href="turnToResourcePage" class="a_top1" hidefocus="true">我的资源</a>
                                        <a href="accountinfo" class="a_top1" hidefocus="true">帐户信息</a>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </td>
			<td width="3%" class="td_top1a"><a href="allcomplaint" hidefocus="true"><img src="images/btn_config1.png" /></a></td>
		</tr>
	</table>
   <!--  <form action="searchResourceAjax" method="post" > -->
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
            <td width="3%" height="110">&nbsp;</td>
            <td width="220" class="td_top2a"><a href="homepage" hidefocus="true"><img src="images/logo.png" /></a></td>
            <td>
                <div class="key">
                    <span class="mkey">线路</span>
                    <ul  class="key_ul" >
                    	<li onclick="$('#resource_choose').val('线路')">线路</li>
                    	<li onclick="$('#resource_choose').val('配送')">配送</li>
                        <li onclick="$('#resource_choose').val('车辆')">车辆</li>
                        <li onclick="$('#resource_choose').val('仓库')">仓库</li>
                        <li onclick="$('#resource_choose').val('公司')">公司</li>
                        <li onclick="$('#resource_choose').val('货物')">货物</li>
                    </ul>
                </div>
                <input type="text" name="search_content"  id="search_content" class="search_input" value="请输入关键字" hidefocus="true"  />
                <input type="button" class="search_btn" value="" hidefocus="true" onclick="changeToSearchPage()">
              <input type="hidden" id="resource_choose" name="resource_choose" value="线路"/><!-- 隐藏字段  --> 
			</td>
            <td width="280" class="td_top2b"><a href="getallfocus" class="a_top2" hidefocus="true" id="focusNum"><img src="images/btn_m1.png" />&nbsp;我的关注</a></td>
            <td width="3%">&nbsp;</td>
		</tr>
	</table>
<!-- </form> -->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_mainnav">
		<tr>
            <td width="3%">&nbsp;</td>
            <td width="222">
                <div class='allsort'>
                    <div class='mt'>
                        <a href="javascript:;" hidefocus="true"><strong>资源分类</strong></a>
                        <div class='extra'>&nbsp;</div>
                    </div>
                    <div class='mc'>
                        <div class='item fore'>
                            <span><h3><a href="linetransport?flag=0" hidefocus="true">运输线路</a></h3><s></s></span>
                            <div class='i-mc'>
                                <div class='close' onclick="$(this).parent().parent().removeClass('hover')"></div>
                                <div class='subitem'>
                                    <dl class='fore'>
                                        <dt>始发城市</dt>
                                        <dd>
                                            <em><a href="linetransport?flag=0&city1=北京&city2=全国" hidefocus="true">北京</a></em>
                                            <em><a href="linetransport?flag=0&city1=天津&city2=全国" hidefocus="true">天津</a></em>
                                            <em><a href="linetransport?flag=0&city1=上海&city2=全国" hidefocus="true">上海</a></em>
                                            <em><a href="linetransport?flag=0&city1=广州&city2=全国" hidefocus="true">广州</a></em>
                                            <em><a href="linetransport?flag=0&city1=武汉&city2=全国" hidefocus="true">武汉</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>到达城市</dt>
                                        <dd>
                                            <em><a href="linetransport?flag=0&city1=全国&city2=北京" hidefocus="true">北京</a></em>
                                            <em><a href="linetransport?flag=0&city1=全国&city2=天津" hidefocus="true">天津</a></em>
                                            <em><a href="linetransport?flag=0&city1=全国&city2=上海" hidefocus="true">上海</a></em>
                                            <em><a href="linetransport?flag=0&city1=全国&city2=广州" hidefocus="true">广州</a></em>
                                            <em><a href="linetransport?flag=0&city1=全国&city2=武汉" hidefocus="true">武汉</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>运输类型</dt>
                                        <dd>
                                            <em><a href="linetransport?flag=0&type=整车" hidefocus="true">整车</a></em>
                                            <em><a href="linetransport?flag=0&type=零担" hidefocus="true">零担</a></em>
                                        </dd>
                                    </dl>
                                </div>
                                <div class='fr'>
                                    <img src="images/illust_1a.png" />
                                    <dl class='fore'>
                                        <!-- <dt>推荐</dt>
                                        <dd><a href="companyDetail?id=C-0001" hidefocus="true">北京市畅通达1</a></dd>
                                        <dd><a href="companyDetail?id=C-0002" hidefocus="true">北京市畅通达</a></dd>
                                        <dd><a href="companyDetail?id=C-0003" hidefocus="true">北京圆通</a></dd> -->
                                    </dl>
                                </div>
                            </div>
                        </div>
                        <div class='item'>
                            <span><h3><a href="cityline?flag=0" hidefocus="true">配送网络</a></h3><s></s></span>
                            <div class='i-mc'>
                                <div class='close' onclick="$(this).parent().parent().removeClass('hover')"></div>
                                <div class='subitem'>
                                    <dl class='fore'>
                                        <dt>配送城市</dt>
                                        <dd>
                                            <em><a href="cityline?flag=0&city1=北京" hidefocus="true">北京</a></em>
                                            <em><a href="cityline?flag=0&city1=上海" hidefocus="true">上海</a></em>
                                            <em><a href="cityline?flag=0&city1=广州" hidefocus="true">广州</a></em>
                                            <em><a href="cityline?flag=0&city1=武汉" hidefocus="true">武汉</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>增值服务</dt>
                                        <dd>
                                            <em><a href="cityline?flag=0&vip_service=有" hidefocus="true">有</a></em>
                                            <em><a href="cityline?flag=0&vip_service=无" hidefocus="true">无</a></em>
                                        </dd>
                                    </dl>
                                </div>
                                <div class='fr'>
                                    <img src="images/illust_1b.png" />
                                    <dl class='fore'>
                                        <!-- <dt>推荐</dt>
                                        <dd><a href="companyDetail?id=C-0001" hidefocus="true">北京市畅通达1</a></dd>
                                        <dd><a href="companyDetail?id=C-0002" hidefocus="true">北京市畅通达</a></dd>
                                        <dd><a href="companyDetail?id=C-0003" hidefocus="true">北京圆通</a></dd> -->
                                    </dl>
                                </div>
                            </div>
                        </div>
                        <div class='item'>
                            <span><h3><a href="car?flag=0" hidefocus="true">车辆</a></h3><s></s></span>
                            <div class='i-mc'>
                                <div class='close' onclick="$(this).parent().parent().removeClass('hover')"></div>
                                <div class='subitem'>
                                    <dl class='fore'>
                                        <dt>车辆厢型</dt>
                                        <dd>
                                            <em><a href="car?flag=0&carBase=普通" hidefocus="true">普通</a></em>
                                            <em><a href="car?flag=0&carBase=平板" hidefocus="true">平板</a></em>
                                            <em><a href="car?flag=0&carBase=集装箱" hidefocus="true">集装厢</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>车辆长度</dt>
                                        <dd>
                                            <em><a href="car?flag=0&carLength=10米" hidefocus="true">10米</a></em>
                                            <em><a href="car?flag=0&carLength=12米" hidefocus="true">12米</a></em>
                                            <em><a href="car?flag=0&carLength=14米" hidefocus="true">14米</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>车辆载重</dt>
                                        <dd>
                                            <em><a href="car?flag=0&carWeight=8吨" hidefocus="true">8吨</a></em>
                                            <em><a href="car?flag=0&carWeight=16吨" hidefocus="true">16吨</a></em>
                                            <em><a href="car?flag=0&carWeight=20吨" hidefocus="true">20吨</a></em>
                                        </dd>
                                    </dl>
                                </div>
                                <div class='fr'>
                                    <img src="images/illust_1c.png" />
                                    <dl class='fore'>
                                        <!-- <dt>推荐</dt>
                                        <dd><a href="companyDetail?id=C-0001" hidefocus="true">北京市畅通达1</a></dd>
                                        <dd><a href="companyDetail?id=C-0002" hidefocus="true">北京市畅通达</a></dd>
                                        <dd><a href="companyDetail?id=C-0003" hidefocus="true">北京圆通</a></dd> -->
                                    </dl>
                                </div>
                            </div>
                        </div>
                        <div class='item'>
                            <span><h3><a href="warehouse?flag=0" hidefocus="true">仓库</a></h3><s></s></span>
                            <div class='i-mc'>
                                <div class='close' onclick="$(this).parent().parent().removeClass('hover')"></div>
                                <div class='subitem'>
                                    <dl class='fore'>
                                        <dt>所在城市</dt>
                                        <dd>
                                            <em><a href="warehouse?flag=0&city1=北京" hidefocus="true">北京</a></em>
                                            <em><a href="warehouse?flag=0&city1=天津" hidefocus="true">天津</a></em>
                                            <em><a href="warehouse?flag=0&city1=上海" hidefocus="true">上海</a></em>
                                            <em><a href="warehouse?flag=0&city1=广州" hidefocus="true">广州</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>仓库类型</dt>
                                        <dd>
                                            <em><a href="warehouse?flag=0&type=保税" hidefocus="true">保税</a></em>
                                            <em><a href="warehouse?flag=0&type=非保税" hidefocus="true">非保税</a></em>
                                        </dd>
                                    </dl>
                                   <!--  <dl>
                                        <dt>装卸平台</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">有</a></em>
                                            <em><a href="javascript:;" hidefocus="true">无</a></em>
                                        </dd>
                                    </dl> -->
                                </div>
                                <div class='fr'>
                                    <img src="images/illust_1d.png" />
                                    <dl class='fore'>
                                        <!-- <dt>推荐</dt>
                                        <dd><a href="companyDetail?id=C-0001" hidefocus="true">北京市畅通达1</a></dd>
                                        <dd><a href="companyDetail?id=C-0002" hidefocus="true">北京市畅通达</a></dd>
                                        <dd><a href="companyDetail?id=C-0003" hidefocus="true">北京圆通</a></dd> -->
                                    </dl>
                                </div>
                            </div>
                        </div>
                        <div class='item'>
                            <span><h3><a href="company" hidefocus="true">公司</a></h3><s></s></span>
                            <div class='i-mc'>
                                <div class='close' onclick="$(this).parent().parent().removeClass('hover')"></div>
                                <div class='subitem'>
                                    <dl class='fore'>
                                        <dt>资源等级</dt>
                                        <dd>
                                            <em><a href="company?flag=0&resource_level=自由">自有</a></em>
                                            <em><a href="company?flag=0&resource_level=核心">核心</a></em>
                                            <em><a href="company?flag=0&resource_level=外围" hidefocus="true">外围</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>业务种类</dt>
                                        <dd>
                                            <em><a href="company?flag=0&business_kind=运输线路" hidefocus="true">运输线路</a></em>
                                            <em><a href="company?flag=0&business_kind=配送网络" hidefocus="true">配送网络</a></em>
                                            <em><a href="company?flag=0&business_kind=仓储" hidefocus="true">仓储</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>信用等级</dt>
                                        <dd>
                                            <em><a href="company?flag=0&credit_rate=1级" hidefocus="true">1级</a></em>
                                            <em><a href="company?flag=0&credit_rate=2级" hidefocus="true">2级</a></em>
                                            <em><a href="company?flag=0&credit_rate=3级" hidefocus="true">3级</a></em>
                                        </dd>
                                    </dl>
                                </div>
                                <div class='fr'>
                                    <img src="images/illust_1f.png" />
                                    <dl class='fore'>
                                        <!-- <dt>推荐</dt>
                                        <dd><a href="companyDetail?id=C-0001" hidefocus="true">北京市畅通达1</a></dd>
                                        <dd><a href="companyDetail?id=C-0002" hidefocus="true">北京市畅通达</a></dd>
                                        <dd><a href="companyDetail?id=C-0003" hidefocus="true">北京圆通</a></dd> -->
                                    </dl>
                                </div>
                            </div>
                        </div>
                        <div class='extra'><a href="goodsform?flag=0" hidefocus="true">货物</a></div>
                    </div>
                </div>
                <script type="text/javascript"> 
                    $(".allsort").hoverForIE6({current:"allsorthover",delay:100});
                    $(".allsort .item").hoverForIE6({delay:50});
                </script>
            </td>
           <td class="td_top2a">
            	<a href="linetransport?flag=0" class="a_mainnav" hidefocus="true">找资源</a>
            </td>
            <td class="td_top2a">&nbsp;</td>
            <td width="3%">&nbsp;</td>
		</tr>
    </table>
</div>
