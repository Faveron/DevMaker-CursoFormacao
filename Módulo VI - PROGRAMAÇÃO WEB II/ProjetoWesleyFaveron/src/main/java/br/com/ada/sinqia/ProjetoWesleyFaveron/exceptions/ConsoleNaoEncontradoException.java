package br.com.ada.sinqia.ProjetoWesleyFaveron.exceptions;

public class ConsoleNaoEncontradoException extends RuntimeException {
    public ConsoleNaoEncontradoException() {
        super("Console não encontrado");
    }
}