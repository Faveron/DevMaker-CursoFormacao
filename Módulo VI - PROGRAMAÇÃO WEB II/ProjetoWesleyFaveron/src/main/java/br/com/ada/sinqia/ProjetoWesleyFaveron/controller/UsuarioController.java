package br.com.ada.sinqia.ProjetoWesleyFaveron.controller;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Console;
import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Endereco;
import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Usuario;
import br.com.ada.sinqia.ProjetoWesleyFaveron.dto.UsuarioDTO;
import br.com.ada.sinqia.ProjetoWesleyFaveron.mapper.UsuarioMapper;
import br.com.ada.sinqia.ProjetoWesleyFaveron.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("usuarios")
@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper mapper;

    @GetMapping
    public List<Usuario> list() {
        return usuarioService.list();
    }

    @GetMapping("{id}")
    public Usuario getById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@Valid @RequestBody UsuarioDTO dto) {
        Usuario usuario = mapper.usuarioDTOtoUsuario(dto);
        var endereco = new Endereco();
        endereco.setCep(dto.getCep());
        usuario.setEndereco(endereco);
        usuario.setConsole(Console.builder().id(dto.getConsoleId()).build());
        return usuarioService.save(usuario);
    }
    @PutMapping("{id}")
    public Usuario update(@PathVariable Long id,@Valid @RequestBody UsuarioDTO dto) {
        Usuario usuario = mapper.usuarioDTOtoUsuario(dto);
        var endereco = new Endereco();
        endereco.setCep(dto.getCep());
        usuario.setEndereco(endereco);
        usuario.setConsole(Console.builder().id(dto.getConsoleId()).build());
        return usuarioService.update(id, usuario);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }
}
