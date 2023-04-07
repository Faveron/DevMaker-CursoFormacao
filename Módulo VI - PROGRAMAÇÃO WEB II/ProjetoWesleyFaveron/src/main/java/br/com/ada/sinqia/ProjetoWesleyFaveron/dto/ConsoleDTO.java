package br.com.ada.sinqia.ProjetoWesleyFaveron.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ConsoleDTO {

    @NotBlank(message = "Nome é um campo obrigatorio")
    private String nome;

    @NotBlank(message = "Ano é um campo obrigatorio")
    private Integer ano;
}
