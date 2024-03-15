package com.example.backend.controllers;

import com.example.backend.exceptions.UserNotFoundException;
import com.example.backend.models.Rol;
import com.example.backend.models.Usuario;
import com.example.backend.models.UsuarioRol;
import com.example.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping({"/usuarios"})
@CrossOrigin({"*"})
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioController() {
    }

    @PostMapping({"/"})
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception {
        Set<UsuarioRol> usuarioRoles = new HashSet();
        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setRolNombre("USER");
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);
        usuarioRoles.add(usuarioRol);
        return this.usuarioService.guardarUsuario(usuario, usuarioRoles);
    }

    @GetMapping({"/{username}"})
    public Usuario obtenerUsuario(@PathVariable("username") String username) {
        return this.usuarioService.obtenerUsuario(username);
    }

    @GetMapping({"/"})
    public List<Usuario> listarUsuarios() {
        return this.usuarioService.listarUsuarios();
    }

    @PutMapping({"/{userId}"})
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long userId, @RequestBody Usuario usuarioActualizado) throws UserNotFoundException {
        Usuario usuario = this.usuarioService.actualizarUsuario(userId, usuarioActualizado);
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    @DeleteMapping({"/{usuarioId}"})
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId) {
        this.usuarioService.eliminarUsuario(usuarioId);
    }
}
