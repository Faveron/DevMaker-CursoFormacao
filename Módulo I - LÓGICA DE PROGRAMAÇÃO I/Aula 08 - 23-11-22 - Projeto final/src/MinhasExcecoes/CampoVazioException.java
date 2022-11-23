package MinhasExcecoes;

public class CampoVazioException extends RuntimeException
{
    public String getMessage()
    {
        return "\n\tNenhum campo pode ser vazio!";
    }
}
