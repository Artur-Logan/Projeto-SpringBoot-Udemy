package com.arturlogan.cursospringboot.repositories;

import com.arturlogan.cursospringboot.entitites.Categoria;
import com.arturlogan.cursospringboot.entitites.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}