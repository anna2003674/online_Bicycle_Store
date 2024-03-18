//package com.spring.onlineBicycle.controller;
//
//
//import com.spring.onlineBicycle.model.Bicycle;
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
//public class BicycleManagerController {
//
//    private final BicycleRepository bicycleRepository;
//
//    public BicycleManagerController(BicycleRepository bicycleRepository) {
//        this.bicycleRepository = bicycleRepository;
//    }
//
//
//    // при переходе на страницу списка всех добавленных велосипедов
//    @GetMapping("/bicycle")
//    public String bicycle(){
//        return "home";
//    }
//
//    // при переходе на страницу списка всех велосипедов
//    @GetMapping("/allBicycle")
//    public String allBicycle(Model model){
//        Iterable<Bicycle> bicycles = bicycleRepository.findAll();
//        model.addAttribute("bicycles",bicycles);
//        return "allBicycle";
//    }
//
//    // при переходе на страницу добавления велосипеда
//    @GetMapping("/bicycleAdd")
//    public String bicycleAdd(){
//        return "bicycleAdd";
//    }
//
//    @PostMapping("/bicycleAdd")
//    public String BicyclePostAdd(@RequestParam String modell,
//                                 @RequestParam int year,
//                                 @RequestParam String bottomBracket,
//                                 @RequestParam String brand,
//                                 @RequestParam String chain,
//                                 @RequestParam String saddle,
//                                 @RequestParam String pedals,
//                                 @RequestParam String frontHub,
//                                 @RequestParam String type,
//                                 @RequestParam int price,
//                                 @RequestParam double weight,
//                                 @RequestParam double wheeDiameter,
//                                 @RequestParam String frameMaterial,
//                                 @RequestParam String brakeType,
//                                 @RequestParam int numberSpeeds,
//                                 @RequestParam String depreciation,
//                                 @RequestParam int quantityInStock,
//                                 @RequestParam String description,
//                                 Model model){
//
//        Bicycle bicycle = new Bicycle(modell,year,bottomBracket,
//                brand,chain,saddle,pedals,frontHub,type,price,weight,wheeDiameter,frameMaterial,
//                brakeType,numberSpeeds,depreciation,quantityInStock,description);
//        bicycleRepository.save(bicycle);
//
//        return "redirect:/allBicycle";
//
//    }
//
//
//    @GetMapping("/allBicycle/{id}")
//    public String bicycleDetails(@PathVariable(value = "id") long id, Model model){
//        if(!bicycleRepository.existsById(id)){
//            return "redirect:/allBicycle";
//
//        }
//        Optional<Bicycle> bicycle = bicycleRepository.findById(id);
//        ArrayList<Bicycle> res = new ArrayList<>();
//        bicycle.ifPresent(res::add);
//        model.addAttribute("bicycle", res);
//        return "bicycleDetails";
//    }
//
//    @GetMapping("/allBicycle/{id}/edit")
//    public String bicycleEdit(@PathVariable(value = "id") long id, Model model){
//        if(!bicycleRepository.existsById(id)){
//            return "redirect:/allBicycle";
//        }
//        Optional<Bicycle> bicycle = bicycleRepository.findById(id);
//        ArrayList<Bicycle> res = new ArrayList<>();
//        bicycle.ifPresent(res::add);
//        model.addAttribute("bicycle", res);
//        return "bicycleEdit";
//    }
//
//
//
//    //функц обрабатывает формочку для обновления данных
//    @PostMapping("/bicycleAdd/{id}/edit")
//    public String BicyclePostUpdate(@PathVariable(value = "id") long id,
//                                 @RequestParam String modell,
//                                 @RequestParam int year,
//                                 @RequestParam String bottomBracket,
//                                 @RequestParam String brand,
//                                 @RequestParam String chain,
//                                 @RequestParam String saddle,
//                                 @RequestParam String pedals,
//                                 @RequestParam String frontHub,
//                                 @RequestParam String type,
//                                 @RequestParam int price,
//                                 @RequestParam double weight,
//                                 @RequestParam double wheeDiameter,
//                                 @RequestParam String frameMaterial,
//                                 @RequestParam String brakeType,
//                                 @RequestParam int numberSpeeds,
//                                 @RequestParam String depreciation,
//                                 @RequestParam int quantityInStock,
//                                 @RequestParam String description,
//                                 Model model){
//
//        Bicycle bicycle = bicycleRepository.findById(id).orElseThrow();
//        bicycle.setModell(modell);
//        bicycle.setYear(year);
//        bicycle.setBottomBracket(bottomBracket);
//        bicycle.setBrand(brand);
//        bicycle.setChain(chain);
//        bicycle.setSaddle(saddle);
//        bicycle.setPedals(pedals);
//        bicycle.setFrontHub(frontHub);
//        bicycle.setType(type);
//        bicycle.setPrice(price);
//        bicycle.setWeight(weight);
//        bicycle.setWheelDiameter(wheeDiameter);
//        bicycle.setFrameMaterial(frameMaterial);
//        bicycle.setBrakeType(brakeType);
//        bicycle.setNumberSpeeds(numberSpeeds);
//        bicycle.setDepreciation(depreciation);
//        bicycle.setQuantityInStock(quantityInStock);
//        bicycle.setDescription(description);
//        bicycleRepository.save(bicycle);
//
//        return "redirect:/bicycleAdd";
//
//    }
//
//
//    //функц обрабатывает формочку для удаления велосипедов
//    @PostMapping("/allBicycle/{id}/remove")
//    public String BicyclePostDelete(@PathVariable(value = "id") long id, Model model){
//        Bicycle bicycle = bicycleRepository.findById(id).orElseThrow();
//        bicycleRepository.delete(bicycle);
//        return "redirect:/allBicycle/{id}";
//
//    }
//
//
//
//
//
//
//}
