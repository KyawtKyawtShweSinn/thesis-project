<%@page contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

 <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>
               
                <a class="navbar-brand" href="Home.jsp">
                    <img src="images/logo.jpg" alt="" width="70" height="61" />
                </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
			  <ul class="nav navbar-nav">
				<li class="active"><a href="<s:url action="home"/>">Home</a></li>
				<li><a href="<s:url action="uploadFileForm"/>">Upload</a></li>
				<li><a href="<s:url action="shareFile"/>">Share File</a></li>
				<li><a href="<s:url action="viewFile"/>">View File</a></li>
				<li><a href="<s:url action="viewRequest"/>">View Request</a></li>
				
				<li><a href="<s:url action="downloadFile"/>">Download</a></li>
				<li><a href="<s:url action="logout"/>">Logout</a></li>
				
			  </ul>
            </div>
