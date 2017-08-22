package com.rockers.api.model;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class Team{

	private String idTeam;
    private Set<Employee> employees = new HashSet<Employee>();
    private String nameTeam;
    	
}
