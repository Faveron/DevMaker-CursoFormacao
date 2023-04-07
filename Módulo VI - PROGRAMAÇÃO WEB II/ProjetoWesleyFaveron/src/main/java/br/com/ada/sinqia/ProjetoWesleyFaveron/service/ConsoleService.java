package br.com.ada.sinqia.ProjetoWesleyFaveron.service;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Console;

import java.util.List;

public interface ConsoleService {
    List<Console> list();
    Console save(Console console);
    Console findById(Long id);
    Console update(Long id, Console console);
    void delete(Long id);
}
