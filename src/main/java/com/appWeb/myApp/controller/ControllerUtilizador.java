package com.appWeb.myApp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerUtilizador {



    @GetMapping("/test")
    public ResponseEntity getAll(){
        return  new ResponseEntity<>("test", HttpStatus.OK);
    }
}
