package com.appWeb.myApp.service;

import com.appWeb.myApp.domain.Produto;
import com.appWeb.myApp.exception.ProdutoException;

import java.util.List;

public interface IserviceProduto {

    List<Produto>getAll() throws ProdutoException;


    void cadastrarProduto(Produto produto);

    Produto getProdutoById(Long id);
}
