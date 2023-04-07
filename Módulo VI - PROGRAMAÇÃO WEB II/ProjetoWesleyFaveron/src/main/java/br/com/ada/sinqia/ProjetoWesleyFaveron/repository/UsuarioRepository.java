package br.com.ada.sinqia.ProjetoWesleyFaveron.repository;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    boolean existsByNome(String nome);
}
