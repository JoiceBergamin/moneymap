package com.demo.services;

import com.demo.models.Lancamento;
import com.demo.models.Pessoa;
import com.demo.models.dtos.BancoDTO;
import com.demo.models.dtos.LancamentoDTO;
import com.demo.models.dtos.PessoaDTO;
import com.demo.repositories.LancamentoRepository;
import com.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepo;

    public List<LancamentoDTO> findAll() {
        return lancamentoRepo.findAll().stream().map
                (obj -> new LancamentoDTO(obj)).collect(Collectors.toList());
    }
    public Lancamento findbyId (Integer id){
        Optional<Lancamento> obj = lancamentoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Lancamento não encontrado! Id: " + id));
    }

}
