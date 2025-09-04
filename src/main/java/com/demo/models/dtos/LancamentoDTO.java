package com.demo.models.dtos;

import com.demo.models.Lancamento;
import com.demo.models.enums.Situacao;
import com.demo.models.enums.TipoLancamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class LancamentoDTO {

    private Integer id;

    @NotNull(message = "O campo descricao não pode ser nulo")
    @NotBlank(message = "O campo descricao não pode estar vazio")
    private String descricao;

    @NotNull(message = "O campo Parcela não pode ser nulo")
    @NotBlank(message = "O campo Parcela não pode estar vazio")
    private String parcela;

    @NotNull(message = "O campo dataLancamento é obrigatório")
    private LocalDate dataLancamento;

    private LocalDate dataVencimento;

    private LocalDate dataBaixa;

    @NotNull(message = "O campo valorDocumento é obrigatório")
    private Double valorDocumento;

    @NotNull(message = "O campo centroCustoId é obrigatório")
    private Integer centroCustoId;
    private String centroCustoDescricao;

    @NotNull(message = "O campo pessoaId é obrigatório")
    private Integer pessoaId;
    private String pessoaRazaoSocial;

    @NotNull(message = "O campo contaId é obrigatório")
    private Integer contaId;
    private String contaDescricao;

    @NotNull(message = "O campo tipoLancamento é obrigatório")
    private TipoLancamento tipoLancamento;

    @NotNull(message = "O campo situacao é obrigatório")
    private Situacao situacao;

    public LancamentoDTO() {
    }

    public LancamentoDTO(Lancamento lancamento) {
        this.id = lancamento.getId();
        this.descricao = lancamento.getDescricao();
        this.parcela = lancamento.getParcela();
        this.dataLancamento = lancamento.getDataLancamento();
        this.dataVencimento = lancamento.getDataVencimento();
        this.dataBaixa = lancamento.getDataBaixa();
        this.valorDocumento = lancamento.getValorDocumento();
        this.centroCustoId = lancamento.getCentroCusto().getId();
        this.centroCustoDescricao = lancamento.getCentroCusto().getDescricao();
        this.pessoaId = lancamento.getPessoa().getId();
        this.pessoaRazaoSocial = lancamento.getPessoa().getRazaoSocial();
        this.contaId = lancamento.getConta().getId();
        this.contaDescricao = lancamento.getConta().getDescricao();
        this.tipoLancamento = lancamento.getTipoLancamento();
        this.situacao = lancamento.getSituacao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "O campo descricao não pode ser nulo") @NotBlank(message = "O campo descricao não pode estar vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descricao não pode ser nulo") @NotBlank(message = "O campo descricao não pode estar vazio") String descricao) {
        this.descricao = descricao;
    }

    public @NotNull(message = "O campo Parcela não pode ser nulo") @NotBlank(message = "O campo Parcela não pode estar vazio") String getParcela() {
        return parcela;
    }

    public void setParcela(@NotNull(message = "O campo Parcela não pode ser nulo") @NotBlank(message = "O campo Parcela não pode estar vazio") String parcela) {
        this.parcela = parcela;
    }

    public @NotNull(message = "O campo dataLancamento é obrigatório") LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(@NotNull(message = "O campo dataLancamento é obrigatório") LocalDate dataLancamento) {
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

    public @NotNull(message = "O campo valorDocumento é obrigatório") Double getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(@NotNull(message = "O campo valorDocumento é obrigatório") Double valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public @NotNull(message = "O campo centroCustoId é obrigatório") Integer getCentroCustoId() {
        return centroCustoId;
    }

    public void setCentroCustoId(@NotNull(message = "O campo centroCustoId é obrigatório") Integer centroCustoId) {
        this.centroCustoId = centroCustoId;
    }

    public String getCentroCustoDescricao() {
        return centroCustoDescricao;
    }

    public void setCentroCustoDescricao(String centroCustoDescricao) {
        this.centroCustoDescricao = centroCustoDescricao;
    }

    public @NotNull(message = "O campo pessoaId é obrigatório") Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(@NotNull(message = "O campo pessoaId é obrigatório") Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getPessoaRazaoSocial() {
        return pessoaRazaoSocial;
    }

    public void setPessoaRazaoSocial(String pessoaRazaoSocial) {
        this.pessoaRazaoSocial = pessoaRazaoSocial;
    }

    public @NotNull(message = "O campo contaId é obrigatório") Integer getContaId() {
        return contaId;
    }

    public void setContaId(@NotNull(message = "O campo contaId é obrigatório") Integer contaId) {
        this.contaId = contaId;
    }

    public String getContaDescricao() {
        return contaDescricao;
    }

    public void setContaDescricao(String contaDescricao) {
        this.contaDescricao = contaDescricao;
    }

    public @NotNull(message = "O campo tipoLancamento é obrigatório") TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(@NotNull(message = "O campo tipoLancamento é obrigatório") TipoLancamento tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public @NotNull(message = "O campo situacao é obrigatório") Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(@NotNull(message = "O campo situacao é obrigatório") Situacao situacao) {
        this.situacao = situacao;
    }
}
