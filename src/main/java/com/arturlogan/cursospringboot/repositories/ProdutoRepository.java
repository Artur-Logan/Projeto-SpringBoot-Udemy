package com.arturlogan.cursospringboot.repositories;

import com.arturlogan.cursospringboot.entitites.Categoria;
import com.arturlogan.cursospringboot.entitites.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}