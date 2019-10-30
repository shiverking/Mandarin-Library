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
<title>BookSearch</title>


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
							<li><a href="BookManagement"><i class="fa fa-book"></i>
										Manage Book </a></li>
								<li class="active"><a href="searchBook1"><i class="fa fa-search"></i>
										Search Book</a></li>
								<li><a href="getAllReaders"><i class="fa fa-user-plus"></i>
										Managing readers </a></li>
								<li><a href="BorrowHistory"><i class="fa fa-history"></i>
										Borrow History</a></li>
								<li><a href="BookBorrow"><i class="fa fa-share"></i>
										Borrow Book</a></li>
								<li ><a href="BookReturn"><i
										class="fa fa-reply"></i> Return Book</a></li>
								<li><a href="IncomeHistory"><i class="fa fa-money"></i>
										Income History</a></li>
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
						<h3 class="widget-header">Search Book</h3>
						<form action="searchBook1">
							<div class="row justify-content-center ">
								<!-- Store Search -->
								<div class="col-10 col-md-12">
									<div class="block d-flex row">
										<input type="text"
											class="form-control col-7 mb-2 mr-sm-2 mb-sm-0"
											name="searchContent" id="search" placeholder="Search book">
										<select name="selectSearch"
											class="form-control col-2 mb-2 mr-sm-2 mb-sm-0">
											<option value="1" selected>ALL</option>
											<option value="2">Book ISBN</option>
											<option value="3">Book Title</option>
											<option value="4">Book Author</option>
										</select>
										<!-- Search Button -->
										<button class="btn btn-primary col-2" type="submit">SEARCH</button>
									</div>
								</div>
							</div>
						</form>
						<div class="tab-pane" id="profile" role="tabpanel">

							<div class="accordion col-12" ID="VIEW2">
								<div class="row ">
									<s:iterator value="bookPage.dataList" status="L2">
												<s:include value="setBook.jsp" />
										<!-- product card -->
										<div class="product-item bg-light">
											<div class="row">
												<div class="thumb-content col-3">
													<!-- <div class="price">$200</div> -->
													<a data-toggle="collapse" href="#collap2${bookID}"> <img
														class="card-img-top img-fluid" src="${ImageAddress}" onerror="{this.src='images/book-default-lpic.gif'}"
														alt="Card image cap" style="height: 200px; width: 150px;">
													</a>
												</div>
												<div class=" col-8">
													<h4 class="card-title">
														<a data-toggle="collapse" href="#collap2${bookID}">${bookName}</a>
													</h4>
													<ul class="list-inline product-meta">
														<li class="list-inline-item"><a><i
																class="fa fa-book"> Category:</i>${Category}</a></li>
														<li class="list-inline-item"><a><i
																class="fa fa-bookmark"> ISBN:</i>${ISBN}</a></li>
														<li class="list-inline-item"><a><i
																class="fa fa-pencil" aria-hidden="true"> Author:</i>${Author}</a></li>
														<li class="list-inline-item"><i
															class="fa fa-map-marker"> Location:</i> &nbsp;${Location}</li>
														<li class="list-inline-item"><s:if
																test="isBorrowed==0">
																<li class="list-inline-item "><strong>Status:</strong><strong
																	class="text-info">Available</strong></li>
																<br>
																<a data-toggle="modal" data-target="#setBook${bookID}"
																	class="btn btn-main-sm" style="color: #fff;">Edit
																	</a>
															
																<a class="btn btn-main-sm" style="background-color: red;"
																	href='deleteBook?book.BookID=<s:property value="BookID"/>'>Delete</a>

															</s:if> <s:elseif test="reservations.get(#L2.index)!=0">
																<li class="list-inline-item "><strong>Status:
																</strong> <strong class="text-warning">Reserved</strong></li>
															</s:elseif> <s:else>
																<li class="list-inline-item "><strong>Status:
																</strong> <strong class="text-danger">Lended</strong></li>
															</s:else>
													</ul>
												</div>
												<div class="collapse col-12" id="collap2${bookID}">
													<div
														style="overflow-y: scroll; max-height: 250px; width: 100%; margin: 0 auto; text-indent: 2em">
														<strong>Introduction:</strong>
														<div class="card card-body">${Introduction}</div>
													</div>
												</div>
											</div>
										</div>

									</s:iterator>
								</div>
							</div>
						</div>
					</div>


					<s:if test="bookPage.dataList">
						<!--分页按钮  -->
						<div class="pagination justify-content-center">
							<nav aria-label="Page navigation example">
								<ul class="pagination">
									<!--前往上一页的按钮-->
									<li class="page-item"><a class="page-link"
										href="javascript:searchs(${bookPage.prePageNum})"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											<span class="sr-only">Previous</span>
									</a></li>
									<!--显示前往第一页的按钮-->
									<s:if test="bookPage.beginPageNum>1">
										<li class="page-item"><a class="page-link"
											href="javascript:searchs(1)">1</a></li>
										<s:if test="bookPage.beginPageNum>2">
											<li class="page-item"><a class="page-link">....</a></li>
										</s:if>
									</s:if>
									<!-- 显示以当前页为中心的7页 -->
									<s:iterator begin="%{bookPage.beginPageNum}"
										end="%{bookPage.endPageNum}" var="snum">
										<s:if test="#snum == bookPage.currentPage">
											<li class="page-item active"><a class="page-link"
												href="javascript:searchs(${snum})">${snum}</a></li>
										</s:if>
										<s:else>
											<li class="page-item"><a class="page-link"
												href="javascript:searchs(${snum})">${snum}</a></li>
										</s:else>
									</s:iterator>
									<!-- 显示最后一页 -->
									<s:if test="bookPage.endPageNum<bookPage.totalPage">

										<s:if test="bookPage.endPageNum+1<bookPage.totalPage">
											<li class="page-item"><a class="page-link">....</a></li>
										</s:if>
										<li class="page-item"><a class="page-link"
											href="javascript:searchs(${bookPage.totalPage})">${bookPage.totalPage}</a></li>
									</s:if>

									<!-- 前往下一页的按钮-->
									<li class="page-item"><a class="page-link"
										href="javascript:searchs(${bookPage.nextPageNum})"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											<span class="sr-only">Next</span>
									</a></li>
								</ul>
							</nav>
						</div>
					</s:if>

				</div>
			</div>
		</div>
		<!-- Row End -->
		</div>
		<!-- Container End -->
	</section>
	<s:include value="/footer.jsp" />

	<form action="searchBook1" id="search2" style="display: none;">
		<input name="searchContent" value="" id="searchContent"> <input
			name="selectSearch" value="" id="selectSearch"> <input
			name="pageNum" value="" id="pageNum">
	</form>
	<script>
           function searchs(e){
        	   $("#searchContent").val('${searchContent}')
        	   $("#selectSearch").val(${selectSearch})
        	   $("#pageNum").val(e)
        	   $("#search2").submit()
        	            };
        </script>
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