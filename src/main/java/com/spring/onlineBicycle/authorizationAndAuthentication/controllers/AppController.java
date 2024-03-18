package com.spring.onlineBicycle.authorizationAndAuthentication.controllers;


import com.spring.onlineBicycle.authorizationAndAuthentication.models.Application;
import com.spring.onlineBicycle.authorizationAndAuthentication.models.MyUser;
import com.spring.onlineBicycle.authorizationAndAuthentication.services.AppService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/apps")
@AllArgsConstructor
public class AppController {

    private AppService service;


    // первая контрольная точка будет доступна без регистрации
    @GetMapping("/welcome")
    public String welcome() {
        return "Добро пожаловать на незащищенную страницу";
    }

    // вторая контрольная точка вернет всех
    @GetMapping("/all-app")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Application> allApplications() {
        return service.allApplications();

    }

    // последняя контр точка ищет все приложения по идентификатору
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Application applicationByID(@PathVariable int id) {
        return service.applicationById(id);

    }

    @PostMapping("/new-user")
    public String addUser(@RequestBody MyUser user) {
        service.addUser(user);
        return "User is saved";

    }


    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }


}
