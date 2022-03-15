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
<head>
<meta charset="UTF-8">
<title>HOME</title>
<link rel="stylesheet" href="details.css">
</head>
<body>
<% String typeName=(String)request.getParameter("status"); %>
<jsp:include page='Menu.jsp'>
<jsp:param name="ACCOUNT DETAILS" value=" " />
        <jsp:param name="CUSTOMER DETAILS" value=" " />
        <jsp:param name="TRANSFER" value=" " />
</jsp:include>
<h1>WELCOME</h1>
<!--  <form action="AddUpdateAccount.jsp?type=addAccount" method="post"> -->
<h1>LIST OF ACCOUNTS</h1>
<a href="AddUpdateAccount.jsp?type=addAccount" method="post" class="addAcc">ADD NEW ACCOUNTS</a>
<%if(typeName==null){ %>
<a href="Welcome.jsp?status=inactive" class="inactive">INACTIVE ACCOUNTS</a>
<%}else{ %>
<a href="Welcome.jsp" class="inactive">ACTIVE ACCOUNTS</a>
<%}
String result=(String)request.getAttribute("result");
if(result!=null)
{
%>
<h2><%=result%></h2>
<%}%>
<!--  <input class="addbtn" type="submit" value="ADD NEW ACCOUNTS"> -->
<table class="center">
<tr>
<br>
<th>ACCOUNT NUMBER</th>
<th>CUSTOMER ID</th>
<th>BRANCH</th>
<th>BALANCE</th>
<th>ACTIVITY</th>
</tr>
<% 
BankingLogic logic=(BankingLogic) request.getServletContext().getAttribute("Instance");
Map<Integer,Map<Integer,AccountInfo>> accountMap=null;
if(typeName!=null)
{
	accountMap=logic.getInactiveAccounts();
}
else
{
	
 accountMap=logic.getActiveAccounts();
}

if(accountMap.isEmpty())
{
%>	
<tr><td colspan="5" class="record"><b>No records found</b></td></tr>
<%}
else
{
for(Map.Entry<Integer,Map<Integer,AccountInfo>> entry:accountMap.entrySet())
{
	int customer_id=entry.getKey();
	Map<Integer,AccountInfo> tempMap=entry.getValue();
	
	for(Map.Entry<Integer,AccountInfo> entry1:tempMap.entrySet())
	{
		int acc_num=entry1.getKey();
		AccountInfo account=entry1.getValue();
		//System.out.println("active:"+account);
	
%>
<tr>
<td><a href="AddUpdateAccount.jsp?type=editAccount&accountNum=<%=acc_num%>&customerId=<%=customer_id%>" class="edit">
<img src="images.png" class="offImg" title="Edit">
<%=acc_num%></a></td>
<td><%=customer_id%></td>
<td><%=account.getBranch()%></td>
<td><%=account.getBalance()%></td>
<%if(typeName==null){ %>
<td><a href="accountServlet?status=inactive&accountNum=<%=acc_num%>&customerId=<%=customer_id%>">
<img src="download.png" class="offImg" title="Inactivate">
</a></td>
<%}else{ %>
<td><a href="accountServlet?status=active&accountNum=<%=acc_num%>&customerId=<%=customer_id%>">
<img src="images.jpeg"class="offImg" title="Activate">
</a></td>
<%} %>
</tr>
<%} }}

%>

</table>


</body>
</html>