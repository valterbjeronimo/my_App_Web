package com.appWeb.myApp.service;

import com.appWeb.myApp.domain.Utilizador;
import com.appWeb.myApp.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUtilizadorimpl implements IServiceUtilizador {

    @Autowired
    UtilizadorRepository utilizadorRepository;
    @Override
    public Utilizador serviceTest() {
        return null;
    }

    @Override
    public Utilizador adicionarUtilizador(Utilizador utilizador) {
        return utilizadorRepository.save(utilizador);
    }

    @Override
    public Utilizador findByLogin(String login) {
        return null;
    }
}
