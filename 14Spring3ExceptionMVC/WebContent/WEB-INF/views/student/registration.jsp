<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Registration Form</title>
</head>
<body>
<h2 align="center">Student Registration Form</h2><hr/>
<table align="center" cellpadding="5" cellspacing="5">
	<form:form commandName="registration" method="POST" action="add-form">
		<tr>
			<td>Name</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Course</td>
			<td><form:select path="course" items="${courses}"
				itemLabel="title" itemValue="title" /></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><form:input path="age" /></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><form:textarea cols="30" rows="4" path="address" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Register" /></td>
		</tr>
	</form:form>
</table>
</body>
</html>