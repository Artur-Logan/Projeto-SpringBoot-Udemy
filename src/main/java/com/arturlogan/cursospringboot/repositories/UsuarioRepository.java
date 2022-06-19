package com.arturlogan.cursospringboot.repositories;

import com.arturlogan.cursospringboot.entitites.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
