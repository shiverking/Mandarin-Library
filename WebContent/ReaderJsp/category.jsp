<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@page import="java.util.Date,java.lang.*"%>
<!DOCTYPE html>
<html lang="en">
<head>

<!-- SITE TITTLE -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Calssimax</title>

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
	<!--导航栏-->
	<s:include value="/Navbar.jsp"></s:include>
	<!--搜索栏 -->
	<section class="page-search " style="background-color: #4573ab;">
		<div class="container">
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
									<option value="4">Book Author</option>
								</select>
								<!-- Search Button -->
								<button class="btn btn-primary " type="submit">SEARCH</button>
							</div>
						</div>
					</div>
				</form>
			</div>
	</section>
	<section class="section-sm">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="search-result bg-gray">
						<h2>
							Search
							<s:if test="selectSearch==2">by ISBN</s:if>
							<s:elseif test="selectSearch==3">by Book Title</s:elseif>
							<s:elseif test="selectSearch==4">by Author</s:elseif>
							For "${searchContent}"
						</h2>
						<%
							Date Resultsdate = new Date();
						%>
						<p>${bookPage.totalRecord}
							Results on
							<%=Resultsdate%></p>
					</div>
				</div>
			</div>
			<s:include value="Search_result.jsp"></s:include>
		</div>
	</section>
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

	<script src="js/scripts.js"></script>

</body>

</html>