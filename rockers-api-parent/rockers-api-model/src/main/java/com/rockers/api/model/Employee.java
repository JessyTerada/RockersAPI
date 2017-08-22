package com.rockers.api.model;

import lombok.Data;

@Data
public class Employee {

	private String name;
	private String wiproId;
	private int clientId;
	private String email;
	
	//private Set<Employee> employees = new HashSet<Employee>(); 
	
	public void registerMe() {
		//TODO: implement
	}
	
	/*private Register register;
	public Set<Employee> listCollegues(){
		return register.getEmployees();
	}*/	
}
