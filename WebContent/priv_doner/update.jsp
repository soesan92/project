<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
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
</head>
<body>
	<!-- Header -->
	<jsp:include page="../private/privHeader.jsp" />
<br><br>

	<div class="container-fluid">
		<div class="span3"> </div>
		<div class="span9"> 
			
			<s:form action="updateAction" method="post" enctype="multipart/form-data" theme="bootstrap" cssClass="" label="Update Donator!">
				<s:token />
				<s:actionerror/>
				<s:actionmessage/>
				<s:hidden name="doner.id" />
				<s:hidden name="doner.createDate" />
				<s:textarea name="doner.description" label="" placeholder="Say something about doner..." />
				<img src="<s:url action='showImage?id=%{doner.id}'/>" class="img-donor"/>
				<s:file name="donerImage" label="Choose Photo!" class="img-donor"/>

				<s:textfield name="doner.donerName" placeholder="Name" required="true"/>
	
				<s:textfield name="doner.donateAmount" placeholder="Donate Amount" required="true" type="number"/>
	
				<s:textfield name="doner.email" label="" placeholder="E-mail" required="true" type="email"/>
				<s:textfield name="doner.phone" label="" placeholder="Phone number" required="true"/>
				<s:label>Birthday (dd-MMM-yyyy)</s:label>
				<sx:datetimepicker name="doner.dob" type="date"/><br>
		
				<s:submit value="Update" Class="btn btn-success" />
				
				<s:url id="updateURL" action="donor_Init_Display">
				</s:url> 
				<s:a href="%{updateURL}">
					<button Class="btn btn-warning" type="button">Cancel</button>
				</s:a>
				<%-- <s:a href="../priv_doner/insert.jsp" Class="btn btn-warning">Reset</s:a> --%>
			</s:form>
		
		</div>
		<div class="span4"> </div>
	</div>
</body>
</html>