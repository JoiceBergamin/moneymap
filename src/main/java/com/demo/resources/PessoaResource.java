package com.demo.resources;

import com.demo.models.Pessoa;
import com.demo.models.dtos.BancoDTO;
import com.demo.models.dtos.PessoaDTO;
import com.demo.services.BancoService;
import com.demo.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll() {
        return ResponseEntity.ok().body(pessoaService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Integer id) {
        Pessoa obj = this.pessoaService.findbyId(id);
        return ResponseEntity.ok().body(new PessoaDTO(obj));
}
    @PostMapping
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaDTO dto){
        Pessoa  pessoa= pessoaService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
