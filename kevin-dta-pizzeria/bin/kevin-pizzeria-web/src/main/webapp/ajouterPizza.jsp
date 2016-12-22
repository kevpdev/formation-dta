<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.pizzeria.model.Pizza"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/entete.jsp"></c:import>

<c:set var="pizza" scope="page" value="${pizza}"></c:set>
<title>Pizzeria - Modifier la pizza ${pizza.nom}</title>
</head>
<body>
	<c:import url="/nav_entete.jsp"></c:import>
	<div class="jumbotron">
		<div class="container">
			<h2>Ajouter une pizza</h2>
		</div>
	</div>
	<div class="container">
		<form class="form-horizontal" method="post"
			action="<c:url value="/pizzas/new"/>">
			<fieldset>

				<!-- Form Name -->
				<legend> Ajouter une pizza </legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="code">Code</label>
					<div class="col-md-4">
						<input id="code" name="code" type="text" placeholder="code"
							class="form-control input-md" required="" value="">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="nom">Nom</label>
					<div class="col-md-4">
						<input id="nom" name="nom" type="text" placeholder="nom"
							class="form-control input-md" required="" value="">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="prix">Prix</label>
					<div class="col-md-4">
						<input id="prix" name="prix" type="text" placeholder="prix"
							class="form-control input-md" required=""
							value="">

					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="categ_pizza">Catégorie
						de Pizza</label>
					<div class="col-md-4">
						<select id="categ_pizza" name="categ_pizza" class="form-control">
							<option value="VIANDE">Viande</option>
							<option value="SANS_VIANDE">Sans Viande</option>
							<option value="POISSON">Poisson</option>
						</select>
					</div>
				</div>

				<!-- File Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="url_image">Url
						image</label>
					<div class="col-md-4">
						<input id="url_image" name="url_image" class="input-file"
							type="file">
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>
					<div class="col-md-4">
						<input type="submit" id="enregistrer" name="enregistrer"
							class="btn btn-success" value="Enregistrer" />
					</div>
				</div>

			</fieldset>
		</form>


	</div>

</body>
</html>