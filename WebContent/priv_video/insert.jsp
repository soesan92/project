<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert</title>
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
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script>

	$(function() {

		var minimized_elements = $('pre.minimize');

		minimized_elements
				.each(function() {
					var t = $(this).text();
					if (t.length < 60)
						return;

					$(this)
							.html(
								t.slice(0, 60)
									+ '<span>... </span><a href="#" class="more">More</a>'
									+ '<span style="display:none;">'
									+ t.slice(60, t.length)
									+ ' <a href="#" class="less">Less</a></span>');

				});

		$('a.more', minimized_elements).click(function(event) {

			event.preventDefault();
			$(this).hide().prev().hide();
			$(this).next().show();

		});

		$('a.less', minimized_elements).click(function(event) {

			event.preventDefault();
			$(this).parent().hide().prev().show().prev().show();

		});

	});
</script>
	<!-- Header -->
	<jsp:include page="../private/privHeader.jsp" />
<body>
	<div class="container-fluid">
	<div class="span10">
		<!-- to search activity --><br>
		<div class="input-append ">
			<form action="searchVideo" method="post">
				<input class="span2" type="text" name="searchValue" /> <input
					type="submit" Class="btn btn-primary" value="Search">
			</form>
		</div>

		<s:if test="%{!videoList.isEmpty}">
			<table class="table table-striped table-bordered align-center">
					<th >ID</th>
					<th >Video_Id</th>
					<th>Video_Title</th>
					<th >Creator_Name</th>
					<th>Description</th>
					<th >Create_Date</th>
					<th>Update_Date</th>
					<th>#</th>
					<th>#</th>
				<s:iterator value="videoList" status="videoStatus">
					<tr>
						<td><s:property value="id" /></td>
						<td>
							<a href="<s:property value="videoId" />">Preview</a>
						</td>
						<td><s:property value="videoTitle" /></td>
						<td><s:property value="creatorName" /></td>
						<td>
							<div class="pre-scrollable_description">
								<pre class="minimize"><s:property value="description" /></pre>
							</div>
						</td>
						<td><s:property value="createDate" /></td>
						<td><s:property value="updateDate" /></td>
						<td>
							
							<s:url id="updateURL" action="getVideoId">
							<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{updateURL}">Edit</s:a>
						</td>
						<td>
							<s:url id="deleteURL" action="delVideoAction">
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
			<s:form action="saveVideoAction" method="post" enctype="multipart/form-data" theme="bootstrap" cssClass="" label="Create New Video !">
				<s:token/>
				<s:actionerror/>
				<s:actionmessage/>
				<s:hidden name="video.id" />
				<s:hidden name="video.createDate" />
				<s:textfield name="video.videoId" placeholder="Video ID" required="true" value=""/>
				<s:textfield name="video.videoTitle" placeholder="Video Title" value=""/>
				<s:textfield name="video.creatorName" placeholder="Your Name" required="true" value=""/>
				<s:textarea name="video.description" placeholder="Say Something..." value=""/>
				
				<s:submit Class="btn btn-primary" value="Create New"/>
				<s:reset Class="btn btn-warning"></s:reset>
			</s:form>
		</ul>
		</div>
	</div>
</body>
</html>