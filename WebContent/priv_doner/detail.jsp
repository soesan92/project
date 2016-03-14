<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirm</title>
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
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script>
jQuery(function(){

    var minimized_elements = $('pre.minimize');
    
    minimized_elements.each(function(){    
        var t = $(this).text();        
        if(t.length < 100) return;
        
        $(this).html(
            t.slice(0,100)+'<a href="#" class="more">...More</a>'+
            '<span style="display:none;">'+ t.slice(100,t.length)+' <a href="#" class="less">Less</a></span>'
        );
        
    }); 
    
    $('a.more', minimized_elements).click(function(event){
        event.preventDefault();
        $(this).hide().prev().hide();
        $(this).next().show();        
    });
    
    $('a.less', minimized_elements).click(function(event){
        event.preventDefault();
        $(this).parent().hide().prev().show().prev().show();    
    });

});
</script>
<head>
	<!-- Header -->
	<jsp:include page="../private/privHeader.jsp" />
<title>Detail</title>
</head>
<body>

	<div class="span12 container-fluid">
		<div class="span2">
		</div>
		
		<div class="span2">
		<br>
			<table class="table table-bordered"><!-- table-striped  -->
				<tr>
					<td>
						<table>
							<tr>
								<td>
									<pre class="minimize">
										<strong>
										<s:property value="%{doner.donerName}" /></strong> Say :~ <s:property value="%{doner.description}" />
									</pre>
								</td>
							</tr>
							<tr>
								<td><img src="<s:url action='showImage?id=%{doner.id}'/>" class="img-detail" /></td>
							</tr>
							<tr>
								<td>
									<table class="table table-bordered table-striped">
										<tr>
											<td>ID</td>
											<td><s:property value="%{doner.id}" /></td>
										</tr>
										<tr>
											<td>Name</td>
											<td><s:property value="%{doner.donerName}" /></td>
										</tr>
										<tr>
											<td>Donate Amount</td>
											<td><s:property value="%{doner.donateAmount}" /></td>
										</tr>
										<tr>
											<td>E-mail</td>
											<td><s:property value="%{doner.email}" /></td>
										</tr>
										<tr>
											<td>Phone No</td>
											<td><s:property value="%{doner.phone}" /></td>
										</tr>
										<tr>
											<td>Date of Birth</td>
											<td><s:property value="%{doner.dob}" /></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
										</tr>
									</table>
								</td>
							</tr>
						</table> 
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="span8">
	</div>
</body>
</html>