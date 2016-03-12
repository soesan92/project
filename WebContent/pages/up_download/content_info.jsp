<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post</title>
</head>
<body>
	<s:form action="aaaAction" method="post"
		enctype="multipart/form-data" theme="bootstrap" cssClass=""
		label="Add New Doner!!!">
		<div class="input-medium">
			<s:file name="donerImage" label="Photo" required="true"></s:file><br>
		</div>
		<div class="input-medium">
			<s:textfield name="doner.donerName" label="" placeholder="Doner's Name" required="true"
				size="26.5" style="height: 20px; width: 180px;" /><br>
		</div>
		
		<div class="input-medium">
			<s:textfield name="doner.donateAmount" label="" placeholder="Donate Amount" 
				size="26.5" style="height: 20px; width: 180px;" /><br>
		</div>
		
		
		<div class="input-medium">
			<s:textfield name="doner.email" label="" placeholder="E-mail" required="true"
				size="26.5" style="height: 20px; width: 180px;" /><br>
		</div>
		<div class="input-medium">
			<s:textfield name="doner.phone" label="" placeholder="Phone number" required="true"
				size="26.5" style="height: 20px; width: 180px;" /><br>
		</div>
		<div class="input-medium">
			<s:textfield name="doner.dob" label="" placeholder="Date of birth" required="true"
				size="26.5" style="height: 20px; width: 180px;" /><br>
		</div>
		<div class="input-medium">
			<s:textarea name="doner.description" label="" placeholder="Say something about doner..." 
				style="height: 80px; width: 300px;" /><br>
		</div>
	
		<div class="">
			<s:submit cssClass="btn btn-primary" />
		</div>
	</s:form>
</body>
</html>