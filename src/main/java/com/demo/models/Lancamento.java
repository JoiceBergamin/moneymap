package com.demo.models;

import com.demo.models.enums.Situacao;
import com.demo.models.enums.TipoLancamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "lancamentos")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lancamentos")
    private Integer id;

    @NotNull @NotBlank
    private String descricao;

    @NotNull @NotBlank
    private String parcela;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLancamento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVencimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataBaixa;

    @NotNull
    private Double valorDocumento;

    @ManyToOne
    @JoinColumn(name = "centrocusto")
    private CentroCusto centroCusto;

    @ManyToOne
    @JoinColumn(name = "pessoa")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "conta")
    private Conta conta;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name="tipolancamento")
    private TipoLancamento tipoLancamento;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name="situacao")
    private Situacao situacao;

    public Lancamento() {
    }

    public Lancamento(Integer id, String descricao, String parcela, LocalDate dataLancamento, LocalDate dataVencimento, LocalDate dataBaixa, Double valorDocumento, CentroCusto centroCusto, Pessoa pessoa, Conta conta, TipoLancamento tipoLancamento, Situacao situacao) {
        this.id = id;
        this.descricao = descricao;
        this.parcela = parcela;
        this.dataLancamento = dataLancamento;
        this.dataVencimento = dataVencimento;
        this.dataBaixa = dataBaixa;
        this.valorDocumento = valorDocumento;
        this.centroCusto = centroCusto;
        this.pessoa = pessoa;
        this.conta = conta;
        this.tipoLancamento = tipoLancamento;
        this.situacao = situacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull @NotBlank String descricao) {
        this.descricao = descricao;
    }

    public @NotNull @NotBlank String getParcela() {
        return parcela;
    }

    public void setParcela(@NotNull @NotBlank String parcela) {
        this.parcela = parcela;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(LocalDate dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public @NotNull Double getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(@NotNull Double valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public CentroCusto getCentroCusto() {
        return centroCusto;
    }

    public void setCentroCusto(CentroCusto centroCusto) {
        this.centroCusto = centroCusto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(TipoLancamento tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lancamento that = (Lancamento) o;
        return id == that.id && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }
}

