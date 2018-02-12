<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>REST-MVC Test - ITO</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }

    </style>
     <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="container" ng-controller="VehicleController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Vehicle - Create Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.vehicle.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Type of Vehicle</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.vehicle.typeVehicle" name="typeVehicle" class="typeVehicle form-control input-sm" placeholder="Enter the type of vehicle" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Brand</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.vehicle.brand" class="form-control input-sm" placeholder="Enter the brand"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Model</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.vehicle.model" name="model" class="email form-control input-sm" placeholder="Enter model" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.model.$error.required">This is a required field</span>
                                      <span ng-show="myForm.model.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.vehicle.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Vehicles </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Type of Vehicle</th>
                              <th>Brand</th>
                              <th>Model</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="v in ctrl.vehicles">
                              <td><span ng-bind="v.id"></span></td>
                              <td><span ng-bind="v.typeVehicle"></span></td>
                              <td><span ng-bind="v.brand"></span></td>
                              <td><span ng-bind="v.model"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(v.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(v.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/jquery.min.js' />"></script>
      <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
      <script src="<c:url value='/static/js/service/vehicle_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/vehicle_controller.js' />"></script>
  </body>
</html>