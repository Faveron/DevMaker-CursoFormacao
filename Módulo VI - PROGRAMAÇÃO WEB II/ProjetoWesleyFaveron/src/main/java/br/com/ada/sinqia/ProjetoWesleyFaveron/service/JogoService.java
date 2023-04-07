package br.com.ada.sinqia.ProjetoWesleyFaveron.service;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Jogo;

import java.util.List;

public interface JogoService {
    List<Jogo> list();
    Jogo save(Jogo jogo);
    Jogo findById(Long id);
    Jogo update(Long id, Jogo jogo);
    void delete(Long id);
}
