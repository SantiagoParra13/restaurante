package com.example.backend.service.impl;


import com.example.backend.exceptions.UserNotFoundException;
import com.example.backend.models.Usuario;
import com.example.backend.models.UsuarioRol;
import com.example.backend.repository.RolRepository;
import com.example.backend.repository.UsuarioRepository;
import com.example.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UsuarioServiceimpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;

    public UsuarioServiceimpl() {
    }

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = this.usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioLocal != null) {
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        } else {
            Iterator var5 = usuarioRoles.iterator();

            while(var5.hasNext()) {
                UsuarioRol usuarioRol = (UsuarioRol)var5.next();
                this.rolRepository.save(usuarioRol.getRol());
            }

            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = (Usuario)this.usuarioRepository.save(usuario);
            return usuarioLocal;
        }
    }

    public Usuario obtenerUsuario(String username) {
        return this.usuarioRepository.findByUsername(username);
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long userId) {
        return this.usuarioRepository.findById(userId);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuario) throws UserNotFoundException {
        Optional<Usuario> usuarioOpt = this.usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuarioExistente = (Usuario)usuarioOpt.get();
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setApellido(usuario.getApellido());
            usuarioExistente.setPassword(usuario.getPassword());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setUsername(usuario.getUsername());
            return (Usuario)this.usuarioRepository.save(usuarioExistente);
        } else {
            throw new UserNotFoundException("El usuario con ID " + id + " no fue encontrado.");
        }
    }

    public void eliminarUsuario(Long id) {
        this.usuarioRepository.deleteById(id);
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList(this.usuarioRepository.findAll());
    }
}
