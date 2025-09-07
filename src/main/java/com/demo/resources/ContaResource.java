package com.demo.resources;

import com.demo.models.Conta;
import com.demo.models.dtos.ContaDTO;
import com.demo.services.ContaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/conta")
public class ContaResource {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<ContaDTO>> findAll() {
        return ResponseEntity.ok().body(contaService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ContaDTO> findById(@PathVariable Integer id) {
        Conta obj = this.contaService.findbyId(id);
        return ResponseEntity.ok().body(new ContaDTO(obj));
    }

    @GetMapping(value = "/numero/{numero}")
        public ResponseEntity<ContaDTO> findById(@PathVariable String numero){
        Conta obj = this.contaService.findbyNumero(numero);
        return ResponseEntity.ok().body(new ContaDTO(obj));
    }

    @PostMapping
    public ResponseEntity<ContaDTO> create(@Valid @RequestBody ContaDTO dto){
        Conta conta = contaService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(conta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
