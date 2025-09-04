package com.demo.resources;

import com.demo.models.Banco;
import com.demo.models.dtos.BancoDTO;
import com.demo.services.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/banco")
public class BancoResource {

    @Autowired
    private BancoService bancoService;

    @GetMapping
    public ResponseEntity<List<BancoDTO>> findAll() {
        return ResponseEntity.ok().body(bancoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BancoDTO> findById(@PathVariable Integer id){
        Banco obj = this.bancoService.findbyId(id);
        return ResponseEntity.ok().body(new BancoDTO(obj));
    }
}
