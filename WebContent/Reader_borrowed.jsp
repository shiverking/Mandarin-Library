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
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.css">
<title>test</title>
<style>
#v-pills-tab{
position:sticky;
top:3rem;
}

</style>
</head>
<body>

	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top ">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>

			</ul>
			<form class="form-inline my-2 my-lg-0">
			
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search by title or ISBN" aria-label="Search">

				<div class="btn-group" role="group">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					<button id="btnGroupDrop1" type="button"
						class="btn btn-outline-success dropdown-toggle my-2 my-sm-0" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Dropdown</button>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="btnGroupDrop1">
						<button class="dropdown-item" href="#">Dropdown link</button>
						<div class="dropdown-divider"></div>
						<button class="dropdown-item" href="#">Dropdown link</button>
					</div>
				</div>
			</form>


		</div>
	</nav>
	
		<div class="row">
			<div class="col-3 mt-8 ">
				<div class="nav flex-column nav-pills " id="v-pills-tab"
					role="tablist" aria-orientation="vertical" >
					<a class="nav-link active" id="v-pills-Current-tab" data-toggle="pill"
						href="#v-pills-Current" role="tab" aria-controls="v-pills-Current"
						aria-selected="true">Current Borrowing</a> 
					<a class="nav-link" id="v-pills-History-tab" data-toggle="pill"
						href="#v-pills-History" role="tab" aria-controls="v-pills-History"
						aria-selected="false">Borrowing History</a> 
					<a class="nav-link" id="v-pills-messages-tab" data-toggle="pill"
						href="#v-pills-messages" role="tab"
						aria-controls="v-pills-messages" aria-selected="false">Messages</a>
					<a class="nav-link" id="v-pills-settings-tab" data-toggle="pill"
						href="#v-pills-settings" role="tab"
						aria-controls="v-pills-settings" aria-selected="false">Settings</a>
				</div>
			</div>
			<div class="col-9 mt-8">
				<div class="tab-content" id="v-pills-tabContent">
					<div class="tab-pane fade show active" id="v-pills-Current"
						role="tabpanel" aria-labelledby="v-pills-Current-tab">
						<table class="table container table-hover main-contents mt-8">
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
									<s:if test="isReturn==0">
										<tr>
											<td><s:property value="bookID" /></td>
											<td><s:property value="booknameList[#L.index]" /></td>
											<td class="reply-cell"><s:property value="borrowingDate" /></td>
											<td><s:property value="bookID" /></td>
										</tr>
									</s:if>
								</s:iterator>
							</tbody>
						</table>
					</div>
					<div class="tab-pane fade" id="v-pills-History" role="tabpanel"
						aria-labelledby="v-pills-History-tab">
						<table class="table container table-hover main-contents mt-8">
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
									<s:if test="isReturn!=0">
										<tr>
											<td><s:property value="bookID" /></td>
											<td><s:property value="booknameList[#L.index]" /></td>
											<td class="reply-cell"><s:property value="borrowingDate" /></td>
											<td><s:property value="bookID" /></td>
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
	<script src="https://code.jquery.com/jquery-3.3.1.slim.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.js"></script>
</body>

</html>
