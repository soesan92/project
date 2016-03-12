<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Private Staff</title>
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

	
	<div class="container-fluid">
	<div class="span10">
		<!-- to search staff --><br>
		<div class="input-append ">
			<form action="searchStaff" method="post">
				<input class="span2" type="text" name="searchValue" /> <input
					type="submit" Class="btn btn-primary" value="Search">
			</form>
		</div>


		<s:if test="%{!staffList.isEmpty}">
			<table class="table table-striped table-bordered align-center">
					<th >ID</th>
					<th >Name</th>
					<th>E-mail</td>
					<th >NRC_NO</th>
					<th>Phone_Number</th>
					<th >Department</th>
					<th>Role</th>
					<th >Entry_Date</th>
					<th >Description</th>
					<th>#</th>
					<th>#</th>
				<s:iterator value="staffList" status="staffStatus">
					<tr>
						<td><s:property value="id" /></td>
						<td>
							<s:url id="updateURL" action="detailStaffAction">
							<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{updateURL}"><s:property value="name" /></s:a>
						</td>
						<td><s:property value="email" /></td>
						<td><s:property value="nrc_no" /></td>
						<td><s:property value="phone" /></td>
						<td><s:property value="department" /></td>
						<td><s:property value="role" /></td>
						<td><s:property value="entryDate"/></td>
						<td><s:property value="description" /></td>
						<td>
							
							<s:url id="updateURL" action="getModifyId">
							<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{updateURL}">Edit</s:a>
						</td>
						<td>
							<s:url id="deleteURL" action="delStaffAction">
							<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{deleteURL}">Delete</s:a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
	</div>
		<div class="span2"> 
		<ul class="nav nav-list bs-docs-sidenav affix">
		<br>
			<s:form action="saveStaffAction" method="post" enctype="multipart/form-data" theme="bootstrap" cssClass="" label="Create New Staff !">
				<s:token/>
				<s:actionerror/>
				<s:actionmessage/>
				<s:hidden name="staff.id" />
				<s:hidden name="staff.createDate" />
				<s:textfield name="staff.name" label="" placeholder="Name" required="true" value=""/>
				<s:textfield name="staff.nrc_no" placeholder="NRC Number" required="true" value=""/>
				<s:textfield name="staff.email" label="" placeholder="E-mail" required="true" type="email" value=""/>
				<s:textfield name="staff.phone" label="" placeholder="Phone Number" value=""/>
				<s:select headerKey=""
					headerValue="Select Department"
					list="#{'Yangon':'Yangon', 'Mandalay':'Mandalay', 'Myint Kiee Nar':'Myint Kiee Nar', 'Naypyi Daw':'Naypyi Daw'}"
					name="staff.department" value=""/>
				<s:radio name="staff.role" list="#{'Staff':'Staff','Board Member':'Board Member','Advisors':'Advisors','Other':'Other'}" value="Staff" />
				<s:label>Entry Date (dd-MMM-yyyy)</s:label>
				<sx:datetimepicker name="staff.entryDate" displayFormat="dd-MMM-yyyy" type="date" />
				<s:textarea name="staff.description" placeholder="Description..." value=""/>
				<s:password name="staff.password" placeholder="Password for Staff" value=""/>
				<s:submit Class="btn btn-primary" value="Create New"/>
				<s:reset Class="btn btn-warning"></s:reset>
			</s:form>
		</ul>
		</div>
	</div>
</body>
</html>