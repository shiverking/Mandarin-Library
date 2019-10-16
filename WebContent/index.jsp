<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Index</title>
</head>
<body>
	<s:if test="posts==null"><s:action  name="displayPosts" namespace="/" executeResult="true"></s:action></s:if>
    <s:if test="posts!=null">
    <form action="displayPosts" method="post"></form>
	<table>
    <tr>
        <th>PostID</th> 
        <th>Title</th>
        <th>Content</th>
        <th>Librarian</th>
    </tr>    
	<s:iterator value="posts">
    <tr>
        <td><s:property value="PostID"/></td>
        <td><s:property value="Title"/></td>
        <td><s:property value="Content"/></td>
        <td><s:property value="librarian.librarianName"/></td> 
    </tr>
	</s:iterator>
	</s:if>
 	</table>
 	</form>
</body>
</html>
