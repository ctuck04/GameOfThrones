<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<link rel="stylesheet" type="text/css" href="index.css">
</head>
<body id="change">
	<form id="form" action="editCharacter.do" Method="POST">
		First Name:<input type="text" name="firstName" value="${fn}"><br/>
		<p></p>
		Family:<input type="text" name="lastName" value="${ln}"><br/>
		<p></p>
	    Gender:<input type="text" name="gender" value="${g}"><br/>		
	    <p></p>
	    Status:<input type="text" name="status" value="${st}"><br/>
		<p></p>
		<input type="hidden" name="oldFirstName" value="${fn}">
		<button type="submit" name="edit" value="edit">Update</button>
	</form>	   
</body>
</html>