package com.arturlogan.cursospringboot.services;

import com.arturlogan.cursospringboot.entitites.Usuario;
import com.arturlogan.cursospringboot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository  usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.get();
    }

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }


}
