/*
    Verifica se um número é par ou ímpar
 */

import java.util.Scanner;

public class Exercicio07
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int n = entrada.nextInt();

        System.out.print("O número é: " + (n % 2 == 0 ? "Par" : "Ímpar"));
    }
}
