package br.com.ada.Industria.eolica.config;

import br.com.ada.Industria.eolica.domain.ParqueEolico;
import br.com.ada.Industria.eolica.domain.Usuario;
import br.com.ada.Industria.eolica.repository.ParqueEolicoRepository;
import br.com.ada.Industria.eolica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.transaction.annotation.Transactional;

//@Component
@Transactional
public class InitProject implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ParqueEolicoRepository parqueEolicoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Usuario usuario = usuarioRepository.findById(1L).get();
        ParqueEolico parqueEolico = parqueEolicoRepository.findById(52L).get();
        parqueEolico.getUsuarios().add(usuario);
        parqueEolicoRepository.save(parqueEolico);
    }
}
