<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ForgetPassword</title>
</head>
<body>
	<h6>请输入您的邮箱:</h6>
	<form action="forgetReaderPassword" method="post">
		<div>
			<input name="Email" type="email" placeholder="输入邮箱" required>
			<div>
				<button type="submit">提交</button>
			</div>
		</div>
	</form>
</body>
</html>