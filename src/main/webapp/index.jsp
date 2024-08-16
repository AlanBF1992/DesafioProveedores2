<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
	<jsp:include page="./assets/html/head.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="./assets/css/styles.css"/>
</head>
<body class="d-flex align-items-center justify-content-center">

<main class="justify-items-center">
	<section class="mb-5 formulario mx-auto">
		<h1 class="text-white">Agregar nuevo proveedor</h1>
	
		<form method="post">
			
			<input type="text" class="form-control mb-3" id="nombre" name="nombre" aria-describedby="nombre" placeholder="Nombre" required>
			<input type="text" class="form-control mb-3" id="rut" name="rut" aria-describedby="rut" placeholder="RUT" required>
			<input type="text" class="form-control mb-3" id="direccion" name="direccion" aria-describedby="direccion" placeholder="Dirección" required>
			<input type="text" class="form-control mb-3" id="correo" name="correo" aria-describedby="correo" placeholder="Email" required>
			<input type="text" class="form-control mb-3" id="telefono" name="telefono" aria-describedby="telefono" placeholder="Teléfono" required>
			<input type="text" class="form-control mb-3" id="contacto" name="contacto" aria-describedby="contacto" placeholder="Contacto" required>
			<input type="text" class="form-control mb-3" id="telefono_contacto" name="telefono_contacto" aria-describedby="telefono_contacto" placeholder="Teléfono Contacto" required>
				
			<button type="submit" class="btn btn-primary w-100">Agregar</button>
		</form>
	</section>
	
	<section>
		<h1>Proveedores</h1>
		<table class="table" id="tblProveedor">
			<thead>
				<tr>
					<th scope="col" class="table-dark">id</th>
					<th scope="col" class="table-dark">Nombre</th>
					<th scope="col" class="table-dark">Rut</th>
					<th scope="col" class="table-dark">Dirección</th>
					<th scope="col" class="table-dark">Correo</th>
					<th scope="col" class="table-dark">Teléfono</th>
					<th scope="col" class="table-dark">Contacto</th>
					<th scope="col" class="table-dark">Teléfono Contacto</th>
					<th scope="col" class="table-dark">Acciones</th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach var="p" items="${proveedores}">
				<tr>
		            <th scope="row"><c:out value="${p.getId()}"></c:out></th>
		            <td><c:out value="${p.getNombre()}"></c:out></td>
		            <td><c:out value="${p.getRut()}"></c:out></td>
		            <td><c:out value="${p.getDireccion()}"></c:out></td>
		            <td><c:out value="${p.getCorreo()}"></c:out></td>
		            <td><c:out value="${p.getTelefono()}"></c:out></td>
		            <td><c:out value="${p.getContacto()}"></c:out></td>
		            <td><c:out value="${p.getTelefonoContacto()}"></c:out></td>
		            <td>
			            <div class="d-flex">
			            	<a class="btn btn-primary" href="edit?edit_id=<c:out value="${p.getId()}"></c:out>">Editar</a>
			            	<form method="post">
			            		<button type="submit" class="btn btn-danger" name="delete_id" value=<c:out value="${p.getId()}"></c:out>>Borrar</button>
			            	</form>
		            	</div>
		            </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</section>
</main>
<script
 src="https://code.jquery.com/jquery-3.7.1.min.js"
 integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
 crossorigin="anonymous"></script>
<script src="//cdn.datatables.net/2.1.2/js/dataTables.min.js"></script>
<script>
$(document).ready(() => {
	$('#tblProveedor').DataTable();
})
</script>
</body>
</html>