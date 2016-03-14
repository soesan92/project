<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>

</head>
<body>
	<s:form action="saveUserAction" method="post" enctype="multipart/form-data" theme="bootstrap" cssClass="" label="Create An Account !">
		<s:actionerror/>
		<s:actionmessage/> 
		<s:token/>
		<s:hidden name="user.id" />
		<s:textfield name="user.userName" required="true" placeholder="Name"/>
		<s:textfield name="user.email" required="true" placeholder="E-mail" type="email"/>
		<s:password name="user.password" required="true" placeholder="Password"/>
		<s:password name="user.confPassword" required="true" placeholder="Confirm Password"/>
		<s:submit Class="btn btn-large btn-block btn-primary" value="Sign Up Now !"/>
	</s:form>
</body>
</html>