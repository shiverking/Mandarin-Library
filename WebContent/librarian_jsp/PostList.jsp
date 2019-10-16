<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PostList</title>
</head>
<body>
	<s:if test="posts==null">
		<s:action name="displayPosts" namespace="/" executeResult="true"></s:action>
	</s:if>
	<s:if test="posts!=null">
		<div id="a">
			<form action="displayPosts" method="post">
			<table>
				<tr>
					<th>PostID</th>
					<th>Title</th>
					<th>Content</th>
					<th>LibrarianName</th>
				</tr>
				<s:iterator value="posts">
					<tr>
						<td><s:property value="PostID" /></td>
						<td><s:property value="Title" /></td>
						<td><s:property value="Content" /></td>
						<td><s:property value="librarian.LibrarianName" /></td>
					</tr>
				</s:iterator>
				</s:if>
			</table>
			</form>
		</div>
</body>
</html>
