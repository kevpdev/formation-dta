import { RecipesService} from './services/recipes.service';
import { PizzeriaService} from './services/pizzeria.service';

console.log('hello word');

  const recipesService = new RecipesService();
const pizzeriaService = new PizzeriaService(recipesService, $('#pool .pizzas'));
//     recipesService.getRecipesNames().then(names=>{
//     console.log('names', names);})

// setTimeout(() => {

//     recipesService.getRecipe('recette 1').then(recipe=>{
//     console.log('recipe', recipe);})

//     recipesService.queryRecipes('1').then(recipes=>{
//     console.log('recipes', recipes);})

//    const pizzeriaService = new PizzeriaService(recipesService);
//     pizzeriaService.start(1000);
//     pizzeriaService.sendPizza('Margharita');
    
// }, 1000)


recipesService.getRecipesNames()
.then(recipes => {
    
    $('#recipes').append(recipes.map(recipe => 
            `<li class="list-group-item">${ recipe }</li>`));

})





recipesService.getToppings()
.then(toppings => {
    $('#toppings')
        .html(toppings.map(topping => `
        <button data-topping="${ topping }" class="btn btn-primary">${ topping }</button>
        `));
    $('#toppings button').click(function () {
       addTopping($(this).data('topping'));
    });
});

let currentPizza;

$('#start').click(function () {
      alert("go !!");
    pizzeriaService.start(1000);
    $(this).hide();
    $('#pool').show();
    currentPizza = {
        toppings: []
    };
});

function addTopping(topping){
currentPizza.toppings.push(topping);
 $('#pizza').html(currentPizza.toppings.join('<br>'));
console.log('currentPizza : '+currentPizza);

}

$('#sendPizza').click(function () {
    recipesService.getPizzaRecipeName(currentPizza)
    .then(recipeName => {
        currentPizza = { toppings: [] };
        $('#pizza').html('');
        if (recipeName) pizzeriaService.sendPizza(recipeName);
    });
});






