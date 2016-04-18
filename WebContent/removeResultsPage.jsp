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
<body>
<body>
	<%-- <c:choose> --%>
		<%-- <c:when test="${! empty lastName}"> --%>

		<form action="RemoveCharacter.do" method="POST">			
			<ul>
				<!-- <ul> -->
					<c:forEach var="test" items="${family}">
						<li>
							
									
										${test.firstName} ${test.lastName}
										<input type="hidden" name="firstName" value="${test.firstName}"></input>
										<button type="submit" name="delete" value="remove">Delete</button>
								
							
						</
					</c:forEach>
			</ul>
		</form>
		<%-- </c:when> --%>
	<%-- </c:choose> --%>
	<p></p>
	<p></p>
	<a href="addCharacter.html">Add Character</a>



</body>
</html>