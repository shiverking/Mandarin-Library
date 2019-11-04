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
<link rel="stylesheet" href="css/calendar.css">
<script src="js/z.src.js"></script>
<script src="js/ui.js"></script>
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
							<p>Time Now:<span id="time"></span></p>
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
								<li class="active"><a href="IncomeHistory"><i
										class="fa fa-money"></i> Income History</a></li>
										<li><a href="displayDeleteRecords"><i class="fa fa-trash-o" aria-hidden="true"></i>
										Deleted Records</a></li>
								<li><a href="displayPosts"><i class="fa fa-paper-plane"></i>
										Post News</a></li>
								<li><a href="librarianLogout"><i class="fa fa-sign-out"></i>
										Logout</a></li>

							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
					<!-- Recently Favorited -->
					<div class="widget dashboard-container my-adslist">
						<h3 class="widget-header">IncomeHistory</h3>
						<form action="displayPayrecords" method="post">
							begin day：<input id="date1" type="text" name="date1" class="form-control" required="required" autocomplete=”off”><br />
							end day：<input id="date2" type="text" name="date2" class="form-control" required="required" autocomplete=”off”><br />
							<button type="submit" value="submit" class="btn btn-main">submit</button>
						</form>
						<p></p>
						<p class="h3">Deposit : ${sessionScope.Deposit}</p>
						<p class="h3">Fine : ${sessionScope.Fine}</p>
						<script>
							var calendar1 = Z.ui.Calendar('#date1', {
								chosenDate : '2019-10-25'
							})

							var calendar2 = Z.ui.Calendar('#date2', {
								chosenDate : '2019-10-25'
							})
						</script>
					</div>
				</div>
			</div>
		</div>
		<!-- 在这里写IncomeHistory展示对象 -->



		<!-- Row End -->

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

	<script src="js/scripts.js"></script>
<script type="text/javascript">
  function getCurrentTime() {
  	var date = new Date();
  	var hour = date.getHours()<10?"0"+date.getHours().toString():date.getHours();
  	var minu = date.getMinutes()<10?"0"+date.getMinutes().toString():date.getMinutes();
  	var seco=date.getSeconds()<10?"0"+date.getSeconds().toString():date.getSeconds();
  	var timeInfo = date.getFullYear()+"."+(date.getMonth()+1)+"."+date.getDate()+"."+hour+":"+minu+":"+seco;
  	var spanObj = document.getElementById("time");
  	spanObj.innerHTML = timeInfo.fontcolor("gray");
  }
  getCurrentTime();//页面加载时执行
  window.setInterval("getCurrentTime()", 1000); // 每1000毫秒执行一次
  </script>

</body>
</html>