package org.example.demo;

import org.example.demo.model.RiverBurge;
import org.example.demo.model.Truck;
import org.example.demo.model.Vehicle;

public class App 
{
    public static void main( String[] args ) {
    Vehicle vehicle=new Truck();
    System.out.println(vehicle.calculateTripDistance(101, 200));
    System.out.println(vehicle.calculateFuelEfficiency(120));
    System.out.println(vehicle);
    Vehicle vehicle2=new RiverBurge();
    System.out.println(vehicle2.calculateTripDistance(90, 250));
    System.out.println(vehicle2.calculateFuelEfficiency(10));
    System.out.println(vehicle2);
            }

}