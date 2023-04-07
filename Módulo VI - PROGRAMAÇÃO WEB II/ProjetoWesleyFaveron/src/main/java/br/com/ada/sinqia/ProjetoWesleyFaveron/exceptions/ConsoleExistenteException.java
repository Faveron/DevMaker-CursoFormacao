package br.com.ada.sinqia.ProjetoWesleyFaveron.exceptions;

public class ConsoleExistenteException extends RuntimeException {
    public ConsoleExistenteException() {
        super("Console já existente");
    }
}
