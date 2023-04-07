package br.com.ada.sinqia.ProjetoWesleyFaveron.exceptions;

public class JogoNaoEncontradoException extends RuntimeException {
    public JogoNaoEncontradoException() {
        super("Jogo não encontrado");
    }
}