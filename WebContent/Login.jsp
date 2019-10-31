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
				document.getElementById("uName").innerHTML = "Mobile number:";
				document.getElementById("User").name = "PhoneNumber";
				document.getElementById("User").setAttribute('placeholder',
						"Input Your Email");
				document.getElementById("fgp").setAttribute('data-target',
						"#ReaderFg");
			} else {
				document.getElementById("loginform").action = "librarianlogin";
				document.getElementById("getPassword").action = "#";
				document.getElementById("uName").innerHTML = "Name:";
				document.getElementById("User").name = "LibrarianName";
				document.getElementById("User").setAttribute('placeholder',
						"Input Your UserName");
				document.getElementById("fgp").setAttribute('data-target',
						"#lbinfo");
			}
		};
	</script>
	<!--登录的输入表单-->
	<section class="popular-deals section "
		style="background-image: url(images/home/timg.jpg); background-position: center; background-repeat: no-repeat; background-size: cover;">
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
					<label id="uName">Mobile number:</label>
					<div class="input-group margin-bottom-sm ">
						<span class="input-group-addon"><i
							class="fa fa-user-o fa-fw"></i></span> <input
							class="form-control bg-shadow" type="text"
							placeholder="Input Your mobile number" Id="User"
							name="PhoneNumber">
					</div>

					<label>Password</label>
					<div class="input-group margin-bottom-sm ">
						<span class="input-group-addon "><i class="fa fa-key fa-fw"></i></span>
						<input class="form-control bg-shadow" type="password"
							placeholder="Input Your Password" id="Password" name="Password">
					</div>
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
					<label><a href="#" data-toggle="modal" id="fgp"
						data-target="#ReaderFg">Forget Password?</a></label>
				</div>
			</div>
		</div>
	</section>

	<!--============================
=            Forget Password           =
=============================-->

	<div class="modal fade" id="lbinfo" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog " role="document">
			<div class="modal-content">
				<div class="modal-header"></div>

				<div class="modal-body">
				Please contact the Admin to retrieve the password!
				</div>
				<div class="modal-footer"></div>

			</div>
		</div>
	</div>
	<!-- reader 找回密码的Modal -->
	<div class="modal fade" id="ReaderFg" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
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
						<div class="input-group margin-bottom-sm ">
							<span class="input-group-addon "><i
								class="fa fa-envelope-o fa-fw"></i></span><input
								class="form-control bg-shadow" type="email"
								placeholder="Input Your Email" name="Email">
						</div>

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
	<s:include value="/footer.jsp"></s:include>
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



