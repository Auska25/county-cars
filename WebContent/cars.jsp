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
	
	<h1>Car Manager</h1>
    <s:actionerror />

    <s:form action="addCar" method="post">
        <s:textfield name="car.licencePlate" label="LicencePlate" />
        <s:textfield name="car.make"  label="Make" />
        <s:textfield name="car.model"  label="Model" />
        <s:select name="car.color" list="{'black', 'silver', 'blue', 'red', 'white'}" />
        <s:hidden name="car.resident_residentId" value="%{residentId}" />
        <s:submit value="Add Car" align="center" />
    </s:form>


    <h2>Cars</h2>
    <table id="car" border="1">
        <tr>
            <th>Licence Plate</th>
            <th>Make</th>
            <th>Model</th>
            <th>Color</th>
            <th>Delete</th>
        </tr>
        <s:iterator value="carList" var="car">
            <tr>
                <td><s:property value="licencePlate" /></td>
                <td><s:property value="make" /></td>
                <td><s:property value="model" /></td>
                <td><s:property value="color" /></td>
                <td><a href="deleteCar?licencePlate=<s:property value="licencePlate"/>">delete</a></td>
            </tr>
        </s:iterator>
    </table>
    <a href="residents">residents</a><br/>
    <a href="index">logout</a>
</body>
</html>