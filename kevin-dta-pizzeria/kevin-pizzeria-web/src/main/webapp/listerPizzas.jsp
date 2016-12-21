<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.pizzeria.model.Pizza"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/entete.jsp"></c:import>

<title>Pizzeria</title>
</head>
<body>

<c:import url="/nav_entete.jsp"></c:import>
	<div class="jumbotron">
		<div class="container">
			<h2>Bienvenue ${utilisateur}</h2>
			<h3>Gestion des pizzas</h3>
		</div>

	</div>
	<div class="container">
		<a href='<c:url value="/pizzas/new"/>' class="btn btn-success">Ajouter</a>
		<table class="table table-striped">
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
						<td>${pizza.nom}</td>
						<td>${pizza.prix}€</td>
						<td>${pizza.categPizza.nomCateg}</td>
						<td><img src="<c:url value="/images/pizzas/${pizza.url}"/>"
							width="70" /></td>
						<td><a
							href='<c:url value="/pizzas/edit?code=${pizza.code}"/>'
							class="btn btn-primary">Modifier</a>
						<td><a
							href='<c:url value="/pizzas/delete?code=${pizza.code}"/>'
							class="btn btn-danger">Supprimer</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>