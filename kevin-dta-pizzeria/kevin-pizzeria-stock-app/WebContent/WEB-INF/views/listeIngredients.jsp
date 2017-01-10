<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
<title>Ingredients</title>
</head>
<body>
	<h1>Liste des ingredients</h1>

	<table>
		<thead>
			<tr>
				<td>id</td>
				<td>nom</td>
				<td>prix</td>
				<td>quantité</td>
			<tr>
		</thead>
		<c:forEach items="${ingredients}" var="ingred">
			<tr>
				<td>${ingred.id}</td>
				<td>${ingred.nom}</td>
				<td>${ingred.prix}</td>
				<td>${ingred.quantite}</td>
			</tr>

		</c:forEach>

		<tbody>
		</tbody>
	</table>


</body>
</html>