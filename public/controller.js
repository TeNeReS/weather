var app = angular.module('Weather', []);
app.controller('mainController', function($scope, $http) {

    $scope.getWeatherByName = function () {
        $http.get('weather/location', {params: {name: $scope.name}}).
            then(function (success){
                $scope.greeting = success.data;
                $scope.name = "";
            },function (error){

        });
    };

    $scope.getWeatherByCoordinates = function () {
        $http.get('weather/coordinates', {params: {lon: $scope.lon, lat: $scope.lat}}).
        then(function (success){
            $scope.greeting = success.data;
            $scope.lon = "";
            $scope.lat = "";
        },function (error){

        });
    };
});