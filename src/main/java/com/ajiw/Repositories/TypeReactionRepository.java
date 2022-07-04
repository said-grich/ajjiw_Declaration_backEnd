package com.ajiw.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajiw.entities.TypeReaction;

public interface TypeReactionRepository extends JpaRepository<TypeReaction, Integer>{
	
	List<TypeReaction> findAll();
	
	TypeReaction findByLibelle(String libelle);
}
