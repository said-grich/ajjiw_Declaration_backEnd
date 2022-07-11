package com.ajiw.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajiw.entities.TypeReaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeReactionRepository extends JpaRepository<TypeReaction, Integer>{
	
	List<TypeReaction> findAll();
	
}
