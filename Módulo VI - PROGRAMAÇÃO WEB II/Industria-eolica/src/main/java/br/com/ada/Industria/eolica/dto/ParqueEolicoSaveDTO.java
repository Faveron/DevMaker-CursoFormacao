package br.com.ada.Industria.eolica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
public class ParqueEolicoSaveDTO {
    @NotBlank
    private String nome;
    @CNPJ
    @NotBlank
    private String cnpj;
    @NotBlank
    @PositiveOrZero
    private Double potencia;
}
