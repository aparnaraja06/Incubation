<%@ page import="bankinginfo.logic.BankingLogic" %>
<%@ page import="customer.CustomerInfo" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CUSTOMER DETAILS</title>
<link rel="stylesheet" href="details.css">
</head>
<body>
<% String typeName=(String)request.getParameter("status"); 
%>
<jsp:include page='Menu.jsp'>
<jsp:param name="ACCOUNT DETAILS" value=" " />
        <jsp:param name="CUSTOMER DETAILS" value=" " />
        <jsp:param name="TRANSFER" value=" " />
</jsp:include>

<!--  <form method="post" action="AddUpdateCustomer.jsp?type=addCustomer"> -->
<h1>LIST OF CUSTOMERS</h1>
<a href="AddUpdateCustomer.jsp?type=addCustomer" method="post" class="addAcc">ADD NEW CUSTOMERS</a>
<%if(typeName==null){ %>
<a href="CustomerDetails.jsp?status=inactive"  class="inactive">INACTIVE CUSTOMERS</a>
<%}else{ %>
<a href="CustomerDetails.jsp" class="inactive">ACTIVE CUSTOMERS</a>
<%}
String result=(String)request.getAttribute("result");

if(result!=null)
{
%>
<h2><%=result%></h2>
<%}%>
<!--  <input class="addbtn" type="submit" value="ADD NEW CUSTOMERS"> -->
<table class="center">
<tr>
<br>
<th>CUSTOMER ID</th>
<th>CUSTOMER NAME</th>
<th>GENDER</th>
<th>MOBILE NUMBER</th>
<th>ACTIVITY</th>
</tr>
<%
BankingLogic logic=(BankingLogic) request.getServletContext().getAttribute("Instance");

Map<Integer,CustomerInfo> customerMap=logic.showAllCustomers();
int customer_id=0;
if(typeName!=null)
{
	customerMap=logic.getInactiveCustomers();
}
else
{
	customerMap=logic.getActiveCustomers();
}
if(customerMap.isEmpty())
{
%>	
<tr><td colspan="5" class="record"><b>No records found</b></td></tr>
<%}
else
{
for(Map.Entry<Integer,CustomerInfo> entry:customerMap.entrySet())
{
	int customerId=entry.getKey();
	customer_id=customerId;
	CustomerInfo customer=entry.getValue();
%>
<tr>
<td><a href="AddUpdateCustomer.jsp?type=editCustomer&customerId=<%=customer_id%>" class="edit">
<img src="images.png" class="offImg" title="Edit">
<%=customer_id%></a></td>
<td><%=customer.getCustomerName()%></td>
<td><%=customer.getGender()%></td>
<td><%=customer.getMobileNum()%></td>
<%if(typeName==null){ %>
<td><a href="addcustomer?status=inactive&customerId=<%=customer_id%>">
<img src="download.png" class="offImg" title="Inactivate">
</a></td>
<%}else{ %>
<td><a href="addcustomer?status=active&customerId=<%=customer_id%>">
<img src="images.jpeg"class="offImg" title="Activate">
</a></td>
<%} %>
</tr>
<% }}%>
</table>
<br><br>


</form>
</body>
</html>