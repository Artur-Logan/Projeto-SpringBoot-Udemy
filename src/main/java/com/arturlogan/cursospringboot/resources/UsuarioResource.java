package com.arturlogan.cursospringboot.resources;

import com.arturlogan.cursospringboot.entitites.Usuario;
import com.arturlogan.cursospringboot.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> usuarioList = usuarioService.findAll();
        return ResponseEntity.ok().body(usuarioList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
     Usuario usuario = usuarioService.findById(id);
     return ResponseEntity.ok().body(usuario);
    }
}