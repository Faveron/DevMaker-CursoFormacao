package br.com.ada.Industria.eolica.controller;

import br.com.ada.Industria.eolica.domain.Aerogerador;
import br.com.ada.Industria.eolica.dto.AerogeradorSaveDTO;
import br.com.ada.Industria.eolica.service.AerogeradorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("aerogeradores")
@RestController
public class AerogeradorController {
    private final AerogeradorService aerogeradorService;

    @GetMapping
    public List<Aerogerador> list() {
        return aerogeradorService.list();
    }

    @GetMapping("{id}")
    public Aerogerador getById(@PathVariable Long id) {
        return aerogeradorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aerogerador save(@Valid @RequestBody AerogeradorSaveDTO dto) {
        Aerogerador aerogerador = Aerogerador.builder()
                .modelo(dto.getModelo())
                .numeroSerie(dto.getNumeroSerie())
                .status(dto.getStatus())
                .build();
        return aerogeradorService.save(aerogerador);
    }

    @PutMapping("{id}")
    public Aerogerador update(@PathVariable Long id, @RequestBody AerogeradorSaveDTO dto) {
        Aerogerador aerogerador = Aerogerador.builder()
                .modelo(dto.getModelo())
                .numeroSerie(dto.getNumeroSerie())
                .status(dto.getStatus())
                .build();
        return aerogeradorService.update(id, aerogerador);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        aerogeradorService.delete(id);
    }
}