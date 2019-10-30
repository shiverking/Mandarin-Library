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
<meta name="referrer" content="never">
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
								<li class="active"><a href="BookManagement"><i
										class="fa fa-book"></i> Manage Book </a></li>
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
					<form action="addBook" method="post">

						<div
							class="widget dashboard-container my-adslist row justify-content-center">
							<div class="col-4">
								<img src="${ImageAddress}"
									onerror="{this.src='images/book-default-lpic.gif'}"
									style="max-height: 350px; width: 100%">
							</div>
							<div class="col-8">
								<div class="input-group margin-bottom-sm col-12 mb-2">
									<span class="input-group-addon"><i
										class="fa fa-book fa-fw" aria-hidden="true"></i></span> <input
										class="form-control" type="text" placeholder="BookName"
										value="${BookName}" id="ink" name="BookName"
										required="required">
								</div>
								<div class="input-group margin-bottom-sm col-12 mb-2">
									<span class="input-group-addon"><i
										class="fa fa-barcode fa-fw" aria-hidden="true"></i></span> <input
										class="form-control" type="text" placeholder="ISBN"
										name="ISBN" id="isbnk" required="required" value="${ISBN}">
									<span class="input-group-addon"><a
										href="javascript:findbyisbn()"><i
											class="fa fa-search fa-fw" aria-hidden="true"></i></a></span>
								</div>
								<script type="text/javascript">
									function findbyisbn() {
										var key = $('#isbnk').val();
										window.location.href = "findBookByISBNinWeb?ISBN="
												+ key;
									}
								</script>
								<div class="input-group margin-bottom-sm col-12 mb-2">
									<span class="input-group-addon"><i
										class="fa fa-money fa-fw" aria-hidden="true"></i></span> <input
										class="form-control" type="text" placeholder="Price"
										value="${Price}" name="Price" required="required">
								</div>
								<div class="input-group margin-bottom-sm col-12 mb-2">
									<span class="input-group-addon"><i
										class="fa fa-user-o fa-fw" aria-hidden="true"></i></span> <input
										class="form-control" type="text" placeholder="Author"
										value="${Author}" name="author" required="required">
								</div>
								<div class="input-group margin-bottom-sm col-12 mb-2">
									<span class="input-group-addon"><i
										class="fa fa-plus fa-fw" aria-hidden="true"></i></span> <input
										class="form-control" placeholder="Number" name="Num"
										required="required">
								</div>
								<div class="input-group margin-bottom-sm col-12 mb-2">
									<span class="input-group-addon">category:</span> <select
										name="Category" required="required" class="form-control">
										<option value="Literature">Literature</option>
										<option value="Arts">Arts</option>
										<option value="History&Geography">History&Geography</option>
										<option value="Science">Science</option>
										<option value="Politics&Law">Politics&Law</option>
										<option value="Philosophy&Religion">Philosophy&Religion</option>
									</select>
								</div>
							</div>

							<div class="input-group margin-bottom-sm col-12 mb-2">
								<span class="input-group-addon">Floor:</span> <label><br></label>
								<select name="Location" required="required" class="form-control">
									<option value="first floor">first floor</option>
									<option value="second floor">second floor</option>
									<option value="third floor">third floor</option>
								</select> <span class="input-group-addon">Area:</span><select
									name="Location" required="required" class="form-control">
									<option value="A area">A</option>
									<option value="B area">B</option>
									<option value="C area">C</option>
									<option value="D area">D</option>
								</select>
							</div>
							<div class="input-group margin-bottom-sm col-12">
								<span class="input-group-addon">Description:</span>
								<textarea id="T1" class="form-control"
									placeholder="Description:" name="Introduction"
									required="required">${Introduction}</textarea>
							</div>
							<input style="display: none" name="ImageAddress"
								value="${ImageAddress}">
							<button type="submit" value="add" class="btn btn-main-sm">Add
								Book</button>
						</div>
					</form>
				</div>
			</div>
		</div>

		<!-- Container End -->
	</section>
	<s:include value="/footer.jsp" />
	<!-- JAVASCRIPTS -->
	<script src="webapp/ckeditor.js"></script>
	<script type="text/javascript">
	    (function()
	    {
	       
	        CKEDITOR.replace('T1',{
	        		width:'100%',
	        		height:'150px',
	        		tabSpaces: 4
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