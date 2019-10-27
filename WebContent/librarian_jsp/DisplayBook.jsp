<!DOCTYPE html>
<div id="a">
							<td><a href="addBookPage">AddBook</a>
								<form action="displayBooks" method="post">
									<table border="1" width="100%">
										<tr>
											<th width="128" height="25" align="center">BookID</th>
											<th width="157" align="center">BookName</th>
											<th width="147" align="center">ISBN</th>
											<th width="281" align="center">Price</th>
											<th width="281" align="center">Location</th>
											<th width="281" align="center">IsBorrowed</th>
											<th width="281" align="center">Category</th>
											<th width="281" align="center">Operation</th>
										</tr>
										<s:iterator value="books">
											<tr>
												<td align="center"><s:property value="BookID" /></td>
												<td align="center"><s:property value="BookName" /></td>
												<td align="center"><s:property value="ISBN" /></td>
												<td align="center"><s:property value="Price" /></td>
												<td align="center"><s:property value="Location" /></td>
												<td align="center"><s:property value="IsBorrowed" /></td>
												<td align="center"><s:property value="Category" /></td>
												<td><a
													href='editBook?book.BookID=<s:property value="BookID"/>'>Edit/</a><a
													href='deleteBook?book.BookID=<s:property value="BookID"/>'>Delete</a>
												</td>
											</tr>
										</s:iterator>

									</table>
								</form>
						</div>