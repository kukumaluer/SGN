<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link id="theme" rel="stylesheet" type="text/css" href="style.css" title="theme" />
<link rel="stylesheet" href="normalize.css">
<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
<script type="text/javascript" language="javascript" src="js/custom.js"></script>
<script type="text/javascript" language="javascript" src="js/addon.js"></script>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>

<script type="text/javascript" src="/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" href="/fancybox/jquery.fancybox-1.3.4.css" type="text/css" media="screen" />



<title>Create Account</title>
</head>
<body>


		
		<div id="top">
      <div class="overlay"></div>
    </div>
    <div id="wrapper">
      <div class="overlay"></div>
      <div class="border-top"></div>
      <div class="content">
        <div id="container">
          <div class="hd">
            <div id="container-top"></div>
            <div id="banner"></div>
            <div id="hmenu-wpr">
              <ul id="hmenu" class="sf-menu sf-js-enabled sf-shadow">
                <li class="current" style="border:none">
                  <a class="toplvl" href="home.html">Home</a>
                </li>
                <li>
                
                  <a href="login.html" class="toplvl">Login</a>
                
                </li>
         
                <li>
                  <a class="toplvl" href="#">Search </a>

                    </li>
              </ul>
            </div>
          </div>
          <div class="bd">
            <div id="page">
              <div id="main">
                <div class="content">
                  <h1>Create Account</h1>
                  <h3>Social Group Network </h3>
                    <c:if test = "${not empty err}">
						<font color = "red">${err}</font>
					</c:if>
                    
                    
                    
                    <section class = "signup su">
                    <form:form modelAttribute="user">
				<ul >

					<li >
					<label> First Name:</label> <form:input path="firstName" /><span style = "color:red;"><form:errors path = "firstName"/></span>
					</li>	
					<li>
					<label>	Last Name: </label> <form:input path="lastName" /><span style = "color:red;"><form:errors path = "lastName"/></span>
					</li>	
					<li>
					
					
					<label>Email: </label> <form:input path="email" /><span style = "color:red;"><form:errors path = "email"/></span>
						</li>
					

					<li>
					<label>	Password </label>  <form:password path="password" /><span style = "color:red;"><form:errors path = "password"/></span>
					</li>	
					
				</ul>


				<input type="submit" name="submit" value="Submit" />


			</form:form>
                    
                    
                    
</section>                    
                    
                    
                </div>
              </div>
              <div class="clear" style="height:60px"></div>
            </div>
          </div>
          <div class="ft">
            <div id="footer">
              <div class="content">


              </div>
            </div>
            <div id="container-bottom"></div>
          </div>
        </div>
      </div>
    </div>
    <div class="clear"></div>
    
		
		
		
		
						


</body>
</html>