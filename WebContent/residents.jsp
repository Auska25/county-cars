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

	<h1>Resident Manager</h1>
	<s:actionerror />

	<s:form action="addResident" method="post">
		<s:textfield name="resident.firstName" label="FirstName" />
		<s:textfield name="resident.lastName"  label="LastName" />
		<s:submit value="Add Resident" align="center" />
	</s:form>


	<h2>Residents</h2>
	<table id="resident" border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>County</th>
		</tr>
		<s:iterator value="residentList" var="resident">
			<tr>
				<td><s:property value="firstName" /></td>
				<td><s:property value="lastName" /></td>
				<td><s:property value="county" />
				<td><a href="deleteResident?residentId=<s:property value="residentId"/>">delete</a></td>
				<td><a href="cars?residentId=<s:property value="residentId" />">cars</a></td>
			</tr>
		</s:iterator>
	</table>
	
	<a href="index">logout</a>
	
</body>
</html>