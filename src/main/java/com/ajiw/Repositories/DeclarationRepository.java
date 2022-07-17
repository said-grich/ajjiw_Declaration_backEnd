package com.ajiw.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajiw.entities.Declaration;

import java.util.List;


public interface DeclarationRepository extends JpaRepository<Declaration, Long>  {
    Declaration findDeclarationById(Long id);
    List<Declaration> findAll();
    List<Declaration> findDeclarationsByUserId(int id);

    void deleteById(Long aLong);
}
