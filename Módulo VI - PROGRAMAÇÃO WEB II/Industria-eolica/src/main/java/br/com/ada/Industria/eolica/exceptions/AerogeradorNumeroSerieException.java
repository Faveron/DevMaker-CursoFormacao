package br.com.ada.Industria.eolica.exceptions;

public class AerogeradorNumeroSerieException extends RuntimeException{

    public AerogeradorNumeroSerieException() {
        super("Aerogerador já existe");
    }
}
