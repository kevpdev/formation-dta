<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
                 <%@ page import="java.util.List"%>
              <%@ page import="fr.pizzeria.model.Pizza"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html;" charset="utf-8">
   <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
   <% Pizza pizza = (Pizza)request.getAttribute("pizza"); %>
<title>Pizzeria - Modifier la pizza <%= pizza.getNom() %></title>
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
 <div class="container">
<h2> Modifier la pizza <%= pizza.getNom() %></h2>
</div>
 </div>
<div=container>
<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend> Modifier la pizza <%= pizza.getNom() %></legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="code">Code</label>  
  <div class="col-md-4">
  <input id="code" name="code" type="text" placeholder="code" class="form-control input-md" required="" value="<%= pizza.getCode() %>">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nom">Nom</label>  
  <div class="col-md-4">
  <input id="nom" name="nom" type="text" placeholder="nom" class="form-control input-md" required="" value="<%= pizza.getNom() %>">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="prix">Prix</label>  
  <div class="col-md-4">
  <input id="prix" name="prix" type="text" placeholder="prix" class="form-control input-md" required="" value="<%= pizza.getPrix() %>">
    
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="categ_pizza">Catégorie de Pizza</label>
  <div class="col-md-4">
    <select id="categ_pizza" name="categ_pizza" class="form-control">
      <option value="VIANDE"<%= pizza.getCategPizza().toString() == "Viande" ? "selected='selected'" : ""%>>Viande</option>
      <option value="SANS_VIANDE"<%= pizza.getCategPizza().toString() == "Sans Viande" ? "selected='selected'" : ""%>>Sans Viande</option>
      <option value="POISSON"<%= pizza.getCategPizza().toString() == "Poisson" ? "selected='selected'" : ""%>>Poisson</option>
    </select>
  </div>
</div>

<!-- File Button --> 
<div class="form-group">
  <label class="col-md-4 control-label" for="url_image">Url image</label>
  <div class="col-md-4">
    <input id="url_image" name="url_image" class="input-file" type="file">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Enregistrer</button>
  </div>
</div>

</fieldset>
</form>


</div>

</body>
</html>