<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Usuario</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="/Practica003/css/estilo.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</head>
<body>

  <c:set var="p1" value="${requestScope['usuario']}" />
  <c:set var="p2" value="${requestScope['mensaje']}" />


	<div class="card text-center container mt-4 col-lg-4">
		<form class="form-sign" action="/Peralta_Torres_Daniel/CrearUsuario" method="POST">
			<div class="card-body">
				<div class="form-group">
					<a>Nombre</a>
					<input type="text"  class="form-control" id="exampleInputName2" placeholder="Nombre" name="nombre" required>
				</div>
				<div class="form-group">
					<a>Cédula</a>
					<input type="text" class="form-control" id="exampleInputName2" placeholder="Cédula" name="cedula" required>
				</div>
				<div class="form-group">
					<a>Dirección</a>
					<input type="text" class="form-control" id="exampleInputName2" placeholder="Dirección" name="direccion" required>
				</div>
				<div class="form-group">
					<a>Teléfono</a>
					<input type="text" class="form-control" id="exampleInputName2"" placeholder="Teléfono"  name="telefono" required>
				</div>
				<br>
				<button class="btn btn-primary" type="submit" name="resp" value="Registrarse">Registrarse</button>
			</div>
		</form>
	</div>
</body>
</html>
