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

<script>
	/* 实现分页页数接受和表单提交的函数 */
	function topage(num) {
		document.getElementById("pagenum").value = num;
		document.getElementById("postPage").submit();
	}
</script>
</head>

<body class="bg-secondary">
	<s:include value="Reader_Navbar.jsp" />
	<div class="container">
		<div class="row">

			<div class="col-12 col-sm-4 col-md-3 col-lg-2 mt-8">
				<div
					class="nav flex-column nav-pills shadow p-3 mb-5 bg-white rounded text-center"
					id="v-pills-tab" role="tablist" aria-orientation="vertical">
					<a class="nav-link active" id="v-pills-Current-tab"
						data-toggle="pill" href="#v-pills-Current" role="tab"
						aria-controls="v-pills-Current" aria-selected="true">Borrow
						history</a> <a class="nav-link" id="v-pills-History-tab"
						data-toggle="pill" href="#v-pills-History" role="tab"
						aria-controls="v-pills-History" aria-selected="false">Return
						history </a> <a class="nav-link" id="v-pills-messages-tab"
						data-toggle="pill" href="#v-pills-messages" role="tab"
						aria-controls="v-pills-messages" aria-selected="false">Messages
					</a> <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill"
						href="#v-pills-settings" role="tab"
						aria-controls="v-pills-settings" aria-selected="false">Settings</a>
				</div>
			</div>
			<div class="col-12 col-sm-8 col-md-9 col-lg-10 mt-8">
				<div class="tab-content bg-light" id="v-pills-tabContent rounded">
					<div class="tab-pane fade show active" id="v-pills-Current"
						role="tabpanel" aria-labelledby="v-pills-Current-tab">
						<table
							class="table container table-hover main-contents table-responsive-md mt-8 ">
							<thead class="thead-light">
								<tr>
									<th class="table-title" scope="col">BookID</th>
									<th class="table-title" scope="col">BookName</th>
									<th class="table-title" scope="col">Borrow Date</th>
									<th class="table-title" scope="col">Category</th>
								</tr>
							</thead>
							<tbody>

								<s:iterator value="borrowPage.datalist" status="L">
									<s:if test="isReturn==0">
										<tr>
											<td><s:property value="bookID" /></td>
											<td><s:property value="books[#L.index].BookName" /></td>
											<td><s:property value="borrowingDate" /></td>
											<td><s:property value="books[#L.index].Category" /></td>
										</tr>
									</s:if>
								</s:iterator>
								<!-- 显示分页信息和触发分页功能的表格 -->
								<tr>
									<td colspan="4">
										<nav aria-label="Page navigation example">
											<ul class="pagination justify-content-center">
												<li class="page-item"><a class="page-link"
													href="javascript:topage(1)" aria-label="Previous"> <span
														aria-hidden="true">&larrb;</span> <span class="sr-only">First
															page</span>
												</a></li>
												<li class="page-item"><a class="page-link"
													href="javascript:topage(${borrowPage.prePageNum})"
													aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
														<span class="sr-only">Previous</span>
												</a></li>
												<s:iterator begin="%{borrowPage.beginPageNum}"
													end="%{borrowPage.endPageNum}" var="snum">
													<s:if test="#snum == borrowPage.currentPage">
														<li class="page-item active" id="page${snum}"><a
															class="page-link" href="javascript:topage(${snum})">${snum}</a></li>
													</s:if>
													<s:else>
														<li class="page-item " id="page${snum}"><a
															class="page-link" href="javascript:topage(${snum})">${snum}</a></li>
													</s:else>
												</s:iterator>

												<li class="page-item"><a class="page-link"
													href="javascript:topage(${borrowPage.nextPageNum})"
													aria-label="Next"> <span aria-hidden="true">&raquo;</span>
														<span class="sr-only">Next</span>
												</a></li>
												<li class="page-item"><a class="page-link"
													href="javascript:topage(${borrowPage.totalPage})"
													aria-label="Previous"> <span aria-hidden="true">&rarrb;</span>
														<span class="sr-only">End page</span>
												</a></li>
											</ul>
										</nav>
									</td>
								</tr>
								<!-- 显示分页信息和触发分页功能的表格 -->
							</tbody>
						</table>

						<!-- 用于提交页数的表单 -->
						<form action="getReaderStatuForBorrowPage" method="post"
							id="postPage">
							<s:hidden name="pageNum" type="int" value="" id="pagenum"></s:hidden>
						</form>
						<!-- 用于提交页数的表单 -->

					</div>
					<div class="tab-pane fade" id="v-pills-History" role="tabpanel"
						aria-labelledby="v-pills-History-tab">
						<table
							class="table container table-hover main-contents table-responsive-lg mt-8">
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

								<s:iterator value="borrowPage.dataList" status="L">

									<s:if test="isReturn!=0">
										<tr>
											<td><s:property value="bookID" /></td>
											<td><s:property value="books[#L.index].BookName" /></td>
											<td><s:property value="borrowingDate" /></td>
											<td><s:property value="returnDate" /></td>
											<td><s:property value="books[#L.index].Category" /></td>
											<td><s:if test="fine!=0">
													<s:property value="fine" />¥</s:if></td>
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
