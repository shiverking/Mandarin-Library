<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<div class="row">
	<div class="col-md-3">
		<div class="category-sidebar">
			<div class="widget category-list">
				<h4 class="widget-header">
					<a href="javascript:searcha('')">All Category</a>
				</h4>
				<ul class="category-list">

					<s:iterator value="categoryMap" status="st">
						<s:if test="%{categoryString ==key}">
							<li><a style="color: #5672f9;"
								href="javascript:searcha('<s:property value='key'/>')"><s:property
										value='key' /> <span
									style="color: #fff; background: #5672f9;"> <s:property
											value='value' /></span></a></li>
						</s:if>
						<s:else>
							<li><a
								href="javascript:searcha('<s:property value='key'/>')"><s:property
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
				<div class="col-md-6"></div>
				<div class="col-md-6">
					<div class="view">
						<strong>Views</strong>
						<ul class="list-group list-inline view-switcher">
							<s:if test="%{displayStyle ==true}">
								<li class="list-inline-item"><a
									class="list-group-item-action active" data-toggle="list"
									href="#home" role="tab"><i class="fa fa-th-large"></i></a></li>
								<li class="list-inline-item"><a
									class="list-group-item-action" data-toggle="list"
									href="#profile" role="tab"><i class="fa fa-reorder"></i></a></li>
							</s:if>
							<s:else>
								<li class="list-inline-item"><a
									class="list-group-item-action " data-toggle="list" href="#home"
									role="tab"><i class="fa fa-th-large"></i></a></li>
								<li class="list-inline-item"><a
									class="list-group-item-action active" data-toggle="list"
									href="#profile" role="tab"><i class="fa fa-reorder"></i></a></li>
							</s:else>

						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- Tab panes -->
		<!-- 搜索结果页面 -->

		<div class="tab-content">
			<s:if test="%{displayStyle ==true}">
				<div class="tab-pane fade active show" id="home" role="tabpanel">
			</s:if>
			<s:else>
				<div class="tab-pane fade " id="home" role="tabpanel">
			</s:else>
			<div class="product-grid-list col-12" ID="VIEW1">
				<div class="row mt-30">
					<s:iterator value="bookPage.dataList" status="L1">
						<div class="col-sm-12 col-lg-4 col-md-6">
							<!-- product card -->
							<div class="product-item bg-light">
								<div class="card">
									<div class="thumb-content" style="text-align: center">
										<!-- <div class="price">$200</div> -->
										<a data-toggle="collapse" href="#collap${bookID}"> <img
											class="card-img-top img-fluid" src="${ImageAddress}" onerror="{this.src='images/book-default-lpic.gif'}"
											alt="Card image cap" style="height: 200px; width: auto;">
										</a>
									</div>
									<div class="card-body">
										<h4 class="card-title">
											<a data-toggle="collapse" href="#collap${bookID}">${bookName}</a>
										</h4>
										<ul class="list-inline product-meta">
											<li class="list-inline-item"><a><i
													class="fa fa-book"> Category:</i>${Category}</a></li>
											<li class="list-inline-item"><a><i
													class="fa fa-bookmark"> ISBN:</i>${ISBN}</a></li>
											<li class="list-inline-item"><a><i
													class="fa fa-pencil" aria-hidden="true"> Author:</i>${Author}</a></li>
										</ul>

										<p class="card-text">
											<i class="fa fa-map-marker"> Location:</i> &nbsp;${Location}
										</p>
										<s:if test="isBorrowed==0">
											<li class="list-inline-item "><strong>Status:</strong><strong
												class="text-info">Available</strong></li>
											<a class="btn-main-sm"
												href='javascript:ReserveBook(<s:property value="BookID"/>)'>Reserve</a>
										</s:if>
										<s:elseif test="reservations.get(#L1.index)!=0">
											<li class="list-inline-item "><strong>Status: </strong>
												<strong class="text-warning">Reserved</strong></li>
										</s:elseif>
										<s:else>
											<li class="list-inline-item "><strong>Status: </strong>
												<strong class="text-danger">Lended</strong></li>
										</s:else>
										<div class=" collapse" id="collap${bookID}">
											<div
												style="overflow-y: scroll; max-height: 250px; width: 110%; margin: 0 auto;">
												<strong>Introduction:</strong>
												<div class="card card-body" style="text-indent: 2em">${Introduction}</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</s:iterator>
				</div>
			</div>
		</div>
		<s:if test="%{displayStyle !=true}">
			<div class="tab-pane fade active show" id="profile" role="tabpanel">
		</s:if>
		<s:else>
			<div class="tab-pane fade" id="profile" role="tabpanel">
		</s:else>
		<div class="accordion col-12" ID="VIEW2">
			<div class="row ">
				<s:iterator value="bookPage.dataList" status="L2">

					<!-- product card -->
					<div class="product-item bg-light">
						<div class="row">
							<div class="thumb-content col-3">
								<!-- <div class="price">$200</div> -->
								<a data-toggle="collapse" href="#collap2${bookID}"> <img
									class="card-img-top img-fluid" src="${ImageAddress}"
									alt="Card image cap" style="height: 200px; width: 150px;">
								</a>
							</div>
							<div class=" col-8">
								<h4 class="card-title">
									<a data-toggle="collapse" href="#collap2${bookID}">${bookName}</a>
								</h4>
								<ul class="list-inline product-meta">
									<li class="list-inline-item"><a><i class="fa fa-book">
												Category:</i>${Category}</a></li>
									<li class="list-inline-item"><a><i
											class="fa fa-bookmark"> ISBN:</i>${ISBN}</a></li>
									<li class="list-inline-item"><a><i
											class="fa fa-pencil" aria-hidden="true"> Author:</i>${Author}</a></li>
									<li class="list-inline-item"><i class="fa fa-map-marker">
											Location:</i> &nbsp;${Location}</li>
									<li class="list-inline-item"><s:if test="isBorrowed==0">
											<li class="list-inline-item "><strong>Status:</strong><strong
												class="text-info">Available</strong></li>
											<a class="btn-main-sm"
												href='javascript:ReserveBook(<s:property value="BookID"/>)'>Reserve</a>
										</s:if> <s:elseif test="reservations.get(#L2.index)!=0">
											<li class="list-inline-item "><strong>Status: </strong>
												<strong class="text-warning">Reserved</strong></li>
										</s:elseif> <s:else>
											<li class="list-inline-item "><strong>Status: </strong>
												<strong class="text-danger">Lended</strong></li>
										</s:else>
								</ul>
							</div>
							<div class="collapse col-12" id="collap2${bookID}">
								<div
									style="overflow-y: scroll; max-height: 350px; width: 100%; margin: 0 auto; text-indent: 2em">
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


