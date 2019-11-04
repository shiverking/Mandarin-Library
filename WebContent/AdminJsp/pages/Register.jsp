<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<script src="<%=request.getContextPath()%>/AdminJsp/js/LibrarianName.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function check() {
		document.forms['Register'].action = "librariansignup";
		document.forms['Register'].submit();

	}
</script>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>RoyalUI Admin</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/AdminJsp/vendors/ti-icons/css/themify-icons.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/style/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/AdminJsp/vendors/base/vendor.bundle.base.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/AdminJsp/css/style.css">
<!-- endinject -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/AdminJsp/images/favicon.png" />
</head>

<body>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->
		<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
			<div
				class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
				<a class="navbar-brand brand-logo mr-5"
					href="<%=request.getContextPath()%>/AdminJsp/index.jsp"><img
					src="<%=request.getContextPath()%>/AdminJsp/images/gen.svg"
					class="mr-2" alt="logo" /></a>
			</div>
			<div
				class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
				<button class="navbar-toggler navbar-toggler align-self-center"
					type="button" data-toggle="minimize">
					<span class="ti-view-list"></span>
				</button>
				<script>
					function sh() {
						$("#a1").submit()
					}
				</script>
				<form action="searchLibrarian" id="a1">
					<ul class="navbar-nav mr-lg-2">
						<li class="nav-item nav-search d-none d-lg-block">
							<div class="input-group">
								<div class="input-group-prepend hover-cursor"
									id="navbar-search-icon">
									<span class="input-group-text" id="search"> <a
										onclick="sh()"> <i class="ti-search"></i>
									</a>
									</span>
								</div>
								<input name="librarian.LibrarianName" type="text"
									class="form-control" id="navbar-search-input"
									placeholder="Search now" aria-label="search"
									aria-describedby="search">
							</div>
						</li>
					</ul>
				</form>
				<ul class="navbar-nav navbar-nav-right">
				</ul>
				<button
					class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
					type="button" data-toggle="offcanvas">
					<span class="ti-view-list"></span>
				</button>
			</div>
		</nav>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:<%=request.getContextPath()%>/AdminJsp/<%=request.getContextPath()%>/AdminJsp/partials/_sidebar.html -->

			<nav class="sidebar sidebar-offcanvas" id="sidebar">
				<ul class="nav">
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/AdminJsp/index.jsp"> <i
							class="ti-shield menu-icon"></i> <span class="menu-title">HomePage</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/AdminJsp/pages/Register.jsp">
							<i class="ti-layout-list-post menu-icon"></i> <span
							class="menu-title">Librarian_Register</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/AdminJsp/pages/EditLibrarian.jsp">
							<i class="ti-view-list-alt menu-icon"></i> <span
							class="menu-title">Librarians</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/AdminJsp/pages/EditLibrarian.jsp">
							<i class="ti-settings menu-icon"></i> <span class="menu-title">Modify
								Deposit</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/Mandarin-Library/AdminJsp/pages/ChangePassword.jsp"> <i
							class="ti-settings menu-icon"></i> <span class="menu-title">Change
								Password</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/AdminJsp/pages/Edit.jsp">
							<i class="ti-settings menu-icon"></i> <span class="menu-title">Edit
								fines and return period</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="logout"> <i
							class="ti-settings menu-icon"></i> <span class="menu-title">Log
								out</span>
					</a></li>
				</ul>
			</nav>

			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Register a librarian</h4>
									<form action="librariansignup" name="Register"
										class="forms-sample" method="post">
										<div class="form-group">
											<label for="exampleInputUsername1">Username</label> <input
												type="text" class="form-control" id="exampleInputUsername1"
												placeholder="Username" name="LibrarianName">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Email</label> <input
												type="email" class="form-control" id="exampleInputEmail1"
												placeholder="Email" name="Email">
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Password</label> <input
												type="password" class="form-control"
												id="exampleInputPassword1"
												placeholder="Password, the default password is 00010001"
												name="Password">
										</div>
										<div class="form-group">
											<label for="exampleInputConfirmPassword1">Confirm
												Password</label> <input type="password" class="form-control"
												id="exampleInputConfirmPassword1" placeholder="Password"
												name="ConfirmPassword">
										</div>
										<input type="submit" class="btn btn-primary mr-2"
											value="signup">
									</form>

								</div>
							</div>
						</div>
					</div>
					<div id="toast" style="position: absolute; margin-bottom: 50px;">
						<div id="img">
							<i class="fas fa-exclamation-circle"></i>
						</div>
						<p id="desc"></p>
					</div>
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
						if ("<s:property value="errorMessage"></s:property>" == "") {
							console.log("no error");
						} else {
							launch_toast();
						}
					})();
				</script>
				<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
				<script
					src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
				<script
					src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
				<!-- content-wrapper ends -->
				<!-- partial:<%=request.getContextPath()%>/AdminJsp/<%=request.getContextPath()%>/AdminJsp/partials/_footer.html -->
				<footer class="footer">
					<div
						class="d-sm-flex justify-content-center justify-content-sm-between">
						<span
							class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright
							© 2019 <a href="https://www.templatewatch.com/" target="_blank">Templatewatch</a>.
							All rights reserved.
						</span>
					</div>
				</footer>
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script
		src="<%=request.getContextPath()%>/AdminJsp/<%=request.getContextPath()%>/AdminJsp/vendors/base/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script
		src="<%=request.getContextPath()%>/AdminJsp/<%=request.getContextPath()%>/AdminJsp/js/off-canvas.js"></script>
	<script
		src="<%=request.getContextPath()%>/AdminJsp/<%=request.getContextPath()%>/AdminJsp/js/hoverable-collapse.js"></script>
	<script
		src="<%=request.getContextPath()%>/AdminJsp/<%=request.getContextPath()%>/AdminJsp/js/template.js"></script>
	<script
		src="<%=request.getContextPath()%>/AdminJsp/<%=request.getContextPath()%>/AdminJsp/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script
		src="<%=request.getContextPath()%>/AdminJsp/<%=request.getContextPath()%>/AdminJsp/js/file-upload.js"></script>
	<!-- End custom js for this page-->

</body>
</html>