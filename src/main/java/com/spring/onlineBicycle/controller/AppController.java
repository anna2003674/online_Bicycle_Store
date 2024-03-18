//package com.spring.onlineBicycle.controller;
//
//
//import com.spring.onlineBicycle.models.Application;
//import com.spring.onlineBicycle.services.AppService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/apps")
//@AllArgsConstructor
//public class AppController {
//
//    private AppService service;
//
//    // контрольная точка доступна без регистрации
//    @GetMapping("/welcome")
//    public String welcome(){
//        return "Welcome to the unprotected page";
//    }
//
//    @GetMapping("/all-app")
//    public List<Application> allApplications(){
//        return service.allApplications();
//    }
//
//    // ищет по id
//    @GetMapping("/{id}")
//    public Application applicationBYiD(@PathVariable int id){
//        return service.applicationById(id);
//
//    }
//
//
//
//
//}
