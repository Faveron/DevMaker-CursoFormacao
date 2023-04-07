package br.com.ada.sinqia.ProjetoWesleyFaveron.service;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> list();
    Usuario save(Usuario usuario);
    Usuario findById(Long id);
    Usuario update(Long id, Usuario usuario);
    void delete(Long id);
}
