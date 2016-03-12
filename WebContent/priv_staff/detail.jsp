<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirm</title>
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

	<!-- Header -->
	<jsp:include page="../private/privHeader.jsp" />
<body>
	<div class="container-fluid">
		<div class="span4">
		</div>
		
		<div class="span4"><br>
			<p class="lead text-center">Detail about <strong><s:property value="%{staff.name}" /></strong></p>
			<table class="table table-striped table-bordered align-center">
				<tr>
					<td>ID</td>
					<td><s:property value="%{staff.id}"/></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><s:property value="%{staff.name}" /></td>
				</tr>
				<tr>
					<td>Nrc Number</td>
					<td><s:property value="%{staff.nrc_no}" /></td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><s:property value="%{staff.email}" /></td>
				</tr>
				<tr>
					<td>Phone No</td>
					<td><s:property value="%{staff.phone}" /></td>
				</tr>
				<tr>
					<td>Department</td>
					<td><s:property value="%{staff.department}" /></td>
				</tr>
				<tr>
					<td>Role</td>
					<td><s:property value="%{staff.role}" /></td>
				</tr>
				<tr>
					<td>Entry Date</td>
					<td><s:property value="%{staff.entryDate}" /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><s:property value="%{staff.description}" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><s:property value="%{staff.password}" /></td>
				</tr>
				<tr>
					<td>Create Date</td>
					<td><s:property value="%{staff.createDate}" /></td>
				</tr>
				<tr>
					<td>Update Date</td>
					<td><s:property value="%{staff.updateDate}" /></td>
				</tr>
			</table>
		</div>
		<div class="span2">
		</div>
	</div>
</body>
</html>