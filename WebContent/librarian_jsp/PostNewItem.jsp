<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:if test="posts!=null">
	<s:iterator value="posts" status="L">
		<s:if test="#L.index<3">
			<div class="col-sm-12 col-lg-4">
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
								<a href=""><s:property value="Title" /></a>
							</h4>
							<ul class="list-inline product-meta">
								<li class="list-inline-item"><a href=""><i
										class="fa fa-folder-open-o"></i><s:property value="librarian.LibrarianName" /></a></li>
								<li class="list-inline-item"><a href=""><i
										class="fa fa-calendar"></i>26th December</a></li>
							</ul>
							<p class="card-text"><s:property value="Content" /></p>
							<div class="product-ratings">
								<ul class="list-inline">
									<li class="list-inline-item selected"><i
										class="fa fa-star"></i></li>
									<li class="list-inline-item selected"><i
										class="fa fa-star"></i></li>
									<li class="list-inline-item selected"><i
										class="fa fa-star"></i></li>
									<li class="list-inline-item selected"><i
										class="fa fa-star"></i></li>
									<li class="list-inline-item"><i class="fa fa-star"></i></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</s:if>
	</s:iterator>
</s:if>
</html>