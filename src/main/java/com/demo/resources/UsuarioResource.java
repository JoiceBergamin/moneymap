package com.demo.resources;

import com.demo.models.Usuario;
import com.demo.models.dtos.UsuarioDTO;
import com.demo.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id) {
        Usuario obj = this.usuarioService.findbyId(id);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }
    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO dto){
        Usuario usuario = usuarioService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @Valid @RequestBody UsuarioDTO objDto) {
        Usuario Obj = usuarioService.update(id, objDto);
        return ResponseEntity.ok().body(new UsuarioDTO(Obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> delete(@PathVariable Integer id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
