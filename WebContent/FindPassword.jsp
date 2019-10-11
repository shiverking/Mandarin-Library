<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find the librarian password</title>
</head>
<body>
	<form action="findPassword" method="post">
	Username<input type="text" name="librarian.LibrarianName"><br>
	<button type="submit" value="find">Find</button>
	</form>
</body>
</html>