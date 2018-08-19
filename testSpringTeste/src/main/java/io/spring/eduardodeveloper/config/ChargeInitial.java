/*
 *
 * Eduardo Alexandre L Silva
 *
 * Projeto para fins Academicos
 * 
 *
 */
package io.spring.eduardodeveloper.config;

import io.spring.eduardodeveloper.entity.Perfil;
import io.spring.eduardodeveloper.entity.Usuario;
import io.spring.eduardodeveloper.repository.PerfilRepository;
import io.spring.eduardodeveloper.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author edr
 */
@Component
public class ChargeInitial implements ApplicationListener<ContextRefreshedEvent>{
    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Autowired
    PerfilRepository perfilRepository;
    
       
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        List<Perfil> perfis = perfilRepository.findAll();
        
        if(perfis.isEmpty()){
            perfilRepository.save(new Perfil("ROLE_ADMIN"));
            Perfil perfil = perfilRepository.findByNome("ROLE_ADMIN");
            List<Perfil> perfisUsuario = new ArrayList<>();
            perfisUsuario.add(perfil);
            usuarioRepository.save(new Usuario("Eduardo", perfisUsuario,"admin", "123"));
        }
    }
    
}
