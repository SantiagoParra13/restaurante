package com.example.backend.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "roles"
)
public class Rol {
    @Id
    private Long rolId;
    private String rolNombre;
    @OneToMany(
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY,
            mappedBy = "rol"
    )
    private Set<UsuarioRol> usuarioRoles = new HashSet();

    public Long getRolId() {
        return this.rolId;
    }

    public String getRolNombre() {
        return this.rolNombre;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return this.usuarioRoles;
    }

    public void setRolId(final Long rolId) {
        this.rolId = rolId;
    }

    public void setRolNombre(final String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public void setUsuarioRoles(final Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    public Rol(final Long rolId, final String rolNombre, final Set<UsuarioRol> usuarioRoles) {
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.usuarioRoles = usuarioRoles;
    }

    public Rol() {
    }
}