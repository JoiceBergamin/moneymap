package com.demo.models;

import com.demo.models.dtos.ContaDTO;
import com.demo.models.enums.TipoConta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contas")
    private Integer id;

    @NotNull @NotBlank
    private String descricao;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "tipoConta")
    private TipoConta tipoConta;

    @NotNull @NotBlank
    private String agencia;

    @NotNull @NotBlank
    private String numero;

    @NotNull
    private Double limite;

    @NotNull
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "idBanco")
    private Banco banco;

    @JsonIgnore
    @OneToMany(mappedBy = "conta")
    private List<Lancamento> lancamentos = new ArrayList<>();

    public Conta() {
    }

    public Conta(Integer id, String descricao, TipoConta tipoConta, String agencia, String numero, Double limite, Double saldo, Banco banco) {
        this.id = id;
        this.descricao = descricao;
        this.tipoConta = tipoConta;
        this.agencia = agencia;
        this.numero = numero;
        this.limite = limite;
        this.saldo = saldo;
        this.banco = banco;
    }

    public Conta (ContaDTO dto){
        this.id = dto.getId();
        this.descricao = dto.getDescricao();
        this.tipoConta = dto.getTipoConta();
        this.agencia = dto.getAgencia();
        this.numero = dto.getNumero();
        this.limite = dto.getLimite();
        this.saldo = dto.getSaldo();
        this.banco = new Banco();
        this.banco.setId(dto.getBancoId());
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return id == conta.id && Objects.equals(descricao, conta.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }
}
