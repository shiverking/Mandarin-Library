<%@ page language="java" contentType="text/html; charset=UTf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify the Reader Security Deposit</title>
</head>
<body>
	<s:if test="NewSecurityDeposit==null"><s:action name="dmodify" namespace="/" executeResult="true"></s:action></s:if>
	<s:if test="NewSecurityDeposit!=null">
	<form action="modify" method="post">
		<table border="1">
			<tr>
				<th>The Reader Security Deposit</th>
				<th>New Reader Security Deposit</th>
			</tr>
			<tr>
				<td><s:property value="Deposit"/></td>
				<td><input type="text" name="NewSecurityDeposit"></td>
			</tr>
		</table>
		<input type="submit" value="save">
		</form>
		</s:if>
</body>
</html>