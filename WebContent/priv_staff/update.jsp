<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Staff</title>
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet"
	type="text/css">
<link href="../bootstrap/css/docs.css" rel="stylesheet" type="text/css">
<link href="../bootstrap/js/bootstrap.js" rel="stylesheet"
	type="text/css">
<link href="../bootstrap/js/bootstrap.min.js" rel="stylesheet"
	type="text/css">
<sx:head />
	<!-- Header -->
	<jsp:include page="../private/privHeader.jsp" />
</head>
<body>
	<div class="span4"> </div>
	<div class="span6"> 
	<br>
		<s:form action="updStaffAction" method="post" enctype="multipart/form-data" theme="bootstrap" cssClass="" label="Update Staff !">
				<s:token />
				<s:actionerror/>
				<s:actionmessage/>
				<s:hidden name="staff.id" />
				<s:hidden name="staff.createDate" />
				<s:textfield name="staff.name" label="" placeholder="Name" required="true"/>
				<s:textfield name="staff.nrc_no" placeholder="NRC Number"/>
				<s:textfield name="staff.email" label="" placeholder="E-mail" required="true" type="email"/>
				<s:textfield name="staff.phone" label="" placeholder="Phone Number"/>
				<s:select name="staff.department" headerKey="-1"
					headerValue="Select Department"
					list="#{'Yangon':'Yangon', 'Mandalay':'Mandalay', 'Myint Kiee Nar':'Myint Kiee Nar', 'Naypyi Daw':'Naypyi Daw'}" />

				<s:radio name="staff.role" list="#{'Staff':'Staff','Board Member':'Board Member','Advisors':'Advisors','Other':'Other'}" value="%{staff.role}" />
				<s:label>Entry Date (dd-MMM-yyyy)</s:label>
				<sx:datetimepicker name="staff.entryDate" displayFormat="dd-MM-yyyy" type="date"/>
				<s:textarea name="staff.description" placeholder="Description..."/>
				<s:password name="staff.password" placeholder="Password for Staff"/>
				<s:submit Class="btn btn-success" value="Update"/>
				
				<s:url id="updateURL" action="staff_Init_Display">
				</s:url> 
				<s:a href="%{updateURL}">
					<button Class="btn btn-warning" type="button">Cancel</button>
				</s:a>
		</s:form>
	</div>
	<div class="span2"> </div>
</body>
</html>