package com.appWeb.myApp.service;

import com.appWeb.myApp.domain.Role;
import com.appWeb.myApp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRoleImpl implements  IServiceRole{


    @Autowired
     RoleRepository roleRepository;

    @Override
    public Role adicionarRole(Role role) {
        return roleRepository.save(role);
    }
}
