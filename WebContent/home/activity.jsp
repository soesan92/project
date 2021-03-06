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



<s:if test="%{!activityList.isEmpty}">

	<s:iterator value="activityList" status="activityStatus">
		<table class="table table-bordered">
			<tr>
				<td class="foreground">
					<table border="1" bordercolor="#f9f9f9">
							<tr>
								<td width="80%">
									<pre class="minimize"><strong><s:property value="creatorName" /> Post :~ </strong> <s:property value="description" /></pre>
								</td>
							</tr>
							
							<tr>
								<td>
									<div class="fb-post" data-href="<s:property value="postId"/>" data-width="600">
									<div class="fb-xfbml-parse-ignore">
										<blockquote
											cite="<s:property value="postId"/>">
										</blockquote>
									</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<table>
										<tr>
											<td>
												<div class="fb-share-button"
													data-href="<s:property value="postId"/>"
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
						data-href="http://localhost:8080/project/getActivityId.action?id=<s:property value="id"/>"
						data-numposts="5">
					</div>
				</td>
			</tr>
		</table>
	</s:iterator>
</s:if>
</body>
</html>