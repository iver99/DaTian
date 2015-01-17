<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大田集团供应链资源管理平台-用户登录</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no" />
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css" />
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/backtop.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<script type="text/javascript"> 
	$(function() {
		$('input, textarea').placeholder(); 
	});
</script>
</head>

<body>

<div id="backtop_item">
    <div class="qqserver">
        <div class="qqserver_fold">
            <div></div>
        </div>
        <div class="qqserver-body" style="display:block;">
            <div class="qqserver-header">
                <div>在线客服</div>
                <span class="qqserver_arrow"></span>
            </div>
            <a href="javascript:;" onclick="window.open('http://b.qq.com/webc.htm?new=0&sid=11223344&o=abc.com&q=1', '_blank')" hidefocus="true">咨询提问</a>
            <a href="javascript:;" hidefocus="true">意见建议</a>
            <div class="qqserver_comment" onclick="showid('popup1');" hidefocus="true">
                给我留言
            </div>
            <a href="javascript:;" class="a1" hidefocus="true">查看历史记录</a>
        </div>
    </div>
    <a id="backtop" onclick="return false;" title="回到顶部"></a> 
</div>

<div id="top_frame">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="3%" class="td_top1a">&nbsp;</td>
			<td width="220" class="td_top1b">您好！请&nbsp;<a href="login.htm" hidefocus="true">登录</a>&nbsp;或&nbsp;<a href="register.htm" hidefocus="true">注册</a></td>
			<td class="td_top1a"><span class="span_top1a">&nbsp;&nbsp;&nbsp;&nbsp;北京&nbsp;<a href="city.htm" hidefocus="true">[更换]</a></span></td>
			<td class="td_top1a" width="90">
            	<div id="topinfo">
                    <ul class="quickmenu">
                        <li class="menuitem">
                            <div class="menu">
                                <a href="mgmt.htm" class="menuhd" hidefocus="true">我的信息</a> 
                                <div class="menubd">
                                    <div class="menubdpanel">
                                        <a href="mgmt_d_order_s.htm" class="a_top1" hidefocus="true">我的订单</a>
                                        <a href="mgmt_r_line.htm" class="a_top1" hidefocus="true">我的资源</a>
                                        <a href="mgmt_a_info.htm" class="a_top1" hidefocus="true">帐户信息</a>
                                        <a href="login.htm" class="a_top1" hidefocus="true">安全退出</a>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </td>
			<td width="3%" class="td_top1a">&nbsp;</td>
		</tr>
	</table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
            <td width="3%" height="110">&nbsp;</td>
            <td width="220" class="td_top2a"><a href="index.htm" hidefocus="true"><img src="images/logo.png" /></a></td>
            <td>
                <div class="key">
                    <span class="mkey">线路</span>
                    <ul class="key_ul">
                        <li>货物</li>
                        <li>车辆</li>
                    </ul>
                </div>
                <input type="text" class="search_input" value="请输入关键字" hidefocus="true" />
                <input type="submit" class="search_btn" value="" hidefocus="true">
			</td>
            <td width="280" class="td_top2b"><a href="mgmt_d_focus.htm" class="a_top2" hidefocus="true"><img src="images/btn_m1.png" />&nbsp;我的关注(5)</a></td>
            <td width="3%">&nbsp;</td>
		</tr>
	</table>

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
                            <span><h3><a href="resource_list.htm" hidefocus="true">运输线路</a></h3><s></s></span>
                            <div class='i-mc'>
                                <div class='close' onclick="$(this).parent().parent().removeClass('hover')"></div>
                                <div class='subitem'>
                                    <dl class='fore'>
                                        <dt>始发城市</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">北京</a></em>
                                            <em><a href="javascript:;" hidefocus="true">天津</a></em>
                                            <em><a href="javascript:;" hidefocus="true">上海</a></em>
                                            <em><a href="javascript:;" hidefocus="true">广州</a></em>
                                            <em><a href="javascript:;" hidefocus="true">武汉</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>到达城市</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">北京</a></em>
                                            <em><a href="javascript:;" hidefocus="true">天津</a></em>
                                            <em><a href="javascript:;" hidefocus="true">上海</a></em>
                                            <em><a href="javascript:;" hidefocus="true">广州</a></em>
                                            <em><a href="javascript:;" hidefocus="true">武汉</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>运输类型</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">整车</a></em>
                                            <em><a href="javascript:;" hidefocus="true">零担</a></em>
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
                            <span><h3><a href="resource_list2.htm" hidefocus="true">配送网络</a></h3><s></s></span>
                            <div class='i-mc'>
                                <div class='close' onclick="$(this).parent().parent().removeClass('hover')"></div>
                                <div class='subitem'>
                                    <dl class='fore'>
                                        <dt>配送城市</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">北京</a></em>
                                            <em><a href="javascript:;" hidefocus="true">上海</a></em>
                                            <em><a href="javascript:;" hidefocus="true">广州</a></em>
                                            <em><a href="javascript:;" hidefocus="true">武汉</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>增值服务</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">有</a></em>
                                            <em><a href="javascript:;" hidefocus="true">无</a></em>
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
                            <span><h3><a href="resource_list3.htm" hidefocus="true">车辆</a></h3><s></s></span>
                            <div class='i-mc'>
                                <div class='close' onclick="$(this).parent().parent().removeClass('hover')"></div>
                                <div class='subitem'>
                                    <dl class='fore'>
                                        <dt>车辆用途</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">普通运输</a></em>
                                            <em><a href="javascript:;" hidefocus="true">特殊</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>车辆厢型</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">普通</a></em>
                                            <em><a href="javascript:;" hidefocus="true">平板</a></em>
                                            <em><a href="javascript:;" hidefocus="true">集装厢</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>冷藏用车</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">是</a></em>
                                            <em><a href="javascript:;" hidefocus="true">否</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>车辆长度</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">10米</a></em>
                                            <em><a href="javascript:;" hidefocus="true">12米</a></em>
                                            <em><a href="javascript:;" hidefocus="true">14米</a></em>
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
                            <span><h3><a href="resource_list4.htm" hidefocus="true">仓库</a></h3><s></s></span>
                            <div class='i-mc'>
                                <div class='close' onclick="$(this).parent().parent().removeClass('hover')"></div>
                                <div class='subitem'>
                                    <dl class='fore'>
                                        <dt>所在城市</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">北京</a></em>
                                            <em><a href="javascript:;" hidefocus="true">天津</a></em>
                                            <em><a href="javascript:;" hidefocus="true">上海</a></em>
                                            <em><a href="javascript:;" hidefocus="true">广州</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>仓库类型</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">保税</a></em>
                                            <em><a href="javascript:;" hidefocus="true">非保税</a></em>
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
                            <span><h3><a href="resource_list5.htm" hidefocus="true">司机</a></h3><s></s></span>
                            <div class='i-mc'>
                                <div class='close' onclick="$(this).parent().parent().removeClass('hover')"></div>
                                <div class='subitem'>
                                    <dl class='fore'>
                                        <dt>驾照等级</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">A</a></em>
                                            <em><a href="javascript:;" hidefocus="true">B</a></em>
                                            <em><a href="javascript:;" hidefocus="true">C</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>驾龄</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">超过10年</a></em>
                                            <em><a href="javascript:;" hidefocus="true">超过5年</a></em>
                                            <em><a href="javascript:;" hidefocus="true">超过2年</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>性别</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">男</a></em>
                                            <em><a href="javascript:;" hidefocus="true">女</a></em>
                                        </dd>
                                    </dl>
                                </div>
                                <div class='fr'>
                                    <img src="images/illust_1e.png" />
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
                            <span><h3><a href="resource_list6.htm" hidefocus="true">公司</a></h3><s></s></span>
                            <div class='i-mc'>
                                <div class='close' onclick="$(this).parent().parent().removeClass('hover')"></div>
                                <div class='subitem'>
                                    <dl class='fore'>
                                        <dt>资源等级</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">自有</a></em>
                                            <em><a href="javascript:;" hidefocus="true">核心</a></em>
                                            <em><a href="javascript:;" hidefocus="true">外围</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>业务种类</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">运输线路</a></em>
                                            <em><a href="javascript:;" hidefocus="true">配送网络</a></em>
                                            <em><a href="javascript:;" hidefocus="true">仓储</a></em>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>信用等级</dt>
                                        <dd>
                                            <em><a href="javascript:;" hidefocus="true">1级</a></em>
                                            <em><a href="javascript:;" hidefocus="true">2级</a></em>
                                            <em><a href="javascript:;" hidefocus="true">3级</a></em>
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
                        <div class='extra'><a href="javascript:;" hidefocus="true">全部资源</a></div>
                    </div>
                </div>
                <script type="text/javascript"> 
                    $(".allsort").hoverForIE6({current:"allsorthover",delay:100});
                    $(".allsort .item").hoverForIE6({delay:50});
                </script>
            </td>
            <td class="td_top2a">
            	<a href="resource_list.htm" class="a_mainnav" hidefocus="true">资源</a>
            </td>
            <td class="td_top2a">&nbsp;</td>
            <td width="3%">&nbsp;</td>
		</tr>
    </table>
