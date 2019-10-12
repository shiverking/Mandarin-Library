<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<form action="librariansignup" method="post">
username<input type="text" name="LibrarianName"><br>
password<input type="password" name="Password"><br>
confirm<input type="password" name="ConfirmPassword"><br>
<button type="submit" value="signup">register</button>
<script type="text/javascript">
 //错误提示信息
 var msg=""+'${request.tipMessage}';
 if(msg!=""){
    alert(msg);
 } 
    //-->
</script>
</form>
</body>
</html>