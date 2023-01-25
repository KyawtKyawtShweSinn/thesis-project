 <%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<div align="center">
	<h2>
		<font color="blue">User List</font>
	</h2>
	<%-- <%int i=1; %> --%>
	<display:table export="false" id="shareFileSuccessInformation" name="rlist" class="table table-hover table-striped table-bordered" requestURI="shareFileSuccess" pagesize="8">
		<display:caption></display:caption> 
		<%-- <display:column title="No." ><%=i++ %></display:column> --%>
		
		<%-- <display:column><s:checkbox name="check"/></display:column> --%>
		<display:column title="User Name" property="username"></display:column>
		<display:column title="Email" property="email"></display:column>
		<display:column title="Phone" property="phone"></display:column>
		<display:column title="Gender" property="gender"></display:column>
		<display:column><s:a href="shareFileSuccessSend?id=%{#attr.shareFileSuccessInformation.rid}&madd=%{#attr.shareFileSuccessInformation.email}" onclick="return confirm('Are you sure you want to send?');">SEND</s:a></display:column> 
		
		<display:setProperty name="paging.banner.placement">bottom</display:setProperty>
		<display:setProperty name="export.pdf" value="true" />
		<display:footer>
		</display:footer>
	</display:table>
</div>
