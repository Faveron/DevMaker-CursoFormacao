package br.com.ada.sinqia.ProjetoWesleyFaveron.repository;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Console;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends CrudRepository<Console, Long> {
    boolean existsByNome(String nome);
}
