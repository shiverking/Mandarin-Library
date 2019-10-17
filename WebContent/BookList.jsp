<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Display_Edit_Delete_Book</title>
</head>
<body>
	<s:if test="books==null"><s:action  name="displayBooks" namespace="/" executeResult="true"></s:action></s:if>
    <s:if test="books!=null">
	<div id="a"> 	
	<td><a href="addBookPage">AddBook</a>
	<form action="displayBooks" method="post">
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
      <th width="666" align="center">Bar Code</th>
      <th width="281" align="center">Operation</th>
    </tr>
    <s:iterator value="books">
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
      <td align="center"><img src="https://barcode.tec-it.com/barcode.ashx?data=<s:property value="ISBN"/>&code=Code128&dpi=96&dataseparator=&tdsourcetag=s_pctim_aiomsg"/></td>
      
      <td><a href='editBook?book.BookID=<s:property value="BookID"/>'>Edit/</a><a  href='deleteBook?book.BookID=<s:property value="BookID"/>'>Delete</a>
      </td>
    </tr>
   </s:iterator>
   </s:if>
   </table>
   </form>  
</div>
</body>
</html>