package com.rockers.api.dao;

import java.util.ArrayList;
import java.util.List;
import com.rockers.api.model.Employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDao implements Crud<Employee>{

	@Override
	public Employee findOne(String id) {
		Employee emp = new Employee();
		emp.setWiproId("12365");
		emp.setName("Jessica");
		emp.setEmail("jessica.tereda@wipro.com");
		emp.setClientId(895);
		return emp;
	}

	@Override
	public String save(Employee t) {
		t.setWiproId("385653");
		return t.getWiproId();
	}

	@Override
	public List<Employee> listAll() {
		List<Employee> employees = new ArrayList<Employee>();
		
		Employee emp1 = new Employee();
		emp1.setWiproId("659854");
		emp1.setName("Jorge");
		emp1.setEmail("fsfsdf");
		emp1.setClientId(423424);
		employees.add(emp1);

		Employee emp2 = new Employee();
		emp2.setWiproId("548754");
		emp2.setName("Lucas");
		emp2.setEmail("fsfsdf");
		emp2.setClientId(884);
		employees.add(emp2);	
		
		return employees;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}	
}
