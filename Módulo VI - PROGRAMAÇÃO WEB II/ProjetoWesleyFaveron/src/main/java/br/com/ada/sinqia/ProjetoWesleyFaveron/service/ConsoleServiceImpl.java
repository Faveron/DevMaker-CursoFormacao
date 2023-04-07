package br.com.ada.sinqia.ProjetoWesleyFaveron.service;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Console;
import br.com.ada.sinqia.ProjetoWesleyFaveron.exceptions.ConsoleExistenteException;
import br.com.ada.sinqia.ProjetoWesleyFaveron.exceptions.ConsoleNaoEncontradoException;
import br.com.ada.sinqia.ProjetoWesleyFaveron.repository.ConsoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsoleServiceImpl implements ConsoleService {

    private final ConsoleRepository repository;

    @Override
    public List<Console> list() {
        return (List<Console>) repository.findAll();
    }

    @Override
    public Console save(Console console) {
        if (repository.existsByNome(console.getNome())) {
            throw new ConsoleExistenteException();
        }
        return repository.save(console);
    }

    @Override
    public Console findById(Long id) {
        return repository.findById(id).orElseThrow(ConsoleNaoEncontradoException::new);
    }

    @Override
    public Console update(Long id, Console console) {
        if (repository.existsById(id)) {
            console.setId(id);
            return repository.save(console);
        }
        throw new ConsoleNaoEncontradoException();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ConsoleNaoEncontradoException();
        }
        repository.deleteById(id);
    }
}
