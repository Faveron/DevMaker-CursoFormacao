package br.com.ada.sinqia.ProjetoWesleyFaveron.service;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Jogo;
import br.com.ada.sinqia.ProjetoWesleyFaveron.exceptions.JogoExistenteException;
import br.com.ada.sinqia.ProjetoWesleyFaveron.exceptions.JogoNaoEncontradoException;
import br.com.ada.sinqia.ProjetoWesleyFaveron.repository.JogoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JogoServiceImpl implements JogoService {

    private final JogoRepository repository;

    @Override
    public List<Jogo> list() {
        return (List<Jogo>) repository.findAll();
    }

    @Override
    public Jogo save(Jogo jogo) {
        if (repository.existsByNome(jogo.getNome())) {
            throw new JogoExistenteException();
        }
        return repository.save(jogo);
    }

    @Override
    public Jogo findById(Long id) {
        return repository.findById(id).orElseThrow(JogoNaoEncontradoException::new);
    }

    @Override
    public Jogo update(Long id, Jogo jogo) {
        if (repository.existsById(id)) {
            jogo.setId(id);
            return repository.save(jogo);
        }
        throw new JogoNaoEncontradoException();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new JogoNaoEncontradoException();
        }
        repository.deleteById(id);
    }
}
