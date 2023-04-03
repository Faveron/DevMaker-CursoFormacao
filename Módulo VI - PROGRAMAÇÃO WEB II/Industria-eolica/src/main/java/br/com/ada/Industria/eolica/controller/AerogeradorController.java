package br.com.ada.Industria.eolica.controller;

import br.com.ada.Industria.eolica.domain.Aerogerador;
import br.com.ada.Industria.eolica.domain.ParqueEolico;
import br.com.ada.Industria.eolica.dto.AerogeradorSaveDTO;
import br.com.ada.Industria.eolica.mapper.AerogeradorMapper;
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
    private final AerogeradorMapper mapper;

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
        Aerogerador aerogerador = mapper.aerogeradorSaveDTOToAerogerador(dto);
        aerogerador.setParqueEolico(ParqueEolico.builder().id(dto.getParqueEolicoId()).build());
        return aerogeradorService.save(aerogerador);
    }

    @PutMapping("{id}")
    public Aerogerador update(@PathVariable Long id, @RequestBody AerogeradorSaveDTO dto) {
        Aerogerador aerogerador = mapper.aerogeradorSaveDTOToAerogerador(dto);
        aerogerador.setParqueEolico(ParqueEolico.builder().id(dto.getParqueEolicoId()).build());
        return aerogeradorService.update(id, aerogerador);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        aerogeradorService.delete(id);
    }
}