
<%@ page import="java.util.List,com.app.bean.Student" isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.html"></jsp:include>


	Registered Students

	<table border="1">

		<tr>
			<th>UNo</th>
			<th>Name</th>
			<th>Gender</th>
		</tr>
		
		<!-- forEach tag : JSTL and EL($) , standard tag -->
		
		<!-- ${Studentdata} : request.getAttribute("Studentdata"); -->
		
		<c:forEach items="${Studentdata}" var= "student">
		
			<tr> 
				<td>${student.getUno()}</td> 
				<td>${student.getName()}</td>
				<td>${student.getGender()}</td>
			</tr>		
		
		</c:forEach>		


	</table>


	<jsp:include page="footer.html"></jsp:include>

</body>
</html>