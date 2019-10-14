<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BorrowList</title>
</head>
<body>

	<div style="margin: 10px auto; text-align: center">
		<h1 align="center">BorrowList</h1>



		<form action="displayBorrowrecord" method="post">
			<table border="1" width="100%">
				<tr>
					<th width="128" height="25" align="center">RecordID</th>
					<th width="157" align="center">ReaderID</th>
					<th width="147" align="center">BookID</th>
					<th width="281" align="center">BorrowingDate</th>
					<th width="281" align="center">ReturnDate</th>
					<th width="281" align="center">IsReturn</th>
					<th width="281" align="center">IsPayFine</th>
					<th width="281" align="center">Fine</th>
				</tr>
				<s:iterator value="borrowrecords">
					<tr>
						<td align="center"><s:property value="RecordID" /></td>
						<td align="center"><s:property value="ReaderID" /></td>
						<td align="center"><s:property value="BookID" /></td>
						<td align="center"><s:property value="BorrowingDate" /></td>
						<td align="center"><s:property value="ReturnDate" /></td>
						<td align="center"><s:property value="IsReturn" /></td>
						<td align="center"><s:property value="IsPayfine" /></td>
						<td align="center"><s:property value="Fine" /></td>
					</tr>
				</s:iterator>
				<tr>
					<th width="157" align="center">ReaderName</th>
				</tr>
				<s:iterator value="readers">
					<tr>
						<td align="center"><s:property value="ReaderName" /></td>
					</tr>
				</s:iterator>
				<tr>
					<th width="147" align="center">BookName</th>
				</tr>
				<s:iterator value="books">
					<tr>
						<td align="center"><s:property value="BookName" /></td>
					</tr>
				</s:iterator>
			</table>
		</form>
	</div>
	<div style="margin: 10px auto; text-align: center">
		<s:form action="findBRByReader" method="post">
			<input type="text" placeholder="Input the ReaderID" name="ReaderID" />
			<input type="submit" value="Search" />
		</s:form>
	</div>
	<div style="margin: 10px auto; text-align: center">
		<s:form action="findBRByReaderName" method="post">
			<input type="text" placeholder="Input the ReaderName"
				name="ReaderName" />
			<input type="submit" value="Search" />
		</s:form>
	</div>
	<div style="margin: 10px auto; text-align: center">
		<s:form action="displayBorrowrecord" method="post">
			<input type="submit" value="Show ALL" />
		</s:form>
	</div>
<jsp:include page="Librarian_Borrow.jsp"></jsp:include>
<jsp:include page="Librarian_Return.jsp"></jsp:include>
</body>
</html>