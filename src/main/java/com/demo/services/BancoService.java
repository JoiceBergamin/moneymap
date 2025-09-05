package com.demo.services;

import com.demo.models.Banco;
import com.demo.models.dtos.BancoDTO;
import com.demo.repositories.BancoRepository;
import com.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepo;

    public List<BancoDTO> findAll() {
        return bancoRepo.findAll().stream().map
                (obj -> new BancoDTO(obj)).collect(Collectors.toList());
    }

    public Banco findbyId(int id){
        Optional<Banco> obj = bancoRepo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Banco não Encontrado! Id: " + id));
    }

    public Banco create(BancoDTO dto) {
        dto.setId(null);
        Banco obj = new Banco(dto);
        return bancoRepo.save(obj);
    }
}
