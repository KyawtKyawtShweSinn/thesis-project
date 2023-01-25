<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
	<title>File Uploading Form</title>
	</head>
	<body>
		<h3>File Upload:</h3>
		<h3>Select a file to upload:</h3><br/>
		<s:form action="uploadFile" method="post" enctype="multipart/form-data" theme="simple">
			<table border="1">
				
				<tr>
					<td><s:label value="File"></s:label></td>
					<td><s:file name="filetype.photo"></s:file></td>
				</tr>
				<tr>
					<td><s:label value="Key Generate"></s:label></td>
					<td><s:textfield name="filetype.keytext"></s:textfield></td>
				</tr>
				<tr>
					<td><s:submit value="Upload File"></s:submit></td>
					<td><s:reset value="Cancel"></s:reset></td>
				</tr>
			</table>	
		</s:form>
	</body>
</html>