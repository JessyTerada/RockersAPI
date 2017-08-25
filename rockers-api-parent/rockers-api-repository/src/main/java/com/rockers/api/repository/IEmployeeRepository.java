package com.rockers.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockers.api.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
