
<!DOCTYPE html>
<div class="modal fade" id="setBook${bookID}" tabindex="-1" role="dialog" style=""
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog " role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Change Book Information</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div class="modal-body">


				<form action="editBook" method="post">
					<label>change book name</label>
					<div class="row justify-content-center">
						<input class="form-control bg-shadow col-6" type="text"
							placeholder="Enter new book name" name="BookName">
					
						<button class="btn btn-main-sm col-3 " type="submit">yes</button>
						<input class="fade" value="${bookID}" name="book.BookID">
					</div>
				</form>
				<form action="editBook" method="post">
					<label>change ISBN</label>
					<div class="row justify-content-center">
						<input class="form-control bg-shadow col-6" type="number"
							placeholder="Enter new ISBN" name="ISBN">
							
							
						<button class="btn btn-main-sm col-3 " type="submit">yes</button>
						<input class="fade" value="${bookID}" name="book.BookID">
					</div>
				</form>
				<form action="editBook" method="post">
					<label>change author</label>
					<div class="row justify-content-center">
						<input class="form-control bg-shadow col-6" type="text"
							placeholder="Enter new author" name="Author">
							
						<button class="btn btn-main-sm col-3 " type="submit">yes</button>
						<input class="fade" value="${bookID}" name="book.BookID">
					</div>
				</form>
				<form action="editBook" method="post">
					<label>change location</label>
					<div class="row justify-content-center">
					<li><label>Floor<br></label> <select name="Location"
										required="required">
											<option value="first floor">first floor</option>
											<option value="second floor">second floor</option>
											<option value="third floor">third floor</option>
									</select></li>
									<li><label>Area<br></label> <select name="Location"
										required="required">
											<option value="A area">A</option>
											<option value="B area">B</option>
											<option value="C area">C</option>
											<option value="D area">D</option>

									</select></li>
					<button class="btn btn-main-sm col-3 " type="submit">yes</button>
							<input class="fade" value="${bookID}" name="book.BookID">
						
					</div>
				</form>
				<form action="editBook" method="post">
					<label>change category</label>
					<div class="row justify-content-center">
					<li class="col-6"><label>category:<br></label> <select name="Category"
										required="required">
											<option value="Literature">Literature</option>
											<option value="Arts">Arts</option>
											<option value="History&Geography">History&Geography</option>
											<option value="Science">Science</option>
											<option value="Politics&Law">Politics&Law</option>
											
											<option value="Philosophy&Religion">Philosophy&Religion</option>
									</select></li>
					<button class="btn btn-main-sm col-3 " type="submit">yes</button>
							<input class="fade" value="${bookID}" name="book.BookID">
						
					</div>
				</form>
		
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-main-sm" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
