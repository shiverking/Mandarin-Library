<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<% String path = request.getContextPath();%>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>404<%=path%></title>

<link rel="stylesheet" type="text/css" href="<%=path%>/error/scr/normalize.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/error//scr/demo.css">
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="<%=path%>/error//scr/component.css">
<!--[if IE]><script src="souye/js/html5.js"></script><![endif]-->

<style type="text/css">
#Layer1 {position:absolute;	width:100%;	z-index:2;	top: 60%;}
.STYLE3 {font-size: medium}
</style>

</head>
<body>

<div class="container demo-1">
	<div class="content">
		<div id="large-header" class="large-header" style="height: 917px;">
			<canvas id="demo-canvas" width="1920" height="917"></canvas>
			<h1 class="main-title">404<br><span class="STYLE3">sorry! The page cannot be found</span></h1>
		</div>
		<div id="Layer1">
			<nav class="codrops-demos">
				<a href="../index.jsp">Return Index</a>
			</nav>
		</div>
	</div>
</div>


<script src="<%=path%>/error//scr/TweenLite.min.js"></script>
<script src="<%=path%>/error//scr/EasePack.min.js"></script>
<script src="<%=path%>/error//scr/rAF.js"></script>
<script src="<%=path%>/error//scr/demo-1.js"></script>

</body></html>