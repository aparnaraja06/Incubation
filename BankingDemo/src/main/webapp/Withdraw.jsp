<%@ page import="bankinginfo.logic.BankingLogic" %>
<%@ page import="java.util.Map" %>
<%@ page import="account.AccountInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WITHDRAW</title>
<link rel="stylesheet" href="withdraw.css">
</head>
<body>
<%String result=(String)request.getServletContext().getAttribute("result");

String cust_id=request.getParameter("customerId");

String typeName=(String)request.getParameter("type");
%>

<jsp:include page='Menu.jsp'>
<jsp:param name="ACCOUNT DETAILS" value=" " />
        <jsp:param name="CUSTOMER DETAILS" value=" " />
        <jsp:param name="TRANSFER" value="<%=cust_id%>" />
</jsp:include>

<%if(typeName.equals("withdraw"))
{ %>
<h1>WITHDRAW AMOUNT</h1>
<form action="transaction?type=withdraw" method="post">
<div class="Container">
<%String error=(String)request.getAttribute("Error");
if(result!=null)
{
%>
<h2><%=result%></h2>
<%}
if(error!=null)
{
%>
<h3><%=error%></h3>
<%}%>
<label for="selectAccount">SELECT ACCOUNT</label><br><br>
<select name="selectAccount">
<%
if(cust_id==null)
{
	BankingLogic logic=(BankingLogic) request.getServletContext().getAttribute("Instance");

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
<% } } }%>
</select><br><br>
<label for="amount">ENTER AMOUNT</label><br><br>
<input type="number" placeholder="Enter amount" name="amount" required><br><br>
<input class="button" type="submit" value="WITHDRAW" >
</div>
</form>
<%}
else {%>
<h1>DEPOSIT AMOUNT</h1>
<form action="transaction?type=deposit" method="post">
<div class="Container">
<%String error=(String)request.getAttribute("Error");
if(result!=null)
{
%>
<h2><%=result%></h2>
<%}
if(error!=null)
{
%>
<h3><%=error%></h3>
<%}%>
<label for="selectAccount">SELECT ACCOUNT</label><br><br>
<select name="selectAccount">
<%
if(cust_id==null)
{
	BankingLogic logic=(BankingLogic) request.getServletContext().getAttribute("Instance");

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
<% } } }%>
</select>
<br><br>
<label for="amount">ENTER AMOUNT</label><br><br>
<input type="number" placeholder="Enter amount" name="amount" required><br><br>
<input class="button" type="submit" value="DEPOSIT" >
</div>
</form>
<%} %>
</body>
</html>