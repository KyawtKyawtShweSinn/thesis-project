 <%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<div align="center">
	<h2>
		<font color="blue">File List</font>
	</h2>
	
	<display:table export="false" id="shareInformation" name="flist" class="table table-hover table-striped table-bordered" requestURI="shareFile" pagesize="8">
		<display:caption></display:caption>
		 <%-- <display:column title="No." ><s:property value="%{count}"/></display:column>  --%>
		<%-- <display:column title="File Name" property="photoFileName"></display:column>
		<display:column title="Owner" property="sid"></display:column> --%>
		<display:column title="Cipher Data" property="ciphertext"></display:column>
		<display:column title="Uploated Date" property="uploaddate"></display:column>
		<display:column><s:a href="shareFileSuccess?fileid=%{#attr.shareInformation.fid}" >SHARE</s:a></display:column>
		
		<display:setProperty name="paging.banner.placement">bottom</display:setProperty>
		<display:setProperty name="export.excel.filename" value="StudentDetails.xls" />
		<display:setProperty name="export.pdf.filename" value="StudentDetails.pdf" />
		<display:setProperty name="export.pdf" value="true" />
		<display:footer>
		</display:footer>
	</display:table>	
</div>
