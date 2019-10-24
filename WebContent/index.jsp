<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>

<!-- SITE TITTLE -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mandarin-Library</title>


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

<body class="body-wrapper">
	<!--===============================
=            Navbar Area            =
================================-->
	<s:include value="/librarian_jsp/Navbar.jsp"></s:include>

	<!--===============================
=            Hero Area            =
================================-->
	<section class="hero-area bg-1 text-center overly">
		<!-- Container Start -->
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<!-- Header Contetnt -->
					<div class="content-block">
						<h1>Mandarin-Library</h1>
						<p>
							Enter the library and immerse yourself in the sea of books<br>many
							people around the world use this site every day
						</p>

					</div>
					<!-- Advance Search -->
					<div class="advance-search">
						<form action="searchBook">
							<div class="row justify-content-center ">
								<!-- Store Search -->
								<div class="col-lg-10 col-md-12">
									<div class="block d-flex">
										<input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"
											name="searchContent" id="search" placeholder="Search book">
										<select name="selectSearch"
											class="form-control mb-2 mr-sm-2 mb-sm-0">
											<option value="1" selected>ALL</option>
											<option value="2">Book ISBN</option>
											<option value="3">Book Title</option>
											<option value="2">Book Author</option>
										</select>
										<!-- Search Button -->
										<button class="btn btn-main " type="submit">SEARCH</button>
									</div>
								</div>
							</div>
						</form>

					</div>

				</div>
			</div>
		</div>
		<!-- Container End -->
	</section>

	<!--===================================
=            Client Slider            =
====================================-->


	<!--===========================================
=            Popular deals section            =
============================================-->

	<section class="popular-deals section bg-gray">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-title">
						<h2>Post news</h2>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Quas, magnam.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<!-- offer 01 -->
				<s:if test="posts==null">
					<s:action name="displayPostItem" namespace="/" executeResult="true"></s:action>
				</s:if>
			</div>
		</div>
	</section>



	<!--==========================================
=            All Category Section            =
===========================================-->

	<section class=" section">
		<!-- Container Start -->
		<div class="container">
			<div class="row">
				<div class="col-12">
					<!-- Section title -->
					<div class="section-title">
						<h2>All Categories</h2>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Perferendis, provident!</p>
					</div>
					<div class="row">
						<!-- Category list -->
						<div
							class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
							<div class="category-block">
								<div class="header">
									<i class="fa fa-laptop icon-bg-1"></i>
									<h4>Electronics</h4>
								</div>
								<ul class="category-list">
									<li><a href="category.html">Laptops <span>93</span></a></li>
									<li><a href="category.html">Iphone <span>233</span></a></li>
									<li><a href="category.html">Microsoft <span>183</span></a></li>
									<li><a href="category.html">Monitors <span>343</span></a></li>
								</ul>
							</div>
						</div>
						<!-- /Category List -->
						<!-- Category list -->
						<div
							class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
							<div class="category-block">
								<div class="header">
									<i class="fa fa-apple icon-bg-2"></i>
									<h4>Restaurants</h4>
								</div>
								<ul class="category-list">
									<li><a href="category.html">Cafe <span>393</span></a></li>
									<li><a href="category.html">Fast food <span>23</span></a></li>
									<li><a href="category.html">Restaurants <span>13</span></a></li>
									<li><a href="category.html">Food Track<span>43</span></a></li>
								</ul>
							</div>
						</div>
						<!-- /Category List -->
						<!-- Category list -->
						<div
							class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
							<div class="category-block">
								<div class="header">
									<i class="fa fa-home icon-bg-3"></i>
									<h4>Real Estate</h4>
								</div>
								<ul class="category-list">
									<li><a href="category.html">Farms <span>93</span></a></li>
									<li><a href="category.html">Gym <span>23</span></a></li>
									<li><a href="category.html">Hospitals <span>83</span></a></li>
									<li><a href="category.html">Parolurs <span>33</span></a></li>
								</ul>
							</div>
						</div>
						<!-- /Category List -->
						<!-- Category list -->
						<div
							class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
							<div class="category-block">
								<div class="header">
									<i class="fa fa-shopping-basket icon-bg-4"></i>
									<h4>Shoppings</h4>
								</div>
								<ul class="category-list">
									<li><a href="category.html">Mens Wears <span>53</span></a></li>
									<li><a href="category.html">Accessories <span>212</span></a></li>
									<li><a href="category.html">Kids Wears <span>133</span></a></li>
									<li><a href="category.html">It & Software <span>143</span></a></li>
								</ul>
							</div>
						</div>
						<!-- /Category List -->
						<!-- Category list -->
						<div
							class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
							<div class="category-block">
								<div class="header">
									<i class="fa fa-briefcase icon-bg-5"></i>
									<h4>Jobs</h4>
								</div>
								<ul class="category-list">
									<li><a href="category.html">It Jobs <span>93</span></a></li>
									<li><a href="category.html">Cleaning & Washing <span>233</span></a></li>
									<li><a href="category.html">Management <span>183</span></a></li>
									<li><a href="category.html">Voluntary Works <span>343</span></a></li>
								</ul>
							</div>
						</div>
						<!-- /Category List -->
						<!-- Category list -->
						<div
							class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
							<div class="category-block">
								<div class="header">
									<i class="fa fa-car icon-bg-6"></i>
									<h4>Vehicles</h4>
								</div>
								<ul class="category-list">
									<li><a href="category.html">Bus <span>193</span></a></li>
									<li><a href="category.html">Cars <span>23</span></a></li>
									<li><a href="category.html">Motobike <span>33</span></a></li>
									<li><a href="category.html">Rent a car <span>73</span></a></li>
								</ul>
							</div>
						</div>
						<!-- /Category List -->
						<!-- Category list -->
						<div
							class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
							<div class="category-block">
								<div class="header">
									<i class="fa fa-paw icon-bg-7"></i>
									<h4>Pets</h4>
								</div>
								<ul class="category-list">
									<li><a href="category.html">Cats <span>65</span></a></li>
									<li><a href="category.html">Dogs <span>23</span></a></li>
									<li><a href="category.html">Birds <span>113</span></a></li>
									<li><a href="category.html">Others <span>43</span></a></li>
								</ul>
							</div>
						</div>
						<!-- /Category List -->
						<!-- Category list -->
						<div
							class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
							<div class="category-block">
								<div class="header">
									<i class="fa fa-laptop icon-bg-8"></i>
									<h4>Services</h4>
								</div>
								<ul class="category-list">
									<li><a href="category.html">Cleaning <span>93</span></a></li>
									<li><a href="category.html">Car Washing <span>233</span></a></li>
									<li><a href="category.html">Clothing <span>183</span></a></li>
									<li><a href="category.html">Business <span>343</span></a></li>
								</ul>
							</div>
						</div>
						<!-- /Category List -->


					</div>
				</div>
			</div>
		</div>
		<!-- Container End -->
	</section>




	<!--============================
