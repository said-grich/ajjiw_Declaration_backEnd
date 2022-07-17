package com.ajiw.Controllers;

import com.ajiw.entities.Declaration;
import com.ajiw.entities.EtatDeclaration;
import com.ajiw.service.DeclarationService;
import com.ajiw.service.EtatDeclartionService;
import com.google.gson.Gson;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;

@RestController
@RequestMapping("/declaration")
public class DeclarationController {
    @Autowired
    DeclarationService declarationService;
    @Autowired
    EtatDeclartionService etatDeclartionService;

    @GetMapping("/")
    public List<Declaration> findAll() {
        return declarationService.findAll();
    }
    @PostMapping("/newDeclaration")
    public Optional<?> save(@RequestParam("declaration") String declaration,@RequestParam("file") MultipartFile file ,@RequestParam("email") String useremail) throws IOException {
        Declaration convertedObject = new Gson().fromJson(declaration, Declaration.class);

        return declarationService.save(convertedObject,file,useremail);
    }
    @PutMapping("/update")
    public Optional<?> update(@RequestParam("declaration") String declaration,@RequestParam("file") MultipartFile file ) throws IOException {
        Declaration convertedObject = new Gson().fromJson(declaration, Declaration.class);

        return declarationService.update(convertedObject,file);
    }
    @DeleteMapping("/delete/{id}")
    public int deleteById(@PathVariable Long id) {
       return declarationService.deleteById(id);
    }
    @GetMapping("/userdec/{id}")
    public List<Declaration> findDeclarationsByUserId(@PathVariable int id) {
        return declarationService.findDeclarationsByUserId(id);
    }
    @GetMapping("/etat/{id}")
    public List<EtatDeclaration> findEtatDeclarationsByDeclarationId(@PathVariable Long id) {
        return declarationService.findEtatDeclarationsByDeclarationId(id);
    }
    @GetMapping("/updateetat/{leEtat}/{idDeclaration}")
    public EtatDeclaration save(@PathVariable String leEtat,@PathVariable Long idDeclaration) {
        return etatDeclartionService.save(leEtat, idDeclaration);
    }
    @GetMapping("/byid/{id}")
    public Declaration findDeclarationById(@PathVariable String id) {
        System.out.println(id);
        return declarationService.findDeclarationById(id);
    }
}
