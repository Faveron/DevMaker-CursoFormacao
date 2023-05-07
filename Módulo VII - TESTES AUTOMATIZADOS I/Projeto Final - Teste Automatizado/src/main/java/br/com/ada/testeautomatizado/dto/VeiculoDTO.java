package br.com.ada.testeautomatizado.dto;

import br.com.ada.testeautomatizado.model.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VeiculoDTO {

    private String placa;
    private String modelo;
    private String marca;
    private Boolean disponivel;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFabricacao;

    public static Veiculo DTOToVeiculo(VeiculoDTO veiculoDTO) {
        return Veiculo.builder()
                .placa(veiculoDTO.getPlaca())
                .marca(veiculoDTO.getMarca())
                .modelo(veiculoDTO.getModelo())
                .dataFabricacao(veiculoDTO.getDataFabricacao())
                .disponivel(veiculoDTO.getDisponivel())
                .build();
    }

}
