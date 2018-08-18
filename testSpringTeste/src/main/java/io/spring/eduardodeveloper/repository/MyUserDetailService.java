/*
 *
 * Eduardo Alexandre L Silva
 *
 * Projeto para fins Academicos
 * 
 *
 */
package io.spring.eduardodeveloper.repository;

import io.spring.eduardodeveloper.config.MyUserDetails;
import io.spring.eduardodeveloper.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author edr
 */


@Service
public class MyUserDetailService implements UserDetailsService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuário ou senha inválidos!!!");//Disparando uma exception
        }
        return new MyUserDetails(usuario);
    }
    
}
