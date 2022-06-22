package com.arturlogan.cursospringboot.services;

import com.arturlogan.cursospringboot.entitites.Categoria;
import com.arturlogan.cursospringboot.entitites.Pedido;
import com.arturlogan.cursospringboot.repositories.CategoriaRepository;
import com.arturlogan.cursospringboot.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.get();
    }
}
