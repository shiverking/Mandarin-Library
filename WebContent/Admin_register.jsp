<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
<title>Register</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body >
	<div id="toast">
		<div id="img">
			<i class="fas fa-exclamation-circle"></i>
		</div>
		<p id="desc"></p>
	</div>
	<form action="librariansignup" method="post">
	username<input type="text" name="LibrarianName"><br>
	password<input type="password" name="Password"><br>
	confirm<input type="password" name="ConfirmPassword"><br>
	<button type="submit" value="signup">register</button>
	</form>
	<script>
		function launch_toast() {
			var x = document.getElementById("toast")
			x.className = "show";
			var desc = document.getElementById("desc");
			desc.innerHTML = "<s:property value="errorMessage"></s:property>";
			setTimeout(function() {
				x.className = x.className.replace("show", "");
			}, 2900);
		};

		(function() {
			// your page initialization code here
			// the DOM will be available here
			if ("<s:property value="errorMessage"></s:property>" == "") {
				console.log("no error");
			} else {
				launch_toast();
			}
		})();
	</script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>