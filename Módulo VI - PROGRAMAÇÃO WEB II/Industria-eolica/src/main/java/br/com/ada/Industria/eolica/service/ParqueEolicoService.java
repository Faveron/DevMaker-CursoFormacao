package br.com.ada.Industria.eolica.service;

import br.com.ada.Industria.eolica.domain.ParqueEolico;

import java.util.List;

public interface ParqueEolicoService {
    ParqueEolico findById(Long id);

    List<ParqueEolico> list();

    ParqueEolico save(ParqueEolico parqueEolico);

    void delete(Long id);
}
