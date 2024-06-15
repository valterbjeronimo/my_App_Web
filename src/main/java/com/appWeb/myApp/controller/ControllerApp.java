package com.appWeb.myApp.controller;



import com.appWeb.myApp.domain.Produto;

import com.appWeb.myApp.service.IserviceProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ControllerApp {


    @Autowired
    private IserviceProduto iserviceProduto;





    @GetMapping("/")
    @PostMapping("/")
    public String root(Model model){
        List<Produto> allProducts = iserviceProduto.getAll();
        model.addAttribute("produtos",allProducts);

        return "index";

    }

    @RequestMapping("/checkout")
    public String checkout(){
        return "checkout";
    }
}
