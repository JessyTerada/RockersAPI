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

import com.rockers.api.dao.TeamDao;
import com.rockers.api.model.Team;

@RestController
@RequestMapping(value="/team")
public class TeamController {

	@Autowired
	private TeamDao dao;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> saveTeam(Team team){
		String idTeam = dao.save(team);
		return new ResponseEntity<String>(idTeam, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update/{idTeam}")
	public ResponseEntity<String> updateTeam(@PathVariable ("idTeam") String idTeam){
		Team team = dao.findOne(idTeam);
		return new ResponseEntity<String>(team.getNameTeam(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/show")
	public ResponseEntity<List<Team>> showTeam(){
		List<Team> teams = new ArrayList<Team>();
		teams = dao.listAll();
		return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{idTeam}")
	public ResponseEntity<String> deleteTeam(@PathVariable ("idTeam") String idTeam){
		dao.delete(idTeam);
		return new ResponseEntity<String>("Team has deleted sucessfully", HttpStatus.OK);
	}
}
