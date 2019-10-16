<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        Description:<input name="Introduction" required="required"/><br>
        Author:<input name="author" required="required"/><br>
        <button type="submit" value="add">Add Book</button>
      </form>
      
      </table>
      <br>
      <table border="2" name="AddBookisbn">
      <form action="addBookISBN" method = "post">
         ISBN:<input name="ISBN" required="required"><br>
         Location:<input name="Location" required="required"/><br>
         number:<input name="Number" required="required"><br>
        <button type="submit" value="add">Add Book BY ISBN</button>
      </form>
      
      </table>
</body>
</html>
