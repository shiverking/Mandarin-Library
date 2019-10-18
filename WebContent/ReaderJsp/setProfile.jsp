
<!DOCTYPE html>
<div class="modal fade" id="setProfile" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog " role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Enter your Email
					to retrieve your password</h5>
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
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
