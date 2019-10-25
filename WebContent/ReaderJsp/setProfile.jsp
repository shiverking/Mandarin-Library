
<!DOCTYPE html>
<div class="modal fade" id="setProfile" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog " role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Set up your
					personal information</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div class="modal-body">


				<form action="changeReaderName" method="post">
					<label>change your name</label>
					<div class="row justify-content-center">
						<input class="form-control bg-shadow col-6" type="text"
							placeholder="Enter your new name" name="ReaderName">
						<button class="btn btn-main-sm col-3 " type="submit">yes</button>
					</div>
				</form>

				<form action="changeReaderPassword" method="post">

					<label>change your Password</label>
					<div class="row justify-content-center">
						<input class="form-control bg-shadow col-6" type="password"
							placeholder="Enter your new Password" name="Password">
						<button class=" btn btn-main-sm col-3 " type="submit">yes</button>
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
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
