package com.appWeb.myApp.service;


import com.appWeb.myApp.domain.Utilizador;

public interface IServiceUtilizador {
    Utilizador serviceTest();

    Utilizador adicionarUtilizador(Utilizador utilizador);

    Utilizador findByLogin(String login);
}
