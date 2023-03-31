package br.com.ada.Industria.eolica.repository;

import br.com.ada.Industria.eolica.domain.ParqueEolico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParqueEolicoRepository extends CrudRepository<ParqueEolico, Long> {
}
