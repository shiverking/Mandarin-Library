<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<title>带验证的登录表单form</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body class="bg-secondary">

	<div class="container">
		<div class="loginBox">
			<div class="userImage">
				<img src="https://avatars3.githubusercontent.com/u/31076337?s=460&v=4">
			</div>
			<form id="loginForm" action="readersignin" method="post">
				<label>Name:</label> <input type="text" class="input-wrapper"
					name="ReaderName"> <label>Password:</label> <input
					type="password" class="input-wrapper" name="Password">
				<button class="btn btn-primary btn-block" type="submit" value="登录">Login</button>
			</form>
		</div>
	</div>
	<!-- partial -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>