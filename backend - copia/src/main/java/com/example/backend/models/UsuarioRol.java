package com.example.backend.models;


import javax.persistence.*;

@Entity
public class UsuarioRol {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long usuarioRolId;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    private Usuario usuario;
    @ManyToOne
    private Rol rol;

    public Long getUsuarioRolId() {
        return this.usuarioRolId;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public Rol getRol() {
        return this.rol;
    }

    public void setUsuarioRolId(final Long usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    public void setUsuario(final Usuario usuario) {
        this.usuario = usuario;
    }

    public void setRol(final Rol rol) {
        this.rol = rol;
    }

    public UsuarioRol(final Long usuarioRolId, final Usuario usuario, final Rol rol) {
        this.usuarioRolId = usuarioRolId;
        this.usuario = usuario;
        this.rol = rol;
    }

    public UsuarioRol() {
    }
}
