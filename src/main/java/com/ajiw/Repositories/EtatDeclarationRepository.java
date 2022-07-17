package com.ajiw.Repositories;

import com.ajiw.entities.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ajiw.entities.EtatDeclaration;

import java.util.List;
import java.util.SortedSet;

public interface EtatDeclarationRepository extends JpaRepository<EtatDeclaration, Integer> {
    List<EtatDeclaration> deleteEtatDeclarationByDeclarationId(Long id);

    List<EtatDeclaration> findEtatDeclarationsByDeclarationId(Long id);

}
