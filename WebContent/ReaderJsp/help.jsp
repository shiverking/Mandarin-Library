<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<thead class="thead-light">
								<tr>
									<th class="table-title" scope="col">BookID</th>
									<th class="table-title" scope="col">BookName</th>
									<th class="table-title" scope="col">Borrow Date</th>
									<th class="table-title" scope="col">Category</th>
								</tr>
							</thead>
							<tbody>

								<s:iterator value="borrowPage.datalist" status="L">
									<s:if test="isReturn==0">
										<tr>
											<td><s:property value="bookID" /></td>
											<td><s:property value="books[#L.index].BookName" /></td>
											<td><s:property value="borrowingDate" /></td>
											<td><s:property value="books[#L.index].Category" /></td>
										</tr>
									</s:if>
								</s:iterator>
								<!-- 显示分页信息和触发分页功能的表格 -->
								<tr>
									<td colspan="4">
										<nav aria-label="Page navigation example">
											<ul class="pagination justify-content-center">
												<li class="page-item"><a class="page-link"
													href="javascript:topage(1)" aria-label="Previous"> <span
														aria-hidden="true">&larrb;</span> <span class="sr-only">First
															page</span>
												</a></li>
												<li class="page-item"><a class="page-link"
													href="javascript:topage(${borrowPage.prePageNum})"
													aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
														<span class="sr-only">Previous</span>
												</a></li>
												<s:iterator begin="%{borrowPage.beginPageNum}"
													end="%{borrowPage.endPageNum}" var="snum">
													<s:if test="#snum == borrowPage.currentPage">
														<li class="page-item active" id="page${snum}"><a
															class="page-link" href="javascript:topage(${snum})">${snum}</a></li>
													</s:if>
													<s:else>
														<li class="page-item " id="page${snum}"><a
															class="page-link" href="javascript:topage(${snum})">${snum}</a></li>
													</s:else>
												</s:iterator>

												<li class="page-item"><a class="page-link"
													href="javascript:topage(${borrowPage.nextPageNum})"
													aria-label="Next"> <span aria-hidden="true">&raquo;</span>
														<span class="sr-only">Next</span>
												</a></li>
												<li class="page-item"><a class="page-link"
													href="javascript:topage(${borrowPage.totalPage})"
													aria-label="Previous"> <span aria-hidden="true">&rarrb;</span>
														<span class="sr-only">End page</span>
												</a></li>
											</ul>
										</nav>
									</td>
								</tr>
								<!-- 显示分页信息和触发分页功能的表格 -->
							</tbody>