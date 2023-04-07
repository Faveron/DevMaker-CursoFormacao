package br.com.ada.sinqia.ProjetoWesleyFaveron.exceptions;

public class JogoExistenteException extends RuntimeException {
    public JogoExistenteException() {
        super("Jogo já existente");
    }
}