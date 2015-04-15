$(document).ready(function(){
	var urladdtion = new Array([5]);//申请数组存储筛选控件状态
	
	urladdtion[0] = "";
	urladdtion[1] = "";
	urladdtion[2] = "";
	urladdtion[3] = "";
	urladdtion[4] = "";
							
	$("#select1 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("resource_all")) {
			$("#selectA").remove();
			urladdtion[0] = document.getElementById("select1").getAttribute('value') + "=All";//取消点选是状态恢复为all
		} else {
			var copyThisA = $(this).clone();
			urladdtion[0] = document.getElementById("select1").getAttribute('value') + "=" + $(this).text();//点选控件时控件value设置为当前text
			if ($("#selectA").length > 0) {
				$("#selectA a").html($(this).text());
			} else {
				$(".resource_result dl").append(copyThisA.attr("id", "selectA"));
			}
		}
	});
	
	$("#select2 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("resource_all")) {
			$("#selectB").remove();
			urladdtion[1] = document.getElementById("select2").getAttribute('value') + "=All";
		} else {
			var copyThisB = $(this).clone();
			urladdtion[1] = document.getElementById("select2").getAttribute('value') + "=" + $(this).text();
			if ($("#selectB").length > 0) {
				$("#selectB a").html($(this).text());
			} else {
				$(".resource_result dl").append(copyThisB.attr("id", "selectB"));
			}
		}
	});
	
	$("#select3 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("resource_all")) {
			$("#selectC").remove();
			urladdtion[2] = document.getElementById("select3").getAttribute('value') + "=All";
		} else {
			var copyThisC = $(this).clone();
			urladdtion[2] = document.getElementById("select3").getAttribute('value') + "=" + $(this).text();
			if ($("#selectC").length > 0) {
				$("#selectC a").html($(this).text());
			} else {
				$(".resource_result dl").append(copyThisC.attr("id", "selectC"));
			}
		}
	});
	
	$("#select4 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("resource_all")) {
			$("#selectD").remove();
			urladdtion[3] = document.getElementById("select4").getAttribute('value') + "=All";
		} else {
			var copyThisD = $(this).clone();
			urladdtion[3] = document.getElementById("select4").getAttribute('value') + "=" + $(this).text();
			if ($("#selectD").length > 0) {
				$("#selectD a").html($(this).text());
			} else {
				$(".resource_result dl").append(copyThisD.attr("id", "selectD"));
			}
		}
	});

	
	$("#select5 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("resource_all")) {
			$("#selectE").remove();
			urladdtion[4] = document.getElementById("select5").getAttribute('value') + "=All";
		} else {
			var copyThisE = $(this).clone();
			urladdtion[4] = document.getElementById("select5").getAttribute('value') + "=" + $(this).text();
			if ($("#selectE").length > 0) {
				$("#selectE a").html($(this).text());
			} else {
				$(".resource_result dl").append(copyThisE.attr("id", "selectE"));
			}
		}
	});
	
	function Rescreen()//想做外部调用没成功，目前这段代码没用
	{
		alert("123");
	}
	
	$("#btn1").click(function () {//筛选按钮
		//var div = document.getElementById("zzz");
		//div.click();
		var locateurl = "";
		if(location.pathname.indexOf("selected")>0){//判断是否需要再加selected
			locateurl = "http://localhost:8080" + location.pathname+"?";
			//alert(locateurl);
		}
		else
			//alert(location.pathname.indexOf("selected"));
			locateurl = "http://localhost:8080" + location.pathname + "selected?";//重组url前缀
			//alert(locateurl);
		
		if(document.getElementById("city1") != null)//判断某页面是否存在id为city1的控件
		{
			if(document.getElementById("city1").value == "中文或拼音")//city1控件状态是否为默认状态
				locateurl += document.getElementById("city1").getAttribute('text') + "=All" + "&";//若是，则设定为All
			else
				locateurl += document.getElementById("city1").getAttribute('text') + "=" + document.getElementById("city1").value + "&";//否则将value值写入url
		}
		
		if(document.getElementById("city2") != null)
		{
			if(document.getElementById("city2").value == "中文或拼音")
				locateurl += document.getElementById("city2").getAttribute('text') + "=All" + "&";
			else
				locateurl += document.getElementById("city2").getAttribute('text') + "=" + document.getElementById("city2").value + "&";
		}
		
		for (var i=0;i<5;i++)//对应五个控件
		{
		    if(urladdtion[i] != "")//若控件存在
		    {
		    	if(i == 0)
		    		locateurl += urladdtion[i];//首个控件没有&做前缀
		    	else
		    		locateurl += "&" + urladdtion[i];
		    }
		}
		
		if(document.getElementById("location1") != null)
		{
			if(document.getElementById("location1").value == "点击此处定位...")
				locateurl += "&carLocation=All";
			else
				locateurl += "&carLocation=" + document.getElementById("location1").value;
		}

		locateurl += "&Display=" + document.getElementById("Display").options[document.getElementById("Display").selectedIndex].value + "&PageNow=" + document.getElementById("PageNow").getAttribute('value');
        //Display是每页显示个数，PageNow是目前在第几页，分页和页面跳转对应的控件变化还没做
		location.assign(locateurl);//重载新的url，是否能被后台获取未检验
	});

	$("#selectA").live("click", function () {
		$(this).remove();
		urladdtion[0] = "";
		$("#select1 .resource_all").addClass("").siblings().removeClass("selected");
	});
	
	$("#selectB").live("click", function () {
		$(this).remove();
		urladdtion[1] = "";
		$("#select2 .resource_all").addClass("selected").siblings().removeClass("selected");
	});
	
	$("#selectC").live("click", function () {
		$(this).remove();
		urladdtion[2] = "";
		$("#select3 .resource_all").addClass("selected").siblings().removeClass("selected");
	});
	
	$("#selectD").live("click", function () {
		$(this).remove();
		$("#select4 .resource_all").addClass("selected").siblings().removeClass("selected");
	});
	
	$("#selectE").live("click", function () {
		$(this).remove();
		$("#select5 .resource_all").addClass("selected").siblings().removeClass("selected");
	});

	$(".resource dd").live("click", function () {
		if ($(".resource_result dd").length > 1) {
			$(".resource_no").hide();
		} else {
			$(".resource_no").show();
		}
	});
});