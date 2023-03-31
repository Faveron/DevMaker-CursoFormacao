package br.com.ada.Industria.eolica.controller;

import br.com.ada.Industria.eolica.domain.ParqueEolico;
import br.com.ada.Industria.eolica.dto.ParqueEolicoSaveDTO;
import br.com.ada.Industria.eolica.service.ParqueEolicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("parqueseolico")
@RestController
public class ParqueEolicoController {
    private final ParqueEolicoService parqueEolicoService;

    @GetMapping
    public List<ParqueEolico> list() {
        return parqueEolicoService.list();
    }

    @GetMapping("{id}")
    public ParqueEolico getById(@PathVariable Long id) {
        return parqueEolicoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParqueEolico save(@Valid @RequestBody ParqueEolicoSaveDTO dto) {
        ParqueEolico parqueEolico = ParqueEolico.builder()
                .nome(dto.getNome())
                .cnpj(dto.getCnpj())
                .potencia(dto.getPotencia())
                .build();
        return parqueEolicoService.save(parqueEolico);
    }

    @PutMapping("{id}")
    public ParqueEolico update(@PathVariable Long id, @RequestBody ParqueEolicoSaveDTO dto) {
        ParqueEolico parqueEolico = ParqueEolico.builder()
                .nome(dto.getNome())
                .cnpj(dto.getCnpj())
                .potencia(dto.getPotencia())
                .build();
        return parqueEolicoService.update(id, parqueEolico);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        parqueEolicoService.delete(id);
    }
}
