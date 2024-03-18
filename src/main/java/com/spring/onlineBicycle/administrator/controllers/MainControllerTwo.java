package com.spring.onlineBicycle.administrator.controllers;


import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrator")
@AllArgsConstructor
public class MainControllerTwo {


    // главная страница
    @GetMapping("/home")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String showHomePageAdm() {
        System.out.println("Main controller");
        return "administrator/homeAdm";
    }


    // добавление пользователей
    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String usersAdd() {
        return "administrator/usersAdd";
    }


}
