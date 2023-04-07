package br.com.ada.sinqia.ProjetoWesleyFaveron.exceptions;

public class UsuarioExistenteException extends RuntimeException {
    public UsuarioExistenteException() {
        super("Usuario já existente");
    }
}
