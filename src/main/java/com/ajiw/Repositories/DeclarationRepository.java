package com.ajiw.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajiw.entities.Declaration;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DeclarationRepository extends JpaRepository<Declaration, Long>  {
    Declaration findDeclarationById(Long id);
    List<Declaration> findAll();

    void deleteById(Long aLong);
}
