package com.ito.vehiclemvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.ito.vehiclemvc.model.VehicleEntity;

@Service("vehicleService")
public class VehicleServiceImpl implements IRestService {

	private static final AtomicLong count = new AtomicLong();
	private static List<VehicleEntity> vehicles;
	static {
		vehicles = addingDefaultSetOfVehicles();
	}
	
	@Override
	public VehicleEntity findById(long id) {
		for(VehicleEntity vehicle : vehicles) {
			if(vehicle.getId() == id) {
				return vehicle;
			}
		}
		return null;
	}

	@Override
	public VehicleEntity findByModel(String model) {
		for(VehicleEntity vehicle : vehicles) {
			if(vehicle.getModel().equalsIgnoreCase(model)) {
				return vehicle;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(VehicleEntity vehicle) {
		// TODO Auto-generated method stub
		vehicle.setId(count.incrementAndGet());
		vehicles.add(vehicle);
	}

	@Override
	public void update(VehicleEntity vehicle) {
		// TODO Auto-generated method stub
		System.out.println("Get ID: + "+ vehicle.getId());
		int idVehicle = (int) (vehicle.getId()-1);
		vehicles.set(idVehicle, vehicle);
	}

	@Override
	public void deleteVehicleById(long id) {
		// TODO Auto-generated method stub
		for(Iterator<VehicleEntity> iterator = vehicles.iterator(); iterator.hasNext();) {
			VehicleEntity vehicle = iterator.next();
			if(vehicle.getId() == id) {
				iterator.remove();
			}
		}
	}

	@Override
	public List<VehicleEntity> listAll() {
		// TODO Auto-generated method stub
		return vehicles;
	}

	@Override
	public boolean isVehicleExist(VehicleEntity vehicle) {
		// TODO Auto-generated method stub
		return findByModel(vehicle.getModel()) != null;
	}
	
	private static List<VehicleEntity> addingDefaultSetOfVehicles(){
		List<VehicleEntity> vehicles = new ArrayList<VehicleEntity>();
		vehicles.add(new VehicleEntity(count.incrementAndGet(), "Car", "Nissan", "Verssa"));
		vehicles.add(new VehicleEntity(count.incrementAndGet(), "Truck", "Caterpillar", "C175"));
		return vehicles;
	}

}
