package br.com.ada.sinqia.ProjetoWesleyFaveron.controller;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Jogo;
import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Usuario;
import br.com.ada.sinqia.ProjetoWesleyFaveron.dto.JogoDTO;
import br.com.ada.sinqia.ProjetoWesleyFaveron.mapper.JogoMapper;
import br.com.ada.sinqia.ProjetoWesleyFaveron.service.JogoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RequestMapping("jogos")
@RestController
public class JogoController {

    private final JogoService jogoService;
    private final JogoMapper mapper;

    @GetMapping
    public List<Jogo> list() {
        return jogoService.list();
    }

    @GetMapping("{id}")
    public Jogo getById(@PathVariable Long id) {
        return jogoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jogo save(@Valid @RequestBody JogoDTO dto){
        Jogo jogo = mapper.jogoDTOToJogo(dto);
        jogo.setUsuarios((Set<Usuario>) Usuario.builder().id(dto.getUsuarioId()).build());
        return jogoService.save(jogo);
    }
    @PutMapping("{id}")
    public Jogo update(@PathVariable Long id, @Valid @RequestBody JogoDTO dto){
        Jogo jogo = mapper.jogoDTOToJogo(dto);
        jogo.setUsuarios((Set<Usuario>) Usuario.builder().id(dto.getUsuarioId()).build());
        return jogoService.update(id, jogo);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        jogoService.delete(id);
    }
}
