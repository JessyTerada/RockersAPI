package com.rockers.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.rockers.api.model.Contract;

@Controller
public class ContractDao implements Crud<Contract>{

	@Override
	public Contract findOne(String id) {
		Contract cont = new Contract();
		cont.setName("po");
		return cont;
	}

	@Override
	public String save(Contract t) {
		return null;
	}

	@Override
	public List<Contract> listAll() {
		List<Contract> contracts = new ArrayList<Contract>();
		
		Contract con1 = new Contract();
		con1.setName("lala");
		contracts.add(con1);
		
		Contract con2 = new Contract();
		con2.setName("popo");
		contracts.add(con2);
		
		return contracts;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}
