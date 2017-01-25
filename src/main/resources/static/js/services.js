var services = angular.module('ngdemo.services', ['ngResource']);

services.factory('UsersFactory', ['$http', '$q',function ($http, $q) {

	var REST_SERVICE_URI = 'http://localhost:8080/users';

	var factory = {
		fetchAllUsers : fetchAllUsers,
		createUser : createUser
	};

	return factory;

	function fetchAllUsers() {
			var deferred = $q.defer();
		$http.get(REST_SERVICE_URI).then(function(response) {
			deferred.resolve(response.data);
		}, function(errResponse) {
			console.error('Error while fetching users');
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}

	function createUser(user) {
		console.log("hola hoala hola"+user.firstName);
		var deferred = $q.defer();
		$http.post(REST_SERVICE_URI, user).then(function(response) {
			deferred.resolve(response.data);
		}, function(errResponse) {
			console.error('Error while creating User');
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}}]);

services.factory('UserFactory', function ($resource) {
	
    return $resource('/users/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'}},
        delete: { method: 'DELETE'}
    })
});