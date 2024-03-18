package com.spring.onlineBicycle.authorizationAndAuthentication.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")


@AllArgsConstructor
@NoArgsConstructor


public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String password;
    private String roles;

    public MyUser(String name, String password, String roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }


}
