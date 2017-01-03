<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.pizzeria.model.Pizza"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/entete.jsp"></c:import>

<title>Pizzeria - Gestion des clients</title>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#form_ajout").hide();
						$("#ajouter_client a").click(function() {
							$("#form_ajout").show();
						});
						$("#hide_ajouter").click(function() {
							$("#form_ajout").hide();
						});

						$
								.ajax({
									url : 'http://localhost:8080/kevin-pizzeria-web/api/rest/clients',
									type : 'GET',
									dataType : 'JSON',
									success : function(data) {
										console.log(data);

										$
												.each(
														data,
														function(index, value) {
															console.log(index);
															$("#tbody_data")
																	.append(
																			"<tr><td>"
																					+ value['nom']
																					+ "</td><td>"
																					+ value['prenom']
																					+ "</td><td>"
																					+ value['adresse']
																					+ "</td><td>"
																					+ value['ville']
																					+ "</td><td>"
																					+ value['codePostal']
																					+ "</td><td>"
																					+ value['email']
																					+ "</td></tr>");

														});

									}
								});

					});
</script>
</head>
<body>

	<c:import url="/nav_entete.jsp"></c:import>
	<div class="jumbotron">
		<div class="container">
			<h2>Bienvenue ${utilisateur}</h2>
			<h3>Gestion des Client</h3>
		</div>

	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-6 col-xs-12">
				<div id="ajouter_client">

					<a href="#" class="btn btn-success">Ajouter un nouveau client</a>
				</div>

			</div>
			<div class="col-md-3 col-sm-6 col-xs-12">
				<a href='<c:url value="/pizzas/corbeille"/>' class="btn btn-danger">Corbeille</a>
			</div>

		</div>
		<div id="list_client">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Adresse</th>
						<th>Ville</th>
						<th>Code postal</th>
						<th>Email</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="tbody_data">

				</tbody>
			</table>
		</div>
	</div>
	<div id="form_ajout">
		<div class="container">
			<form class="form-horizontal">
				<fieldset>

					<!-- Form Name -->
					<legend>
						Ajouter un client
						<!-- Button -->
						<a id="hide_ajouter" href="#" class="btn btn-primary">retour </a>
					</legend>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="nom">Nom </label>
						<div class="col-md-4">
							<input id="nom" name="nom" type="text" placeholder="nom"
								class="form-control input-md" required="">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="prenom">Prenom</label>
						<div class="col-md-4">
							<input id="prenom" name="prenom" type="text" placeholder="prenom"
								class="form-control input-md" required="">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="adresse">Adresse</label>
						<div class="col-md-5">
							<input id="adresse" name="adresse" type="text"
								placeholder="adresse" class="form-control input-md" required="">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="ville">Ville</label>
						<div class="col-md-4">
							<input id="ville" name="ville" type="text" placeholder="ville"
								class="form-control input-md" required="">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="code_postal">Code
							Postal</label>
						<div class="col-md-4">
							<input id="code_postal" name="code_postal" type="text"
								placeholder="code postal" class="form-control input-md"
								required="">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="email">Email</label>
						<div class="col-md-4">
							<input id="email" name="email" type="text" placeholder="email"
								class="form-control input-md" required="">

						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="motdepasse">Mot
							de passe</label>
						<div class="col-md-4">
							<input id="motdepasse" name="motdepasse" type="password"
								placeholder="mot de passe" class="form-control input-md"
								required="">

						</div>
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="ajouter"></label>
						<div class="col-md-4">
							<button id="ajouter" name="ajouter" class="btn btn-primary">Ajouter</button>
						</div>
					</div>

				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>