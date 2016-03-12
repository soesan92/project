<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign Up</title>
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet"
	type="text/css">
<link href="../bootstrap/css/docs.css" rel="stylesheet" type="text/css">
<link href="../bootstrap/js/bootstrap.js" rel="stylesheet"
	type="text/css">
<link href="../bootstrap/js/bootstrap.min.js" rel="stylesheet"
	type="text/css">
</head>
<body>
	<!-- Header -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div style="background-color: #4b67a8">
			<div class="container">
				<a class="brand" href="../index.jsp">MCHAN</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="">
							<a href="../index.jsp">
							<i class="icon-home icon-white"></i>Home</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- body -->
	<div class="container-fluid">
	<div class="span2"></div>

	<div class="span4">
		<s:form action="saveJoinerAction" method="post" enctype="multipart/form-data" theme="bootstrap" cssClass="" label="Join Us">
			<s:actionerror/>
			<s:actionmessage/>
			<s:token />
			<s:textfield name="joiner.joinerName" label="" required="true"  placeholder="Name"/>
			<s:textfield name="joiner.email" label="" required="true"  placeholder="E-mail" type="email"/>
			<s:textfield name="joiner.phone" label="" required="true" placeholder="Phone Number"/>
			<s:textarea name="joiner.description" label="" value="" placeholder="Write something..." />
			<s:submit Class="btn btn-large btn-block btn-primary" />
	</s:form>
	</div>
	
	<div class="span2"></div>
</div>
</body>
</html>