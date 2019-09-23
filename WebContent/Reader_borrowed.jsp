<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<s:iterator value="Borrwedtable" status="L">
					<tr>
						<td><s:property value="title" /></td>
						<td class="reply-cell"><s:property value="replyNum[#L.index]" /></td>
						<td class="timeline-cell"><s:property value="createTime" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>
