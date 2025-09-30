package com.cognizant.spring.core.beans;

public class Users {
	
  private String firstName;
  
  private String lastName;
  
  public String getFirstName() {
	  System.out.println("inside getFirst name method()");
	return firstName;
  }
  public void setFirstName(String firstName) {
	  System.out.println("inside seetFirst name method()");
	this.firstName = firstName;
  }
  public String getLastName() {
	  System.out.println("inside getLast name method()");
	return lastName;
  }
  public void setLastName(String lastName) {
	  System.out.println("inside setLasst name method()");
	this.lastName = lastName;
  }
  public Users() {
	System.out.println("No args constructor");
  }
  public Users(String firstName, String lastName) {
	System.out.println("constuctor with 2 args");
	this.firstName = firstName;
	this.lastName = lastName;
  }
  
}
