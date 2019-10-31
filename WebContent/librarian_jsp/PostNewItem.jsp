<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.post p {
	color: #000;
}

.carousel-indicators li {
	background-color: #ccc;
}

.carousel-indicators .active {
	background-color: #26aeb5;
	height: 4px;
}
</style>
<div id="carouselExampleIndicators" class="carousel slide"
	data-ride="carousel">
	<ol class="carousel-indicators">
		<li data-target="#carouselExampleIndicators" data-slide-to="0"
			class="active"></li>
		<s:if test="posts.size()>3"><li data-target="#carouselExampleIndicators" data-slide-to="1"></li></s:if>
		<s:if test="posts.size()>6"><li data-target="#carouselExampleIndicators" data-slide-to="2"></li></s:if>
	</ol>
	<div class="carousel-inner">
		<div class="carousel-item active ">
			<div class="container">
				<div class="row">
					<s:if test="posts!=null">
						<s:iterator value="posts" status="L">
							<s:if test="#L.index<3">
								<div class="col-sm-12 col-lg-4">
									<!-- product card -->
									<div class="product-item ">
										<div class="card">
											<div class="thumb-content">
												<!-- <div class="price">$200</div> -->
											</div>
											<div class="card-body  " style="background-color: #ccc;">
												<h4 class="card-title text-center ">
													<a
														href="displaySingleNews?post.PostID=${PostID}&libname=<s:property value="librarian.LibrarianName" />"><i
														class="fa fa-info-circle"></i> <s:property value="Title" /></a>
												</h4>
												<hr>
												<div class="card-text post"
													style="display: -webkit-box; -webkit-box-orient: vertical; -webkit-line-clamp: 2; overflow: hidden; max-height: 7em; width: 300px">
													${Content}</div>
												<div class="product-ratings"></div>
											</div>
										</div>
									</div>
								</div>
							</s:if>
						</s:iterator>
					</s:if>
				</div>
			</div>
		</div>
		<s:if test="posts.size()>3">
			<div class="carousel-item">
				<div class="container">
					<div class="row">
						<s:if test="posts!=null">
							<s:iterator value="posts" status="L">
								<s:if test="#L.index>2&&#L.index<6">
									<div class="col-sm-12 col-lg-4">
										<!-- product card -->
										<div class="product-item ">
											<div class="card">
												<div class="thumb-content">
													<!-- <div class="price">$200</div> -->
												</div>
												<div class="card-body  " style="background-color: #ccc;">
													<h4 class="card-title text-center">
														<a
															href="displaySingleNews?post.PostID=${PostID}&libname=<s:property value="librarian.LibrarianName" />"><i
															class="fa fa-info-circle"></i> <s:property value="Title" /></a>
													</h4>
													<hr>
													<div class="card-text post"
														style="display: -webkit-box; -webkit-box-orient: vertical; -webkit-line-clamp: 2; overflow: hidden; max-height: 7em; width: 3000px">
														${Content}</div>
													<div class="product-ratings"></div>
												</div>
											</div>
										</div>
									</div>
								</s:if>
							</s:iterator>
						</s:if>
					</div>
				</div>
			</div>
		</s:if>
		<s:if test="posts.size()>6">
			<div class="carousel-item">
				<div class="container">
					<div class="row">
						<s:if test="posts!=null">
							<s:iterator value="posts" status="L">
								<s:if test="#L.index<3">
									<div class="col-sm-12 col-lg-4">
										<!-- product card -->
										<div class="product-item ">
											<div class="card">
												<div class="thumb-content">
													<!-- <div class="price">$200</div> -->
												</div>
												<div class="card-body  " style="background-color: #ccc;">
													<h4 class="card-title text-center">
														<a
															href="displaySingleNews?post.PostID=${PostID}&libname=<s:property value="librarian.LibrarianName" />"><i
															class="fa fa-info-circle"></i> <s:property value="Title" /></a>
													</h4>
													<hr>
													<div class="card-text post"
														style="display: -webkit-box; -webkit-box-orient: vertical; -webkit-line-clamp: 2; overflow: hidden; max-height: 7em;  width: 3000px">
														${Content}</div>
													<div class="product-ratings"></div>
												</div>
											</div>
										</div>
									</div>
								</s:if>
							</s:iterator>
						</s:if>
					</div>
				</div>
			</div>
		</s:if>
	</div>
	<s:if test="posts.size()>3"><a class="carousel-control-prev" href="#carouselExampleIndicators"
		role="button" data-slide="prev"> <span
		class="carousel-control-prev-icon " aria-hidden="true"></span> <span
		class="sr-only">Previous</span>
	</a> <a class="carousel-control-next " href="#carouselExampleIndicators"
		role="button" data-slide="next"> <span
		class="carousel-control-next-icon" aria-hidden="true"></span> <span
		class="sr-only">Next</span>
	</a></s:if>
</div>
</html>