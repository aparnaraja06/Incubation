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
</head>
<body>
<jsp:include page='Menu.jsp'>
        <jsp:param name="TRANSFER" value=" " />
</jsp:include>
<h1 style="text-align:center">WELCOME!</h1>
<br><br><br>
<h2 style="text-align:center">CUSTOMER DETAILS</h2>
<table align="center" style="margin: 0px auto;">
<br>
<caption>DETAILS</caption>
<tr>
<br>
<br><th>ACCOUNT NUMBER&emsp;</th>
<br><th>BRANCH&emsp;</th>
<br><th>BALANCE&emsp;</th>
</tr>
<% CustomerInfo customer=(CustomerInfo)request.getAttribute("customerId");
int id=customer.getCustomerID();
BankingLogic logic=new BankingLogic();
Map<Integer,AccountInfo> accountMap=logic.getAccountById(id);
int acc_num=0;
for(Map.Entry<Integer,AccountInfo> entry:accountMap.entrySet())
{
	acc_num=entry.getKey();
	AccountInfo account=entry.getValue();
%>
<tr>
<td><%=acc_num %>&emsp;</td>
<td><%=account.getBranch()%>&emsp;</td>
<td><%=account.getBalance()%>&emsp;</td>
</tr>

<%} %>
</table>
<nav>
<br>
<ul>
<li><a href="Transfer.jsp" style="text-align:left">TRANSFER</a></li>
</br>
</ul>
</nav>
</body>
</html>