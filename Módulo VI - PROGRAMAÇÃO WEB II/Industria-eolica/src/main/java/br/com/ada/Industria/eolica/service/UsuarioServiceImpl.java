package br.com.ada.Industria.eolica.service;

import br.com.ada.Industria.eolica.domain.Usuario;
import br.com.ada.Industria.eolica.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository repository;

    @Override
    public Usuario save(Usuario usuario) {
        return null;
    }
}