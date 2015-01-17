var count = 3; /*从id为city4开始动态增加*/


////车辆维护页面用
function addcity() {
count += 1;
var dymcity = document.getElementById("dym_citylist");

var div = document.createElement("div");

	var inputTxt = document.createElement("input");  //section-输入框
		inputTxt.type = 'text';
		inputTxt.value = '';
		inputTxt.id = 'city'+count;
		inputTxt.className = 'input_city1a';

/*	var del = document.createElement("input"); //section-删除
		del.type = "button";
		del.value = "删除";
*/
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
div.appendChild(del);
dymcity.appendChild(div);
$("#city"+count).querycity({'data':cityResource,'tabs':labelFromcity,'hotList':hotList});
}



////方案需求提交页面用--线路
function addcity2() {
count += 1;
var dymcity = document.getElementById("dym_citylist");

var div = document.createElement("div");

	var inputTxt = document.createElement("input");  //section-输入框
		inputTxt.type = 'text';
		inputTxt.value = '';
		inputTxt.id = 'city'+count;
		inputTxt.className = 'input_city1a';

	var inputTxt2 = document.createElement("span");  //section-输入框
		inputTxt2.className = 'span_mgmt_dynamic1';
		inputTxt2.innerHTML = '至';

	var inputTxt3 = document.createElement("input");  //section-输入框
		inputTxt3.type = 'text';
		inputTxt3.value = '';
		inputTxt3.id = 'city'+count+1;
		inputTxt3.className = 'input_city1a';

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
div.appendChild(inputTxt2);
div.appendChild(inputTxt3);
div.appendChild(del);
dymcity.appendChild(div);
$("#city"+count).querycity({'data':cityResource,'tabs':labelFromcity,'hotList':hotList});
$("#city"+count+1).querycity({'data':cityResource,'tabs':labelFromcity,'hotList':hotList});
}
