package br.com.ada.sinqia.ProjetoWesleyFaveron.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JogoDTO {

    @NotBlank(message = "Nome é um campo obrigatorio")
    private String nome;

    @NotBlank(message = "Id do usuário é um campo obrigatorio")
    private Long usuarioId;
}
