package com.demo.resources;

import com.demo.models.Pessoa;
import com.demo.models.dtos.BancoDTO;
import com.demo.models.dtos.PessoaDTO;
import com.demo.services.BancoService;
import com.demo.services.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
@Tag(name = "Pessoas", description = "API para gerenciamento de pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    @Operation(summary = "Lista todas as pessoas",
            description = "Retorna uma lista com todas as pessoas cadastradas")
    public ResponseEntity<List<PessoaDTO>> findAll() {
        return ResponseEntity.ok().body(pessoaService.findAll());
    }
    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca uma pessoa por id",
            description = "Realiza a busca de uma pessoa cadastrada por id")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Integer id) {
        Pessoa obj = this.pessoaService.findbyId(id);
        return ResponseEntity.ok().body(new PessoaDTO(obj));
}
    @PostMapping
    @Operation(summary = "Cria uma nova pessoa",
            description = "Cria um novo pessoa com base nos dados fornecidos")
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaDTO dto){
        Pessoa  pessoa= pessoaService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    @Operation(summary = "Altera uma pessoa",
            description = "Altera uma pessoa existente")
    public ResponseEntity<PessoaDTO> update(@PathVariable Integer id, @Valid @RequestBody PessoaDTO objDto) {
        Pessoa Obj = pessoaService.update(id, objDto);
        return ResponseEntity.ok().body(new PessoaDTO(Obj));
    }
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleta uma pessoa",
            description = "Remove uma pessoa a partir do seu Id")
    public ResponseEntity<PessoaDTO> delete(@PathVariable Integer id){
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
