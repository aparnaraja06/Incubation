<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CUSTOMER DETAILS</title>
</head>
<body>
<h1 style="text-align:center">LIST OF CUSTOMERS</h1>
<form style="text-align:center" action="AddUpdateCustomer.jsp">
<jsp:include page='Menu.jsp'>
<jsp:param name="ACCOUNT DETAILS" value=" " />
        <jsp:param name="CUSTOMER DETAILS" value=" " />
        <jsp:param name="TRANSFER" value=" " />
</jsp:include>
<table align="center" style="margin: 0px auto;">
<br>
<caption>CUSTOMERS</caption>
<tr>
<br>
<br><th>CUSTOMER ID&emsp;</th>
<br><th>CUSTOMER NAME&emsp;</th>
<br><th>GENDER&emsp;</th>
<br><th>MOBILE NUMBER&emsp;</th>
<br><th>DELETE&emsp;</th>
</tr>
<tr>
<td><a href="AddUpdateCustomer.jsp">101</a></td>
<td>Sam&emsp;</td>
<td>Male&emsp;</td>
<td>9234798323&emsp;</td>
<td><a href="#">Remove</a></td>
</tr>
</table>
<br><br>
<input type="submit" value="ADD NEW CUSTOMERS">
</body>
</html>