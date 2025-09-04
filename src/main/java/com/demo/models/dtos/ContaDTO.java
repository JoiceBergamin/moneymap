package com.demo.models.dtos;

import com.demo.models.Conta;
import com.demo.models.enums.TipoConta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ContaDTO {

    private Integer id;

    @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode estar vazio")
    private String descricao;

    @NotNull(message = "O campo tipoConta é obrigatório")
    private TipoConta tipoConta;

    @NotNull(message = "O campo agência não pode ser nulo")
    @NotBlank(message = "O campo agência não pode estar vazio")
    private String agencia;

    @NotNull(message = "O campo numero não pode ser nulo")
    @NotBlank(message = "O campo número não pode estar vazio")
    private String numero;

    @NotNull(message = "O campo limite é obrigatório")
    private Double limite;

    @NotNull(message = "O campo saldo é obrigatório")
    private Double saldo;

    @NotNull(message = "O campo bancoId é obrigatório")
    private Integer bancoId;
    private String bancoRazaoSocial;

    public ContaDTO() {
    }

    public ContaDTO(Conta conta) {
        this.id = conta.getId();
        this.descricao = conta.getDescricao();
        this.tipoConta = conta.getTipoConta();
        this.agencia = conta.getAgencia();
        this.numero = conta.getNumero();
        this.limite = conta.getLimite();
        this.saldo = conta.getSaldo();
        this.bancoId = conta.getBanco().getId();
        this.bancoRazaoSocial = conta.getBanco().getRazaoSocial();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "O campo descrição não pode ser nulo") @NotBlank(message = "O campo descrição não pode estar vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descrição não pode ser nulo") @NotBlank(message = "O campo descrição não pode estar vazio") String descricao) {
        this.descricao = descricao;
    }

    public @NotNull(message = "O campo tipoConta é obrigatório") TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(@NotNull(message = "O campo tipoConta é obrigatório") TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public @NotNull(message = "O campo agência não pode ser nulo") @NotBlank(message = "O campo agência não pode estar vazio") String getAgencia() {
        return agencia;
    }

    public void setAgencia(@NotNull(message = "O campo agência não pode ser nulo") @NotBlank(message = "O campo agência não pode estar vazio") String agencia) {
        this.agencia = agencia;
    }

    public @NotNull(message = "O campo numero não pode ser nulo") @NotBlank(message = "O campo número não pode estar vazio") String getNumero() {
        return numero;
    }

    public void setNumero(@NotNull(message = "O campo numero não pode ser nulo") @NotBlank(message = "O campo número não pode estar vazio") String numero) {
        this.numero = numero;
    }

    public @NotNull(message = "O campo limite é obrigatório") Double getLimite() {
        return limite;
    }

    public void setLimite(@NotNull(message = "O campo limite é obrigatório") Double limite) {
        this.limite = limite;
    }

    public @NotNull(message = "O campo saldo é obrigatório") Double getSaldo() {
        return saldo;
    }

    public void setSaldo(@NotNull(message = "O campo saldo é obrigatório") Double saldo) {
        this.saldo = saldo;
    }

    public @NotNull(message = "O campo bancoId é obrigatório") Integer getBancoId() {
        return bancoId;
    }

    public void setBancoId(@NotNull(message = "O campo bancoId é obrigatório") Integer bancoId) {
        this.bancoId = bancoId;
    }

    public String getBancoRazaoSocial() {
        return bancoRazaoSocial;
    }

    public void setBancoRazaoSocial(String bancoRazaoSocial) {
        this.bancoRazaoSocial = bancoRazaoSocial;
    }
}
