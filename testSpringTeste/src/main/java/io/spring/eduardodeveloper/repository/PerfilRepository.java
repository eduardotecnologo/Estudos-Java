package io.spring.eduardodeveloper.repository;

import io.spring.eduardodeveloper.entity.Perfil;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Eduardo Alexandre <eduardotecnologo@hotmail.com>
 */
public interface PerfilRepository extends MongoRepository<Perfil, String> {

}
