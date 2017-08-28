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
import org.springframework.web.bind.annotation.RestController;

import com.rockers.api.model.Contract;
import com.rockers.api.model.Message;
import com.rockers.api.repository.IContractRepository;

@RestController
@RequestMapping(value="/contract")
public class ContractController {

	private static final String MESSAGE_INSERT_BLANK = null;
	private static final String MESSAGE_ERROR_DELETE = null;
	@Autowired
	IContractRepository contractRepository;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Message> saveContract(@RequestBody Contract cont){
		if (cont == null || StringUtils.isEmpty(cont.getName())){
			return new ResponseEntity<Message>(new Message(MESSAGE_INSERT_BLANK), HttpStatus.OK);
		}
		
		contractRepository.save(cont);
		String msg = cont.getName() + " saved"; 				
		return new ResponseEntity<Message>(new Message(msg), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update")
	public ResponseEntity<Message> updateContract(@RequestBody Contract cont){
		if (cont == null || StringUtils.isEmpty(cont.getName())){
			return new ResponseEntity<Message>(new Message(MESSAGE_INSERT_BLANK), HttpStatus.OK);
		}
		
		contractRepository.save(cont); 
		String msg = cont.getName() + " updated"; 				
		return new ResponseEntity<Message>( new Message(msg),HttpStatus.OK);		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/show")
	public ResponseEntity<List<Contract>> showContract(){
		List<Contract> contracts = new ArrayList<Contract>();
		contracts = contractRepository.findAll();
		return new ResponseEntity<List<Contract>>(contracts, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{idCont}")
	public ResponseEntity<Message> deleteContract(@PathVariable ("idCont") Long idCont){
		if (idCont == null || StringUtils.isEmpty(idCont)){
			return new ResponseEntity<Message>(new Message(MESSAGE_INSERT_BLANK), HttpStatus.OK);
		}
		
		try {
			contractRepository.delete(idCont);
			String msg = "Contract deleted"; 				
			return new ResponseEntity<Message>(new Message(msg), HttpStatus.OK);
		}catch(Exception e) {			
			return new ResponseEntity<Message>(new Message(MESSAGE_ERROR_DELETE), HttpStatus.OK);
		}
	}
}
