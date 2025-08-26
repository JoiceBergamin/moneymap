package com.demo.models.enums;

public enum Situacao {
    ABERTO (1), BAIXADO(2);

    private int situacao;

    Situacao(int situacao) {
        this.situacao = situacao;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public static Situacao toEnum (Integer id){
        if(id==null) return null;
        for(Situacao x : Situacao.values()){
            if(id.equals(x.getSituacao())){
                return x;
            }
        }
        throw new IllegalArgumentException("Situacao invalida");
}
}
