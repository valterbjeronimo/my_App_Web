package com.appWeb.myApp.controller;

import com.appWeb.myApp.domain.Produto;
import com.appWeb.myApp.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoRepository produtoRepository;


    @GetMapping
    public List<Produto>listar(){
        return produtoRepository.findAll();
    }


    @PostMapping
    public void criar(@RequestBody Produto produto){
       Produto produtoSalvo = produtoRepository.save(produto);
        System.out.println("Produto Salvo " + produtoSalvo);

    }

    @GetMapping("/pesquisar")
    public List<Produto>pesquisar(@RequestParam String nome){
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }
}
