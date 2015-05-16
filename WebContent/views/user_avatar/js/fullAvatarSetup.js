swfobject.addDomLoadEvent(function () {
	var swf = new fullAvatarEditor("swfContainer", {
			id: 'swf',
			upload_url: 'asp/Upload.asp',
			src_upload: 2  //1为自动保存原图，2为由用户选择是否保存原图
		}
/*					,
		function (msg) {
			switch(msg.code)
			{
				case 1 : alert("页面成功加载了组件！");break;
				case 2 : alert("已成功加载默认指定的图片到编辑面板。");break;
				case 3 :
					if(msg.type == 0)
					{
						alert("摄像头已准备就绪且用户已允许使用。");
					}
					else if(msg.type == 1)
					{
						alert("摄像头已准备就绪但用户未允许使用！");
					}
					else
					{
						alert("摄像头被占用！");
					}
				break;
				case 5 : 
					if(msg.type == 0)
					{
						if(msg.content.sourceUrl)
						{
							alert("原图已成功保存至服务器，url为：\n" +　msg.content.sourceUrl);
						}
						alert("头像已成功保存至服务器，url为：\n" + msg.content.avatarUrls.join("\n"));
					}
				break;
			}
		}*/
	);
	document.getElementById("upload").onclick=function(){
		swf.call("upload");
	};
});
