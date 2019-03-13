<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<style>
{
.register {
	padding-left: 200px;
}
</style>
<body>



	<jsp:include page="header.html"></jsp:include>

	<H3>Registration</H3>
	<form action="controller" method="post">
		<table>
			<tr>
				<td>University Number :</td>
				<td><input type="text" name="uno"></td>
			</tr>
			<tr>
				<td>Sex :</td>
				<td>Male <input type="radio" name="gender" value="Male"></td>
				<td>Female <input type="radio" name="gender" value="Female"></td>
			</tr>

			<tr>
				<td>Name :</td>
				<td><input type="text" name="Name"></td>
				
			</tr>
			
			<input type = "hidden" name = "action" value="registernewstudent"/>
			
			
			

			<tr align="center">

				<td><input class="register" type="submit" value="Register"
					size=30></td>
				<td><input class="cancel" type="button" value="Cancel" size=30></td>
			</tr>


		</table>
	</form>





	<jsp:include page="footer.html"></jsp:include>


</body>
</html>