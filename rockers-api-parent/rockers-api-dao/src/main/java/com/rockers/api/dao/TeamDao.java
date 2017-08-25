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
		team.setName("ESS");
		team.setEmployeesList(null);
		return team;
	}

	@Override
	public String save(Team t) {
		return null;
	}

	@Override
	public List<Team> listAll() {
		List<Team> teams = new ArrayList<Team>();
		
		Team team1 = new Team();
		team1.setName("kekeke");
		team1.setEmployeesList(null);
		teams.add(team1);
		
		Team team2 = new Team();
		team2.setName("llflf");
		team2.setEmployeesList(null);
		teams.add(team2);
		
		return teams;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}
