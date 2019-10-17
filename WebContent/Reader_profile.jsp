<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>Profile</title>
</head>
<body>
	<h6>可以修改以下信息</h6>
	<form action="changeReaderName" method="post">
		<div>
			<input name="readerName" type="text" placeholder="输入新的用户名" required>
			<div>
				<button type="submit">点击修改</button>
			</div>
		</div>
	</form>

	<form action="changeReaderPassword" method="post">
		<div>
			<input name="Password" type="password" placeholder="输入新的密码" required>
			<div>
				<button type="submit">点击修改</button>
			</div>
		</div>
	</form>
	
</body>
</html>