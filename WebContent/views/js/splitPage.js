/**
 * 分页操作
 */
function ChangePage(page){
		//alert("changepage+"+page);
		var url = location.search;
		if (url.indexOf("?") != -1) {
		      var str = url.substr(1);
		      
		      if(str.indexOf("flag") != -1)
		      {
		    	  //alert("changepage+if");
		    	  var pageNum = Math.ceil(document.getElementById("count").value / 10) ;//默认是每页10条
		    	  document.getElementById("PageNow").setAttribute('value',page);
		      }
		      else
		    	  {
		    	  //alert("changepage+else");
		    	  strs = str.split("&");
			      var pageNum = Math.ceil(document.getElementById("count").value / Number(UrlDecode(strs[strs.length-2].split("=")[1])));
			      document.getElementById("PageNow").setAttribute('value',page);
		    	  }
		      
		      
		}
		document.getElementById("btn1").click();
	}
	
	function ChangeTo(operate){	
		//alert("changeto+"+operate);
		var url = location.search;
		if (url.indexOf("?") != -1) {
		      var str = url.substr(1);
		      var num;
		      if(str.indexOf("flag") != -1){
		    	  
		    	  var pageNum = Math.ceil(document.getElementById("count").value /10);//默认每页10条
		    	  switch(operate)
			      {
			      case "first": num = 1;break;
			      case "previous": num = 1;break;
			      case "next": num = 1 + 1;break;
			      case "last": num = pageNum;break;
			      }
		      }
		      else
		    {
		    	  strs = str.split("&");
		    	  var pageNum = Math.ceil(document.getElementById("count").value / Number(UrlDecode(strs[strs.length-2].split("=")[1])));
		    	  switch(operate)
			      {
			      case "first": num = 1;break;
			      case "previous": num = Number(UrlDecode(strs[strs.length-1].split("=")[1])) - 1;break;
			      case "next": num = Number(UrlDecode(strs[strs.length-1].split("=")[1])) + 1;break;
			      case "last": num = pageNum;break;
			      }
		    }
		      if(num <= 0)
		    	  num = 1;
		      else if(num > pageNum)
		    	  num = pageNum;
		      document.getElementById("PageNow").setAttribute('value',num.toString());
		}
		document.getElementById("btn1").click();
	}