<!--分页按钮  -->
<div class="pagination justify-content-center">
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<!--前往上一页的按钮-->
			<li class="page-item"><a class="page-link"
				href="javascript:searchb(${bookPage.prePageNum})"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span
					class="sr-only">Previous</span>
			</a></li>
			<!--显示前往第一页的按钮-->
			<s:if test="bookPage.beginPageNum>1">
				<li class="page-item"><a class="page-link"
					href="javascript:searchb(1)">1</a></li>
				<s:if test="bookPage.beginPageNum>2">
					<li class="page-item"><a class="page-link">....</a></li>
				</s:if>
			</s:if>
			<!-- 显示以当前页为中心的7页 -->
			<s:iterator begin="%{bookPage.beginPageNum}"
				end="%{bookPage.endPageNum}" var="snum">
				<s:if test="#snum == bookPage.currentPage">
					<li class="page-item active"><a class="page-link"
						href="javascript:searchb(${snum})">${snum}</a></li>
				</s:if>
				<s:else>
					<li class="page-item"><a class="page-link"
						href="javascript:searchb(${snum})">${snum}</a></li>
				</s:else>
			</s:iterator>
			<!-- 显示最后一页 -->
			<s:if test="bookPage.endPageNum<bookPage.totalPage">

				<s:if test="bookPage.endPageNum+1<bookPage.totalPage">
					<li class="page-item"><a class="page-link">....</a></li>
				</s:if>
				<li class="page-item"><a class="page-link"
					href="javascript:searchb(${bookPage.totalPage})">${bookPage.totalPage}</a></li>
			</s:if>

			<!-- 前往下一页的按钮-->
			<li class="page-item"><a class="page-link"
				href="javascript:searchb(${bookPage.nextPageNum})" aria-label="Next">
					<span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
			</a></li>
		</ul>
	</nav>
</div>

<form action="searchBook" id="search2" style="display: none;">
	<input name="searchContent" value="" id="searchContent"> <input
		name="selectSearch" value="" id="selectSearch"> <input
		name="categoryString" value="" id="categoryString"> <input
		name="displayStyle" value="" id="displayStyle"> <input
		name="pageNum" value="" id="pageNum">
</form>
<form action="getReaderStatuForReserveBook" id="reservations"
	style="display: none;">
	<input name="searchContent" value="" id="RsearchContent"> <input
		name="selectSearch" value="" id="RselectSearch"> <input
		name="categoryString" value="" id="RcategoryString"> <input
		name="displayStyle" value="" id="RdisplayStyle"> <input
		name="pageNum" value="" id="RpageNum"> <input
		name="book.BookID" value="" id="BookID">
</form>
<script>
           function searchb(e){
        	   $("#searchContent").val('${searchContent}')
        	   $("#selectSearch").val(${selectSearch})
        	   $("#categoryString").val('${categoryString}')
        	   $("#pageNum").val(e)
        	   $("#displayStyle").val(document.getElementById("home").className=="tab-pane fade active show")
        	   $("#search2").submit()
        	            }
           function searcha(e){
        	   $("#searchContent").val('${searchContent}')
        	   $("#selectSearch").val(${selectSearch})
        	   $("#categoryString").val(e)
        	   $("#displayStyle").val(document.getElementById("home").className=="tab-pane fade active show")
        	   $("#search2").submit()
           }
           function ReserveBook(e){
        	   $("#RsearchContent").val('${searchContent}')
        	   $("#RselectSearch").val(${selectSearch})
        	   $("#RcategoryString").val('${categoryString}')
        	   $("#BookID").val(e)
        	   $("#RpageNum").val(${bookPage.currentPage})
        	   $("#RdisplayStyle").val(document.getElementById("home").className=="tab-pane fade active show")
        	           	   $("#reservations").submit()
           }
        </script>
</div>
</div>
