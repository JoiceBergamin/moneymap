package com.demo.services;

import com.demo.models.*;
import com.demo.models.enums.Situacao;
import com.demo.models.enums.TipoConta;
import com.demo.models.enums.TipoLancamento;
import com.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private PessoaRepository pessoaRepo;
    @Autowired
    private CentroCustoRepository centroCustoRepo;
    @Autowired
    private BancoRepository bancoRepo;
    @Autowired
    private ContaRepository contaRepo;
    @Autowired
    private LancamentoRepository lancamentoRepo;

    public void initDB(){
        Pessoa pessoa01 = new Pessoa(0, "Fornecedor ABC");
        CentroCusto centroCusto01 = new CentroCusto(0, "Manutenção");
        Banco banco01 = new Banco(0, "Banco do Brasil");
        Conta conta01 = new Conta(0, "Conta Principal", TipoConta.POUPANCA, "1234", "5678-9", 1000.00, 5000.00,banco01);

        Lancamento lancamento01 = new Lancamento(
                0,"Compra de materiais", "1/1", LocalDate.now(), LocalDate.now(), LocalDate.now(), 1500.0, centroCusto01, pessoa01, conta01, TipoLancamento.DEBITO, Situacao.BAIXADO);

        pessoaRepo.save(pessoa01);
        centroCustoRepo.save(centroCusto01);
        bancoRepo.save(banco01);
        contaRepo.save(conta01);
        lancamentoRepo.save(lancamento01);

    }


}
