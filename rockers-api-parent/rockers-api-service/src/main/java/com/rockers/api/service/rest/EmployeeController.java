package com.rockers.api.service.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rockers.api.dao.EmployeeDao;
import com.rockers.api.model.Employee;
import com.rockers.api.repository.IEmployeeRepository;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	IEmployeeRepository employeeRepository;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Long> saveEmployee(@RequestBody Employee emp){
		employeeRepository.save(emp);
		return new ResponseEntity<Long>(emp.getId().longValue(), HttpStatus.OK);		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update/{idWipro}")
	public ResponseEntity<String> updateEmployee(@PathVariable ("idWipro") Long idWipro){
		Employee emp = employeeRepository.findOne(idWipro);
		return new ResponseEntity<String>(emp.getName(), HttpStatus.OK);		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/show")
	public ResponseEntity<List<Employee>> showEmployee(){
		List<Employee> employees = new ArrayList<Employee>();
		employees = employeeRepository.findAll();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value="/delete/{idWipro}")
	public ResponseEntity<String> deleteEmployee(@PathVariable ("idWipro") Long idWipro){
		employeeRepository.delete(idWipro);
		return new ResponseEntity<String>("Employee has deleted successfully", HttpStatus.OK);
		
	}
}