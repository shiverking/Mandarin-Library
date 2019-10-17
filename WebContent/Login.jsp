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
<title>Calssimax</title>

<!-- PLUGINS CSS STYLE -->
<link href="plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet">
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
<!-- Bootstrap -->
<link href="plugins/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
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
	<s:include value="/Navbar.jsp"></s:include>
	<!--===============================
=           Login form Area            =
================================-->

	<script>
		/*根据用户选择给与输入的提示信息*/
		function selChange() {
			var sel = document.getElementById("inputGroupSelect01").value;
			if (sel == 1) {
				document.getElementById("loginform").action = "readersignin";
				document.getElementById("getPassword").action = "forgetReaderPassword";
				document.getElementById("uName").innerHTML = "Email:";
				document.getElementById("User").type = "email:";
				document.getElementById("User").name = "Email";
				document.getElementById("User").setAttribute('placeholder',
						"Input Your Email");
			} else {
				document.getElementById("loginform").action = "#";
				document.getElementById("getPassword").action = "#";
				document.getElementById("uName").innerHTML = "Name:";
				document.getElementById("User").type = "text";
				document.getElementById("User").name = "LibrarianName";
				document.getElementById("User").setAttribute('placeholder',
						"Input Your UserName");
			}
		};
	</script>
	<!--登录的输入表单-->
	<section class="popular-deals section "
		style="background-image: url(http://tushuguan.nwpu.edu.cn/images/2019/20191010A.jpg); background-size: 100%; background-position: center;">
		<div class="row justify-content-center">
			<div class="container form-group col-3 bg-shadow bg-white rounded ">
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
				<form action="readersignin" id="loginform" method="post">
					<label id="uName">Email:</label> <input
						class="form-control bg-shadow" type="email"
						placeholder="Input Your Email" Id="User" name="Email"> <label>Password</label>
					<input class="form-control bg-shadow" type="password"
						placeholder="Input Your Password" id="Password" name="Password">
					<label></label>
					<div class="row justify-content-center">
						<select class="form-control form-control-lg col-4 bg-shadow"
							id="inputGroupSelect01" onchange="selChange()">
							<option value="1" selected>Reader</option>
							<option value="2">Librarian</option>
						</select>
						<div class="col-2"></div>
						<button class="btn btn-info col-5 bg-shadow" type="submit"
							onclick="Login()">Login</button>
					</div>
				</form>

				<div class="blockquote text-right">
					<label><a href="#" data-toggle="modal"
						data-target="#exampleModalCenter">Forget Password?</a></label>
				</div>
			</div>
		</div>
	</section>

	<!--============================
=            Forget Password           =
=============================-->

	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog " role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Enter your
						Email to retrieve your password</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="forgetReaderPassword" id="getPassword" method="post">
					<div class="modal-body">

						<input class="form-control bg-shadow" type="email"
							placeholder="Input Your Email" name="Email">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>
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
						<p class="alt-color">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit, sed do eiusmod tempor incididunt ut labore et
							dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
							exercitation ullamco laboris nisi ut aliquip ex ea commodo
							consequat.</p>
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



