<%@ page import="bankinginfo.logic.BankingLogic" %>
<%@ page import="customer.CustomerInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD CUSTOMER</title>
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
<%if(typeName.equals("addCustomer")) 
{%>
<h1>ADD CUSTOMER</h1>
<form action="addcustomer?type=addCustomer" method="post">
<div class="Container">
<%String error=(String)request.getAttribute("Error");
if(error!=null)
{
%>
<h3><%=error%></h3>
<%}%>
<label for="name">Name</label><br><br>
<input type="text" placeholder="Enter the name" name="customername" required><br><br>
<label for="gender">Gender</label><br><br>
<select name="gender">
<option>Male</option>
<option>Female</option>
<option>Others</option>
</select><br><br>
<label for="mobile">Mobile number</label><br><br>
<input type="text" placeholder="Mobile number" name="mobile" minlength="10" maxlength="10" required><br><br>
<br>
<input  class="subButton" type="submit" value="Add">
</div>
</form>
<%}
else if(typeName.equals("editCustomer"))
{
	BankingLogic logic=(BankingLogic) request.getServletContext().getAttribute("Instance");

	 String cust_id=request.getParameter("customerId");
	 int customerId=Integer.valueOf(cust_id);
	 CustomerInfo customer=logic.getCustomerById(customerId);
%>
<h1>EDIT CUSTOMER</h1>
<form action="addcustomer?type=editCustomer&customerId=<%=customerId%>" method="post">
<div class="Container">
<%String error=(String)request.getAttribute("Error");
if(error!=null)
{
%>
<h3><%=error%></h3>
<%}%>
<label for="name">Name</label><br><br>
  <input type="text" id="name" name="customername" value="<%=customer.getCustomerName()%>" required><br><br>
  <label for="gender">Gender</label><br><br>
<%--   <input type="text" id="gender" name="gender" value="<%=customer.getGender()%>"><br><br> --%>
<select name="gender">
<option <%if(customer.getGender().equals("Male")){ %>selected="selected" <%} %>>Male</option>
<option <%if(customer.getGender().equals("Female")){ %>selected="selected" <%} %>>Female</option>
<option <%if(customer.getGender().equals("Others")){ %>selected="selected" <%} %>>Others</option>
</select><br><br>
  <label for="mobile">Mobile number</label><br><br>
  <input type="text" id="mobile" name="mobile" minlength="10" maxlength="10" value="<%=customer.getMobileNum()%>" required><br><br>
  <input class="subButton" type="submit" value="Edit">
  </div>
  </form>
  <%} %>
</body>
</html>