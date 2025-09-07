package com.demo.security;

import com.demo.models.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class UserSS implements UserDetails {
    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;
    public UserSS(Usuario usuario){
        this.username = usuario.getEmailUsuario();
        this.password = usuario.getSenhaUsuario();
        this.authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    @Override
    public boolean isEnabled(){
        return true;
    }
}
