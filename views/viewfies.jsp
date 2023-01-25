 <%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<div align="center">
	<h2>
		<font color="blue">File List</font>
	</h2>
	<%-- <%int i=1; %> --%>
	<display:table export="false" id="viewFileInformation" name="flist" class="table table-hover table-striped table-bordered" requestURI="viewFile" pagesize="8">
		<display:caption></display:caption>
		<%-- <display:column title="No." ><%=i++ %></display:column> --%>
		<display:column title="Cipher Data" property="ciphertext"></display:column>
		<display:column title="Owner" property="email"></display:column>
		<display:column title="Uploated Date" property="uploaddate"></display:column>
		
		<display:column><s:a href="viewFileRequest?id=%{#attr.viewFileInformation.fid}" onclick="return confirm('Are you sure you want to share?');">REQUEST KEY</s:a></display:column>
		
		<display:setProperty name="paging.banner.placement">bottom</display:setProperty>
		<display:setProperty name="export.excel.filename" value="StudentDetails.xls" />
		<display:setProperty name="export.pdf.filename" value="StudentDetails.pdf" />
		<display:setProperty name="export.pdf" value="true" />
		<display:footer>
		</display:footer>
	</display:table>	
</div>
