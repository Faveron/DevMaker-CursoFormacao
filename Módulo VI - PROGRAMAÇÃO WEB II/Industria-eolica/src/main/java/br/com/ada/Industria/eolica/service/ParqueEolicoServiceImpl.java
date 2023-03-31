package br.com.ada.Industria.eolica.service;

import br.com.ada.Industria.eolica.domain.ParqueEolico;
import br.com.ada.Industria.eolica.exceptions.ParqueEolicoNotFoundException;
import br.com.ada.Industria.eolica.repository.ParqueEolicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParqueEolicoServiceImpl implements ParqueEolicoService {

    private final ParqueEolicoRepository repository;

    @Override
    public List<ParqueEolico> list() {
        return (List<ParqueEolico>) repository.findAll();
    }

    @Override
    public ParqueEolico save(ParqueEolico parqueEolico) {
        return repository.save(parqueEolico);
    }

    @Override
    public ParqueEolico findById(Long id) {
        return repository.findById(id).orElseThrow(ParqueEolicoNotFoundException::new);
    }

    @Override
    public ParqueEolico update(Long id, ParqueEolico parqueEolico) {
        if (repository.existsById(id)) {
            parqueEolico.setId(id);
            return repository.save(parqueEolico);
        }
        throw new ParqueEolicoNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ParqueEolicoNotFoundException();
        }
        repository.deleteById(id);
    }
}
