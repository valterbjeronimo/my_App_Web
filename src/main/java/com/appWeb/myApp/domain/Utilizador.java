package com.appWeb.myApp.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Utilizador {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nome;
    @Column
    private int idade;

    @Column
    private String login;
    @Column
    private String password;


    @ManyToMany
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name = "utilizador_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


}
