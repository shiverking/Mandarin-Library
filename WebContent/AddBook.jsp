<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>AddBook</title>
</head>
<body>
      <table border="1" name="AddBook">
      <form action="addBook" method = "post">
        BookName:<input name="BookName" required="required"><br>
        Price:<input name="Price" required="required"/><br>
      	Location:<input name="Location" required="required"/><br>
        category:<input name="Category" required="required"/><br>
        Number:<input name="Num" required="required"/><br>
        <button type="submit" value="add">Add Book</button>
      </form>
      </table>
</body>
</html>
