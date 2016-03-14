<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
							<li class="">
								<s:url id="updateURL" action="donor_Init_Display">
								</s:url> <s:a href="%{updateURL}"><i class="icon-user icon-white"></i> Donator</s:a>
							</li>
							<li class="">
								<s:url id="updateURL" action="staff_Init_Display">
								</s:url> <s:a href="%{updateURL}"><i class="icon-user icon-white"></i> Staff</s:a>
							</li>
							<li class="">
								<s:url id="updateURL" action="activity_Init_Display">
								</s:url> <s:a href="%{updateURL}"><i class="icon-pencil icon-white"></i> Upload Activity</s:a>
							</li>
							<li class="">
								<s:url id="updateURL" action="video_Init_Display">
								</s:url> <s:a href="%{updateURL}"><i class="icon-film icon-white"></i> Upload Video</s:a>
							</li>
							<li class="">
								<s:url id="updateURL" action="book_Init_Display">
								</s:url> <s:a href="%{updateURL}"><i class="icon-book icon-white"></i> Upload Book</s:a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
</body>
</html>