<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>

<html lang="en">
<head>

<!-- SITE TITTLE -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BookBorrow</title>

<!-- Bootstrap -->
<link href="plugins/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- Owl Carousel -->
<link href="plugins/slick-carousel/slick/slick.css" rel="stylesheet">
<link href="plugins/slick-carousel/slick/slick-theme.css"
	rel="stylesheet">
<!-- Fancy Box -->
<link href="plugins/fancybox/jquery.fancybox.pack.css" rel="stylesheet">
<link href="plugins/jquery-nice-select/css/nice-select.css"
	rel="stylesheet">
<link
	href="plugins/seiyria-bootstrap-slider/dist/css/bootstrap-slider.min.css"
	rel="stylesheet">
<!-- CUSTOM CSS -->
<link href="css/style.css" rel="stylesheet">

<!-- FAVICON -->
<link href="img/favicon.png" rel="shortcut icon">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

</head>



<body>

	<s:include value="/Navbar.jsp" />

	<!--==================================
=            User Profile            =
===================================-->
	<section class="dashboard section">
		<!-- Container Start -->
		<div class="container">
			<!-- Row Start -->
			<div class="row">
				<div class="col-md-10 offset-md-1 col-lg-4 offset-lg-0">
					<div class="sidebar">
						<!-- User Widget -->
						<div class="widget user-dashboard-profile">
							<!-- User Image -->
							<div class="profile-thumb">
								<img src="images/user/user-thumb.jpg" alt=""
									class="rounded-circle">
							</div>
							<!-- User Name -->
							<h5 class="text-center"><s:property value="#session.librarian.librarianName" /></h5>
							<p>Joined February 06, 2017</p>
						</div>
						<!-- Dashboard Links -->
						<div class="widget user-dashboard-menu">
							<ul>
								<li><a href="BookManagement"><i class="fa fa-book"></i>
										Manage Book </a></li>
								<li><a href="searchBook1"><i class="fa fa-search"></i>
										Search Book</a></li>
								<li class="active"><a href="getAllReaders"><i
										class="fa fa-user-plus"></i> Managing readers </a></li>
								<li><a href="BorrowHistory"><i class="fa fa-history"></i>
										Borrow History</a></li>
								<li><a href="BookBorrow"><i class="fa fa-share"></i>
										Borrow Book</a></li>
								<li><a href="BookReturn"><i class="fa fa-reply"></i>
										Return Book</a></li>
								<li><a href="IncomeHistory"><i class="fa fa-money"></i>
										Income History</a></li>
								<li><a href="displayPosts"><i class="fa fa-paper-plane"></i>
										Post News</a></li>
								<li><a href="displayDeleteRecords"><i class="fa fa-trash-o" aria-hidden="true"></i>
										Deleted Records</a></li>
								<li><a href="librarianLogout"><i class="fa fa-sign-out"></i>
										Logout</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
					<!-- Recently Favorited -->
					<s:if test="errorMessage!=null">
						<div class="alert alert-danger" role="alert">
							<i class="fa fa-exclamation-circle" aria-hidden="true"></i>
							${errorMessage}
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</s:if>
					<div class="widget dashboard-container my-adslist">
						<div class="row">
							<form action="getAllReaders" class="col-10">
								<div class="input-group margin-bottom-sm ">
									<span class="input-group-addon"><i
										class="fa fa-user-o fa-fw"></i></span> <input class="form-control "
										type="email" name="searchContent" placeholder="Search By Reader Email">
									<button type="submit" value="search"
										class="btn btn-main-sm input-group-addon">search</button>
								</div>
							</form>
							<div class="col-2">
								<a data-toggle="modal" data-target="#addReader"
									class="btn btn-main form-control" style="color: #fff;"><i
									class="fa fa-user-plus"></i></a>
							</div>
						</div>
						<hr>
						<s:iterator value="readerPage.dataList" status="L">
							<!-- product card -->
							<div class="product-item bg-light">
								<div class="row">
									<div class="thumb-content col-3">
										<!-- <div class="price">$200</div> -->
										<a> <img class="card-img-top img-fluid"
											src="upload/${ReaderID}.jpg" alt="Reader Avatar"
											onerror="{this.src='images/avatar1.jpg'}"
											style="height: 80px; width: AUTO;">
										</a>
									</div>
									<div class=" col-7">
										<h4 class="card-title">
											<a>${ReaderName}</a>
										</h4>
										<ul class="list product-meta">
											<li class="list-item"><a><i
													class="fa fa-envelope-square fa-fw "> </i>Email: ${Email}</a></li>
											<li class="list-item"><a><i
													class="fa fa-phone fa-fw"> </i>Phone Number: ${PhoneNumber}</a></li>
										</ul>
									</div>
									<div class=" col-1 m-auto">
										<a data-toggle="modal" data-target="#editReader${ReaderID}"><i
											class="fa fa-wrench  fa-flip-horizontal"></i></a> <a
											href="getReaderForDelete?ReaderID=${ReaderID}"><i
											class="fa fa-trash"></i></a>
									</div>
								</div>
							</div>
							<!--editReader模态框-->
							<form action="setreader" method="post">
								<div class="modal fade" id="editReader${ReaderID}" tabindex="-1"
									role="dialog">
									<div class="modal-dialog modal-lg" role="document">
										<div class="modal-content ">
											<div class="modal-header ">
												<h2 class="m-auto">Edit Reader</h2>
											</div>
											<div class="modal-body row justify-content-center">
												<div class="input-group margin-bottom-sm col-10 mb-2">
													<span class="input-group-addon"><i
														class="fa fa-user-o fa-fw"></i></span> <input
														class="form-control " type="text" name="ReaderName"
														value="${ReaderName}" placeholder="username ">
												</div>
												<div class="input-group margin-bottom-sm col-5  mb-2">
													<span class="input-group-addon "><i
														class="fa fa-key fa-fw"></i></span> <input class="form-control"
														type="password" name="Password" placeholder="Password">
												</div>
												<div class="input-group margin-bottom-sm col-5 mb-2">
													<span class="input-group-addon "><i
														class="fa fa-key fa-fw"></i></span> <input class="form-control"
														type="password" name="ConfirmPassword"
														placeholder="confirm your password">
												</div>
												<div class="input-group margin-bottom-sm col-10 mb-2">
													<span class="input-group-addon "><i
														class="fa fa-envelope-o fa-fw"></i></span> <input
														value="${Email}" class="form-control" type="email"
														name="Email" placeholder="Email">
												</div>
												<div class="input-group margin-bottom-sm col-10 mb-2">
													<span class="input-group-addon "><i
														class="fa fa-phone fa-fw"></i></span> <input class="form-control"
														type="text" name="PhoneNumber" maxlength="11"
														value="${PhoneNumber}" placeholder="phone number">
												</div>
												<input value="${ReaderID}" name="ReaderID"
													style="display: none">
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Close</button>
												<button type="submit" class="btn btn-primary">changes</button>
											</div>
										</div>
									</div>
								</div>
							</form>
						</s:iterator>
						<s:if test="readerPage.datalist.size()>0">
							<div class="pagination justify-content-center">
								<nav aria-label="Page navigation example">
									<ul class="pagination">
										<!--前往上一页的按钮-->
										<li class="page-item"><a class="page-link"
											href="getAllReaders?pageNum=${readerPage.prePageNum}"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
												<span class="sr-only">Previous</span>
										</a></li>
										<!--显示前往第一页的按钮-->
										<s:if test="readerPage.beginPageNum>1">
											<li class="page-item"><a class="page-link"
												href="getAllReaders?pageNum=1">1</a></li>
											<s:if test="readerPage.beginPageNum>2">
												<li class="page-item"><a class="page-link">....</a></li>
											</s:if>
										</s:if>
										<!-- 显示以当前页为中心的7页 -->
										<s:iterator begin="%{readerPage.beginPageNum}"
											end="%{readerPage.endPageNum}" var="snum">
											<s:if test="#snum == readerPage.currentPage">
												<li class="page-item active"><a class="page-link"
													href="getAllReaders?pageNum=${snum}">${snum}</a></li>
											</s:if>
											<s:else>
												<li class="page-item"><a class="page-link"
													href="getAllReaders?pageNum=${snum}">${snum}</a></li>
											</s:else>
										</s:iterator>
										<!-- 显示最后一页 -->
										<s:if test="readerPage.endPageNum<readerPage.totalPage">

											<s:if test="readerPage.endPageNum+1<readerPage.totalPage">
												<li class="page-item"><a class="page-link">....</a></li>
											</s:if>
											<li class="page-item"><a class="page-link"
												href="getAllReaders?&pageNum=${readerPage.totalPage}">${readerPage.totalPage}</a></li>
										</s:if>
										<!-- 前往下一页的按钮-->
										<li class="page-item"><a class="page-link"
											href="getAllReaders?pageNum=${readerPage.nextPageNum}"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
												<span class="sr-only">Next</span>
										</a></li>
									</ul>
								</nav>
							</div>
						</s:if>
						<!--addReader模态框-->

						<form action="readerregister" method="post">
							<div class="modal fade" id="addReader" tabindex="-1"
								role="dialog" style="position: fixed; top: 18%">
								<div class="modal-dialog " role="document">
									<div class="modal-content">
										<div class="modal-header ">
											<h2 class="m-auto">Reader Register</h2>
										</div>
										<div class="modal-body">
											<div class="modal-body row justify-content-center">
												<div class="input-group margin-bottom-sm col-10 mb-2">
													<span class="input-group-addon"><i
														class="fa fa-user-o fa-fw"></i></span> <input
														class="form-control " type="text" name="ReaderName"
														placeholder="username ">
												</div>
												<div class="input-group margin-bottom-sm col-10 mb-2">
													<span class="input-group-addon "><i
														class="fa fa-envelope-o fa-fw"></i></span> <input
														class="form-control" type="email" name="Email"
														placeholder="Email">
												</div>
												<div class="input-group margin-bottom-sm col-10 mb-2">
													<span class="input-group-addon "><i
														class="fa fa-phone fa-fw"></i></span> <input class="form-control"
														type="text" name="PhoneNumber" maxlength="11"
														placeholder="phone number">
												</div>
												<input value="${ReaderID}" name="ReaderID"
													style="display: none">
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
											<button type="submit" class="btn btn-primary">submit</button>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- Row End -->
		</div>
		<!-- Container End -->
	</section>
	<s:include value="/footer.jsp" />
	<!-- JAVASCRIPTS -->
	<script src="plugins/jquery/dist/jquery.min.js"></script>
	<script src="plugins/tether/js/tether.min.js"></script>
	<script src="plugins/raty/jquery.raty-fa.js"></script>
	<script src="plugins/bootstrap/dist/js/popper.min.js"></script>
	<script src="plugins/bootstrap/dist/js/bootstrap.min.js"></script>
	<script
		src="plugins/seiyria-bootstrap-slider/dist/bootstrap-slider.min.js"></script>
	<script src="plugins/slick-carousel/slick/slick.min.js"></script>
	<script src="plugins/jquery-nice-select/js/jquery.nice-select.min.js"></script>
	<script src="plugins/fancybox/jquery.fancybox.pack.js"></script>
	<script src="plugins/smoothscroll/SmoothScroll.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw"></script>
	<script src="js/scripts.js"></script>

</body>

</html>