package com.ajiw.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajiw.entities.Reaction; 

public interface ReactionRepository  extends JpaRepository<Reaction, Integer>{


}
