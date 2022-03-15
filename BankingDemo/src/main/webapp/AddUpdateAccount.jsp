<%@ page import="bankinginfo.logic.BankingLogic" %>
<%@ page import="java.util.Map" %>
<%@ page import="customer.CustomerInfo" %>
<%@ page import="account.AccountInfo" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD ACCOUNT</title>
<link rel="stylesheet" href="add.css">
</head>
<body>
<%
String typeName=(String)request.getParameter("type");
%>
<jsp:include page='Menu.jsp'>
<jsp:param name="ACCOUNT DETAILS" value=" " />
        <jsp:param name="CUSTOMER DETAILS" value=" " />
        <jsp:param name="TRANSFER" value=" " />
</jsp:include>
<%if(typeName.equals("addAccount")) 
{%>
<h1>ADD ACCOUNT</h1>
<form action="accountServlet?type=addAccount" method="post">
<div class="Container">
<%String result=(String)request.getAttribute("result");
if(result!=null)
{
%>
<h3><%=result%></h3>
<%}%>
<label for="customerid">CUSTOMER ID</label><br><br>
<select name="customerid">
<%
BankingLogic logic=(BankingLogic) request.getServletContext().getAttribute("Instance");

		Map<Integer,CustomerInfo> customerMap=logic.showAllCustomers();
		for(Map.Entry<Integer,CustomerInfo> entry:customerMap.entrySet())
		{
			int customer_id=entry.getKey();
 %>
<option><%=customer_id %></option>
<%}%>
</select><br><br>
<!--  <input type="text" placeholder="Enter the id" name="customerid" required><br><br> -->
<label for="branch">BRANCH</label><br><br>
<select name="branch">
<% 
List<String> branches=logic.getAllBranches();
for(String branch:branches)
{	
%>
<option><%=branch%></option>
<%}%>
</select><br><br>
<label for="mobile">BALANCE</label><br><br>
<input type="number" placeholder="balance" name="balance" min="1000" required><br><br>
<br>
<input class="subButton" type="submit" value="Add" name="page"></input>
</div>
</form>
<%}
else if(typeName.equals("editAccount"))
{
	BankingLogic logic=(BankingLogic) request.getServletContext().getAttribute("Instance");
	
	 String customerId=request.getParameter("customerId");
	 String accountNum=request.getParameter("accountNum");
	 int acc_num=Integer.valueOf(accountNum);
	 int cust_id=Integer.valueOf(customerId);
	 
	
	 AccountInfo account=logic.getAccountByAccountNum(cust_id,acc_num);
	 String getBranch=account.getBranch();
%>
<h1>EDIT ACCOUNT</h1>
<form action="accountServlet?type=editAccount&accountNum=<%=acc_num%>" method="post">
<div class="Container">
<label class="accountNum"><b>ACCOUNT NUMBER <%=acc_num%></b></label><br><br>
<%String result=(String)request.getAttribute("result");
if(result!=null)
{
%>
<h3><%=result%></h3>
<%}%>
<label for="customerid">CUSTOMER ID</label><br><br>
<select name="customerid">
<%
		Map<Integer,CustomerInfo> customerMap=logic.showAllCustomers();
		for(Map.Entry<Integer,CustomerInfo> entry:customerMap.entrySet())
		{
			int customer_id=entry.getKey();
%>
<option <%if(customer_id==cust_id){  %>selected="selected" <%} %> > <%=customer_id%></option>
<%}%>
</select><br><br>
  <label for="branch">BRANCH</label><br><br>
  <select name="branch">
 <% 
List<String> branches=logic.getAllBranches();
for(String branch:branches)
{
%>
<option <%if(getBranch.equals(branch)){ %>selected="selected"<%}%> > <%=branch%></option>
<%}%>
  </select><br><br>
  <label for="balance">BALANCE</label><br><br>
  <input type="number" id="balance" name="balance" min="1000" value="<%=account.getBalance()%>" required><br><br>
  <input  class="subButton" type="submit" value="Edit">
  </div>
  </form>
  
  <%}%>
</body>
</html>