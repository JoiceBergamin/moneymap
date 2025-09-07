package com.demo.resources;

import com.demo.models.Banco;
import com.demo.models.dtos.BancoDTO;
import com.demo.services.BancoService;
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
@RequestMapping(value = "/banco")
@Tag(name = "Banco", description = "API para gerenciamento de Grupo de Bancos")
public class BancoResource {

    @Autowired
    private BancoService bancoService;

    @GetMapping
    @Operation(summary = "Lista todos os bancos",
            description = "Retorna uma lista com todos os bancos cadastrados")
    public ResponseEntity<List<BancoDTO>> findAll() {
        return ResponseEntity.ok().body(bancoService.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um banco por id",
            description = "Realiza a busca de um banco cadastrado por id")
    public ResponseEntity<BancoDTO> findById(@PathVariable Integer id){
        Banco obj = this.bancoService.findbyId(id);
        return ResponseEntity.ok().body(new BancoDTO(obj));
    }
    @PostMapping
    @Operation(summary = "Cria um novo banco",
            description = "Cria um novo banco com base nos dados fornecidos")
    public ResponseEntity<BancoDTO> create(@Valid @RequestBody BancoDTO dto) {
        Banco banco = bancoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(banco.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    @Operation(summary = "Altera um banco",
            description = "Altera um banco existente")
    public ResponseEntity<BancoDTO> update(@PathVariable Integer id, @Valid @RequestBody BancoDTO objDto) {
        Banco Obj = bancoService.update(id, objDto);
        return ResponseEntity.ok().body(new BancoDTO(Obj));
    }
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar um banco",
            description = "Remove um banco a partir do seu Id")
    public ResponseEntity<BancoDTO> delete(@PathVariable Integer id){
        bancoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
