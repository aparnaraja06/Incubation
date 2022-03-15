<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<link rel="stylesheet" href="Login.css">
<title>LOGIN</title>
</head>
<body style=img:"istockphoto-1136393786-612x612.jpg">
<% String error=(String)request.getAttribute("Error"); 
if(error!=null)
{ %>
<h2><%=error%></h2>
<%}%>
<h1>LOGIN HERE</h1>
<form action="login" method="post">
<div class="container">
<label>USERNAME</label><br><br>
<input type="text" placeholder="Enter UserName" name="username" required><br><br>
<label>PASSWORD</label><br><br>
<input type="password" placeholder="Enter Password" name="password" required><br><br>
<a href="#">Forgot password?</a><br><br>
<input type="submit" class="loginbtn" value="Login"><br><br>
<input type="checkbox" checked="checked">Remember me<br><br>
</div>
<button type="button" class="cancelbutton">Back</button>
</form>
</body>
</html>