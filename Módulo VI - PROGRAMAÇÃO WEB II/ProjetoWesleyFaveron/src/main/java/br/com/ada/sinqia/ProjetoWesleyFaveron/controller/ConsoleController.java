package br.com.ada.sinqia.ProjetoWesleyFaveron.controller;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Console;
import br.com.ada.sinqia.ProjetoWesleyFaveron.dto.ConsoleDTO;
import br.com.ada.sinqia.ProjetoWesleyFaveron.mapper.ConsoleMapper;
import br.com.ada.sinqia.ProjetoWesleyFaveron.service.ConsoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("consoles")
@RestController
public class ConsoleController {

    private final ConsoleService consoleService;
    private final ConsoleMapper mapper;
    @GetMapping
    public List<Console> list() {
        return consoleService.list();
    }

    @GetMapping("{id}")
    public Console getById(@PathVariable Long id) {
        return consoleService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Console save(@Valid @RequestBody ConsoleDTO dto) {
        Console console = mapper.consoleDTOToConsole(dto);
        return consoleService.save(console);
    }

    @PutMapping("{id}")
    public Console update(@PathVariable Long id, @RequestBody ConsoleDTO dto) {
        Console console = mapper.consoleDTOToConsole(dto);
        return consoleService.update(id, console);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        consoleService.delete(id);
    }
}
