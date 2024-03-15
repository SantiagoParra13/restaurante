package com.example.backend.repository;

import com.example.backend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findById(String userId);

    Usuario findByUsername(String username);
}
