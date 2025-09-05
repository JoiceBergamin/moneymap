package com.demo.resources;

import com.demo.models.Banco;
import com.demo.models.dtos.BancoDTO;
import com.demo.services.BancoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/banco")
public class BancoResource {

    @Autowired
    private BancoService bancoService;

    @GetMapping
    public ResponseEntity<List<BancoDTO>> findAll() {
        return ResponseEntity.ok().body(bancoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BancoDTO> findById(@PathVariable Integer id){
        Banco obj = this.bancoService.findbyId(id);
        return ResponseEntity.ok().body(new BancoDTO(obj));
    }
    @PostMapping
    public ResponseEntity<BancoDTO> create(@Valid @RequestBody BancoDTO dto) {
        Banco banco = bancoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(banco.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
