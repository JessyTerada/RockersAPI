package com.rockers.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Team extends BaseEntity{

	@OneToMany(mappedBy = "team")
    private List<Employee> employeesList;
	
	@Column(name = "name", nullable = false, unique = true)
    private String name;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contract_id")
    private Contract contract;
    	
}
