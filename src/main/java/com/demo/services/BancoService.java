package com.demo.services;

import com.demo.models.dtos.BancoDTO;
import com.demo.repositories.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepo;

    public List<BancoDTO> findAll() {
        return bancoRepo.findAll().stream().map
                (obj -> new BancoDTO(obj)).collect(Collectors.toList());
    }


}
