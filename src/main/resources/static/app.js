'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ui.router',
    'ui.grid',
    'ui.grid.pagination',
    'gridModule'
]).
config(function($stateProvider, $urlRouterProvider) {
      $urlRouterProvider.otherwise('grid');
      $stateProvider.state('grid',{
          url:'/grid',
          templateUrl:'view/grid/grid.html',
          controller:'gridCtrl'
      })
});
