package com.cognizant.spring.core.bean;

public class Car {
 private String model;
 private double cost;
 
 
 @Override
public String toString() {
	return "Car [model=" + model + ", cost=" + cost + "]";
}
 public Car() {
	super();
	// TODO Auto-generated constructor stub
}
 public Car(String model, double cost) {
	super();
	this.model = model;
	this.cost = cost;
}
 public String getModel() {
	return model;
 }
 public void setModel(String model) {
	this.model = model;
 }
 public double getCost() {
	return cost;
 }
 public void setCost(double cost) {
	this.cost = cost;
 }
 
 
}
