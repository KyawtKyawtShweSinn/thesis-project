<%@page contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta charset="utf-8">
    	<meta charset="utf-8">
		
		<tiles:importAttribute name="bootstrap" />
  		<link href="<%=request.getContextPath()%>/${bootstrap}" rel="stylesheet" type="text/css" media="screen"/>
		
		<tiles:importAttribute name="bootstrapcss" />
  		<link href="<%=request.getContextPath()%>/${bootstrapcss}" rel="stylesheet" type="text/css" media="screen"/>
  		
  		<tiles:importAttribute name="basecss" />
  		<link href="<%=request.getContextPath()%>/${basecss}" rel="stylesheet" type="text/css" media="screen"/>
  		
  		
  		

		<tiles:importAttribute name="jquery" />
  		<script type="text/javascript" src="<%=request.getContextPath()%>/${jquery}"></script>
		
		
		<tiles:importAttribute name="bootstrapscript" />
  		<script type="text/javascript" src="<%=request.getContextPath()%>/${bootstrapscript}"></script>
		
		
		
		<style type="text/css">
                body { 
                    
                 background: url('images/bg1.jpg') no-repeat center center fixed ;
                  
                 -webkit-background-size: cover;
                 -moz-background-size: cover;
                 -o-background-size: cover;
                 background-size: cover;
               
                }
                
                .panel-default {
                    opacity:0.7;
                 margin-top:200px;
                 margin-left:-300px;
                 margin-right:250px;
                
                }
                .form-group.last {
                 margin-bottom:0px;
                }
        .login-heading
        {
            background-color:#0a1dcb;
            height:50px;
            color:white;
            padding: 10px 15px;
            border-bottom: 1px solid transparent;
            border-top-left-radius: 3px;
            border-top-right-radius: 3px;
        }
    </style>	
	
	</head>
	
	<body>
    
    <div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-7">
            <div class="panel panel-default">
                <div class="login-heading">
                <strong class="">Login</strong>
                </div>
                <div class="panel-body">
                    <s:form action="login">
						<s:textfield label="Email" name="email"></s:textfield>
						<s:password label="Password" name="password"></s:password>
						<s:submit value="Login"></s:submit>
						<s:submit value="Cancel"></s:submit>
					</s:form>
					<div class="txt1">New User?<a href="<s:url action="registerForm"/>">Register</a></div>
                </div>
            </div>
        </div>
    </div>
</div>
       
</body>
</html>
 <div id="signup" class="modal fade"  role="dialog" aria-labelledby="login" aria-hidden="false">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Sign Up</h4>
        </div>
        <div class="modal-body">
          <form class="form-horizontal loginFrm" action="signup_check" method="post">
		<form class="form-horizontal loginFrm" action="signup" method="post">
				<div class="control-group">								
				<input type="text" name="inputName" placeholder="Name">
			  </div>
			  <div class="control-group">								
				<input type="text" name="inputEmail" placeholder="Email">
			  </div>
			  <div class="control-group">
				<input type="password" name="inputPassword" placeholder="Password">
			  </div>
			  <div class="control-group">
				<input type="text" name="phone" placeholder="Phone">
			  </div>
			   <div class="control-group">
				<input type="text" name="age" placeholder="Age">
			  </div>
			   <div class="control-group">
				<input type="text" name="address" placeholder="Address">
			  </div>
			  <div class="control-group">
				
				<input type="radio" name="gender" value="Female" checked="true">Female</input>
				<input type="radio" name="gender" value="Male">Male</input>
			  </div>
				
			<button type="submit" class="btn btn-success">Sign up</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			</form>	
			</form>
        </div>
       
      </div>
    </div>
  </div>
</div>
