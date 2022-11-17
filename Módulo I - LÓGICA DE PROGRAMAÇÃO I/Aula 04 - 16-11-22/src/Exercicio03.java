/*
    Faça um programa que imprima uma matriz quadrada de dimensão N contedo:
        o número 1 nos elementos abaixo da diagonal principal
        o número 0 nos demais elementos

    N deve ser menor ou igual a 20
 */

import java.util.Scanner;

public class Exercicio03
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o tamanho da matriz quadrada (menor ou igual a 20): ");
        int N = entrada.nextInt();

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if(i > j)
                {
                    System.out.print("1 ");
                }
                else
                {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
