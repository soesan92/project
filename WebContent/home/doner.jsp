<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Donator</title>
    <!-- You can use open graph tags to customize link previews.
    Learn more: https://developers.facebook.com/docs/sharing/webmasters -->
	<%-- <meta property="og:url"           content="http://localhost:8080/project/populate.action#donatorList" />
	<meta property="og:type"          content="website" />
	<meta property="og:title"         content="Your Website Title" />
	<meta property="og:description"   content="Your description" />
	<meta property="og:image"         content="http://localhost:8080/project/getId.action?id=<s:property value="id"/>"/> --%>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script>
jQuery(function(){
	var minimized_elements = $('pre.minimize');

		minimized_elements.each(function() {
			var t = $(this).text();
			if (t.length < 200)
				return;

			$(this).html(
					t.slice(0, 200) + '<a href="#" class="more">...See More</a>'
							+ '<span style="display:none;">'
							+ t.slice(200, t.length)+'</span>');

		});

		$('a.more', minimized_elements).click(function(event) {
			event.preventDefault();
			$(this).hide().prev().hide();
			$(this).next().show();
		});

	});
</script>
<body>


<div id="fb-root"></div>

<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.5";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
</script>



<s:if test="%{!donorList.isEmpty}">
	<s:iterator value="donorList">
			<table class="table table-bordered"><!-- table-striped -->
				<tr>
					<td class="foreground">
						<strong><s:property value="%{donerName}" /></strong> :~
						<table border="1" bordercolor="#f9f9f9">
							<tr>
								<td ><!-- colspan="2" width="68%" -->
									<pre class="minimize"><s:property value="%{description}" /></pre>
								</td>
							</tr>
							<tr>
								<td height="10%"> <!-- colspan="3" -->
									<s:if test="%{donerImage != null}">
										<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
											<div class="hovereffect">
												
												<img class="img-detail" src="<s:url action='showImage?id=%{id}'/>" alt="">
												<div class="overlay">
													<h2>$ <strong><s:property value="%{donateAmount}" /></strong> Donator (^_^)</h2>
													<p class="icon-links">
														<span class="fb-like"
															data-href="http://localhost:8080/project/getId.action?id=<s:property value="id"/>"
															data-layout="button_count"
															data-action="recommend"
															data-show-faces="true">
														</span><!--data-share="true" date-width="0.5" -->
													</p>
												</div>
											</div>
										</div> 
									</s:if>
								</td>
							</tr>
							<tr>
								<td>
									<div class="fb-like" 
										data-href="http://localhost:8080/project/getId.action?id=<s:property value="id"/>"
										data-share="true"
										data-layout="standard" 
										data-action="like" 
										data-show-faces="true">
									</div>
								</td>
							</tr>
						</table> 
					</td>
				</tr>
				<tr>
					<td class="foreground">
						<div class="fb-comments"
							data-href="http://localhost:8080/project/getId.action?id=<s:property value="id"/>"
							data-numposts="5">
						</div>
					</td>
				</tr>
			</table>
		</s:iterator>
	</s:if>
</body>
</html>