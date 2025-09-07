package com.demo.models;

import com.demo.models.dtos.UsuarioDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    protected Integer idUsuario;

    protected String nomeUsuario;

    @Column(unique = true)
    protected String emailUsuario;
    protected String senhaUsuario;

    public Usuario() {
    }
    public Usuario(UsuarioDTO dto) {
        this.idUsuario = dto.getIdUsuario();
        this.nomeUsuario = dto.getNomeUsuario();
        this.emailUsuario = dto.getEmailUsuario();
        this.senhaUsuario = dto.getSenhaUsuario();
    }

    public Usuario(Integer idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idUsuario, usuario.idUsuario) && Objects.equals(nomeUsuario, usuario.nomeUsuario) && Objects.equals(emailUsuario, usuario.emailUsuario) && Objects.equals(senhaUsuario, usuario.senhaUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nomeUsuario, emailUsuario, senhaUsuario);
    }
}
