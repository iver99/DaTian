function showid(idname){
var isIE = (document.all) ? true : false;
var isIE6 = isIE && ([/MSIE (\d)\.0/i.exec(navigator.userAgent)][0][1] == 6);
var newbox=document.getElementById(idname);
newbox.style.zIndex="9999";
newbox.style.display="block";
newbox.style.position = !isIE6 ? "fixed" : "absolute";
newbox.style.top =newbox.style.left = "50%";
newbox.style.marginTop = - newbox.offsetHeight / 2 + "px";
newbox.style.marginLeft = - newbox.offsetWidth / 2 + "px";  
var layer=document.createElement("div");
layer.id="layer";
layer.style.width=layer.style.height="100%";
layer.style.position= !isIE6 ? "fixed" : "absolute";
layer.style.top=layer.style.left=0;
layer.style.backgroundColor="#111";
layer.style.zIndex="9998";
layer.style.opacity="0.3";
document.body.appendChild(layer);
/*var sel=document.getElementsByTagName("select");
for(var i=0;i<sel.length;i++){        
sel[i].style.visibility="hidden";
}*/
function layer_iestyle(){      
layer.style.width=Math.max(document.documentElement.scrollWidth, document.documentElement.clientWidth)
+ "px";
layer.style.height= Math.max(document.documentElement.scrollHeight, document.documentElement.clientHeight) +
"px";
}
function newbox_iestyle(){      
newbox.style.marginTop = document.documentElement.scrollTop - newbox.offsetHeight / 2 + "px";
newbox.style.marginLeft = document.documentElement.scrollLeft - newbox.offsetWidth / 2 + "px";
}
if(isIE){layer.style.filter ="alpha(opacity=30)";}
if(isIE6){  
layer_iestyle()
newbox_iestyle();
window.attachEvent("onscroll",function(){                              
newbox_iestyle();
})
window.attachEvent("onresize",layer_iestyle)          
}  


/*以下各行均取消对select的操作*/
/****
for (var i=0;i<sel.length;i++) {
	sel[i].style.visibility="visible";
	}
****/

document.getElementById("close").onclick=function(){newbox.style.display="none";layer.style.display="none";}

document.getElementById("close2").onclick=function(){newbox.style.display="none";layer.style.display="none";}

//document.getElementById("close2a").onclick=function(){document.getElementById('location1').value='北京市顺义区天竺空港工业区天柱中路16号';newbox.style.display="none";layer.style.display="none";}
document.getElementById("close2a").onclick=function(){document.getElementById("location1").value = document.getElementById("searchloc").value;newbox.style.display="none";layer.style.display="none";}
}
