<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
	<title>File Download Form</title>
	</head>
	<body>
		<h3>File Download:</h3>
		<h3>Select a file to upload:</h3><br/>
		<s:form action="download" method="" enctype="multipart/form-data" theme="simple">
			<table border="1">
				
				
				<tr>
					<td><s:label value="Key"></s:label></td>
					<td><s:textfield name="keytext"></s:textfield></td>
				</tr>
				
				<tr>
					<td><s:submit value="Download File"></s:submit></td>
					<td><s:reset value="Cancel"></s:reset></td>
				</tr>
			</table>	
		</s:form>
	</body>
</html>