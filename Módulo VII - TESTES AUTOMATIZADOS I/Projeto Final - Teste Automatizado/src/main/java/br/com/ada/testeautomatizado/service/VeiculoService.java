package br.com.ada.testeautomatizado.service;

import br.com.ada.testeautomatizado.dto.VeiculoDTO;
import br.com.ada.testeautomatizado.exception.PlacaInvalidaException;
import br.com.ada.testeautomatizado.exception.VeiculoNaoEncontradoException;
import br.com.ada.testeautomatizado.model.Veiculo;
import br.com.ada.testeautomatizado.repository.VeiculoRepository;
import br.com.ada.testeautomatizado.dto.ResponseDTO;
import br.com.ada.testeautomatizado.util.ValidacaoPlaca;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ValidacaoPlaca validacaoPlaca;

    public ResponseEntity<ResponseDTO<VeiculoDTO>> cadastrar(VeiculoDTO veiculoDTO) {
        try {
            validacaoPlaca.isPlacaValida(veiculoDTO.getPlaca());
            veiculoRepository.save(veiculoDTO.DTOToVeiculo(veiculoDTO));
            return ResponseEntity.ok(ResponseDTO.<VeiculoDTO>builder()
                    .message("Cadastro realizado com sucesso!")
                    .build() );
        } catch (PlacaInvalidaException exception) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(new ResponseDTO<>(exception.getMessage(), null));
        }
    }

    public ResponseEntity<ResponseDTO<Boolean>> deletarVeiculoPelaPlaca(String placa) {
        try {
            veiculoRepository.delete(buscarVeiculoPelaPlaca(placa)
                    .orElseThrow(VeiculoNaoEncontradoException::new));
            return ResponseEntity.ok(ResponseDTO.<Boolean>builder()
                    .message("Veiculo deletado com sucesso!")
                    .build() );
        } catch (VeiculoNaoEncontradoException exception) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new ResponseDTO<>(exception.getMessage(), null));
        }
    }

    public ResponseEntity<ResponseDTO<VeiculoDTO>> atualizar(VeiculoDTO veiculoDTO) {
        return null;
    }

    public ResponseEntity<ResponseDTO<List<Veiculo>>> listarTodos() {
        List<Veiculo> veiculos = veiculoRepository.findAll().stream().toList();
        return ResponseEntity.ok(new ResponseDTO<>("Lista resgatada com sucesso!", veiculos));
    }

    private Optional<Veiculo> buscarVeiculoPelaPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa);
    }
}

