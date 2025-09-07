package com.demo.resources;

import com.demo.models.CentroCusto;
import com.demo.models.dtos.BancoDTO;
import com.demo.models.dtos.CentroCustoDTO;
import com.demo.services.BancoService;
import com.demo.services.CentroCustoService;
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
@RequestMapping(value = "centrocusto")
@Tag(name = "Centro de custos", description = "API para gerenciamento de Centro de custos")
public class CentroCustoResource {

    @Autowired
    private CentroCustoService centroCustoService;

    @GetMapping
    @Operation(summary = "Lista todos os centro de custos",
            description = "Retorna uma lista com todos os centros de custos cadastrados")
    public ResponseEntity<List<CentroCustoDTO>> findAll() {
        return ResponseEntity.ok().body(centroCustoService.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um Centro de custo por id",
            description = "Realiza a busca de um centro de custo cadastrado por id")
    public ResponseEntity<CentroCustoDTO> findById(@PathVariable Integer id) {
        CentroCusto obj = this.centroCustoService.findbyId(id);
        return ResponseEntity.ok().body(new CentroCustoDTO(obj));
    }

    @PostMapping
    @Operation(summary = "Cria um novo centro de custo",
            description = "Cria um novo centro de custo com base nos dados fornecidos")
    public ResponseEntity<CentroCustoDTO> create(@Valid @RequestBody CentroCustoDTO dto){
        CentroCusto centroCusto = centroCustoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(centroCusto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    @Operation(summary = "Altera um centro de custo",
            description = "Altera um centro de custo existente")
    public ResponseEntity<CentroCustoDTO> update(@PathVariable Integer id, @Valid @RequestBody CentroCustoDTO objDto) {
        CentroCusto Obj = centroCustoService.update(id, objDto);
        return ResponseEntity.ok().body(new CentroCustoDTO(Obj));
    }
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar um centro de custo",
            description = "Remove um centro de custo a partir do seu Id")
    public ResponseEntity<CentroCustoDTO> delete(@PathVariable Integer id){
        centroCustoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
