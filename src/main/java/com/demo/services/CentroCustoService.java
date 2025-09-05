package com.demo.services;

import com.demo.models.CentroCusto;
import com.demo.models.dtos.CentroCustoDTO;
import com.demo.repositories.CentroCustoRepository;
import com.demo.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CentroCustoService {

    @Autowired
    private CentroCustoRepository centroCustoRepo;

    public List<CentroCustoDTO> findAll() {
        return centroCustoRepo.findAll().stream().map
                (obj -> new CentroCustoDTO(obj)).collect(Collectors.toList());
    }

    public CentroCusto findbyId (Integer id){
        Optional<CentroCusto> obj = centroCustoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Centro Custo não encontrado! Id: " +id));
    }
    public CentroCusto create(CentroCustoDTO dto) {
        dto.setId(null);
        CentroCusto obj = new CentroCusto(dto);
        return centroCustoRepo.save(obj);
    }
}
