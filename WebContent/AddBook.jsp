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
        <li><label>Floor</label>
<select name="Location" required="required">                      
<option value="first floor">first floor</option> 
<option value="second floor">second floor</option>
<option value="third floor">third floor</option>
</select>
</li> 
<li><label>Area</label>
<select name="Location" required="required">                      
<option value="A area">A</option> 
<option value="B area">B</option>
<option value="C area">C</option>
<option value="D area">D</option>

</select>
</li> 
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
         <li><label>Floor</label>
        <select name="Location" required="required">                      
		<option value="first floor">first floor</option> 
		<option value="second floor">second floor</option>
		<option value="third floor">third floor</option>
		</select>
	</li> 
	<li><label>Area</label>
	<select name="Location" required="required">                      
		<option value="A area">A</option> 
		<option value="B area">B</option>
		<option value="C area">C</option>
		<option value="D area">D</option>

</select>
</li> <br>
         number:<input name="Number" required="required"><br>
        <button type="submit" value="add">Add Book BY ISBN</button>
      </form>
      
      </table>
</body>
</html>
