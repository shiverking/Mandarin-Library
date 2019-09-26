<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>RESULT</title>

</head>

<body>
<div class="container">
<s:include value="Reader_Navbar.jsp" />
<s:property value="tempReader.ReaderID" />
	<div class="row">
		<table
			class="table container table-hover main-contents table-responsive-sm mt-8">
			<thead class="thead-light">
				<tr>
					<th class="table-title" scope="col">BookID</th>
					<th class="table-title" scope="col">BookName</th>
					<th class="table-title" scope="col">Location</th>
					<th class="table-title" scope="col">Category</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="books" status="L">
					<s:if test="isBorrowed!=1">
						<tr>
						
							<td><s:property value="bookID" /></td>
							<td><s:property value="bookName" /></td>
							<td><s:property value="Location" /></td>
							<td><s:property value="Category" /></td>
						
						</tr>
					</s:if>
				</s:iterator>
			</tbody>
		</table>
	</div>
	</div>
	
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>