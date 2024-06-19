package com.appWeb.myApp.service;

import com.appWeb.myApp.domain.Role;
import org.springframework.stereotype.Service;

@Service
public interface IServiceRole {

    Role adicionarRole(Role role);

}
