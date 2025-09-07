package com.demo.services;

import com.demo.models.Conta;
import com.demo.models.dtos.ContaDTO;
import com.demo.repositories.ContaRepository;
import com.demo.services.exceptions.DataIntegrityViolationException;
import com.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepo;

    public List<ContaDTO> findAll() {
        return contaRepo.findAll().stream().map
                (obj -> new ContaDTO(obj)).collect(Collectors.toList());
    }
    public Conta findbyId (Integer id){
        Optional<Conta> obj = contaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Conta não encontrado! Id: " + id));
    }

    public Conta create(ContaDTO dto) {
        dto.setId(null);
        validaNumero(dto);
        Conta obj = new Conta(dto);
        return contaRepo.save(obj);
    }

    public Conta findbyNumero(String numero){
        Optional<Conta> obj = contaRepo.findByNumero(numero);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Conta não encontrada! Numero: " + numero));
    }

    private void validaNumero(ContaDTO dto) {
        Optional<Conta> obj = contaRepo.findByNumero(dto.getNumero());

        if (obj.isPresent()) {

            if (dto.getId() == null || !obj.get().getId().equals(dto.getId())) {
                throw new DataIntegrityViolationException("Numero de conta já cadastrado!");
            }
        }

    }
    public Conta update(Integer id, ContaDTO objDto){
        objDto.setId(id);
        Conta oldObj = findbyId(id);
        oldObj = new Conta(objDto);
        return contaRepo.save(oldObj);
    }
    public void delete(Integer id) {
        Conta obj = findbyId(id);
        if (obj.getLancamentos().size() > 0) {
            throw new DataIntegrityViolationException("Conta não pode ser deletada pois possui Lançamentos vinculados!");
        }
        contaRepo.deleteById(id);
}
}

