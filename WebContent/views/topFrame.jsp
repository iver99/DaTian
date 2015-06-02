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
			<td width="220" class="td_top1b">您好！<%=session.getAttribute("username") %>&nbsp;&nbsp;&nbsp;<a href="logout">退出</a></td>
			<%
				}
				else{
			%>
			<td width="220" class="td_top1b">您好！请&nbsp;<a href="loginForm" hidefocus="true">登录</a>&nbsp;或&nbsp;<a href="registerForm" hidefocus="true">注册</a></td>
			<%
				}
			%>
			<td class="td_top1a"><span class="span_top1a">&nbsp;&nbsp;&nbsp;&nbsp;北京&nbsp;<a href="city.htm" hidefocus="true">[更换]</a></span></td>
			<td class="td_top1a" width="90">
            	<div id="topinfo">
                    <ul class="quickmenu">
                        <li class="menuitem">
                            <div class="menu">
                                <a href="myinfo" class="menuhd" hidefocus="true">我的信息</a> 
                                <div class="menubd">
                                    <div class="menubdpanel">
                                        <a href="sendorderinfo" class="a_top1" hidefocus="true">我的订单</a>
                                        <a href="linetransport?flag=1&Display=10&PageNow=1" class="a_top1" hidefocus="true">我的资源</a>
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
    <form action="searchResource" method="post">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
            <td width="3%" height="110">&nbsp;</td>
            <td width="220" class="td_top2a"><a href="homepage" hidefocus="true"><img src="images/logo.png" /></a></td>
            <td>
                <div class="key">
                    <span class="mkey">线路</span>
                    <ul  class="key_ul" >
                    	<li onclick="document.getElementById('resourcechoose').value='线路'">线路</li>
                    	<li onclick="document.getElementById('resourcechoose').value='配送'">配送</li>
                        <li onclick="document.getElementById('resourcechoose').value='车辆'">车辆</li>
                        <li onclick="document.getElementById('resourcechoose').value='仓库'">仓库</li>
                        <li onclick="document.getElementById('resourcechoose').value='公司'">公司</li>
                        <li onclick="document.getElementById('resourcechoose').value='货物'">货物</li>
                    </ul>
                </div>
                <input type="text" name="searchContent" class="search_input" value="请输入关键字" hidefocus="true" />
                <input type="submit" class="search_btn" value="" hidefocus="true">
              <input type="hidden" id="resourcechoose" name="resourceChoose" value="线路"/><!-- 隐藏字段  --> 
			</td>
            <td width="280" class="td_top2b"><a href="getallfocus" class="a_top2" hidefocus="true" id="focusNum"><img src="images/btn_m1.png" />&nbsp;我的关注</a></td>
            <td width="3%">&nbsp;</td>
		</tr>
	</table>
