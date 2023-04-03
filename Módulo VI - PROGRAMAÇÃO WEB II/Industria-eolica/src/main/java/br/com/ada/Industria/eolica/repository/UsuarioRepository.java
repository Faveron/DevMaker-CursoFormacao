package br.com.ada.Industria.eolica.repository;

import br.com.ada.Industria.eolica.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
