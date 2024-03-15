package com.example.backend.repository;


import com.example.backend.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByRolNombre(String rolNombre);
}
