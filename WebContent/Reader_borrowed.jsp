<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>login</title>
</head>
<body>
	<div class="row">
		<table class="table container table-hover main-contents mt-4">
			<thead>
				<tr>
					<th class="table-title" scope="col">BookID</th>
					<th class="table-title" scope="col">BookName</th>
					<th class="table-title" scope="col">Borrow Date</th>
					<th class="table-title" scope="col">Category</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="borrowrecords" status="L">
					<tr>
						<td><s:property value="bookID" /></td>
						<td><s:property value="booknameList[#L.index]" /></td>
						<td class="reply-cell"><s:property value="borrowingDate" /></td>
						<td><s:property value="bookID" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>

</body>
</html>
