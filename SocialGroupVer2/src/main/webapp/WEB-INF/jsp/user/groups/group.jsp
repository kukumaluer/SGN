<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link id="theme" rel="stylesheet" type="text/css" href="../../style.css"
	title="theme" />
<link rel="stylesheet" href="../../normalize.css">
<script type="text/javascript" language="javascript"
	src="../../js/jquery.js"></script>
<script type="text/javascript" language="javascript"
	src="../../js/custom.js"></script>
<script type="text/javascript" language="javascript"
	src="../../js/addon.js"></script>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>

<script type="text/javascript"
	src="/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" href="/fancybox/jquery.fancybox-1.3.4.css"
	type="text/css" media="screen" />


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
							<li class="current" style="border: none"><a class="toplvl"
								href="../profile.html">Home</a></li>
							<li><a href="../logout.html" class="toplvl">Logout</a></li>
							<li><a class="toplvl" href="#">Search </a>
								<ul>
									<li><a href="../../search/allPublic.html">View Public
											Groups</a></li>
									<li><a href="../../search/allPriv.html">View Private Groups..</a></li>

								</ul></li>
						</ul>
					</div>



				</div>

				<div class="bd">
					<div id="page">
						<div id="sidebar">
							<div class="content">

								<br> <br>

								<div>
									<img src="../../images/blue_group.png" style="width: 100%" />
								</div>

								<!--                   <div class="sidebox1"> -->
								<!--                     <h2>Groups</h2> -->
								<!--                     <div class="vmenu"> -->
								<!--                       <ul> -->
								<!--                       <li> -->
								<!--                       <a href = "../user/groups/newGroup.html">Create a new group</a> -->
								<!--                       </li> -->
								<%--                       <c:if test="${not empty user.groups}" > --%>
								<%-- 						<c:forEach items="${user.groups}" var="group" varStatus="status"> --%>
								<!-- 						<li> -->
								<%-- 						<a href = "group.html?groupId=${group.id}"> -- ${group.groupName} -- </a> --%>
								<!-- 						</li> -->
								<%-- 						</c:forEach> --%>
								<%-- 						</c:if> --%>
								<!--                       </ul> -->
								<!--                     </div> -->
								<!--                   </div> -->
								<!--                   <div> -->
								<!--                     <img src="images/business-man-1.png" style="width:100%" /> -->
								<!--                   </div> -->
								<div class="sidebox1">
									<h2>Friends in Group</h2>
									<div class="vmenu">
										<ul>
											<c:forEach items="${friends}" var="friends"
												varStatus="status">
												<li>

													<form action="../viewfriend.html" method="get">
														<input type="hidden" name="fID" value="${friends.id }">
														-- <a href="../viewfriend.html?fdId=${friends.id}">
															${friends.firstName} ${friends.lastName}</a> --
													</form> <c:if test="${isOwner eq true }">
														<form class="unfriend" action="unfriend.html" method="GET">
															<input type="hidden" name="unfriend"
																value="${friends.id}"> <input type="hidden"
																name="groupID" value="${group.id}">
															<button style="width: 60px">Unfriend</button>

														</form>
													</c:if>
												</li>


											</c:forEach>


										</ul>
									</div>
								</div>
							</div>
						</div>



						<div id="main">
							<div class="content">


								<section class="group g">
								<center>
									<h1>${group.groupName}</h1>
								</center>
								<center>
									<h2>Timeline</h2>
								</center>

								<ul>
									<c:forEach items="${group.commets}" var="comment"
										varStatus="status">
										<section class="comments c">

										<li><b>${comment.postedById.firstName}</b> commented
											<hr></li>
										<li>${comment.post}</li>
										</section>
									</c:forEach>

								</ul>

								<form class="post" action="post.html" method="GET">
									<table>
										<col width="325">
										<col width="320">

										<c:choose>
											<c:when test="${ingroup eq true }">
												<tr>
													<td><textarea class="textbox" name="posted"></textarea>
													</td>
												</tr>


												<tr>
													<td><input type="hidden" value="${group.id}"
														name="groupId">
														<button style="align: right" type="submit" name="submit"
															value="post">Post</button></td>
												</tr>
											</c:when>
											<c:otherwise>
												<tr>
													<td>
														<h2>
															<span style="color: red"> You are not a member --
																Add Group </span>

														</h2>



													</td>
												</tr>

											</c:otherwise>

										</c:choose>
										<!--                  <input type="submit" id = "1"  name="submit" value="post" /> -->
									</table>
								</form>

<%-- 								<c:if test="${ingroup eq false }"> --%>
<%-- 									<form class="addG" action="addGroup.html" method="GET"> --%>
<%-- 										<input type="hidden" name="groupId" value="${group.id}"> --%>
<!-- 										<button style="width: 40px">Add</button> -->
<%-- 									</form> --%>
<%-- 								</c:if> </section> --%>





							</div>
						</div>




						<div class="clear" style="height: 60px"></div>
					</div>
				</div>
				<div class="ft">
					<div id="footer">
						<div class="content"></div>
					</div>
					<div id="container-bottom"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>









</body>
</html>