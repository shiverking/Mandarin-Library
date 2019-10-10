<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin_Display_Book</title>
</head>
<body>
	<s:if test="books==null"><s:action  name="adminDisplayBooks" namespace="/" executeResult="true"></s:action></s:if>
    <s:if test="books!=null">
    <form action="adminDisplayBooks" method="post">
    <table border="1" width="100%">
    <tr>
      <th width="128" height="25" align="center">BookID</th>
      <th width="157" align="center">BookName</th>
      <th width="147" align="center">ISBN</th>
      <th width="281" align="center">ReturnPeriod</th>
      <th width="281" align="center">FineValue</th>
      <th width="281" align="center">Operation</th>
    </tr>
    <s:iterator value="books">
    <tr>
      <td align="center"><s:property value="BookID"/></td>
      <td align="center"><s:property value="BookName"/></td>
      <td align="center"><s:property value="ISBN"/></td>
      <td align="center"><s:property value="ReturnPeriod"/></td>
      <td align="center"><s:property value="FineValue"/></td>
      <td align="center"><a href='adminEditBook?book.BookID=<s:property value="BookID"/>'>Edit</a>
      </td>
    </tr>
    </s:iterator>
    </table>
    </form>
    </s:if>
</body>
</html>