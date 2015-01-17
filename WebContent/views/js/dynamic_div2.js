var count = 1; /*从id为1开始动态增加*/

function additem() {  //确认订单时的动态添加信息

count += 1;
var dymcity = document.getElementById("dym_itemlist");

var div = document.createElement("div");

	var inputTxt = document.createElement("input");  //section-输入框
		inputTxt.type = 'text';
		inputTxt.value = '';
		inputTxt.id = 'city'+count;
		inputTxt.className = 'input_mgmt2';
		inputTxt.placeholder = '运单号';

	var inputTxt1a = document.createElement("span");  //section-输入框
		inputTxt1a.className = 'span_mgmt_dynamic1';
		inputTxt1a.innerHTML = '--';

/*	var inputTxt2 = document.createElement("input");  //section-输入框
		inputTxt2.type = 'text';
		inputTxt2.value = '';
		inputTxt2.id = 'city'+count;
		inputTxt2.className = 'input_mgmt2';
		inputTxt2.placeholder = '车牌号';
*/
	var inputTxt2 = document.createElement("select");  //section-输入框
		inputTxt2.options[0] = new Option("选择车牌号", "");
		inputTxt2.options[1] = new Option("京AB0001", "a");
		inputTxt2.options[2] = new Option("京AB0002", "b");
		inputTxt2.options[3] = new Option("京AB0003", "c");
		inputTxt2.size = "1";
		inputTxt2.className = 'input_mgmt2a';

	var inputTxt2a = document.createElement("span");  //section-输入框
		inputTxt2a.className = 'span_mgmt_dynamic1';
		inputTxt2a.innerHTML = '--';

	var inputTxt3 = document.createElement("input");  //section-输入框
		inputTxt3.type = 'text';
		inputTxt3.value = '';
		inputTxt3.id = 'city'+count;
		inputTxt3.className = 'input_mgmt2';
		inputTxt3.value = '随车司机';
		inputTxt3.readOnly = 'readOnly';

	var del = document.createElement("img"); //section-删除
		del.src = "../images/btn_cancel2.png";
		del.className = "img_citydel";
		del.alt = "删除";
		del.onclick = function() { //删除后效果，包括计数
			this.parentNode.parentNode.removeChild(this.parentNode);
			var n = citylist.getElementsByTagName("div");
			for(var k=0; k<n.length; k++) {
				n[k].firstChild.nodeValue = k+1;
			}
			count -= 1;
		}

//页面显示内容的控制
div.appendChild(inputTxt);
div.appendChild(inputTxt1a);
div.appendChild(inputTxt2);
div.appendChild(inputTxt2a);
div.appendChild(inputTxt3);
div.appendChild(del);
dymcity.appendChild(div);

$(function() {
	$('input, textarea').placeholder(); 
});

}
