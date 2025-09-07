package com.demo.models.dtos;

import com.demo.models.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioDTO {
    private Integer idUsuario;

    @NotNull(message = "O campo nome do usuário não pode ser nulo")
    @NotBlank(message = "O campo nome do usuário não pode estar vazio")
    private String nomeUsuario;

    @NotNull(message = "O campo nome do emailUsuário não pode ser nulo")
    @NotBlank(message = "O campo email do usuário não pode estar vazio")
    private String emailUsuario;

    @NotNull(message = "O campo senha não pode ser nulo")
    @NotBlank(message = "O campo senha não pode estar vazio")
    private String senhaUsuario;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nomeUsuario = usuario.getNomeUsuario();
        this.emailUsuario = usuario.getEmailUsuario();
        this.senhaUsuario = usuario.getSenhaUsuario();
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
}
