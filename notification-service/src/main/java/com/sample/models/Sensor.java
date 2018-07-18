package com.sample.models;

public class Sensor {
	
private String id;
	
	private float temperature;

	private float acceleration;
	
	private float velocity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(float acceleration) {
		this.acceleration = acceleration;
	}

	public float getVelocity() {
		return velocity;
	}

	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}
}
