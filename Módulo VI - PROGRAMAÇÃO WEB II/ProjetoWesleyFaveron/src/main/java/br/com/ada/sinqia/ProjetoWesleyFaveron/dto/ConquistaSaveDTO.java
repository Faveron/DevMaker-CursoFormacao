package br.com.ada.sinqia.ProjetoWesleyFaveron.dto;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.ConquistaGrau;
import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.ConquistaRaridade;
import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.ConquistaStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ConquistaSaveDTO {
    @NotBlank(message = "Nome é um campo obrigatorio")
    private String nome;

    @NotBlank(message = "Descrição é um campo obrigatorio")
    private String descricao;

    @NotBlank(message = "Status é um campo obrigatorio")
    @NotNull
    private ConquistaStatus status;

    @NotBlank(message = "Grau é um campo obrigatorio")
    @NotNull
    private ConquistaGrau grau;

    @NotBlank(message = "Raridade é um campo obrigatorio")
    @NotNull
    private ConquistaRaridade raridade;
}
