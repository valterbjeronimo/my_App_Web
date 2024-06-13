package com.appWeb.myApp.repository;

import com.appWeb.myApp.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    List<Produto>findByNomeContainingIgnoreCase(String nome);



}
