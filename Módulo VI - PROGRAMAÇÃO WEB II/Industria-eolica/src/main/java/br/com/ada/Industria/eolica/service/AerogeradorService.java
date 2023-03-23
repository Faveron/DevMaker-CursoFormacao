package br.com.ada.Industria.eolica.service;

import br.com.ada.Industria.eolica.domain.Aerogerador;

import java.util.List;

public interface AerogeradorService {
    List<Aerogerador> list();

    Aerogerador save(Aerogerador aerogerador);

    Aerogerador findById(Long id);

    Aerogerador update(Long id, Aerogerador aerogerador);

    void delete(Long id);
}