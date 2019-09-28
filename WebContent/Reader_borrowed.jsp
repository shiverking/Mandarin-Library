<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>test</title>
<style>
#v-pills-tab {
	position: sticky;
	top: 5.5rem;
}
</style>
</head>

<body class="bg-secondary">

	<div class="container">
		<s:include value="Reader_Navbar.jsp" />

		<div class="row">
			<div class="col-2 mt-8">
				<div
					class="nav navbar flex-column nav-pills shadow p-3 mb-5 bg-white rounded"
					id="v-pills-tab" role="tablist" aria-orientation="vertical">
					<a class="nav-link active" id="v-pills-Current-tab"
						data-toggle="pill" href="#v-pills-Current" role="tab"
						aria-controls="v-pills-Current" aria-selected="true">Borrow
						history</a> <a class="nav-link" id="v-pills-History-tab"
						data-toggle="pill" href="#v-pills-History" role="tab"
						aria-controls="v-pills-History" aria-selected="false">Return
						history </a> <a class="nav-link" id="v-pills-messages-tab"
						data-toggle="pill" href="#v-pills-messages" role="tab"
						aria-controls="v-pills-messages" aria-selected="false">Messages   </a>
					<a class="nav-link" id="v-pills-settings-tab" data-toggle="pill"
						href="#v-pills-settings" role="tab"
						aria-controls="v-pills-settings" aria-selected="false">Settings</a>
				</div>
			</div>
			<div class="col-10 mt-8">
				<div class="tab-content bg-light" id="v-pills-tabContent rounded">
					<div class="tab-pane fade show active" id="v-pills-Current"
						role="tabpanel" aria-labelledby="v-pills-Current-tab">
						<table
							class="table container table-hover main-contents table-responsive-sm mt-8 ">
							<thead class="thead-light">
								<tr>
									<th class="table-title" scope="col">BookID</th>
									<th class="table-title" scope="col">BookName</th>
									<th class="table-title" scope="col">Borrow Date</th>
									<th class="table-title" scope="col">Category</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="borrowrecords" status="L">
									<s:if test="isReturn==0">
										<tr>
											<td><s:property value="bookID" /></td>
											<td><s:property value="books[#L.index].BookName" /></td>
											<td><s:property value="borrowingDate" /></td>
											<td><s:property value="books[#L.index].Category" /></td>
										</tr>
									</s:if>
								</s:iterator>
							</tbody>
						</table>
					</div>
					<div class="tab-pane fade" id="v-pills-History" role="tabpanel"
						aria-labelledby="v-pills-History-tab">
						<table
							class="table container table-hover main-contents table-responsive-sm mt-8">
							<thead class="thead-light">
								<tr>
									<th class="table-title" scope="col">BookID</th>
									<th class="table-title" scope="col">BookName</th>
									<th class="table-title" scope="col">Borrow Date</th>
									<th class="table-title">Return Date</th>
									<th class="table-title" scope="col">Category</th>
									<th class="table-title">Fine</th>
								</tr>
							</thead>
							<tbody>

								<s:iterator value="borrowrecords" status="L">
									
										<s:if test="isReturn!=0">
											<tr>
												<td><s:property value="bookID" /></td>
												<td><s:property value="books[#L.index].BookName" /></td>
												<td><s:property value="borrowingDate" /></td>
												<td><s:property value="returnDate" /></td>
												<td><s:property value="books[#L.index].Category" /></td>
												<s:if test="fine!=0">
													<td><s:property value="fine" /></td>
												</s:if>
											</tr>
										</s:if>
								
								</s:iterator>
							</tbody>
						</table>
					</div>
					<div class="tab-pane fade" id="v-pills-messages" role="tabpanel"
						aria-labelledby="v-pills-messages-tab">...</div>
					<div class="tab-pane fade" id="v-pills-settings" role="tabpanel"
						aria-labelledby="v-pills-settings-tab">...</div>
				</div>
			</div>
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
