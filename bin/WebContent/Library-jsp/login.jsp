<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>LibrarySystem</title>
		<!--
         --@author: WuLiangxu
         --@version:2019/9/23 21:27
         --@description:引入css文件与javascript文件
    	-->
		<link rel="stylesheet" type="text/css" href="login.css"/>
		<script type="text/javascript" src="login.js"></script>
	</head>
	<!--
         --@author: WuLiangxu
         --@version:2019/9/23 21:27
         --@description:登陆界面
    -->
	<body>
		<div id="login_frame">
			<p><img id="image_logo" src="../images/login/logo.png"></p>
			<form action="login.js" method="post">
					<p><label class="label_input">用户名</label><input type="text" id="username" name="username" class="text_field"/></p>
					<p><label class="label_input">密码</label><input type="text" id="password" name="username" class="text_field"/></p>
					<input id="login_control" type="submit" value="登录" onclick="login();"><br>
			</form>
		</div>
	</body>
</html>