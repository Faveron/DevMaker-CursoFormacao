/*
    Ler um número e verifica se este é ou não um número primo
 */

import java.util.Scanner;

public class Exercicio01
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int n = entrada.nextInt();
        int verifica = 0;

        for (int i = 2; i <= Math.sqrt(Math.abs(n)) && verifica == 0; i++)
        {
            if (n % i == 0)
            {
                verifica++;
            }
        }
        if (verifica == 0)
        {
            System.out.printf("O número %d é primo", n);
        }
        else
        {
            System.out.printf("O número %d NÃO é primo", n);
        }
    }
}