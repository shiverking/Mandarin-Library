<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Display_Payreord</title>
</head>
<body>
	<s:if test="payrecords==null"><s:action  name="displayPayrecords" namespace="/" executeResult="true"></s:action></s:if>
    <s:if test="payrecords!=null">
	<div id="a"> 	
	<td>
	<form action="displayPayrecords" method="post">
    <table border="1" width="100%">
    <tr>
      <th width="128" height="25" align="center">PayrecordID</th>
      <th width="157" align="center">Date</th>
      <th width="147" align="center">Type</th>
      <th width="281" align="center">Amount</th>
    </tr>
    <s:iterator value="payrecords">
    <tr>
      <td align="center"><s:property value="PayrecordID"/></td>
      <td align="center"><s:property value="Date"/></td>
      <td align="center"><s:property value="Type"/></td>
      <td align="center"><s:property value="Amount"/></td>
    </tr>
   </s:iterator>
   </s:if>
   </table>
   </form>  
</div>
</body>
</html>