package com.ajiw.service;

import com.ajiw.Repositories.UserRespository;
import com.ajiw.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class UserFrontService {
    @Autowired
    UserRespository userRespository;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Optional<?> login(User u){
        User userT=userRespository.findByEmail(u.getEmail());

        if(userT!=null&&userT.getIsAdmin()){
            String encodedPassword=userT.getPassword();
            String password=u.getPassword();
            boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
            if(isPasswordMatch){
                return Optional.of(userT);

            }else {
                return Optional.of(-2);
            }

        }else{
            return Optional.of(-1);
        }
    }

    public Optional<?> save(User u) {
        User userT=userRespository.findByEmail(u.getEmail());
        if(userT==null) {
            User user = new User();
            user.setIsAdmin(Boolean.TRUE);
            user.setNom(u.getNom());
            user.setPrenom(u.getPrenom());
            user.setEmail(u.getEmail());
            user.setCin(u.getCin());
            user.setTelephone(u.getTelephone());
            user.setRole(u.getRole());
            user.setPassword(passwordEncoder.encode(u.getPassword()));
            user.setRole(u.getRole());
            return  Optional.of(userRespository.save(user));
        }
        else {
            return Optional.of(-1);
        }
    }
    public Optional<?> update(User u) {
        User userT=userRespository.findByEmail(u.getEmail());
        if(userT!=null&&userT.getIsAdmin()) {
            userT.setNom(u.getNom());
            userT.setPrenom(u.getPrenom());
            userT.setEmail(u.getEmail());
            userT.setPassword(passwordEncoder.encode(u.getPassword()));
            userT.setRole(u.getRole());
            return  Optional.of(userRespository.save(userT));
        }
        else {
            return Optional.of(-1);
        }
    }
}
