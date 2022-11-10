/*
    Escrevar um programa que faça o calculo de média simples de salário anual
    salario * 13/ 12 (divisão)
 */

import java.util.Scanner;

public class Exercicio03
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite seu salário atual: ");
        double salario = entrada.nextDouble();

        System.out.printf("A média anual do salário é R$ %.2f", salario*13.0/12.0);
    }
}
