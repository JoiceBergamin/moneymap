package com.demo.models.dtos;

import com.demo.models.Banco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BancoDTO {

    private Integer id;

    @NotBlank(message = "O campo Razão Social não pode estar vazio")
    @NotNull(message = "O campo Razão Social não pode ser nulo")
    private String razaoSocial;

    public BancoDTO() {
    }

    public BancoDTO(Banco banco) {
        this.id = banco.getId();
        this.razaoSocial = banco.getRazaoSocial();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "O campo Razão Social não pode estar vazio") @NotNull(message = "O campo Razão Social não pode ser nulo") String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotBlank(message = "O campo Razão Social não pode estar vazio") @NotNull(message = "O campo Razão Social não pode ser nulo") String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
