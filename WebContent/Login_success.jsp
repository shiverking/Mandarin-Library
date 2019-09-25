<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Congratulation</title>
</head>
<body>
<h1>Login Successfully!</h1>
	<form action="changePassword" method="post">
	Password<input type="password" name="password"><br>
	NewPassword<input type="password" name="NewPassword"><br>
	<button type="submit" value="change">Change</button>
	</form>
	<form action="logout" method="post">
	<button type="submit" value="logout">logout</button>
	</form>
</body>
</html>