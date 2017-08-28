package com.rockers.api.service.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rockers.api.model.Message;
import com.rockers.api.model.User;
import com.rockers.api.repository.IEmployeeRepository;
import com.rockers.api.repository.IUserRepository;

@RestController
@RequestMapping(value="/user")
public class UserController {

	private static final String MESSAGE_INSERT_BLANK = null;
	private static final String MESSAGE_ERROR_DELETE = null;
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	IEmployeeRepository employeeRespository;
	
	@RequestMapping(method=RequestMethod.GET, value="/login")
	public ResponseEntity<String> loginUser(@RequestParam String login, @RequestParam String senha ){
		User user = userRepository.findByLoginAndPassword(login, senha);
		return new ResponseEntity<String>(user==null ? "User not found" : user.getLogin(), HttpStatus.OK);		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Message> saveUser(@RequestBody User user){
		if (user == null || StringUtils.isEmpty(user.getLogin())){
			return new ResponseEntity<Message>(new Message(MESSAGE_INSERT_BLANK), HttpStatus.OK);
		}
		
		if (user.getEmployee() != null) {
			user.setEmployee(
				employeeRespository.findOne(user.getEmployee().getId())
			);			
		}
		
		userRepository.save(user);
		String msg = user.getLogin() + " saved"; 	
		return new ResponseEntity<Message>(new Message(msg), HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/update")
	public ResponseEntity<Message> updateUser(@RequestBody User user){
		if (user == null || StringUtils.isEmpty(user.getLogin())){
			return new ResponseEntity<Message>(new Message(MESSAGE_INSERT_BLANK), HttpStatus.OK);
		}
		
		userRepository.saveAndFlush(user);
		String msg = user.getLogin() + " saved"; 	
		return new ResponseEntity<Message>(new Message(msg), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/show")
	public ResponseEntity<List<User>> showUser(){
		List<User> usuarios = new ArrayList<User>();
		usuarios = userRepository.findAll();		
		return new ResponseEntity<List<User>>(usuarios, HttpStatus.OK);		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public ResponseEntity<Message> deleteUser(@PathVariable("id") Long id){
		if (id == null || StringUtils.isEmpty(id)){
			return new ResponseEntity<Message>(new Message(MESSAGE_INSERT_BLANK), HttpStatus.OK);
		}
		
		try {
			userRepository.delete(id);
			String msg = "User saved"; 	
			return new ResponseEntity<Message>(new Message(msg), HttpStatus.OK);
		}catch(Exception e) {			
			return new ResponseEntity<Message>(new Message(MESSAGE_ERROR_DELETE), HttpStatus.OK);
		}
	}
}
