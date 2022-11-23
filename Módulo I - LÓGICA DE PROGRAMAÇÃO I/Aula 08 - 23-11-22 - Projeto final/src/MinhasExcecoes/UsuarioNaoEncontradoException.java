package MinhasExcecoes;

public class UsuarioNaoEncontradoException extends RuntimeException{
    public String getMessage()
    {
        return "\n\tUsuário inválido!";
    }
}
