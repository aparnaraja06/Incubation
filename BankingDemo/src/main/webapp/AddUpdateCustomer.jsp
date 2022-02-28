<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD CUSTOMER</title>
</head>
<body>
<h1 style="text-align:center">ADD CUSTOMER</h1>
<form style="text-align:center" action="Welcome.jsp">
<jsp:include page='Menu.jsp'>
<jsp:param name="ACCOUNT DETAILS" value=" " />
        <jsp:param name="CUSTOMER DETAILS" value=" " />
        <jsp:param name="TRANSFER" value=" " />
</jsp:include>
<table align="center" style="margin: 0px auto;">
<br>
<caption>CUSTOMER</caption>
</br>
<tr>
<td>Name</td>
<td><input type="text" placeholder="Enter the name" name="customername" required></td>
</tr>
<tr>
<td>Gender</td>
<td><input type="text" placeholder="Male/Female" name="gender" required></td>
</tr>
<tr>
<td>Mobile number</td>
<td><input type="text" placeholder="Mobile number" name="mobile" required></td>
</tr>
</table>
<br>
<input type="submit" value="Add">
</br>
</form>
</body>
</html>