package com.demo.services;

import com.demo.models.dtos.CentroCustoDTO;
import com.demo.repositories.CentroCustoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CentroCustoService {

    @Autowired
    private CentroCustoRepository centroCustoRepo;

    public List<CentroCustoDTO> findAll() {
        return centroCustoRepo.findAll().stream().map
                (obj -> new CentroCustoDTO(obj)).collect(Collectors.toList());
    }
}
