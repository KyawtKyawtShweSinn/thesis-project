<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head><title>Register Form</title></head>
	<body>
			<h3>Register Application</h3>
			<s:form action="register" method="post" enctype="multipart/form-data" theme="simple">
				<table border="1" width="500" height="600">
					<tr>
						<td><s:label value="User Name"></s:label></td>
						<td><s:textfield name="reg.username"></s:textfield></td>
					</tr>
					<tr>
						<td><s:label value="Email"></s:label></td>
						<td><s:textfield name="reg.email"></s:textfield></td>
					</tr>
					<tr>
						<td><s:label value="Password"></s:label></td>
						<td><s:password name="reg.password"></s:password></td>
					</tr>
					<tr>
						<td><s:label value="Gender"></s:label></td>
						<td><s:radio name="reg.gender" list="{'Male','Female'}"  /></td>
					</tr>
					<tr>
						<td><s:label value="Phone"></s:label></td>
						<td><s:textfield name="reg.phone"></s:textfield></td>
					</tr>
					<tr>
						<td><s:submit value="Register"></s:submit></td>
						<td><s:reset value="Cancel"></s:reset></td>
					</tr>
				</table>
			</s:form>
	</body>
</html>