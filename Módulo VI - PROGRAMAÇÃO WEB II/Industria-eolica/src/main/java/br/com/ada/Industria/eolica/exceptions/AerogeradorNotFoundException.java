package br.com.ada.Industria.eolica.exceptions;

public class AerogeradorNotFoundException extends RuntimeException {
    public AerogeradorNotFoundException() {
        super("Aerogerador não encontrado");
    }
}
