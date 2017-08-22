package com.rockers.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rockers.api.model.Team;

@Component
public class TeamDao implements Crud<Team> {

	@Override
	public Team findOne(String id) {
		Team team = new Team();
		team.setIdTeam(id);
		team.setNameTeam("ESS");
		team.setEmployees(null);
		return team;
	}

	@Override
	public String save(Team t) {
		t.setIdTeam("78");
		return t.getIdTeam();
	}

	@Override
	public List<Team> listAll() {
		List<Team> teams = new ArrayList<Team>();
		
		Team team1 = new Team();
		team1.setIdTeam("96");
		team1.setNameTeam("kekeke");
		team1.setEmployees(null);
		teams.add(team1);
		
		Team team2 = new Team();
		team2.setIdTeam("12");
		team2.setNameTeam("llflf");
		team2.setEmployees(null);
		teams.add(team2);
		
		return teams;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}
