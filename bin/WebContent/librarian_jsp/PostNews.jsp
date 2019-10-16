<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Post</title>
</head>
<body>
 <table border="1" name="AddBook">
      <form action="PostNews" method = "post" textarea rows="10" cols="30">
        Title:<input name="Title" required="required"><br>
        Content:<br> <textarea rows="10" cols="30" name="Content" required="required"/></textarea>
       <br> <button type="submit" value="update">Update Post</button>
      </form>
      </table>
</body>
</html>