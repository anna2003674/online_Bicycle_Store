package com.spring.onlineBicycle.bicycleManager.controllers;

import com.spring.onlineBicycle.bicycleManager.models.Bicycle;
import com.spring.onlineBicycle.bicycleManager.repository.BicycleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

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
        Bicycle bicycle = new Bicycle(modell, year, bottomBracket, brand, chain, saddle, pedals, frontHub, type, price,
                weight, wheelDiameter, frameMaterial, brakeType, numberSpeeds, depreciation, quantityInStock, description);
        bicycleRepository.save(bicycle);
        return "redirect:/bicycleManager/home";
    }

    @GetMapping("/home/{id}")
    @PreAuthorize("hasAuthority('ROLE_BICYCLEMANAGER')")
    public String bicycleDetails(@PathVariable(value = "id") long id, Model model) {
        if (!bicycleRepository.existsById(id)) {
            return "redirect:/bicycleManager/home";
        }
        Optional<Bicycle> bicycle = bicycleRepository.findById(id);
        ArrayList<Bicycle> res = new ArrayList<>();
        bicycle.ifPresent(res::add);
        model.addAttribute("bicycle", res);
        return "bicycleManager/bicycleDetails";
    }


    // обновление велосипедов update
    @GetMapping("/home/{id}/edit")
    @PreAuthorize("hasAuthority('ROLE_BICYCLEMANAGER')")
    public String bicycleEdit(@PathVariable(value = "id") long id, Model model) {
        if (!bicycleRepository.existsById(id)) {
            return "redirect:/bicycleManager/home";
        }
        Optional<Bicycle> bicycle = bicycleRepository.findById(id);
        ArrayList<Bicycle> res = new ArrayList<>();
        bicycle.ifPresent(res::add);
        model.addAttribute("bicycle", res);
        return "bicycleManager/bicycleEdit";
    }


    // получаем данные из формочки для обновления данных
    @PostMapping("/home/{id}/edit")
    @PreAuthorize("hasAuthority('ROLE_BICYCLEMANAGER')")
    public String bicyclePostUpdate(@PathVariable(value = "id") long id,
                                    @RequestParam String modell, @RequestParam int year,
                                    @RequestParam String bottomBracket, @RequestParam String brand,
                                    @RequestParam String chain, @RequestParam String saddle,
                                    @RequestParam String pedals, @RequestParam String frontHub,
                                    @RequestParam String type, @RequestParam double price,
                                    @RequestParam double weight, @RequestParam double wheelDiameter,
                                    @RequestParam String frameMaterial, @RequestParam String brakeType,
                                    @RequestParam int numberSpeeds, @RequestParam String depreciation,
                                    @RequestParam int quantityInStock, @RequestParam String description,
                                    Model model) {
        Bicycle bicycle = bicycleRepository.findById(id).orElseThrow(); // если запись не найдена ()
        bicycle.setModell(modell);
        bicycle.setYear(year);
        bicycle.setBottomBracket(bottomBracket);
        bicycle.setBrand(brand);
        bicycle.setChain(chain);
        bicycle.setSaddle(saddle);
        bicycle.setPedals(pedals);
        bicycle.setFrontHub(frontHub);
        bicycle.setType(type);
        bicycle.setPrice(price);
        bicycle.setWeight(weight);
        bicycle.setWheelDiameter(wheelDiameter);
        bicycle.setFrameMaterial(frameMaterial);
        bicycle.setBrakeType(brakeType);
        bicycle.setNumberSpeeds(numberSpeeds);
        bicycle.setDepreciation(depreciation);
        bicycle.setQuantityInStock(quantityInStock);
        bicycle.setDescription(description);
        bicycleRepository.save(bicycle);
        return "redirect:/bicycleManager/home";
    }


    // получаем данные из формочки для удаления данных
    @PostMapping("/home/{id}/remove")
    @PreAuthorize("hasAuthority('ROLE_BICYCLEMANAGER')")
    public String bicyclePostDelete(@PathVariable(value = "id") long id, Model model) {
        Bicycle bicycle = bicycleRepository.findById(id).orElseThrow(); // если запись не найдена ()
        bicycleRepository.delete(bicycle);
        return "redirect:/bicycleManager/home";
    }


}
