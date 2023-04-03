package br.com.ada.sinqia.ProjetoWesleyFaveron.exceptions;

public class ConquistaNaoEncontradaException extends RuntimeException {
    public ConquistaNaoEncontradaException() {
        super("Conquista não encontrado");
    }
}
