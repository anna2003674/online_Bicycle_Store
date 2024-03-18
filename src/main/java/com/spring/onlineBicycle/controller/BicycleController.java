//package com.spring.onlineBicycle.controller;
//
//
//
//import com.spring.onlineBicycle.repository.BicycleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@Controller
//public class BicycleController {
//
//
//    // при переходе на главную страницу home
//    @GetMapping("/")
//    public String home(Model model){
//        model.addAttribute("title","Главная страница сайта");
//        return "home";
//
//    }
//
//    @GetMapping("/about")
//    public String about(Model model){
//        model.addAttribute("title","О нас");
//        return "about";
//
//    }
//
//
//
//
//
//
//}
