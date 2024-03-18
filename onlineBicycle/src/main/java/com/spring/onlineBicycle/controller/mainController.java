package com.spring.onlineBicycle.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// контроллер для незарег. пользователей
@Controller
@AllArgsConstructor
public class mainController {

    // при переходе на главную страницу
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница сайта");
        return "home";

    }


    // переход на страницу о нас
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "О нас");
        return "about";

    }


    // переход на страницу контакты
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Контакты");
        return "contact";

    }


    // переход на страницу каталог
    @GetMapping("/cataloge")
    public String cataloge(Model model) {
        model.addAttribute("title", "Каталог товаров");
        return "cataloge";

    }


    // переход на страницу бренды
    @GetMapping("/brands")
    public String brands(Model model) {
        model.addAttribute("title", "Бренды");
        return "brands";

    }


    // переход на страницу доставка и оплата
    @GetMapping("/deliveryPayment")
    public String deliveryPayment(Model model) {
        model.addAttribute("title", "Доставка и оплата");
        return "deliveryPayment";

    }


}
