package com.demo.services;

import com.demo.models.dtos.BancoDTO;
import com.demo.models.dtos.LancamentoDTO;
import com.demo.repositories.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepo;

    public List<LancamentoDTO> findAll() {
        return lancamentoRepo.findAll().stream().map
                (obj -> new LancamentoDTO(obj)).collect(Collectors.toList());
    }

}
