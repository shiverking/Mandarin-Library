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
	<script src="webapp/ckeditor.js"></script>
</head>



<body>

	<s:include value="/Navbar.jsp" />
	<s:include value="/librarian_jsp/PostSingleNews.jsp"></s:include>
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
								<li><a href="getAllReaders"><i class="fa fa-user-plus"></i>
										Managing readers </a></li>
								<li><a href="BorrowHistory"><i class="fa fa-history"></i>
										Borrow History</a></li>
								<li><a href="BookBorrow"><i class="fa fa-share"></i>
										Borrow Book</a></li>
								<li><a href="BookReturn"><i class="fa fa-reply"></i>
										Return Book</a></li>
								<li><a href="IncomeHistory"><i class="fa fa-money"></i>
										Income History</a></li>
								<li class="active"><a href="displayPosts"><i
										class="fa fa-paper-plane"></i> Post News</a></li>
								<li><a href="librarianLogout"><i class="fa fa-sign-out"></i>
										Logout</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
					<!-- Recently Favorited -->
					<div class="widget dashboard-container my-adslist">
						<a data-toggle="modal" data-target="#PostSingleNews"
							class="btn btn-outline-success my-2 my-sm-0"
							style="color: #228B22;">Post News</a>
						<p></p>
						<table class="table table-striped ">
							<tr>
								<th class="text-center">Title</th>
								<th class="text-center">Content</th>
								<th class="text-center">Librarian</th>
								<th class="text-center">Operation</th>
							</tr>
							</thead>
							<tbody>
								<s:iterator value="posts" status="status">
									<div class="modal fade"
										id="EditSingleNews<s:property value="PostID"/>" tabindex="-1"
										role="dialog" style=""
										aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
										<div class="modal-dialog " role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Post
														News</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>

												<div class="modal-body">
													<div class="form-group"></div>
													
													<form action="editPost" method="post">

														<div class="form-group">
															<label>Title</label> <input name="Title"
																required="required" class="form-control"
																value="<s:property value="Title"/>">
														</div>
														<div class="form-group ">
															<label>Content</label><br>
															<textarea class="form-main-control " rows="10" cols="50"
																id="p${PostID}" name="Content" required="required">${Content}</textarea>
														</div>
														<div class="form-group">
															<input class="fade" value="${PostID}" name="post.PostID">
															<button type="submit" class="btn btn-primary"
																style="float: right">Submit</button>
														</div>
													</form>
													<script type="text/javascript">
														(function() {

															CKEDITOR
																	.replace(
																			'p${PostID}',
																			{
																				width : '100%',
																				height : '150px',
																				tabSpaces : 4
																			});
														})();
													</script>
												</div>
											</div>
										</div>
									</div>
									<tr>
										<td><s:property value="Title" /></td>
										<td
											><div style="overflow: hidden; text-overflow: ellipsis; max-width: 20em;max-height:3em;">${Content}</div></td>
										<td class="text-center"><s:property
												value="librarian.LibrarianName" /></td>
										<td class="text-center">
											<ul>
												<li class="list-inline-item"><a data-toggle="modal"
													data-target="#EditSingleNews<s:property value="PostID"/>">
														<i class="fa fa-pencil"></i>
												</a></li>
												<li class="list-inline-item"><a class="delete"
													href="deletePost?post.PostID=<s:property value="PostID"/>">
														<i class="fa fa-trash"></i>
												</a></li>
											</ul>
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Row End -->
	<!-- Container End -->
	<s:include value="/footer.jsp" />
	<!-- JAVASCRIPTS -->

	<script type="text/javascript">
		(function() {

			CKEDITOR.replace('T2', {
				width : '100%',
				height : '150px',
				tabSpaces : 4
			});
		})();
	</script>
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

	<script src="js/scripts.js"></script>

</body>

</html>