package com.demo.models.enums;

public enum TipoLancamento {
    CREDITO (1), DEBITO(2);

    private Integer tipoLancamento;

    TipoLancamento(Integer tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public Integer getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(int tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public static TipoLancamento toEnum (Integer id){
        if(id==null) return null;
        for(TipoLancamento x : TipoLancamento.values()){
            if(id.equals(x.getTipoLancamento())){
                return x;
            }
        }
        throw new IllegalArgumentException("Tipo Lancamento invalido");
    }
}
