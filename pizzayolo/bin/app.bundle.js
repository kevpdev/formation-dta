/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	var _recipes = __webpack_require__(1);

	var _pizzeria = __webpack_require__(2);

	console.log('hello word');

	var recipesService = new _recipes.RecipesService();

	recipesService.getRecipesNames().then(function (names) {
	    console.log('names', names);
	});

	setTimeout(function () {

	    recipesService.getRecipe('recette 1').then(function (recipe) {
	        console.log('recipe', recipe);
	    });

	    recipesService.queryRecipes('1').then(function (recipes) {
	        console.log('recipes', recipes);
	    });

	    var pizzeria = new Pizzeria(recipesService);
	    pizzeria.start(1000);
	    pizzeria.sendPizza('Margharita');
	}, 1000);

/***/ },
/* 1 */
/***/ function(module, exports) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	var RecipesService = exports.RecipesService = function () {
	    function RecipesService() {
	        _classCallCheck(this, RecipesService);

	        this.recipes = null;
	    }

	    // retourne depuis serveur une promesse recette
	    //gerer la mise en cache pour limiter le nombre de requete


	    _createClass(RecipesService, [{
	        key: 'getRecipes',
	        value: function getRecipes() {
	            var _this = this;

	            if (!this.recipes) {
	                return fetch('http://localhost:3000/recipes').then(function (response) {
	                    return response.json();
	                }).then(function (recipes) {
	                    return _this.recipes = recipes;
	                });
	            } else {
	                return Promise.resolve(this.recipes);
	            }
	        }
	    }, {
	        key: 'isRecipeCompliant',
	        value: function isRecipeCompliant(recipe, pizza) {
	            if (pizza.length !== recipe.length) {
	                return false;
	            }
	            return pizza.reduce(function (boolValue, topping) {
	                return boolValue && recipe.indexOf(topping) !== -1 && pizza.indexOf(topping) === pizza.lastIndexOf(topping);
	            }, true);
	        }

	        //verif pizza est dans la liste de recette

	    }, {
	        key: 'getPizzaRecipeName',
	        value: function getPizzaRecipeName(pizza) {
	            var _this2 = this;

	            this.getRecipes().then(recipes.reduce(function (boolValue, recipe) {
	                return boolValue || _this2.isRecipeCompliant(recipe, pizza) ? recipe.name : false;
	            }), false);
	        }

	        //recup une recette et retourne une promesse

	    }, {
	        key: 'getRecipe',
	        value: function getRecipe(name) {
	            //  return this.recipes.find(recipe => recipe.name === name)
	            return this.getRecipes().then(function (recipes) {
	                return recipes.find(function (recipe) {
	                    return recipe.name === name;
	                });
	            }).catch(this.handleError);
	        }
	        //recup un tableau de nom recettes, retourne une promesse 

	    }, {
	        key: 'getRecipesNames',
	        value: function getRecipesNames() {

	            return this.getRecipes().then(function (recipes) {
	                return recipes.map(function (recipe) {
	                    return recipe.name;
	                });
	            }).catch(this.handleError);
	        }
	        //recupe les recettes dont le nom contient query ex : 'ma' => margharita, retourne une promesse

	    }, {
	        key: 'queryRecipes',
	        value: function queryRecipes(query) {

	            return this.getRecipes().then(function (recipes) {
	                return recipes.filter(function (recipe) {
	                    return recipe.name.includes(query);
	                });
	            }).catch(this.handleError);
	        }
	    }]);

	    return RecipesService;
	}();

/***/ },
/* 2 */
/***/ function(module, exports) {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	var Pizzeria = exports.Pizzeria = function () {
	    function Pizzeria(recipesService) {
	        _classCallCheck(this, Pizzeria);

	        this.pool = [];
	        this.recipesService = recipesService;
	    }

	    //every n sec add a new recipe name to the pool


	    _createClass(Pizzeria, [{
	        key: "start",
	        value: function start(time) {
	            var _this = this;

	            this.recipesService.getRecipesNames().then(function (names) {
	                var setinverlId = setInterval(function () {
	                    var index = Math.floor(Math.random() * names.length);
	                    _this.pool.push(names[index]);
	                    console.log('pool : ', _this.pool);
	                    if (_this.pool.length > 5) {
	                        console.log("STOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOP !!!!!!!!");
	                        clearTimeout(setinverlId);
	                    }
	                }, time);
	            });
	        }

	        // { id: 1, toppings: ['', ''] }

	    }, {
	        key: "sendPizza",
	        value: function sendPizza(pizzaName) {
	            var idx = this.pool.indexOf(pizzaName);
	            if (idx !== -1) this.pool.splice(idx, 1);
	        }
	    }]);

	    return Pizzeria;
	}();

/***/ }
/******/ ]);