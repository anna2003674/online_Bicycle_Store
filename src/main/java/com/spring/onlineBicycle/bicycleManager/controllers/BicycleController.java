package com.spring.onlineBicycle.bicycleManager.controllers;


import com.spring.onlineBicycle.bicycleManager.models.Bicycle;
import com.spring.onlineBicycle.bicycleManager.repository.BicycleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bicycleManager")
@AllArgsConstructor
public class BicycleController {

    @Autowired
    private BicycleRepository bicycleRepository;


    // главная страница (пока со всеми велосипедами (потом исправить) !!!!!!!!!!!!!!!!)
    @GetMapping("/home")
    @PreAuthorize("hasAuthority('ROLE_BICYCLEMANAGER')")
    public String showHomePageBicycleManager(Model model) {
        Iterable<Bicycle> bicycles = bicycleRepository.findAll();
        model.addAttribute("bicycles", bicycles);
        return "bicycleManager/homeBicycleManager";
    }


    // добавление велосипедов (просто перешли на стр)
    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_BICYCLEMANAGER')")
    public String bicycleAdd(Model model) {
        return "bicycleManager/bicycleAdd";
    }



    // получаем данные из формочки
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_BICYCLEMANAGER')")
    public String bicyclePostAdd(@RequestParam String modell, @RequestParam int year,
                                 @RequestParam String bottomBracket, @RequestParam String brand,
                                 @RequestParam String chain, @RequestParam String saddle,
                                 @RequestParam String pedals, @RequestParam String frontHub,
                                 @RequestParam String type, @RequestParam double price,
                                 @RequestParam double weight, @RequestParam double wheelDiameter,
                                 @RequestParam String frameMaterial, @RequestParam String brakeType,
                                 @RequestParam int numberSpeeds, @RequestParam String depreciation,
                                 @RequestParam int quantityInStock, @RequestParam String description,
                                 Model model) {
        Bicycle bicycle = new Bicycle(modell,year,bottomBracket,brand,chain,saddle,pedals,frontHub,type,price,
                weight,wheelDiameter,frameMaterial,brakeType,numberSpeeds,depreciation,quantityInStock,description);
        bicycleRepository.save(bicycle);
        return "redirect:/bicycleManager/home";
    }


}
