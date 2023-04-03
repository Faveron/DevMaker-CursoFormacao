package br.com.ada.sinqia.ProjetoWesleyFaveron.service;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Conquista;
import br.com.ada.sinqia.ProjetoWesleyFaveron.exceptions.ConquistaExistenteException;
import br.com.ada.sinqia.ProjetoWesleyFaveron.exceptions.ConquistaNaoEncontradaException;
import br.com.ada.sinqia.ProjetoWesleyFaveron.repository.ConquistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConquistaServiceImpl implements ConquistaService {

    private final ConquistaRepository repository;

    @Override
    public Conquista save(Conquista conquista) {
        if (repository.existsByNome(conquista.getNome())) {
            throw new ConquistaExistenteException();
        }
        return repository.save(conquista);
    }

    @Override
    public Conquista findById(Long id) {
        return repository.findById(id).orElseThrow(ConquistaNaoEncontradaException::new);
    }

    @Override
    public Conquista update(Long id, Conquista conquista) {
        if (repository.existsById(id)) {
            conquista.setId(id);
            return repository.save(conquista);
        }
        throw new ConquistaNaoEncontradaException();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ConquistaNaoEncontradaException();
        }
        repository.deleteById(id);
    }
}
