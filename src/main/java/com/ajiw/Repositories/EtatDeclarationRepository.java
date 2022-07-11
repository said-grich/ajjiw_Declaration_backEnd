package com.ajiw.Repositories;

import com.ajiw.entities.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ajiw.entities.EtatDeclaration;

import java.util.List;

public interface EtatDeclarationRepository extends JpaRepository<EtatDeclaration, Integer> {
    List<EtatDeclaration> deleteEtatDeclarationByDeclarationId(Long id);

}
