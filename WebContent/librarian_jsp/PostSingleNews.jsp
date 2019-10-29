<!DOCTYPE html>
<div class="modal fade" id="PostSingleNews" tabindex="-1" role="dialog" style=""
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog " role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Post News</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div class="modal-body">
				<div class="form-group">
						</div>
						<table border="1" name="PostSingleNews">
							<form action="PostNews" method="post" >
								<div class="form-group">
								<label>Title</label>
								<input name="Title" required="required" class="form-control">
								</div>
								<div class="form-group">
								<label>Content</label><br>
								<textarea  id="T2" name="Content" class="form-main-control" rows="10" cols="50" required="required"></textarea>
								</div>
								<div class="form-group">
								<button type="submit" class="btn btn-primary" style="float:right">Submit</button>
								</div>
							</form>
						</table>
					</div>
			</div>
		</div>
	</div>
