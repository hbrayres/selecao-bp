'use strict';

angular.module('juros-front',['ngRoute','ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'partials/landing',controller:'LandingPageController'})
      .when('/LimiteCreditos',{templateUrl:'partials/limite-credito-search',controller:'SearchLimiteCreditoController'})
      .when('/LimiteCreditos/new',{templateUrl:'partials/limite-credito-detail',controller:'NewLimiteCreditoController'})
      .when('/LimiteCreditos/edit/:LimiteCreditoId',{templateUrl:'partials/limite-credito-detail',controller:'EditLimiteCreditoController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('LandingPageController', function LandingPageController() {
  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
