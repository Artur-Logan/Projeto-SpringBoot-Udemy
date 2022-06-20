package com.arturlogan.cursospringboot.services;

import com.arturlogan.cursospringboot.entitites.Pedido;
import com.arturlogan.cursospringboot.entitites.Usuario;
import com.arturlogan.cursospringboot.repositories.PedidoRepository;
import com.arturlogan.cursospringboot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.get();
    }
}
