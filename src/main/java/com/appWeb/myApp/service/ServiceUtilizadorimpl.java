package com.appWeb.myApp.service;

import com.appWeb.myApp.domain.Role;
import com.appWeb.myApp.domain.Utilizador;
import com.appWeb.myApp.repository.RoleRepository;
import com.appWeb.myApp.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class ServiceUtilizadorimpl implements IServiceUtilizador {

    @Autowired
     private UtilizadorRepository utilizadorRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Utilizador serviceTest() {
        return null;
    }

    @Override
    public Utilizador adicionarUtilizador(Utilizador utilizador) {
        Role role =roleRepository.findByName(Role.USER_Role);

        utilizador.setRoles(Collections.singleton(role));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        utilizador.setPassword(passwordEncoder.encode(utilizador.getPassword()));

        return utilizadorRepository.save(utilizador);

    }

    @Override
    public Utilizador findByLogin(String login) {
        return utilizadorRepository.findBylogin(login);
    }
}
