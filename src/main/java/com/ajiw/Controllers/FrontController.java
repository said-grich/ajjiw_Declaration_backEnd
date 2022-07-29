package com.ajiw.Controllers;

import com.ajiw.Repositories.DeclarationRepository;
import com.ajiw.Repositories.UserRespository;
import com.ajiw.entities.Declaration;
import com.ajiw.entities.User;
import com.ajiw.service.DeclarationService;
import com.ajiw.service.EtatDeclartionService;
import com.ajiw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/front/auth")
public class FrontController {

    @Autowired
    UserService userService;
    @Autowired
    DeclarationService declarationService;
    @Autowired
    EtatDeclartionService etatDeclartionService;
    @Autowired
    UserRespository userRespository;

    @PostMapping("/login")
    public Optional<?> login(@RequestBody User u) {
        return userService.login(u);
    }
    @PostMapping("/singup")
    public Optional<?> save(@RequestBody User u) {
        return userService.save(u);
    }
    @PutMapping("/update")
    public Optional<?> update(@RequestBody User u) {
        return userService.update(u);
    }
    @GetMapping("/{email}")
    public ResponseEntity findAll(@PathVariable String email) {
       User user= userRespository.findByEmail(email);
       if(user.getIsAdmin()){
           return   ResponseEntity.ok(declarationService.findAll());
       }else{
           return ResponseEntity.ok(-1);
       }
    }



}
