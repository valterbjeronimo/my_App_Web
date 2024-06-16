package com.appWeb.myApp.service;

import com.appWeb.myApp.domain.Produto;
import com.appWeb.myApp.exception.ProdutoException;
import com.appWeb.myApp.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceprodutoImpl implements IserviceProduto{

    @Autowired
     ProdutoRepository produtoRepository;


    @Override
    public List<Produto> getAll() throws ProdutoException {

        //throw new ProdutoException("ocorreu um erro ", "/produtoscadastrar");
        return produtoRepository.findAll();


    }

    @Override
    public void cadastrarProduto(Produto produto) {
        produtoRepository.save(produto);

    }

    @Override
    public Produto getProdutoById(Long id) {
        return produtoRepository.getReferenceById(id);
    }
}
