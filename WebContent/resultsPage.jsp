<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GameOfThrones</title>
</head>
<link rel="stylesheet" type="text/css" href="index.css">
<body>
<body id="results">
	<%-- <c:choose> --%>
		<%-- <c:when test="${! empty lastName}"> --%>

					
			<!--  <ul>-->
				<!-- <ul> -->
					<ul><c:forEach var="test" items="${family}">
						<!--  <li>-->
							
							
									
								
											<li><form action="RemoveCharacter.do" method="POST">
												${test.firstName} of House ${test.lastName}</br>
										
										
									
									
												<input type="hidden" name="firstName" value="${test.firstName}"></input>
												<button type="submit" name="delete" value="remove">Valar Morghulis</button>
											</form>
										
										<!--  </td>-->
									
								
											
										
											<form action="editCharacter.do" method="GET">
												<input type="hidden" name="firstName" value="${test.firstName}"/>
											 	<input type="hidden" name="lastName" value="${test.lastName}"/>
											  	<input type="hidden" name="gender" value="${test.gender}"/>
											    <input type="hidden" name="status" value="${test.status}"/>
				
												<button type="submit" name="edit" value="edit">Edit</button></li>
											</form>
										
								
								</c:forEach>
							
						<!--  </li>-->
					<c/:forEach>
			<!--  </ul>-->
		<%-- </c:when> --%>
	<%-- </c:choose> --%>
	<p></p>
	<p></p>
	<li><a href="addCharacter.html">Add Character</a></li>
	</ul>



</body>
</html>