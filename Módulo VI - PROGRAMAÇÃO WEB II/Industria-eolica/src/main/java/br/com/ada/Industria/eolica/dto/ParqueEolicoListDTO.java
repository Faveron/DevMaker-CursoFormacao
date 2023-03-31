package br.com.ada.Industria.eolica.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParqueEolicoListDTO {
    private Long id;
    private String nome;
    private String cnpj;
    private Double potencia;
}
