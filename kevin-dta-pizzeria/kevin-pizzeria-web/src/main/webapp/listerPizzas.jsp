<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
             <%@ page import="java.util.List"%>
              <%@ page import="fr.pizzeria.model.Pizza"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html;" charset="utf-8">
   <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<title>Pizzeria</title>
</head>
<body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Pizzeria la Florentina</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Accueil</a></li>
            <li><a href="#about">La carte</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
<div class="jumbotron">
<div class="container"><h2>Liste des pizzas</h2></div>

 </div>
<div class="container">
<%
List<Pizza> pizzas = (List<Pizza>)request.getAttribute("pizzas");
for(Pizza pizza : pizzas) {
%>
  <div class="row">
   <div class="col-md-2 col-sm-6 col-xs12"><%= pizza.getCode()%></div>
   <div class="col-md-2 col-sm-6 col-xs12"><%= pizza.getNom() %></div>
   <div class="col-md-2 col-sm-6 col-xs12"><%= pizza.getPrix()%></div>
   <div class="col-md-2 col-sm-6 col-xs12"><%= pizza.getCategPizza()%></div>
   <div class="col-md-2 col-sm-6 col-xs12">image</div>
   <div class="col-md-1 col-sm-6 col-xs12"><a href="<%=request.getContextPath()%>/pizzas/edit?code=<%=pizza.getCode()%>" class="btn btn-primary">Modifier</a></div>
   <div class="col-md-1 col-sm-6 col-xs12"><a href="<%=request.getContextPath()%>/pizzas/delete?code=<%=pizza.getCode()%>" class="btn btn-primary">Supprimer</a></div>
  </div>
    <%  }
%>

 </div>
</body>
</html>