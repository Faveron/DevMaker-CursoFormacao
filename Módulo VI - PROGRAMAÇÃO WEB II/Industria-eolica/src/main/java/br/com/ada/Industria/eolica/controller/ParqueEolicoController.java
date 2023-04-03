package br.com.ada.Industria.eolica.controller;

import br.com.ada.Industria.eolica.domain.Endereco;
import br.com.ada.Industria.eolica.domain.ParqueEolico;
import br.com.ada.Industria.eolica.dto.ParqueEolicoListDTO;
import br.com.ada.Industria.eolica.dto.ParqueEolicoSaveDTO;
import br.com.ada.Industria.eolica.mapper.ParqueEolicoMapper;
import br.com.ada.Industria.eolica.service.ParqueEolicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("parque-eolico")
@RequiredArgsConstructor
public class ParqueEolicoController {

    private final ParqueEolicoService service;
    private final ParqueEolicoMapper mapper;

    @GetMapping("{id}")
    public ParqueEolico findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<ParqueEolicoListDTO> list() {
        return service.list().stream().map(mapper::parqueEolicoToParqueEolicoListDTO).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParqueEolico save(@RequestBody @Valid ParqueEolicoSaveDTO dto) {
        ParqueEolico parqueEolico = mapper.parqueEolicoSaveDTOToParqueEolico(dto);
        var endereco = new Endereco();
        endereco.setCep(dto.getCep());
        parqueEolico.setEndereco(endereco);
        return service.save(parqueEolico);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
