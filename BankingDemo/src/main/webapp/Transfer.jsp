<%@ page import="bankinginfo.logic.BankingLogic" %>
<%@ page import="java.util.Map" %>
<%@ page import="account.AccountInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRANSFER</title>
<link rel="stylesheet" href="transfer.css">
</head>
<body>
<jsp:include page='Menu.jsp'>
<jsp:param name="ACCOUNT DETAILS" value=" " />
        <jsp:param name="CUSTOMER DETAILS" value=" " />
        <jsp:param name="TRANSFER" value=" " />
</jsp:include>
<h1>TRANSFER AMOUNT</h1>
<form action="transaction?type=transfer" method="post">
<div class="Container">
<%String error=(String)request.getAttribute("Error");
if(error!=null)
{
%>
<h3><%=error%></h3>
<%}%>
<label for="selectAccount">FROM ACCOUNT</label><br><br>
<select name="selectAccount">
<%int id=(int) session.getAttribute("customerId");
		
		BankingLogic logic=(BankingLogic) request.getServletContext().getAttribute("Instance");

if(id==0)
{
Map<Integer,Map<Integer,AccountInfo>> accountMap=logic.showAllAccounts();
for(Map.Entry<Integer,Map<Integer,AccountInfo>> entry:accountMap.entrySet())
{
	int customer_id=entry.getKey();
	Map<Integer,AccountInfo> tempMap=entry.getValue();
	for(Map.Entry<Integer,AccountInfo> entry1:tempMap.entrySet())
	{
		int account_num=entry1.getKey();
%>

<option><%=account_num%></option>
<% } } }
else
{
	Map<Integer,AccountInfo> customerMap=logic.getAccountById(id);
	for(Map.Entry<Integer,AccountInfo> entry:customerMap.entrySet())
	{
		int acc_num=entry.getKey();
	%>
	<option><%=acc_num %></option>
<% } } %>
</select>
<br><br>
<label for="toAccount">TO ACCOUNT</label><br><br>
<select name="toAccount">
<%
BankingLogic logicc=(BankingLogic) request.getServletContext().getAttribute("Instance");

Map<Integer,Map<Integer,AccountInfo>> accountMapp=logicc.showAllAccounts();
for(Map.Entry<Integer,Map<Integer,AccountInfo>> entryy:accountMapp.entrySet())
{
	int customer_id1=entryy.getKey();
	Map<Integer,AccountInfo> tempMapp=entryy.getValue();
	for(Map.Entry<Integer,AccountInfo> entryy1:tempMapp.entrySet())
	{
		int account_num1=entryy1.getKey();
%>
<option><%=account_num1%></option>
<% } }  %>
</select>
<br><br>
<label for="amount">ENTER AMOUNT</label><br><br>
<input type="number" placeholder="Enter amount" name="amount" required><br><br>
<input class="amount" type="submit" value="TRANSFER" >
<br><br><br><br>
</div>
</form>
</body>
</html>