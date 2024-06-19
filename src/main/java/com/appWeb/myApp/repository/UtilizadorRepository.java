package com.appWeb.myApp.repository;


import com.appWeb.myApp.domain.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilizadorRepository extends JpaRepository<Utilizador,Long> {

    Utilizador findBylogin(String login);
}
