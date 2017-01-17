<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<h1>Login</h1>

	<form method="post" action="authentication">
		<input name="username" type="text"/>
		<input name="password" type="password"/>
		<input type="submit" value="Submit" />
	</form>
	${error }
</body>
</html>
