package br.com.ada.Industria.eolica.exceptions;

public class ParqueEolicoNotFoundException extends RuntimeException {

    public ParqueEolicoNotFoundException() {
        super("Parque Eolico não encontrado");
    }
}