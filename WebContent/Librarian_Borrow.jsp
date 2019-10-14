<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Librarian_Borrow</title>
</head>
<body>

	<div style="margin: 10px auto; text-align: center">
		<h1 align="center">Librarian_Borrow</h1>
	</div>
	<div style="margin: 10px auto; text-align: center">
		<s:form action="borrowBookFindReader" method="post">
			<input type="text" placeholder="Input the ReaderID" name="ReaderID"/>
			&nbsp;
			&nbsp;
			<input type="text" placeholder="Input the BookID" name="BookID"/>
			&nbsp;
			&nbsp;
			<input type="submit" value="Borrow" />
		</s:form>
	</div>
</body>
</html>