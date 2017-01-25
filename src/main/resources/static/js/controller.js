var app = angular.module('ngdemo.controllers', []);

app.controller('UserListCtrl', ['$scope', 'UsersFactory', 'UserFactory', '$location','$window',
    function ($scope, UsersFactory, UserFactory, $location,$window) {

        // callback for ng-click 'editUser':
        $scope.editUser = function (userId) {
            $location.path('/user-detail/' + userId);
        };

        // callback for ng-click 'deleteUser':
        $scope.deleteUser = function (userId) {
        	UserFactory.delete({ id: userId });
        	$window.location.href='/#user-list';
        };

        // callback for ng-click 'createUser':
        $scope.createNewUser = function () {
            $location.path('/user-creation');
        };

        var findAll=function(){
        	 UsersFactory.fetchAllUsers().then(function(response) {
                 $scope.users = response;
                 console.log($scope.users);
     		}, function(errResponse) {
     			console.error('Error while fetching Users');
     		});
        }
        findAll();
       
    }]);

app.controller('UserDetailCtrl', ['$scope', '$routeParams', 'UserFactory', '$location',
    function ($scope, $routeParams, UserFactory, $location) {

        // callback for ng-click 'updateUser':
        $scope.updateUser = function () {
            UserFactory.update($scope.user);
            console.log("User to be updates"+ $scope.user.id)
            $location.path('/user-list');
        };

        // callback for ng-click 'cancel':
        $scope.cancel = function () {
            $location.path('/user-list');
        };
        console.log($routeParams.id);
        $scope.user = UserFactory.show({id: $routeParams.id});
        console.log($scope.user);
        
    }]);

app.controller('UserCreationCtrl', ['$scope','UsersFactory', '$location','$window',
    function ($scope, UsersFactory, $location,$window) {

        // callback for ng-click 'createNewUser':
        $scope.createNewUser = function () {
        	console.log("hey hey hey"+ $scope.user);
            UsersFactory.createUser($scope.user);
            $window.location.href='/#user-list';
        }
        
        // callback for ng-click 'cancel':
        $scope.cancel = function () {
        	$location.path('/user-list');
        };
    }]);
