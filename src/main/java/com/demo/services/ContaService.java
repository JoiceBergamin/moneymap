package com.demo.services;

import com.demo.models.dtos.BancoDTO;
import com.demo.models.dtos.ContaDTO;
import com.demo.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepo;

    public List<ContaDTO> findAll() {
        return contaRepo.findAll().stream().map
                (obj -> new ContaDTO(obj)).collect(Collectors.toList());
    }
}