=            Footer            =
=============================-->

	<footer class="footer section section-sm">
		<!-- Container Start -->
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-7 offset-md-1 offset-lg-0">
					<!-- About -->
					<div class="block about">
						<!-- footer logo -->
						<img src="images/MLA_logo_tagline.png" width="300px" alt="">
						<!-- description -->

					</div>
				</div>
				<!-- Link list -->
				<div class="col-lg-2 offset-lg-1 col-md-3">
					<div class="block">
						<h4>Site Pages</h4>
						<ul>
							<li><a href="#">Boston</a></li>
							<li><a href="#">How It works</a></li>
							<li><a href="#">Deals & Coupons</a></li>
							<li><a href="#">Articls & Tips</a></li>
							<li><a href="#">Terms of Services</a></li>
						</ul>
					</div>
				</div>
				<!-- Link list -->
				<div class="col-lg-2 col-md-3 offset-md-1 offset-lg-0">
					<div class="block">
						<h4>Admin Pages</h4>
						<ul>
							<li><a href="#">Boston</a></li>
							<li><a href="#">How It works</a></li>
							<li><a href="#">Deals & Coupons</a></li>
							<li><a href="#">Articls & Tips</a></li>
							<li><a href="#">Terms of Services</a></li>
						</ul>
					</div>
				</div>
				<!-- Promotion -->
				<div class="col-lg-4 col-md-7">
					<!-- App promotion -->
					<div class="block-2 app-promotion">
						<a href=""> <!-- Icon --> <img
							src="images/footer/phone-icon.png" alt="mobile-icon">
						</a>
						<p>Get the Dealsy Mobile App and Save more</p>
					</div>
				</div>
			</div>
		</div>
		<!-- Container End -->
	</footer>
	<!-- Footer Bottom -->
	<footer class="footer-bottom">
		<!-- Container Start -->
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-12">
					<!-- Copyright -->
					<div class="copyright">
						<p>Copyright Â© 2019. All Rights Reserved</p>
					</div>
				</div>
				<div class="col-sm-6 col-12">
					<!-- Social Icons -->
					<ul class="social-media-icons text-right">
						<li><a class="fa fa-facebook" href=""></a></li>
						<li><a class="fa fa-twitter" href=""></a></li>
						<li><a class="fa fa-pinterest-p" href=""></a></li>
						<li><a class="fa fa-vimeo" href=""></a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- Container End -->
		<!-- To Top -->
		<div class="top-to">
			<a id="top" class="" href=""><i class="fa fa-angle-up"></i></a>
		</div>
	</footer>

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
	
	<script src="js/scripts.js"></script>

</body>

</html>



