package com.ajiw.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajiw.entities.Etat;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatRepository extends JpaRepository<Etat, Integer> {
        Etat findByLibelle(String s);

}
