<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>librarian_SearchFine</title>
</head>
<body>
		<form action="displayreaderfine"method="post">
		<table border="1" width="100%">
				<tr>
					<th>BookID</th>
					<th>BookName</th>
					<th>FineValue</th>
					<th>Fine</th>
					<th>isPayfine</th>
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
</body>
</html>