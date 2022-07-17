package com.ajiw.service;

import com.ajiw.Repositories.DeclarationRepository;
import com.ajiw.Repositories.EtatDeclarationRepository;
import com.ajiw.Repositories.EtatRepository;
import com.ajiw.entities.Declaration;
import com.ajiw.entities.Etat;
import com.ajiw.entities.EtatDeclaration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class EtatDeclartionService {
    @Autowired
    EtatDeclarationRepository etatDeclarationRepository;
    @Autowired
    EtatRepository etatRepository;
    @Autowired
    DeclarationRepository declarationRepository;


    public  EtatDeclaration save(String leEtat ,Long idDeclaration) {
        EtatDeclaration etatDeclaration=new EtatDeclaration();
        Etat etat=etatRepository.findByLibelle(leEtat);
        Declaration declaration=declarationRepository.findDeclarationById(idDeclaration);
        etatDeclaration.setEtat(etat);
        etatDeclaration.setDeclaration(declaration);
        LocalDateTime date = LocalDateTime.now();
        Timestamp date2= Timestamp.valueOf(date);
        etatDeclaration.setDateEtat(date2);
        etatDeclaration.setUser(declaration.getUser());
        return etatDeclarationRepository.save(etatDeclaration);
    }
}
