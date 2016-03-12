<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/bootstrap/js/bootstrap.js" rel="stylesheet" type="text/css">
<link href="/bootstrap/js/bootstrap.min.js" rel="stylesheet"
	type="text/css">
</head>
<body>
	<%-- <s:form action="uploadAction" method="post"
		enctype="multipart/form-data" theme="bootstrap" cssClass=""
		label="Upload here!!!">
		<div class="input-medium">
			<s:file name="userImage" label="File"></s:file>
		</div>
		<div class="input-medium">
			<s:textfield name="user.name" label="" required="true"
				placeholder="Name" size="26.5" style="height: 20px; width: 180px;" />
		</div>
		<div class="input-medium">
			<s:textfield name="user.email" label="" required="true"
				placeholder="E-mail" size="26.5" style="height: 20px; width: 180px;" />
		</div>
		<div class="input-medium">
			<s:textarea name="user.userinfo" label="" required="true"
				placeholder="Write about you something!!!"
				style="height: 80px; width: 180px;" />
		</div>
		<div>
			<s:submit cssClass="btn btn-primary" />
			<a href="http://localhost:8080/Project4Mchan/populate.action">Finished</a>
		</div>
	</s:form> --%>


	<form action="UserAction" enctype="multipart/form-data" method="post">
		What is your name ? <input type="text" name="submiter"> Which
		file do you want to upload? <input type="file" name="file"><br>
		<input type="submit" value="Upload">
	</form>
</body>
</html>