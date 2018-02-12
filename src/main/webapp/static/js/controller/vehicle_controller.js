'use strict';

angular.module('myApp').controller('VehicleController', ['$scope', 'VehicleService', function($scope, VehicleService) {
    var self = this;
    self.vehicle={id:null, typeVehicle:'', brand:'', model:''};
    self.vehicles=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    AllVehicles();

    function AllVehicles(){
        VehicleService.AllVehicles()
            .then(
            function(d) {
                self.vehicles = d;
            },
            function(errResponse){
                console.error('Error - All Vehicle');
            }
        );
    }

    function createVehicle(vehicle){
        VehicleService.createVehicle(vehicle)
            .then(
            AllVehicles,
            function(errResponse){
                console.error('Error - Create Vehicle');
            }
        );
    }

    function updateVehicle(vehicle, id){
        VehicleService.updateVehicle(vehicle, id)
            .then(AllVehicles,
            function(errResponse){
                console.error('Error - Update Vehicle');
            }
        );
    }

    function deleteVehicle(id){
        VehicleService.deleteVehicle(id)
            .then(
            AllVehicles,
            function(errResponse){
                console.error('Error - Delete Vehicle');
            }
        );
    }

    function submit() {
        if(self.vehicle.id===null){
            console.log('Creating vehicle', self.vehicle);
            createVehicle(self.vehicle);
        }else{
            updateVehicle(self.vehicle, self.vehicle.id);
            console.log('Updating vehicle with id ', self.vehicle.id);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.vehicles.length; i++){
            if(self.vehicles[i].id === id) {
                self.vehicle = angular.copy(self.vehicles[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.vehicle.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteVehicle(id);
    }


    function reset(){
        self.vehicle={id:null,typeVehicle:'',brand:'',model:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
