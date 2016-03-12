<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body><h1>File info</h1>
File name is  	:<c:out value="${sessionScope.fileName}"/><br>
File type  		:<c:out value="${sessionScope.contentType}"/><br>
Is in Memory  	:<c:out value="${sessionScope.isInMemory}"/><br>
File Size is  	:<c:out value="${sessionScope.sizeInMB}"/>	MB<br>

	<form method="GET" action="Download">
		Enter file name to download : <input type="text" name="filename" value="${sessionScope.fileName}" >
		<input type="submit" value="Download it">
	</form>
	<video width="560" height="340" controls> <source
		src="${sessionScope.fileName}"
		type='video/mp4; codecs="avc1.42E01E, mp4a.40.2"'> 
	</video>
</body>
</html>