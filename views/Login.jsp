<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
	<head><title>Login</title> <s:head/> 
	</head>
	
	<body>
		<tiles:insertDefinition name="login.tiles"/>
		<s:form action="login">
			<s:textfield label="User Name" name="username"></s:textfield>>
			<s:password  label="Password" name="password"></s:password>
			<s:submit value="Login"></s:submit>
			<s:submit value="Cancel"></s:submit>
		</s:form>
		New User<a href="<s:url action="registerForm"/>">Register</a>
	</body>
</html>