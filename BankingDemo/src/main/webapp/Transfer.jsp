<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRANSFER</title>
</head>
<body>
<h1 style="text-align:center">TRANSFER AMOUNT</h1>
<jsp:include page='Menu.jsp'>
<jsp:param name="ACCOUNT DETAILS" value=" " />
        <jsp:param name="CUSTOMER DETAILS" value=" " />
        <jsp:param name="TRANSFER" value=" " />
</jsp:include>
<table align="center" style="margin: 0px auto;">
<br>
<caption>MONEY TRANSFER</caption>
<tr>
<td>FROM ACCOUNT &emsp;</td>
<td><select>
<option value="account 1">Account 1</option>
<option value="account 2">Account 2</option>
<option value="account 3">Account 3</option>
</select></td></tr>
<br><br>
<tr>
<td>TO ACCOUNT&emsp;</td>
<td><select>
<option value="account 1">Account 11</option>
<option value="account 2">Account 12</option>
<option value="account 3">Account 13</option>
</select>
</td></tr>

<tr>
<br><br>
<td>ENTER AMOUNT TO TRANSFER&emsp;</td>
<td>
<input type="text" placeholder="balance:20000.50" name="amount" required>
</td>
</tr>

<tr>
<td colspan="2" style="text-align:center;height:100px;">
<input type="submit" value="TRANSFER" >
</td>
</tr>
</table>
<br><br><br><br>

</form>
</body>
</html>