package com.appWeb.myApp.service;

import com.appWeb.myApp.domain.Role;
import com.appWeb.myApp.domain.Utilizador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class UserDetailImpl implements UserDetailsService {

    @Autowired
    IServiceUtilizador iServiceUtilizador;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilizador utilizador = iServiceUtilizador.findByLogin(username);

        Set<Role>roles=utilizador.getRoles();

        Set<GrantedAuthority> authorities = new HashSet<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

        return new User(utilizador.getLogin(), utilizador.getPassword(), authorities);
    }
}
