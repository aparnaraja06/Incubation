<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD ACCOUNT</title>
</head>
<body>
<h1 style="text-align:center">ADD ACCOUNT</h1>
<form style="text-align:center" action="Welcome.jsp">
<jsp:include page='Menu.jsp'>
<jsp:param name="ACCOUNT DETAILS" value=" " />
        <jsp:param name="CUSTOMER DETAILS" value=" " />
        <jsp:param name="TRANSFER" value=" " />
</jsp:include>
<table align="center" style="margin: 0px auto;">
<br>
<caption>ACCOUNT</caption>
</br>
<tr>
<td>Customer ID</td>
<td><input type="text" placeholder="Enter the id" name="customerid" required></td>
</tr>
<tr>
<td>Branch</td>
<td><input type="text" placeholder="Enter the branch" name="branch" required></td>
</tr>
<tr>
<td>Balance</td>
<td><input type="text" placeholder="balance" name="balance" required></td>
</tr>
</table>
<br>
<input type="submit" value="Add"></input>
</br>
</form>
</body>
</html>