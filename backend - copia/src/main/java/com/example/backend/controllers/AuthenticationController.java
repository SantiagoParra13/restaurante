package com.example.backend.controllers;


import com.example.backend.config.JwtUtils;
import com.example.backend.exceptions.UserNotFoundException;
import com.example.backend.models.JwtRequest;
import com.example.backend.models.JwtResponse;
import com.example.backend.models.Usuario;
import com.example.backend.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping
@CrossOrigin({"*"})
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsImpl userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;

    public AuthenticationController() {
    }

    @PostMapping({"/generate-token"})
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            this.autenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (UserNotFoundException var4) {
            var4.printStackTrace();
            throw new Exception("Usuario no encontrado");
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void autenticar(String username, String password) throws Exception {
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException var4) {
            throw new Exception("USUARIO DESHABILITADO " + var4.getMessage());
        } catch (BadCredentialsException var5) {
            throw new Exception("Credenciales invalidas " + var5.getMessage());
        }
    }

    @GetMapping({"/actual-usuario"})
    public Usuario obtenerUsuarioActual(Principal principal) {
        return (Usuario)this.userDetailsService.loadUserByUsername(principal.getName());
    }
}
