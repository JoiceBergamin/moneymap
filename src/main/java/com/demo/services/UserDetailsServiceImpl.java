package com.demo.services;

import com.demo.models.Usuario;
import com.demo.repositories.UsuarioRepository;
import com.demo.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmailUsuario(email);
        if (usuario == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(usuario);
    }
}
