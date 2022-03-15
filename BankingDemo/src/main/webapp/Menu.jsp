<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MENU</title>
<link rel="stylesheet" href="menu.css">
</head>
<body>
<nav>
<br>
<%
String name=(String)session.getAttribute("username");
if(session.getAttribute("customerId")==null)
{%>
<jsp:forward page="Login.jsp"></jsp:forward>	
	
<%}
else
{
	int cust_id=(int)session.getAttribute("customerId");
if(cust_id==0)
{
//	System.out.println("Inside if"+cust_id);
%>
<ul>
<li><a href="Welcome.jsp">ACCOUNT DETAILS</a></li>
<li><a href="CustomerDetails.jsp">CUSTOMER DETAILS</a></li>
<li><a href="Transfer.jsp">TRANSFER</a></li>

<li><a href="Withdraw.jsp?type=withdraw">WITHDRAW</a></li>
<li><a href="Withdraw.jsp?type=deposit">DEPOSIT</a></li>
<li><a href="logout">LOGOUT</a></li>

<li class="name">
<img src="user-security-5000473-4164979.webp" class="menuImg" title="User">
<%=name%></li>

</ul>
<% } 
else
{
	//int cust_id=(int)session.getAttribute("customerId");
// 	int customerId=Integer.parseInt(cust_id);
%>
<ul>
<li><a href="HomeCustomer.jsp">HOME</a></li>
<li><a href="Transfer.jsp?customerId=<%=cust_id%>">TRANSFER</a></li>
<li><a href="logout">LOGOUT</a></li>
</ul>
<%} }%>
</nav>
</body>
</html>