package com.ajiw.service;

import com.ajiw.Repositories.*;
import com.ajiw.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;

@Service
public class DeclarationService {
    @Autowired
    DeclarationRepository declarationRepository;
    @Autowired
    EtatDeclarationRepository etatDeclarationRepository;
    @Autowired
    UserRespository userRespository;
    @Autowired
    EtatRepository etatRepository;
    @Autowired
    private FileStorageService fileDBRepository;
    @Autowired
    private  PhotoService  photoService;

    public List<Declaration> findAll() {
        return declarationRepository.findAll();
    }


    public Optional<?>  save(Declaration declaration, MultipartFile file,String email) throws IOException {
      Declaration dc_Tmp= declarationRepository.findDeclarationById( declaration.getId());
       if(dc_Tmp==null){
           User user =userRespository.findByEmail(email);
           String fileName = StringUtils.cleanPath(file.getOriginalFilename());
           FileDB fileDB = new FileDB(fileName, file.getContentType());
           fileDB=photoService.saveImage(file,fileDB);
           declaration.setPhoto(fileDB);
           System.out.println(fileDB.getName());
           LocalDateTime date = LocalDateTime.now();
           int day = date.getDayOfMonth();
           int mois = date.getMonthValue();
           int ans = date.getYear();
           int hour=date.getHour();
           int min=date.getMinute();
           int sec=date.getSecond();
           String datee0 = ans+"-"+mois+"-"+day;
           String datee01 = ans+"-"+mois+"-"+day+" "+hour+":"+min+":"+sec;
           Date date1=Date.valueOf(datee0);
           Timestamp date2= Timestamp.valueOf(datee01);
           System.out.println("------------------------>"+date1);
           declaration.setDateDecl(date1);
           declaration.setUser(user);
          Declaration dec= declarationRepository.save(declaration);
           Etat etat= etatRepository.findByLibelle("en attente");
           EtatDeclaration etatDeclaration = new EtatDeclaration();
           etatDeclaration.setDeclaration(declaration);
           etatDeclaration.setEtat(etat);
           etatDeclaration.setDateEtat(date2);
           etatDeclaration.setUser(user);
           etatDeclarationRepository.save(etatDeclaration);
            return Optional.of(dec);

       }else {
           return Optional.of(-1);
       }
    }
    @Transactional
    public Optional<?>  update(Declaration declaration, MultipartFile file) throws IOException {
        Declaration dc_Tmp= declarationRepository.findDeclarationById(declaration.getId());
        if(dc_Tmp!=null){
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            FileDB fileDB = new FileDB(fileName, file.getContentType());

            dc_Tmp.setPhoto(fileDB);
            dc_Tmp.setAdresse(declaration.getAdresse());
            dc_Tmp.setTitle(declaration.getTitle());
            dc_Tmp.setContent(declaration.getContent());
            dc_Tmp.setCateg(declaration.getCateg());
            dc_Tmp.setLatitude(declaration.getLatitude());
            dc_Tmp.setLongitude(declaration.getLongitude());
            LocalDateTime date = LocalDateTime.now();
            int day = date.getDayOfMonth();
            int mois = date.getMonthValue();
            int ans = date.getYear();
            int hour=date.getHour();
            int min=date.getMinute();
            String datee0 = ans+"-"+mois+"-"+day;
            String datee01 = ans+"-"+mois+"-"+day+"-"+hour+"-"+min;
            Date date1=Date.valueOf(datee0);
            Timestamp date2= Timestamp.valueOf(datee01);
            dc_Tmp.setDateDecl(date1);
            etatDeclarationRepository.deleteEtatDeclarationByDeclarationId(declaration.getId());
            Declaration dec= declarationRepository.save(dc_Tmp);
            Etat etat= etatRepository.findByLibelle("en attente");
            EtatDeclaration etatDeclaration = new EtatDeclaration();
            etatDeclaration.setDeclaration(declaration);
            etatDeclaration.setEtat(etat);
            etatDeclaration.setDateEtat(date2);
            etatDeclaration.setUser(dc_Tmp.getUser());
            etatDeclarationRepository.save(etatDeclaration);

            return Optional.of(dec );

        }else {
            return Optional.of(-1);
        }
    }
    @Transactional
    public int deleteById(Long integer) {
        Declaration declaration=declarationRepository.findDeclarationById(integer);
        if(declaration!=null){
            etatDeclarationRepository.deleteEtatDeclarationByDeclarationId(integer);
            declarationRepository.deleteById(integer);
            return 1;
        }else{
            return -1;
        }

    }

    public List<Declaration> findDeclarationsByUserId(int id) {
        return declarationRepository.findDeclarationsByUserId(id);
    }

    public List<EtatDeclaration> findEtatDeclarationsByDeclarationId(Long id) {
        return etatDeclarationRepository.findEtatDeclarationsByDeclarationId(id);
    }

    public Declaration findDeclarationById(String id) {
        Long id1=Long.valueOf(id);
        return declarationRepository.findDeclarationById(id1);
    }
}
