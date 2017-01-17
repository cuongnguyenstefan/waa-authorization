<%@ page session="false"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<h1>Login</h1>

	<form method="post" action="authentication">
		<input name="username" placeholder="username" type="text"/>
		<input name="password" placeholder="password" type="password"/>
		<input type="submit" value="Submit" />
	</form>
	${error }
</body>
</html>
