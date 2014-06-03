<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link id="theme" rel="stylesheet" type="text/css" href="../style.css" title="theme" />
<link rel="stylesheet" href="normalize.css">
<script type="text/javascript" language="javascript" src="../js/jquery.js"></script>
<script type="text/javascript" language="javascript" src="../js/custom.js"></script>
<script type="text/javascript" language="javascript" src="../js/addon.js"></script>



<title>Welcome ${user.firstName} ${user.lastName}</title>
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
                  <a class="toplvl" href="profile.html">Home</a>
                </li>
                <li>
                  <a href="logout.html" class="toplvl">Logout</a>
                </li>
                <li>
                  <a class="toplvl" href="#">Search </a>
                  <ul>
                  	<li>
                  	 <a href = "../search/allPublic.html">Public Groups</a>
                  	</li>
                  	<li>
                  	 <a href = "../search/allPriv.html">Private Groups</a>
                  	</li>
                  </ul>
                </li>
                <li>
                  <a href="notifications.html" class="toplvl">Notications ${numNtfs}</a>
                </li>
              </ul>
            </div>
          </div>
          
          <div class="bd">
            <div id="page">
            <div id="sidebar">
                <div class="content">
                
                <br>
                <br>
                
                <div>
                    <img src="../images/blue_group.png" style="width:100%" />
                  </div>
                  
                  <div class="sidebox1">
                    <h2>Groups</h2>
                    <div class="vmenu">
                      <ul>
                      <li>
                      <a href = "../user/groups/newGroup.html">Create a new group</a>
                      </li>
                      <c:if test="${not empty user.groups}" >
						<c:forEach items="${user.groups}" var="group" varStatus="status">
						<li>
						
<%-- 						<form action = "groups/group.html" method="GET"> --%>
<%-- 						<input type="hidden" value="${group.id}" id = "hiddenGroupId" name="hiddenGroupId"> --%>
<%-- 						</form>	 --%>
						<a href = "groups/group.html?groupId=${group.id}"> -- ${group.groupName} -- </a>
						</li>
						</c:forEach>
						</c:if>
<!--                         <li> -->
<!--                           <a href="#">Category 1</a> -->
<!--                         </li> -->
<!--                         <li> -->
<!--                           <a href="#">Category 2</a> -->
<!--                         </li> -->
<!--                         <li> -->
<!--                           <a href="#">Category 3</a> -->
<!--                         </li> -->
<!--                         <li> -->
<!--                           <a href="#">Category 4</a> -->
<!--                         </li> -->
<!--                         <li> -->
<!--                           <a href="#">Category 5</a> -->
<!--                         </li> -->
                      </ul>
                    </div>
                  </div>
<!--                   <div> -->
<!--                     <img src="images/business-man-1.png" style="width:100%" /> -->
<!--                   </div> -->
                  <div class="sidebox1">
                    <h2>Groups I am in..</h2>
                    <ul>
                    
                    
                    
                    <c:if test="${not empty inGroups}" >
						<c:forEach items="${inGroups}" var="inGroups" varStatus="status">
						<li>
						
<%-- 						<form action = "groups/group.html" method="GET"> --%>
<%-- 						<input type="hidden" value="${group.id}" id = "hiddenGroupId" name="hiddenGroupId"> --%>
<%-- 						</form>	 --%>
						<a href = "groups/group.html?groupId=${inGroups.id}"> -- ${inGroups.groupName} -- </a>
						
						<form  class ="unfollow" action="unfollow.html" method="GET">  
                   			<input type ="hidden" name="uid" value="${user.id}">
                   			<input type ="hidden" name="unfollow" value="${inGroups.id}">
                   			<button style = "width:60px" >unfollow </button>
                   
                  		</form>
						
						</li>
						</c:forEach>
						</c:if>
						
						
						
                    
                    </ul>
                    
                    
                    
                    
                  </div>
                </div>
              </div>
              
            
            
              <div id="main">
                <div class="content">
				
				<section class="group g">
			<ul>
				<c:forEach items="${user.notifications}"  var ="notifications" varStatus ="status">
				<li>
				${notifications.friendId.firstName} ${notifications.friendId.lastName} wants to add 
				your group ${notifications.groudId.groupName }.
				<form  class ="addG" action="approve.html" method="GET">  
                   <input type ="hidden" name="groupId" value="${notifications.groudId.id}">
                   <input type ="hidden" name="requesterId" value="${notifications.friendId.id}">
                   <input type ="hidden" name="ntfIndex" value="${status.index}">
                   <button style = "width:40px">Add</button> 
                   </form>
				</li>
				
				</c:forEach>			
			</ul>

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