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

<body class="body-wrapper">
	<!--导航栏-->
	<s:include value="/Navbar.jsp"></s:include>
	<!--搜索栏 -->
	<section class="page-search">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-10 ">
					<!-- Advance Search -->
					<div class="advance-search">
						<form action="searchBook">
							<div class="form-row justify-content-center">
								<div class="form-group col-md-10 ">
									<input type="text" class="form-control" name="searchContent"
										id="inputLocation4" placeholder="Search by title or ISBN">
								</div>
								<div class="form-group col-md-2 ">
									<button type="submit" class="btn btn-primary">Search
										Now</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="section-sm">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="search-result bg-gray">
						<h2>Results For "${searchContent}"</h2>
						<%
							Date Resultsdate = new Date();
						%>
						<p>${bookPage.totalRecord}
							Results on
							<%=Resultsdate%></p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="category-sidebar">
						<div class="widget category-list">
							<h4 class="widget-header">All Category</h4>
							<ul class="category-list">
								<li><a href="category.html">Laptops <span>93</span></a></li>
								<li><a href="category.html">Iphone <span>233</span></a></li>
								<li><a href="category.html">Microsoft <span>183</span></a></li>
								<li><a href="category.html">Monitors <span>343</span></a></li>
							</ul>
						</div>

						<div class="widget category-list">
							<h4 class="widget-header">Nearby</h4>
							<ul class="category-list">
								<li><a href="category.html">New York <span>93</span></a></li>
								<li><a href="category.html">New Jersy <span>233</span></a></li>
								<li><a href="category.html">Florida <span>183</span></a></li>
								<li><a href="category.html">California <span>120</span></a></li>
								<li><a href="category.html">Texas <span>40</span></a></li>
								<li><a href="category.html">Alaska <span>81</span></a></li>
							</ul>
						</div>

						<div class="widget filter">
							<h4 class="widget-header">Show Produts</h4>
							<select>
								<option>Popularity</option>
								<option value="1">Top rated</option>
								<option value="2">Lowest Price</option>
								<option value="4">Highest Price</option>
							</select>
						</div>

						<div class="widget price-range">
							<h4 class="widget-header">Price Range</h4>
							<div class="block">
								<b>$10</b> <input id="ex2" type="text" class="span2" value=""
									data-slider-min="10" data-slider-max="1000"
									data-slider-step="5" data-slider-value="[250,450]" /> <b>$5000</b>
							</div>
						</div>

						<div class="widget product-shorting">
							<h4 class="widget-header">By Condition</h4>
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox" value="">
									Brand New
								</label>
							</div>
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox" value="">
									Almost New
								</label>
							</div>
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox" value="">
									Gently New
								</label>
							</div>
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox" value="">
									Havely New
								</label>
							</div>
						</div>

					</div>
				</div>
				<div class="col-md-9">
					<div class="category-search-filter">
						<div class="row">
							<div class="col-md-6">
								<strong>Short</strong> <select>
									<option>Most Recent</option>
									<option value="1">Most Popular</option>
									<option value="2">Lowest Price</option>
									<option value="4">Highest Price</option>
								</select>
							</div>
							<div class="col-md-6">
								<div class="view">
									<strong>Views</strong>
									<ul class="list-inline view-switcher">
										<li class="list-inline-item"><a
											href="javascript:void(0);"><i class="fa fa-th-large"></i></a>
										</li>
										<li class="list-inline-item"><a
											href="javascript:void(0);"><i class="fa fa-reorder"></i></a>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<!-- 搜索结果页面 -->
					<div class="product-grid-list">
						<div class="row mt-30">
							<s:iterator value="bookPage.dataList" status="L">
								<div class="col-sm-12 col-lg-4 col-md-6">
									<!-- product card -->
									<div class="product-item bg-light">
										<div class="card">
											<div class="thumb-content">
												<!-- <div class="price">$200</div> -->
												<a href=""> <img class="card-img-top img-fluid"
													src="images/products/products-1.jpg" alt="Card image cap">
												</a>
											</div>
											<div class="card-body">
												<h4 class="card-title">
													<a href="">${bookName}</a>
												</h4>
												<ul class="list-inline product-meta">
													<li class="list-inline-item"><a href=""><i
															class="fa fa-book"></i>${Category}</a></li>
													<li class="list-inline-item"><a href=""><i
															class="fa fa-bookmark"></i>${ISBN}</a></li>

												</ul>

												<p class="card-text">
													<i class="fa fa-map-marker"></i> &nbsp;${Location}
												</p>
												<s:if test="isBorrowed==0">
													<li class="list-inline-item "><strong>Status:
													</strong><strong class="text-info">Available</strong></li>
													<a class="btn-main-sm"
														href='getReaderStatuForReserveBook?book.BookID=<s:property value="BookID"/>&searchContent=${searchContent}&pageNum=${pageNum}'>Reserve</a>
												</s:if>
												<s:else>
													<li class="list-inline-item "><strong>Status:
													</strong> <strong class="text-danger">Lended</strong></li>
												</s:else>

											</div>
										</div>
									</div>
								</div>
							</s:iterator>
						</div>
					</div>
					<!--分页按钮  -->
					<div class="pagination justify-content-center">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<!--前往上一页的按钮-->
								<li class="page-item"><a class="page-link"
									href="searchBook?searchContent=${searchContent}&pageNum=${bookPage.prePageNum}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
								</a></li>
								<!--显示前往第一页的按钮-->
								<s:if test="bookPage.beginPageNum>1">
									<li class="page-item"><a class="page-link"
										href="searchBook?searchContent=${searchContent}&pageNum=1">1</a></li>
									<s:if test="bookPage.beginPageNum>2">
										<li class="page-item"><a class="page-link">....</a></li>
									</s:if>
								</s:if>
								<!-- 显示以当前页为中心的7页 -->
								<s:iterator begin="%{bookPage.beginPageNum}"
									end="%{bookPage.endPageNum}" var="snum">
									<s:if test="#snum == bookPage.currentPage">
										<li class="page-item active"><a class="page-link"
											href="searchBook?searchContent=${searchContent}&pageNum=${snum}">${snum}</a></li>
									</s:if>
									<s:else>
										<li class="page-item"><a class="page-link"
											href="searchBook?searchContent=${searchContent}&pageNum=${snum}">${snum}</a></li>
									</s:else>
								</s:iterator>
								<!-- 显示最后一页 -->
								<s:if test="bookPage.endPageNum<bookPage.totalPage">

									<s:if test="bookPage.endPageNum+1<bookPage.totalPage">
										<li class="page-item"><a class="page-link">....</a></li>
									</s:if>
									<li class="page-item"><a class="page-link"
										href="searchBook?searchContent=${searchContent}&pageNum=${bookPage.totalPage}">${bookPage.totalPage}</a></li>
								</s:if>
								<!-- 前往下一页的按钮-->
								<li class="page-item"><a class="page-link"
									href="searchBook?searchContent=${searchContent}&pageNum=${bookPage.nextPageNum}"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
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
						<img src="images/logo-footer.png" alt="">
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
						<p>Copyright Â© 2016. All Rights Reserved</p>
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