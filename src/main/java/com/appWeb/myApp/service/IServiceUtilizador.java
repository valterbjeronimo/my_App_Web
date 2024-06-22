package com.appWeb.myApp.service;


import com.appWeb.myApp.domain.Utilizador;

import java.util.List;

public interface IServiceUtilizador {
    Utilizador serviceTest();

    Utilizador adicionarUtilizador(Utilizador utilizador);

    Utilizador findByLogin(String login);

    List<Utilizador>getAll();
}
