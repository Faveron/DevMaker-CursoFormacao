package br.com.ada.sinqia.ProjetoWesleyFaveron.exceptions;

public class ConquistaExistenteException extends RuntimeException {
    public ConquistaExistenteException() {
        super("Conquista já existente");
    }
}