</div>

<div id="main_frame">
	<div class="div_login_left">
    	<div class="div_login_sub1">
        	登录
        </div>
    	<div class="div_login_sub2">
			<div class="div_login_sub2a">
            	<div class="div_login_sub2as">
            		<form action="login" name="loginForm" method="post">
                    <input name="username" type="text" class="input_login1" placeholder="帐户" />
                    <input name="password" type="password" class="input_login1" placeholder="密码" />   
                    
				</div>
            </div>
			<div class="div_login_sub2b">
            	<input type="button" id="btn2" value="登&nbsp;录" class="submit_login" hidefocus="true" onclick="document.forms.loginForm.submit();" />          
            </div>
            </form> 
        </div>
    	<div class="div_login_sub3">
        	<input type="checkbox" />&nbsp;自动登录&nbsp;&nbsp;|&nbsp;&nbsp;忘记密码
        </div>
	</div>
	<div class="div_login_right">
    	<div class="div_login_sub1">
        	加入我们
        </div>
    	<div class="div_login_sub4">
        	现在可以简单、快速的成为会员！<br />
            加入会员后可以享受我们提供的快捷服务！<br />
            <input type="button" id="btn2" value="注册" class="submit_login1" hidefocus="true" onclick="window.location.href='register.htm'" />
        </div>
	</div>
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
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.htm"></iframe>
</div>

</body>
</html>