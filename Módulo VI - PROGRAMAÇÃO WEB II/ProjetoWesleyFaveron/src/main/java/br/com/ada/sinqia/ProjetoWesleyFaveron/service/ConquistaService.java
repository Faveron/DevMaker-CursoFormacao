package br.com.ada.sinqia.ProjetoWesleyFaveron.service;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Conquista;

import java.util.List;

public interface ConquistaService {
    Conquista save(Conquista conquista);
    Conquista findById(Long id);
    Conquista update(Long id, Conquista conquista);
    void delete(Long id);
}
