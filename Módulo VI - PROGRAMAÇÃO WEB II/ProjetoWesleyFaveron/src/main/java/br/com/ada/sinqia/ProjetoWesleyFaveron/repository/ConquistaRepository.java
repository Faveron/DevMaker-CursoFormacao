package br.com.ada.sinqia.ProjetoWesleyFaveron.repository;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Conquista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConquistaRepository extends CrudRepository<Conquista, Long> {
    boolean existsByNome(String nome);
}
