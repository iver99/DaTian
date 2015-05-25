<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>城市配送网络信息</title>
<!-- 我的信息-城市配送-更新 -->
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/mgmt.js"></script>
<script type="text/javascript" src="js/citylist.js"></script>
<script type="text/javascript" src="js/cityquery.js"></script>
<script type="text/javascript" src="js/backtop.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="js/focus_load.js"></script>
<script type="text/javascript"> 
	$(function() {
		$('input, textarea').placeholder(); 
	});
</script>
</head>

<body onload="OnLoad()">

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

<%@ include  file="topFrame.jsp"%>

<div id="main_frame">
	<a href="myinfo" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的资源
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <%@ include  file="mysource_leftnav_mytrade.jsp"%>
                    <hr class="hr_2" />
                    <span class="text_mgmt_leftnav1"><span
							id="mgmt_nav_switch2a" class="span_mgmt_nav1" title="收起"
							onclick="mgmt_nav_switch2a();"></span><span
							id="mgmt_nav_switch2b" class="span_mgmt_nav2" title="展开"
							onclick="mgmt_nav_switch2b();"></span>我的资源</span>
						<div id="mgmt_nav2">
                        <a href="linetransport?flag=1&Display=10&PageNow=1" class="a_mgmt_leftnav" hidefocus="true">干线运输线路信息</a>
                        <a href="cityline?flag=1" class="a_mgmt_leftnav1" hidefocus="true">城市配送网络信息</a>
                        <a href="car?flag=1" class="a_mgmt_leftnav" hidefocus="true">车辆信息</a>
                        <a href="warehouse?flag=1" class="a_mgmt_leftnav" hidefocus="true">仓库信息</a>
						<a href="driver?flag=1" class="a_mgmt_leftnav" hidefocus="true">司机信息</a>
                        <a href="client" class="a_mgmt_leftnav" hidefocus="true">客户信息</a>
                        <a href="goodsform?flag=1" class="a_mgmt_leftnav" hidefocus="true">货物信息</a>
                        <a href="contract" class="a_mgmt_leftnav" hidefocus="true">合同信息</a>
                    </div>
                    <%@ include  file="mysource_leftnav_myplan.jsp"%>
                    <%@ include  file="mysource_leftnav_myanalysis.jsp"%>
                    <%@ include  file="mysource_leftnav_myaccount.jsp"%>
