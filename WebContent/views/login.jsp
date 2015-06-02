<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no" />
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css" />
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<!-- 用于表单验证 -->
<script type="text/javascript" src="js/jquery.metadata.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>

<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/backtop.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="js/focus_load.js"></script>
<script type="text/javascript"> 
	/* $(function() {
		$('input, textarea').placeholder(); 
		$("#loginForm").validate({
			rules:{
				username:{required : true},
				password:{required : true}
			},
			errorPlacement: function( error, element ) {
				error.insertAfter( element.parent() );
			}
		});
		alert("finish")
		
	}); */
	/* $().ready(function(){
		//debugger;
		$("#loginForm").validate({
			rules:{
				username:{required : true,minlength:5,maxlength:10},
				password:{required : true,minlength:5,maxlength:10}
			},
			message:{
				username:"用户名不能为空",
				password:"密码不能为空"
			},
			errorPlacement: function( error, element ) {
				error.insertAfter( element.parent() );
			}
		});
		//alert("finish");
	}); */
</script>
</head>

<body onload="OnLoad()">

<%@ include file="qq.jsp"%>

<%@ include  file="topFrame.jsp"%>

<div id="main_frame">
<form action="login" name="loginForm" method="post" id="loginForm">
	<div class="div_login_left">
    	<div class="div_login_sub1">
        	登录&nbsp;&nbsp;${msg }
        </div>
    	<div class="div_login_sub2">
			<div class="div_login_sub2a">
            	<div class="div_login_sub2as">
            		
                    <input name="username" type="text" class="input_login1" placeholder="帐户" />
                    <input name="password" type="password" class="input_login1" placeholder="密码" />   
                    
				</div>
            </div>
			<div class="div_login_sub2b">
            	<input type="submit" id="btn2" value="登&nbsp;录" class="submit_login" hidefocus="true" onclick="document.forms.loginForm.submit();" />          
            </div>
           	
        </div>
       			<br/>
       	 <div class="div_login_sub3">
        	<input type="radio" name="userkind" value="2" checked="checked"/>&nbsp;个人用户&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="userkind" value="3"/>企业用户
        </div>
        	<br/>
    	<div class="div_login_sub3">
        	<input type="checkbox" />&nbsp;自动登录&nbsp;&nbsp;|&nbsp;&nbsp;忘记密码
        </div>
	</div>
	</form>
	<div class="div_login_right">
    	<div class="div_login_sub1">
        	加入我们
        </div>
    	<div class="div_login_sub4">
        	现在可以简单、快速的成为会员！<br />
            加入会员后可以享受我们提供的快捷服务！<br />
            <input type="button" id="btn2" value="注册" class="submit_login1" hidefocus="true" onclick="window.location.href='registerForm'" />
        </div>
	</div>
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