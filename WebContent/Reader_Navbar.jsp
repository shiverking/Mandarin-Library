<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top mb-4 ">
	<a class="navbar-brand" href="#">Navbar</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>

		</ul>

		<form action="getReaderStatuForSearch" class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="text" name="searchContent"
				placeholder="Search by title or ISBN" aria-label="Search">
			<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
		</form>
		<ul class="nav navbar-nav ml-auto justify-content-end">
			<li class="nav-item dropdown"><a href="#"
				data-toggle="dropdown" class="nav-link dropdown-toggle user-action"><img
					src="https://avatars3.githubusercontent.com/u/31076337?s=460&v=4"
					class="avatar" alt="Avatar"></a>
				<ul class="dropdown-menu dropdown-menu-right">
					<li><a href="getReaderStatuForRecord.action" class="dropdown-item">Borrowing Record</a></li>
					<li class="divider dropdown-divider"></li>
					<li><a href="#" class="dropdown-item">Setting</a></li>
					<li class="divider dropdown-divider"></li>
					<li><a href="readersignout.action" class="dropdown-item">Sign Out</a></li>
				</ul></li>
		</ul>
	</div>
<style>
.avatar{
 border-radius: 50%;
  width: 30px;
  height: 30px;
  margin-right: 10px;
}
</style>
</nav>

