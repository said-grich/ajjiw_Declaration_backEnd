package com.ajiw.Controllers;

import com.ajiw.entities.User;
import com.ajiw.service.DeclarationService;
import com.ajiw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    UserService userService;

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
}
