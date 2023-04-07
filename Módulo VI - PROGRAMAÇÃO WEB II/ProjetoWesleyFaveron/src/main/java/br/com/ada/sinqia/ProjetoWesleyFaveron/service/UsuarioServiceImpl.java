package br.com.ada.sinqia.ProjetoWesleyFaveron.service;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Endereco;
import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Usuario;
import br.com.ada.sinqia.ProjetoWesleyFaveron.dto.EnderecoDTO;
import br.com.ada.sinqia.ProjetoWesleyFaveron.exceptions.UsuarioNaoEncontradoException;
import br.com.ada.sinqia.ProjetoWesleyFaveron.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final RestTemplate restTemplate;

    @Override
    public List<Usuario> list() {
        return (List<Usuario>) repository.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        String url = "https://cdn.apicep.com/file/apicep/" + usuario.getEndereco().getCep() + ".json";
        EnderecoDTO response = restTemplate.getForObject(url, EnderecoDTO.class);
        Endereco endereco = new Endereco();
        endereco.setCep(response.getCep());
        endereco.setLogradouro(response.getAddress() + " " + response.getDistrict() + " " + response.getCity());
        usuario.setEndereco(endereco);
        return repository.save(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return repository.findById(id).orElseThrow(UsuarioNaoEncontradoException::new);
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        if (repository.existsById(id)) {
            usuario.setId(id);
            return repository.save(usuario);
        }
        throw new UsuarioNaoEncontradoException();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new UsuarioNaoEncontradoException();
        }
        repository.deleteById(id);
    }
}
