<%@ page import="java.util.List"%>
<%@ page import="fr.pizzeria.model.Pizza"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html;" charset="utf-8">
<script
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<title>Pizzeria</title>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Pizzeria la Florentina</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Accueil</a></li>
					<li><a href="#about">La carte</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="jumbotron">
		<div class="container">
			<h2>Gestion des pizzas</h2>
			<h3></h3>
		</div>

	</div>
	<div class="container">
		<a href="#" class="btn btn-success">Ajouter</a>
		<table class="table">
			<thead>
				<tr>
					<th>Code</th>
					<th>Nom</th>
					<th>Prix</th>
					<th>Catégorie pizza</th>
					<th>Image</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
						
			<c:forEach var="pizza" items="${pizzas}">
			<tr>
						<td>${pizza.code}</td>
						<td>{pizza.nom}</td>
						<td>{pizza.prix}</td>
						<td>{pizza.CategoriePizza}</td>
						<td>image</td>
						<td><a href='<c:url value="/pizzas/edit?code=${pizza.code}"/>' class="btn btn-primary">Modifier</a>
					<td><a href='<c:url value="/pizzas/delete?code=${pizza.code}"/>' class="btn btn-danger">Supprimer</a>
					</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>