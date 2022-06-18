package com.arturlogan.cursospringboot.resources;

import com.arturlogan.cursospringboot.entitites.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @GetMapping
    public ResponseEntity<Usuario> findAll(){
        Usuario usuario = new Usuario(2L,"artur", "12345", "asdfg");
        return ResponseEntity.ok().body(usuario);
    }

}