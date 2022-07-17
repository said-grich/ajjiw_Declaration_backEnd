package com.ajiw.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajiw.entities.Reaction;

import java.util.List;

public interface ReactionRepository  extends JpaRepository<Reaction, Integer>{
    List<Reaction> findReactionsByDeclarationId(int id);
    int deleteReactionsByIdReact(Integer id);
}
