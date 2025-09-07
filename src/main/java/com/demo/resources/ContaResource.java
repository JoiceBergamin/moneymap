package com.demo.resources;

import com.demo.models.Conta;
import com.demo.models.dtos.ContaDTO;
import com.demo.services.ContaService;
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
@RequestMapping(value = "/conta")
@Tag(name = "Contas", description = "API para gerenciamento de Contas")
public class ContaResource {

    @Autowired
    private ContaService contaService;

    @GetMapping
    @Operation(summary = "Lista todas as contas",
            description = "Retorna uma lista com todas as contas cadastradas")
    public ResponseEntity<List<ContaDTO>> findAll() {
        return ResponseEntity.ok().body(contaService.findAll());
    }
    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca uma conta por id",
            description = "Realiza a busca de uma conta por id")
    public ResponseEntity<ContaDTO> findById(@PathVariable Integer id) {
        Conta obj = this.contaService.findbyId(id);
        return ResponseEntity.ok().body(new ContaDTO(obj));
    }

    @GetMapping(value = "/numero/{numero}")
    @Operation(summary = "Busca uma conta pelo Numero",
            description = "Realiza a busca de uma conta por numero da conta")
        public ResponseEntity<ContaDTO> findById(@PathVariable String numero){
        Conta obj = this.contaService.findbyNumero(numero);
        return ResponseEntity.ok().body(new ContaDTO(obj));
    }

    @PostMapping
    @Operation(summary = "Cria uma nova conta",
            description = "Cria uma nova conta com base nos dados fornecidos")
    public ResponseEntity<ContaDTO> create(@Valid @RequestBody ContaDTO dto){
        Conta conta = contaService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(conta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    @Operation(summary = "Altera uma conta",
            description = "Altera uma conta existente")
    public ResponseEntity<ContaDTO> update(@PathVariable Integer id, @Valid @RequestBody ContaDTO objDto) {
        Conta Obj = contaService.update(id, objDto);
        return ResponseEntity.ok().body(new ContaDTO(Obj));
    }
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar uma conta",
            description = "Remove uma conta a partir do seu Id")
    public ResponseEntity<ContaDTO> delete(@PathVariable Integer id){
        contaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
