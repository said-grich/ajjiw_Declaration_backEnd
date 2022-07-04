package com.ajiw.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajiw.entities.User; 

public interface UserRespository extends JpaRepository<User, Integer>{

	User findByEmail(String username); 
	
}
