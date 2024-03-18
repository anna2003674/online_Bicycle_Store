package com.spring.onlineBicycle.authorizationAndAuthentication.repository;


// репозиторий который вытаскивает данные из БД

import com.spring.onlineBicycle.authorizationAndAuthentication.models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    // поиск пользователя по имени
    Optional<MyUser> findByName(String username);


}
