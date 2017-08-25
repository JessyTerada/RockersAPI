package com.rockers.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Contract extends BaseEntity{

	@Override
	public String toString() {
		return "Project [name=" + name + "]";
	}
	
	@Column(name = "name", nullable = false, unique = true)
	public String name;
	
	@OneToMany(mappedBy = "contract")
	public List<Team> teamList;
	
}
