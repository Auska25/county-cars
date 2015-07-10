<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<style>
body,input {
	font-family: Calibri, Arial;
}

table#car {
	border-collapse: collapse;
	width: 550px;
}

th {
	height: 40px;
	background-color: #ffee55;
}
</style>
<title>County Car Reg</title>
</head>
<body>

	<h1>Login</h1>
	<s:actionerror />

	<s:form action="login" method="post">
		<s:textfield name="user.userName" label="UserName" />
		<s:submit value="Login" align="center" />
	</s:form>
	
</body>
</html>