package com.demo.models.dtos;

import com.demo.models.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PessoaDTO {

    private Integer id;

    @NotBlank(message = "O campo razão social não pode estar vazio")
    @NotNull(message = "O campo razão social não pode ser nulo")
    private String razaoSocial;

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.razaoSocial = pessoa.getRazaoSocial();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "O campo razão social não pode estar vazio") @NotNull(message = "O campo razão social não pode ser nulo") String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotBlank(message = "O campo razão social não pode estar vazio") @NotNull(message = "O campo razão social não pode ser nulo") String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
