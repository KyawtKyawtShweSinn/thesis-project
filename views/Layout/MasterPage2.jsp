<%@page contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
	<head>
		<meta charset="utf-8">
    	 <meta name="viewport" content="width=device-width, initial-scale=1.0">
    	 <meta name="description" content="">
    	 <meta name="author" content="">
		
		<tiles:importAttribute name="bootstrapcss" />
  		<link href="<%=request.getContextPath()%>/${bootstrapcss}" rel="stylesheet" type="text/css" media="screen"/>
  		
  		<tiles:importAttribute name="stylecss" />
  		<link href="<%=request.getContextPath()%>/${stylecss}" rel="stylesheet" type="text/css" media="screen"/>
  		
  		<tiles:importAttribute name="defaultcss" />
  		<link href="<%=request.getContextPath()%>/${defaultcss}" rel="stylesheet" type="text/css" media="screen"/>
  		

		
	</head>
	
	<body id="page-top" data-spy="scroll" data-target=".navbar-custom">


<div id="wrapper">
	
    <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="top-area">
			<tiles:insertAttribute name="header" />
		</div>
        <div class="container navigation">
			<tiles:insertAttribute name="menu" />
           
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
	
	<!-- Section: intro -->
    <section id="intro" class="intro">
		<div class="intro-content">
			<div class="container">
					<tiles:insertAttribute name="body" />	
			</div>
		</div>		
    </section>
	
	

	
	
	
	
</div>

	
</body>
</html>
