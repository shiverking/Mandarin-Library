<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sign in</title>
</head>
<body>
	<form action="readersignin" method="post">
		ReaderName<input type="text" name="ReaderName"><br> 
		Password<input type="password" name="Password"><br>
		<button type="submit" value="signin" >登录</button>
	</form>
</body>
</html>