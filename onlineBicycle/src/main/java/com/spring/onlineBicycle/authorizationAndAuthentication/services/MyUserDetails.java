package com.spring.onlineBicycle.authorizationAndAuthentication.services;


import com.spring.onlineBicycle.authorizationAndAuthentication.models.MyUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


public class MyUserDetails implements UserDetails {

    private MyUser user;

    public MyUserDetails(MyUser user) {
        this.user = user;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(user.getRoles().split(", "))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }


    // истек ли срок действия учетной записи пользователя
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    // заблокирован ли пользователь или нет
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    // истек ли срой действия пароля
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    // включен ли пользователь или отколючен
    @Override
    public boolean isEnabled() {
        return true;
    }
}
