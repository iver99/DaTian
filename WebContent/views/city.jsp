<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>城市切换</title>
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
<script type="text/javascript" src="js/citylist.js"></script>
<script type="text/javascript" src="js/cityquery.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
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
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_cityswitch1">
        <tr>
            <td height="30" class="td_cityswitch1" id="cityselector">
				<span class="span_cityswitch1">选择城市</span>
                <input id="city1" type="text" value="" class="input_city1" />
                &nbsp;
                <input type="button" id="btn1" value="进入" class="btn_mgmt1" hidefocus="true" onclick="ChangeCity(document.getElementById('city1').value);"/>
            </td>
        </tr>
        <tr>
            <td height="30" class="td_cityswitch1">
				<span class="span_cityswitch2">热门城市</span>
                <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('北京');">北京</a>
                <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('天津');">天津</a>
                <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('上海');">上海</a>
                <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('广州');">广州</a>
                <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('武汉');">武汉</a>
                <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('西安');">西安</a>
                <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('重庆');">重庆</a>
                <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('青岛');">青岛</a>
                <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('大连');">大连</a>
                <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('石家庄');">石家庄</a>
            </td>
        </tr>
        <tr>
            <td height="30" class="td_cityswitch1">
				<span class="span_cityswitch3">按拼音首字母选择</span>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="60" height="60"><span class="span_cityswitch4">A</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('阿拉善');">阿拉善</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('鞍山');">鞍山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('安庆');">安庆</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('安阳');">安阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('安顺');">安顺</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('阿里');">阿里</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('安康');">安康</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('阿克苏');">阿克苏</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('阿勒泰');">阿勒泰</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('澳门');">澳门</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('安丘');">安丘</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('安吉');">安吉</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">B</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('北京');">北京</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('保定');">保定</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('包头');">包头</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('巴彦淖尔');">巴彦淖尔</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('本溪');">本溪</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('白山');">白山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('白城');">白城</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('蚌埠');">蚌埠</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('滨州');">滨州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('北海');">北海</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('百色');">百色</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('巴中');">巴中</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('毕节');">毕节</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('保山');">保山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('宝鸡');">宝鸡</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('白银');">白银</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('亳州');">亳州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('保亭');">保亭</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('白沙');">白沙</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">C</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('承德');">承德</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('沧州');">沧州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('长治');">长治</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('赤峰');">赤峰</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('朝阳');">朝阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('长春');">长春</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('常州');">常州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('滁州');">滁州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('巢湖');">巢湖</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('池州');">池州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('长沙');">长沙</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('郴州');">郴州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('潮州');">潮州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('重庆');">重庆</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('成都');">成都</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('昌都');">昌都</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('昌吉');">昌吉</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('常德');">常德</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('崇左');">崇左</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('慈溪');">慈溪</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('常熟');">常熟</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('澄迈');">澄迈</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('昌江');">昌江</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('长兴');">长兴</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('苍南');">苍南</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">D</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('大同');">大同</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('大连');">大连</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('丹东');">丹东</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('大庆');">大庆</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('大兴安岭');">大兴安岭</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('东营');">东营</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('德州');">德州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('东莞');">东莞</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('德阳');">德阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('达州');">达州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('大理');">大理</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('定西');">定西</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('儋州');">儋州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('东方');">东方</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('定安');">定安</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('德清');">德清</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('东阳');">东阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('独山子');">独山子</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">E</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('鄂尔多斯');">鄂尔多斯</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('鄂州');">鄂州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('恩施');">恩施</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">F</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('抚顺');">抚顺</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('阜新');">阜新</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('阜阳');">阜阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('福州');">福州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('抚州');">抚州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('佛山');">佛山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('防城港');">防城港</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('凤凰');">凤凰</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('阜康');">阜康</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">G</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('赣州');">赣州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('广州');">广州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('桂林');">桂林</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('贵港');">贵港</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('贵阳');">贵阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('固原');">固原</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('广元');">广元</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('广安');">广安</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('甘孜');">甘孜</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('广汉');">广汉</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">H</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('邯郸');">邯郸</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('衡水');">衡水</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('呼和浩特');">呼和浩特</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('呼伦贝尔');">呼伦贝尔</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('葫芦岛');">葫芦岛</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('哈尔滨');">哈尔滨</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('鹤岗');">鹤岗</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('黑河');">黑河</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('淮安');">淮安</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('杭州');">杭州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('湖州');">湖州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('合肥');">合肥</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('淮南');">淮南</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('淮北');">淮北</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('鹤壁');">鹤壁</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('衡阳');">衡阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('怀化');">怀化</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('惠州');">惠州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('河源');">河源</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('贺州');">贺州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('河池');">河池</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('海口');">海口</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('汉中');">汉中</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('海东');">海东</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('哈密');">哈密</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('菏泽');">菏泽</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('黄山');">黄山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('和田');">和田</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('黄冈');">黄冈</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('海宁');">海宁</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('合川');">合川</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">J</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('晋城');">晋城</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('晋中');">晋中</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('锦州');">锦州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('吉林');">吉林</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('鸡西');">鸡西</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('佳木斯');">佳木斯</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('嘉兴');">嘉兴</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('金华');">金华</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('吉安');">吉安</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('济南');">济南</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('济宁');">济宁</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('焦作');">焦作</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('荆门');">荆门</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('江门');">江门</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('揭阳');">揭阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('嘉峪关');">嘉峪关</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('金昌');">金昌</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('酒泉');">酒泉</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('景德镇');">景德镇</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('九江');">九江</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('江阴');">江阴</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('济源');">济源</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('荆州');">荆州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('晋江');">晋江</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('九寨沟');">九寨沟</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('江津');">江津</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('江油');">江油</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">K</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('开封');">开封</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('昆明');">昆明</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('克拉玛依');">克拉玛依</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('喀什');">喀什</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('昆山');">昆山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('开县');">开县</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('奎屯');">奎屯</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('库尔勒');">库尔勒</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">L</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('廊坊');">廊坊</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('临汾');">临汾</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('吕梁');">吕梁</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('辽阳');">辽阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('辽源');">辽源</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('连云港');">连云港</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('丽水');">丽水</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('六安');">六安</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('龙岩');">龙岩</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('莱芜');">莱芜</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('临沂');">临沂</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('聊城');">聊城</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('洛阳');">洛阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('漯河');">漯河</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('娄底');">娄底</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('柳州');">柳州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('泸州');">泸州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('凉山');">凉山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('六盘水');">六盘水</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('丽江');">丽江</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('临沧');">临沧</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('拉萨');">拉萨</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('兰州');">兰州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('临夏');">临夏</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('来宾');">来宾</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('陇南');">陇南</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('乐山');">乐山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('临高');">临高</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('龙胜');">龙胜</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('乐东');">乐东</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('陵水');">陵水</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('兰溪');">兰溪</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('临夏');">临夏</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('浏阳');">浏阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('阆中');">阆中</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">M</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('牡丹江');">牡丹江</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('马鞍山');">马鞍山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('茂名');">茂名</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('梅州');">梅州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('绵阳');">绵阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('眉山');">眉山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('满洲里');">满洲里</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('明光');">明光</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('绵竹');">绵竹</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">N</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('南京');">南京</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('南通');">南通</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('宁波');">宁波</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('南平');">南平</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('宁德');">宁德</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('南昌');">南昌</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('南阳');">南阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('南宁');">南宁</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('南充');">南充</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('怒江');">怒江</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('那曲');">那曲</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('林芝');">林芝</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('内江');">内江</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('南川');">南川</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">P</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('盘锦');">盘锦</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('莆田');">莆田</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('平顶山');">平顶山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('濮阳');">濮阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('攀枝花');">攀枝花</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('平凉');">平凉</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('萍乡');">萍乡</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('普洱');">普洱</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('平湖');">平湖</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('平阳');">平阳</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">Q</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('秦皇岛');">秦皇岛</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('齐齐哈尔');">齐齐哈尔</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('七台河');">七台河</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('泉州');">泉州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('青岛');">青岛</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('清远');">清远</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('钦州');">钦州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('曲靖');">曲靖</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('庆阳');">庆阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('衢州');">衢州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('琼海');">琼海</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('曲阜');">曲阜</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('琼中');">琼中</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('綦江');">綦江</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">R</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('日照');">日照</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('日喀则');">日喀则</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('瑞安');">瑞安</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">S</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('石家庄');">石家庄</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('朔州');">朔州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('沈阳');">沈阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('四平');">四平</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('双鸭山');">双鸭山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('绥化');">绥化</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('上海');">上海</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('苏州');">苏州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('宿迁');">宿迁</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('绍兴');">绍兴</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('宿州');">宿州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('三明');">三明</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('上饶');">上饶</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('三门峡');">三门峡</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('商丘');">商丘</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('十堰');">十堰</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('随州');">随州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('邵阳');">邵阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('韶关');">韶关</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('深圳');">深圳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('汕头');">汕头</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('汕尾');">汕尾</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('三亚');">三亚</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('遂宁');">遂宁</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('山南');">山南</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('石嘴山');">石嘴山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('商洛');">商洛</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('松原');">松原</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('石狮');">石狮</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('石河子');">石河子</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('什邡');">什邡</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">T</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('天津');">天津</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('唐山');">唐山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('太原');">太原</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('通辽');">通辽</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('铁岭');">铁岭</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('通化');">通化</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('泰州');">泰州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('台州');">台州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('铜陵');">铜陵</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('泰安');">泰安</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('铜仁');">铜仁</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('铜川');">铜川</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('天水');">天水</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('吐鲁番');">吐鲁番</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('塔城');">塔城</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('塘沽');">塘沽</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('屯昌');">屯昌</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('太仓');">太仓</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('天长');">天长</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">W</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('乌海');">乌海</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('乌兰察布');">乌兰察布</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('无锡');">无锡</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('温州');">温州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('芜湖');">芜湖</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('潍坊');">潍坊</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('威海');">威海</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('武汉');">武汉</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('梧州');">梧州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('文山');">文山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('渭南');">渭南</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('武威');">武威</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('吴忠');">吴忠</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('乌鲁木齐');">乌鲁木齐</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('吴江');">吴江</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('五指山');">五指山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('文昌');">文昌</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('万宁');">万宁</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('武夷山');">武夷山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('婺源');">婺源</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('万州');">万州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('乌苏');">乌苏</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">X</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('邢台');">邢台</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('忻州');">忻州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('兴安');">兴安</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('锡林郭勒');">锡林郭勒</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('徐州');">徐州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('宣城');">宣城</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('厦门');">厦门</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('新余');">新余</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('新乡');">新乡</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('许昌');">许昌</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('信阳');">信阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('孝感');">孝感</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('湘潭');">湘潭</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('西双版纳');">西双版纳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('西安');">西安</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('咸阳');">咸阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('西宁');">西宁</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('香港');">香港</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('襄阳');">襄阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('咸宁');">咸宁</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('象山');">象山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('萧山');">萧山</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">Y</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('阳泉');">阳泉</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('运城');">运城</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('营口');">营口</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('伊春');">伊春</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('盐城');">盐城</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('扬州');">扬州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('鹰潭');">鹰潭</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('宜春');">宜春</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('烟台');">烟台</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('宜昌');">宜昌</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('岳阳');">岳阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('益阳');">益阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('永州');">永州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('阳江');">阳江</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('云浮');">云浮</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('玉林');">玉林</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('宜宾');">宜宾</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('玉溪');">玉溪</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('延安');">延安</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('榆林');">榆林</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('玉树');">玉树</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('银川');">银川</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('伊犁');">伊犁</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('雅安');">雅安</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('义乌');">义乌</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('兖州');">兖州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('仪征');">仪征</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('宜兴');">宜兴</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('乐清');">乐清</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('余姚');">余姚</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('永康');">永康</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('阳朔');">阳朔</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('杨陵');">杨陵</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('永川');">永川</a>
                        </td>
                    </tr>
                    <tr>
                        <td height="60"><span class="span_cityswitch4">Z</span></td>
                        <td>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('张家口');">张家口</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('镇江');">镇江</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('舟山');">舟山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('漳州');">漳州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('淄博');">淄博</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('枣庄');">枣庄</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('郑州');">郑州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('周口');">周口</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('驻马店');">驻马店</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('株洲');">株洲</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('珠海');">珠海</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('湛江');">湛江</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('肇庆');">肇庆</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('中山');">中山</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('自贡');">自贡</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('遵义');">遵义</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('昭通');">昭通</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('张掖');">张掖</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('张家界');">张家界</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('中卫');">中卫</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('资阳');">资阳</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('涿州');">涿州</a>
                            <a href="javascript:;" class="a_cityswitch1" hidefocus="true" onclick="ChangeCity('张家港');">张家港</a>
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
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.htm"></iframe>
</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
	}
	function ChangeCity(City) {
		document.getElementById("city").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;"+City+"&nbsp;<a href=\"city\" hidefocus=\"true\">[更换]</a>";
		setCookie(City);
		var curWwwPath=window.document.location.href;
	    var pathName=window.document.location.pathname;
	    var pos=curWwwPath.indexOf(pathName);
		location.assign(curWwwPath.substring(0,pos) + "/DaTian/");
	}
	function setCookie(value) 
	{ 
	    var Days = 30; 
	    var exp = new Date(); 
	    exp.setTime(exp.getTime() + Days*24*60*60*1000); 
	    document.cookie = "city="+ escape (value) + ";expires=" + exp.toGMTString(); 
	    //alert("cookie");
	}
</script>
</html>