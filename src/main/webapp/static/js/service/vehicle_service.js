'use strict';

angular.module('myApp').factory('VehicleService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/vehiclemvc/vehicle/';
    //var REST_SERVICE_URI = '<a class="vglnk" href="http://localhost:8080/vehiclemvc/vehicle/" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>Spring4MVCAngularJSExample</span><span>/</span><span>user</span><span>/</span></a>';
    
    
    var factory = {
        AllVehicles: AllVehicles,
        createVehicle: createVehicle,
        updateVehicle:updateVehicle,
        deleteVehicle:deleteVehicle
    };

    return factory;

    function AllVehicles() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error All Vehicles');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createVehicle(vehicle) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + "save", vehicle)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error - Create Vehicle');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateVehicle(vehicle, id) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + "update", vehicle)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error - Update Vehicle');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteVehicle(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error - Delete Vehicle');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
