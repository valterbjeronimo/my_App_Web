package com.appWeb.myApp.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerApp {



    @GetMapping("/")
    public String root(){
        return "index";
    }

    @RequestMapping("/checkout")
    public String checkout(){
        return "checkout";
    }
}
