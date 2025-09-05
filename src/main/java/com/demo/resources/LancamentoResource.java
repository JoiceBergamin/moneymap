package com.demo.resources;

import com.demo.models.Lancamento;
import com.demo.models.Pessoa;
import com.demo.models.dtos.BancoDTO;
import com.demo.models.dtos.LancamentoDTO;
import com.demo.models.dtos.PessoaDTO;
import com.demo.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping(value = "/{id}")
    public ResponseEntity<LancamentoDTO> findById(@PathVariable Integer id) {
        Lancamento obj = this.lancamentoService.findbyId(id);
        return ResponseEntity.ok().body(new LancamentoDTO(obj));
    }
}
