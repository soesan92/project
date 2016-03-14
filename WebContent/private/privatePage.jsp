<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authorization</title>
</head>
<body>
	<a href="http://localhost:8080/mchan/populate.action">Return to
		home page </a>
	<br>
	<br>
	<form action="Upload" method="post" enctype="multipart/form-data">
		What is your name ? <input type="text" name="submiter"> Which
		file do you want to upload? <input type="file" name="file"><br>
		<input type="submit" value="Upload">
	</form>
</body>
</html>