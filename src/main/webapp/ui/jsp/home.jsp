<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div>
        <form action="/logout" method="post">
            <button type="submit" class="btn btn-danger">Salir</button>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </form>
    </div>
    
    <h1>Administrador de Empleados</h1>
    
    <input type="button" value="Registrar Empleado"
    onclick="window.location.href='showForm'; return false;"/>
    <br/>
    
	<h2>Lista de Empleados</h2>
	
	<c:out value="${danger}"></c:out></b>
	
	<table border="1px solid black">
		<thead>
			<tr>
				<th>Nombres</th>
				<th>Telefono</th>
				<th>Email</th>
				<th>Area</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${employees}">
			
			<c:url var="updateLink" value="/admin/updateForm">
	          <c:param name="employeeId" value="${emp.employeeId}" />
	        </c:url>
	
	        <!-- construct an "delete" link with customer id -->
	        <c:url var="deleteLink" value="/admin/delete">
	          <c:param name="employeeId" value="${emp.employeeId}" />
	        </c:url>
       
			<tr>
				<td>${emp.nombres}</td>
				<td>${emp.telefono}</td>
				<td>${emp.email}</td>
				<td>${emp.area.nombre}</td>
				<td>
					<a href="${updateLink}">Editar</a>
					<a href="${deleteLink}" onclick="if (!(confirm('¿Está seguro que quiere eliminar al Empleado?'))) return false">Eliminar</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
		
</body>
</html>