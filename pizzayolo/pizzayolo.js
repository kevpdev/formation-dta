class RecipesService{
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


isRecipeCompliant(recipe, pizza){
       if(pizza.length!==recipe.length){
           return false;
       }
           return pizza.reduce((boolValue, topping) => 
           boolValue && recipe.indexOf(topping) !== -1 && pizza.indexOf(topping)===pizza.lastIndexOf(topping), true);
   }

//verif pizza est dans la liste de recette
   getPizzaRecipeName(pizza){
       this.getRecipes()
       .then(recipes.reduce((boolValue, recipe) => boolValue || this.isRecipeCompliant(recipe, pizza) ? recipe.name : false), false);
    
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



}



class Pizzeria{

    constructor(recipesService){
        this.pool=[];
        this.recipesService = recipesService;
    }

//every n sec add a new recipe name to the pool
    start(time){
     this.recipesService.getRecipesNames().then(names => {
const setinverlId = setInterval(()=>{
           const index = Math.floor(Math.random()*names.length) 
           this.pool.push(names[index]) ;  
         console.log('pool : ', this.pool)
         if(this.pool.length > 5){
             console.log("STOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOP !!!!!!!!")
 clearTimeout(setinverlId)
         }
          
        },time);
      
     })
       

    }

      // { id: 1, toppings: ['', ''] }
    sendPizza (pizzaName) {
        const idx = this.pool.indexOf(pizzaName);
        if (idx !== -1) this.pool.splice(idx, 1);
    }
}