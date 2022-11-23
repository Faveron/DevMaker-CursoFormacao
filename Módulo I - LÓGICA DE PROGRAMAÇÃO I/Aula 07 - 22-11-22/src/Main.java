/*
    Exemplo de como usar try catch finally
 */
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int[] vetor = new int[10];
        String s = null;

        Scanner entrada = new Scanner(System.in);
        try{
            vetor[11] = 5;
            s.toUpperCase();
        }catch (NullPointerException e){
            System.out.println("Erro acesso objeto nulo");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro acesso index inválido");
        }catch (Exception e){
            System.out.println("Exceção genérica");
        }finally{
            entrada.close();
        }
    }
}