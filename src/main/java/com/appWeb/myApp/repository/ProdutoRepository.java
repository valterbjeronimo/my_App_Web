package com.appWeb.myApp.repository;

import com.appWeb.myApp.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
