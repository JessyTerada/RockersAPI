package com.rockers.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockers.api.model.User;

public interface IUserRepository  extends JpaRepository<User, Long>{

	User findByLoginAndPassword(String login, String password);

	User findByLogin(String username);
}
