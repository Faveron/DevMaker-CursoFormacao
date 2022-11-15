/*
    Desenvolver um programa que deverá desenhar um triângulo conforme a figura abaixo.
    O programa deverá receber quantidade de linhas a serem impressas.
    Exemplo, se for informado 10 linhas, o resultado deverá ser:
    **********
    *********
    ********
    *******
    ******
    *****
    ****
    ***
    **
    *
 */

import java.util.Scanner;

public class Tarefa01
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int n = entrada.nextInt();

        for (int i = n; i > 0; i--)
        {
            for (int j = i; j > 0; j--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
