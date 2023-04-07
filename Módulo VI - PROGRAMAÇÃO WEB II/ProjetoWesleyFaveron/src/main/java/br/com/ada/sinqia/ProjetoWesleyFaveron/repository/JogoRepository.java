package br.com.ada.sinqia.ProjetoWesleyFaveron.repository;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Jogo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends CrudRepository<Jogo, Long> {
    boolean existsByNome(String nome);
}
