package com.demo.models.enums;

public enum TipoConta {
   CONTA_CORRENTE(1), CONTA_INVESTIMENTO(2), CARTAO_DE_CREDITO(3), ALIMENTACAO(4), POUPANCA(5);

   private int tipoConta;

    TipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setIdTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public static TipoConta toEnum (Integer id){
        if(id==null) return null;
        for(TipoConta x : TipoConta.values()){
            if(id.equals(x.getTipoConta())){
                return x;
            }
        }
        throw new IllegalArgumentException("Tipo de conta invalida");
    }
}
