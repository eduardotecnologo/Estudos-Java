package io.spring.eduardodeveloper.repository;

import io.spring.eduardodeveloper.entity.Usuario;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Eduardo Alexandre <eduardotecnologo@hotmail.com>
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    List<Usuario> findByNomeLikeIgnoreCase(String nome);
}
