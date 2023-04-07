package br.com.ada.sinqia.ProjetoWesleyFaveron.controller;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Conquista;
import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Jogo;
import br.com.ada.sinqia.ProjetoWesleyFaveron.dto.ConquistaDTO;
import br.com.ada.sinqia.ProjetoWesleyFaveron.mapper.ConquistaMapper;
import br.com.ada.sinqia.ProjetoWesleyFaveron.service.ConquistaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("conquistas")
@RestController
public class ConquistaController {

    private final ConquistaService conquistaService;
    private final ConquistaMapper mapper;

    @GetMapping("{id}")
    public Conquista getById(@PathVariable Long id) {
        return conquistaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conquista save(@Valid @RequestBody ConquistaDTO dto) {
        Conquista conquista = mapper.conquistaDTOToConquista(dto);
        conquista.setJogo(Jogo.builder().id(dto.getJogoId()).build());
        return conquistaService.save(conquista);
    }

    @PutMapping("{id}")
    public Conquista update(@PathVariable Long id, @RequestBody ConquistaDTO dto) {
        Conquista conquista = mapper.conquistaDTOToConquista(dto);
        conquista.setJogo(Jogo.builder().id(dto.getJogoId()).build());
        return conquistaService.update(id, conquista);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        conquistaService.delete(id);
    }
}
