<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.pizzeria.model.Pizza"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/entete.jsp"></c:import>


<title>Pizzeria - Authentification</title>
</head>
<body>
	<c:import url="/nav_entete.jsp"></c:import>
		<div class="jumbotron">
		<div class="container">
			<h2>Pizzeria Administration</h2>
		</div>
	</div>
	<div class="container">
		<form class="form-horizontal" method="post"
			action="<c:url value="/login"/>">
			<fieldset>

				<!-- Form Name -->
				<legend> Se connecter</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="login">Nom d'utilisateur</label>
					<div class="col-md-4">
						<input id="code" name="login" type="text" placeholder="Nom d'utilisateur"
							class="form-control input-md" required="" value="admin">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="motdepasse">Mot de passe</label>
					<div class="col-md-4">
						<input id="nom" name="motdepasse" type="password" placeholder="Mot de passe"
							class="form-control input-md" required="" value="admin@pizzeria">

					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>
					<div class="col-md-4">
						<input type="submit" id="valider" name="valider"
							class="btn btn-success" value="Valider" />
					</div>
				</div>

			</fieldset>
		</form>


	</div>

</body>
</html>