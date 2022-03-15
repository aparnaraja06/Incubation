<%@ page import="bankingInfo.db.ConnectDb" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="customer.CustomerInfo" %>
<%@ page import="bankinginfo.logic.BankingLogic" %>
<%@ page import="java.util.Map "%>
<%@ page import="account.AccountInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<link rel="stylesheet" href="details.css">
</head>
<body>
<%
if(session.getAttribute("customerId")==null)
{%>
	
	<jsp:forward page="Login.jsp"></jsp:forward>	

<%}else
{
int id=(int)session.getAttribute("customerId");

BankingLogic logic=(BankingLogic) request.getServletContext().getAttribute("Instance");

CustomerInfo customer=logic.getCustomerById(id);
%>

<jsp:include page='Menu.jsp'>
        <jsp:param name="TRANSFER" value=" " />
</jsp:include>
<h1>WELCOME <%=customer.getCustomerName()%> !</h1>
<h1>CUSTOMER DETAILS</h1>
<table class="center">
<tr>
<br>
<th>ACCOUNT NUMBER</th>
<th>BRANCH</th>
<th>BALANCE</th>
</tr>
<% 

Map<Integer,AccountInfo> accountMap=logic.getAccountById(id);
int acc_num=0;
for(Map.Entry<Integer,AccountInfo> entry:accountMap.entrySet())
{
	acc_num=entry.getKey();
	AccountInfo account=entry.getValue();
%>
<tr>
<td><%=acc_num %></td>
<td><%=account.getBranch()%></td>
<td><%=account.getBalance()%></td>
</tr>

<%}} %>
</table>
<nav>
<br>
<!-- <ul>
<li><a href="Transfer.jsp?customerID=<%%>" style="text-align:left">TRANSFER</a></li>
</br>
</ul>
-->
</nav>
</body>
</html>