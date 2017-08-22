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

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	private EmployeeDao dao;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp){
		String idWipro = dao.save(emp);
		return new ResponseEntity<String>(idWipro, HttpStatus.OK);		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update/{idWipro}")
	public ResponseEntity<String> updateEmployee(@PathVariable ("idWipro") String idWipro){
		Employee emp = dao.findOne(idWipro);
		return new ResponseEntity<String>(emp.getName(), HttpStatus.OK);		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/show")
	public ResponseEntity<List<Employee>> showEmployee(){
		List<Employee> employees = new ArrayList<Employee>();
		employees = dao.listAll();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value="/delete/{idWipro}")
	public ResponseEntity<String> deleteEmployee(@PathVariable ("idWipro") String idWipro){
		dao.delete(idWipro);
		return new ResponseEntity<String>("Employee has deleted successfully", HttpStatus.OK);
		
	}
}