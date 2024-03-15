package com.example.backend.service;

import com.example.backend.exceptions.UserNotFoundException;
import com.example.backend.models.Usuario;
import com.example.backend.models.UsuarioRol;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UsuarioService {
    Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    Usuario obtenerUsuario(String username);

    Optional<Usuario> obtenerUsuarioPorId(Long userId);

    Usuario actualizarUsuario(Long id, Usuario usuario) throws UserNotFoundException;

    void eliminarUsuario(Long id);

    List<Usuario> listarUsuarios();
}
