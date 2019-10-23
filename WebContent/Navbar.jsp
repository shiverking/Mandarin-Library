<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<section>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-expand-lg  navigation">
					<a class="navbar-brand" href="index.jsp"> <img
						src="images/MLA_logo_tagline.png" width="100px" >
					</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"><i class="fa fa-bars" aria-hidden="true"></i></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav ml-auto main-nav ">
							<li class="nav-item active"><a class="nav-link"
								href="index.jsp">Home</a></li>
							<li class="nav-item"><a class="nav-link"
								href="dashboard.html">Dashboard</a></li>
							<li class="nav-item dropdown dropdown-slide"><a
								class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"> Pages <span><i
										class="fa fa-angle-down"></i></span>
							</a> <!-- Dropdown list -->
								<div class="dropdown-menu dropdown-menu-right">
									<a class="dropdown-item" href="category.html">Category</a> <a
										class="dropdown-item" href="single.html">Single Page</a> <a
										class="dropdown-item" href="store-single.html">Store
										Single</a> <a class="dropdown-item" href="dashboard.html">Dashboard</a>
									<a class="dropdown-item" href="user-profile.html">User
										Profile</a> <a class="dropdown-item" href="submit-coupon.html">Submit
										Coupon</a> <a class="dropdown-item" href="blog.html">Blog</a> <a
										class="dropdown-item" href="single-blog.html">Single Post</a>
								</div></li>
							<s:if test="#session.reader==null">
								<li class="nav-item dropdown dropdown-slide"><a
									class="nav-link dropdown-toggle" href="" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"> Listing <span><i
											class="fa fa-angle-down"></i></span>
								</a> <!-- Dropdown list -->
									<div class="dropdown-menu dropdown-menu-right">
										<a class="dropdown-item" href="#">Action</a> <a
											class="dropdown-item" href="#">Another action</a> <a
											class="dropdown-item" href="#">Something else here</a>
									</div></li>
							</s:if>
							<s:else>
								<li class="nav-item dropdown dropdown-slide"><a
									class="nav-link dropdown-toggle" href="" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"> History <span><i
											class="fa fa-angle-down"></i></span>
								</a> <!-- Dropdown list -->
									<div class="dropdown-menu dropdown-menu-right">
										<a class="dropdown-item" href="getReaderStatuForCurrent">Reservation
											record</a> <a class="dropdown-item"
											href="getReaderStatuForBorrowPage">Current Borrowing</a> <a
											class="dropdown-item" href="getReaderStatuForReturn">Return
											History</a>
									</div></li>
							</s:else>
						</ul>
						<s:if test="#session.librarian!=null">
							<ul class="navbar-nav ml-auto mt-10">
								<li class="nav-item"><a class="nav-link login-button"
									href="#">Logout</a></li>
							</ul>
						</s:if>
						<s:elseif test="#session.reader!=null">
							<ul class="navbar-nav ml-auto mt-10">
								<li class="nav-item"><a class="nav-link login-button"
									href="readersignout">Logout <i class="fa fa-sign-out"
										aria-hidden="true"></i></a></li>
							</ul>
						</s:elseif>
						<s:else>
							<ul class="navbar-nav ml-auto mt-10">
								<li class="nav-item"><a class="nav-link add-button"
									href="Login.jsp"> Login <i class="fa fa-sign-in"
										aria-hidden="true"></i></a></li>
							</ul>
						</s:else>
					</div>
				</nav>
			</div>
		</div>
	</div>
</section>