<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>

	<jsp:include page="header.html"></jsp:include>
	
	<tr>
		<td>
			<a href ="controller?action=register">Register new Student</a><BR> 
			
			<a href="controller?action=list">Get Registered Students</a>
		<td>
	</tr>
	
	<BR>
	<BR>
	
	<jsp:include page="footer.html"></jsp:include>	

</table>



</body>
</html>