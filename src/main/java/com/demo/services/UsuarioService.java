package com.demo.services;

import com.demo.models.Usuario;
import com.demo.models.dtos.UsuarioDTO;
import com.demo.repositories.UsuarioRepository;
import com.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PasswordEncoder encoder;

    public List<UsuarioDTO> findAll() {
        return usuarioRepo.findAll().stream().map
                (obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
    }
    public Usuario findbyId (Integer id){
        Optional<Usuario> obj = usuarioRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado! Id: " + id));
    }
    public Usuario create(UsuarioDTO objDto) {
        objDto.setIdUsuario(null);
        objDto.setSenhaUsuario(encoder.encode(objDto.getSenhaUsuario()));
        Usuario obj = new Usuario(objDto);
        return usuarioRepo.save(obj);
    }
    public Usuario update(Integer id, UsuarioDTO objDto){
        objDto.setIdUsuario(id);
        Usuario oldObj = findbyId(id);
        oldObj = new Usuario(objDto);
        return usuarioRepo.save(oldObj);
    }
    public void delete(Integer id){
        Usuario obj = findbyId(id);
        usuarioRepo.deleteById(id);
    }
}
