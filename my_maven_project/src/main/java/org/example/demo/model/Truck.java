package org.example.demo.model;

public class Truck extends Vehicle{

	private double distanceCovered;
	private double fuelConsumed;
	private double fuelEfficiency;

	@Override
	public double calculateFuelEfficiency(double fuelConsumed) {
		// TODO Auto-generated method stub
		this.fuelConsumed=fuelConsumed;
		this.fuelEfficiency=this.fuelConsumed/this.distanceCovered;
		return this.fuelEfficiency;
	}

	@Override
	public double calculateTripDistance(double start, double end) {
		// TODO Auto-generated method stub
		distanceCovered=end-start;
		return distanceCovered;
	}
	@Override
	public String toString()
	{
		return "The Truck Has Covered: "+distanceCovered+" Miles And The Fuel Efficiency is: "+fuelEfficiency;
	}


}
