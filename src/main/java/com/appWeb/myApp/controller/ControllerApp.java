package com.appWeb.myApp.controller;



import com.appWeb.myApp.domain.Utilizador;
import com.appWeb.myApp.service.IServiceUtilizador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerApp {

    @Autowired
    private IServiceUtilizador serviceUtilizador;



    @GetMapping("/")
    public String root(){
        Utilizador utilizador = serviceUtilizador.serviceTest();
        System.out.println(utilizador);
        return "index";
    }

    @RequestMapping("/checkout")
    public String checkout(){
        return "checkout";
    }
}
