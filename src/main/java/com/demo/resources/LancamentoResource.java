package com.demo.resources;

import com.demo.models.Lancamento;
import com.demo.models.Pessoa;
import com.demo.models.dtos.BancoDTO;
import com.demo.models.dtos.LancamentoDTO;
import com.demo.models.dtos.PessoaDTO;
import com.demo.services.LancamentoService;
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
@RequestMapping(value = "/lancamento")
@Tag(name = "Lançamento", description = "API para gerenciamento de Lançamentos")
public class LancamentoResource {

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping
    @Operation(summary = "Lista todos os lançamentos",
            description = "Retorna uma lista com todos os lançamentos cadastrados")
    public ResponseEntity<List<LancamentoDTO>> findAll() {
        return ResponseEntity.ok().body(lancamentoService.findAll());
    }
    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um lançamento por id",
            description = "Realiza a busca de um lançamento cadastrado por id")
    public ResponseEntity<LancamentoDTO> findById(@PathVariable Integer id) {
        Lancamento obj = this.lancamentoService.findbyId(id);
        return ResponseEntity.ok().body(new LancamentoDTO(obj));
    }
    @PostMapping
    @Operation(summary = "Cria um novo lançamento",
            description = "Cria um novo lançamento com base nos dados fornecidos")
    public ResponseEntity<LancamentoDTO> create(@Valid @RequestBody LancamentoDTO dto){
        Lancamento lancamento = lancamentoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lancamento.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    @Operation(summary = "Altera um lançamento",
            description = "Altera um lançamento existente")
    public ResponseEntity<LancamentoDTO> update(@PathVariable Integer id, @Valid @RequestBody LancamentoDTO objDto) {
        Lancamento Obj = lancamentoService.update(id, objDto);
        return ResponseEntity.ok().body(new LancamentoDTO(Obj));
    }
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar um lançamento",
            description = "Remove um lançamento a partir do seu Id")
    public ResponseEntity<LancamentoDTO> delete(@PathVariable Integer id){
        lancamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
