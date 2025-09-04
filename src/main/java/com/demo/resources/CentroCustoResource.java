package com.demo.resources;

import com.demo.models.dtos.BancoDTO;
import com.demo.models.dtos.CentroCustoDTO;
import com.demo.services.BancoService;
import com.demo.services.CentroCustoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "centrocusto")
public class CentroCustoResource {

    @Autowired
    private CentroCustoService centroCustoService;

    @GetMapping
    public ResponseEntity<List<CentroCustoDTO>> findAll() {
        return ResponseEntity.ok().body(centroCustoService.findAll());
    }
}
