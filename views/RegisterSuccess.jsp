<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	</head>
	<body>
	<center>
		<h3>Success Register!</h3>
		
		<img src="<%=System.getProperty("catalina.base")%>/webapps/Yangon City Guide Website/images/<s:property value="reg.photoFileName"/>" width="100" height="100" /><br/>
		Name: <s:property value="reg.firstname"/>&nbsp;&nbsp; <s:property value="reg.lastname"/><br/>
		Email: <s:property value="reg.email"/><br/>
		Gender: <s:property value="reg.gender"/><br/>
		City: <s:property value="reg.city"/><br/>
		Country: <s:property value="reg.country"/><br/>
		Phone: <s:property value="reg.phone"/><br/>
		Hobby: <s:iterator value="reg.hobbies">
					<s:property/>
				</s:iterator><br/>
				
		User Photo File: <s:property value="reg.photoFileName"/><br/>
		
		
	</center>
	</body>
</html>