package com.demo.services;

import com.demo.models.*;
import com.demo.models.enums.Situacao;
import com.demo.models.enums.TipoConta;
import com.demo.models.enums.TipoLancamento;
import com.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private UsuarioRepository usuarioRepo;
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

    @Autowired
    private PasswordEncoder encoder;

    public void initDB(){

        Usuario usuario01 = new Usuario(null, "Richard", "richard@email.com", encoder.encode("1234"));
        Pessoa pessoa01 = new Pessoa(null, "Fornecedor ABC");
        CentroCusto centroCusto01 = new CentroCusto(null, "Manutenção");
        Banco banco01 = new Banco(null, "Banco do Brasil");
        Conta conta01 = new Conta(null, "Conta Principal", TipoConta.POUPANCA, "1234", "5678-9", 1000.00, 5000.00,banco01);

        Lancamento lancamento01 = new Lancamento(
                null,"Compra de materiais", "1/1", LocalDate.now(), LocalDate.now(), LocalDate.now(), 1500.0, centroCusto01, pessoa01, conta01, TipoLancamento.DEBITO, Situacao.BAIXADO);

        usuarioRepo.save(usuario01);
        pessoaRepo.save(pessoa01);
        centroCustoRepo.save(centroCusto01);
        bancoRepo.save(banco01);
        contaRepo.save(conta01);
        lancamentoRepo.save(lancamento01);

    }


}
