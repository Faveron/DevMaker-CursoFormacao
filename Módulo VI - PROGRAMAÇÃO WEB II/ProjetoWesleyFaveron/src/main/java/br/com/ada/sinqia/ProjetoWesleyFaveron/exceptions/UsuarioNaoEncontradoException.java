package br.com.ada.sinqia.ProjetoWesleyFaveron.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException() {
        super("Usuario não encontrado");
    }
}