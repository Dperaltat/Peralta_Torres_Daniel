<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar y Editar</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="/Practica003/css/estilo.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</head>
<body>

	<c:set var="p1" value="${requestScope['cliente'] }" />
	<c:set var="p2" value="${requestScope['idc'] }" />

<center>
	<div class="card" style="width: 45rem;">
	<form action="/Peralta_Torres_Daniel/AgregarNumero?ced=${p2 }" method="POST">
	<div class="card-body">
		<div class="form-group row">
			<label for="numero" class="col-sm-2 col-form-label">Placa</label>
			<div class="col-sm-10">
				<input class="form-control" type="text" name="numero" placeholder="Número" maxlength="10">
			</div>		
		</div>
		<div class="form-group row">
			<label for="operadora" class="col-sm-2 col-form-label">Marca</label>
			<div class="col-sm-10">
				<input class="form-control" type="text" name="operadora" placeholder="Operadora">
			</div>
		</div>
		<div class="form-group row">
			<label for="tipo" class="col-sm-2 col-form-label">Modelo</label>
			<div class="col-sm-10">
				<input class="form-control" type="text" name="tipo" placeholder="Tipo">
			</div>
		</div>
		<br>
		<button type="submit" name="agregar" value="ingresar" class="btn btn-primary mb-2">Agregar</button>
	</div>		
	</form>
	</div>
</center>
</body>
</html>
