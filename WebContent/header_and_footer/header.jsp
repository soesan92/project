<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Header</title>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div style="background-color: #4b67a8">
			<div class="container">
				<div class="nav-collapse collapse">
					<ul class="nav">

						<li class="">
							<a href="#home"> <i class="icon-home icon-white"></i> Home</a>
						</li>

						<li class="">
							<a href="#donatorList"><i class="icon-user icon-white"></i> donator</a>
						</li>

						<li class="">
							<a href="#activity"><i class="icon-flag icon-white"></i> Our Activities</a>
						</li>

						<li class="">
							<a href="#video"><i class="icon-film icon-white"></i> video</a>
						</li>

						<li class="">
							<a href="#book"><i class="icon-book icon-white"></i> book</a>
						</li>

						<li class="">
							<a href="mailto:marygren03@gmail.com"><i class="icon-white icon-envelope"></i> E-mail Us</a>
						</li>
						<%-- <li>
							<form action="#" method="post" name="Login !">
								<s:actionerror />
								<s:actionmessage />
								<div class="control-group">
									<input type="text" name="username" placeholder="Email">
								</div>
								<div class="control-group">
									<input type="text" name="password" />
								</div>
								<div class="control-group">
									<label
										class="checkbox"> <input type="checkbox">
										Remember me
									</label>
								<input type="submit" Class="btn btn-primary" data-loading-text="Loading..." value="Login">
								</div>
							</form>
						</li> --%>
					</ul>
				</div>
				<div class="navbar-form pull-right">
					<ul class="nav">
						<li class="">
							<a href="./priv_doner/insert.jsp">Admin</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
