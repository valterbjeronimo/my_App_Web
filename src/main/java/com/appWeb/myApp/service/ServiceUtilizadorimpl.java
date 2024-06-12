package com.appWeb.myApp.service;

import com.appWeb.myApp.domain.Utilizador;
import org.springframework.stereotype.Service;

@Service
public class ServiceUtilizadorimpl implements IServiceUtilizador {


    @Override
    public void inserirutilizador(Utilizador utilizador) {

       Utilizador valter =Utilizador.builder()
                .nome("valter")
                .idade(32)
                .build();


    }
}
