package br.com.ada.Industria.eolica.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ErrorDTO {
    private String message;
}