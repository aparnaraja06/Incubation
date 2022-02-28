<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="bankingInfo.db.BankingDb" %>
<%@page import="bankingInfo.db.ConnectDb" %>
<%@page import="java.sql.Connection"%>
<%@page import="bankingInfo.db.CustomerDb" %>
<%@page import="account.AccountInfo" %>
<%@page import="java.util.Map" %>
<%@page import="bankinginfo.logic.BankingLogic" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>`
<meta charset="UTF-8">
<title>HOME</title>

</head>
<body>
<h1 style="text-align:center">&emsp;&emsp;&emsp;&emsp;WELCOME</h1>
<form style="text-align:center" action="AddUpdateAccount.jsp" method="post">

<jsp:include page='Menu.jsp'>
<jsp:param name="ACCOUNT DETAILS" value=" " />
        <jsp:param name="CUSTOMER DETAILS" value=" " />
        <jsp:param name="TRANSFER" value=" " />
</jsp:include>
<br>
<br>
<br>
<h2 style="text-align:center">LIST OF ACCOUNTS</h2>
<table align="center" style="margin: 0px auto;">
<br>
<caption>ACCOUNTS</caption>
<tr>
<br>
<br><th>ACCOUNT NUMBER&emsp;</th>
<br><th>CUSTOMER ID&emsp;</th>
<br><th>BRANCH&emsp;</th>
<br><th>BALANCE&emsp;</th>
<br><th>DELETE&emsp;</th>
</tr>
<% BankingLogic logic = new BankingLogic();
Map<Integer,Map<Integer,AccountInfo>> accountMap=logic.showAllAccounts();
for(Map.Entry<Integer,Map<Integer,AccountInfo>> entry:accountMap.entrySet())
{
	int customer_id=entry.getKey();
	Map<Integer,AccountInfo> tempMap=entry.getValue();
	
	for(Map.Entry<Integer,AccountInfo> entry1:tempMap.entrySet())
	{
		int acc_num=entry1.getKey();
		AccountInfo account=entry1.getValue();
%>
<tr>
<td><a href="AddUpdateAccount.jsp"><%=acc_num%></a></td>
<td><%=customer_id%></td>
<td><%=account.getBranch()%></td>
<td><%=account.getBalance()%></td>
<td><a href="#">Remove</a></td>
</tr>
<%} }%>
</table>
<br><br>
<input  type="submit" value="ADD NEW ACCOUNTS">
<br>
</form>
</body>
</html>