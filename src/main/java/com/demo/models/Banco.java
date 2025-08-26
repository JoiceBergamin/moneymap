package com.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "bancos")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bancos")
    private int id;

    @NotNull @NotBlank
    private String razaoSocial;

    public Banco() {
    }

    public Banco(int id, String razaoSocial) {
        this.id = id;
        this.razaoSocial = razaoSocial;
    }

    public @NotNull @NotBlank String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotNull @NotBlank String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return id == banco.id && Objects.equals(razaoSocial, banco.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, razaoSocial);
    }
}
