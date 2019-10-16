<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>librarian</title>
</head>
<body>
		<s:if test="Librarians==null"><s:action  name="displayLibrarians" namespace="/" executeResult="true"></s:action></s:if>
    	<s:if test="Librarians!=null">
    	<form action="displayLibrarians"method="post">
		<table border="1" width="100%">
				<tr>
					<th>LibrarianID</th>
					<th>LibradianName</th>
					<th>Password</th>
					<th>Operation</th>
				</tr>
					<s:iterator value="Librarians">
						<tr>
						<td><s:property value="LibrarianID" /></td>
						<td><s:property value="LibrarianName" /></td>
						<td><s:property value="Password" /></td>
						<td><a href='editLibrarian?librarian.LibrarianID=<s:property value="LibrarianID"/>'>Edit/</a><a  href='deleteLibrarian?librarian.LibrarianID=<s:property value="LibrarianID"/>'>Delete</a>
						</tr>
					</s:iterator>
		</table>
		</form>
		</s:if>
</body>
</html>