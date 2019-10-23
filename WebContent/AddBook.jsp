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
<title>AddBook</title>

<!-- PLUGINS CSS STYLE -->
<link href="plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet">
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
	<s:include value="jspElement/Head.jsp" />
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
							<h5 class="text-center">Samanta Doe</h5>
							<p>Joined February 06, 2017</p>
						</div>
						<!-- Dashboard Links -->
						<div class="widget user-dashboard-menu">
							<ul>
								<li class="active"><a href=""><i class="fa fa-book"></i>
										Manage Book </a></li>
								<li><a href="BookSearch"><i class="fa fa-search"></i>
										Search Book</a></li>
								<li><a href="ReaderRegister"><i class="fa fa-user-plus"></i>
										Register Reader </a></li>
								<li><a href="BorrowHistory"><i class="fa fa-history"></i>
										Borrow History</a></li>
								<li><a href="BookBorrow"><i class="fa fa-share"></i>
										Borrow Book</a></li>
								<li><a href="BookReturn"><i class="fa fa-reply"></i>
										Return Book</a></li>
								<li><a href="IncomeHistory"><i class="fa fa-money"></i>
										Income History</a></li>
								<li><a href="NewsPost"><i class="fa fa-paper-plane"></i>
										Post News</a></li>
								<li><a href="Logout"><i class="fa fa-sign-out"></i>
										Logout</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
					<!-- Recently Favorited -->
					<div class="widget dashboard-container my-adslist">
						<h3 class="widget-header">Book Management</h3>
						<table border="1" name="AddBook">
							<form action="addBook" method="post">
								BookName:<br><input name="BookName" required="required"><br>
								Price:<br><input name="Price" required="required" /><br>
								<li><label>Floor:<br></label> <select name="Location"
									required="required"><br>
										<option value="first floor">first floor</option>
										<option value="second floor">second floor</option>
										<option value="third floor">third floor</option>
								</select></li>
								<li><label>Area:</label> <select name="Location"
									required="required"><br>
										<option value="A area">A</option>
										<option value="B area">B</option>
										<option value="C area">C</option>
										<option value="D area">D</option>

								</select></li> category:<br><input name="Category" required="required" /><br>
								Number:<br><input name="Num" required="required" /><br>
								Description:<br><input name="Introduction" required="required" /><br>
								Author:<br><input name="author" required="required" /><br>
								<button type="submit" value="add">Add Book</button>
							</form>

						</table>
						<br>
						<table border="2" name="AddBookisbn">
							<form action="addBookISBN" method="post">
								ISBN:<input name="ISBN" required="required"><br>
								<li><label>Floor</label> <select name="Location"
									required="required">
										<option value="first floor">first floor</option>
										<option value="second floor">second floor</option>
										<option value="third floor">third floor</option>
								</select></li>
								<li><label>Area</label> <select name="Location"
									required="required">
										<option value="A area">A</option>
										<option value="B area">B</option>
										<option value="C area">C</option>
										<option value="D area">D</option>

								</select></li> <br> number:<input name="Number" required="required"><br>
								<button type="submit" value="add">Add Book BY ISBN</button>
							</form>

						</table>
					</div>
				</div>
			</div>
			<!-- Row End -->
		</div>
		<!-- Container End -->
	</section>
	<s:include value="jspElement/Foot.jsp" />
	<!-- JAVASCRIPTS -->
	<script src="plugins/jquery/dist/jquery.min.js"></script>
	<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
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


