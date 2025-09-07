package com.demo.services;

import com.demo.models.Pessoa;
import com.demo.models.dtos.BancoDTO;
import com.demo.models.dtos.PessoaDTO;
import com.demo.repositories.PessoaRepository;
import com.demo.services.exceptions.DataIntegrityViolationException;
import com.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepo;

    public List<PessoaDTO> findAll() {
        return pessoaRepo.findAll().stream().map
                (obj -> new PessoaDTO(obj)).collect(Collectors.toList());
    }

    public Pessoa findbyId (Integer id){
        Optional<Pessoa> obj = pessoaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrado! Id: " + id));
    }

    public Pessoa create(PessoaDTO dto) {
        dto.setId(null);
        Pessoa obj = new Pessoa(dto);
        return pessoaRepo.save(obj);
    }
    public Pessoa update(Integer id, PessoaDTO objDto){
        objDto.setId(id);
        Pessoa oldObj = findbyId(id);
        oldObj = new Pessoa(objDto);
        return pessoaRepo.save(oldObj);
    }
    public void delete(Integer id) {
        Pessoa obj = findbyId(id);
        if (obj.getLancamentos().size() > 0) {
            throw new DataIntegrityViolationException("Pessoa não pode ser deletada pois possui Lançamentos vinculados!");
        }
        pessoaRepo.deleteById(id);
}}
