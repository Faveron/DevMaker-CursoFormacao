package br.com.ada.sinqia.ProjetoWesleyFaveron.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@Setter
@Getter
public class UsuarioDTO {

    @NotBlank(message = "Nome é um campo obrigatorio")
    private String nome;

    @NotBlank(message = "CPF é um campo obrigatorio")
    @CPF
    private String cpf;

    @NotBlank(message = "Data de nascimento é um campo obrigatorio")
    private LocalDateTime dataNascimento;

    @NotBlank(message = "CEP é um campo obrigatorio")
    @Pattern(regexp = "[\\d]{5}-[\\d]{3}", message = "CEP invalido")
    private String cep;

    @NotBlank(message = "ID do console é um campo obrigatorio")
    private Long consoleId;
}
