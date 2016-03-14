<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Donor</title>
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
<body>

	<!-- Header -->
	<jsp:include page="../private/privHeader.jsp" />

	<!-- Header End -->

<br><br>

	<div class="container-fluid">
			
		<!-- to display the Donator List-->
		<div class="span10">
		
			<!-- to search donoter -->
			<div class="input-append ">
				<form action="searchAction" method="post">
				<s:actionerror/>
				<s:actionmessage/>
					<input class="span2" type="text" name="searchValue" />
					<input type="submit" Class="btn btn-primary" value="Search">
				</form>
			</div>
			
			<s:if test="%{!donorList.isEmpty}">
				<table class="table table-striped table-bordered">
						<th >ID</th>
						<th >Image</th>
						<th >Name</th>
						<th>Amount</td>
						<th>Birthday</th>
						<th >E-mail</th>
						<th>Phone Number</th>
						<th >Donator's Message</th>
						<th >#</th>
						<th >#</th>
					<s:iterator value="donorList" status="donorStatus">
						<tr>
							<td><s:property value="id" /></td>
							<td>
								<s:url id="updateURL" action="detailPage">
								<s:param name="id" value="%{id}"></s:param>
								</s:url> <s:a href="%{updateURL}">   <img src="<s:url action='showImage?id=%{id}'/>" class="img-donor"/>    </s:a>
							</td>
							<td><s:property value="donerName" /></td>
							<td><s:property value="donateAmount" /></td>
							<td><s:property value="dob"/></td>
							<td><s:property value="email" /></td>
							<td><s:property value="phone" /></td>
							<td>
								<div class="pre-scrollable_description">
									<pre class="minimize"><s:property value="description" /></pre>
								</div>
							</td>
							<td>
								<s:url id="updateURL" action="getId">
								<s:param name="id" value="%{id}"></s:param>
								</s:url> <s:a href="%{updateURL}">Edit</s:a>
							</td>
							<td>
								<s:url id="deleteURL" action="deleteAction">
								<s:param name="id" value="%{id}"></s:param>
								</s:url> <s:a href="%{deleteURL}">Delete</s:a>
							</td>
						</tr>
					</s:iterator>
				</table>
			</s:if>
		</div>
	
		<!-- Insert or Update the Donator -->
		<div class="span2">
			
			<ul class="nav nav-list bs-docs-sidenav affix">
			<br><br>
				<s:form action="doDonorAction" method="post" enctype="multipart/form-data" theme="bootstrap" cssClass="" label="Create New Donator!">
					<s:actionerror/>
					<s:actionmessage/>
					<s:token />
					<s:hidden name="doner.id" />
					<s:hidden name="doner.createDate" />
					<s:textarea name="doner.description" label="" placeholder="Say something about doner..." value=""/>
					
					<s:file name="donerImage" multiple="1" label="Choose Photo!" type="blob"/>
		
					<s:textfield name="doner.donerName" placeholder="Name" required="true" value=""/>
		
					<s:textfield name="doner.donateAmount" placeholder="Donate Amount" required="true" type="number" value=""/>
		
					<s:textfield name="doner.email" label="" placeholder="E-mail" type="email" value=""/>
					<s:textfield name="doner.phone" label="" placeholder="Phone number" required="true" value=""/>
					<s:label>Birthday (dd-MMM-yyyy)</s:label>
					<sx:datetimepicker name="doner.dob" displayFormat="dd-MMM-yyyy" type="date" value=""/>
					<br>
					<s:submit value="Create New" Class="btn btn-primary" />&nbsp;&nbsp;&nbsp;
					<s:reset Class="btn btn-warning"/>
				</s:form>
			</ul>
		</div>
	</div>	
</body>

</html>
