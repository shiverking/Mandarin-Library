
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
							<input class="fade" value="${bookID}" name="book.BookID">
						<button class="btn btn-main-sm col-3 " type="submit">yes</button>
					</div>
				</form>
				<form action="editBook" method="post">
					<label>change ISBN</label>
					<div class="row justify-content-center">
						<input class="form-control bg-shadow col-6" type="number"
							placeholder="Enter new ISBN" name="ISBN">
							<input class="fade" value="${bookID}" name="book.BookID">
							
						<button class="btn btn-main-sm col-3 " type="submit">yes</button>
					</div>
				</form>
				<form action="editBook" method="post">
					<label>change author</label>
					<div class="row justify-content-center">
						<input class="form-control bg-shadow col-6" type="text"
							placeholder="Enter new author" name="Author">
							<input class="fade" value="${bookID}" name="book.BookID">
						<button class="btn btn-main-sm col-3 " type="submit">yes</button>
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
					
							<input class="fade" value="${bookID}" name="book.BookID">
						<button class="btn btn-main-sm col-3 " type="submit">yes</button>
					</div>
				</form>
				<form action="changeReaderAvatar" method="post"
					enctype="multipart/form-data">
					<label>change your avatar</label>
					<div class="row justify-content-center">
						<input class=" input form-control  bg-shadow col-6 " name="filename"
							value="Select a picture to upload" readonly id="display"
							onclick="upimg()"> <input style="display: none;"
							id="file" type="file" accept="image/png ,image/gif "
							name="avatarFile" onChange="flashdp()">
						<button class="btn btn-main-sm col-3 " type="submit">yes</button>
					</div>
										<script>
						function upimg() {
							$("#file").trigger("click");
						}
						function flashdp() {
	
							var str = $("#file").val();
							var arr = str.split('\\');//注split可以用字符或字符串分割
							var my = arr[arr.length - 1];//这就是要取得的图片名称
							$("#display").val(my);
						}
					</script>
				</form>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-main-sm" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
