package com.appWeb.myApp.controller;

import com.appWeb.myApp.domain.Role;
import com.appWeb.myApp.service.IServiceRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role/")
public class RoleController {

    @Autowired
    IServiceRole serviceRole;

    @PostMapping
    public Role adicionarRole(@RequestBody Role role){
       return serviceRole.adicionarRole(role);
    }
}
