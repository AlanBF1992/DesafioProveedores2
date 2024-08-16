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
	<section>
		<h1>Editar proveedor</h1>
		<form method="post" action="edit">
		<table class="table" id="tblProveedor">
			<thead>
				<tr>
					<th scope="col" class="table-dark">Campo</th>
					<th scope="col" class="table-dark">Valor inicial</th>
					<th scope="col" class="table-dark">Valor final</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row" class="table-dark">Nombre</th>
		            <td><c:out value="${p.getNombre()}"></c:out></td>
		            <td>
						<input type="text" class="form-control mb-3" id="nombre" name="nombre" aria-describedby="nombre" value="<c:out value="${p.getNombre()}"></c:out>" required>
					</td>
				</tr>
				<tr>
					<th scope="row" class="table-dark">Rut</th>
		            <td><c:out value="${p.getRut()}"></c:out></td>
		            <td>
						<input type="text" class="form-control mb-3" id="rut" name="rut" aria-describedby="rut" value="<c:out value="${p.getRut()}"></c:out>" required>
					</td>
				</tr>
				<tr>
					<th scope="row" class="table-dark">Direccion</th>
		            <td><c:out value="${p.getDireccion()}"></c:out></td>
		            <td>
		            	<input type="text" class="form-control mb-3" id="direccion" name="direccion" aria-describedby="direccion" value="<c:out value="${p.getDireccion()}"></c:out>" required>
	            	</td>
				</tr>
				<tr>
					<th scope="row" class="table-dark">Correo</th>
		            <td><c:out value="${p.getCorreo()}"></c:out></td>
		            <td>
		            	<input type="text" class="form-control mb-3" id="correo" name="correo" aria-describedby="correo" value="<c:out value="${p.getCorreo()}"></c:out>" required>
	            	</td>
				</tr>
				<tr>
					<th scope="row" class="table-dark">Telefono</th>
		            <td><c:out value="${p.getTelefono()}"></c:out></td>
		            <td>
		            	<input type="text" class="form-control mb-3" id="telefono" name="telefono" aria-describedby="telefono" value="<c:out value="${p.getTelefono()}"></c:out>" required>
	            	</td>
				</tr>
				<tr>
					<th scope="row" class="table-dark">Contacto</th>
		            <td><c:out value="${p.getContacto()}"></c:out></td>
		            <td>
		            	<input type="text" class="form-control mb-3" id="contacto" name="contacto" aria-describedby="contacto" value="<c:out value="${p.getContacto()}"></c:out>" required>
	            	</td>
				</tr>
				<tr>
					<th scope="row" class="table-dark">Teléfono Contacto</th>
		            <td><c:out value="${p.getTelefonoContacto()}"></c:out></td>
		            <td>
		            	<input type="text" class="form-control mb-3" id="telefono_contacto" name="telefono_contacto" aria-describedby="telefono_contacto" value="<c:out value="${p.getTelefonoContacto()}"></c:out>" required>
	            	</td>
				</tr>
			</tbody>
		</table>
  		<button type="submit" class="btn btn-danger" name="id" value=<c:out value="${p.getId()}"></c:out>>Guardar</button>
		</form>
	</section>
</main>
<script
 src="https://code.jquery.com/jquery-3.7.1.min.js"
 integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
 crossorigin="anonymous"></script>
<script src="//cdn.datatables.net/2.1.2/js/dataTables.min.js"></script>
<script>
$(document).ready(() => {
	$('#tblProveedor').DataTable({
	    searching: false,
	    paging: false,
	    ordering: false,
	    info: false
	});
})
</script>
</body>
</html>