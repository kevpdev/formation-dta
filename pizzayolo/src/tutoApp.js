import { RecipesService } from './services/recipes.service';
import { PizzeriaService } from './services/pizzeria.service';

const recipesService = new RecipesService();
const pizzeriaService = new PizzeriaService(recipesService,  $('#pool .pizzas'));

// liste des recettes
recipesService.getRecipes()
.then(recipes => {
    
    $('#recipes')
        .html(recipes.map(recipe => `
        <li>
            ${ recipe.name.toUpperCase() }
            ( ${ recipe.toppings.join(', ') } )
        </li>
        `));

});


recipesService.getToppings()
.then(toppings => {
    $('#toppings')
        .html(toppings.map(topping => `
        <button draggable="true" data-topping="${ topping }" class="btn">${ topping }</button>
        `));
    $('#toppings button').click(function () {
       addTopping($(this).data('topping'));
    });
    $('#toppings button').on('dragstart', function (event) {
         event.dataTransfer.setData("text/plain", $(this).data('topping'));
    });
});

let currentPizza;

$('#startbtn').click(function () {
    pizzeriaService.start(1000);
    $(this).hide();
    $('#pool').show();
    currentPizza = { toppings: [] };
});

function addTopping(topping) {
    currentPizza.toppings.push(topping);
    $('#pizza').html(currentPizza.toppings.join('<br>'));
}

$('#sendPizza').click(function () {
    recipesService.getPizzaRecipeName(currentPizza)
    .then(recipeName => {
        currentPizza = { toppings: [] };
        $('#pizza').html('');
        if (recipeName) pizzeriaService.sendPizza(recipeName);
    });
});

$("#pizza").on("dragover", function(event) {
    event.preventDefault();  
    event.stopPropagation();
});

$("#pizza").on("dragleave", function(event) {
    event.preventDefault();  
    event.stopPropagation();
});

$("#pizza").on("drop", function(event) {
    console.log('ici', event.dataTransfer.getData("text"));
    event.preventDefault();  
    event.stopPropagation();
});