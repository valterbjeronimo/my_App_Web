package com.appWeb.myApp.service;

import com.appWeb.myApp.domain.Produto;

import java.util.List;

public interface IserviceProduto {

    List<Produto>getAll();


    void cadastrarProduto(Produto produto);

    Produto getProdutoById(Long id);
}
