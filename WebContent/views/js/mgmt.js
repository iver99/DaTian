/*我的信息-左侧菜单收缩*/
function mgmt_nav_switch1a() {
	document.getElementById('mgmt_nav_switch1a').style.display = "none";
	document.getElementById('mgmt_nav_switch1b').style.display = "inline-block";
	document.getElementById('mgmt_nav1').style.display = "none";
}
function mgmt_nav_switch1b() {
	document.getElementById('mgmt_nav_switch1a').style.display = "inline-block";
	document.getElementById('mgmt_nav_switch1b').style.display = "none";
	document.getElementById('mgmt_nav1').style.display = "block";
}
function mgmt_nav_switch2a() {
	document.getElementById('mgmt_nav_switch2a').style.display = "none";
	document.getElementById('mgmt_nav_switch2b').style.display = "inline-block";
	document.getElementById('mgmt_nav2').style.display = "none";
}
function mgmt_nav_switch2b() {
	document.getElementById('mgmt_nav_switch2a').style.display = "inline-block";
	document.getElementById('mgmt_nav_switch2b').style.display = "none";
	document.getElementById('mgmt_nav2').style.display = "block";
}
function mgmt_nav_switch3a() {
	document.getElementById('mgmt_nav_switch3a').style.display = "none";
	document.getElementById('mgmt_nav_switch3b').style.display = "inline-block";
	document.getElementById('mgmt_nav3').style.display = "none";
}
function mgmt_nav_switch3b() {
	document.getElementById('mgmt_nav_switch3a').style.display = "inline-block";
	document.getElementById('mgmt_nav_switch3b').style.display = "none";
	document.getElementById('mgmt_nav3').style.display = "block";
}
function mgmt_nav_switch4a() {
	document.getElementById('mgmt_nav_switch4a').style.display = "none";
	document.getElementById('mgmt_nav_switch4b').style.display = "inline-block";
	document.getElementById('mgmt_nav4').style.display = "none";
}
function mgmt_nav_switch4b() {
	document.getElementById('mgmt_nav_switch4a').style.display = "inline-block";
	document.getElementById('mgmt_nav_switch4b').style.display = "none";
	document.getElementById('mgmt_nav4').style.display = "block";
}
function mgmt_nav_switch5a() {
	document.getElementById('mgmt_nav_switch5a').style.display = "none";
	document.getElementById('mgmt_nav_switch5b').style.display = "inline-block";
	document.getElementById('mgmt_nav5').style.display = "none";
}
function mgmt_nav_switch5b() {
	document.getElementById('mgmt_nav_switch5a').style.display = "inline-block";
	document.getElementById('mgmt_nav_switch5b').style.display = "none";
	document.getElementById('mgmt_nav5').style.display = "block";
}




/*城市配送网络维护-显示辖区*/
function check_sub()
{
	if(document.getElementById('subs').checked == true) {
	 document.getElementById('layer_subs').style.display = "";
	 }
	else {
	 document.getElementById('layer_subs').style.display = "none";
	}
}



/*城市配送网络维护-增值服务*/
function change1() {
	if (document.getElementById('valueadd').selectedIndex == 1 )
	{
		document.getElementById('v_detail').style.display='inline';
		}
	else{
		document.getElementById('v_detail').style.display='none';	
		}
	return false;
}


/*提交订单-关联客户运单*/
function change2() {
	if (document.getElementById('psource').selectedIndex == 1 )
	{
		document.getElementById('p_detail').style.display='inline';
		}
	else{
		document.getElementById('p_detail').style.display='none';	
		}
	return false;
}



/*车辆维护-定位方式*/
function change_pos() {
	if (document.getElementById('pos').selectedIndex == 1 )
	{
		document.getElementById('pos_detail_1').style.display='inline';
		document.getElementById('pos_detail_2').style.display='none';
		}
	else {
		document.getElementById('pos_detail_1').style.display='none';
		document.getElementById('pos_detail_2').style.display='none';
		}
	return false;
}



/*车辆维护-入市许可证*/
function change_cert() {
	if (document.getElementById('city_cert').selectedIndex == 1 )
	{
		document.getElementById('c_detail').style.display='inline';
		}
	else{
		document.getElementById('c_detail').style.display='none';	
		}
	return false;
}




/*我的结算-详情显示*/
function balance_switch1a() {
	document.getElementById('balance_detail_1a').style.display = "inline";
	document.getElementById('balance_detail_1b').style.display = "block";
}
function balance_switch1b() {
	document.getElementById('balance_detail_1a').style.display = "none";
	document.getElementById('balance_detail_1b').style.display = "none";
}



//方案需求申请页面：点击radio进行内容切换
function content_switch1() {
	document.getElementById('content1').style.display="block";
	document.getElementById('content2').style.display="none";
	document.getElementById('content3').style.display="none";
	}
function content_switch2() {
	document.getElementById('content1').style.display="none";
	document.getElementById('content2').style.display="block";
	document.getElementById('content3').style.display="none";
	}
function content_switch3() {
	document.getElementById('content1').style.display="none";
	document.getElementById('content2').style.display="none";
	document.getElementById('content3').style.display="block";
	}
