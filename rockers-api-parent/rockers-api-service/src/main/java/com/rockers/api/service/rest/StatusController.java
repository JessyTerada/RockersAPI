package com.rockers.api.service.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/status")
public class StatusController {

	@RequestMapping(method = RequestMethod.GET, value="/{name}/{id}")
	public ResponseEntity<String> getStatu(@PathVariable String name, @PathVariable String id){
		String msg = "Good morning " + name + " our service s " + id + " UP and Running!!!";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
