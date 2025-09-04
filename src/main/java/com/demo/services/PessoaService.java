package com.demo.services;

import com.demo.models.dtos.BancoDTO;
import com.demo.models.dtos.PessoaDTO;
import com.demo.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepo;

    public List<PessoaDTO> findAll() {
        return pessoaRepo.findAll().stream().map
                (obj -> new PessoaDTO(obj)).collect(Collectors.toList());
    }


}
