package br.com.ada.sinqia.ProjetoWesleyFaveron.dto;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.ConquistaGrau;
import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.ConquistaRaridade;
import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.ConquistaStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ConquistaDTO {

    @NotBlank(message = "Nome é um campo obrigatorio")
    private String nome;

    @NotBlank(message = "Descrição é um campo obrigatorio")
    private String descricao;

    @NotBlank(message = "Status é um campo obrigatorio")
    private ConquistaStatus status;

    @NotBlank(message = "Grau é um campo obrigatorio")
    private ConquistaGrau grau;

    @NotBlank(message = "Raridade é um campo obrigatorio")
    private ConquistaRaridade raridade;

    @NotBlank(message = "ID do jogo é um campo obrigatorio")
    private Long jogoId;
}
