package com.demo.resources;

import com.demo.models.Conta;
import com.demo.models.dtos.BancoDTO;
import com.demo.models.dtos.ContaDTO;
import com.demo.services.BancoService;
import com.demo.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
