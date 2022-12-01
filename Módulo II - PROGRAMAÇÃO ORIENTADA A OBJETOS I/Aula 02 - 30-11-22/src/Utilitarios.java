import java.util.UUID;

public class Utilitarios {
    public static void main(String[] args) {
        /*
            Funcionalidades interessantes utilizadas ao longo da aula
         */
        for (int i = 0; i < 10; i++)
        {
            System.out.println(UUID.randomUUID());
            System.out.println(System.currentTimeMillis());
        }
    }
}