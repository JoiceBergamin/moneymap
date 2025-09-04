package com.demo.resources;

import com.demo.models.dtos.BancoDTO;
import com.demo.models.dtos.LancamentoDTO;
import com.demo.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lancamento")
public class LancamentoResource {

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping
    public ResponseEntity<List<LancamentoDTO>> findAll() {
        return ResponseEntity.ok().body(lancamentoService.findAll());
    }
}
