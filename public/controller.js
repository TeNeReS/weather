var app = angular.module('Weather', []);
app.controller('mainController', function($scope, $http, $timeout) {

    $scope.getWeatherByName = function () {
        $http.get('weather/location', {params: {name: $scope.name}}).
            then(function (success){
                $scope.success = true;
                $timeout(function() {
                    $scope.success = false;
                }, 3000);
                $scope.location = success.data;
                $scope.name = "";
            },function (error){
                $scope.message = error.data.detail;
                $scope.danger = true;
                $timeout(function() {
                    $scope.danger = false;
                }, 3000);
            });
    };

    $scope.getWeatherByCoordinates = function () {
        $http.get('weather/coordinates', {params: {lon: $scope.lon, lat: $scope.lat}}).
            then(function (success){
                $scope.success = true;
                $timeout(function() {
                    $scope.success = false;
                }, 3000);
                $scope.location = success.data;
                $scope.lon = "";
                $scope.lat = "";
            },function (error){
                $scope.message = error.data.detail;
                $scope.danger = true;
                $timeout(function() {
                    $scope.danger = false;
                }, 3000);
            });
    };
});

var COORDINATE_REGEXP = /^-?\d+[.,]?\d*$/;

app.directive('longitude', function() {
    return {
        require: 'ngModel',
        link: function(scope, elm, attrs, ctrl) {
            ctrl.$validators.longitude = function(modelValue, viewValue) {
                if (ctrl.$isEmpty(modelValue)) {
                    return true;
                }
                return COORDINATE_REGEXP.test(viewValue) && viewValue >= -180 && viewValue <= 180;
            };
        }
    };
});

app.directive('latitude', function() {
    return {
        require: 'ngModel',
        link: function(scope, elm, attrs, ctrl) {
            ctrl.$validators.latitude = function(modelValue, viewValue) {
                if (ctrl.$isEmpty(modelValue)) {
                    return true;
                }
                return COORDINATE_REGEXP.test(viewValue) && viewValue >= -90 && viewValue <= 90;
            };
        }
    };
});