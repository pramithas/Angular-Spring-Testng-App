angular.module('ngdemo', ['ngdemo.services','ngdemo.controllers', 'ngRoute', 'ngResource']).config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'partials/user-list.html',
		controller : 'UserListCtrl'
	});
	$routeProvider.when('/user-detail/:id', {
		templateUrl : 'partials/edit-user.html',
		controller : 'UserDetailCtrl'
	});
	$routeProvider.when('/user-creation', {
		templateUrl : 'partials/add-user.html',
		controller : 'UserCreationCtrl'
	});
	$routeProvider.otherwise({
		redirectTo : '/user-list'
	});
});