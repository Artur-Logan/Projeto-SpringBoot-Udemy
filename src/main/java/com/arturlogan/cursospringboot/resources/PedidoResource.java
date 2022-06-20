package com.arturlogan.cursospringboot.resources;

import com.arturlogan.cursospringboot.entitites.Pedido;
import com.arturlogan.cursospringboot.entitites.Usuario;
import com.arturlogan.cursospringboot.services.PedidoService;
import com.arturlogan.cursospringboot.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        List<Pedido> pedidoList = pedidoService.findAll();
        return ResponseEntity.ok().body(pedidoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
     Pedido pedido = pedidoService.findById(id);
     return ResponseEntity.ok().body(pedido);
    }
}