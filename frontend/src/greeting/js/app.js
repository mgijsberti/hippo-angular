var greetingApp = angular.module("greetingApp", [ 'ngRoute','hippoModule']);

greetingApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/greeting', {templateUrl: '/app/greeting/templates/greeting.html', controller: 'GreetingController'});
    $routeProvider.when('/alert', {templateUrl: '/app/greeting/templates/alert.html', controller: 'AlertController'});
    $routeProvider.otherwise({redirectTo: '/greeting'});
}]);

greetingApp.controller("GreetingController", ['$scope', '$http','$location', 'hippoDocument', function($scope, $http, $location, hippoDocument) {
        $scope.myForm = {};
        $scope.myForm.name = {};
        $scope.myForm.greeting = {};
        console.log('description : ' + hippoDocument.description);
        console.log('url : ' + hippoDocument.url);

        $scope.myForm.submitTheForm = function(item, event) {
            var dataObject = {
                name : $scope.myForm.name
            };
            console.log("--> Submitting form for " + dataObject.name);
            var responsePromise = $http({
                url: hippoDocument.url,
                method: "GET",
                params: {name: dataObject.name}
            });

            responsePromise.success(function(dataFromServer, status, headers, config) {
                console.log(dataFromServer.message);
                $location.path("/alert").search('name',dataFromServer.message)
                //$scope.myForm.greeting = dataFromServer.message;
            });

            responsePromise.error(function(data, status, headers, config) {
                alert("Submitting form failed!");
            });
        }

}]);

greetingApp.controller("AlertController", ['$scope','$routeParams',function($scope, $routeParams){
    $scope.greeting = $routeParams.name;
}]);