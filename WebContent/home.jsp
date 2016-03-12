<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mchan</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
<link href="bootstrap/css/docs.css" rel="stylesheet" type="text/css">
<link href="bootstrap/css/mycss.css" rel="stylesheet" type="text/css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>

<jsp:include page="./header_and_footer/header.jsp" />
<body>

<!-- <div id="fb-root"></div> -->
<script>
	(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.5";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));

	(function(d){
	  var js, id = 'facebook-jssdk'; if (d.getElementById(id)) {return;}
	  js = d.createElement('script'); js.id = id; js.async = true;
	  js.src = "//connect.facebook.net/my_MM/all.js";
	  d.getElementsByTagName('head')[0].appendChild(js);
	}(document));
</script>
	<div class="container-fluid background">
	<!-- left side -->

		<div class="span3">
			...
		</div>

		<!-- web page's body -->
		<div class="span6">
			<section id="home"><br>
				<jsp:include page="home/mchanHome.jsp" />
			</section>
			
			<section id="donatorList">
				<br>
				<jsp:include page="home/doner.jsp"/>
			</section>

			<section id="activity">
				<br>
				<jsp:include page="home/activity.jsp" />
			</section>

			<section id="video">
				<br>
				<jsp:include page="home/video.jsp" />
			</section>

			<div class="row-fluid">
				<section id="book">
					<br>
					<jsp:include page="home/book.jsp" />
				</section>
			</div>
		</div>
		
	<!-- right side -->
		<div class="span3 foreground">
			<ul class="nav nav-list bs-docs-sidenav affix">
				<li><jsp:include page="/pub_user/user.jsp" /></li>
				<li>
					<div class="fb-page" data-href="https://www.facebook.com/mchan.mm"
						data-tabs="MCHAN"
						data-adapt-container-width="true" data-hide-cover="false"
						
						data-show-facepile="true">
						<div class="fb-xfbml-parse-ignore">
							<blockquote cite="https://www.facebook.com/mchan.mm">
								<a href="https://www.facebook.com/mchan.mm">MCHAN</a>
							</blockquote>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<div class="footer">
		<jsp:include page="./header_and_footer/footer.jsp" />
	</div>
</html>
</body>

