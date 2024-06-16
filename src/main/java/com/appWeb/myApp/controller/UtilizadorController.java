package com.appWeb.myApp.controller;

import com.appWeb.myApp.domain.Utilizador;
import com.appWeb.myApp.service.IServiceUtilizador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/utilizador/")
public class UtilizadorController {

    @Autowired
    IServiceUtilizador iServiceUtilizador;

    @PostMapping
    public Utilizador adicionarUtilizador(@RequestBody Utilizador utilizador) {
        return iServiceUtilizador.adicionarUtilizador(utilizador );
    }
}
