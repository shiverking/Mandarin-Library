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

						</div>
						<div class="card-body">
							<h4 class="card-title text-center">
								<a href=""><s:property value="Title" /></a>
							</h4>
							<hr>
							<div class="card-text"
								style="display: -webkit-box; -webkit-box-orient: vertical; -webkit-line-clamp: 2; overflow: hidden;max-height:7em">
								${Content}
							</div>
							<div class="product-ratings"></div>
						</div>
					</div>
				</div>
			</div>
		</s:if>
	</s:iterator>
</s:if>
</html>