<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<title>EditLibrarian</title>
</head>
<body>
	<div id="a"> 	
	<s:form action="editLibrarian" method="post">
    <table border="1" width="100%">
    <tr>
		<th>LibrarianID</th>
		<th>LibradianName</th>
		<th>Password</th>
		<th>Operation</th>      
    </tr>
    <s:iterator value="librarian">
    <tr>
      <td align="center"><s:property value="LibrarianID"/></td>
      <td align="center"><s:property value="LibrarianName"/></td>
      <td align="center"><s:property value="Password"/></td>
      <td><a href='deleteBook?book.BookID=<s:property value="BookID"/>'>Delete</a></td>
    </tr>
   </s:iterator>
    <s:iterator value="librarian">
    <tr>
      <td align="center"><s:property value="LibrarianID"/></td>
      <td><input type="text" value="<s:property value="LibrarianName"/>" name="LibrarianName"/></td>
      <td><input type="text" value="<s:property value="Password"/>" name="Password"/></td>
    </tr>
   </s:iterator>
   </table>
   <input type="submit" value="Save"/><a href='Librarian.jsp'>Return</a>
   </s:form>  
</div>

</body>
</html>