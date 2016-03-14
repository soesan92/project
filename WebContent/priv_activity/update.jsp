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
	<!-- Header -->
	<jsp:include page="../private/privHeader.jsp" />
</head>
<body>
	<div class="span4"> </div>
	<div class="span6"> 
	<br>
		<s:form action="updActivityAction" method="post" enctype="multipart/form-data" theme="bootstrap" cssClass="" label="Update Activity Information !"><s:token/>
			<s:actionerror/>
			<s:actionmessage/>
			<s:hidden name="activity.id" />
			<s:hidden name="activity.createDate" />
			<s:textfield name="activity.postId" placeholder="Post ID" required="true" value="%{activity.postId}"/>
			<s:textfield name="activity.creatorName" label="" placeholder="Your Name" required="true" value="%{activity.creatorName}"/>
			<s:textarea name="activity.description" label="" placeholder="Say Something..." value="%{activity.description}"/>

			<s:submit Class="btn btn-success" value="Update"/>
			
			<s:url id="updateURL" action="activity_Init_Display">
			</s:url> 
			<s:a href="%{updateURL}">
				<button Class="btn btn-warning" type="button">Cancel</button>
			</s:a>
		</s:form>
	</div>
	<div class="span2"> </div>
</body>
</html>