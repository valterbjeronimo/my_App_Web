package com.appWeb.myApp.domain;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Utilizador {
    private String nome;
    private int idade;
}
