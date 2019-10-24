                    s<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>AdminEditBook</title>
</head>
<body>
	<div id="a"> 	
	<s:form action="adminEditBook" method="post">
    <table border="1" width="100%">
    <tr>
      <th width="128" height="25" align="center">BookID</th>
      <th width="157" align="center">BookName</th>
      <th width="147" align="center">ISBN</th>
      <th width="281" align="center">ReturnPeriod</th>
      <th width="281" align="center">FineValue</th>
    </tr>
    <s:iterator value="book">
    <tr>
      <td align="center"><s:property value="BookID"/></td>
      <td align="center"><s:property value="BookName"/></td>
      <td align="center"><s:property value="ISBN"/></td>
      <td align="center"><s:property value="ReturnPeriod"/></td>
      <td align="center"><s:property value="FineValue"/></td>
      </td>
    </tr>
   </s:iterator>
    <s:iterator value="book">
    <tr>
      <td align="center"><s:property value="BookID"/></td>
      <td align="center"><s:property value="BookName"/></td>
      <td align="center"><s:property value="ISBN"/></td>
      <td><input type="text" value="<s:property value="ReturnPeriod"/>" name="ReturnPeriod"/></td>
      <td><input type="text" value="<s:property value="FineValue"/>" name="FineValue"/></td>
      </td>
    </tr>
   </s:iterator>
   </table>
   <input type="submit" value="Save"/><a href='Admin_Display_Book.jsp'>Return</a>
   </s:form>  
</div>
</body>
</html>