</form>
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
                                            <em><a href="linetransportselected?startPlace=北京&endPlace=All&type=All&startPlace1=北京始发&refPrice=All&Display=10&PageNow=1" hidefocus="true">北京</a></em>
                                            <em><a href="linetransportselected?startPlace=天津&endPlace=All&type=All&startPlace1=天津始发&refPrice=All&Display=10&PageNow=1" hidefocus="true">天津</a></em>
                                            <em><a href="linetransportselected?startPlace=上海&endPlace=All&type=All&startPlace1=上海始发&refPrice=All&Display=10&PageNow=1" hidefocus="true">上海</a></em>
                                            <em><a href="linetransportselected?startPlace=广州&endPlace=All&type=All&startPlace1=广州始发&refPrice=All&Display=10&PageNow=1" hidefocus="true">广州</a></em>
                                            <em><a href="linetransportselected?startPlace=武汉&endPlace=All&type=All&startPlace1=武汉始发&refPrice=All&Display=10&PageNow=1" hidefocus="true">武汉</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>到达城市</dt>
                                        <dd>
                                            <em><a href="linetransportselected?startPlace=All&endPlace=北京&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" hidefocus="true">北京</a></em>
                                            <em><a href="linetransportselected?startPlace=All&endPlace=天津&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" hidefocus="true">天津</a></em>
                                            <em><a href="linetransportselected?startPlace=All&endPlace=上海&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" hidefocus="true">上海</a></em>
                                            <em><a href="linetransportselected?startPlace=All&endPlace=广州&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" hidefocus="true">广州</a></em>
                                            <em><a href="linetransportselected?startPlace=All&endPlace=武汉&type=All&startPlace1=All&refPrice=All&Display=10&PageNow=1" hidefocus="true">武汉</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>运输类型</dt>
                                        <dd>
                                            <em><a href="linetransportselected?startPlace=All&endPlace=All&type=整车&startPlace1=All&refPrice=All&Display=10&PageNow=1" hidefocus="true">整车</a></em>
                                            <em><a href="linetransportselected?startPlace=All&endPlace=All&type=零担&startPlace1=All&refPrice=All&Display=10&PageNow=1" hidefocus="true">零担</a></em>
                                        </dd>
                                    </dl>
                                </div>
                                <div class='fr'>
                                    <img src="images/illust_1a.png" />
                                    <dl class='fore'>
                                        <dt>推荐</dt>
                                        <dd><a href="javascript:;" hidefocus="true">北京畅通达物流</a></dd>
                                        <dd><a href="javascript:;" hidefocus="true">北京畅通达物流</a></dd>
                                        <dd><a href="javascript:;" hidefocus="true">北京畅通达物流</a></dd>
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
                                            <em><a href="citylineselected?cityName=北京&VIPService=All&refPrice=All&Display=10&PageNow=1" hidefocus="true">北京</a></em>
                                            <em><a href="citylineselected?cityName=上海&VIPService=All&refPrice=All&Display=10&PageNow=1" hidefocus="true">上海</a></em>
                                            <em><a href="citylineselected?cityName=广州&VIPService=All&refPrice=All&Display=10&PageNow=1" hidefocus="true">广州</a></em>
                                            <em><a href="citylineselected?cityName=武汉&VIPService=All&refPrice=All&Display=10&PageNow=1" hidefocus="true">武汉</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>增值服务</dt>
                                        <dd>
                                            <em><a href="citylineselected?cityName=All&VIPService=有增值服务&refPrice=All&Display=10&PageNow=1" hidefocus="true">有</a></em>
                                            <em><a href="citylineselected?cityName=All&VIPService=无增值服务&refPrice=All&Display=10&PageNow=1" hidefocus="true">无</a></em>
                                        </dd>
                                    </dl>
                                </div>
                                <div class='fr'>
                                    <img src="images/illust_1b.png" />
                                    <dl class='fore'>
                                        <dt>推荐</dt>
                                        <dd><a href="javascript:;" hidefocus="true">北京畅通达物流</a></dd>
                                        <dd><a href="javascript:;" hidefocus="true">北京畅通达物流</a></dd>
                                        <dd><a href="javascript:;" hidefocus="true">北京畅通达物流</a></dd>
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
                                            <em><a href="carselected?carLocation=All&endPlace=All&carBase=普通&carLength=All&carWeight=All&Display=10&PageNow=1" hidefocus="true">普通</a></em>
                                            <em><a href="carselected?carLocation=All&endPlace=All&carBase=平板&carLength=All&carWeight=All&Display=10&PageNow=1" hidefocus="true">平板</a></em>
                                            <em><a href="carselected?carLocation=All&endPlace=All&carBase=厢式&carLength=All&carWeight=All&Display=10&PageNow=1" hidefocus="true">集装厢</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>车辆长度</dt>
                                        <dd>
                                            <em><a href="carselected?carLocation=All&endPlace=All&carBase=All&carLength=10米&carWeight=All&Display=10&PageNow=1" hidefocus="true">10米</a></em>
                                            <em><a href="carselected?carLocation=All&endPlace=All&carBase=All&carLength=12米&carWeight=All&Display=10&PageNow=1" hidefocus="true">12米</a></em>
                                            <em><a href="carselected?carLocation=All&endPlace=All&carBase=All&carLength=14米&carWeight=All&Display=10&PageNow=1" hidefocus="true">14米</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>车辆载重</dt>
                                        <dd>
                                            <em><a href="carselected?carLocation=All&endPlace=All&carBase=All&carLength=All&carWeight=8吨&Display=10&PageNow=1" hidefocus="true">8吨</a></em>
                                            <em><a href="carselected?carLocation=All&endPlace=All&carBase=All&carLength=All&carWeight=16吨&Display=10&PageNow=1" hidefocus="true">16吨</a></em>
                                            <em><a href="carselected?carLocation=All&endPlace=All&carBase=All&carLength=All&carWeight=20吨&Display=10&PageNow=1" hidefocus="true">20吨</a></em>
                                        </dd>
                                    </dl>
                                </div>
                                <div class='fr'>
                                    <img src="images/illust_1c.png" />
                                    <dl class='fore'>
                                        <dt>推荐</dt>
                                        <dd><a href="javascript:;" hidefocus="true">北京畅通达物流</a></dd>
                                        <dd><a href="javascript:;" hidefocus="true">北京畅通达物流</a></dd>
                                        <dd><a href="javascript:;" hidefocus="true">北京畅通达物流</a></dd>
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
                                            <em><a href="warehouseselected?city=北京&type=All&storageForm=All&houseArea=All&Display=10&PageNow=1" hidefocus="true">北京</a></em>
                                            <em><a href="warehouseselected?city=天津&type=All&storageForm=All&houseArea=All&Display=10&PageNow=1" hidefocus="true">天津</a></em>
                                            <em><a href="warehouseselected?city=上海&type=All&storageForm=All&houseArea=All&Display=10&PageNow=1" hidefocus="true">上海</a></em>
                                            <em><a href="warehouseselected?city=广州&type=All&storageForm=All&houseArea=All&Display=10&PageNow=1" hidefocus="true">广州</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>仓库类型</dt>
                                        <dd>
                                            <em><a href="warehouseselected?city=All&type=保税仓库&storageForm=All&houseArea=All&Display=10&PageNow=1" hidefocus="true">保税</a></em>
                                            <em><a href="warehouseselected?city=All&type=非保税仓库&storageForm=All&houseArea=All&Display=10&PageNow=1" hidefocus="true">非保税</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>装卸平台</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">有</a></em>
                                            <em><a href="javascript:;" hidefocus="true">无</a></em>
                                        </dd>
                                    </dl>
                                </div>
                                <div class='fr'>
                                    <img src="images/illust_1d.png" />
                                    <dl class='fore'>
                                        <dt>推荐</dt>
                                        <dd><a href="javascript:;" hidefocus="true">北京畅通达物流</a></dd>
                                        <dd><a href="javascript:;" hidefocus="true">北京畅通达物流</a></dd>
                                        <dd><a href="javascript:;" hidefocus="true">北京畅通达物流</a></dd>
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
                                            <em><a href="companyselected?city=All&resourceRate=自有资源&serviceIndustry=All&creditRate=All&business=All&Display=10&PageNow=1" hidefocus="true">自有</a></em>
                                            <em><a href="companyselected?city=All&resourceRate=核心资源&serviceIndustry=All&creditRate=All&business=All&Display=10&PageNow=1" hidefocus="true">核心</a></em>
                                            <em><a href="companyselected?city=All&resourceRate=外围资源&serviceIndustry=All&creditRate=All&business=All&Display=10&PageNow=1" hidefocus="true">外围</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>业务种类</dt>
                                        <dd>
                                            <em><a href="companyselected?city=All&resourceRate=All&serviceIndustry=All&creditRate=All&business=干线运输业务&Display=10&PageNow=1" hidefocus="true">运输线路</a></em>
                                            <em><a href="companyselected?city=All&resourceRate=All&serviceIndustry=All&creditRate=All&business=城市配送业务&Display=10&PageNow=1" hidefocus="true">配送网络</a></em>
                                            <em><a href="companyselected?city=All&resourceRate=All&serviceIndustry=All&creditRate=All&business=仓储业务&Display=10&PageNow=1" hidefocus="true">仓储</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>信用等级</dt>
                                        <dd>
                                            <em><a href="companyselected?city=All&resourceRate=All&serviceIndustry=All&creditRate=1级信用等级&business=All&Display=10&PageNow=1" hidefocus="true">1级</a></em>
                                            <em><a href="companyselected?city=All&resourceRate=All&serviceIndustry=All&creditRate=2级信用等级&business=All&Display=10&PageNow=1" hidefocus="true">2级</a></em>
                                            <em><a href="companyselected?city=All&resourceRate=All&serviceIndustry=All&creditRate=3级信用等级&business=All&Display=10&PageNow=1" hidefocus="true">3级</a></em>
                                        </dd>
                                    </dl>
                                </div>
                                <div class='fr'>
                                    <img src="images/illust_1f.png" />
                                    <dl class='fore'>
                                        <dt>推荐</dt>
                                        <dd><a href="javascript:;" hidefocus="true">北京畅通达物流</a></dd>
                                        <dd><a href="javascript:;" hidefocus="true">北京畅通达物流</a></dd>
                                        <dd><a href="javascript:;" hidefocus="true">北京畅通达物流</a></dd>
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