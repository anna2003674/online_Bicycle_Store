package com.spring.onlineBicycle.authorizationAndAuthentication.services;

import com.spring.onlineBicycle.authorizationAndAuthentication.models.MyUser;
import com.spring.onlineBicycle.authorizationAndAuthentication.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveUser(MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Создаем новый экземпляр MyUser с установленным именем и ролью перед сохранением
        MyUser newUser = new MyUser(user.getName(), user.getPassword(), "ROLE_USER");
        userRepository.save(newUser);
    }

    public Optional<MyUser> findByUsername(String username) {
        return userRepository.findByName(username);
    }
}