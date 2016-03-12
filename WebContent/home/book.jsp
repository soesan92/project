<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Books</title>
</head>
<body>
<script>
	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.3";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
</script>


<s:if test="%{!bookList.isEmpty}">
	<s:iterator value="bookList" status="activityStatus">
		<table class="table table-bordered">
				<tr> 
					<td class="foreground">
						<table ><!-- border="1" bordercolor="#f9f9f9" -->
							<tr>
								<td>
									Book Title :~ <s:property value="bookTitle" />
								</td>
							</tr>
							<tr>
								<td><!-- width="80%" -->
									<pre class="minimize"><strong>Book Over view :~ </strong> <s:property value="description" /></pre>
								</td>
								<!-- <td width="20%">
									<table class="table-bordered">
										<tr>
											<td>
												<div class="fb-share-button"
													data-href="http://www.facebook.com/mchan.mm"
													data-layout="button_count">
												</div>
											</td>
										</tr>
									</table>
								</td> -->
							</tr>
							<tr>
								<s:if test="%{sellingSite != null}">
									<td>
										<a href="<s:property value="sellingSite"/>">
											<p class="font_readable">
												<s:text name="%{sellingSite}"/>
											</p>
										</a>
									</td>
								</s:if>
							</tr>
							<tr>
								<td>
									<div class="fb-post"
										data-href="<s:property value="bookId"/>"
										data-width="600">
										<div class="fb-xfbml-parse-ignore">
											<blockquote
												cite="<s:property value="bookId"/>">
											</blockquote>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<table class="table-bordered">
										<tr>
											<td>
												<div class="fb-share-button"
													data-href="<s:property value="bookId"/>"
													data-layout="button_count">
												</div>
											</td>
											<td>
												<div class="fb-follow"
													data-href="https://www.facebook.com/mchan.mm"
													data-width="2"
													data-height="2" data-layout="standard"
													data-show-faces="true">
												</div>
											</td>
										</tr>
									</table>
								</td> 
							</tr>
						</table>
						
					</td>
				</tr>
				<tr>
					<td class="foreground">
						<div class="fb-comments"
							data-href="http://localhost:8080/project/getBookId.action?id=<s:property value="id"/>"
							data-numposts="5">
						</div>
					</td>
				</tr>
			</table>
	</s:iterator>
</s:if>
</body>
</html>