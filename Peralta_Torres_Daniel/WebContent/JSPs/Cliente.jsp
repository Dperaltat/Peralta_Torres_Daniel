<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="/Practica003/css/estilo.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<title>Usuario</title>

</head>
<body>
  <c:set var="v1" value="${requestScope['vehiculo'] }"/>
  <c:set var="p2" value="${requestScope['cliente'] }"/>

				<li class="nav-item">
					<a class="nav-link" href="/Peralta_Torres_Daniel/JSPs/Busquedas.jsp">Buscar</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/Peralta_Torres_Daniel/ControladorSesiones?id=1&c=${p2.cedula }">Agregar Vehiculo</a>
				</li>

	<center>
	<h1>BIENVENIDO</h1>
	<div class="card" style="width: 20rem;">
	<br>
		<div class="card-body">
			<h5 class="card-title">	${p2.nombre } ${p2.cedula }</h5>
			<h6 class="card-subtitle mb-2 text-muted">${p2.direccion }</h6>
			<h6 class="card-subtitle mb-2 text-muted">${p2.telefono }</h6>
		</div>
	</div>
	</center>
	<br>

	<table class="table">
	<thead>
		<tr>
			<th scope="col">Placa</th>
			<th scope="col">Marca</th>
			<th scope="col">Modelo</th>
			<th scope="col">Ticket</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="veh" items="${v1 }">
			<tr>
				<td>${veh.placa }</td>
				<td>${veh.marca }</td>
				<td>${veh.modelo }</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	

</body>
</html>