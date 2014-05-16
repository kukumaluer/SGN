<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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



<title>Sign in</title>
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
<!--             <div id="hmenu-wpr"> -->
<!--               <ul id="hmenu" class="sf-menu sf-js-enabled sf-shadow"> -->
<!--                 <li class="current" style="border:none"> -->
<!--                   <a class="toplvl" href="#">Home</a> -->
<!--                 </li> -->
<!--                 <li> -->
<!--                   <a href="#" class="toplvl">Loing</a> -->
<!--                 </li> -->
<!--                     <li> -->
<!--                       <a href="#" class="toplvl" >Create Account</a> -->
<!--                     </li> -->
<!--                 <li> -->
<!--                   <a class="toplvl" href="#">Search </a> -->

<!--                     </li> -->
<!--               </ul> -->
<!--             </div> -->
          </div>
          <div class="bd">
            <div id="page">
              <div id="main">
                <div class="content">
                  <h1>Login</h1>
                  
                 <section class= "loginform cf">
                  <form:form modelAttribute = "user">
                  
                  <ul>
				<li>
					<label for="usermail">Email</label>
					<form:input path ='email' />
                 </li>
                 <li>
                 <label for="password">Password</label>
                 <form:password path ='password' />
                 </li>
                 <li>
                 <input type='submit' name='login' value='Login' />
                 </li>
                 </ul>
                  
                  
<!-- <table> -->
<%-- <tr><td>Email:</td><td><form:input path ='email' /></td></tr> --%>
<%-- <tr><td>Password:</td><td><form:password path ='password' /></td></tr> --%>
<!-- <tr><td></td></tr><tr><td><input type='submit' name='login' value='Login' /></td></tr>  -->
<!-- </table> -->
</form:form>
				</section>

<!--                   <h3>Social Group Network </h3> -->
                  <!-- <p>
                    <img src="images/bizwoman-1.png" style="float:right;margin-left:20px" /> Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam. Maecenas ligula massa, varius a, semper congue, euismod non, mi.
                  </p>
                  <h2 style="margin-top:35px;">Heading h2</h2>
                  <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.</p>
                  <p>Cras elementum ultrices diam. Maecenas ligula massa, varius a, semper congue, euismod non, mi. Proin porttitor, orci nec nonummy molestie, enim est eleifend mi, non fermentum diam nisl sit amet erat. Duis semper. Duis arcu massa, scelerisque vitae, consequat in, pretium a, enim.</p>
                  <div style="margin-top:25px;">
                    <!-- TO REMOVE -->
                   <!--  <h3>LICENSE</h3>
                    <p>This template is provided for free. You are free to use it, share it, redistribute it, modify it in any way you want as long as you
                      <strong>keep a visible link back to doTemplate.com</strong> in the footer.
                    </p>
                  </div> -->
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
    
    
    


<%-- <form:form modelAttribute = "user"> --%>
<!-- <table> -->
<%-- <tr><td>Email:</td><td><form:input path ='email' /></td></tr> --%>
<%-- <tr><td>Password:</td><td><form:password path ='password' /></td></tr> --%>
<!-- <tr><td></td></tr><tr><td><input type='submit' name='login' value='Login' /></td></tr>  -->
<!-- </table> -->
<%-- </form:form> --%>


</body>
</html>