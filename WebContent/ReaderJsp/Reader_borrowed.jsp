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

<body class="body-wrapper ">

	<s:include value="/Navbar.jsp"></s:include>
	<s:include value="/ReaderJsp/setProfile.jsp"></s:include>
	<!--==================================
=            User Profile            =
===================================-->
	<section class="dashboard section bg-gray">
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
								<%
									Date Resultsdate = new Date();
								%>
								<div class="profile-thumb">
									<img
										src="upload/${tempReader.readerID}.jpg?time=<%=Resultsdate%>"
										onerror="{this.src='images/avatar1.jpg'}" alt=""
										style="max-height: 100px; max-width: 100px;">
								</div>
							</div>
							<!-- User Name -->
							<h5 class="text-center">${tempReader.readerName}</h5>
							<p>${tempReader.email}</p>
							<a data-toggle="modal" data-target="#setProfile"
								class="btn btn-main-sm" style="color: #fff;">Edit Profile</a>
						</div>
						<!-- Dashboard Links -->
						<div class="widget user-dashboard-menu">
							<ul>
								<li><a href="getReaderStatuForCurrent"><i
										class="fa fa-user"></i> My Reservation</a></li>
								<li class="active"><a href="getReaderStatuForBorrowPage"><i
										class="fa fa-bookmark-o"></i> Current Record </a></li>
								<li><a href="getReaderStatuForReturn?pageNum=1"><i
										class="fa fa-file-archive-o"></i> Return History </a></li>

								<li><a href="readersignout"><i class="fa fa-cog"></i>
										Logout</a></li>

							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
					<!-- Recently Favorited -->
					<div class="widget dashboard-container my-adslist">
						<h3 class="widget-header">
							Unpaid fine: ${totalFine} <i class="fa fa-jpy" aria-hidden="true"></i>
						</h3>
						<table class="table table-responsive product-dashboard-table">
							<thead>
								<tr>
									<th class="text-center">Cover</th>
									<th>BOOK INFORMATION</th>
									<th class="text-center">Due Date</th>

								</tr>
							</thead>
							<tbody>
								<s:if test="borrowPage.datalist.size()>0">
									<s:iterator value="borrowPage.datalist" status="L">
										<tr>
											<td class="action" data-title="Action"><img
												class="card-img-top img-fluid"
												src="<s:property value="books[#L.index].ImageAddress" />"
												onerror="{this.src='images/noImage.jpg'}"
												alt="Card image cap" style="height: 200px; width: auto;">
											</td>
											<td class="product-details">
												<h3 class="title">
													<s:property value="books[#L.index].BookName" />
												</h3> <span class="add-id"><strong>Book ID:</strong>
													${BookID}</span> <span class="add-id"><strong>ISBN:</strong>
													<s:property value="books[#L.index].ISBN" /> </span> <span
												class="add-id"><strong>Category:</strong> <s:property
														value="books[#L.index].category" /> </span><span><strong>
														Reserve on: </strong> <time>${BorrowingDate}</time> </span> <span
												class="location"><strong>Location:</strong> <s:property
														value="books[#L.index].Location" /></span>
											</td>
											<td class="product-thumb text-center"><s:property
													value="ReturnDate" /></td>
											<%-- <td class="product-category"><span class="categories"><s:property
														value="books[#L.index].category" /></span></td> --%>

										</tr>
									</s:iterator>
								</s:if>
								<s:else>
									<tr>
										<td class="product-details"></td>
										<td class="product-thumb text-center"></td>
										<td class="product-category"><span class="categories"></span></td>
									</tr>
								</s:else>
							</tbody>
						</table>

					</div>
				</div>
			</div>
			<!-- Row End -->
		</div>
		<!-- Container End -->
	</section>
	<!--============================
=            Footer            =
=============================-->
	<s:include value="/footer.jsp"></s:include>

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