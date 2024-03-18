package com.spring.onlineBicycle.administrator.services;


import com.spring.onlineBicycle.administrator.models.User;
import com.spring.onlineBicycle.administrator.repository.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserrService {

    @Autowired
    private UserrRepository repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }
}
