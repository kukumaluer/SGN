<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
</head>
<body>


			<form:form modelAttribute="user">
				<table >

					<tr >
						<td>First Name:</td><td> <form:input path="firstName" />
						</td>
					</tr>

					<tr>
						<td>Last Name:</td><td><form:input path="lastName" />
						</td>
					</tr>

					<tr >
						<td>Username:</td><td> <form:input path="userName" />
						</td>
					</tr>
					
					<tr>
						<td>Email: </td><td> <form:input path="email" />
						</td>
					</tr>

					<tr>
						<td>Password </td><td><form:password path="password" />
						</td>
					</tr>
				</table>

				<input type="submit" name="submit" value="Submit" />


			</form:form>
			


</body>
</html>