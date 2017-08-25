package com.rockers.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockers.api.model.Contract;

public interface IContractRepository extends JpaRepository<Contract, Long>{

}
