import angular from 'angular';
import ngRoute from 'angular-route';
import { ExclamationFilter } from './exclamation.filter';
import userModule from './user';

angular.module('app', [ngRoute, userModule])

.filter('exclamation', ExclamationFilter)
    .value('Version', '1.0.0')

.config(function($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);
    $routeProvider
        .when('/', {
            template: '<h1>Bienvenue</h1>'
        }).when('/about', {
            template: '<h1>About</h1>'
        }).when('/tp', {
            templateUrl: 'tp.html'
        })
        .otherwise('/');



})


.run(function() {
    console.log('PizzaYOLO !');
})