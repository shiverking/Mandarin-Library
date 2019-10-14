<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Librarian_Return</title>
</head>
<body>

	<div style="margin: 10px auto; text-align: center">
		<h1 align="center">Librarian_Return</h1>
	</div>
	<div style="margin: 10px auto; text-align: center">
		<s:form action="returnBookFindBook" method="post">
		
			<input type="text" placeholder="Input the Return BookID" name="BookID"/>
			&nbsp;
			&nbsp;
			<input type="submit" value="Return" />
		</s:form>
	</div>
</body>
</html>