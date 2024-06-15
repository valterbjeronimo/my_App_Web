package com.appWeb.myApp.service;

import com.appWeb.myApp.domain.Produto;
import com.appWeb.myApp.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceprodutoImpl implements IserviceProduto{

   @Autowired
    ProdutoRepository produtoRepository;


    @Override
    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }
}
