
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="utilisateur" scope="page" value="${utilisateur}"></c:set>
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
			<a class="navbar-brand" href="<c:url value="/pizzas/list" />">Pizzeria
				la Florentina</a>
		</div>

		<div id="navbar" class="collapse navbar-collapse">
			<c:if test="${null != utilisateur}">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<c:url value="/pizzas/list" />">Accueil</a></li>
					<li class="dropdown"><a href="" class="dropdown-toggle"
						type="button" data-toggle="dropdown">Gérer<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li ><a href="<c:url value="/pizzas/list" />">Pizzas</a></li>
							<li><a href="#about">Commandes</a></li>
							<li><a href="<c:url value="/clients.jsp" />">Clients</a></li>
						</ul></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</c:if>

			<c:if test="${null == utilisateur}">
				<form class="navbar-form navbar-right" method="post"
					action="<c:url value="/login"/>">
					<div class="form-group">
						<input id="code" name="login" type="text"
							placeholder="Nom d'utilisateur" class="form-control input-md"
							required="" value="">
					</div>
					<div class="form-group">
						<input id="nom" name="motdepasse" type="password"
							placeholder="Mot de passe" class="form-control input-md"
							required="" value="">
					</div>
					<button type="submit" class="btn btn-success">Se connecter</button>
				</form>
			</c:if>
			<c:if test="${null != utilisateur}">
				<form class="navbar-form navbar-right">
					<div class="form-group">
						<span class="label label-primary">Bienvenue ${utilisateur}</span>
					</div>
					<div class="form-group">
						<a href="<c:url value="/logout"/>" class="btn btn-danger">Deconnecter</a>
					</div>

				</form>

			</c:if>
		</div>
		<!--/.nav-collapse -->

	</div>
</nav>