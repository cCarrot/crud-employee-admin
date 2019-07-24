<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Manager</title>
<style>
    .error{
        color: #ff0000;
        font-weight: bold;
    }
    .sucess{
    	color: green;
        font-weight: bold;
    }
    </style>
</head>
<body>
	<c:choose>
		<c:when test="${employee.employeeId==null}"><h1>Registrar Empleado</h1></c:when>
		<c:otherwise><h1>Editar Empleado</h1></c:otherwise>
	</c:choose>
	
	<form:form action="/admin/save" method="post" modelAttribute="employee">
		<table>
			<form:hidden path="employeeId"/>
		<tr>
			<td><form:label path="nombres">Nombres:</form:label></td>
			<td><form:input path="nombres"/></td>
			<td><form:errors path="nombres" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="telefono">Telefono:</form:label></td>
			<td><form:input path="telefono"/></td>
			<td><form:errors path="telefono" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="email">Email:</form:label></td>
			<td><form:input path="email"/></td>
			<td><form:errors path="email" cssClass="error" /></td>
		<tr>
			<td><form:label path="area">Area:</form:label></td>
			<!--<form:select path="area" items="${allAreas}" itemValue="areaId" itemLabel="nombre" />-->
			<td><form:select path = "area">
                     <form:option value = "-1" label = "Seleccione un area"/>
                     <form:options items = "${allAreas}" itemValue="areaId" itemLabel="nombre"/>
            </form:select> </td>
            <td><form:errors path="area" cssClass="error" /></td>
        </tr>
        <tr></tr>
        <tr></tr>
		<tr>
			<td><form:button>Guardar</form:button></td>
			<td><input type="button" value="Cancelar" onclick="window.location.href='list'; return false;"></td>
		</tr>
		</table>
	</form:form>
	
</body>
</html>