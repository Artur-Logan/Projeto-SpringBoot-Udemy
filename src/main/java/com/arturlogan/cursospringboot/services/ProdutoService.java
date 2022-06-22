package com.arturlogan.cursospringboot.services;

import com.arturlogan.cursospringboot.entitites.Categoria;
import com.arturlogan.cursospringboot.entitites.Produto;
import com.arturlogan.cursospringboot.repositories.CategoriaRepository;
import com.arturlogan.cursospringboot.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.get();
    }
}
