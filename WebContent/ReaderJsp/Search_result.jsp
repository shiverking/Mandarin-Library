<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<div class="row">
	<div class="col-md-3">
		<div class="category-sidebar">
			<div class="widget category-list">
				<h4 class="widget-header">All Category</h4>
				<ul class="category-list">

					<s:iterator value="categoryMap" status="st">
						<s:if test="%{categoryString ==key}">
							<li><a style="color: #5672f9;"
								href="searchBook?searchContent=${searchContent}&selectSearch=${selectSearch}&categoryString=<s:property value='key' />"><s:property
										value='key' /> <span> <s:property value='value' /></span></a></li>
						</s:if>
						<s:else>
							<li><a
								href="searchBook?searchContent=${searchContent}&selectSearch=${selectSearch}&categoryString=<s:property value='key' />"><s:property
										value='key' /> <span> <s:property value='value' /></span></a></li>
						</s:else>
					</s:iterator>
				</ul>
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
							<li class="list-inline-item"><a href="javascript:void(0);"><i
									class="fa fa-th-large"></i></a></li>
							<li class="list-inline-item"><a href="javascript:void(0);"><i
									class="fa fa-reorder"></i></a></li>
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
									<a data-toggle="collapse" href="#collap${bookID}"> <img
										class="card-img-top img-fluid"
										src="images/products/products-1.jpg" alt="Card image cap">
									</a>
								</div>
								<div class="card-body">
									<h4 class="card-title">
										<a data-toggle="collapse" href="#collap${bookID}">${bookName}</a>
									</h4>
									<ul class="list-inline product-meta">
										<li class="list-inline-item"><a href=""><i
												class="fa fa-book"></i>${Category}</a></li>
										<li class="list-inline-item"><a href=""><i
												class="fa fa-bookmark"></i>${ISBN}</a></li>
									</ul>
									<div class="collapse" id="collap${bookID}">
										<div class="card card-body">${Introduction}</div>
									</div>
									<p class="card-text">
										<i class="fa fa-map-marker"></i> &nbsp;${Location}
									</p>
									<s:if test="isBorrowed==0">
										<li class="list-inline-item "><strong>Status: </strong><strong
											class="text-info">Available</strong></li>
										<a class="btn-main-sm"
											href='getReaderStatuForReserveBook?book.BookID=<s:property value="BookID"/>&searchContent=${searchContent}&selectSearch=${selectSearch}&categoryString=${categoryString}&pageNum=${pageNum}'>Reserve</a>
									</s:if>
									<s:else>
										<s:if test="%{reservation.get(#L.index)!=0}">
											<li class="list-inline-item "><strong>Status: </strong>
												<strong class="text-warning">Reserved</strong></li>
										</s:if>
										<s:else>
											<li class="list-inline-item "><strong>Status: </strong>
												<strong class="text-danger">Lended</strong></li>
										</s:else>
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
						href="searchBook?searchContent=${searchContent}&selectSearch=${selectSearch}&categoryString=${categoryString}&pageNum=${bookPage.prePageNum}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
					</a></li>
					<!--显示前往第一页的按钮-->
					<s:if test="bookPage.beginPageNum>1">
						<li class="page-item"><a class="page-link"
							href="searchBook?searchContent=${searchContent}&selectSearch=${selectSearch}&categoryString=${categoryString}&pageNum=1">1</a></li>
						<s:if test="bookPage.beginPageNum>2">
							<li class="page-item"><a class="page-link">....</a></li>
						</s:if>
					</s:if>
					<!-- 显示以当前页为中心的7页 -->
					<s:iterator begin="%{bookPage.beginPageNum}"
						end="%{bookPage.endPageNum}" var="snum">
						<s:if test="#snum == bookPage.currentPage">
							<li class="page-item active"><a class="page-link"
								href="searchBook?searchContent=${searchContent}&selectSearch=${selectSearch}&categoryString=${categoryString}&pageNum=${snum}">${snum}</a></li>
						</s:if>
						<s:else>
							<li class="page-item"><a class="page-link"
								href="searchBook?searchContent=${searchContent}&selectSearch=${selectSearch}&categoryString=${categoryString}&pageNum=${snum}">${snum}</a></li>
						</s:else>
					</s:iterator>
					<!-- 显示最后一页 -->
					<s:if test="bookPage.endPageNum<bookPage.totalPage">

						<s:if test="bookPage.endPageNum+1<bookPage.totalPage">
							<li class="page-item"><a class="page-link">....</a></li>
						</s:if>
						<li class="page-item"><a class="page-link"
							href="searchBook?searchContent=${searchContent}&selectSearch=${selectSearch}&categoryString=${categoryString}&pageNum=${bookPage.totalPage}">${bookPage.totalPage}</a></li>
					</s:if>
					<!-- 前往下一页的按钮-->
					<li class="page-item"><a class="page-link"
						href="searchBook?searchContent=${searchContent}&selectSearch=${selectSearch}&categoryString=${categoryString}&pageNum=${bookPage.nextPageNum}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
							class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>