<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>RESULT</title>
</head>

<body>
	<div class="row">
		<table class="table container table-hover main-contents mt-4">
			<tbody>

				<s:iterator value="books" status="L">

					<tr>
						<td><s:property value="bookID" /></td>
						<td><s:property value="bookName" /></td>
					</tr>

				</s:iterator>
				
			</tbody>
		</table>
	</div>

</body>
</html>