<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>    
    <title>EditBook</title>
  </head>  
  <body> 
	<div id="a"> 	
	<s:form action="editBook" method="post">
    <table border="1" width="100%">
    <tr>
      <th width="128" height="25" align="center">BookID</th>
      <th width="157" align="center">BookName</th>
      <th width="147" align="center">ISBN</th>
      <th width="147" align="center">Author</th>
      <th width="147" align="center">Category</th>
      <th width="1470" align="center">Description</th>
      <th width="281" align="center">Price</th>
      <th width="281" align="center">Location</th>
      <th width="281" align="center">IsBorrowed</th>
      <th width="281" align="center">Category</th>
      <th width="281" align="center">Operation</th>
    </tr>
    <s:iterator value="book">
    <tr>
      <td align="center"><s:property value="BookID"/></td>
      <td align="center"><s:property value="BookName"/></td>
      <td align="center"><s:property value="ISBN"/></td>
      <td align="center"><s:property value="Author"/></td>
      <td align="center"><s:property value="Category"/></td>
      <td align="center"><s:property value="Introduction"/></td>
      <td align="center"><s:property value="Price"/></td>
      <td align="center"><s:property value="Location"/></td>
      <td align="center"><s:property value="IsBorrowed"/></td>
      <td align="center"><s:property value="Category"/></td>
      <td><a href='deleteBook?book.BookID=<s:property value="BookID"/>'>Delete</a>
      </td>
    </tr>
   </s:iterator>
    <s:iterator value="book">
    <tr>
      <td align="center"><s:property value="BookID"/></td>
      <td><input type="text" value="<s:property value="BookName"/>" name="BookName"/></td>
      <td align="center"><s:property value="ISBN"/></td>
       <td><input type="text" value="<s:property value="Author"/>" name="Author"/></td>
        <td><input type="text" value="<s:property value="Category"/>" name="Category"/></td>
       <td><input type="text" value="<s:property value="Introduction"/>" name="Introduction"/></td>
      <td><input type="text" value="<s:property value="Price"/>" name="Price"/></td>
      <td><input type="text" value="<s:property value="Location"/>" name="Location"/></td>
      <td><input type="text" value="<s:property value="IsBorrowed"/>" name="IsBorrowed"/></td>
      <td><input type="text" value="<s:property value="Category"/>" name="Category"/></td>
      </td>
    </tr>
   </s:iterator>
   </table>
   <input type="submit" value="Save"/><a href='BookList.jsp'>Return</a>
   </s:form>  
</div>
</body>
</html>