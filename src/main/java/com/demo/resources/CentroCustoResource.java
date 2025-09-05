package com.demo.resources;

import com.demo.models.CentroCusto;
import com.demo.models.dtos.BancoDTO;
import com.demo.models.dtos.CentroCustoDTO;
import com.demo.services.BancoService;
import com.demo.services.CentroCustoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "centrocusto")
public class CentroCustoResource {

    @Autowired
    private CentroCustoService centroCustoService;

    @GetMapping
    public ResponseEntity<List<CentroCustoDTO>> findAll() {
        return ResponseEntity.ok().body(centroCustoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CentroCustoDTO> findById(@PathVariable Integer id) {
        CentroCusto obj = this.centroCustoService.findbyId(id);
        return ResponseEntity.ok().body(new CentroCustoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<CentroCustoDTO> create(@Valid @RequestBody CentroCustoDTO dto){
        CentroCusto centroCusto = centroCustoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(centroCusto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
