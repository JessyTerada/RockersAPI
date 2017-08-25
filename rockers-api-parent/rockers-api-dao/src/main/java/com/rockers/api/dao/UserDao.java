package com.rockers.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rockers.api.model.User;
import com.rockers.api.repository.IUserRepository;

@Component
public class UserDao implements Crud<User> {
	
	@Autowired
	IUserRepository userRepository;
	
	@Override
	public User findOne(String id) {
		User user = new User();
		user.setLogin("123456");
		user.setPassword("123456");
		
		return user;
	}

	@Override
	public String save(User t) {
		return null;
	}

	@Override
	public List<User> listAll() {
		List<User> usuario = new ArrayList<User>();
		User user1 = new User();
		user1.setLogin("jessica");
		user1.setPassword("123456");
		usuario.add(user1); 
		
		User user2 = new User();
		user2.setLogin("khristian");
		user2.setPassword("654321");
		usuario.add(user2);		
		
		User user3 = new User();
		user3.setLogin("Thaisa");
		user3.setPassword("654321");
		usuario.add(user3);	
		
		return usuario;
	}

	@Override
	public void delete(String id) {
	}


}
