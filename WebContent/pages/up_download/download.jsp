<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Down Load</title>
</head>
<body>
	<p class="lead">
		Before downloading, be sure to have a code editor (we recommend <a
			href="http://sublimetext.com/2">Sublime Text 2</a> ) and some working
		knowledge of HTML and CSS. We won't walk through the source files
		here, but they are available for download. We'll focus on getting
		started with the compiled Bootstrap files.
	</p>
	<div class="row-fluid">
		<div class="span6">
			<h2>Visit to our website</h2>
			<p>
				<strong>Free free to content us.
			</p>
			<p>
				<a class="btn btn-large btn-primary" href="http://www.hnttechs.com">Visit to our website</a>
			</p>
		</div>
		<div class="span6">
			<h2>Visit to our website</h2>
			<p>Free free to content us.</p>
			<p>
			<p>
				<a class="btn btn-large"
					href="http://www.hnttechs.com">Visit to our website</a>
			</p>
		</div>
			<s:iterator value="userList">
				<div class="span6">
					<h2>With Struts2 download</h2>
					User Image:
					<s:property value="userImage" />
					<br> Content Type:
					<s:property value="userImageContentType" />
					<br> File Name:
					<s:property value="userImageFileName" />
					<br> Uploaded Image:
					<p>
						<a class="btn btn-large btn-primary" href="http://www.hnttechs.com">Visit to our website</a>
					</p>
				</div>
			</s:iterator>
		<%-- <h1>File info</h1>
		File name is :
		<c:out value="${sessionScope.fileName}" />
		<br> File type :
		<c:out value="${sessionScope.contentType}" />
		<br> Is in Memory :
		<c:out value="${sessionScope.isInMemory}" />
		<br> File Size is :
		<c:out value="${sessionScope.sizeInMB}" />
		MB <br>

		<form method="GET" action="Download">
			Enter file name to download : <input type="text" name="filename"
				value="${sessionScope.fileName}"> <input type="submit"
				value="Download it">
		</form> --%>
	</div>
</body>
</html>