</div>
			</td>
			<td class="td_leftnav_top">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2a">
                    <tr>
                        <td>
                            <span class="span_mgmt_right2_text1">更新配送网络信息</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                    </tr>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a"> 
                            <br /> 
                            <form action="updateCityline?id=${citylineInfo.id }" method="post" enctype="multipart/form-data">	          
                              	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">网络名称：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${citylineInfo.name }" name="citylineName"/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">配送城市：</td>
                                    <td id="cityselector">
                                    	<input id="city1" type="text" value="${citylineInfo.cityName }" class="input_city1" name="cityName"/>
                                        &nbsp;
                                        <span id="layer_switch"><input type="checkbox" id="subs" onclick="check_sub();" checked="checked" />
                                        显示辖区
                                        </span>
                                    </td>
                                </tr>
                                <tr id="layer_subs">
                                    <td height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
                                    <td>
                                        <span class="span_mgmt_right3_checkbox1">
                                        	<input type="checkbox" checked="checked" />朝阳区
                                        </span>
                                        <span class="span_mgmt_right3_checkbox2">
                                            <input type="checkbox" checked="checked" />管庄&nbsp;
                                            <input type="checkbox" checked="checked" />北苑&nbsp;
                                            <input type="checkbox" checked="checked" />定福庄&nbsp;
                                            <input type="checkbox" checked="checked" />三环以内&nbsp;
                                            <input type="checkbox" checked="checked" />三环到四环之间&nbsp;
                                            <input type="checkbox" checked="checked" />四环到五环之间&nbsp;
                                            <input type="checkbox" checked="checked" />五环到六环之间
                                        </span>
                                        <br />
                                        <span class="span_mgmt_right3_checkbox1">
                                        	<input type="checkbox" checked="checked" />海淀区
                                        </span>
                                        <span class="span_mgmt_right3_checkbox2">
                                            <input type="checkbox" checked="checked" />西三旗&nbsp;
                                            <input type="checkbox" checked="checked" />西二旗&nbsp;
                                            <input type="checkbox" checked="checked" />三环以内&nbsp;
                                            <input type="checkbox" checked="checked" />三环到四环之间&nbsp;
                                            <input type="checkbox" checked="checked" />四环到五环之间&nbsp;
                                            <input type="checkbox" checked="checked" />五环到六环之间&nbsp;
                                            <input type="checkbox" checked="checked" />六环以外
                                        </span>
                                        <br />
                                        <span class="span_mgmt_right3_checkbox1">
                                        	<input type="checkbox" checked="checked" />西城区
                                        </span>
                                        <span class="span_mgmt_right3_checkbox2">
                                            <input type="checkbox" checked="checked" />内环到二环&nbsp;
                                            <input type="checkbox" checked="checked" />二环到三环
                                        </span>
                                        <br />
                                        <span class="span_mgmt_right3_checkbox1">
                                        	<input type="checkbox" checked="checked" />东城区
                                        </span>
                                        <span class="span_mgmt_right3_checkbox2">
                                            <input type="checkbox" checked="checked" />内环到二环&nbsp;
                                            <input type="checkbox" />二环到三环
                                        </span>
                                        <br />
                                        <span class="span_mgmt_right3_checkbox1">
                                        	<input type="checkbox" checked="checked" />丰台区
                                        </span>
                                        <span class="span_mgmt_right3_checkbox2">
                                            <input type="checkbox" checked="checked" />二环到三环之间&nbsp;
                                            <input type="checkbox" checked="checked" />三环到四环之间&nbsp;
                                            <input type="checkbox" checked="checked" />四环到五环之间&nbsp;
                                            <input type="checkbox" />五环到六环之间&nbsp;
                                            <input type="checkbox" />六环以外
                                        </span>
                                        <br />
                                    </td>
                                </tr>
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">增值服务：</td>
                                    <td>
                                        <select id="valueadd" style="width:120px;" onchange="change1();" name="VIPService">
                                        <option value="" selected="selected">请选择</option>
                                        <option value="有">有</option>
                                        <option value="无">无</option>
                                        </select>
                                        <div id="v_detail" style="display:none;">
                                        <input type="text" class="input_mgmt1" style="width:176px;" value="${citylineInfo.VIPDetail }" name="VIPDetail"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">参考价：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${citylineInfo.refPrice }" name="refPrice"/>
                                    (元/kg)</td>
                                </tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">详细报价：</td>
									<td>
                                    	<div style="position:relative;">
                                        	<input id="apply_attachment1" type="text" class="input_attachment1" style="width:230px;" value="请参照模板格式要求填写后提交..." /><input id="upload_btn3" type="button" value="添加" class="input_attachment_btn1" style="width:60px; margin-left:10px;" />
      <input id="upload_btn4" type="file" name="file" onchange="document.getElementById('apply_attachment1').value=/[^\\]+\.\w+$/.exec(this.value)[0]" class="input_attachment_btn1_hidden" style="width:300px;" hidefocus="true" />
                                        </div>
                                    </td>
								</tr>
                                <tr>
                                    <td height="20" class="td_mgmt_right3_td1b"></td>
                                    <td><a href="javascript:;" hidefocus="true">报价模板&nbsp;<img src="images/btn_filetype2.png" /></a></td>
                                </tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">补充信息：</td>
									<td>
                                    	<textarea class="textarea_rating" placeholder="请输入内容..." name="remarks">${citylineInfo.remarks }</textarea>
                                    </td>
								</tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
                                    <td><input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" onclick="window.location.href='mgmt_r_city.htm'" /><input type="button" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" /></td>
                                </tr>
                               
							</table>
							</form>
						</td>
					</tr>
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
	function OnLoad() {
		loadFocus();
	}
</script>
</html>