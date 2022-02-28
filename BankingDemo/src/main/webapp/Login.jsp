<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>LOGIN</title>
</head>
<body background="Inset-Photos-1280px-BusinessFundingBlue-400x250.jpg">
<h1 style="text-align:center">LOGIN HERE</h1>
<form style="text-align:center" action="login" method="post">
<br>
<label>USERNAME</label>
</br>
<br>
<input type="text" placeholder="Enter UserName" name="username" required>
</br>
<br>
<label>PASSWORD</label>
</br>
<br>
<input type="password" placeholder="Enter Password" name="password" required>
</br>
<br>
<a href="#">Forgot password?</a>
</br>
<br>
<input type="submit" value="Login">
</br>
<br>
<input type="checkbox" checked="checked">Remember me
</br>
<br>
<button type="button" class="cancelbutton">Back</button>
</br>
</form>
</body>
</html>