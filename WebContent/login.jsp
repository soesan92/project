<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
	<center>
		<h1><font color="red">Warning: Authories Users Only</font></h1>
		<form action="j_security_check" method="post">
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="j_username"></input></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="j_password"></input></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="login"><input type="reset"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>