package com.arturlogan.cursospringboot.services;

import com.arturlogan.cursospringboot.entitites.Usuario;
import com.arturlogan.cursospringboot.repositories.UsuarioRepository;
import com.arturlogan.cursospringboot.services.exceptions.DatabaseException;
import com.arturlogan.cursospringboot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return usuario.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id){
        try{
            usuarioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
          throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Usuario atualizar(Long id, Usuario usuario){
        try {
            Usuario entity = usuarioRepository.getById(id);
            atualizarData(entity, usuario);
            return usuarioRepository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void atualizarData(Usuario entity, Usuario usuario) {
        entity.setNome(usuario.getNome());
        entity.setEmail(usuario.getEmail());
        entity.setFone(usuario.getFone());
    }
}
