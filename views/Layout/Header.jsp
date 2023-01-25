<%@page contentType="text/html; charset=ISO-8859-1"%>
<%@page import="Entities.Register" %>
 <div class="container">
	<div class="row">
		<div class="col-sm-6 col-md-6">
		<p class="bold text-left">Secure File Sharing System </p>
		</div>
		<% Register r=(Register)session.getAttribute("reg"); %>
		<div class="col-sm-6 col-md-6">
					<p class="bold text-right"><%=r.getEmail() %></p>
		</div>
	</div>
</div> 
			