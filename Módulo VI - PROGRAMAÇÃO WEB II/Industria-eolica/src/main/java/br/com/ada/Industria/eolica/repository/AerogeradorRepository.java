package br.com.ada.Industria.eolica.repository;

import br.com.ada.Industria.eolica.domain.Aerogerador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AerogeradorRepository extends CrudRepository<Aerogerador, Long> {

    boolean existsByNumeroSerie(String numeroSerie);
}
