package com.ito.vehiclemvc.service;

import java.util.List;

import com.ito.vehiclemvc.model.VehicleEntity;

public interface IRestService {
	
	VehicleEntity findById(long id);
	VehicleEntity findByModel(String model);
	void save(VehicleEntity vehicle);
	void update(VehicleEntity vehicle);
	void deleteVehicleById(long id);
	List<VehicleEntity> listAll();
	public boolean isVehicleExist(VehicleEntity vehicle);
}
