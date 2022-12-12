package MinhasExcecoes;

public class UsuarioExistenteException extends RuntimeException
{
    public String getMessage()
    {
        return "\n\tUsuário já existente!";
    }
}