package com.rockers.api.service.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rockers.api.dao.ContractDao;
import com.rockers.api.model.Contract;
import com.rockers.api.repository.IContractRepository;

@RestController
@RequestMapping(value="/contract")
public class ContractController {

	@Autowired
	IContractRepository contractRepository;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Long> saveContract(Contract cont){
		contractRepository.save(cont);
		return new ResponseEntity<Long>(cont.getId().longValue(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update/{idCont}")
	public ResponseEntity<String> updateContract(@PathVariable ("idCont") Long idCont){
		Contract cont = contractRepository.findOne(idCont); 
		return new ResponseEntity<String>(cont.getName(), HttpStatus.OK);		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/show")
	public ResponseEntity<List<Contract>> showContract(){
		List<Contract> contracts = new ArrayList<Contract>();
		contracts = contractRepository.findAll();
		return new ResponseEntity<List<Contract>>(contracts, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{idCont}")
	public ResponseEntity<String> deleteContract(@PathVariable ("idCont") Long idCont){
		contractRepository.delete(idCont);
		return new ResponseEntity<String>("Contract has deleted successfully", HttpStatus.OK);
		
	}
}
