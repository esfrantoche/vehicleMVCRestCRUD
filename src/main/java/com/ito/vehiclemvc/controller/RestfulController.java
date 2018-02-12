package com.ito.vehiclemvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.ito.vehiclemvc.model.Response;
import com.ito.vehiclemvc.model.VehicleEntity;
import com.ito.vehiclemvc.service.IRestService;

@RestController
public class RestfulController {

	@Autowired
	IRestService vehicleService;
	
	//-------------------------------- List of vehicles -----------------
	@RequestMapping(value = "/vehicle/", method = RequestMethod.GET)
	public ResponseEntity<List<VehicleEntity>> getAll(){
		
		List<VehicleEntity> vehicles = vehicleService.listAll();
		
		if(vehicles.isEmpty()) {
			return new ResponseEntity<List<VehicleEntity>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<VehicleEntity>>(vehicles, HttpStatus.OK);
	}
	
	//--------------------------- Getting a vehicle by Id ---------------
	@RequestMapping(value = "/vehicle/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehicleEntity> getById(@PathVariable("id") long id){
		VehicleEntity vehicle = vehicleService.findById(id);
		if(vehicle == null) {
			return new ResponseEntity<VehicleEntity>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<VehicleEntity>(vehicle, HttpStatus.OK);
	}
	
	//---------------------------- Create new vehicle -----------------
	@PostMapping(value="vehicle/save")
	public Response create(@RequestBody String payload)
	{
		Gson gson = new Gson();
		
		VehicleEntity vehicle = gson.fromJson(payload, VehicleEntity.class);
		vehicleService.save(vehicle);
		
		return new Response("Success","The vehicle was saved without problems");
	}
	
	@PostMapping(value="vehicle/update")
	public Response update(@RequestBody String payload)
	{
		Gson gson = new Gson();
		
		System.out.println("Test");
		VehicleEntity vehicle = gson.fromJson(payload, VehicleEntity.class);
		System.out.println(vehicle.getId());
		vehicleService.update(vehicle);
	
	return new Response("Success","The vehicle was saved successfully.");
	}
	/*@RequestMapping(value = "/vehicle/", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody VehicleEntity vehicle, UriComponentsBuilder ucBuilder){
		if(vehicleService.isVehicleExist(vehicle)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		vehicleService.save(vehicle);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/vehicle/{id}").buildAndExpand(vehicle.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//------------------------- Update --------------------------------
	@RequestMapping(value = "/vehicle/{id}", method = RequestMethod.PUT)
    public ResponseEntity<VehicleEntity> update(@PathVariable("id") long id, @RequestBody VehicleEntity vehicle) {

    	VehicleEntity currVehicle = vehicleService.findById(id);
    	
        if (currVehicle==null) {
        	System.out.println("Vehicle with id " + id + " not found");
            return new ResponseEntity<VehicleEntity>(HttpStatus.NOT_FOUND);
        }
        currVehicle.setTypeVehicle(vehicle.getTypeVehicle());
        currVehicle.setBrand(vehicle.getBrand());
        currVehicle.setModel(vehicle.getModel());
          
        vehicleService.update(currVehicle);
        return new ResponseEntity<VehicleEntity>(currVehicle, HttpStatus.OK);
    }*/
    
    //------------------- Delete --------------------------------
    @RequestMapping(value = "/vehicle/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<VehicleEntity> delete(@PathVariable("id") long id) {
  
        VehicleEntity vehicle = vehicleService.findById(id);
        if (vehicle == null) {
            return new ResponseEntity<VehicleEntity>(HttpStatus.NOT_FOUND);
        }
        vehicleService.deleteVehicleById(id);
        return new ResponseEntity<VehicleEntity>(HttpStatus.NO_CONTENT);
    }
}
