package com.demo.resources;

import com.demo.models.Usuario;
import com.demo.models.dtos.UsuarioDTO;
import com.demo.services.UsuarioService;
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
@RequestMapping(value = "/usuario")
@Tag(name = "Pessoas", description = "API para gerenciamento de pessoas")
public class UsuarioResource {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @Operation(summary = "Listar todos os usuarios",
            description = "Retorna uma lista com todos usuarios cadastrados")
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um usuario por id",
            description = "Realiza a busca de um usuario cadastrado por id")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id) {
        Usuario obj = this.usuarioService.findbyId(id);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }
    @PostMapping
    @Operation(summary = "Cria um novo usuario",
            description = "Cria um novo usuario com base nos dados fornecidos")
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO dto){
        Usuario usuario = usuarioService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    @Operation(summary = "Altera um usuario",
            description = "Altera um usuario existente")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @Valid @RequestBody UsuarioDTO objDto) {
        Usuario Obj = usuarioService.update(id, objDto);
        return ResponseEntity.ok().body(new UsuarioDTO(Obj));
    }
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleta um usuario",
            description = "Remove um usuario a partir do seu Id")
    public ResponseEntity<UsuarioDTO> delete(@PathVariable Integer id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
