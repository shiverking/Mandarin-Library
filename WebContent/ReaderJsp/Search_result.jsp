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
<script>
	/* 实现分页页数接受和表单提交的函数 */
	function topage(num) {
		document.getElementById("content").value = "<s:property value="searchContent" />";
		document.getElementById("pagenum").value = num;
		document.getElementById("postPage").submit();
	}
</script>
</head>

<body class="bg-secondary">
<div id="toast">
		<div id="img">
			<i class="fas fa-exclamation-circle"></i>
		</div>
		<p id="desc"></p>
	</div>
	<script>
		function launch_toast() {
			var x = document.getElementById("toast")
			x.className = "show";
			var desc = document.getElementById("desc");
			desc.innerHTML = "<s:property value="errorMessage"></s:property>";
			setTimeout(function() {
				x.className = x.className.replace("show", "");
			}, 2900);
		};

		(function() {
			// your page initialization code here
			// the DOM will be available here
			if ("<s:property value="errorMessage"></s:property>" == "") {
				console.log("no error");
			} else {
				launch_toast();
			}
		})();
	</script>
	<div class="container">
		<s:include value="Reader_Navbar.jsp" />
		<div class="row">
			<div class="col-12">
				<table
					class="table container table-hover bg-light main-contents table-responsive-md mt-8 ">
					<thead class="thead-light">
						<tr>
							<th class="table-title" scope="col">ISBN</th>
							<th class="table-title" scope="col">BookName</th>
							<th class="table-title" scope="col">Location</th>
							<th class="table-title" scope="col">Category</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="bookPage.dataList" status="L">
							<s:if test="isBorrowed!=1">
								<tr>
									<td><s:property value="ISBN" /></td>
									<td><s:property value="bookName" /></td>
									<td><s:property value="Location" /></td>
									<td><s:property value="Category" /></td>
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
											href="javascript:topage(${bookPage.prePageNum})"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
												<span class="sr-only">Previous</span>
										</a></li>
										<s:iterator begin="%{bookPage.beginPageNum}"
											end="%{bookPage.endPageNum}" var="snum">
											<s:if test="#snum == bookPage.currentPage">
												<li class="page-item active" id="page${snum}"><a
													class="page-link" href="javascript:topage(${snum})">${snum}</a></li>
											</s:if>
											<s:else>
												<li class="page-item " id="page${snum}"><a
													class="page-link" href="javascript:topage(${snum})">${snum}</a></li>
											</s:else>
										</s:iterator>
										<li class="page-item"><a class="page-link"
											href="javascript:topage(${bookPage.nextPageNum})"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
												<span class="sr-only">Next</span>
										</a></li>
										<li class="page-item"><a class="page-link"
											href="javascript:topage(${bookPage.totalPage})"
											aria-label="Previous"> <span aria-hidden="true">&rarrb;</span>
												<span class="sr-only">End page</span>
										</a></li>
									</ul>
								</nav>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<form action="searchBook" method="post" id="postPage">
		<s:hidden name="pageNum" type="int" value="" id="pagenum"></s:hidden>
		<s:hidden name="searchContent" type="text" value="" id="content"></s:hidden>
	</form>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>