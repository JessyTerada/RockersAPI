package com.rockers.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rockers.api.model.User;

@Component
public class UserDao implements Crud<User> {
	
	@Override
	public User findOne(String id) {
		User user = new User();
		user.setId(id);
		user.setLogin("123456");
		user.setPassword("123456");
		
		return user;
	}

	@Override
	public String save(User t) {
		t.setId("hehehe");
		return t.getId();
	}

	@Override
	public List<User> listAll() {
		List<User> usuario = new ArrayList<User>();
		User user1 = new User();
		user1.setId("45");
		user1.setLogin("jessica");
		user1.setPassword("123456");
		usuario.add(user1); 
		
		User user2 = new User();
		user2.setId("71");
		user2.setLogin("khristian");
		user2.setPassword("654321");
		usuario.add(user2);		
		
		User user3 = new User();
		user3.setId("102");
		user3.setLogin("Thaisa");
		user3.setPassword("654321");
		usuario.add(user3);	
		
		return usuario;
	}

	@Override
	public void delete(String id) {
	}


}
