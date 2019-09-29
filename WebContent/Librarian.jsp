<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>librarian</title>
</head>
<body>
		<table>
				<tr>
					<th>LibrarianID</th>
					<th>LibradianName</th>
					<th>Password</th>
				</tr>
				<tbody>
					<s:iterator value="Librarains">
						<tr>
						<td><s:property value="LibrarianID" /></td>
						<td><s:property value="LibrarianName" /></td>
						<td><s:property value="Password" /></td>
						</tr>
					</s:iterator>
				</tbody>
		</table>
</body>
</html>