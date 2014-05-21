<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link id="theme" rel="stylesheet" type="text/css" href="../style.css" title="theme" />
<link rel="stylesheet" href="../normalize.css">

<script type="text/javascript" language="javascript" src="../js/jquery.js"></script>
<script type="text/javascript" language="javascript" src="../js/custom.js"></script>
<script type="text/javascript" language="javascript" src="../js/addon.js"></script>


<title>Social Group Network</title>
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
                
                  <a class="toplvl" href="../user/profile.html">Home</a>
                </li>
                <li>
                  <a href="user/logout.html" class="toplvl">Logout</a>
                </li>
                <li>
                  <a class="toplvl" href="#">Search </a>
                  <ul>
                  	<li>
                  	 <a href = "../search/allPublic.html">Public Groups</a>
                  	</li>
                  </ul>
                  
                </li>
              </ul>
            </div>
          </div>
          <div class="bd">
            <div id="page">
              <div id="main">
                <div class="content">
                
                  <h1>Public Groups</h1>
                  <h3>${user.firstName} </h3>
                  <section class = "allg ag" > 
                  <table>
                 
                  <c:forEach items="${allGroups}" var="all" varStatus="status">
                  <c:if test = "${user.id != all.ownerId.id }">
                  
                  <tr>
                  <td>
                  
                 
					                 
                  ${all.groupName} - Created by<a href = "../user/viewProfile.html?userId=${all.ownerId.id}" > ${all.ownerId.firstName} ${all.ownerId.lastName} </a> 
                  
                   </td>
                   <td>
                 <form  class ="addG" action="addGroup.html" method="GET">  
                   <input type ="hidden" name="groupId" value="${all.id}">
                   <button style = "width:40px">Add</button>
                   
                  </form>
        			</td>
        			</tr>  
        			        
		            </c:if>      
                  </c:forEach>
                  
                  
                  </table>
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