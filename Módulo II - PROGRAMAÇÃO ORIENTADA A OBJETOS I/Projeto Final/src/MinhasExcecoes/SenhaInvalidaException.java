package MinhasExcecoes;

public class SenhaInvalidaException extends RuntimeException
{
    public String getMessage()
    {
        return "\n\tSenha inválida!";
    }
}