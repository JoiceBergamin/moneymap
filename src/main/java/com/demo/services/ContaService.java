package com.demo.services;

import com.demo.models.Conta;
import com.demo.models.dtos.ContaDTO;
import com.demo.repositories.ContaRepository;
import com.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepo;

    public List<ContaDTO> findAll() {
        return contaRepo.findAll().stream().map
                (obj -> new ContaDTO(obj)).collect(Collectors.toList());
    }
    public Conta findbyId (Integer id){
        Optional<Conta> obj = contaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Conta não encontrado! Id: " + id));
    }

    public Conta create(ContaDTO dto) {
        dto.setId(null);
        Conta obj = new Conta(dto);
        return contaRepo.save(obj);
    }
}
