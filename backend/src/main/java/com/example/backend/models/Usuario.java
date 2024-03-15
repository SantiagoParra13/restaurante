package com.example.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "usuarios"
)
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private boolean enabled = true;
    private String email;
    @OneToMany(
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER,
            mappedBy = "usuario"
    )
    @JsonIgnore
    private Set<UsuarioRol> usuarioRoles = new HashSet();

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autoridades = new HashSet();
        this.usuarioRoles.forEach((usuarioRol) -> {
            autoridades.add(new Authority(usuarioRol.getRol().getRolNombre()));
        });
        return autoridades;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return this.usuarioRoles;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(final String apellido) {
        this.apellido = apellido;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @JsonIgnore
    public void setUsuarioRoles(final Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    public Usuario() {
    }

    public Usuario(final Long id, final String username, final String password, final String nombre, final String apellido, final boolean enabled, final String email, final Set<UsuarioRol> usuarioRoles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.enabled = enabled;
        this.email = email;
        this.usuarioRoles = usuarioRoles;
    }
}

