import _ from 'lodash';

export class RecipesService{
constructor(){
    this.recipes = null;
}

// retourne depuis serveur une promesse recette
//gerer la mise en cache pour limiter le nombre de requete
 getRecipes(){
     if(!this.recipes){
     return fetch('http://localhost:3000/recipes')
        .then(response => response.json())
        .then(recipes => this.recipes = recipes)
     }else{
        return Promise.resolve(this.recipes);
     }
      
    }


// isRecipeCompliant(recipe, pizza){
//        if(pizza.length!==recipe.length){
//            return false;
//        }
//            return pizza.reduce((boolValue, topping) => 
//            boolValue && recipe.indexOf(topping) !== -1 && pizza.indexOf(topping)===pizza.lastIndexOf(topping), true);
//    }

//verif pizza est dans la liste de recette
//    getPizzaRecipeName(pizza){
//        this.getRecipes()
//        .then(recipes.reduce((boolValue, recipe) => boolValue || this.isRecipeCompliant(recipe, pizza) ? recipe.name : false), false);
    
// }
  isRecipeCompliant(recipe, pizza) {
        if (recipe.toppings.length !== pizza.toppings.length) return false;

        return pizza.toppings.reduce((acc, topping) =>
            acc 
            && recipe.toppings.indexOf(topping) !== -1 
            && pizza.toppings.indexOf(topping) === pizza.toppings.lastIndexOf(topping)
            , true);
    }

getPizzaRecipeName (pizza) {
        return this.getRecipes()
        .then(recipes => {
            return recipes.reduce(
                (acc, recipe) => 
                acc 
                || (this.isRecipeCompliant(recipe, pizza) ? recipe.name : false), 
            false);
        })
    }

    //recup une recette et retourne une promesse
getRecipe(name){
  //  return this.recipes.find(recipe => recipe.name === name)
  return this.getRecipes()
  .then(recipes => recipes.find(recipe => recipe.name === name))
  .catch(this.handleError);
    
}
    //recup un tableau de nom recettes, retourne une promesse 
getRecipesNames(){
    
    return this.getRecipes()
    .then(recipes => recipes.map(recipe => recipe.name))
      .catch(this.handleError);
}
//recupe les recettes dont le nom contient query ex : 'ma' => margharita, retourne une promesse
queryRecipes(query){

    return this.getRecipes().
    then(recipes => recipes.filter(recipe => recipe.name.includes(query)))
      .catch(this.handleError);


}

getToppings() {
        return this.getRecipes()
        .then(recipes => 
            _(recipes.map(recipe => recipe.toppings))
                .flatten()
                .uniq()
                .value()
        )
        .catch(this.handleError)
        
    }





}