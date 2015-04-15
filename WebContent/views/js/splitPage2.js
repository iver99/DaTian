/**
 * 分页操作
 */
function ChangePage(page){
		//alert("changepage+"+page);
		var url = location.search;
		//alert(url);显示问号之后的内容
		if (url.indexOf("?") != -1) {
		      var str = url.substr(1);
		      //alert(str);
		      strs = str.split("&");
		      //alert(document.getElementById("count").value);  显示16
		      //alert(Number(strs[strs.length-2].split("=")[1]));
		      var pageNum = Math.ceil(document.getElementById("count").value / Number(strs[strs.length-2].split("=")[1]));
		      // var pageNum=4;
		      //alert(pageNum);   显示2
		      //alert(page);
		      document.getElementById("PageNow").setAttribute('value',page);
		}
		//document.getElementById("btn1").click();
	}
	
	function ChangeTo(operate){	
		//alert("changeto+"+operate);
		var url = location.search;
		if (url.indexOf("?") != -1) {
		      var str = url.substr(1);
		      strs = str.split("&");
		      var num;
		      var pageNum = Math.ceil(document.getElementById("count").value / Number(UrlDecode(strs[strs.length-2].split("=")[1])));
		      switch(operate)
		      {
		      case "first": num = 1;break;
		      case "previous": num = Number(UrlDecode(strs[strs.length-1].split("=")[1])) - 1;break;
		      case "next": num = Number(UrlDecode(strs[strs.length-1].split("=")[1])) + 1;break;
		      case "last": num = pageNum;break;
		      }
		      if(num <= 0)
		    	  num = 1;
		      else if(num > pageNum)
		    	  num = pageNum;
		      document.getElementById("PageNow").setAttribute('value',num.toString());
		}
		document.getElementById("btn1").click();
	}