package com.spring.onlineBicycle.authorizationAndAuthentication.services;


import com.github.javafaker.Faker;
import com.spring.onlineBicycle.authorizationAndAuthentication.models.Application;
import com.spring.onlineBicycle.authorizationAndAuthentication.models.MyUser;
import com.spring.onlineBicycle.authorizationAndAuthentication.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;


@Service
@AllArgsConstructor
public class AppService {
    private List<Application> applications;
    private UserRepository repository;
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void loadAppInDB() {
        Faker faker = new Faker();
        applications = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> Application.builder()
                        .id(i)
                        .name(faker.app().name())
                        .author(faker.app().author())
                        .version(faker.app().version())
                        .build())
                .toList();


    }


    // метод возвращает полный список приложений (100)
    public List<Application> allApplications() {
        return applications;
    }

    // возвращение приложения по id
    public Application applicationById(int id) {
        return applications.stream()
                .filter(app -> app.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addUser(MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }


}
