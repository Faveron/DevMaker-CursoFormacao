package br.com.ada.Industria.eolica.service;

import br.com.ada.Industria.eolica.domain.ParqueEolico;

import java.util.List;

public interface ParqueEolicoService {
    List<ParqueEolico> list();

    ParqueEolico save(ParqueEolico parqueEolico);

    ParqueEolico findById(Long id);

    ParqueEolico update(Long id, ParqueEolico parqueEolico);

    void delete(Long id);
}
