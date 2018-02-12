package com.ito.vehiclemvc.model;

public class VehicleEntity {
	
	private long id;
	private String typeVehicle, brand, model;
	
	public VehicleEntity(long id, String typeVehicle, String brand, String model) {
		this.id = id;
		this.typeVehicle = typeVehicle;
		this.brand = brand;
		this.model = model;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
}
